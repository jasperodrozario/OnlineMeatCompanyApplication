package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class CEOViewEmployeeListController implements Initializable {

    @FXML
    private ComboBox<String> designationComboBox;
    @FXML
    private TableView<Employee> empListTV;
    @FXML
    private TableColumn<Employee, Integer> empIdCol;
    @FXML
    private TableColumn<Employee, String> empNameCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        empIdCol.setCellValueFactory(new PropertyValueFactory<Employee, Integer>("userId"));
        empNameCol.setCellValueFactory(new PropertyValueFactory<Employee, String>("userName"));
        designationComboBox.getItems().addAll("Account Officer", "Regulatory Officer", "CCE", "Affliated Marketer", "Vendor");
    }    

    @FXML
    private void viewemployeeonclick(ActionEvent event) {
        if(designationComboBox.getValue().equals("Account Officer")) {
            empListTV.setItems(Database.getAllAccountOfficers());
        }
        else if(designationComboBox.getValue().equals("Regulatory Officer")) {
            empListTV.setItems(Database.getAllRegulatoryOfficers());
        }
        else if(designationComboBox.getValue().equals("CCE")) {
            empListTV.setItems(Database.getAllCCE());
        }
        else if(designationComboBox.getValue().equals("Affliated Marketer")) {
            empListTV.setItems(Database.getAllAffliatedMarketers());
        }
        else if(designationComboBox.getValue().equals("Vendor")) {
            empListTV.setItems(Database.getAllVendors());
        }
    }
    
}
