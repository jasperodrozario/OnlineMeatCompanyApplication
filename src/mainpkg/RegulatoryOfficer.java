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
 * @author Jasper
 */
public class RegulatoryOfficer extends Employee {
    
    public RegulatoryOfficer(String userType, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj, String phoneNumber) {
        this.userType = userType;
        this.userId = RegulatoryOfficer.generateUniqueUserId();
        this.userName = userName;
        this.password = password;
        this.userDob = userDob;
        this.gender = gender;
        this.userDoj = userDoj;
        this.phoneNumber = phoneNumber;
    };
    
    public static int generateUniqueUserId() {
        int newId;
        
        if(RegulatoryOfficer.getLastUserInstance() != null) {
            newId = RegulatoryOfficer.getLastUserInstance().userId + 1;
            return newId;
        }
        else {
            return newId = 10000;
        }
    }
    
    public static RegulatoryOfficer getLastUserInstance() {
        RegulatoryOfficer lastInst = null;
        File orderFile = new File("RegulatoryOfficerUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(orderFile.exists()) {
            try {            
                fis = new FileInputStream(orderFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    try {
                        lastInst = (RegulatoryOfficer)ois.readObject();
                    }
                    catch (EOFException eof) {
                        // End of file reached
                        return lastInst;
                    }
                }
            }
            catch(FileNotFoundException e) {
                anAlert.setContentText("'RegulatoryOfficerUser.bin' file not found!");
                anAlert.show();
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in 'RegulatoryOfficerUser.bin' file!");
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
    
//    public viewVaccinationReport() {
//        
//    }
    
    public static boolean submitPolicy(String policy){
        Policy newPolicy = new Policy(policy);
        return newPolicy.addPolicy(policy);
    }
    
}
