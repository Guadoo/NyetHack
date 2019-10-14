import java.lang.Exception

fun main() {
    var swordsJuggling: Int? = null
    val isJugglingProficient = (1..3).shuffled().last() == 3
    if (isJugglingProficient){
        swordsJuggling = 2
    }

    try {

        proficiencyCheck(swordsJuggling)
        swordsJuggling = swordsJuggling!!.plus(1)
        juggleSwords(swordsJuggling)

    } catch (e: Exception){
        println(e)
    }

    println("You juggle $swordsJuggling swords!")

}


fun proficiencyCheck(swordsJuggling: Int?){
    //swordsJuggling ?: throw UnskilledSwordJugglerException()
    checkNotNull(swordsJuggling,{"Player cannot juggle swords"})
}

fun juggleSwords(swordsJuggling: Int){
    require(swordsJuggling >=5, {"Juggle at least 5 swords to be exciting."})
}

class UnskilledSwordJugglerException():
        IllegalStateException("Player cannot juggle swords")