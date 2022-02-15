package com.example.mytictactoe

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.example.mytictactoe.ui.InfoDisplay
import com.example.mytictactoe.ui.TicTacToeBoard
import com.example.mytictactoe.ui.TicTacToeViewModel
import com.example.mytictactoe.ui.theme.MyTicTacToeTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val ticTacToeViewModel by viewModels<TicTacToeViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTicTacToeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    TicTacToeScreen(ticTacToeViewModel)
                }
            }
        }
    }
}

@Composable
fun TicTacToeScreen(viewModel: TicTacToeViewModel) {
    Column {
        TicTacToeBoard(
            theBoard = viewModel.theBoardState,
            onSelect = viewModel::markSpot
        )
        InfoDisplay(viewModel = viewModel)
    }
}