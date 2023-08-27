package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class AffiliateMarketerContentCreationSceneController implements Initializable {

    @FXML
    private TextArea contentDescTA;
    @FXML
    private TextField contentTitleTF;

    
    Alert anInfoAlert = new Alert(Alert.AlertType.INFORMATION);
    Alert anErrorAlert = new Alert(Alert.AlertType.ERROR);
    SceneLoader newSceneLoader = new SceneLoader();
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void rtrnHomeBtnOnClick(ActionEvent event) throws IOException {
        newSceneLoader.switchScene("AffiliateMarketerDashboard.fxml", event);
        
    }

    @FXML
    private void uploadBtnOnClick(ActionEvent event) {
        if(LoggedUserInstance.affiliateMarketerInst.makeContent(contentTitleTF.getText(), contentDescTA.getText())) {
            contentDescTA.setText(null);
            contentTitleTF.setText(null);
            anInfoAlert.setContentText("Content uploaded successfully");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Content upload failed. Try again later");
            anErrorAlert.show();
        }
    }
    
}
