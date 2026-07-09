package com.sarnavsky.pasz.pokermaster

import PlayingCard
import Rank

class PreflopOdds {

    fun getStartingHandRank(
        card1: PlayingCard,
        card2: PlayingCard
    ): Int {

        val key = buildKey(card1, card2)

        return odds[key] ?: 169
    }

    fun getWinChance(card1: PlayingCard, card2: PlayingCard): Double {

        val key = buildKey(card1, card2)

        val rank = odds[key] ?: 169

        return (170 - rank).toDouble()
    }

    fun getHandCategory(rank: Int): HandCategory {

        return when (rank) {

            in 1..20 -> HandCategory.PREMIUM

            in 21..50 -> HandCategory.STRONG

            in 51..90 -> HandCategory.PLAYABLE

            in 91..130 -> HandCategory.MARGINAL

            else -> HandCategory.WEAK
        }
    }



    private fun buildKey(
        card1: PlayingCard,
        card2: PlayingCard
    ): String {

        val high = if (card1.rank.value >= card2.rank.value) card1 else card2
        val low = if (card1.rank.value >= card2.rank.value) card2 else card1

        val highRank = rankToString(high.rank)
        val lowRank = rankToString(low.rank)

        return if (high.rank == low.rank) {
            "${highRank}${lowRank}p"
        } else {
            val suffix = if (high.suit == low.suit) "s" else "o"
            "$highRank$lowRank$suffix"
        }
    }


    private fun rankToString(rank: Rank): String {

        return when (rank) {
            Rank.ACE -> "A"
            Rank.KING -> "K"
            Rank.QUEEN -> "Q"
            Rank.JACK -> "J"
            Rank.TEN -> "T"
            Rank.NINE -> "9"
            Rank.EIGHT -> "8"
            Rank.SEVEN -> "7"
            Rank.SIX -> "6"
            Rank.FIVE -> "5"
            Rank.FOUR -> "4"
            Rank.THREE -> "3"
            Rank.TWO -> "2"
        }
    }


}