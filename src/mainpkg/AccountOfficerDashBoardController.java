package mainpkg;
//i love filter
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
 * @author DELL
 */

public class AccountOfficerDashBoardController implements Initializable {

    
    @FXML
    private BorderPane accountOfficerBorderPane;
    
    SceneLoader newSceneOpener = new SceneLoader();
    SceneLoader newSceneLoader = new SceneLoader();
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void checkTransictionButtonOnClick(ActionEvent event) {
        accountOfficerBorderPane.setCenter(newSceneOpener.getSceneRoot("CheckTransactionReport.fxml"));
    }

    @FXML
    private void quotattionReportButtonOnClick(ActionEvent event) {
        accountOfficerBorderPane.setCenter(newSceneOpener.getSceneRoot("QuotattionReport.fxml"));
    }

    @FXML
    private void auditReportButtonOnClick(ActionEvent event) {
        accountOfficerBorderPane.setCenter(newSceneOpener.getSceneRoot("AuditReportEditScene.fxml"));
    }

    @FXML
    private void dataAnalysisButtonOnClick(ActionEvent event) {
        accountOfficerBorderPane.setCenter(newSceneOpener.getSceneRoot("AnalysisData.fxml"));
    }

    @FXML
    private void planningButtonOnClick(ActionEvent event) {
        accountOfficerBorderPane.setCenter(newSceneOpener.getSceneRoot("PlanningStratagyPage.fxml"));
    }

    @FXML
    private void policiesButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void taxButtonOnClick(ActionEvent event) {
        accountOfficerBorderPane.setCenter(newSceneOpener.getSceneRoot("TaxReportSceneAccountant.fxml"));
    }

    @FXML
    private void recordButtonOnClick(ActionEvent event) {
    }

    @FXML
    private void logOutButtonOnClick(ActionEvent event) throws IOException{
        
        newSceneLoader.switchScene("LoginScene.fxml", event);
        
    }
}
