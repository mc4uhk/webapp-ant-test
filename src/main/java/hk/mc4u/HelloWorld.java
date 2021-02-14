package hk.mc4u;
import javax.print.DocFlavor;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HelloWorld {
	private static final Logger logger = LoggerFactory.getLogger(HelloWorld.class);
	
	public static void main(String[] args) {
		logger.info("Hello World!!!");
		PrintService ps0 = PrintServiceLookup.lookupDefaultPrintService();
		DocFlavor f[] = ps0.getSupportedDocFlavors();
		for (int i = 0; i < f.length; i++) {
			logger.info("MIME Type:" + f[i].getMimeType());
			logger.info("Media Subtype:" + f[i].getMediaSubtype());
			logger.info("Media Type:" + f[i].getMediaType());
			logger.info("--------------------------------------");
		}
	}
}
