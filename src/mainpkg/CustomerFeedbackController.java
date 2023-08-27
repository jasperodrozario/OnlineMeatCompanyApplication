package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class CustomerFeedbackController implements Initializable {

    @FXML
    private TextArea feedbackTA;
    @FXML
    private ComboBox<Integer> selectOrderCB;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Order order: Order.getCustomerOrder(LoggedUserInstance.custInst.userId, true)) {
            selectOrderCB.getItems().add(order.orderId);
        }
    }    

    @FXML
    private void submitFeedbackBtnOnClick(ActionEvent event) {
        
    }

    @FXML
    private void rtrnHomeBtnOnClick(ActionEvent event) {
    }
    
}
