package com.example.mytictactoe.ui

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class WinChecker @Inject constructor() {
    fun check(theBoard: CharArray) : TicTacToeViewModel.PLAYER? {
        for (char in arrayOf('X', 'O')) {
            for (x in 0..2) {
                if (theBoard[0 + x * 3] == char && theBoard[1 + x * 3] == char && theBoard[2 + x * 3] == char) {
                    // Horizontal win
                    return whichPlayer(char)
                } else if (theBoard[0 + x] == char && theBoard[3 + x] == char && theBoard[6 + x] == char) {
                    return whichPlayer(char)
                }
            }
            if (theBoard[0] == char && theBoard[4] == char && theBoard[8] == char) {
                return whichPlayer(char)
            } else if (theBoard[2] == char && theBoard[4] == char && theBoard[6] == char) {
                return whichPlayer(char)
            }
        }
        return null
    }

    private fun whichPlayer(char: Char): TicTacToeViewModel.PLAYER =
        if (char == 'X') TicTacToeViewModel.PLAYER.ONE else TicTacToeViewModel.PLAYER.TWO
}