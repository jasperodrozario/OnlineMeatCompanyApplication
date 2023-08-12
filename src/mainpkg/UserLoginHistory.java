package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.time.LocalTime;


/**
 *
 * @author Jasper
 */

public class UserLoginHistory<classType> {
    LocalTime now;
    LocalDate today;
    classType userInst;
    
    public UserLoginHistory(classType userInst) {
        this.userInst = userInst;
        
        File thisFile = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            thisFile = new File("UserLoginHistory.bin");
            if (thisFile.exists()) {
                fos = new FileOutputStream(thisFile, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(thisFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(userInst);
            oos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
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
