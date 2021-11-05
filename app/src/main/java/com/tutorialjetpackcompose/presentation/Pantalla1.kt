package com.tutorialjetpackcompose.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tutorialjetpackcompose.model.user

@Composable
fun Pantalla1(
    navegarPantalla2: (user) -> Unit
) {
    var textValue by remember { mutableStateOf(user("Juan","Villa","69666")) }
    var userVar = user("Juan","Villa","69666")
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "PANTALLA 1",
            style = TextStyle(color = Color.Black, fontSize = 42.sp, fontWeight = FontWeight.Black)
        )

        TextField(
            value = textValue.name,
            onValueChange = { textValue.name = it },
            label = { Text("Introducir Texto") }
        )

        Button(onClick = { navegarPantalla2(userVar) }) {
            Text("Enviar")
        }
    }
}