package com.sarnavsky.pasz.pokermaster

import PlayingCard

data class HandResult(
    val rank: HandRank,
    val cards: List<PlayingCard>
)