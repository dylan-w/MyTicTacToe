package com.example.mytictactoe.ui

import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithContentDescription
import androidx.compose.ui.test.performClick
import com.example.mytictactoe.ui.theme.MyTicTacToeTheme
import org.hamcrest.CoreMatchers.`is`
import org.hamcrest.MatcherAssert.assertThat
import org.junit.Rule
import org.junit.Test

class TicTacToeBoardKtTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun ticTacToeBoard() {
        var result = 200
        composeTestRule.setContent {
            MyTicTacToeTheme {
                TicTacToeBoard(
                    theBoard =
                    charArrayOf(
                        ' ', ' ', ' ',
                        ' ', ' ', ' ',
                        ' ', ' ', ' ',
                    ),
                    onSelect = { a: Int ->
                        result = a
                        true
                    })
            }
        }

        composeTestRule.onNodeWithContentDescription(
            "Row 1, column 1",
            substring = true,
            ignoreCase = true
        ).performClick()

        assertThat(result, `is`(0))

        composeTestRule.onNodeWithContentDescription(
            "Row 1, column 2",
            substring = true,
            ignoreCase = true
        ).performClick()

        assertThat(result, `is`(1))

        composeTestRule.onNodeWithContentDescription(
            "Row 2, column 1",
            substring = true,
            ignoreCase = true
        ).performClick()

        assertThat(result, `is`(3))
    }
}