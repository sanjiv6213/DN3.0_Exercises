package FactoryMethodPattern;

public class FactoryMethodTest {
	// FactoryMethodPatternExample.java
	
	    public static void main(String[] args) {
	        DocumentFactory wordFactory = new WordDocumentFactory();
	        Document wordDocument = wordFactory.createDocument();
	        wordDocument.open();
	        wordDocument.close();

	        DocumentFactory pdfFactory = new PdfDocumentFactory();
	        Document pdfDocument = pdfFactory.createDocument();
	        pdfDocument.open();
	        pdfDocument.close();

	        DocumentFactory excelFactory = new ExcelDocumentFactory();
	        Document excelDocument = excelFactory.createDocument();
	        excelDocument.open();
	        excelDocument.close();
	    }
	}

