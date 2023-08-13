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
    
}
