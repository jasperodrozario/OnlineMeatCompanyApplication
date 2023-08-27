package mainpkg;

import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextField;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class StartInstMeetingSceneController implements Initializable {

    @FXML
    private TextField gmlTF;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void strtMeetBtnOnClick(ActionEvent event) {
        LoggedUserInstance.regulatoryOfficerInst.startMeetingSession(gmlTF.getText());
    }
}
