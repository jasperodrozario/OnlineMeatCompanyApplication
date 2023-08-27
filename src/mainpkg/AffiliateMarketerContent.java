package mainpkg;

import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileOutputStream;
import java.util.Optional;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.FileChooser;

/**
 *
 * @author Jasper
 */
public class AffiliateMarketerContent {
    public static boolean writeContent(int affiliateMarketerId, String pdfTitle, String contentStr) {
        try{
            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
            File f = new File("AffiliateMarketer_Content/" + affiliateMarketerId + "_" + pdfTitle + ".pdf");
            if(f!=null){              
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                PdfDocument pdf =  new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(70);
                
                //For adding Paragraph to the pdf
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);
                
                String paraText = contentStr;
                Paragraph para1 = new Paragraph(paraText);
                
                Text titleText = new Text(pdfTitle);
                titleText.setFontSize(18f);
                Paragraph pageTitle = new Paragraph(titleText);
                pageTitle.setBold();
                
                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                
                //adding an image
                Alert aConfAlert = new Alert(Alert.AlertType.CONFIRMATION);
                aConfAlert.setContentText("Add Image to the pdf?");
                Optional<ButtonType> result = aConfAlert.showAndWait();
                if(result.get() == ButtonType.OK){
                    File imageFile = fc.showOpenDialog(null);
                    String imagePath = imageFile.getAbsolutePath();
                    ImageData data = ImageDataFactory.create(imagePath);
                    Image image = new Image(data);  
                    image.setAutoScale(true);
                    
                    doc.add(image);
                    doc.add(lineSpace);
                    aConfAlert = new Alert(Alert.AlertType.INFORMATION);
                    aConfAlert.setContentText("Image added successfully");
                    aConfAlert.showAndWait();
                }
                
                doc.close();
                return true;
            }
            else{
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Content creation cancelled");
                a.showAndWait();
                return false;
            }
        }
        catch(Exception e){
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Exception: " + e.toString()+ " occured.");
            a.showAndWait(); 
            return false;
        } 
    }
}
