package mad.feature.preview.ui.template.template_data.reusable

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mad.core.designsystem.theme.CVForgeTheme

@Composable
fun TemplateProgressBar(
    value: Float,
    modifier: Modifier = Modifier
) {
    LinearProgressIndicator(
        progress = value,
        modifier = modifier
            .padding(all=8.dp)
            .fillMaxWidth()
            .requiredHeight(8.dp),
        color = MaterialTheme.colorScheme.secondary,
        trackColor = MaterialTheme.colorScheme.secondaryContainer
    )
}

@Preview
@Composable
fun PreviewTemplateProgressBar() {
    CVForgeTheme {
        TemplateProgressBar(value = 0.8f)
    }

}