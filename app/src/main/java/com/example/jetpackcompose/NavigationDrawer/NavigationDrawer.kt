
package com.example.jetpackcompose.NavigationDrawer

import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch



@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailedDrawerExample() {

    // Manages the state of the Navigation Drawer (Open or Closed)
    val drawerState = rememberDrawerState(
       initialValue = DrawerValue.Closed// Drawer starts in the open state
    )

    // Used to launch suspend functions like opening/closing the drawer
    val scope = rememberCoroutineScope()

    // ModalNavigationDrawer provides a drawer that slides in from the side
    ModalNavigationDrawer(
        drawerState = drawerState, // Bind the drawer's state

        // ---------- Drawer Content ----------
        drawerContent = {
            // ModalDrawerSheet defines the UI inside the drawer panel
            ModalDrawerSheet {
                Column(
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .verticalScroll(rememberScrollState()) // Enables scrolling if content is long
                ) {
                    // Header and Divider
                    Text("Drawer Title", style = MaterialTheme.typography.titleLarge)
                    HorizontalDivider(modifier = Modifier.padding(vertical = 8.dp))

                    Text("Content of Drawer", style = MaterialTheme.typography.bodyMedium)

                    Spacer(modifier = Modifier.height(16.dp)) // Space between header and items

                    // Navigation items inside drawer
                    NavigationDrawerItem(
                        label = { Text("Item 1") },
                        selected = false,
                        onClick = {
                            // Handle click on Item 1
                        }
                    )

                    NavigationDrawerItem(
                        label = { Text("Item 2") },
                        selected = false,
                        onClick = {
                            // Handle click on Item 2
                        }
                    )
                }
            }
        }
    ) {

        // ---------- Main Screen Content ----------
        Scaffold(
            // Top App Bar shown above the main content
            topBar = {
                TopAppBar(
                    title = { Text("Navigation Drawer") },

                    // Navigation Icon (hamburger menu)
                    navigationIcon = {
                        IconButton(
                            onClick = {
                                scope.launch {
                                    // Toggle drawer open/close when icon is clicked
                                    if (drawerState.isClosed) {
                                        drawerState.open()
                                    } else {
                                        drawerState.close()
                                    }
                                }
                            }
                        ) {
                            Icon(Icons.Default.Menu, contentDescription = "Menu Icon")
                        }
                    }
                )
            }
        ) { innerPadding ->
            // Body content of the Scaffold
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                // You can add content here below the TopAppBar
                Text("Main content goes here", modifier = Modifier.padding(16.dp))
            }
        }
    }
}

// ---------- Preview Composable ----------
@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {
    DetailedDrawerExample()
}
