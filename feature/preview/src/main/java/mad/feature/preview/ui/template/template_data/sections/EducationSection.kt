package mad.feature.preview.ui.template.template_data.sections

//import androidx.compose.foundation.layout.Column
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import mad.core.designsystem.theme.CVForgeTheme
//import mad.feature.forge.model.EducationItem
//import mad.feature.forge.model.EducationUiState
//
//@Composable
//fun EducationSection(
//    section: EducationUiState,
//    modifier: Modifier = Modifier
//) {
//    val bullet = "\u2022"
//    Column(modifier = modifier) {
//        section.items.forEach { it ->
//            Text(text = it.title, style = MaterialTheme.typography.titleMedium)
//            it.period?.let { period ->
//                Text(text = period, style = MaterialTheme.typography.labelSmall)
//            }
//        }
//    }
//}