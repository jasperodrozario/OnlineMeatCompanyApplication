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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author DELL
 */
public class FarmCostVendor implements Serializable {
    
    String month;
    int cost;

    public FarmCostVendor(String month, int cost) {
        this.month = month;
        this.cost = cost;
    }

    public String getMonth() {
        return month;
    }

    public int getCost() {
        return cost;
    }
    
    public boolean addFarmCost() {
        
        File farmCostFile = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            farmCostFile = new File("MonthlyFarmCost.bin");
            if(farmCostFile.exists()) {
                fos = new FileOutputStream(farmCostFile, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(farmCostFile);
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
    
    
    public static ObservableList<FarmCostVendor> getFarmCostUpdates() {
        ObservableList<FarmCostVendor> farmCost = FXCollections.observableArrayList();
        FarmCostVendor tempInst;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try{
            File f1 = new File("MonthlyFarmCost.bin");
            fis = new FileInputStream(f1);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (FarmCostVendor)ois.readObject();
                farmCost.add(tempInst);
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
            return farmCost;
        }
    }
    
}
