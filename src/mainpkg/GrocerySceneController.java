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
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class GrocerySceneController implements Initializable {

    @FXML
    private Button bbiAddToCartBtn;
    @FXML
    private ComboBox<?> bbiQuantityComboBox;
    @FXML
    private Button btcAddToCartBtn;
    @FXML
    private ComboBox<?> btcQuantityComboBox;
    @FXML
    private Button btsAddToCartBtn;
    @FXML
    private ComboBox<?> btsQuantityComboBox;
    @FXML
    private Button btbsAddToCartBtn;
    @FXML
    private ComboBox<?> btbsQuantityComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void bbiAddToCartBtnOnClick(MouseEvent event) {
    }

    @FXML
    private void btcAddToCartBtnOnClick(MouseEvent event) {
    }

    @FXML
    private void btsAddToCartBtnOnClick(MouseEvent event) {
    }

    @FXML
    private void btbsAddToCartBtnOnClick(MouseEvent event) {
    }

    @FXML
    private void checkoutBtnOnClick(ActionEvent event) {
    }
    
}
