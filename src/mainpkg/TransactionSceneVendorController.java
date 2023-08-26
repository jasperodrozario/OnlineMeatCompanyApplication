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
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class TransactionSceneVendorController implements Initializable {

    @FXML
    private TextField productNameTextField;
    @FXML
    private TextField productAmountTextField;
    @FXML
    private TextField productPriceTextField;
    @FXML
    private DatePicker transactionDate;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void addVendorTransactionOnClick(ActionEvent event) {
    }

    @FXML
    private void goTableOnClick(ActionEvent event) {
    }
    
}
