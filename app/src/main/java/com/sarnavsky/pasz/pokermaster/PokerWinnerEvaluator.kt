package com.sarnavsky.pasz.pokermaster

import PlayingCard

class PokerWinnerEvaluator {

    fun isRoyalFlush(cards: List<PlayingCard>): Boolean {

        // Проходимо по кожній масті
        for (suit in Suit.entries) {

            // Беремо тільки карти цієї масті
            val suitedCards = cards.filter { it.suit == suit }

            // Якщо їх менше 5 — Royal Flush неможливий
            if (suitedCards.size < 5) continue

            // Беремо тільки ранги
            val ranks = suitedCards.map { it.rank }

            // Перевіряємо чи є всі потрібні карти
            if (
                Rank.TEN in ranks &&
                Rank.JACK in ranks &&
                Rank.QUEEN in ranks &&
                Rank.KING in ranks &&
                Rank.ACE in ranks
            ) {
                return true
            }
        }

        return false
    }

    fun checkStraightFlush(cards: List<PlayingCard>): HandResult? {

        val suits = cards.groupBy { it.suit }

        for ((_, suitedCards) in suits) {

            if (suitedCards.size < 5) continue

            val values = suitedCards
                .map { it.rank.value }
                .distinct()
                .sorted()

            for (i in 0..values.size - 5) {

                if (values[i + 4] - values[i] == 4) {

                    return HandResult(
                        rank = HandRank.STRAIGHT_FLUSH,
                        cards = suitedCards.filter {
                            it.rank.value in values[i]..values[i + 4]
                        }
                    )
                }
            }
        }

        return null
    }

    fun checkFourOfKind(cards: List<PlayingCard>): HandResult? {

        val groups = cards.groupBy { it.rank }

        val fourRank = groups.entries
            .firstOrNull { it.value.size == 4 }
            ?.key ?: return null

        val fourCards = groups[fourRank]!!

        val kicker = cards
            .filter { it.rank != fourRank }
            .maxBy { it.rank.value }

        return HandResult(
            rank = HandRank.FOUR_OF_A_KIND,
            cards = fourCards + kicker
        )
    }

    fun checkFullHouse(cards: List<PlayingCard>): HandResult? {

        val groups = cards.groupBy { it.rank }

        val threeRanks = groups.entries
            .filter { it.value.size >= 3 }
            .sortedByDescending { it.key.value }

        if (threeRanks.isEmpty()) return null

        val threeRank = threeRanks.first().key

        val pairRank = groups.entries
            .filter {
                it.key != threeRank &&
                        it.value.size >= 2
            }
            .maxByOrNull { it.key.value }
            ?.key
            ?: threeRanks
                .drop(1)
                .firstOrNull()
                ?.key
            ?: return null

        val resultCards =
            groups[threeRank]!!.take(3) +
                    groups[pairRank]!!.take(2)

        return HandResult(
            rank = HandRank.FULL_HOUSE,
            cards = resultCards
        )
    }

    fun checkFlush(cards: List<PlayingCard>): HandResult? {

        val suits = cards.groupBy { it.suit }

        val flushCards = suits.values
            .firstOrNull { it.size >= 5 }
            ?.sortedByDescending { it.rank.value }
            ?.take(5)
            ?: return null

        return HandResult(
            rank = HandRank.FLUSH,
            cards = flushCards
        )
    }

    fun checkStraight(cards: List<PlayingCard>): HandResult? {

        val values = cards
            .map { it.rank.value }
            .distinct()
            .sorted()

        for (i in 0..values.size - 5) {

            if (values[i + 4] - values[i] == 4) {

                val straightCards = values
                    .subList(i, i + 5)
                    .map { value ->
                        cards.first { it.rank.value == value }
                    }

                return HandResult(
                    rank = HandRank.STRAIGHT,
                    cards = straightCards
                )
            }
        }

        return null
    }

    fun checkThreeOfKind(cards: List<PlayingCard>): HandResult? {

        val groups = cards.groupBy { it.rank }

        val threeRank = groups.entries
            .filter { it.value.size >= 3 }
            .maxByOrNull { it.key.value }
            ?.key
            ?: return null

        val threeCards = groups[threeRank]!!.take(3)

        val kickers = cards
            .filter { it.rank != threeRank }
            .sortedByDescending { it.rank.value }
            .take(2)

        return HandResult(
            rank = HandRank.THREE_OF_A_KIND,
            cards = threeCards + kickers
        )
    }

    fun checkTwoPair(cards: List<PlayingCard>): HandResult? {

        val groups = cards.groupBy { it.rank }

        val pairRanks = groups.entries
            .filter { it.value.size >= 2 }
            .sortedByDescending { it.key.value }

        if (pairRanks.size < 2) return null

        val highPair = pairRanks[0].key
        val lowPair = pairRanks[1].key

        val pairCards =
            groups[highPair]!!.take(2) +
                    groups[lowPair]!!.take(2)

        val kicker = cards
            .filter {
                it.rank != highPair &&
                        it.rank != lowPair
            }
            .maxBy { it.rank.value }

        return HandResult(
            rank = HandRank.TWO_PAIR,
            cards = pairCards + kicker
        )
    }

    fun checkOnePair(cards: List<PlayingCard>): HandResult? {

        val groups = cards.groupBy { it.rank }

        val pairRank = groups.entries
            .filter { it.value.size >= 2 }
            .maxByOrNull { it.key.value }
            ?.key
            ?: return null

        val pairCards = groups[pairRank]!!.take(2)

        val kickers = cards
            .filter { it.rank != pairRank }
            .sortedByDescending { it.rank.value }
            .take(3)

        return HandResult(
            rank = HandRank.PAIR,
            cards = pairCards + kickers
        )
    }

    fun checkHighCard(cards: List<PlayingCard>): HandResult {

        val highCards = cards
            .sortedByDescending { it.rank.value }
            .take(5)

        return HandResult(
            rank = HandRank.HIGH_CARD,
            cards = highCards
        )
    }
}