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
    @FXML
    private TextField phoneNumberTF;
    

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
                newUserIdTextField.setText(Integer.toString(Customer.generateUniqueUserId()));
            }
            else if(userTypeComboBox.getValue().equals("Regulatory Officer")) {
                dobDatePicker.setDisable(false);
                dojDatePicker.setDisable(false);
                salaryTextField.setDisable(false);
                addressTextField.setDisable(true);
                newUserIdTextField.setText(Integer.toString(RegulatoryOfficer.generateUniqueUserId()));
            }
            else if(userTypeComboBox.getValue().equals("Affiliate Marketer")) {
                dobDatePicker.setDisable(false);
                dojDatePicker.setDisable(false);
                salaryTextField.setDisable(false);
                addressTextField.setDisable(true);
                newUserIdTextField.setText(Integer.toString(AffiliateMarketer.generateUniqueUserId()));
            }
            else if(userTypeComboBox.getValue().equals("Rider")) {
                dobDatePicker.setDisable(false);
                dojDatePicker.setDisable(false);
                salaryTextField.setDisable(false);
                addressTextField.setDisable(true);
                newUserIdTextField.setText(Integer.toString(Rider.generateUniqueUserId()));
            }
            else if(userTypeComboBox.getValue().equals("Account Officer")) {
                dobDatePicker.setDisable(false);
                dojDatePicker.setDisable(false);
                salaryTextField.setDisable(false);
                addressTextField.setDisable(true);
                newUserIdTextField.setText(Integer.toString(AccountOfficer.generateUniqueUserId()));
            }
            else if(userTypeComboBox.getValue().equals("Vendor")) {
                dobDatePicker.setDisable(false);
                dojDatePicker.setDisable(false);
                salaryTextField.setDisable(false);
                addressTextField.setDisable(true);
                newUserIdTextField.setText(Integer.toString(Vendor.generateUniqueUserId()));
            }
            else if(userTypeComboBox.getValue().equals("CEO")) {
                dobDatePicker.setDisable(false);
                dojDatePicker.setDisable(false);
                salaryTextField.setDisable(false);
                addressTextField.setDisable(true);
                newUserIdTextField.setText(Integer.toString(CEO.generateUniqueUserId()));
            }
            else if(userTypeComboBox.getValue().equals("CCE")) {
                dobDatePicker.setDisable(false);
                dojDatePicker.setDisable(false);
                salaryTextField.setDisable(false);
                addressTextField.setDisable(true);
                newUserIdTextField.setText(Integer.toString(CCE.generateUniqueUserId()));
            }
        });
    }

    @FXML
    private void registerButtonOnClick(MouseEvent event) {
        String userType = userTypeComboBox.getValue();
        int userId = Integer.parseInt(newUserIdTextField.getText());
        String name = nameTextField.getText();
        String password = passwordTextField.getText();
        String phoneNumber = phoneNumberTF.getText();
        String address = addressTextField.getText();
        LocalDate dob = dobDatePicker.getValue();
        LocalDate doj = dojDatePicker.getValue();
        
        addUserStatus = Database.addUser(userType, name, true, password, dob, doj, phoneNumber, address);
        
        newUserIdTextField.setText("");
        nameTextField.setText("");
        passwordTextField.setText("");
        salaryTextField.setText("");
        phoneNumberTF.setText("");
        addressTextField.setText("");
        dobDatePicker.setValue(null);
        dojDatePicker.setValue(null);
        
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
