package com.example.jetpackcompose

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Button
import androidx.compose.material3.FilledTonalButton
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.material3.ElevatedButton as ElevatedButton1

@Composable
fun FilledButtonSample() {
    val context = LocalContext.current

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {

        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // 1. Filled Button (Most commonly used for primary actions)
            Button(
                onClick = {
                    Toast.makeText(context, "Filled Button is clicked", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("Filled Button")
            }

            // Spacer for visual separation (optional)
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.weight(0.1f))

            // 2. Filled Tonal Button (Less emphasis than Filled, but still prominent)
            FilledTonalButton(
                onClick = {
                    Toast.makeText(context, "Tonal Button is clicked", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("Tonal Button")
            }

            // Spacer for visual separation
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.weight(0.1f))

            // 3. Outlined Button (Used for secondary actions, minimal visual weight)
            OutlinedButton(
                onClick = {
                    Toast.makeText(context, "Outlined Button clicked", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("Outlined Button")
            }

            // Spacer for visual separation
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.weight(0.1f))

            // 4. Elevated Button (Raised button to give prominence, but not primary)
            ElevatedButton1(
                onClick = {
                    Toast.makeText(context, "Elevated Button clicked", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("Elevated Button")
            }

            // Spacer for visual separation
            androidx.compose.foundation.layout.Spacer(modifier = Modifier.weight(0.1f))

            // 5. Text Button (Lowest emphasis, used for inline or minimal actions like "Forgot Password")
            TextButton(
                onClick = {
                    Toast.makeText(context, "Text Button clicked", Toast.LENGTH_SHORT).show()
                }
            ) {
                Text("Text Button")
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun FilledButtonSamplePreview() {
    FilledButtonSample()
}


