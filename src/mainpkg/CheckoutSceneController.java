package mainpkg;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
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
import javafx.util.converter.FloatStringConverter;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class CheckoutSceneController implements Initializable {
    
    @FXML
    private TableView<ProductFXProperty> cartItemListTableView;
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
    
    ObservableList<ProductFXProperty> cartItemsList = FXCollections.observableArrayList();
    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        for(Product item: Cart.getCart()) {
            ProductFXProperty tempProdFX = new ProductFXProperty(item.name, item.quantity, item.vatRate, item.orgPrice);
            cartItemsList.add(tempProdFX);
        }
        cartItemListTableView.setItems(cartItemsList);
        
        prodNameCol.setCellValueFactory(new PropertyValueFactory<ProductFXProperty, SimpleStringProperty>("name"));
        
        quantityCol.setCellValueFactory(new PropertyValueFactory<ProductFXProperty, SimpleIntegerProperty>("quantity"));
        quantityCol.setCellFactory(TextFieldTableCell.forTableColumn(new IntegerStringConverter()));
        quantityCol.setOnEditCommit(new EventHandler<CellEditEvent<ProductFXProperty, SimpleIntegerProperty>>() {
            @Override
            public void handle(CellEditEvent<ProductFXProperty, Integer> event) {
                ProductFXProperty prod = event.getRowValue();
                prod.setQuantity(event.getNewValue());
                prod.price = prod.orgPrice*prod.quantity;
                Cart.deleteCart();
                for(ProductFXProperty item: cartItemsList) {
                    Product tempProd = new Product();
                    Cart.addProduct(tempProd);
                }
            }
        });
        
        vatRateCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("vatRate"));
        
        priceCol.setCellValueFactory(new PropertyValueFactory<Product, Float>("price"));
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
