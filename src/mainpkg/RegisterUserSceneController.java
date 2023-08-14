package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class RegisterUserSceneController implements Initializable {

    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private TextField newUserIdTextField;
    @FXML
    private TextField nameTextField;
    @FXML
    private TextField passwordTextField;
    @FXML
    private DatePicker dobDatePicker;
    @FXML
    private DatePicker dojDatePicker;
    @FXML
    private RadioButton maleRadioButton;
    @FXML
    private RadioButton femaleRadioButton;
    @FXML
    private TextField addressTextField;
    @FXML
    private TextField salaryTextField;    
    
    
    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);
    boolean addUserStatus;
    

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        addressTextField.setDisable(true);
        userTypeComboBox.getItems().addAll("Customer", "Regulatory Officer", "Affiliate Marketer", "Rider", "Account Officer", "Vendor", "CEO", "CCE");
        userTypeComboBox.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if(userTypeComboBox.getValue().equals("Customer")) {
                dobDatePicker.setDisable(true);
                dojDatePicker.setDisable(true);
                salaryTextField.setDisable(true);
                addressTextField.setDisable(false);
            }
            else {
                dobDatePicker.setDisable(false);
                dojDatePicker.setDisable(false);
                salaryTextField.setDisable(false);
                addressTextField.setDisable(true);
            }
        });
    }

    @FXML
    private void registerButtonOnClick(MouseEvent event) {
        String userType = userTypeComboBox.getValue();
        int userId = Integer.parseInt(newUserIdTextField.getText());
        String name = nameTextField.getText();
        String password = passwordTextField.getText();
        String address = addressTextField.getText();
        LocalDate dob = dobDatePicker.getValue();
        LocalDate doj = dojDatePicker.getValue();
        
        if(userTypeComboBox.getValue().equals("Customer")) {
            addUserStatus = Database.addCustomer(userType, userId, name, true, password, address);
        }
        else {
            addUserStatus = Database.addEmployee(userType, userId, name, true, password, dob, doj);
        }
//        else if(userTypeComboBox.getValue().equals("Regulatory Officer")) {
//            RegulatoryOfficer newEmployee = new RegulatoryOfficer(userType, userId, name, true, password, dob, doj);
//        }
//        else if(userTypeComboBox.getValue().equals("Regulatory Officer")) {
//            AffiliateMarketer newEmployee = new AffiliateMarketer(userType, userId, name, true, password, dob, doj);
//        }
//        else if(userTypeComboBox.getValue().equals("Regulatory Officer")) {
//            RegulatoryOfficer newEmployee = new RegulatoryOfficer(userType, userId, name, true, password, dob, doj);
//        }
//        else if(userTypeComboBox.getValue().equals("Regulatory Officer")) {
//            RegulatoryOfficer newEmployee = new RegulatoryOfficer(userType, userId, name, true, password, dob, doj);
//        }
//        else if(userTypeComboBox.getValue().equals("Regulatory Officer")) {
//            RegulatoryOfficer newEmployee = new RegulatoryOfficer(userType, userId, name, true, password, dob, doj);
//        }
//        else if(userTypeComboBox.getValue().equals("Regulatory Officer")) {
//            RegulatoryOfficer newEmployee = new RegulatoryOfficer(userType, userId, name, true, password, dob, doj);
//        }
//        else if(userTypeComboBox.getValue().equals("Regulatory Officer")) {
//            RegulatoryOfficer newEmployee = new RegulatoryOfficer(userType, userId, name, true, password, dob, doj);
//        }
        
        if(addUserStatus) {
            anAlert.setContentText("User Added Successfully!");
            anAlert.show();
        }
        else {
            anAlert.setContentText("Oops! Something went wrong. Try Again.");
            anAlert.show();
        }
    }
    
    
    
    
}
