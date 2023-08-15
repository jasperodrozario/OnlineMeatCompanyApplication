/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Jasper
 */
public class AuditReportEditSceneController implements Initializable {

    @FXML
    private TextArea auditReportTextField;

    LocalDate curDate = LocalDate.now();
    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);
    boolean auditfile;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void auditSubmitButtonOnClick(ActionEvent event) {
        
        if (AccountOfficer.submitAuditReport(auditReportTextField.getText(), curDate)){
            anAlert.setContentText("Audit report submitted successfully!");
            anAlert.show();
        }
        else{
            anAlert.setContentText("Oops! Something went wrong. Try Again.");
            anAlert.show();
        }
    }
    
}
