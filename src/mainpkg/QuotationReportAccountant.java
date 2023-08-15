/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import javafx.scene.control.Alert;

/**
 *
 * @author DELL
 */
public class QuotationReportAccountant {
    static Alert anAlert = new Alert(Alert.AlertType.ERROR);
    
    public static boolean addReport(String quotationReportStr){
        String newFileName = "QuotatioReportAccountant.txt";
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
