package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class LiveChatRiderController implements Initializable {

    @FXML
    private TextArea messageTA;
    @FXML
    private ComboBox<Integer> customerIdCB;

    Alert anInfoAlert = new Alert(Alert.AlertType.INFORMATION);
    Alert anErrorAlert = new Alert(Alert.AlertType.ERROR);
    SceneLoader newSceneLoader = new SceneLoader();
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Order order: Order.getCustomerOrder(LoggedUserInstance.custInst.userId, false)) {
            customerIdCB.getItems().add(order.customerId);
        }
    }    

    @FXML
    private void sendMsgBtnOnClick(ActionEvent event) {
        if(LoggedUserInstance.riderInst.chatWithCustomer(customerIdCB.getValue(), messageTA.getText())) {
            anInfoAlert.setContentText("Message Sent!");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Something went wrong. Message was not sent.");
            anErrorAlert.show();
        }
    }

    @FXML
    private void rtrnBtnOnClick(ActionEvent event) throws IOException {
        newSceneLoader.switchScene("CustomerDashboardScene.fxml", event);
    }

    @FXML
    private void readChatBtnOnClick(ActionEvent event) {
        messageTA.setText(LoggedUserInstance.riderInst.readCustomerChat(customerIdCB.getValue()));
    }
    
}
