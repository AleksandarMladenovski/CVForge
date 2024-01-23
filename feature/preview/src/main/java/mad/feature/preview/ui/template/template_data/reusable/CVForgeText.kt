package mad.feature.preview.ui.template.template_data.reusable

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mad.core.designsystem.icon.getIconById
import mad.core.designsystem.theme.CVForgeTheme
import mad.core.model.template.item.TextItem


@Composable
fun CvForgeText(
    data: TextItem,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier.padding(all = 4.dp), verticalAlignment = Alignment.CenterVertically) {
        if (data.iconId != null) {
            val icon = getIconById(data.iconId!!)
            Icon(
                icon,
                contentDescription = icon.name,
                tint = MaterialTheme.colorScheme.onPrimaryContainer
            )
            Spacer(Modifier.size(4.dp))
        }
        if (data.linkUri == null) {
            Text(text = data.text)
        } else {
            ClickableLinkText(text = data.text, linkUri = data.linkUri!!)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewIconText() {
    CVForgeTheme {
        CvForgeText(
            TextItem(
                "email-address@gmail.com",
                0,
                null,
            )
        )
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewClickableIconText() {
    CVForgeTheme {
        CvForgeText(
            TextItem(
                "Linkedin",
                1,
                "asd",
            )
        )
    }
}