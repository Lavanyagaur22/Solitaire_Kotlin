
import java.util.*

class Deck {

    //Array<Card> not required to specify the return type as kotlin does this on its own

    //    anonymous function to be passed as parameter to Array(); just remove the function name

    //    val cards = Array(52, fun(i: Int): Card {
    //        return Card(i % 13, getSuit(i))
    //    })

    //    OR using lambda expression

    //    val cards = Array(52, { i -> Card(i % 13, getSuit(i) })

    //  when ony 1 parameter, Kotlin creates it for us by the name of "it"


    val cards = Array(52, { Card(it % 13, getsuit(it)) })


//    If we want to be able to add or remove items from a List then we need not to make sure it's a 'var',
//    instead use mutable version for adding/deleting form collection

    var cardsInDeck: MutableList<Card> = cards.toMutableList()

    fun drawCard(): Card = cardsInDeck.removeAt(0)

    fun reset() {
        cardsInDeck = cards.toMutableList()
        Collections.shuffle(cardsInDeck)
    }

    private fun getsuit(i: Int) = when (i / 13) {
        0 -> clubs
        1 -> diamonds
        2 -> hearts
        else -> spades


    }
}