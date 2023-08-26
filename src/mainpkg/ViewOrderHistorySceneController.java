package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class ViewOrderHistorySceneController implements Initializable {

    @FXML
    private TableView<Order> orderHistTV;
    @FXML
    private TableColumn<Order, Integer> orderIdCol;
    @FXML
    private TableColumn<Order, String> custNameCol;
    @FXML
    private TableColumn<Order, String> addressCol;
    @FXML
    private TableColumn<Order, Integer> totalPriceCol;
    @FXML
    private TableColumn<Order, LocalDate> ordDateCol;
    @FXML
    private TableColumn<Order, String> riderNameCol;
    @FXML
    private TableColumn<Order, String> delvStatCol;
    
    SceneLoader newSceneLoader = new SceneLoader();
    ObservableList<Order> custOrder;

    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        orderIdCol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("orderId"));
        custNameCol.setCellValueFactory(new PropertyValueFactory<Order, String>("customerName"));
        addressCol.setCellValueFactory(new PropertyValueFactory<Order, String>("customerAddress"));
        totalPriceCol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("totalPrice"));
        ordDateCol.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("orderDate"));
        riderNameCol.setCellValueFactory(new PropertyValueFactory<Order, String>("riderName"));
        delvStatCol.setCellValueFactory(new PropertyValueFactory<Order, String>("deliveryStatus"));
        
        custOrder = Order.getCustomerOrder(LoggedUserInstance.custInst.userId, true);
        for(Order order: Order.getCustomerOrder(LoggedUserInstance.custInst.userId, false)) {
            custOrder.add(order);
        }
        orderHistTV.setItems(custOrder);
    }    

    @FXML
    private void rtrnToDashboardBtnOnClick(MouseEvent event) throws IOException {
        newSceneLoader.switchScene("CustomerDashboardScene.fxml", event);
    }
    
}
