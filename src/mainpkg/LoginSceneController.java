package mainpkg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;


/**
 *
 * @author Jasper
 */
public class LoginSceneController implements Initializable {
    
    private Label label;
    @FXML
    private TextField userIdTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private TextField passwordTextField;
    @FXML
    private Label resetPassLabel;
    @FXML
    private Label regLabel;
    

    Alert anAlert = new Alert(Alert.AlertType.ERROR);
    SceneLoader newSceneLoader = new SceneLoader();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        userTypeComboBox.getItems().addAll("Customer","Regulatory Officer", "Affiliate Marketer", "Rider", "Account Officer", "Vendor", "CEO", "CCE");
    }    

    @FXML
    private void loginOnMouseClick(MouseEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {

        if(userTypeComboBox.getValue() == null) {
            anAlert.setContentText("Select a user type first");
            anAlert.showAndWait();
        }
        else if(userIdTextField.getText().isEmpty()) {
            anAlert.setContentText("Enter a user ID and a password to login");
            anAlert.showAndWait();
        }
        else if(passwordTextField.getText().isEmpty()) {
            anAlert.setContentText("Enter a user ID and a password to login");
            anAlert.showAndWait();
        }
        else {
            if(userTypeComboBox.getValue().equals("Customer")) {
                if(Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText())) {
                    newSceneLoader.switchScene("CustomerDashboardScene.fxml", event);
                }
                else {
                    anAlert.setAlertType(Alert.AlertType.ERROR);
                    anAlert.setContentText("Oops! The combination of userId and password is incorrect or something else went wrong. Try again!");
                    anAlert.show();
                }
            }
            else if(userTypeComboBox.getValue().equals("Rider")) {
                if(Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText())) {
                    newSceneLoader.switchScene("RiderDashboardScene.fxml", event);
                }
                else {
                    anAlert.setContentText("Oops! The combination of userId and password is incorrect or something else went wrong. Try again!");
                    anAlert.show();
                }
            }
            else if(userTypeComboBox.getValue().equals("Vendor")) {
                if(Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText())) {
                    newSceneLoader.switchScene("VendorDashBoard.fxml", event);
                }
                else {
                    anAlert.setContentText("Oops! The combination of userId and password is incorrect or something else went wrong. Try again!");
                    anAlert.show();
                }
            }
            else if(userTypeComboBox.getValue().equals("Affiliate Marketer")) {
                if(Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText())) {
                    newSceneLoader.switchScene("AffiliateMarketerDashboard.fxml", event);
                }
                else {
                    anAlert.setContentText("Oops! The combination of userId and password is incorrect or something else went wrong. Try again!");
                    anAlert.show();
                }
            }
            else if(userTypeComboBox.getValue().equals("CEO")) {
                if(Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText())) {
                    newSceneLoader.switchScene("CEOdashboard.fxml", event);
                }
                else {
                    anAlert.setContentText("Oops! The combination of userId and password is incorrect or something else went wrong. Try again!");
                    anAlert.show();
                }
            }
            else if(userTypeComboBox.getValue().equals("Account Officer")) {
                if(Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText())) {
                    newSceneLoader.switchScene("AccountOfficerDashBoard.fxml", event);
                }
                else {
                    anAlert.setContentText("Oops! The combination of userId and password is incorrect or something else went wrong. Try again!");
                    anAlert.show();
                }
            }
            else if(userTypeComboBox.getValue().equals("Regulatory Officer")) {
                if(Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText())) {
                    newSceneLoader.switchScene("RegulatoryOfficerDashboardScene.fxml", event);
                }
                else {
                    anAlert.setContentText("Oops! The combination of userId and password is incorrect or something else went wrong. Try again!");
                    anAlert.show();
                }
            }
            else if(userTypeComboBox.getValue().equals("CCE")) {
                if(Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText())) {
                    newSceneLoader.switchScene("CCEDashboard.fxml", event);
                }
                else {
                    anAlert.setContentText("Oops! The combination of userId and password is incorrect or something else went wrong. Try again!");
                    anAlert.show();
                }
            }
        }
    }

    @FXML
    private void resetPassLabelOnClick(MouseEvent event) {
        newSceneLoader.loadScene("ChangePasswordScene.fxml");
    }
    
    @FXML
    private void resetPassLabelOnHover(MouseEvent event) {
    }

    @FXML
    private void regLabelOnClick(MouseEvent event) {
        newSceneLoader.loadScene("RegisterUserScene.fxml");
    }

    private void switchToViewBinFileSceneOnClick(MouseEvent event) {
        newSceneLoader.loadScene("ViewBinFileContentScene.fxml");
    }
    
}
