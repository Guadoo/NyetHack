package com.guadoo.NyetHack

import java.io.File

const val TAVERN_NAME = "Taernyl's Folly"

val patronList = mutableListOf("Eli","Mordoc","Sophie")
val lastName = listOf("Ironfoot","Fernsworth","Baggins")
val uniquePatrons = mutableSetOf<String>()
val menuList = File("data/tavern-menu-items.txt")
    .readText()
    .split("\n")
//val com.guadoo.NyetHack.getPatronGold = mapOf("Eli" to 10.5, "Mordoc" to 8.0, "Sophie" to 5.5)
val patronGold = mutableMapOf<String, Double>()

fun main() {
    if(patronList.contains("Eli")){
        println("The tavern master says: Eli's in the back playing cards.")
    } else {
        println("The tavern master says: Eli isn't here.")
    }

    if(patronList.containsAll(listOf("Sophie","Mordoc"))){
        println("The tavern master says: Yea, they're seated by the stew kettle.")
    } else {
        println("The tavern master says: Nay, they departed hours ago.")
    }

    (0..9).forEach{
        val first = patronList.shuffled().first()
        val last = lastName.shuffled().first()
        val name = "$first $last"
        uniquePatrons += name
    }

    uniquePatrons.forEach{
        patronGold[it] = 6.0
    }

    var orderCount = 0
    while (orderCount <= 9){
        placeOrder(
            uniquePatrons.shuffled().first(),
            menuList.shuffled().first()
        )
        orderCount++
    }

    displayPatronBalances()

}

private fun toDragonSpeak(phrase: String) =
    phrase.replace(Regex("[aeiouAEIOU]")){
        when(it.value){
            "a" -> "4"
            "A" -> "4"
            "e" -> "3"
            "E" -> "3"
            "i" -> "1"
            "I" -> "1"
            "o" -> "0"
            "O" -> "0"
            "u" -> "|_|"
            "U" -> "|_|"
            else -> it.value
        }
    }


private fun performancePurchase(price: Double, patronName: String){
    val totalPurse = patronGold.getValue(patronName)
    patronGold[patronName] = totalPurse - price
}

private fun placeOrder(patronName: String, menuData: String){
    val indexOfApostrophe = TAVERN_NAME.indexOf('\'')
    val tavernMaster = TAVERN_NAME.substring(0 until indexOfApostrophe)
    println("$patronName with $tavernMaster about their order.")

    val (type, name, price) = menuData.split(',')
    val message = "$patronName buys a $name($type) for $price."
    println(message)
    performancePurchase(price.toDouble(), patronName)

    val phrase = if (name == "Dragon's Breath"){
        "$patronName exclaims: ${toDragonSpeak("DRAGON'S BREATH: IT'S GOT WHAT ADVENTURERS CRAVE!")}"
    } else {
        "$patronName says: Thanks for the $name."
    }
    println(phrase)
}

private fun displayPatronBalances(){
    patronGold.forEach{ patron, balance ->
        println("$patron, balance: ${"%.2f".format(balance)}")
    }
}