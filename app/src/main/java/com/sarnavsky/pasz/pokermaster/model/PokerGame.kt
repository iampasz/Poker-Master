package com.sarnavsky.pasz.pokermaster.model

import Deck
import Player
import PlayingCard
import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import com.sarnavsky.pasz.pokermaster.GameRound

import androidx.compose.runtime.setValue
import com.sarnavsky.pasz.pokermaster.OpponentLogic
import com.sarnavsky.pasz.pokermaster.PlayerAction

import androidx.compose.runtime.mutableIntStateOf
import com.sarnavsky.pasz.pokermaster.BotStyle


class PokerGame {


    private var dealerIndex = -1

    var currentBet = 20

    private var currentPlayerIndex = 0

    var openedCards by mutableIntStateOf(0)
        private set

    var pot by mutableIntStateOf(0)
        private set

    var playerMoved by mutableStateOf(false)
        private set

    var gameFinished by mutableStateOf(false)
        private set



    private val deck = Deck()

    val players = mutableListOf<Player>()

    val tableCards = mutableListOf<PlayingCard>()


    var round by mutableStateOf(GameRound.PRE_FLOP)
        private set


    init {

        repeat(4) { index ->
            players.add(
                Player(
                    id = index,
                    name = "Player ${index + 1}"
                )
            )
        }

        players[1].botStyle = BotStyle.AGGRESSIVE
        players[2].botStyle = BotStyle.TIGHT
        players[3].botStyle = BotStyle.LOOSE
    }

    fun startGame() {

        dealerIndex = (0 until players.size).random()

        players[dealerIndex].isDealer = true

        val smallBlindIndex = (dealerIndex + 1) % players.size
        val bigBlindIndex = (dealerIndex + 2) % players.size

        players[smallBlindIndex].isSmallBlind = true
        players[bigBlindIndex].isBigBlind = true

        val smallBlind = 10
        val bigBlind = 20

        players[smallBlindIndex].chips -= smallBlind
        players[smallBlindIndex].currentBet = smallBlind

        players[bigBlindIndex].chips -= bigBlind
        players[bigBlindIndex].currentBet = bigBlind

        pot = smallBlind + bigBlind

        currentPlayerIndex = (bigBlindIndex + 1) % players.size

        currentPlayerIndex = 0


       // val actions = getAvailableActions(players[currentPlayerIndex])

        Log.d("POKER222", "Current player: ${players[currentPlayerIndex].name}")
       // Log.d("POKER222", "Available actions: $actions")



        playerMoved = false

        gameFinished = false

        openedCards = 0

        tableCards.clear()

        players.forEach {
            it.cards.clear()
            it.folded = false
            it.currentBet = 0
            it.action = PlayerAction.NONE
        }

        deck.reset()

        // 2 карти кожному
        repeat(2) {
            players.forEach { player ->
                player.cards.add(deck.draw())
            }
        }

        // 5 карт на стіл
        repeat(5) {
            tableCards.add(deck.draw())
        }


        players.forEach { player ->
            Log.d(
                "POKER_CARDS",
                "${player.name}: ${player.cards[0]} ${player.cards[1]}"
            )
        }

        players.forEach { player ->

            val position = when {
                player.isDealer -> "DEALER"
                player.isSmallBlind -> "SMALL BLIND"
                player.isBigBlind -> "BIG BLIND"
                else -> "-"
            }

            Log.d("POKER_BLIND", "${player.name}: $position")
        }

    }

    fun getVisibleTableCards(openedCards: Int): List<PlayingCard?> {

        return List(5) { index ->

            if (index < openedCards) {
                tableCards[index]
            } else {
                null
            }
        }
    }

    fun visibleCommunityCards(): Int {

        return when (round) {

            GameRound.PRE_FLOP -> 0

            GameRound.FLOP -> 3

            GameRound.TURN -> 4

            GameRound.RIVER -> 5

            GameRound.SHOWDOWN -> 5
        }
    }

    fun nextRound() {

        round = when (round) {

            GameRound.PRE_FLOP -> GameRound.FLOP

            GameRound.FLOP -> GameRound.TURN

            GameRound.TURN -> GameRound.RIVER

            GameRound.RIVER -> GameRound.SHOWDOWN

            GameRound.SHOWDOWN -> GameRound.SHOWDOWN
        }
    }

    fun opponentsMakeMove() {

        players.drop(1).forEach { player ->

            if (player.folded) return@forEach

            val cards = player.cards + tableCards.take(openedCards)

            val hand = PokerHandEvaluator.evaluate(cards)

            player.action = OpponentLogic.chooseAction(hand.rank)

            when (player.action) {

                PlayerAction.FOLD -> {
                    player.folded = true
                }

                PlayerAction.CALL -> {

                    player.chips -= 10
                    player.currentBet += 10
                    pot += 10
                }

                PlayerAction.RAISE -> {

                    player.chips -= 20
                    player.currentBet += 20
                    pot += 20
                }

                PlayerAction.ALL_IN -> {

                    pot += player.chips
                    player.currentBet += player.chips
                    player.chips = 0
                }

                else -> {}
            }
        }
    }

    fun openNextCard() {

        if (!playerMoved) return

        opponentsMakeMove()

        if (openedCards < 5) {
            openedCards++
        }

        if (openedCards == 5) {
            gameFinished = true
        }

        playerMoved = false
    }

    fun playerFold() {

        val player = players[0]

        player.folded = true
        player.action = PlayerAction.FOLD

        playerMoved = true
    }

    fun playerCheck() {

        players[0].action = PlayerAction.CHECK

        playerMoved = true
    }

    fun playerCall() {

        val player = players[0]

        if (player.chips >= 10) {
            player.chips -= 10
            player.currentBet += 10
            pot += 10
        }

        player.action = PlayerAction.CALL

        playerMoved = true
    }

    fun playerRaise() {

        val player = players[0]

        if (player.chips >= 20) {
            player.chips -= 20
            player.currentBet += 20
            pot += 20
        }

        player.action = PlayerAction.RAISE

        playerMoved = true
    }

    fun playerAllIn() {

        val player = players[0]

        pot += player.chips
        player.currentBet += player.chips
        player.chips = 0

        player.action = PlayerAction.ALL_IN

        playerMoved = true
    }


    fun getAvailableActions(): List<PlayerAction> {
        return listOf(
            PlayerAction.FOLD,
            PlayerAction.CALL,
            PlayerAction.RAISE,
            PlayerAction.ALL_IN
        )
    }
}

