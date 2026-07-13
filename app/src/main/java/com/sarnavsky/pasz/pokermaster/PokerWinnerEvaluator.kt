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
}