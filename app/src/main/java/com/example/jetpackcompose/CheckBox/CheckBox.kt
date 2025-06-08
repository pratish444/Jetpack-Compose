package com.example.jetpackcompose.CheckBox

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.material3.TriStateCheckbox
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsProperties.ToggleableState
import androidx.compose.ui.tooling.preview.Preview

@Composable

fun CheckBoxExample() {
    // List to hold the checked states of child checkboxes (initially all false)

    val childCheckedStates = remember {
        mutableStateListOf(false, false, false)
    }
    // Determine the parent (tri-state) checkbox state:
    // - On if all children are checked
    // - Off if none are checked
    // - Indeterminate if some are checked
    val parentState = when {
        childCheckedStates.all { it } -> androidx.compose.ui.state.ToggleableState.On
        childCheckedStates.none { it } -> androidx.compose.ui.state.ToggleableState.Off
        else -> androidx.compose.ui.state.ToggleableState.Indeterminate
    }

    // UI Layout

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        // Parent Row: "Select all" with TriStateCheckbox
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text("Select all")
            TriStateCheckbox(
                state = parentState,
                onClick = {
                    // Toggle all children based on current parent state
                    val newState = parentState != androidx.compose.ui.state.ToggleableState.On
                    for (i in childCheckedStates.indices) {
                        childCheckedStates[i] = newState
                    }
                }
            )
        }

        // Child Checkboxes
        childCheckedStates.forEachIndexed { index, checked ->
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text("Option ${index + 1}")
                Checkbox(
                    checked = checked,
                    onCheckedChange = {
                        // Update the corresponding child state
                        childCheckedStates[index] = it
                    }
                )
            }
        }

        // Optional message when all options are selected
        if (childCheckedStates.all { it }) {
            Text("All options selected")
        }
    }
}

@Preview(showSystemUi = true)
@Composable
fun CheckExamplePreview() {
    CheckBoxExample()
}



