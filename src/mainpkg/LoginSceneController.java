package mainpkg;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

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
        userTypeComboBox.getItems().addAll("Customer","Regulatory Officer", "Affiliate Marketer");
    }    

    @FXML
    private void loginOnMouseClick(MouseEvent event) throws IOException, FileNotFoundException, ClassNotFoundException {
        if(userTypeComboBox.getValue().equals(null)) {
            anAlert.setContentText("Select a user type first");
            anAlert.showAndWait();
        }
        else if(userIdTextField.equals(null) || passwordTextField.equals(null)) {
            anAlert.setContentText("Enter a user ID and a password to login");
            anAlert.showAndWait();
        }
        else {
            if(userTypeComboBox.getValue().equals("Customer")) {
                if(Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText())) {
                    newSceneLoader.loadScene("CustomerDashboardScene.fxml");
                }
                else {
                    System.out.println("Kaaj kore nai");
                }
            }
            else if(userTypeComboBox.getValue().equals("Rider")) {
                Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText());
            }
            else if(userTypeComboBox.getValue().equals("Vendor")) {
                Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText());
            }
            else if(userTypeComboBox.getValue().equals("Affiliate Marketer")) {
                Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText());
            }
            else if(userTypeComboBox.getValue().equals("CEO")) {
                Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText());
            }
            else if(userTypeComboBox.getValue().equals("Accountant")) {
                Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText());
            }
            else if(userTypeComboBox.getValue().equals("Regulatory Officer")) {
                Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText());
                newSceneLoader.loadScene("RegulatoryOfficerScene.fxml");

            }
            else if(userTypeComboBox.getValue().equals("Affiliate Marketer")) {
                Database.verifyUserPassword(userTypeComboBox.getValue(), Integer.parseInt(userIdTextField.getText()), passwordTextField.getText());
            }
        }
       
    }

    @FXML
    private void resetPassLabelOnClick(MouseEvent event) {
    }
    
    @FXML
    private void resetPassLabelOnHover(MouseEvent event) {
    }

    @FXML
    private void regLabelOnClick(MouseEvent event) {
        newSceneLoader.loadScene("RegisterUserScene.fxml");
    }

    @FXML
    private void switchToViewBinFileSceneOnClick(MouseEvent event) {
        newSceneLoader.loadScene("ViewBinFileContentScene.fxml");
    }

    @FXML
    private void accountOnClick(ActionEvent event) {
        newSceneLoader.loadScene("AccountOfficerDashBoard.fxml");
    }

    @FXML
    private void customerBtnOnClick(MouseEvent event) {
        newSceneLoader.loadScene("CustomerDashboardScene.fxml");
    }
}
