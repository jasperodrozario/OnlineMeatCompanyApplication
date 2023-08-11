package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Jasper
 */
public class RegulatoryOfficerDashboardSceneController implements Initializable {

    @FXML
    private BorderPane regulatoryOfficerDashboardBorderPane;
    
    
    public SceneLoader newSceneLoader = new SceneLoader();
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewProdSpecsMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("ProductDetailsScene.fxml"));
    }

    @FXML
    private void verifyProdLblsMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("ProductLabelsScene.fxml"));
    }

    @FXML
    private void strtInstMeetMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("StartInstMeetingScene.fxml"));
    }

    @FXML
    private void schSessMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("ScheduleMeetingSessionScene.fxml"));
    }

    @FXML
    private void sessHistMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("MeetingSessionHistoryScene.fxml"));
    }

    @FXML
    private void viewSuppProdMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("SupplierProductsScene.fxml"));
    }

    @FXML
    private void viewHlthConcRprtMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("HealthConcernReportScene.fxml"));
    }

    @FXML
    private void viewRegRprtMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("RegulationReportScene.fxml"));
    }

    @FXML
    private void viewAnmlCondRprtMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("AnimalConditionReportScene.fxml"));
    }

    @FXML
    private void viewVaccRprtMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("VaccinationReportScene.fxml"));
    }
    
}
