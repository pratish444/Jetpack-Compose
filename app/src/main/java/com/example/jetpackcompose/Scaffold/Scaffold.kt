package com.example.jetpackcompose.Scaffold

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

// This annotation is needed to use experimental APIs like Scaffold and TopAppBar in Material 3
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ScaffoldExample() {

    // State variable to count how many times the FAB (FloatingActionButton) was clicked
    var presses by remember { mutableStateOf(0) }

    // Scaffold is a layout structure provided by Jetpack Compose.
    // It gives you ready-to-use slots for TopAppBar, BottomAppBar, FAB, and content.
    Scaffold(

        // ---------- TOP APP BAR ----------
        topBar = {
            TopAppBar(
                // Title text shown in the center of the top app bar
                title = { Text("Top App Bar") },

                // Optional navigation icon on the left (e.g., hamburger menu)
                navigationIcon = {
                    IconButton(onClick = {
                        // Logic for opening navigation drawer (if you want to add later)
                    }) {
                        Icon(Icons.Default.Menu, contentDescription = "Menu Icon")
                    }
                },

                // Styling for the top app bar using MaterialTheme colors
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,     // background
                    titleContentColor = MaterialTheme.colorScheme.primary,           // title text
                    navigationIconContentColor = MaterialTheme.colorScheme.primary,  // icon color
                    actionIconContentColor = MaterialTheme.colorScheme.primary       // action icons
                )
            )
        },

        // ---------- BOTTOM APP BAR ----------
        bottomBar = {
            BottomAppBar(
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.primary
            ) {
                Text(
                    text = "Bottom App Bar",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(16.dp),
                    textAlign = TextAlign.Center // center the text inside the bottom bar
                )
            }
        },

        // ---------- FLOATING ACTION BUTTON ----------
        floatingActionButton = {
            FloatingActionButton(
                onClick = { presses++ }, // Increments the counter each time FAB is clicked
                containerColor = MaterialTheme.colorScheme.primary
            ) {
                // Display how many times the FAB has been clicked
                Text("+$presses")
            }
        }

    ) { innerPadding ->

        // ---------- MAIN CONTENT AREA ----------
        // The inner padding avoids content overlapping with top/bottom bars or FAB
            Column(
            modifier = Modifier
                .fillMaxSize()                      // Fills the whole screen
                .padding(innerPadding)             // Applies system-safe padding
                .background(Color(0xFFFFF3E0)),     // Light pastel yellow background
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            // Main text content
            Text(
                text = "This is the scaffold content.",
                style = MaterialTheme.typography.titleLarge,
                color = Color.Black
            )
        }
    }
}

// ---------- PREVIEW FUNCTION ----------
// This function shows how your Composable will look on the screen
@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {
    ScaffoldExample()
}
