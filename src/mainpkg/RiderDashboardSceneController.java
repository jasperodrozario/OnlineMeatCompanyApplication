package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Jasper
 */
public class RiderDashboardSceneController implements Initializable {

    @FXML
    private BorderPane riderDashBoardBP;

    SceneLoader newSceneLoader = new SceneLoader();
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void incDelivMIOnClick(ActionEvent event) {
        riderDashBoardBP.setCenter(newSceneLoader.getSceneRoot("RiderRecieveDelivery.fxml"));
    }

    @FXML
    private void pendingOrdersMIOnClick(ActionEvent event) {
        riderDashBoardBP.setCenter(newSceneLoader.getSceneRoot("RiderRecieveDelivery.fxml"));
    }

    @FXML
    private void writeRprtMIOnClick(ActionEvent event) {
        riderDashBoardBP.setCenter(newSceneLoader.getSceneRoot("RiderRecieveDelivery.fxml"));
    }

    @FXML
    private void safetynSecMIOnClick(ActionEvent event) {
        riderDashBoardBP.setCenter(newSceneLoader.getSceneRoot("RiderRecieveDelivery.fxml"));
    }

    @FXML
    private void delivHistMIOnClick(ActionEvent event) {
        riderDashBoardBP.setCenter(newSceneLoader.getSceneRoot("RiderRecieveDelivery.fxml"));
    }
    
}
