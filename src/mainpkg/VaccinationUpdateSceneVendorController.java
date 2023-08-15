/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import static mainpkg.Database.anAlert;

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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void addVaccineUpdateOnClick(ActionEvent event) {
        if(Vendor.updateVaccineStatus(vaccineNameTextField.getText(), vaccinationDatePicker.getValue())) {
            anAlert.setContentText("Vaccine status successfully updated!");
            anAlert.show();
        }
        else {
            anAlert.setContentText("Oops! Couldn't update vaccine status. Try again.");
            anAlert.show();
        }
    }
    
}
