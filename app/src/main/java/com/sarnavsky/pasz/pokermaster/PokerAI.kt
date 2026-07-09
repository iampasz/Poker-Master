package com.sarnavsky.pasz.pokermaster

import kotlin.random.Random


object PokerAI {

    fun decide(
        category: HandCategory,
        style: BotStyle
    ): PlayerAction {

        val baseAction = decideByCategory(category)

        return applyStyle(baseAction, style)
    }

    fun decideByCategory(category: HandCategory): PlayerAction {

        val roll = Random.nextInt(100)

        return when (category) {

            HandCategory.PREMIUM -> when {
                roll < 5 -> PlayerAction.FOLD
                roll < 20 -> PlayerAction.CALL
                roll < 75 -> PlayerAction.RAISE
                else -> PlayerAction.ALL_IN
            }

            HandCategory.STRONG -> when {
                roll < 10 -> PlayerAction.FOLD
                roll < 45 -> PlayerAction.CALL
                roll < 90 -> PlayerAction.RAISE
                else -> PlayerAction.ALL_IN
            }

            HandCategory.PLAYABLE -> when {
                roll < 25 -> PlayerAction.FOLD
                roll < 70 -> PlayerAction.CALL
                roll < 95 -> PlayerAction.RAISE
                else -> PlayerAction.ALL_IN
            }

            HandCategory.MARGINAL -> when {
                roll < 55 -> PlayerAction.FOLD
                roll < 90 -> PlayerAction.CALL
                roll < 98 -> PlayerAction.RAISE
                else -> PlayerAction.ALL_IN
            }

            HandCategory.WEAK -> when {
                roll < 80 -> PlayerAction.FOLD
                roll < 97 -> PlayerAction.CALL
                roll < 99 -> PlayerAction.RAISE
                else -> PlayerAction.ALL_IN
            }
        }
    }


    private fun applyStyle(
        action: PlayerAction,
        style: BotStyle
    ): PlayerAction {

        val roll = Random.nextInt(100)

        return when (style) {

            BotStyle.NORMAL -> action

            BotStyle.AGGRESSIVE -> {

                when (action) {

                    PlayerAction.CALL ->
                        if (roll < 40) PlayerAction.RAISE else action

                    PlayerAction.RAISE ->
                        if (roll < 20) PlayerAction.ALL_IN else action

                    PlayerAction.FOLD ->
                        if (roll < 10) PlayerAction.CALL else action

                    else -> action
                }
            }

            BotStyle.TIGHT -> {

                when (action) {

                    PlayerAction.CALL ->
                        if (roll < 30) PlayerAction.FOLD else action

                    PlayerAction.RAISE ->
                        if (roll < 30) PlayerAction.CALL else action

                    PlayerAction.ALL_IN ->
                        if (roll < 50) PlayerAction.RAISE else action

                    else -> action
                }
            }

            BotStyle.LOOSE -> {

                when (action) {

                    PlayerAction.FOLD ->
                        if (roll < 40) PlayerAction.CALL else action

                    PlayerAction.CALL ->
                        if (roll < 20) PlayerAction.RAISE else action

                    else -> action
                }
            }
        }
    }
}