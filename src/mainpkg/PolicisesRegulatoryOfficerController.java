/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class PolicisesRegulatoryOfficerController implements Initializable {

    @FXML
    private TextArea policyTextArea;
    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addPoliciesOnClick(ActionEvent event) {
        
        if (RegulatoryOfficer.submitPolicy(policyTextArea.getText())){
            anAlert.setContentText("Policy report submitted successfully!");
            anAlert.show();
        }
        else{
            anAlert.setContentText("Oops! Something went wrong. Try Again.");
            anAlert.show();
        }
    }
    
}
