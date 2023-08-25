package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class TrackOrderSceneController implements Initializable {

    @FXML
    private ListView<String> trackOrderLV;

    SceneLoader newSceneLoader = new SceneLoader();
    Customer loggedCust = LoggedUserInstance.custInst;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Order order: Order.getAllOrders()) {
            if(order.customerId == loggedCust.userId && order.riderId != 0) {
                if(!order.delivered) {
                    trackOrderLV.getItems().add(order.getOrderInfoStr());
                }
            }
        }
    }

    @FXML
    private void rtrnHomeBtnOnClick(MouseEvent event) throws IOException {
        newSceneLoader.switchScene("CustomerDashboardScene.fxml", event);
    }
    
}
