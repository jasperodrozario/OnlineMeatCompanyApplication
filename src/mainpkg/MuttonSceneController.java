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
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class MuttonSceneController implements Initializable {

    @FXML
    private Button addToCartBtn;
    @FXML
    private ComboBox<Integer> quantityBBIComboBox;
    @FXML
    private Button addToCartBtn2;
    @FXML
    private ComboBox<Integer> quantityBBIComboBox2;
    @FXML
    private Button addToCartBtn21;
    @FXML
    private ComboBox<Integer> quantityBBIComboBox21;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void BBIAddToCartOnClick(ActionEvent event) {
    }
    
}
