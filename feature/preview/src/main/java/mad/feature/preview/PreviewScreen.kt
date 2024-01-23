package mad.feature.preview

import android.graphics.Bitmap
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import mad.core.designsystem.component.CvForgeCircularProgress
import mad.core.model.template.CvForgeTemplate
import mad.core.model.template.state.TemplateUiState
import mad.core.pdf.CaptureBitmap
import mad.core.pdf.createPdfDocument
import mad.feature.preview.ui.template.template_list.TemplateBuilder

@Composable
fun PreviewRoute(
    modifier: Modifier = Modifier,
    viewModel: PreviewViewModel = hiltViewModel()
) {
    val state by viewModel.templateUiState.collectAsStateWithLifecycle()
    PreviewScreen(
        templateUiState= state,
        modifier = modifier
    )
}

@Composable
fun PreviewScreen(
    templateUiState: TemplateUiState,
    modifier: Modifier = Modifier
) {
    when(templateUiState){
        TemplateUiState.Loading -> CvForgeCircularProgress()
        is TemplateUiState.Success -> PreviewScreenLayout(templateUiState.template)
    }
}

@Composable
fun PreviewScreenLayout(
    template: CvForgeTemplate,
    modifier: Modifier = Modifier
) {
    val context = LocalContext.current
    Box(modifier = modifier.fillMaxWidth()) {
        var bitmap = Bitmap.createBitmap(300, 200, Bitmap.Config.ARGB_8888)
        val capture = CaptureBitmap(
            captureRequestKey = "capture",
            content = { TemplateBuilder(state = template) },
//            onBitmapCaptured = { bitmap = it })
            onBitmapCaptured = { createPdfDocument(context, it) })

//        ElevatedButton(onClick = { createPdfDocument(context,bitmap) },
        ElevatedButton(
            onClick = { capture.invoke() },
            modifier = Modifier
                .align(Alignment.BottomCenter)
                .padding(bottom = 16.dp)
        ) {
            Text(text = "Save")
        }
    }
}