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
public class Investor implements Serializable{
    String address;
    String investorsName;

    public Investor(String investorsName, String address) {
        this.address = address;
        this.investorsName = investorsName;
    }

    public String getAddress() {
        return address;
    }

    public String getInvestorsName() {
        return investorsName;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setInvestorsName(String investorsName) {
        this.investorsName = investorsName;
    }
    
    
    public static ObservableList<Investor> getAllInvestors() {
        ObservableList<Investor> investorsList = FXCollections.observableArrayList();
        Investor tempInst = null;
        File userFile = new File("Investor.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Investor)ois.readObject();
                investorsList.add(tempInst);
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'Investor.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'Investor.bin' file!");
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
            return investorsList;
        }
    }
    
}
