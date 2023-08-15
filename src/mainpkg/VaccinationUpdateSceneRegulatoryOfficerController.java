package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class VaccinationUpdateSceneRegulatoryOfficerController implements Initializable {

    @FXML
    private TextArea vaccineUpdateDisplayTA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewVaccineUpdatesBtnOnClick(ActionEvent event) {
//        Vaccine tempInst;
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        String dispStr = "";
//        try{
//            File f1 = new File("VaccinationUpdates.bin");
//            fis = new FileInputStream(f1);
//            ois = new ObjectInputStream(fis);
//            while(true) {
//                tempInst = (VaccinationUpdate)ois.readObject();
//                dispStr += "Vaccine Name: " + tempInst.vaccineName + ", Vaccination Date: " + tempInst.vaccinationDate + "\n";
//            }
//        }
//        catch(IOException e) { 
//        }
//        catch(ClassNotFoundException e) {
//        }
//        finally {
//            vaccineUpdateDisplayTA.setText(dispStr);
//            try {
//                if(ois != null) {
//                    ois.close();
//                }
//            }
//            catch(IOException e) {
//            }
//        }
    }
    
}
