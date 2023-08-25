package mainpkg;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DELL
 */

public class VaccinationUpdateSceneVendorController implements Initializable {

    @FXML
    private TextField vaccineNameTextField;
    
    @FXML
    private DatePicker vaccinationDatePicker;
    
    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);
    Vendor loggedUserInst = LoggedUserInstance.vendorInst;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addVaccineUpdateOnClick(ActionEvent event) {
        if(loggedUserInst.updateVaccineStatus(vaccineNameTextField.getText(), vaccinationDatePicker.getValue())) {
            anAlert.setContentText("Vaccine status successfully updated!");
            anAlert.show();
        }
        else {
            anAlert.setContentText("Oops! Couldn't update vaccine status. Try again.");
            anAlert.show();
        }
    }
    
}
