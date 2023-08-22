package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class MuttonSceneController implements Initializable {

    private ComboBox<Integer> quantityBBIComboBox;
    private ComboBox<Integer> quantityBBIComboBox2;
    private ComboBox<Integer> quantityBBIComboBox21;
    @FXML
    private ComboBox<?> mbiQuantityComboBox;
    @FXML
    private ComboBox<?> msQuantityComboBox;
    @FXML
    private ComboBox<?> mblQuantityComboBox;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        quantityBBIComboBox.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        quantityBBIComboBox2.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        quantityBBIComboBox21.getItems().addAll(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    }    


    @FXML
    private void checkoutBtnOnClick(ActionEvent event) {
    }

    @FXML
    private void mbiAddToCartBtnOnClick(ActionEvent event) {
    }

    @FXML
    private void msAddToCartBtnOnClick(ActionEvent event) {
    }

    @FXML
    private void mblAddToCartBtnOnClick(ActionEvent event) {
    }
    
}
