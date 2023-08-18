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

public class Rider extends Employee {
    
    String TimeSlot;
    
    public Rider(String userType, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj) {
        this.userType = userType;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userDob = userDob;
        this.gender = gender;
        this.userDoj = userDoj;
    };
    
    public static int generateUniqueUserId() {
        int newId;
        
        if(Rider.getLastUserInstance() != null) {
            newId = Rider.getLastUserInstance().userId + 1;
            return newId;
        }
        else {
            return newId = 10000;
        }
    }
    
    public static Rider getLastUserInstance() {
        Rider lastInst = null;
        File userFile = new File("RiderUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(userFile.exists()) {
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    try {
                        lastInst = (Rider)ois.readObject();
                    }
                    catch (EOFException eof) {
                        // End of file reached
                        return lastInst;
                    }
                }
            }
            catch(FileNotFoundException e) {
                anAlert.setContentText("'RiderUser.bin' file not found!");
                anAlert.show();
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in 'RiderUser.bin' file!");
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
