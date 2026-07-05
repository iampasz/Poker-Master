package com.sarnavsky.pasz.pokermaster.ui.components

import PlayingCard

fun PlayingCard.suitSymbol(): String {

    return when (suit) {

        Suit.SPADES -> "♠"

        Suit.HEARTS -> "♥"

        Suit.DIAMONDS -> "♦"

        Suit.CLUBS -> "♣"
    }
}

fun PlayingCard.rankText(): String {

    return when (rank) {

        Rank.ACE -> "A"
        Rank.KING -> "K"
        Rank.QUEEN -> "Q"
        Rank.JACK -> "J"
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
}