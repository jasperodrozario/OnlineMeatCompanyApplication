package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class InvestorsListController implements Initializable {

    @FXML
    private TextField NameTextField;
    @FXML
    private TextField addresstextfield;
    @FXML
    private TableView<Investor> investorsTV;
    @FXML
    private TableColumn<Investor, String> investorNameCol;
    @FXML
    private TableColumn<Investor, String> addressCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        investorNameCol.setCellValueFactory(new PropertyValueFactory<Investor, String> ("investorsName"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Investor, String> ("address"));
    }    

    @FXML
    private void AddInvestorOnClick(ActionEvent event) {
        CEO.addInvestors(NameTextField.getText(), addresstextfield.getText());
        NameTextField.setText("");
        addresstextfield.setText("");
    }

    @FXML
    private void ViewInvestorOnClick(ActionEvent event) {
        investorsTV.setItems(Investor.getAllInvestors());
    }
    
}
