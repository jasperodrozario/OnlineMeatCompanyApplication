package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

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
        vendorIdCol.setCellValueFactory(new PropertyValueFactory<Vaccine, Integer>("vendorId"));
        vendorNameCol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("vendorName"));
        vaccineNameCol.setCellValueFactory(new PropertyValueFactory<Vaccine, String>("vaccineName"));
        vaccDateCol.setCellValueFactory(new PropertyValueFactory<Vaccine, LocalDate>("vaccineDate"));
    }    

    @FXML
    private void viewVaccineUpdatesBtnOnClick(ActionEvent event) {
        ObservableList<Vaccine> vaccineList = Vaccine.getAllVaccineUpdates();
        vaccineUpdateTV.setItems(vaccineList);
    }
    
}
