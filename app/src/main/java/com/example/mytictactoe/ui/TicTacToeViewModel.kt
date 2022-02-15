package com.example.mytictactoe.ui

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class TicTacToeViewModel @Inject constructor(
    private val winChecker: WinChecker
) : ViewModel() {
    var theBoardState by mutableStateOf(
        // TODO: Arrays are mutable. Use mutableStateListOf or an immutable list type.
        charArrayOf(
            ' ', ' ', ' ',
            ' ', ' ', ' ',
            ' ', ' ', ' ',
        )
    )
        private set

    var player1 by mutableStateOf("Player 1")
        private set
    var player2 by mutableStateOf("Player 2")
        private set

    var currentPlayer by mutableStateOf(PLAYER.ONE)
        private set

    var winner by mutableStateOf("Winner:")
        private set

    fun changePlayer1(name: String) {
        player1 = name
    }

    fun changePlayer2(name: String) {
        player2 = name
    }

    fun markSpot(spot: Int): Boolean {
        if (spot !in 0..8) return false
        if (theBoardState[spot] in setOf('X', 'O')) return false
        val currentMark = if (currentPlayer == PLAYER.ONE) 'X' else 'O'
        theBoardState = theBoardState.apply { set(spot, currentMark) }.copyOf()
        toggleCurrentPlayer()
        checkForWin()
        return true
    }

    enum class PLAYER {
        ONE, TWO
    }

    private fun checkForWin() {
        winner = when (winChecker.check(theBoardState)) {
            PLAYER.ONE -> "Winner: $player1"
            PLAYER.TWO -> "Winner: $player2"
            else -> "Winner:"
        }
    }

    private fun toggleCurrentPlayer() {
        currentPlayer = if (currentPlayer == PLAYER.ONE) PLAYER.TWO else PLAYER.ONE
    }
}