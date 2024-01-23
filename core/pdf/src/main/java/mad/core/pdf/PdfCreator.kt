package mad.core.pdf

import android.content.Context
import android.graphics.Bitmap
import android.graphics.pdf.PdfDocument
import java.io.File

fun createPdfDocument(context: Context, bitmap: Bitmap): PdfDocument {
    // Create a new PDF document.
    val pdfDocument = PdfDocument()

    // Create a new Compose view that contains the screen you want to add.


    // Render the Compose view to a bitmap.

    val pageInfo = PdfDocument.PageInfo.Builder(2480, 3508, 1).create()

    // Add the bitmap to the PDF document.
    val page = pdfDocument.startPage(pageInfo)
    page.canvas.drawBitmap(bitmap, 0f, 0f, null)
    pdfDocument.finishPage(page)

    // Save the PDF document.
//    val outputFile = File("output.pdf")
//    pdfDocument.writeTo(outputFile.outputStream())
//    pdfDocument.close()

    //share
    return pdfDocument
}