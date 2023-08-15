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
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author Jasper
 */
public class Vaccine implements Serializable {
    String vaccineName;
    LocalDate vaccinationDate;
    
    public Vaccine(String vaccineName, LocalDate vaccinationDate) {
        this.vaccineName = vaccineName;
        this.vaccinationDate = vaccinationDate;
    }
    
    public boolean addVaccine() {
        
        File vaccinationUpdateFile = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            vaccinationUpdateFile = new File("VaccinationUpdates.bin");
            if(vaccinationUpdateFile.exists()) {
                fos = new FileOutputStream(vaccinationUpdateFile, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(vaccinationUpdateFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);
            return true;
        }
        catch (FileNotFoundException e) {
            return false;
        }
        catch(IOException e) {
            return false;
        }
        finally {
            try {
                if(oos != null) oos.close();
            }
            catch(IOException e) {
            }
        }
    }
    
}
