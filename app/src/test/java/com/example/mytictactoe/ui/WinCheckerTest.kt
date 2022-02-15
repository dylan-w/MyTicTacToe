package com.example.mytictactoe.ui

import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

@RunWith(Parameterized::class)
class WinCheckerTest(
    private val theBoard: CharArray,
    private val expected: TicTacToeViewModel.PLAYER?
) {
    @Test
    fun check() {
        assertThat(WinChecker().check(theBoard), `is`(expected))
    }

    companion object {
        @JvmStatic
        @Parameterized.Parameters
        fun data(): Iterable<Array<Any?>> =
            arrayListOf(
                arrayOf(
                    charArrayOf(
                        ' ', ' ', ' ',
                        ' ', ' ', ' ',
                        ' ', ' ', ' ',
                    ),
                    null
                ),
                arrayOf(
                    charArrayOf(
                        'X', 'X', 'O',
                        'O', 'O', 'X',
                        'X', 'O', 'X',
                    ),
                    null
                ),
                arrayOf(
                    charArrayOf(
                        'A', 'D', ' ',
                        'B', 'D', ' ',
                        'C', 'D', ' ',
                    ),
                    null
                ),
                arrayOf(
                    charArrayOf(
                        'X', ' ', ' ',
                        'X', ' ', ' ',
                        'X', ' ', ' ',
                    ),
                    TicTacToeViewModel.PLAYER.ONE
                ),
                arrayOf(
                    charArrayOf(
                        'O', ' ', ' ',
                        ' ', 'O', ' ',
                        ' ', ' ', 'O',
                    ),
                    TicTacToeViewModel.PLAYER.TWO
                ),
                arrayOf(
                    charArrayOf(
                        ' ', 'O', ' ',
                        'X', 'O', ' ',
                        'X', 'O', ' ',
                    ),
                    TicTacToeViewModel.PLAYER.TWO
                ),
                arrayOf(
                    charArrayOf(
                        'X', ' ', 'X',
                        'O', ' ', 'X',
                        'X', ' ', 'X',
                    ),
                    TicTacToeViewModel.PLAYER.ONE
                ),
                arrayOf(
                    charArrayOf(
                        'X', ' ', 'X',
                        'O', 'X', ' ',
                        'X', ' ', ' ',
                    ),
                    TicTacToeViewModel.PLAYER.ONE
                ),
                arrayOf(
                    charArrayOf(
                        'X', ' ', ' ',
                        'O', ' ', ' ',
                        'X', 'X', 'X',
                    ),
                    TicTacToeViewModel.PLAYER.ONE
                ),
                arrayOf(
                    charArrayOf(
                        ' ', ' ', ' ',
                        'X', 'X', 'X',
                        'X', ' ', ' ',
                    ),
                    TicTacToeViewModel.PLAYER.ONE
                ),
            )
    }
}