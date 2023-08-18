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
public class CEO extends Employee{
    
    public CEO(String userType, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj) {
        this.userType = userType;
        this.userId = CEO.generateUniqueUserId();
        this.userName = userName;
        this.password = password;
        this.userDob = userDob;
        this.gender = gender;
        this.userDoj = userDoj;
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
    
}
