//not in companion object so that w can access them without class. operator
//whenever fun and properties outside class it gets scoped for the entire package
//we could have also declare themc in the app class instead , nothing special about card class
val clubs = "Clubs"
val diamonds = "Diamonds"
val hearts = "Hearts"
val spades = "Spades"

val redSuits = arrayOf(diamonds, hearts)
val blackSuits = arrayOf(clubs, spades)
val cardsMap = mapOf(0 to "A", 1 to "2", 2 to "3", 3 to "4", 4 to "5", 5 to "6", 6 to "7", 7 to "8", 8 to "9", 9 to "10", 10 to "J", 11 to "Q", 12 to "K")


//data class -> holding data
data class Card(val value: Int, val suit: String, var faceUp: Boolean = false) {
    override fun toString(): String =

        if(faceUp) "${cardsMap[value]}".padEnd(2)+"${getSuitChar(suit)}" else "xxx"


    private fun getSuitChar(suit: String): String=when(suit){
        diamonds -> "\u2666"
        clubs -> "\u2663"
        hearts -> "\u2665"
        spades -> "\u2660"

        else -> "incorrect suit"

    }


//companion obj is the place where we would have put a anything which is static in java
    //1 class has 1 companion obj
    //use them to replace the string literals in gameModel and Deck


//    companion object {
//        //properties of companion obj
//
//        val clubs = "Clubs"
//        val diamonds = "Diamonds"
//        val hearts = "Hearts"
//        val spades = "Spades"
//    }
}


//class Card(value: Int, suit: String, faceUp: Boolean) {

//    //in kotlin properties don't have default values, and if they dont :->err
//    val value: Int = value
//    //    val value:Int
//    //    get() {
//    //        return 0
//    //    }
//    val suit: String = suit
//
//    var faceUp: Boolean = faceUp//each card should start face down

// }



