import java.io.IOException; 
import org.apache.pdfbox.pdmodel.PDDocument;
  
public class Pdf {
    
   public static void main (String args[]) throws IOException {
       
      //Creating PDF document object 
      PDDocument document = new PDDocument();    
       
      //Saving the document
      document.save("C:/PdfBox_Examples/my_doc.pdf");
         
      System.out.println("PDF created");  
    
      //Closing the document  
      document.close();

   }  
}