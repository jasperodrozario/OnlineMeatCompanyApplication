/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class MonthlyFarnCostSceneVendorController implements Initializable {

    @FXML
    private TextField monthTextField;
    @FXML
    private TextField costTextField;

    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);
    Vendor loggedUserInst = LoggedUserInstance.vendorInst;
    
    SceneLoader newSceneOpener = new SceneLoader();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addCostOnClick(ActionEvent event) {
        
        if(loggedUserInst.updateFarmCost(monthTextField.getText(), Integer.parseInt(costTextField.getText()))) {
            anAlert.setContentText("Vaccine status successfully updated!");
            anAlert.show();
        }
        else {
            anAlert.setContentText("Oops! Couldn't update vaccine status. Try again.");
            anAlert.show();
        }
        
    }

    @FXML
    private void goTableOnClick(ActionEvent event) throws IOException {
        
        newSceneOpener.switchScene("FarmCostTableVendor.fxml", event);
        
    }
    
}
