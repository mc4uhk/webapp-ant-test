import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

public class HelloWorld {
	public static void main(String[] args) {
		System.out.println("Hello World!!!");
		PrintService ps0 = PrintServiceLookup.lookupDefaultPrintService();
		DocFlavor f[] = ps0.getSupportedDocFlavors();
		for (int i = 0; i < f.length; i++) {
			System.out.println("MIME Type:" + f[i].getMimeType());
			System.out.println("Media Subtype:" + f[i].getMediaSubtype());
			System.out.println("Media Type:" + f[i].getMediaType());
			System.out.println("--------------------------------------");
		}
	}
}
