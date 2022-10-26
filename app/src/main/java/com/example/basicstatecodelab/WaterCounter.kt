package com.example.basicstatecodelab

import WellnessTaskItem
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(
        modifier = modifier.padding(16.dp),
        horizontalAlignment = CenterHorizontally
    ) {
        var count by rememberSaveable() { mutableStateOf(0) }

        if (count > 0){
            Text(
                text = "You've had $count glasses."
            )
            var showTask by rememberSaveable() {
                mutableStateOf(true)
            }
            if (showTask){
                WellnessTaskItem(
                    taskName = "Have you take your 15 minute walk today?")
            }
        }
        Row(modifier = modifier.padding(8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count <= 10
            ) {
                Text(text = "Add one")
            }

            Button(onClick = { count = 0},
            modifier = modifier.padding(start = 8.dp)) {
                Text(text = "Clear water count")
            }
        }


    }
}

@Composable
fun StatelessCounter(count: Int, onIncrement: () -> Unit, modifier: Modifier = Modifier){
    Column(modifier = modifier.padding(16.dp)) {
        if (count > 0){
            Text( text = "You've had $count glasses.")
        }
        Button(onClick = onIncrement, Modifier.padding(top = 8.dp), enabled = count < 10) {
            Text(text = "Add one")
        }
    }
}

@Composable
fun StatefulCounter(modifier: Modifier = Modifier) {
    var count by rememberSaveable { mutableStateOf(0) }
    StatelessCounter(count, { count++ }, modifier)
}

@Preview
@Composable
private fun WaterCounterPreview() {
    WaterCounter()
}