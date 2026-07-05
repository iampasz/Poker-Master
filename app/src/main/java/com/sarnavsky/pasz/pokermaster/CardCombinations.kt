package com.sarnavsky.pasz.pokermaster

import PlayingCard

object CardCombinations {

    fun fiveCardHands(cards: List<PlayingCard>): List<List<PlayingCard>> {

        val result = mutableListOf<List<PlayingCard>>()

        val n = cards.size

        for (a in 0 until n - 4)
            for (b in a + 1 until n - 3)
                for (c in b + 1 until n - 2)
                    for (d in c + 1 until n - 1)
                        for (e in d + 1 until n) {

                            result.add(

                                listOf(
                                    cards[a],
                                    cards[b],
                                    cards[c],
                                    cards[d],
                                    cards[e]
                                )
                            )
                        }

        return result
    }
}