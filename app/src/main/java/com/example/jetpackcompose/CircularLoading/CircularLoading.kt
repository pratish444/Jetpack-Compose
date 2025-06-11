package com.example.jetpackcompose.CircularLoading

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.delay
@Composable
fun CircularIndicatorEx() {
    // `loading` is a state variable to control whether the progress indicator should show
    var loading by remember { mutableStateOf(false) }


    // `LaunchedEffect` triggers side effects (like coroutines) when `loading` changes
    LaunchedEffect(loading) {
        if (loading) {
            delay(3000) // Simulate a 3-second loading task
            loading = false // Reset loading to false after delay
        }
    }
    // Main layout
    Column(
        modifier = Modifier
            .fillMaxSize() // Take the entire screen
            .padding(16.dp), // Add some padding around the edges
        horizontalAlignment = Alignment.CenterHorizontally, // Center items horizontally
        verticalArrangement = Arrangement.Center // Center items vertically
    ) {
        // Button to start loading
        Button(
            onClick = { loading = true },
            enabled = !loading // Disable the button during loading
        ) {
            Text(text = if (loading) "Loading..." else "Start Loading") // Change button text
        }

        Spacer(modifier = Modifier.height(20.dp)) // Space between button and indicator

        // Show the Circular Progress Indicator when loading is true
        if (loading) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                CircularProgressIndicator(
                    modifier = Modifier.size(64.dp), // Set size
                    color = MaterialTheme.colorScheme.secondary, // Spinner color
                    trackColor = MaterialTheme.colorScheme.surfaceVariant // Background track color
                )
                Spacer(modifier = Modifier.height(10.dp))
                Text("Please wait...", style = MaterialTheme.typography.bodyMedium)
            }
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {
    CircularIndicatorEx()
}