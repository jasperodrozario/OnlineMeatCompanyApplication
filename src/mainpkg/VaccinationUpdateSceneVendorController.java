/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
    private DatePicker dateTextField;

    /**
     * Initializes the controller class.
     */
    
    
    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);
    boolean vaccineStatus;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void vaccineNameAddOnClick(ActionEvent event) throws IOException {
        
        vaccineStatus = VaccineUpdate.addVaccine(vaccineNameTextField.getText(), dateTextField.getValue());
        
        if (vaccineStatus){
            
            anAlert.setContentText("Vaccine update Successfully!");
            anAlert.show();
        }
        else{
            anAlert.setContentText("Oops! Something went wrong. Try Again.");
            anAlert.show();
        }
        
    }
    
}
