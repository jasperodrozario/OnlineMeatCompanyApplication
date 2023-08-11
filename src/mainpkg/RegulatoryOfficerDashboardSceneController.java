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
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("ViewProductDetailsScene.fxml"));
    }

    @FXML
    private void verifyProdLblsMenuItemOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("ViewProductLabelsScene.fxml"));
    }

    @FXML
    private void viewRegulationsOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("ViewRegulationsScene.fxml"));
    }

    @FXML
    private void trainingSessionsMenuOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("TrainingSessionsScene.fxml"));
    }

    @FXML
    private void supplierProductsOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("SupplierProductsScene.fxml"));
    }

    @FXML
    private void riskAssessmentOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("RiskAssessmentScene.fxml"));
    }

    @FXML
    private void DocumentationsMenuOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("DocumentationsAndRegulationsScene.fxml"));
    }
    
}
