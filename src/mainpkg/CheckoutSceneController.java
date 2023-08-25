package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.input.MouseEvent;
import javafx.util.converter.IntegerStringConverter;

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
        for(Product item: Cart.getCart()) {
            Product tempProd = new Product(item.name, item.quantity, item.vatRate, item.orgPrice);
            cartItemsList.add(tempProd);
        }
        cartItemListTableView.setItems(cartItemsList);
        
        prodNameCol.setCellValueFactory(new PropertyValueFactory<Product, String>("name"));
        
        quantityCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("quantity"));
        quantityCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        quantityCol.setOnEditCommit(new EventHandler<CellEditEvent<Product, Integer>>() {
            @Override
            public void handle(CellEditEvent<Product, Integer> event) {
                Product prod = event.getRowValue();
                prod.setQuantity(event.getNewValue());
                prod.price = prod.orgPrice*prod.quantity + (prod.orgPrice*prod.quantity*prod.vatRate)/100;
                Cart.deleteCart();
                for(Product item: cartItemsList) {
                    Cart.addProduct(item);
                }
            }
        });
        
        vatRateCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("vatRate"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Product, Float>("price"));
        
        totalPriceTextField.setText(Integer.toString(Cart.getTotalPrice()));
    }

    @FXML
    private void confirmOrderBtnOnClick(MouseEvent event) {
        if(LoggedUserInstance.custInst.confirmOrder()) {
            for(Product item: cartItemsList) {
                Product.addToProductPurchaseLogFile(item);
            }
            Cart.deleteCart();
            anAlert.setContentText("Order Placed Successfully!\nThank you for shopping with Bengal Meat.");
            anAlert.show();

        }
        else{
            anAlert.setContentText("Oops! Something went wrong. Please, try again.");
            anAlert.show();
        }
    }
    
}
