package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
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
    private TableColumn<Product, Float> pricePerUnitCol;
    @FXML
    private ComboBox<String> availCoupCB;
    @FXML
    private TextField totalPriceTextField;
    
    ObservableList<Product> cartItemsList = FXCollections.observableArrayList();
    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);
    Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    float discountedPrice;
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cartItemsList = Cart.getCart();
        
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
                totalPriceTextField.setText(Float.toString(Cart.getTotalPrice()));
            }
        });
        
        pricePerUnitCol.setCellValueFactory(new PropertyValueFactory<Product, Float>("orgPrice"));
        vatRateCol.setCellValueFactory(new PropertyValueFactory<Product, Integer>("vatRate"));
        priceCol.setCellValueFactory(new PropertyValueFactory<Product, Float>("price"));
        
        cartItemListTableView.setItems(cartItemsList);
        totalPriceTextField.setText(Float.toString(Cart.getTotalPrice()));
        
        if(Cart.getTotalPrice() >= 10000) {
            availCoupCB.getItems().clear();
            availCoupCB.getItems().addAll("10% Discount", "Free 1kg of Beef Bone In");
        }
        else if(Cart.getTotalPrice() >= 5000 && Cart.getTotalPrice() < 10000) {
            availCoupCB.getItems().clear();
            availCoupCB.getItems().addAll("5% Discount", "Free 1kg of Chicken Drumstick (Skin On)");
        }
        else if(Cart.getTotalPrice() >= 2000 && Cart.getTotalPrice() < 5000) {
            availCoupCB.getItems().clear();
            availCoupCB.getItems().addAll("Tk300 Discount", "Free 400gm of Roast Chicken (Sonali)");
        }
        else if(Cart.getTotalPrice() >= 1000 && Cart.getTotalPrice() < 2000) {
            availCoupCB.getItems().clear();
            availCoupCB.getItems().addAll("Tk100 Discount", "One Free Mutton Mix 250gm");
        }
        availCoupCB.getSelectionModel().selectedItemProperty().addListener(
            (observable, oldValue, newValue) -> {
                if(availCoupCB.getValue().equals("10% Discount")) {
                    discountedPrice = Cart.getTotalPrice() - Cart.getTotalPrice()*0.1f;
                    totalPriceTextField.setText(Float.toString(discountedPrice));
                }
                else if(availCoupCB.getValue().equals("5% Discount")) {
                    discountedPrice = Cart.getTotalPrice() - Cart.getTotalPrice()*0.05f;
                    totalPriceTextField.setText(Float.toString(discountedPrice));
                }
                else if(availCoupCB.getValue().equals("Tk300 Discount")) {
                    discountedPrice = Cart.getTotalPrice()-300;
                    totalPriceTextField.setText(Float.toString(discountedPrice));
                }
                else if(availCoupCB.getValue().equals("Tk100 Discount")) {
                    discountedPrice = Cart.getTotalPrice()-100;
                    totalPriceTextField.setText(Float.toString(discountedPrice));
                }
                else if(availCoupCB.getValue().equals("Free 1kg of Beef Bone In")) {
                    totalPriceTextField.setText(Float.toString(Cart.getTotalPrice()));
                }
                else if(availCoupCB.getValue().equals("Free 1kg of Chicken Drumstick (Skin On)")) {
                    totalPriceTextField.setText(Float.toString(Cart.getTotalPrice()));
                }
                else if(availCoupCB.getValue().equals("Free 400gm of Roast Chicken (Sonali)")) {
                    totalPriceTextField.setText(Float.toString(Cart.getTotalPrice()));
                }
                else if(availCoupCB.getValue().equals("One Free Mutton Mix 250gm")) {
                    totalPriceTextField.setText(Float.toString(Cart.getTotalPrice()));
                }
            }
        );
    }

    @FXML
    private void confirmOrderBtnOnClick(MouseEvent event) throws IOException {
        if(Cart.getCart().isEmpty()) {
            errorAlert.setContentText("Your cart is empty. Add item(s) to the cart to checkout.");
            errorAlert.show();
        }
        else {
            if(LoggedUserInstance.custInst.confirmOrder(Float.parseFloat(totalPriceTextField.getText()))) {
                for(Product item: cartItemsList) {
                    Product.addToProductPurchaseLogFile(item);
                }
                Cart.deleteCart();
                totalPriceTextField.setText("0");
                cartItemsList.clear();
                cartItemListTableView.setItems(cartItemsList);
                anAlert.setContentText("Order Placed Successfully!\nThank you for shopping with Bengal Meat.");
                anAlert.show();
            }
            else{
                errorAlert.setContentText("Something went wrong. Please, try again.");
                errorAlert.show();
            }
        }
    }

    @FXML
    private void deleteCartBtnOnClick(ActionEvent event) {
        if(Cart.deleteCart()) {
            totalPriceTextField.setText("0");
            cartItemsList.clear();
            cartItemListTableView.setItems(cartItemsList);
            anAlert.setContentText("Cart has been deleted.");
            anAlert.show();
        }
    }
    
}
