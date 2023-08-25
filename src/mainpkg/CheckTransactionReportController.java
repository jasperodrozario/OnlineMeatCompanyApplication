package mainpkg;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class CheckTransactionReportController implements Initializable {

    @FXML
    private TableView<Transaction> transactionRprtTV;
    @FXML
    private TableColumn<Transaction, Integer> orderIdCol;
    @FXML
    private TableColumn<Transaction, Float> ammountCol;
    @FXML
    private TableColumn<Transaction, LocalDate> transDateCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        orderIdCol.setCellValueFactory(new PropertyValueFactory<Transaction, Integer>("orderId"));
        ammountCol.setCellValueFactory(new PropertyValueFactory<Transaction, Float>("ammount"));
        transDateCol.setCellValueFactory(new PropertyValueFactory<Transaction, LocalDate>("transactionDate"));
        
        transactionRprtTV.setItems(Transaction.getAllTransaction());
    }    
    
}
