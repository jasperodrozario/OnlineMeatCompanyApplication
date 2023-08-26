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

    private void viewHlthConcRprtMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("HealthConcernReportScene.fxml"));
    }

    private void viewRegRprtMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("RegulationReportScene.fxml"));
    }

    private void viewAnmlCondRprtMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("AnimalConditionReportScene.fxml"));
    }

    private void viewVaccRprtMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("VaccinationUpdateSceneRegulatoryOfficer.fxml"));
    }

    @FXML
    private void ViewSaleReportOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("SaleReport.fxml"));
    }

    @FXML
    private void policyOnClick(ActionEvent event) {
         regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("PolicisesRegulatoryOfficer.fxml"));
    }

    @FXML
    private void viewTransactionReportOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("TransactionTableVendor.fxml"));
    }

    @FXML
    private void farmcostOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("FarmCostTableVendor.fxml"));
    }

    @FXML
    private void viewVaccinationReportOnClick(ActionEvent event) {
    }

    @FXML
    private void logoutButtonOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("LoginScene.fxml"));
    }
    
}
