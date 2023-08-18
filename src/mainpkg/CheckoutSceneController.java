package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class CheckoutSceneController implements Initializable {
    
    @FXML
    private TableView<Product> cartItemListTableView;
    @FXML
    private TableColumn<Product, String> prodNameCol;
    @FXML
    private TableColumn<Product, Integer> quantityCol;
    @FXML
    private TableColumn<Product, Integer> vatRateCol;
    @FXML
    private TableColumn<Product, Float> priceCol;
    @FXML
    private TextField totalPriceTextField;
    
    ObservableList<Product> cartItemsList = FXCollections.observableArrayList();
    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prodNameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        vatRateCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("vatRate"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Product, Float>("price"));
        
        cartItemsList = Cart.getCart();
        for(Product cartItem: cartItemsList) {
            cartItemListTableView.getItems().add(cartItem);
        }
    }

    @FXML
    private void confirmOrderBtnOnClick(MouseEvent event) {
        if(LoggedUserInstance.custInst.confirmOrder()) {
            anAlert.setContentText("Order Placed Successfully!\nThank you for shopping with Bengal Meat.");
            anAlert.show();
            Cart.deleteCart();
        }
        else{
            anAlert.setContentText("Oops! Something went wrong. Please, try again.");
            anAlert.show();
        }
    }
    
}
