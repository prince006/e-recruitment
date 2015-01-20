package utility;
import java.io.FileOutputStream;
import java.io.IOException;
 
import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.pdf.draw.LineSeparator;
 
public class FontTypes {
 
    /** The resulting PDF file. */
    public static String RESULT
        = "D:\\font_types.pdf";
    /** Some text. */
    public static String TEXT
        = "quick brown fox jumps over the lazy dog\nQUICK BROWN FOX JUMPS OVER THE LAZY DOG";
 
    /** Paths to and encodings of fonts we're going to use in this example */
//    public static String[][] FONTS = {
//        {BaseFont.HELVETICA, BaseFont.WINANSI},
////        {"resources/fonts/cmr10.afm", BaseFont.WINANSI},
////        {"resources/fonts/cmr10.pfm", BaseFont.WINANSI},
//        //{"c:/windows/fonts/ARBLI__.TTF", BaseFont.WINANSI},
//        {"c:/windows/fonts/arial.ttf", BaseFont.WINANSI},
//        {"c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H},
//    //    {"resources/fonts/Puritan2.otf", BaseFont.WINANSI},
//        {"c:/windows/fonts/msgothic.ttc,0", BaseFont.IDENTITY_H},
//     //   {"KozMinPro-Regular", "UniJIS-UCS2-H"}
//    };
// 
//    /**
//     * Creates a PDF document.
//     * @param filename the path to the new PDF document
//     * @throws    DocumentException 
//     * @throws    IOException
//     */
   public void createPdf(String filename) throws IOException, DocumentException {
    	// step 1
        Document document = new Document();
        // step 2
        PdfWriter.getInstance(document, new FileOutputStream(filename));
        // step 3
        document.open();
        // step 4
        BaseFont bf;
        Font font;
     
            bf = BaseFont.createFont("c:/windows/fonts/arial.ttf", BaseFont.IDENTITY_H, BaseFont.EMBEDDED);          
            font = new Font(bf, 22);
            document.add(new Paragraph(TEXT, font));
            document.add(new LineSeparator(0.5f, 100, null, 0, -5));
     
        // step 5
        document.close();
    }
 
    /**
     * Main method.
     *
     * @param    args    no arguments needed
     * @throws DocumentException 
     * @throws IOException
     */
    public static void main(String[] args) throws IOException, DocumentException {
        new FontTypes().createPdf(RESULT);
    }
}