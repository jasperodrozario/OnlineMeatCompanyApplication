package mainpkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;

/**
 *
 * @author DELL
 */
public class QuotationReport {
    static Alert anAlert = new Alert(Alert.AlertType.ERROR);
    
    public static boolean addReport(String quotationReportStr){
        String newFileName = "QuotationReportAccountant.txt";
        File f1 = null;
        
        try{
            f1 = new File(newFileName);
            FileWriter fw = new FileWriter(f1);
            fw.write(quotationReportStr);
            fw.close();
            return true;
        }
        catch(IOException e){
            return false;
        }
    }
}
