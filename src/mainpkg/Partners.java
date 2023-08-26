package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import static mainpkg.Database.anAlert;

/**
 *
 * @author Dell
 */

public class Partners implements Serializable{
    String companyName;
    String partnerName;

    public Partners(String partnerName, String companyName) {
        this.companyName = companyName;
        this.partnerName = partnerName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getPartnerName() {
        return partnerName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public void setPartnerName(String partnerName) {
        this.partnerName = partnerName;
    }
    
    public static ObservableList<Partners> getAllPartners() {
        ObservableList<Partners> partnersList = FXCollections.observableArrayList();
        Partners tempInst = null;
        File userFile = new File("Partners.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Partners)ois.readObject();
                partnersList.add(tempInst);
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'Partners.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'Partners.bin' file!");
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
            return partnersList;
        }
    }
    
}
