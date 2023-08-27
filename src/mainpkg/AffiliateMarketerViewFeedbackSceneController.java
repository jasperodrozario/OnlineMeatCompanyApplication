package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class AffiliateMarketerViewFeedbackSceneController implements Initializable {

    @FXML
    private TextArea displayTA;

    SceneLoader newSceneLoader = new SceneLoader();
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }    

    @FXML
    private void openRprtBtnOnClick(ActionEvent event) {
        displayTA.setText(LoggedUserInstance.affiliateMarketerInst.viewFeedbackReport());
    }

    @FXML
    private void rtrnHomeBtntOnClick(ActionEvent event) throws IOException {
        newSceneLoader.switchScene("AffiliateMarketerDashboard.fxml", event);
    }
    
}
