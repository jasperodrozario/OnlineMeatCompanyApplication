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
        
        File vaccinationUpdateFile = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            VaccinationUpdate newVaccinationUpdate = new VaccinationUpdate(vaccineNameTextField.getText(), vaccinationDatePicker.getValue());
            vaccinationUpdateFile = new File("VaccinationUpdate.bin");
            if(vaccinationUpdateFile.exists()) {
                fos = new FileOutputStream(vaccinationUpdateFile, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(vaccinationUpdateFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newVaccinationUpdate);
            oos.close();
            anAlert.setContentText("Vaccine update Successfully!");
            anAlert.show();
        }
        catch (FileNotFoundException e) {
            anAlert.setAlertType(Alert.AlertType.ERROR);
            anAlert.setContentText("Oops! Something went wrong. Vaccination report was not updated.");
            anAlert.show();
        }
        catch(IOException e) {
            anAlert.setAlertType(Alert.AlertType.ERROR);
            anAlert.setContentText("Oops! Something went wrong. Vaccination report was not updated.");
            anAlert.show();
        }
        finally {
            try {
                if(oos != null) oos.close();
            }
            catch(IOException e) {
            }
        }
    }
    
}
