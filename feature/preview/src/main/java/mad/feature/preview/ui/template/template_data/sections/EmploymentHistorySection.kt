package mad.feature.preview.ui.template.template_data.sections
//
//import androidx.compose.foundation.layout.Column
//import androidx.compose.material3.MaterialTheme
//import androidx.compose.material3.Text
//import androidx.compose.runtime.Composable
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.tooling.preview.Preview
//import mad.core.designsystem.theme.CVForgeTheme
//import mad.feature.forge.model.WorkExperienceUiState
//import mad.feature.forge.model.WorkExperience
//
//@Composable
//fun EmploymentHistorySection(
//    section: WorkExperienceUiState,
//    modifier: Modifier = Modifier
//) {
//    val bullet = "\u2022"
//    Column(modifier = modifier) {
//        section.items.forEach { it ->
//            Text(text = it.title, style = MaterialTheme.typography.titleMedium)
//            it.period?.let { period ->
//                Text(text = period, style = MaterialTheme.typography.labelSmall)
//            }
//            it.responsibilities.forEach { responsibility ->
//                Text(
//                    text = bullet.plus(responsibility),
//                    style = MaterialTheme.typography.bodyMedium
//                )
//            }
//        }
//    }
//}
//
//@Preview(showBackground = true)
//@Composable
//fun PreviewEmploymentHistorySection() {
//    CVForgeTheme {
//        EmploymentHistorySection(
//            WorkExperienceUiState(
//                items = listOf(
//                    WorkExperience(
//                        "Big Astronomer at Nasa inc.",
//                        "Nov 2020 - Dec 2023",
//                        listOf(
//                            "Responsibility number 1",
//                            "Long Responsibility number two long Responsibility number 2"
//                        )
//                    ),
//                    WorkExperience(
//                        "Title",
//                        "Nov 2020 - Dec 2023",
//                        listOf(
//                            "Responsibility number 1",
//                            "Long Responsibility number two long Responsibility number 2"
//                        )
//                    )
//                )
//            )
//        )
//    }
//}