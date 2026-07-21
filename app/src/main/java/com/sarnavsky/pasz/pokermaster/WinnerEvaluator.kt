package com.sarnavsky.pasz.pokermaster

import Player

object WinnerEvaluator {

    fun determineWinners(players: List<Player>): List<Player> {

        val bestRank = findBestRank(players)

        val contenders = findContenders(players, bestRank)

        if (contenders.size == 1) {
            return contenders
        }

        return comparePlayers(contenders)
    }


    private fun findBestRank(players: List<Player>): HandRank {

        return players
            .mapNotNull { it.handResult }
            .maxBy { it.rank.ordinal }
            .rank
    }

    private fun findContenders(
        players: List<Player>,
        rank: HandRank
    ): List<Player> {

        return players.filter {
            it.handResult?.rank == rank
        }
    }


    private fun comparePlayers(players: List<Player>): List<Player> {

        return when (players.first().handResult!!.rank) {

            HandRank.ROYAL_FLUSH -> compareRoyalFlush(players)

            HandRank.STRAIGHT_FLUSH -> compareStraightFlush(players)

            HandRank.FOUR_OF_A_KIND -> compareFourOfKind(players)

            HandRank.FULL_HOUSE -> compareFullHouse(players)

            HandRank.FLUSH -> compareFlush(players)

            HandRank.STRAIGHT -> compareStraight(players)

            HandRank.THREE_OF_A_KIND -> compareThreeOfKind(players)

            HandRank.TWO_PAIR -> compareTwoPair(players)

            HandRank.PAIR -> compareOnePair(players)

            HandRank.HIGH_CARD -> compareHighCard(players)
        }
    }
    private fun compareRoyalFlush(players: List<Player>): List<Player> {
        return players
    }
    private fun compareStraightFlush(players: List<Player>): List<Player> {

        val highestCard = players.maxOf {
            it.handResult!!.cards.first().rank.value
        }

        return players.filter {
            it.handResult!!.cards.first().rank.value == highestCard
        }
    }
    private fun compareFourOfKind(players: List<Player>): List<Player> {

        var winners = players

        // Порівнюємо каре
        var highestValue = winners.maxOf {
            it.handResult!!.cards[0].rank.value
        }

        winners = winners.filter {
            it.handResult!!.cards[0].rank.value == highestValue
        }

        if (winners.size == 1) return winners

        // Порівнюємо кікер
        highestValue = winners.maxOf {
            it.handResult!!.cards[4].rank.value
        }

        return winners.filter {
            it.handResult!!.cards[4].rank.value == highestValue
        }
    }
    private fun compareFullHouse(players: List<Player>): List<Player> {

        var winners = players

        // Порівнюємо трійку
        var highestValue = winners.maxOf {
            it.handResult!!.cards[0].rank.value
        }

        winners = winners.filter {
            it.handResult!!.cards[0].rank.value == highestValue
        }

        if (winners.size == 1) return winners

        // Порівнюємо пару
        highestValue = winners.maxOf {
            it.handResult!!.cards[3].rank.value
        }

        return winners.filter {
            it.handResult!!.cards[3].rank.value == highestValue
        }
    }
    private fun compareFlush(players: List<Player>): List<Player> {

        var winners = players

        for (cardIndex in 0 until 5) {

            val highestValue = winners.maxOf {
                it.handResult!!.cards[cardIndex].rank.value
            }

            winners = winners.filter {
                it.handResult!!.cards[cardIndex].rank.value == highestValue
            }

            if (winners.size == 1) {
                return winners
            }
        }

        return winners
    }
    private fun compareStraight(players: List<Player>): List<Player> {

        val highestCard = players.maxOf {
            it.handResult!!.cards.first().rank.value
        }

        return players.filter {
            it.handResult!!.cards.first().rank.value == highestCard
        }
    }
    private fun compareThreeOfKind(players: List<Player>): List<Player> {

        var winners = players

        // Порівнюємо трійку
        var highestValue = winners.maxOf {
            it.handResult!!.cards[0].rank.value
        }

        winners = winners.filter {
            it.handResult!!.cards[0].rank.value == highestValue
        }

        if (winners.size == 1) return winners

        // Перший кікер
        highestValue = winners.maxOf {
            it.handResult!!.cards[3].rank.value
        }

        winners = winners.filter {
            it.handResult!!.cards[3].rank.value == highestValue
        }

        if (winners.size == 1) return winners

        // Другий кікер
        highestValue = winners.maxOf {
            it.handResult!!.cards[4].rank.value
        }

        return winners.filter {
            it.handResult!!.cards[4].rank.value == highestValue
        }
    }
    private fun compareTwoPair(players: List<Player>): List<Player> {

        var winners = players

        // Старша пара
        var highestValue = winners.maxOf {
            it.handResult!!.cards[0].rank.value
        }

        winners = winners.filter {
            it.handResult!!.cards[0].rank.value == highestValue
        }

        if (winners.size == 1) return winners

        // Молодша пара
        highestValue = winners.maxOf {
            it.handResult!!.cards[2].rank.value
        }

        winners = winners.filter {
            it.handResult!!.cards[2].rank.value == highestValue
        }

        if (winners.size == 1) return winners

        // Кікер
        highestValue = winners.maxOf {
            it.handResult!!.cards[4].rank.value
        }

        return winners.filter {
            it.handResult!!.cards[4].rank.value == highestValue
        }
    }
    private fun compareOnePair(players: List<Player>): List<Player> {

        var winners = players

        // Порівнюємо пару
        var highestValue = winners.maxOf {
            it.handResult!!.cards[0].rank.value
        }

        winners = winners.filter {
            it.handResult!!.cards[0].rank.value == highestValue
        }

        if (winners.size == 1) return winners

        // Порівнюємо кікери
        for (cardIndex in 2 until 5) {

            highestValue = winners.maxOf {
                it.handResult!!.cards[cardIndex].rank.value
            }

            winners = winners.filter {
                it.handResult!!.cards[cardIndex].rank.value == highestValue
            }

            if (winners.size == 1) {
                return winners
            }
        }

        return winners
    }
    private fun compareHighCard(players: List<Player>): List<Player> {

        var winners = players

        for (cardIndex in 0 until 5) {

            val highestValue = winners.maxOf {
                it.handResult!!.cards[cardIndex].rank.value
            }

            winners = winners.filter {
                it.handResult!!.cards[cardIndex].rank.value == highestValue
            }

            if (winners.size == 1) {
                return winners
            }
        }

        return winners
    }
}