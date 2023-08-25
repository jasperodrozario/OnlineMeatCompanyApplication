/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jasper
 */
public class Vaccine implements Serializable {
    int vendorId;
    String vendorName;
    String vaccineName;
    LocalDate vaccinationDate;
    
    public Vaccine(int vendorId, String vendorName, String vaccineName, LocalDate vaccinationDate) {
        this.vendorId = vendorId;
        this.vendorName = vendorName;
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
    
    public static ObservableList<Vaccine> getAllVaccineUpdates() {
        ObservableList<Vaccine> vaccineList = FXCollections.observableArrayList();
        Vaccine tempInst;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try{
            File f1 = new File("VaccinationUpdates.bin");
            fis = new FileInputStream(f1);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Vaccine)ois.readObject();
                vaccineList.add(tempInst);
            }
        }
        catch(IOException e) { 
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(ois != null) {
                    ois.close();
                }
            }
            catch(IOException e) {
            }
            return vaccineList;
        }
    }
    
    

    public int getVendorId() {
        return vendorId;
    }

    public String getVendorName() {
        return vendorName;
    }

    public String getVaccineName() {
        return vaccineName;
    }

    public LocalDate getVaccinationDate() {
        return vaccinationDate;
    }
    
}
