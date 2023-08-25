package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */

public class MuttonSceneController implements Initializable {

    @FXML
    private ComboBox<Integer> mbiQuantityComboBox;
    @FXML
    private ComboBox<Integer> msQuantityComboBox;
    @FXML
    private ComboBox<Integer> mblQuantityComboBox;
    
    Alert anErrorAlert = new Alert(Alert.AlertType.ERROR);
    Alert anInfoAlert = new Alert(Alert.AlertType.INFORMATION);
    SceneLoader newSceneLoader = new SceneLoader();
    Customer loggedCustInst = LoggedUserInstance.custInst;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        mbiQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        msQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        mblQuantityComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
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

    @FXML
    private void mbiAddToCartBtnOnClick(ActionEvent event) {
        if(mbiQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Mutton Bone In", mbiQuantityComboBox.getValue(), 10, 1080);
            
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void msAddToCartBtnOnClick(ActionEvent event) {
        if(msQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Mutton Shank", msQuantityComboBox.getValue(), 10, 1550);
            
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void mblAddToCartBtnOnClick(ActionEvent event) {
        if(mblQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Mutton Back Leg", mblQuantityComboBox.getValue(), 10, 1300);
            
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void rtrnHomeBtnOnClick(MouseEvent event) throws IOException {
        newSceneLoader.switchScene("CustomerDashboardScene.fxml", event);
    }
    
}
