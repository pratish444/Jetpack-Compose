package com.example.jetpackcompose

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.selection.DisableSelection
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.LinkAnnotation
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextLinkStyles
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.withLink
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.foundation.text.selection.SelectionContainer as SelectionContainer1

@Composable
fun PartiallySelectlableText() {
    // Box to center the content vertically and horizontally
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        // SelectionContainer allows the text inside it to be selectable
        SelectionContainer1 {
            Column {
                // These texts can be selected and copied by the user
                Text("This is a text can be select")
                Text("this one too")
                Text("this is the third")

                // DisableSelection makes inner Texts non-selectable
                DisableSelection {
                    Text("this is not selectable one")
                    Text("this is not selectable text")
                }
            }
        }
    }
}

@Composable
fun AnnotatedStringwithListenerSample() {
    // Used to open URLs when a link is clicked
    val uriHandler = LocalUriHandler.current

    // Center the text in the screen using Box
    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.Center
    ) {
        Text(
            // Build a text string that contains a clickable URL
            buildAnnotatedString {
                append("Build better apps faster with ")

                // Define the clickable URL with blue color
                val link = LinkAnnotation.Url(
                    "https://developer.android.com/develop/ui/compose/documentation",
                    TextLinkStyles(
                        SpanStyle(
                            color = Color.Blue // Makes the link text blue
                        )
                    )
                ) {
                    // Action when the link is clicked
                    val url = (it as LinkAnnotation.Url).url
                    uriHandler.openUri(url) // Opens the URL in the browser
                }

                // This adds the text "JetPack Compose" as the clickable part
                withLink(link) {
                    append("JetPack Compose")
                }
            }
        )
    }
}

@Preview(showSystemUi = true)
@Composable
fun PreviewSelectable() {
    // Change this to test either one of the two functions
    AnnotatedStringwithListenerSample()
    // Or test PartiallySelectlableText() instead
}


