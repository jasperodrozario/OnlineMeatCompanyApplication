package mainpkg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import javafx.scene.control.Alert;

/**
 *
 * @author DELL
 */

public class QuotationReport {
    static Alert anAlert = new Alert(Alert.AlertType.ERROR);
    
    public static boolean addReport(String quotationReportStr){
        String newFileName = "QuotationReport.bin";
        File f1 = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try{
            f1 = new File(newFileName);
            fos = new FileOutputStream(f1);
            dos = new DataOutputStream(fos);
            dos.writeUTF(quotationReportStr);
            dos.close();
            return true;
        }
        catch(IOException e){
            return false;
        }
    }
}
