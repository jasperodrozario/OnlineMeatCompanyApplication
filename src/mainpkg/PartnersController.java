package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class PartnersController implements Initializable {

    @FXML
    private Button addpartnersBtnOnClick;
    @FXML
    private TextField partnersnametextfield;
    @FXML
    private TextField comnametextfield;
    @FXML
    private TableView<Partners> partnersTV;
    @FXML
    private TableColumn<Partners, String> partNameCol;
    @FXML
    private TableColumn<Partners, String> compNameCol;

    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        partNameCol.setCellValueFactory(new PropertyValueFactory<Partners, String> ("partnerName"));
        compNameCol.setCellValueFactory(new PropertyValueFactory<Partners, String> ("companyName"));
    }    

    @FXML
    private void addpartnersBtnOnClick(ActionEvent event) {
        CEO.addPartners(partnersnametextfield.getText(), comnametextfield.getText());
        partnersnametextfield.setText("");
    }

    @FXML
    private void viewpartneronclick(ActionEvent event) {
        partnersTV.setItems(Partners.getAllPartners());
    }
    
}
