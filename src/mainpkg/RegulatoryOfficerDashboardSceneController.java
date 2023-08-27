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
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("VaccinationUpdateSceneRegulatoryOfficer.fxml"));
    }

    @FXML
    private void logoutButtonOnClick(ActionEvent event) throws IOException {
        newSceneLoader.switchScene("LoginScene.fxml", event);
    }
    
}
