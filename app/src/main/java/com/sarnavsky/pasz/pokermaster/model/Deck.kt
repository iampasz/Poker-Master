class Deck {

    private val cards = mutableListOf<PlayingCard>()

    init {
        reset()
    }

    fun reset() {
        cards.clear()

        Suit.entries.forEach { suit ->
            Rank.entries.forEach { rank ->
                cards.add(
                    PlayingCard(
                        suit = suit,
                        rank = rank
                    )
                )
            }
        }

        cards.shuffle()
    }

    fun draw(): PlayingCard {
        return cards.removeAt(0)
    }

    fun size(): Int {
        return cards.size
    }
}