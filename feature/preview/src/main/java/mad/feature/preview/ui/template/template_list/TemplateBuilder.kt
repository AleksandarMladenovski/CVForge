package mad.feature.preview.ui.template.template_list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mad.core.model.template.CvForgeTemplate
import mad.feature.preview.ui.template.template_data.Section

@Composable
fun TemplateBuilder(
    state: CvForgeTemplate,
    modifier: Modifier = Modifier
) {
    Row(modifier = modifier) {
        Column {
            state.items.forEach { section ->
                Section(sectionData = section)
            }
        }

    }
}