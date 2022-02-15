package com.example.mytictactoe.ui

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun InfoDisplay(viewModel: TicTacToeViewModel) {
    Column {
        Text(
            text = "Player 1: ${viewModel.player1}",
            modifier = Modifier.border(
                BorderStroke(
                    width = if (viewModel.currentPlayer == TicTacToeViewModel.PLAYER.ONE) 1.dp else 0.dp,
                    color = Color.Black
                )
            )
        )
        Text(
            text = "Player 2: ${viewModel.player2}",
            modifier = Modifier.border(
                BorderStroke(
                    width = if (viewModel.currentPlayer == TicTacToeViewModel.PLAYER.TWO) 1.dp else 0.dp,
                    color = Color.Black
                )
            )
        )
        Text(
            text = viewModel.winner
        )
    }
}

@Preview(showBackground = true)
@Composable
fun InfoDisplayPreview() {
    val viewModel = TicTacToeViewModel(WinChecker()).apply {
        changePlayer1("Dylan")
        changePlayer2("Nick")
        markSpot(0)
        markSpot(1)
    }
    InfoDisplay(viewModel = viewModel)
}