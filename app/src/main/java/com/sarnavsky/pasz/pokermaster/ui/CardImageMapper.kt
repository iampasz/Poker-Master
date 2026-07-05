package com.sarnavsky.pasz.pokermaster.ui.components

import PlayingCard
import Rank
import Suit
import android.content.Context
import com.sarnavsky.pasz.pokermaster.R

object CardImageMapper {

    fun getResId(
        context: Context,
        card: PlayingCard
    ): Int {

        val suit = when (card.suit) {
            Suit.SPADES -> "s"
            Suit.HEARTS -> "h"
            Suit.DIAMONDS -> "d"
            Suit.CLUBS -> "c"
        }

        val rank = when (card.rank) {
            Rank.ACE -> "a"
            Rank.KING -> "k"
            Rank.QUEEN -> "q"
            Rank.JACK -> "j"
            Rank.TEN -> "10"
            Rank.NINE -> "9"
            Rank.EIGHT -> "8"
            Rank.SEVEN -> "7"
            Rank.SIX -> "6"
            Rank.FIVE -> "5"
            Rank.FOUR -> "4"
            Rank.THREE -> "3"
            Rank.TWO -> "2"
        }

        val resourceName = suit + rank

        val id = context.resources.getIdentifier(
            resourceName,
            "drawable",
            context.packageName
        )

        return if (id != 0) {
            id
        } else {
            R.drawable.back
        }
    }
}