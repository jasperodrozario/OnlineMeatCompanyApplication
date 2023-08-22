package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class GrocerySceneController implements Initializable {

    @FXML
    private ComboBox<?> bmQuantityComboBox;
    @FXML
    private ComboBox<?> mmQuantityComboBox;
    @FXML
    private ComboBox<?> cmQuantityComboBox;
    @FXML
    private ComboBox<?> fmQuantityComboBox;

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

    @FXML
    private void bmAddToCartBtnOnClick(ActionEvent event) {
    }

    @FXML
    private void mmAddToCartBtnOnClick(ActionEvent event) {
    }

    @FXML
    private void cmAddToCartBtnClick(ActionEvent event) {
    }

    @FXML
    private void fmAddToCartBtnOnClick(ActionEvent event) {
    }
    
}
