import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.*
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.*
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.example.jetpackcompose.R

@Composable
fun DialogWithImage() {
    val context = LocalContext.current

    Dialog(
        onDismissRequest = {
            // Optional: Add state to hide the dialog
        }
    ) {
        Card(
            modifier = Modifier
                .padding(24.dp)
                .fillMaxWidth()
                .heightIn(min = 350.dp),
            shape = RoundedCornerShape(20.dp),
            elevation = CardDefaults.cardElevation(defaultElevation = 8.dp),
            colors = CardDefaults.cardColors(containerColor = Color.White)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth()
            ) {
                // Top: Image with rounded corners
                Image(
                    painter = painterResource(id = R.drawable.image),
                    contentDescription = "Dialog Image",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(180.dp)
                        .clip(RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp))
                )

                Spacer(modifier = Modifier.height(16.dp))

                // Centered Dialog Text
                Text(
                    text = "Stay Informed!",
                    fontSize = 20.sp,
                    modifier = Modifier
                        .padding(horizontal = 16.dp)
                        .align(Alignment.CenterHorizontally)
                )

                Text(
                    text = "Get the latest news and updates directly in your feed. Click confirm to proceed!",
                    fontSize = 14.sp,
                    color = Color.Gray,
                    modifier = Modifier
                        .padding(16.dp)
                        .align(Alignment.CenterHorizontally),
                    textAlign = TextAlign.Center
                )

                Spacer(modifier = Modifier.height(8.dp))

                // Buttons Row
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 12.dp),
                    horizontalArrangement = Arrangement.SpaceEvenly
                ) {
                    // Confirm Button
                    Button(
                        onClick = {
                            Toast.makeText(context, "Confirmed!", Toast.LENGTH_SHORT).show()
                        },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Confirm")
                    }

                    // Dismiss Button
                    OutlinedButton(
                        onClick = {
                            Toast.makeText(context, "Dismissed", Toast.LENGTH_SHORT).show()
                        },
                        shape = RoundedCornerShape(12.dp)
                    ) {
                        Text("Dismiss")
                    }
                }
            }
        }
    }
}
@Preview(showSystemUi = true)
@Composable
fun DialogPreview() {
    DialogWithImage()
}
