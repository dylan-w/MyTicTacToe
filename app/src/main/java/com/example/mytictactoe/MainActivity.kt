package com.example.mytictactoe

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.mytictactoe.ui.TicTacToeViewModel
import com.example.mytictactoe.ui.theme.MyTicTacToeTheme

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
fun Greeting(name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MyTicTacToeTheme {
        Greeting("Android")
    }
}

@Composable
fun TicTacToeScreen(viewModel: TicTacToeViewModel) {
    TicTacToeBoard(
        theBoard = viewModel.theBoardState,
        onSelect = { spot ->
            viewModel.selectState(spot)
        }
    )
}

@Composable
fun TicTacToeBoard(theBoard: CharArray, onSelect: (Int) -> Boolean) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        for (x in 0..2) {
            Row(
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                for (y in 0..2) {
                    Column(
                        modifier = Modifier
                            .weight(1F)
                            .border(BorderStroke(1.dp, Color.Black))
                            .aspectRatio(1F)
                            .clickable(
                                onClickLabel = "Click to select this space."
                            ) {
                                Log.d("TicTacToeBoard", "Space selected: $x, $y")
                                val valid = onSelect(x * 3 + y)
                                Log.d("TicTacToeBoard", "Valid space selected: $valid")
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = theBoard[x * 3 + y].toString(),
                            fontSize = 40.sp
                        )
                    }
                }
            }
        }
    }
}