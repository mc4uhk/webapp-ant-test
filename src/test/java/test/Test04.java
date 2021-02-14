package test;
import org.junit.jupiter.api.Test;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.geom.PageSize;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfReader;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.kernel.pdf.canvas.PdfCanvas;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Paragraph;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class Test04 {
	/* Reference:
	 * Chapter 5: Manipulating an existing PDF document
	https://kb.itextpdf.com/home/it7kb/ebooks/itext-7-jump-start-tutorial-for-java/chapter-5-manipulating-an-existing-pdf-document
	 */
	public void createPdf(String dest) throws Exception {
        //Initialize PDF writer
        PdfWriter writer = new PdfWriter(dest);

        //Initialize PDF document
        PdfDocument pdf = new PdfDocument(writer);
        pdf.setDefaultPageSize(PageSize.A4);
        
        // Initialize document
        Document document = new Document(pdf);
        //Add paragraph to the document
        document.add(new Paragraph("Hello World!"));
        
        
        PdfCanvas canvas = new PdfCanvas(pdf.getFirstPage());
        for(int x=0; x<=550 ; x+=50) {
            for(int y=0; y<=800 ; y+=50) {
            	
        canvas.beginText().setFontAndSize(
                PdfFontFactory.createFont(FontConstants.HELVETICA), 12)
                .moveText(x, y)
                .showText(String.format("%d,%d", x,y))
                .endText();
            }        
        }
        //Close document
        document.close();
    }

	//@Test
	public void test01() throws Exception {
		createPdf("/home/edmund/temp/temp.pdf");
	}

	@Test
	public void test02() throws Exception {
		modifyPdf("/home/edmund/temp/temp.pdf", "/home/edmund/temp/temp01.pdf");
	}

	public void modifyPdf(String src, String dest) throws Exception {

        PdfDocument pdf =
        	    new PdfDocument(new PdfReader(src), new PdfWriter(dest));
        //Initialize PDF document
        pdf.setDefaultPageSize(PageSize.A4);
        
        // Initialize document
        Document document = new Document(pdf);
        //Add paragraph to the document
        document.add(new Paragraph("Hello World!"));
        
        
        PdfCanvas canvas = new PdfCanvas(pdf.getFirstPage());
        for(int x=0; x<=550 ; x+=50) {
            for(int y=25; y<=800 ; y+=50) {
            	
        canvas.beginText().setFontAndSize(
                PdfFontFactory.createFont(FontConstants.HELVETICA), 9)
                .moveText(x, y)
                .showText(String.format("(%d,%d)", x,y))
                .endText();
            }        
        }
        //Close document
        document.close();
    }	
}
