package com.sarnavsky.pasz.pokermaster

import Player
import android.util.Log
import com.sarnavsky.pasz.pokermaster.model.PokerGame
import kotlin.random.Random


object PokerAI {


    fun startGame(game: PokerGame) {
        Log.d("POKER_AI", "Гра почалась")

        if (isHumanTurn(game)) {
            Log.d("POKER_AI", "Хід людини")
        } else {
            Log.d("POKER_AI", "Хід AI")
        }

        if (isBigBlind(game)) {
            Log.d("POKER_AI", "Current player is Big Blind")
        } else {
            Log.d("POKER_AI", "Current player is NOT Big Blind")
        }

        analyze(game)


    }

    private fun isHumanTurn(game: PokerGame): Boolean {
        return game.currentPlayerIndex == 0
    }

    private fun isBigBlind(game: PokerGame): Boolean {
        return game.players[game.currentPlayerIndex].isBigBlind
    }

    private fun wasRaiseAfterBigBlind(game: PokerGame): Boolean {
        return game.currentBet > game.bigBlind
    }

    fun analyze(game: PokerGame) {

        checkCurrentPlayer(game)
        checkRound(game)

        val handStrength = getHandStrength(game)

        Log.d("POKER_AI", "Hand strength: $handStrength")

        val round = checkRound(game)

        Log.d("POKER_AI", "Round: $round")



        while (!isHumanTurn(game)) {

            makeMove(game)

            nextPlayer(game)
        }


    }

    fun checkCurrentPlayer(game: PokerGame) {

    }

    private fun checkRound(game: PokerGame): GameRound {
        return game.round
    }



    fun getHandStrength(game: PokerGame): Int {
        val player = game.players[game.currentPlayerIndex]

        return  PreflopOdds().getStartingHandRank(
            player.cards[0],
            player.cards[1]
        )
    }





    fun makeMove(game: PokerGame){

        Log.d("POKER_AI", "makeMove: ${game.currentPlayerIndex}")

    }


    fun nextPlayer(game: PokerGame){

        Log.d("POKER_AI2", "Ходить гравець "+ game.currentPlayerIndex)

        game.currentPlayerIndex++

        if(game.currentPlayerIndex ==4){
            game.currentPlayerIndex = 0
        }

    

        analyze(game)
    }


}