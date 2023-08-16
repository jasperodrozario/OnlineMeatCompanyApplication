package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
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
    
    Alert anErrorAlert = new Alert(Alert.AlertType.ERROR);
    Alert anInfoAlert = new Alert(Alert.AlertType.INFORMATION);
    SceneLoader newSceneLoader = new SceneLoader();
    Customer loggedCustInst;
    Product thisProduct;
    int i;
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bbiQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        btcQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        btsQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        btbsQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        loggedCustInst = LoggedUserInstance.custInst;
    }    

    @FXML
    private void bbiAddToCartBtnOnClick(MouseEvent event) {
        if(bbiQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef Bone In", bbiQuantityComboBox.getValue(), 800);
            
            anInfoAlert.setContentText("Order successfully added.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void btcAddToCartBtnOnClick(MouseEvent event) {
        if(btcQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef Tehari Cut", btcQuantityComboBox.getValue(), 800);
            anInfoAlert.setContentText("Order successfully added.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
        
    }

    @FXML
    private void btsAddToCartBtnOnClick(MouseEvent event) {
        if(btsQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef Tenderloin Steak", btsQuantityComboBox.getValue(), 800);
            anInfoAlert.setContentText("Order successfully added.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void btbsAddToCartBtnOnClick(MouseEvent event) {
        if(btbsQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef T-Bone Steak", btbsQuantityComboBox.getValue(), 800);
            anInfoAlert.setContentText("Order successfully added.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void checkoutBtnOnClick(ActionEvent event) {
        newSceneLoader.loadScene("CheckoutScene.fxml");
    }
    
}
