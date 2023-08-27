
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
public class AffiliateMarketerDashboardController implements Initializable {


    public SceneLoader newSceneLoader = new SceneLoader();
    @FXML
    private BorderPane affiliateMarketerDashboardBP;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void createContMIOnClick(ActionEvent event) {
        affiliateMarketerDashboardBP.setCenter(newSceneLoader.getSceneRoot("AffiliateMarketerContentCreationScene.fxml"));
    }


    @FXML
    private void logoutButtonOnClick(ActionEvent event) throws IOException {
        newSceneLoader.switchScene("LoginScene.fxml", event);
    }

    @FXML
    private void viewFeedbackMIOnClick(ActionEvent event) {
        affiliateMarketerDashboardBP.setCenter(newSceneLoader.getSceneRoot("AffiliateMarketerViewFeedbackScene.fxml")); 
    }

    @FXML
    private void viewCompGuideMIOnClick(ActionEvent event) {
        affiliateMarketerDashboardBP.setCenter(newSceneLoader.getSceneRoot("ViewPolicyScene.fxml")); 
    }
    
}
