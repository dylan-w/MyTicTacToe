package com.example.mytictactoe.ui

import android.util.Log
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.contentDescription
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytictactoe.ui.theme.MyTicTacToeTheme

@Composable
fun TicTacToeBoard(theBoard: CharArray, onSelect: (Int) -> Boolean) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        for (y in 0..2) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (x in 0..2) {
                    Column(
                        modifier = Modifier
                            .weight(1F)
                            .border(BorderStroke(1.dp, Color.Black))
                            .aspectRatio(1F)
                            .semantics(true) {
                                contentDescription = "Row ${y + 1}, column ${x + 1}. Current value: ${theBoard[twoDimensionsToOneDimension(x, y)]}"
                            }
                            .clickable(
                                onClickLabel = "Click to select this space."
                            ) {
                                Log.d("TicTacToeBoard", "Space selected: $x, $y")
                                val valid = onSelect(twoDimensionsToOneDimension(x, y))
                                Log.d("TicTacToeBoard", "Valid space selected: $valid")
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = theBoard[twoDimensionsToOneDimension(x, y)].toString(),
                            fontSize = 40.sp
                        )
                    }
                }
            }
        }
    }
}

private fun twoDimensionsToOneDimension(col: Int, row: Int) = row * 3 + col

@Preview(showBackground = true)
@Composable
fun TicTacToeBoardPreview() {
    MyTicTacToeTheme {
        val input = charArrayOf(
            'X', ' ', 'O',
            'O', ' ', 'O',
            'X', 'X', 'O',
        )
        TicTacToeBoard(theBoard = input, onSelect = { true })
    }
}