package com.sarnavsky.pasz.pokermaster

import Player
import PlayingCard
import Rank
import Suit
import android.util.Log
import com.sarnavsky.pasz.pokermaster.WinnerEvaluator.determineWinners
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

        val cards = listOf(

            PlayingCard(Suit.HEARTS, Rank.ACE),
            PlayingCard(Suit.HEARTS, Rank.JACK),
            PlayingCard(Suit.CLUBS, Rank.QUEEN),
            PlayingCard(Suit.CLUBS, Rank.TWO),
            PlayingCard(Suit.HEARTS, Rank.THREE),
            PlayingCard(Suit.CLUBS, Rank.TEN),
            PlayingCard(Suit.HEARTS, Rank.SIX)
        )

        var sevenCards = game.players[0].cards + game.tableCards


        val result2 =  PokerWinnerEvaluator().evaluate(sevenCards)
        Log.d("POKER_AI34", "Combination: ${result2.rank}")
        Log.d("POKER_AI34", "Combination: ${result2.cards}")




        game.players[0].handResult = HandResult(
            rank = HandRank.STRAIGHT,
            cards = listOf(
                PlayingCard(suit = Suit.HEARTS, rank = Rank.ACE),
                PlayingCard(suit = Suit.CLUBS, rank = Rank.JACK),
                PlayingCard(suit = Suit.CLUBS, rank = Rank.TEN),
                PlayingCard(suit = Suit.HEARTS, rank = Rank.THREE),
                PlayingCard(suit = Suit.SPADES, rank = Rank.TWO)
            )
        )

        game.players[1].handResult = HandResult(
            rank = HandRank.FOUR_OF_A_KIND,
            cards = listOf(
                PlayingCard(suit = Suit.CLUBS, rank = Rank.ACE),
                PlayingCard(suit = Suit.HEARTS, rank = Rank.JACK),
                PlayingCard(suit = Suit.DIAMONDS, rank = Rank.TEN),
                PlayingCard(suit = Suit.HEARTS, rank = Rank.THREE),
                PlayingCard(suit = Suit.HEARTS, rank = Rank.TWO)
            )
        )

        var winner = determineWinners(game.players)

        if (winner.size>0){

        }





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