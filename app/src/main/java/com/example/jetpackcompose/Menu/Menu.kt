package com.example.jetpackcompose.Menu

import androidx.compose.runtime.Composable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Composable
fun DropDownExample(){
    // State to control whether dropdown is visible or not

    var expanded by remember {
        mutableStateOf(false)
    }

    // Place everything inside a Box to align the dropdown in top-end corner
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.TopEnd // Align 3-dot menu to top-right corner
    ) {

        // Nested Box to give some padding to the IconButton
        Box(
            modifier = Modifier
                .padding(16.dp)
        ) {
            // 3-dot menu icon (vertical dots)
            IconButton(
                onClick = { expanded = !expanded } // Toggle dropdown visibility
            ) {
                Icon(
                    Icons.Default.MoreVert,
                    contentDescription = ""
                )
            }
            // The dropdown menu that appears when IconButton is clicked
            DropdownMenu(
                expanded = expanded,                      // Should dropdown show?
                onDismissRequest = { expanded = false }   // Close on outside click
            ) {
                // 1st option: Profile
                DropdownMenuItem(
                    text = { Text("Profile") },
                    trailingIcon = {
                        Icon(Icons.Outlined.Person, contentDescription = "Profile icon")
                    },
                    onClick = {
                        // Action on "Profile" click
                    }
                )

                // 2nd option: Settings
                DropdownMenuItem(
                    text = { Text("Setting") },
                    trailingIcon = {
                        Icon(Icons.Outlined.Settings, contentDescription = "Settings icon")
                    },
                    onClick = {
                        // Action on "Setting" click
                    }
                )

                // Divider between options
                HorizontalDivider()

                // 3rd option: About
                DropdownMenuItem(
                    text = { Text("About") },
                    trailingIcon = {
                        Icon(Icons.Outlined.AccountBox, contentDescription = "About icon")
                    },
                    onClick = {
                        // Action on "About" click
                    }
                )
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun ExamplePreview() {
    DropDownExample()
}
