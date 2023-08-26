package mainpkg;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.time.LocalDate;
import static mainpkg.Database.anAlert;

/**
 *
 * @author DELL
 */

public class Vendor extends Employee {
    public Vendor(String userType, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj, String phoneNumber) {
        this.userType = userType;
        this.userId = Vendor.generateUniqueUserId();
        this.userName = userName;
        this.password = password;
        this.userDob = userDob;
        this.gender = gender;
        this.userDoj = userDoj;
        this.phoneNumber = phoneNumber;
    };
    
    public static int generateUniqueUserId() {
        int newId;
        
        if(Vendor.getLastUserInstance() != null) {
            newId = Vendor.getLastUserInstance().userId + 1;
            return newId;
        }
        else {
            return newId = 10000;
        }
    }
    
    public static Vendor getLastUserInstance() {
        Vendor lastInst = null;
        File userFile = new File("VendorUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(userFile.exists()) {
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    try {
                        lastInst = (Vendor)ois.readObject();
                    }
                    catch (EOFException eof) {
                        // End of file reached
                        return lastInst;
                    }
                }
            }
            catch(FileNotFoundException e) {
                anAlert.setContentText("'VendorUser.bin' file not found!");
                anAlert.show();
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in 'VendorUser.bin' file!");
                anAlert.show();
            }
            catch(IOException e) {
            }
            finally {
                try {
                    if(ois != null) ois.close();
                }
                catch(IOException e) {
                }
                return lastInst;
            }
        }
        else {
            return lastInst;
        }
    }
    
    @Override
    public boolean applyForLeave() {
        return true;
    }
    
    @Override
    public boolean login() { 
        LoggedUserInstance.logUserInstance(userType, userId);
        return true;
    }
    
    @Override
    public boolean changePassword() {
        return true;
    }
    
    public boolean updateVaccineStatus(String vaccineName, LocalDate vaccinationDate) {
        Vaccine newVaccine = new Vaccine(userId, userName, vaccineName, vaccinationDate);
        return newVaccine.addVaccine();
    }
    
    
    public boolean updateFarmCost(String month, int cost){
        FarmCostVendor newCost = new FarmCostVendor(month,cost);
        return newCost.addFarmCost();
    }
    
    public boolean updateTransaction(String product, int amount, int price, LocalDate date){
        TransactionVendor newTrans = new TransactionVendor(product,amount,price,date);
        return newTrans.addTransactionReport();
    }
    
}
