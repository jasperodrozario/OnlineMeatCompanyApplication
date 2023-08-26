package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class TaxReportSceneAccountantController implements Initializable {

    @FXML
    private DatePicker taxDate;
    @FXML
    private TextField taxAmmountTextField;
    @FXML
    private TextField taxMonthTextField;
    @FXML
    private TextArea textArea;
    
    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addTaxReportOnClick(ActionEvent event) {
        
        if (AccountOfficer.submitTaxReport(Integer.parseInt(taxAmmountTextField.getText()),taxDate.getValue(),taxMonthTextField.getText())){
            anAlert.setContentText("Tax report submitted successfully!");
            anAlert.show();
        }
        else{
            anAlert.setContentText("Oops! Something went wrong. Try Again.");
            anAlert.show();
        }
        
        taxAmmountTextField.setText(" ");
        taxMonthTextField.setText(" ");
        
    }

    @FXML
    private void onClick(ActionEvent event) {
        
        TaxReportAccountant stud = TaxReportAccountant.readFile();
        textArea.setText(stud.getToString());
        
    }
    
}
