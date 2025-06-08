package com.example.jetpackcompose.InputChips

import androidx.compose.foundation.layout.Box
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.InputChip
import androidx.compose.material3.InputChipDefaults
import androidx.compose.material3.Text

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.rememberGraphicsLayer
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun InputChipExample() {

    // `enable` determines if the chip should be visible
    var enable by remember {
        mutableStateOf(true)
    }

    // Box to center the chip on the screen
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        // Only show chip when `enable` is true
        if (enable) {

            // InputChip: clickable UI component with icon, label, and optional trailing icon
            InputChip(
                onClick = {
                    // When clicked, disable the chip (hide it)
                    enable = !enable
                },
                label = {
                    Text("Enabled") // Label inside the chip
                },
                selected = enable, // Chip looks selected based on `enable`
                avatar = {
                    // Left-side icon (Person icon)
                    Icon(
                        Icons.Filled.Person,
                        contentDescription = "User icon",
                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                    )
                },
                trailingIcon = {
                    // Right-side icon (Close icon)
                    Icon(
                        Icons.Filled.Close,
                        contentDescription = "Close icon",
                        modifier = Modifier.size(InputChipDefaults.AvatarSize)
                    )
                }
            )
        }
    }
}


