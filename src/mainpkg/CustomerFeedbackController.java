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

public class CustomerFeedbackController implements Initializable {

    @FXML
    private TextArea feedbackTA;
    @FXML
    private ComboBox<Integer> selectOrderCB;
    
    SceneLoader newSceneLoader = new SceneLoader();
    boolean matched;
    Alert anErrorAlert = new Alert(Alert.AlertType.ERROR);
    Alert anInfoAlert = new Alert(Alert.AlertType.INFORMATION);
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Order order: Order.getCustomerOrder(LoggedUserInstance.custInst.userId, true)) {
            matched = false;
            for(CustomerFeedback feedback: CustomerFeedback.getAllCustomerFeedback()) {
                if(feedback.orderId == order.orderId) {
                    matched = true;
                    break;
                }
            }
            if(!matched) {
                selectOrderCB.getItems().add(order.orderId);
            }
        }
    }    

    @FXML
    private void submitFeedbackBtnOnClick(ActionEvent event) {
        if(selectOrderCB.getValue() == null) {
            anErrorAlert.setContentText("Select an Order ID first.");
            anErrorAlert.show();
        }
        else if(feedbackTA.getText().equals("")) {
            anErrorAlert.setContentText("Blank feedback cannot be submitted");
            anErrorAlert.show();
        }
        else {
            if(LoggedUserInstance.custInst.giveFeedback(selectOrderCB.getValue(), feedbackTA.getText())) {
                feedbackTA.setText(null);
                selectOrderCB.setValue(null);
                selectOrderCB.getItems().clear();
                for(Order order: Order.getCustomerOrder(LoggedUserInstance.custInst.userId, true)) {
                    matched = false;
                    for(CustomerFeedback feedback: CustomerFeedback.getAllCustomerFeedback()) {
                        if(feedback.orderId == order.orderId) {
                            matched = true;
                            break;
                        }
                    }
                    if(!matched) {
                        selectOrderCB.getItems().add(order.orderId);
                    }
                }
                anInfoAlert.setContentText("Feedback submitted successfully.");
                anInfoAlert.show();
            }
            else {
                anErrorAlert.setContentText("Something went wrong. Try again later.");
                anErrorAlert.show();
            }
        }
    }

    @FXML
    private void rtrnHomeBtnOnClick(ActionEvent event) throws IOException {
        newSceneLoader.switchScene("CustomerDashboardScene.fxml", event);
    }
    
}
