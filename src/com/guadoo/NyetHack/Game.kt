package com.guadoo.NyetHack

fun main() {

    val player = Player("Madrigal", 80,true, false)

    player.castFireball()

    // Aura
    val auraColor = player.auraColor()
    player.auraColor()

    // com.guadoo.NyetHack.Player status
    printPlayerStatus(player)


}

private fun printPlayerStatus(player: Player) {
    println(
        "(Aura: ${player.auraColor()}" +
                " Blessed: ${if (player.isBlessed) "YES" else "NO"})"
    )
    println("${player.name} ${player.formatHealthStatus()}")
}


