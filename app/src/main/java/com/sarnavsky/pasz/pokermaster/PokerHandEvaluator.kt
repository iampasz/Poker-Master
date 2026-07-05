import com.sarnavsky.pasz.pokermaster.HandRank
import com.sarnavsky.pasz.pokermaster.HandResult

object PokerHandEvaluator {

    fun evaluate(cards: List<PlayingCard>): HandResult {

        val rankCounts = cards
            .groupingBy { it.rank }
            .eachCount()

        val pairs = rankCounts.values.count { it == 2 }
        val triples = rankCounts.values.count { it == 3 }
        val fours = rankCounts.values.count { it == 4 }

        return when {

            fours == 1 -> HandResult(
                HandRank.FOUR_OF_A_KIND,
                cards
            )

            triples >= 1 && pairs >= 1 -> HandResult(
                HandRank.FULL_HOUSE,
                cards
            )

            triples >= 1 -> HandResult(
                HandRank.THREE_OF_A_KIND,
                cards
            )

            pairs >= 2 -> HandResult(
                HandRank.TWO_PAIR,
                cards
            )

            pairs == 1 -> HandResult(
                HandRank.PAIR,
                cards
            )

            else -> HandResult(
                HandRank.HIGH_CARD,
                cards
            )
        }
    }
}