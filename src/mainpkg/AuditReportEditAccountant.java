package mainpkg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import javafx.scene.control.Alert;


public class AuditReportEditAccountant {
    static Alert anAlert = new Alert(Alert.AlertType.ERROR);
    
    public static boolean addReport(String auditReportStr, LocalDate curDate){
        String newFileName = "AuditReport" + curDate + ".bin";
        File f1 = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try{
            f1 = new File(newFileName);
            fos = new FileOutputStream(f1);
            dos = new DataOutputStream(fos);
            dos.writeUTF(auditReportStr);
            dos.close();
            return true;
        }
        catch(IOException e){
            return false;
        }
    }
    
    
}
