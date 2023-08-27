package mainpkg;

import java.awt.Desktop;
import java.net.URI;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

/**
 * FXML Controller class
 *
 * @author Jasper
 */
public class StartInstMeetingSceneController implements Initializable {

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void strtMeetBtnOnClick(ActionEvent event) {
        String url = "https://meet.google.com/aif-updb-pdu";

        try {
            // Use the Desktop class to open the URL in the default web browser
            if (Desktop.isDesktopSupported() && Desktop.getDesktop().isSupported(Desktop.Action.BROWSE)) {
                Desktop.getDesktop().browse(new URI(url));
            } else {
                System.out.println("Desktop browsing not supported.");
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
