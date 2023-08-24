/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jasper
 */
public class ChangePasswordSceneController implements Initializable {

    @FXML
    private TextField userIdTextField;
    @FXML
    private TextField oldPasswordTextField;
    @FXML
    private ComboBox<String> userTypeComboBox;
    @FXML
    private TextField newPasswordTextField;
    @FXML
    private TextField reenterNewPasswordTextField;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void chngPassBtnOnClick(MouseEvent event) {
        
    }
    
}
