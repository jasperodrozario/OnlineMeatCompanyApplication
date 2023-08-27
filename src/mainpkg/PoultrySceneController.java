package mainpkg;

import java.io.IOException;
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
 * @author Dell
 */

public class PoultrySceneController implements Initializable {
    
    @FXML
    private ComboBox<Integer> wcsoQuantityComboBox;
    @FXML
    private ComboBox<Integer> wcslQuantityComboBox;
    @FXML
    private ComboBox<Integer> rcsQuantityComboBox;
    @FXML
    private ComboBox<Integer> cdsoQuantityComboBox;
    
    Customer loggedCustInst = LoggedUserInstance.custInst;
    SceneLoader newSceneLoader = new SceneLoader();
    Alert anInfoAlert = new Alert(Alert.AlertType.INFORMATION);
    Alert anErrorAlert = new Alert(Alert.AlertType.ERROR);
    @FXML
    private Button addToCartBtn2;
    @FXML
    private Button addToCartBtn21;
    @FXML
    private Button addToCartBtn211;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        wcsoQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        wcslQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        rcsQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        cdsoQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
    }

    @FXML
    private void wcsoAddToCartBtnOnClick(ActionEvent event) {
        if(wcsoQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Whole Chicken (Skin On)", wcsoQuantityComboBox.getValue(), 5, 390);
            wcsoQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void wcslAddToCartBtnOnClick(ActionEvent event) {
        if(wcslQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Whole Chicken (Skinless)", wcslQuantityComboBox.getValue(), 5, 395);
            wcslQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void rcsAddToCartBtnOnClick(ActionEvent event) {
        if(rcsQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Roast Chicken (Sonali)", rcsQuantityComboBox.getValue(), 3, 312);
            rcsQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void cdsoAddToCartBtnOnClick(ActionEvent event) {
        if(cdsoQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Chicken Drumstick (Skin On)", cdsoQuantityComboBox.getValue(), 5, 530);
            cdsoQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }
    
    @FXML
    private void checkoutBtnOnClick(ActionEvent event) {
        if(loggedCustInst.checkOut()) {
            newSceneLoader.loadScene("CheckoutScene.fxml");
        }
        else {
            anInfoAlert.setContentText("Your cart is empty. Add an item to the cart to checkout.");
            anInfoAlert.show();
        }
    }
    
    private void rtrnHomeBtnOnClick(MouseEvent event) throws IOException {
        newSceneLoader.switchScene("CustomerDashboardScene.fxml", event);
    }
    
}
