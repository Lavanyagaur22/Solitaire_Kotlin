import org.junit.Test

import org.junit.Assert.*

class TableauPileTest {
    @Test
    fun addCards() {

        //arrange

        val tableauPile = TableauPile(mutableListOf(Card(12, spades)))

        //for the cards we are going to add to the tableaupile
        val cards = mutableListOf(Card(11, hearts))


        //act
        tableauPile.addCards(cards)

        //assert
        //->make sure that's true

        //2 for the expected value
        assertEquals(2, tableauPile.cards.size)


    }

    @Test
    fun removeCards() {

        //arrange
        val tableauPile = TableauPile(mutableListOf(Card(4, clubs), Card(3, diamonds), Card(2, spades)))


        //act

        tableauPile.removeCards(1)

        //assert

        //we have passed true bcz if this is the only card left , it should be faceUp
        //we want to check whether the 2 cards look the same ,which we can do by properties match between the 2 class
        //they should have the same value,suit and faceUp->make Card class as data

        assertEquals(mutableListOf(Card(4, clubs, true)),tableauPile.cards)
    }
}