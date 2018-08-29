

object GameModel {
    val deck = Deck();
    val wastePile: MutableList<Card> = mutableListOf()

    val foundationPiles = arrayOf(FoundationPile(clubs), FoundationPile(diamonds),
            FoundationPile(hearts), FoundationPile(spades))

    val tableauPiles = Array(7, { TableauPile() })

    fun resetGame() {
        wastePile.clear()

        //forEach is a fun that takes in action->also known as lamda expression-> anonymous fun with different syntax
        //
        foundationPiles.forEach { it.reset() }

//      alter - >this is the internal working of forEach()
//        for(pile in foundationPile){
//            pile.reset()
//        }

        deck.reset()

        //this requires both the index and the item so can't use it
        //forEachIndexed is an extension fun
        tableauPiles.forEachIndexed { i, tableauPile ->
            val cardsInPile: MutableList<Card> = Array(i + 1, { deck.drawCard() }).toMutableList()

            tableauPiles[i] = TableauPile(cardsInPile)
        }

    }


    fun onDeckTap() {
        if (deck.cardsInDeck.size > 0) {
            val card = deck.drawCard()
            card.faceUp = true
            wastePile.add(card)
        } else {
//            used tomutablelist() to return copy of list/object instead of actual wastepile
            deck.cardsInDeck = wastePile.toMutableList() //wastepile is already a mutablelist

            wastePile.clear() //empty wastepile
        }
    }

    fun onWasteTap() {
        if (wastePile.size > 0) {

            val card = wastePile.last()
            if (playCard(card)) {
                wastePile.remove(card)
            }


        }
    }

    fun onFoundationTap(foundationIndex: Int) {
        //specify which foundation we are talking about , which foundation pile was tapped

        val foundationPile = foundationPiles[foundationIndex]
        if (foundationPile.cards.size > 0) {

            val card = foundationPile.cards.last()
            if (playCard(card)) {
                foundationPile.removeCard(card)
            }


        }
    }


    fun onTableauTap(tableauIndex: Int, cardIndex: Int) {
        val tableauPile = tableauPiles[tableauIndex]
        if (tableauPile.cards.size > 0) {
            val cards = tableauPile.cards.subList(cardIndex, tableauPile.cards.lastIndex + 1)
            if (playCards(cards)) {
                tableauPile.removeCards(cardIndex)
            }
        }


    }

    private fun playCards(cards: MutableList<Card>): Boolean {

        if (cards.size == 1) {
            return playCard(cards.first())
        } else {

            tableauPiles.forEach {
                if (it.addCards(cards)) {
                    return true
                }
            }
        }
        return false
    }


    private fun playCard(card: Card): Boolean {

        //lets try to play on foundation piles
        foundationPiles.forEach {
            if (it.addCard(card)) {
                return true
            }
        }
        //lets try to play on tableau piles
        tableauPiles.forEach {
            if (it.addCards(mutableListOf(card))) {
                return true
            }
        }

        return false
    }

    fun debugPrint(){
        //print imp info about GameModel class

       // println(deck.cardsInDeck.last())  //sout for println

        var firstLine=if(wastePile.size>0)"${wastePile.last()}" else "___"
        firstLine=firstLine.padEnd(18)
        foundationPiles.forEach {
            firstLine+=if(it.cards.size>0) "${it.cards.last()}" else "___"
            firstLine+="   "
        }
        println(firstLine)
        println()

        for(i in 0..12){
            var row=""
            tableauPiles.forEach {
                row+=if(it.cards.size>i)"${it.cards[i]}" else "   "
                row+="   "

            }
            println(row)
        }
    }

}