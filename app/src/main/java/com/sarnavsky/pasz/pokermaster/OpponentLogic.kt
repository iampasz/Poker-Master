package com.sarnavsky.pasz.pokermaster

object OpponentLogic {

    fun chooseAction(hand: HandRank): PlayerAction {

        return when (hand) {

            HandRank.HIGH_CARD -> {
                listOf(
                    PlayerAction.FOLD,
                    PlayerAction.CHECK,
                    PlayerAction.CHECK,
                    PlayerAction.CALL
                ).random()
            }

            HandRank.PAIR -> {
                listOf(
                    PlayerAction.CHECK,
                    PlayerAction.CALL,
                    PlayerAction.CALL,
                    PlayerAction.RAISE
                ).random()
            }

            HandRank.TWO_PAIR -> {
                listOf(
                    PlayerAction.CALL,
                    PlayerAction.RAISE,
                    PlayerAction.RAISE
                ).random()
            }

            HandRank.THREE_OF_A_KIND -> {
                listOf(
                    PlayerAction.RAISE,
                    PlayerAction.RAISE,
                    PlayerAction.CALL
                ).random()
            }

            HandRank.FULL_HOUSE,
            HandRank.FOUR_OF_A_KIND -> {
                listOf(
                    PlayerAction.RAISE,
                    PlayerAction.ALL_IN
                ).random()
            }

            else -> PlayerAction.CHECK
        }
    }
}