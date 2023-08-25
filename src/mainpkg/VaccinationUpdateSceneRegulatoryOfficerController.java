package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class VaccinationUpdateSceneRegulatoryOfficerController implements Initializable {

    @FXML
    private TableView<Vaccine> vaccineUpdateTV;
    @FXML
    private TableColumn<Vaccine, Integer> vendorIdCol;
    @FXML
    private TableColumn<Vaccine, String> vendorNameCol;
    @FXML
    private TableColumn<Vaccine, String> vaccineNameCol;
    @FXML
    private TableColumn<Vaccine, LocalDate> vaccDateCol;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void viewVaccineUpdatesBtnOnClick(ActionEvent event) {
        
    }
    
}
