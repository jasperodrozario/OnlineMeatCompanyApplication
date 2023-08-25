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

public class AffiliateMarketer extends Employee {
    
    public AffiliateMarketer(String userType, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj, String phoneNumber) {
        this.userType = userType;
        this.userId = AffiliateMarketer.generateUniqueUserId();
        this.userName = userName;
        this.password = password;
        this.userDob = userDob;
        this.gender = gender;
        this.userDoj = userDoj;
        this.phoneNumber = phoneNumber;
    };
    
    public static int generateUniqueUserId() {
        int newId;
        
        if(AffiliateMarketer.getLastUserInstance() != null) {
            newId = AffiliateMarketer.getLastUserInstance().userId + 1;
            return newId;
        }
        else {
            return newId = 10000;
        }
    }
    
    public static AffiliateMarketer getLastUserInstance() {
        AffiliateMarketer lastInst = null;
        File userFile = new File("AffiliateMarketerUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(userFile.exists()) {
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    try {
                        lastInst = (AffiliateMarketer)ois.readObject();
                    }
                    catch (EOFException eof) {
                        // End of file reached
                        return lastInst;
                    }
                }
            }
            catch(FileNotFoundException e) {
                anAlert.setContentText("'AffiliateMarketerUser.bin' file not found!");
                anAlert.show();
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in 'AffiliateMarketerUser.bin' file!");
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
}
