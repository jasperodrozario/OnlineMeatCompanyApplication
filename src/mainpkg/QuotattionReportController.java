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
 * @author DELL
 */
public class QuotattionReportController implements Initializable {

    @FXML
    private TextArea quotationReportTextArea;

    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void quotetionReportSubmitButtonOnClick(ActionEvent event) {
        
        if (AccountOfficer.submitQuotationReport(quotationReportTextArea.getText())){
            anAlert.setContentText("Audit report submitted successfully!");
            anAlert.show();
        }
        else{
            anAlert.setContentText("Oops! Something went wrong. Try Again.");
            anAlert.show();
        }
        
    }

    
}
