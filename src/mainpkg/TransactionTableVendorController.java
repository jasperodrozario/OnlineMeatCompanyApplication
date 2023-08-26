/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
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
 * @author DELL
 */
public class TransactionTableVendorController implements Initializable {

    @FXML
    private TableView<TransactionVendor> transactionTable;
    @FXML
    private TableColumn<TransactionVendor, String> productCol;
    @FXML
    private TableColumn<TransactionVendor, Integer> amountCol;
    @FXML
    private TableColumn<TransactionVendor, Integer> priceCol;
    @FXML
    private TableColumn<TransactionVendor, LocalDate> dateCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        productCol.setCellValueFactory(new PropertyValueFactory<TransactionVendor, String>("product"));
        amountCol.setCellValueFactory(new PropertyValueFactory<TransactionVendor, Integer>("amount"));
        priceCol.setCellValueFactory(new PropertyValueFactory<TransactionVendor, Integer>("price"));
        dateCol.setCellValueFactory(new PropertyValueFactory<TransactionVendor, LocalDate>("date"));
    }    

    @FXML
    private void veiwTableOnClick(ActionEvent event) {
        
        ObservableList<TransactionVendor> transaction = TransactionVendor.getTransactionReport();
        transactionTable.setItems(transaction);
        
    }
    
}
