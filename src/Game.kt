fun main() {
    val name = "Madrigal"
    var healthPoints = 75
    val isBlessed = true
    val isImmortal = false

    val auraColor = auraColor(isBlessed, healthPoints, isImmortal)

    val healthStatus = formatHealthStatus(healthPoints, isBlessed)

    //Player Status
    printPlayerStatus(auraColor, isBlessed, name, healthStatus)

    castFireball(58)

}

private fun printPlayerStatus(
    auraColor: String,
    isBlessed: Boolean,
    name: String,
    healthStatus: String
) {
    println(
        "(Aura: $auraColor)" +
                "(Blessed: ${if (isBlessed) "YES" else "NO"})"
    )
    println("$name $healthStatus")
}

//private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean): String {
//    val auraVisible = isBlessed && healthPoints > 50 || isImmortal
//    return if (auraVisible) "GREEN" else "NONE"
//}

private fun auraColor(isBlessed: Boolean, healthPoints: Int, isImmortal: Boolean) =
    if (isBlessed && healthPoints > 50 || isImmortal) "GREEN" else "NONE"

private fun formatHealthStatus(healthPoints: Int, isBlessed: Boolean) =
    when (healthPoints) {
        100 -> "is in excellent condition!"
        in 90..99 -> "has a few scratches."
        in 75..89 -> if (isBlessed) {
            "has some minor wounds but is healing quite quickly!"
        } else {
            "has some minor wounds."
        }
        in 15..74 -> "looks pretty hurt."
        else -> "is in awful condition!"
    }

//    val healthStatus = if (healthPoints == 100){
//        "is in excellent condition!"
//    } else if (healthPoints in 90..99){
//        "has a few scratches."
//    } else if (healthPoints in 75..89){
//        if (isBlessed){
//            "has some minor wounds but is healing quite quickly!"
//        } else {
//            "has some minor wounds."
//        }
//    } else if (healthPoints in 15..74){
//        "looks pretty hurt."
//    } else {
//        "is in awful condition."
//    }

private fun castFireball(numFireballs: Int = 2) =
    when(numFireballs){
        in 1..10 -> println("tipsy")
        in 11..20 -> println("sloshed")
        in 21..30 -> println("soused")
        in 31..40 -> println("stewed")
        in 41..50 -> println("t0aSt3d")
        else -> println("Input 1 to 50")
    }



    //if (numFireballs > 0 && numFireballs <= 50)
    //    println("A glass of Fireball springs into existence. (x$numFireballs)")
    //else
    //    println("The number of fireball shall be between 1 and 50.")



