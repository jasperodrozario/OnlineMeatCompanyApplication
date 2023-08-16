package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class MuttonSceneController implements Initializable {

    @FXML
    private Button addToCartBtn;
    @FXML
    private ComboBox<Integer> quantityBBIComboBox;
    @FXML
    private Button addToCartBtn2;
    @FXML
    private ComboBox<Integer> quantityBBIComboBox2;
    @FXML
    private Button addToCartBtn21;
    @FXML
    private ComboBox<Integer> quantityBBIComboBox21;

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
    private void BBIAddToCartOnClick(ActionEvent event) {
    }

    @FXML
    private void checkoutBtnOnClick(ActionEvent event) {
    }
    
}
