package com.example.jetpackcompose.Cards

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ElevatedCard() {
    // Box is used to center the card in the screen
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // ElevatedCard is a card with elevation (shadow)
        ElevatedCard(
            modifier = Modifier.size(width = 200.dp, height = 100.dp), // size of the card
            elevation = CardDefaults.cardElevation(10.dp) // elevation of the card
        ) {
            // Text inside the card with padding and centered text
            Text(
                text = "This is the elevated card",
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun BottomExamplePreview() {

    ElevatedCard()

}