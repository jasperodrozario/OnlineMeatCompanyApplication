/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;
import javafx.scene.control.Alert;


public class AuditReportEditAccountant {
    static Alert anAlert = new Alert(Alert.AlertType.ERROR);
    
    public static boolean addReport(String auditReportStr, LocalDate curDate){
        String newFileName = "AuditReport" + curDate + ".txt";
        File f1 = null;
        
        try{
            f1 = new File(newFileName);
            FileWriter fw = new FileWriter(f1);
            fw.write(auditReportStr);
            fw.close();
            return true;
        }
        catch(IOException e){
            return false;
        }
    }
    
    
}
