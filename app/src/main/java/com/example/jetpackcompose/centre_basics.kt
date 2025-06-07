package com.example.jetpackcompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.res.painterResource
import androidx.compose.material3.Text
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp


@Composable
fun CenteredContent() {
    Box(
        modifier = Modifier
            .fillMaxSize(), // Fill screen
        contentAlignment = Alignment.Center // Center everything
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Image(
                painter = painterResource(id = R.drawable.image), // Replace with your image resource
                contentDescription = "Centered Image",
                modifier = Modifier
                    .size(150.dp)
            )
            Spacer(modifier = Modifier.height(16.dp)) // Space between image and text
            Text(
                text = "Hello, Pratish!",
                fontSize = 24.sp,
                textAlign = TextAlign.Center
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
fun CenteredContentPreview() {
    CenteredContent()
}


