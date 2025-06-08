package com.example.jetpackcompose

import androidx.compose.foundation.layout.*
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun SimpleOutlinedTextFieldSample() {
    var text by remember { mutableStateOf("") }

    // ✅ Correct listOf usage with colors
    val rainbowColors = listOf(
        Color.Red,
        Color(0xFFFF9800),  // Orange
        Color.Yellow,
        Color.Green,
        Color.Blue,
        Color(0xFF4B0082),  // Indigo
        Color(0xFF8F00FF)   // Violet
    )

    Box(
        modifier = Modifier
            .fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        OutlinedTextField(
            value = text,
            onValueChange = { text = it },
            label = {
                Text(text = "Label") // You can style this with color if needed
            }
        )
    }
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun SimpleOutlinedTextFieldSamplePreview() {
    SimpleOutlinedTextFieldSample()
}

