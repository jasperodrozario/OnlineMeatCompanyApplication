/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.awt.Color;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.effect.Effect;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jasper
 */
public class BeefSceneController implements Initializable {

    @FXML
    private Button bbiAddToCartBtn;
    @FXML
    private ComboBox<Integer> bbiQuantityComboBox;
    @FXML
    private Button btcAddToCartBtn;
    @FXML
    private ComboBox<Integer> btcQuantityComboBox;
    @FXML
    private Button btsAddToCartBtn;
    @FXML
    private ComboBox<Integer> btsQuantityComboBox;
    @FXML
    private Button btbsAddToCartBtn;
    @FXML
    private ComboBox<Integer> btbsQuantityComboBox;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bbiQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        btcQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        btsQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        btbsQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
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

    
}
