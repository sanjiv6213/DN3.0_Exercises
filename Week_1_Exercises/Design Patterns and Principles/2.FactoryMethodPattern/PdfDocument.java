package FactoryMethodPattern;

public class PdfDocument implements Document{
	    @Override
	    public void open() {
	        System.out.println("Opening Pdf Document");
	    }

	    @Override
	    public void close() {
	        System.out.println("Closing Pdf Document");
	    }
}
