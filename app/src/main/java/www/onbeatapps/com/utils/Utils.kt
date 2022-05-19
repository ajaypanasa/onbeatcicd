package www.onbeatapps.com.utils

import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.graphics.*
import android.graphics.pdf.PdfDocument
import android.os.Environment
import android.widget.Toast
import androidx.core.content.ContextCompat
//import me.kariot.invoicegenerator.data.*
//import me.kariot.invoicegenerator.utils.InvoiceGenerator
import www.onbeatapps.com.R
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.text.SimpleDateFormat


class Utils {
    companion object{

        var pageHeight = 1120
        var pagewidth = 792

        fun dateConvert(date: String): String {
            val strDate = date
            val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSSXXX")//"yyyy-MM-dd'T'HH:mm:ss.SSS'Z'"
            val output = SimpleDateFormat("dd.MM.yyyy hh:mm aa")
            val date = dateFormat.parse(strDate)
            val data1 = output.format(date)
            return data1.toString()
        }

        fun createPDF(
            context: Context,
            name: String,
            phone: String,
            email: String,
            eventName: String
        ){
            var bmp = BitmapFactory.decodeResource(context.resources, R.drawable.logo_)
            val width = bmp.width
            val height = bmp.height
            var scaledbmp = Bitmap.createScaledBitmap(bmp, width, height, false)
            val pdfDocument = PdfDocument()


            val paint = Paint()
            val line = Paint()
            val title = Paint()
            val content = Paint()

            val mypageInfo = PdfDocument.PageInfo.Builder(pagewidth, pageHeight, 1).create()

            val myPage = pdfDocument.startPage(mypageInfo)
            val canvas = myPage.canvas
            canvas.drawBitmap(scaledbmp, 56F, 40F, paint)
            title.typeface = Typeface.create(Typeface.DEFAULT_BOLD, Typeface.BOLD)
            title.textSize = 30F
            title.color = ContextCompat.getColor(context, R.color.black);

            canvas.drawText(eventName, 230F, 100F, title);
            canvas.drawText("pkb1", 230F, 70F, title);

            // similarly we are creating another text and in this
            // we are aligning this text to center of our PDF file.
            title.typeface = Typeface.defaultFromStyle(Typeface.NORMAL)
            title.color = ContextCompat.getColor(context, R.color.black)
            title.textSize = 15F;


            // below line is used for setting
            // our text to center of PDF.
            title.textAlign = Paint.Align.CENTER;
            canvas.drawText("This is sample document which we have created.", 396F, 560F, title);

            // after adding all attributes to our
            // PDF file we will be finishing our page.
            pdfDocument.finishPage(myPage);

            val file = File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS), "GFG.pdf")
            file.createNewFile()
            try {
                // after creating a file name we will
                // write our PDF file to that location.
                pdfDocument.writeTo(FileOutputStream(file))

                // below line is to print toast message
                // on completion of PDF generation.
                Toast.makeText(
                    context,
                    "PDF file generated successfully.",
                    Toast.LENGTH_SHORT
                ).show()
            } catch (e: IOException) {
                // below line is used
                // to handle error
                e.printStackTrace()
            }
            // after storing our pdf to that
            // location we are closing our PDF file.
            // after storing our pdf to that
            // location we are closing our PDF file.
            pdfDocument.close()
        }


//         fun createPDFFile(
//             context: Context,
//             name: String,
//             phone: String,
//             email: String,
//             eventName: String,
//             total: String,
//             currency: String
//         ) {
//
////            if (!isUIValid()) return
//
//            //data for invoice header
//            val invoiceAddress =
//                ModelInvoiceHeader.ModelAddress(
//                   "",
//                   "",
//                    ""
//                )
//            val headerData = ModelInvoiceHeader(
//                name,
//                email,
//                phone, invoiceAddress
//
//            )
//            //data for invoice
//            val customerInfo =
//                ModelInvoiceInfo.ModelCustomerInfo(
//                    "",
//                   "",
//                    "",
//                    ""
//                )
//            val invoiceInfo = ModelInvoiceInfo(
//                customerInfo,
//                "",
//                "",
//                total
//            )
//            val tableHeader =
//                ModelTableHeader(
//                    "Shope Name",
//                    "Date",
//                    "Price"
//                )
//            val tableData = ModelInvoiceItem(
//                "pkb Stations",
//                "Beear",
//                "10/04/2022",
//                "$20"
//            )
//            val invoicePriceInfo = ModelInvoicePriceInfo(
//
//                total
//            )
//            val footerData = ModelInvoiceFooter("*********OnBeat8888888888")
//            val pdfGenerator = InvoiceGenerator(context).apply {
//                setInvoiceLogo(me.kariot.invoicegenerator.R.drawable.logo_)
//                setCurrency(currency)
//                setInvoiceColor("#51AADF")
//                setInvoiceHeaderData(headerData)
//                setInvoiceInfo(invoiceInfo)
//                setInvoiceTableHeaderDataSource(tableHeader)
//                setInvoiceTableData(
//                    mutableListOf(
//                        tableData,
//                        tableData,
//                        tableData,
//                        tableData,
//                        tableData,
//                        tableData
//                    ) as List<ModelInvoiceItem>
//                )
//                setPriceInfoData(invoicePriceInfo)
//                setInvoiceFooterData(footerData)
//            }
//
//            val fileUri = pdfGenerator.generatePDF("${(0..99999).random()}.pdf")
////            try {
////                val intent = Intent(Intent.ACTION_VIEW)
////                intent.setDataAndType(fileUri, "application/pdf")
////                intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION)
////                context.startActivity(intent)
////            } catch (e: ActivityNotFoundException) {
////                e.printStackTrace()
////                Toast.makeText(context, "There is no PDF Viewer", Toast.LENGTH_SHORT).show()
////            }
//        }
    }
}