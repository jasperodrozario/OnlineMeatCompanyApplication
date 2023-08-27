package mainpkg;

import java.io.IOException;
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

public class CCEDashboardController implements Initializable {

    SceneLoader sceneLoader = new SceneLoader();
    @FXML
    private BorderPane cceDashboardBP;
    
    /**
     * Initializes the controller class.
     */
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void custFeedMIOnClick(ActionEvent event) {
    }

    @FXML
    private void riderFeedMIOnClick(ActionEvent event) {
    }

    @FXML
    private void liveChatMIOnClick(ActionEvent event) {
    }

    @FXML
    private void surveyMIOnClick(ActionEvent event) {
    }

    @FXML
    private void about(ActionEvent event) {
        cceDashboardBP.setCenter(sceneLoader.getSceneRoot("ProductDetailsScene.fxml"));
    }

    @FXML
    private void logoutBtnOnClick(ActionEvent event) throws IOException {
        sceneLoader.switchScene("LoginScene.fxml", event);
    }
    
}
