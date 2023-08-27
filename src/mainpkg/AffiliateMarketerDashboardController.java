
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
    private void strtInstMeetMenuItemOnClick(ActionEvent event) {
    }

    @FXML
    private void schSessMenuItemOnClick(ActionEvent event) {
    }

    @FXML
    private void sessHistMenuItemOnClick(ActionEvent event) {
    }


    @FXML
    private void policyOnClick(ActionEvent event) {
    }

    @FXML
    private void viewTransactionReportOnClick(ActionEvent event) {
    }

    @FXML
    private void farmcostOnClick(ActionEvent event) {
    }

    @FXML
    private void viewVaccinationReportOnClick(ActionEvent event) {
    }

    @FXML
    private void ViewSaleReportOnClick(ActionEvent event) {
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
    }
    
}
