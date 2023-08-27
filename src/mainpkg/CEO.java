package mainpkg;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import javafx.scene.control.Alert;

/**
 *
 * @author Jasper
 */
public class CEO extends Employee{
    static Alert anAlert = new Alert(Alert.AlertType.ERROR);
    
    public CEO(String userType, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj, String phoneNumber) {
        this.userType = userType;
        this.userId = CEO.generateUniqueUserId();
        this.userName = userName;
        this.password = password;
        this.userDob = userDob;
        this.gender = gender;
        this.userDoj = userDoj;
        this.phoneNumber = phoneNumber;
    };
    
    public static int generateUniqueUserId() {
        int newId;
        
        if(CEO.getLastUserInstance() != null) {
            newId = CEO.getLastUserInstance().userId + 1;
            return newId;
        }
        else {
            return newId = 10000;
        }
    }
    
    public static CEO getLastUserInstance() {
        CEO lastInst = null;
        File userFile = new File("CEOUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(userFile.exists()) {
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    try {
                        lastInst = (CEO)ois.readObject();
                    }
                    catch (EOFException eof) {
                        // End of file reached
                        return lastInst;
                    }
                }
            }
            catch(FileNotFoundException e) {
                anAlert.setContentText("'CEOUser.bin' file not found!");
                anAlert.show();
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in 'CEOUser.bin' file!");
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
    
    public static boolean addPartners(String partnerName, String compName) {
        Partners newPartner = new Partners(partnerName, compName);
        File f1 = new File("Partners.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if (f1.exists()) {
                fos = new FileOutputStream(f1, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(f1);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newPartner);
            oos.close();
            return true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                if(oos != null) oos.close();
            } 
            catch (IOException e) {
            }
        }  
    }
    
    public static boolean addInvestors(String investorName, String address) {
        Investor newInvestor = new Investor(investorName, address);
        File f1 = new File("Investor.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            if (f1.exists()) {
                fos = new FileOutputStream(f1, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(f1);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newInvestor);
            oos.close();
            return true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                if(oos != null) oos.close();
            } 
            catch (IOException e) {
            }
        }
    }
}
