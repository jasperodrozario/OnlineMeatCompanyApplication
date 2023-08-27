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
public class GrocerySceneController implements Initializable {

    @FXML
    private ComboBox<Integer> bmQuantityComboBox;
    @FXML
    private ComboBox<Integer> mmQuantityComboBox;
    @FXML
    private ComboBox<Integer> cmQuantityComboBox;
    @FXML
    private ComboBox<Integer> fmQuantityComboBox;

    Customer loggedCustInst = LoggedUserInstance.custInst;
    Alert anInfoAlert = new Alert(Alert.AlertType.INFORMATION);
    Alert anErrorAlert = new Alert(Alert.AlertType.ERROR);
    SceneLoader newSceneLoader = new SceneLoader();
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        bmQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        mmQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        cmQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        fmQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
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
    private void bmAddToCartBtnOnClick(ActionEvent event) {
        if(bmQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Beef Mix", bmQuantityComboBox.getValue(), 3, 80);
            bmQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void mmAddToCartBtnOnClick(ActionEvent event) {
        if(mmQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Mutton Mix", mmQuantityComboBox.getValue(), 3, 100);
            mmQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void cmAddToCartBtnClick(ActionEvent event) {
        if(cmQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Chicken Mix", cmQuantityComboBox.getValue(), 5, 63);
            cmQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void fmAddToCartBtnOnClick(ActionEvent event) {
        if(fmQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Fish Mix", fmQuantityComboBox.getValue(), 5, 70);
            fmQuantityComboBox.setValue(null);
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
