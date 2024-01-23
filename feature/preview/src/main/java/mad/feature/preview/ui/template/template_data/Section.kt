package mad.feature.preview.ui.template.template_data

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.Divider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import mad.core.model.template.CvForgeSection
import mad.core.model.template.item.TextItem
import mad.core.model.template.item.TextProgressItem
import mad.feature.preview.ui.template.template_data.reusable.CvForgeText
import mad.feature.preview.ui.template.template_data.reusable.CvForgeTextProgress

@Composable
fun Section(
    sectionData: CvForgeSection,
    modifier: Modifier = Modifier,
) {
    Column(modifier = modifier) {
        if (sectionData.topTitleDivider) {
            Divider(thickness = 1.dp, modifier = Modifier.padding(vertical = 4.dp))
        }
        if (!sectionData.title.isNullOrBlank()) {
            Text(text = sectionData.title!!, style = MaterialTheme.typography.titleLarge)
        }
        if (sectionData.bottomTitleDivider) {
            Divider(thickness = 1.dp, modifier = Modifier.padding(vertical = 4.dp))
        }
        Spacer(modifier = Modifier)
        LazyVerticalGrid(
            modifier = Modifier,
            columns = GridCells.Fixed(sectionData.getItemsColumnNum())
        ) {
            items(sectionData.items) { item ->
                when (item) {
                    is TextItem -> CvForgeText(data = item)
                    is TextProgressItem -> CvForgeTextProgress(data = item)
                }
            }
        }
    }
}

