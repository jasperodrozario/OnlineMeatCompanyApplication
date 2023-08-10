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
public class RegulatoryOfficerDashboardSceneController implements Initializable {

    @FXML
    private BorderPane regulatoryOfficerDashboardBorderPane;
    
    
    public SceneLoader sceneLoader;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void qualityControlMenuOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(sceneLoader.getSceneRoot("QualityControlScene.fxml"));
    }

    @FXML
    private void viewProductLabelsMenuOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(sceneLoader.getSceneRoot("ViewProductLabelsScene.fxml"));
    }

    @FXML
    private void viewRegulationsOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(sceneLoader.getSceneRoot("ViewRegulationsScene.fxml"));
    }

    @FXML
    private void trainingSessionsMenuOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(sceneLoader.getSceneRoot("TrainingSessionsScene.fxml"));
    }

    @FXML
    private void supplierProductsOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(sceneLoader.getSceneRoot("SupplierProductsScene.fxml"));
    }

    @FXML
    private void riskAssessmentOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(sceneLoader.getSceneRoot("RiskAssessmentScene.fxml"));
    }

    @FXML
    private void DocumentationsMenuOnClick(ActionEvent event) {
        regulatoryOfficerDashboardBorderPane.setCenter(sceneLoader.getSceneRoot("DocumentationsAndRegulationsScene.fxml"));
    }
    
}
