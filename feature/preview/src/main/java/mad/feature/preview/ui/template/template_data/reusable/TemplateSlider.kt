package mad.feature.preview.ui.template.template_data.reusable

import androidx.compose.foundation.layout.defaultMinSize
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.requiredHeight
import androidx.compose.foundation.layout.sizeIn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import mad.core.designsystem.theme.CVForgeTheme

@Composable
fun TemplateSlider(
    value: Float,
    modifier: Modifier = Modifier,
    onValueChange: (Float) -> Unit = {}
) {
    Slider(
        modifier = modifier.requiredHeight(24.dp),
        value = value,
        onValueChange = { onValueChange(it) },
        colors = SliderDefaults.colors(
            thumbColor = MaterialTheme.colorScheme.secondary,
            activeTrackColor = MaterialTheme.colorScheme.secondary,
            inactiveTrackColor = MaterialTheme.colorScheme.secondaryContainer,
        ),
        steps = 0,
        valueRange = 0f..1f
    )
}

@Preview(showBackground = true)
@Composable
fun PreviewTemplateSlider() {
    CVForgeTheme {
        TemplateSlider(value = 0.9f)
    }
}