package mad.feature.preview.ui.template.template_data.reusable

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mad.core.model.template.item.ProgressType
import mad.core.model.template.item.TextProgressItem

@Composable
fun CvForgeTextProgress(
    data: TextProgressItem,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        Text(text = data.text, modifier = Modifier.padding(horizontal = 4.dp))
        when (data.progressType) {
            ProgressType.PROGRESS_BAR -> TemplateProgressBar(data.progress)
            ProgressType.SLIDER -> TemplateSlider(data.progress)
            else -> {}
        }
    }
}