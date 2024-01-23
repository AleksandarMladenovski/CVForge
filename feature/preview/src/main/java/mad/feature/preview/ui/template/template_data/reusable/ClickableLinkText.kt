package mad.feature.preview.ui.template.template_data.reusable

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import mad.core.designsystem.theme.CVForgeTheme


@Composable
fun ClickableLinkText(
    text: String,
    linkUri: String,
    modifier: Modifier = Modifier
) {
    val uriHandler = LocalUriHandler.current
    ClickableText(
        text = createAnnotatedString(text),
        modifier = modifier,
        onClick = {
            uriHandler.openUri(linkUri)
        }
    )
}

private fun createAnnotatedString(text: String): AnnotatedString =
    buildAnnotatedString {
        withStyle(
            style = SpanStyle(
                textDecoration = TextDecoration.Underline,
                color = Color.Blue
            )
        ) {
            append(text)
        }
    }

@Preview(showBackground = true)
@Composable
fun PreviewClickableLinkText() {
    CVForgeTheme {
        ClickableLinkText(
            "email-address@gmail.com",
            "www.youtube.com",
        )
    }
}