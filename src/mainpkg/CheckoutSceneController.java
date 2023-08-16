package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class CheckoutSceneController implements Initializable {
    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);
    Customer loggedUserInst;
    
    @FXML
    private TableView<Product> cartItemListTableView;
    @FXML
    private TableColumn<Product, String> prodNameCol;
    @FXML
    private TableColumn<Product, Integer> quantityCol;
    @FXML
    private TableColumn<Product, Integer> vatRateCol;
    @FXML
    private TableColumn<Cart, Float> priceCol;
    @FXML
    private TextField totalPriceTextField;
    

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        prodNameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        quantityCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        vatRateCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("vatRate"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Cart, Float>("price"));
        System.out.println(Cart.getCart().get(1));
//        cartItemListTableView.getItems().add(Cart.getCart());
    }    

    @FXML
    private void confirmOrderBtnOnClick(ActionEvent event) {
        
        if(loggedUserInst.confirmOrder()) {
            System.out.println(Order.getLastOrderInstance().orderId);
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
