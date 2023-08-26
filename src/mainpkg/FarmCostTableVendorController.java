/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
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
public class FarmCostTableVendorController implements Initializable {

    @FXML
    private TableView<FarmCostVendor> farmCostTable;
    @FXML
    private TableColumn<FarmCostVendor, String> monthTableCol;
    @FXML
    private TableColumn<FarmCostVendor, Integer> costTableCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        monthTableCol.setCellValueFactory(new PropertyValueFactory<FarmCostVendor, String>("month"));
        costTableCol.setCellValueFactory(new PropertyValueFactory<FarmCostVendor, Integer>("cost"));
        
    }    

    @FXML
    private void viewCostButtonOnClick(ActionEvent event) {
        
        ObservableList<FarmCostVendor> farmCost = FarmCostVendor.getFarmCostUpdates();
        farmCostTable.setItems(farmCost);
        
    }
    
}
