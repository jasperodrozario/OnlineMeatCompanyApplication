/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import javafx.scene.control.Alert;

/**
 *
 * @author DELL
 */
public class VaccineUpdate {
    static Alert anAlert = new Alert(Alert.AlertType.ERROR);
    
    public static boolean addVaccine(String vaccineNameTextField, LocalDate dateTextField) throws FileNotFoundException, IOException{
        
        File f1 = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        try{
            f1 = new File("VaccinationUpdate.bin");
            if (f1.exists()) {
                    fos = new FileOutputStream(f1, true);
                    oos = new AppendObjectOutputStream(fos);
            }
            else{
                fos = new FileOutputStream(f1);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(f1);
            oos.close();
            return true;
        }
        catch(IOException e){
            return false;
        }
   }
}
