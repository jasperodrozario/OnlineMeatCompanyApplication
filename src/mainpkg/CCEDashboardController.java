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
public class CCEDashboardController implements Initializable {
    
     @FXML
    private BorderPane cceDashboardBorderPane;
    
    
    public SceneLoader newSceneLoader = new SceneLoader();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void customerFeedbackOnclick(ActionEvent event) {
        cceDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("CustomerFeedback.fxml"));
    }

    @FXML
    private void giveFeedbackAffiliateMIOnClick(ActionEvent event) {
    }

    @FXML
    private void SaleReportOnClick(ActionEvent event) {
       cceDashboardBorderPane.setCenter(newSceneLoader.getSceneRoot("SaleReport.fxml"));
    }
    
}
