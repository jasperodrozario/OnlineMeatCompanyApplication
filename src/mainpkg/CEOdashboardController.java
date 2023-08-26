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
 * @author Dell
 */

public class CEOdashboardController implements Initializable {
    
    @FXML
    private BorderPane ceoDashboardBorderPane;
    
    SceneLoader newSceneLoader = new SceneLoader();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewSaleRprtMenuItemOnClick(ActionEvent event) {
        ceoDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("SaleReport.fxml"));
    }

    @FXML
    private void viewAuditReportOnClick(ActionEvent event) {
        ceoDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("AuditReportViewScene.fxml"));
    }

    @FXML
    private void viewEmpListOnClick(ActionEvent event) {
        ceoDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("CEOViewEmployeeList.fxml"));
    }

    @FXML
    private void vendorOnClick(ActionEvent event) {
    }

    @FXML
    private void investorOnClick(ActionEvent event) {
    }

    @FXML
    private void viewReportOnClick(ActionEvent event) {
    }

    @FXML
    private void liveChatOnClick(ActionEvent event) {
    }

    @FXML
    private void customersFeedbackOnClick(ActionEvent event) {
    }

    @FXML
    private void partnersOnClick(ActionEvent event) {
    }
    
}
