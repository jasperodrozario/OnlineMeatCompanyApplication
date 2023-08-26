/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
public class ContactSceneVendorController implements Initializable {

    @FXML
    private TableView<ContactVendor> InfoTable;
    @FXML
    private TableColumn<ContactVendor, String> designationCol;
    @FXML
    private TableColumn<ContactVendor, String> phoneCol;
    @FXML
    private TableColumn<ContactVendor, String> mailCol;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        ObservableList<ContactVendor>list = FXCollections.observableArrayList(
            new ContactVendor("CEO","01236547890","ceooffice@gmail.com"),
            new ContactVendor("Account Officer","01324569870","accountoffice@gmail.com"),
            new ContactVendor("Regulatory Officer","01423657890","regulatoryoffice@gmail.com"),
            new ContactVendor("CCE","01523469870","customercareoffice@gmail.com")
    );
        
        designationCol.setCellValueFactory(new PropertyValueFactory<ContactVendor,String>("designation"));
        phoneCol.setCellValueFactory(new PropertyValueFactory<ContactVendor,String>("phone"));
        mailCol.setCellValueFactory(new PropertyValueFactory<ContactVendor,String>("email"));
        
        
        InfoTable.setItems(list);
    }    
    
}
