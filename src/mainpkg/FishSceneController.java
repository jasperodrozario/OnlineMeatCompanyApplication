package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
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
public class FishSceneController implements Initializable {

    @FXML
    private ComboBox<Integer> ruiQuantityComboBox;
    @FXML
    private ComboBox<Integer> hilshaQuantityComboBox;
    @FXML
    private ComboBox<Integer> prawnQuantityComboBox;
    @FXML
    private ComboBox<Integer> squidQuantityComboBox;
    
    Customer loggedCustInst = LoggedUserInstance.custInst;
    SceneLoader newSceneLoader = new SceneLoader();
    Alert anInfoAlert = new Alert(Alert.AlertType.INFORMATION);
    Alert anErrorAlert = new Alert(Alert.AlertType.ERROR);
    @FXML
    private Button bbiAddToCartBtn;
    @FXML
    private Button btcAddToCartBtn;
    @FXML
    private Button btsAddToCartBtn;
    @FXML
    private Button btbsAddToCartBtn;

    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ruiQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        hilshaQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        prawnQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
        squidQuantityComboBox.getItems().addAll(1,2,3,4,5,6,7,8,9,10);
    }
    
    @FXML
    private void rtrnHomeBtnOnClick(MouseEvent event) throws IOException {
        newSceneLoader.switchScene("CustomerDashboardScene.fxml", event);
    }

    @FXML
    private void ruiAddToCartBtnOnClick(MouseEvent event) {
        if(ruiQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Rui", ruiQuantityComboBox.getValue(), 3, 400);
            ruiQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void hilshaAddToCartBtnOnClick(MouseEvent event) {
        if(hilshaQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Hilsha", hilshaQuantityComboBox.getValue(), 10, 1200);
            hilshaQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void prawnAddToCartBtnOnClick(MouseEvent event) {
        if(prawnQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Prawn", prawnQuantityComboBox.getValue(), 5, 1000);
            prawnQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void squidAddToCartBtnOnClick(MouseEvent event) {
        if(squidQuantityComboBox.getValue() != null) {
            loggedCustInst.addToCart("Squid", squidQuantityComboBox.getValue(), 15, 600);
            squidQuantityComboBox.setValue(null);
            anInfoAlert.setContentText("Item(s) has been added to your cart.");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Select quantity first!");
            anErrorAlert.show();
        }
    }

    @FXML
    private void checkoutBtnOnClick(MouseEvent event) {
        if(loggedCustInst.checkOut()) {
            newSceneLoader.loadScene("CheckoutScene.fxml");
        }
        else {
            anInfoAlert.setContentText("Your cart is empty. Add an item to the cart to checkout.");
            anInfoAlert.show();
        }
    }
    
}
