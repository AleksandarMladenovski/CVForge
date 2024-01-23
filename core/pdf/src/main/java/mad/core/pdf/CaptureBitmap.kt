package mad.core.pdf

import android.graphics.Bitmap
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.viewinterop.AndroidView
import androidx.core.view.drawToBitmap

@Composable
fun CaptureBitmap(
    captureRequestKey: String,
    content: @Composable () -> Unit,
    onBitmapCaptured: (Bitmap) -> Unit
): () -> Unit {

    val context = LocalContext.current

    /**
     * ComposeView that would take composable as its content
     * Kept in remember so recomposition doesn't re-initialize it
     **/
    val composeView = remember { ComposeView(context) }

//    LaunchedEffect(captureRequestKey) {
//        composeView.post {
//            val bitmap = Bitmap.createScaledBitmap(composeView.drawToBitmap(), 2480, 3508, true)
//            onBitmapCaptured.invoke(bitmap)
//        }
//    }

    /** Use Native View inside Composable **/
    AndroidView(
        factory = {
            composeView.apply {
                setContent {
                    content.invoke()
                }
            }
        }
    )
    return {
        composeView.post {
            val bitmap = Bitmap.createScaledBitmap(composeView.drawToBitmap(), 2480, 3508, true)
            onBitmapCaptured.invoke(bitmap)
        }

    }
}