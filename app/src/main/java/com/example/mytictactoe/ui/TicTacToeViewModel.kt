package com.example.mytictactoe.ui

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class TicTacToeViewModel : ViewModel() {
    var theBoardState by mutableStateOf(
        charArrayOf(
            ' ', ' ', ' ',
            ' ', ' ', ' ',
            ' ', ' ', ' ',
        )
    )

    fun selectState(spot: Int): Boolean {
        Log.d(
            "TicTacToeViewModel.selectState",
            "Spot: $spot"
        )
        Log.d(
            "TicTacToeViewModel.selectState",
            """
                Current Board:
                ${theBoardState[0]}, ${theBoardState[1]}, ${theBoardState[2]},
                ${theBoardState[3]}, ${theBoardState[4]}, ${theBoardState[5]},
                ${theBoardState[6]}, ${theBoardState[7]}, ${theBoardState[8]}
            """.trimIndent()
        )
        if (spot !in 0..8) {
            Log.d("TicTacToeViewModel.selectState", "Spot out of bounds.")
            return false
        }
        if (theBoardState[spot] in setOf('X', 'O')) {
            Log.d("TicTacToeViewModel.selectState", "This spot is already set.")
            return false
        }
        theBoardState = theBoardState.toMutableList().apply { set(spot, 'O') }.toCharArray()
        Log.d(
            "TicTacToeViewModel.selectState",
            """
                New Board:
                ${theBoardState[0]}, ${theBoardState[1]}, ${theBoardState[2]},
                ${theBoardState[3]}, ${theBoardState[4]}, ${theBoardState[5]},
                ${theBoardState[6]}, ${theBoardState[7]}, ${theBoardState[8]}
            """.trimIndent()
        )
        return true
    }
}