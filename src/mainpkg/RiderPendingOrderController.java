package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class RiderPendingOrderController implements Initializable {

    @FXML
    private TableView<Order> pendingOrdersTV;
    @FXML
    private TableColumn<Order, LocalDate> dateCol;
    @FXML
    private TableColumn<Order, Integer> orderIdCol;
    @FXML
    private TableColumn<Order, String> locationCol;
    @FXML
    private TableColumn<Order, String> riderNameCol;
    @FXML
    private TableColumn<Order, String> phoneNumberCol;
    @FXML
    private TableColumn<Order, String> deliveryStatusCol;
    @FXML
    private ComboBox<Integer> selectOrderCB;
    
    Alert anErrorAlert = new Alert(Alert.AlertType.ERROR);
    Alert anInfoAlert = new Alert(Alert.AlertType.INFORMATION);
    SceneLoader sceneLoader = new SceneLoader();
    Rider loggedUserInst = LoggedUserInstance.riderInst;
    ObservableList<Order> orderList;
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        orderIdCol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("orderId"));
        riderNameCol.setCellValueFactory(new PropertyValueFactory<Order, String>("riderName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Order, String>("phoneNumber"));
        deliveryStatusCol.setCellValueFactory(new PropertyValueFactory<Order, String>("deliveryStatus"));
        locationCol.setCellValueFactory(new PropertyValueFactory<Order, String>("customerAddress"));
        dateCol.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("orderDate"));
        
        orderList = Order.getRiderOrder(loggedUserInst.userId, false);
        
        for(Order order: orderList) {
            selectOrderCB.getItems().add(order.orderId);
        }
        pendingOrdersTV.setItems(orderList);
    }    

    @FXML
    private void rtrnHomeBtnOnClick(ActionEvent event) throws IOException {
        sceneLoader.switchScene("RiderDashboardScene.fxml", event);
    }

    @FXML
    private void updateDelStatBtnOnClick(ActionEvent event) {
        if(loggedUserInst.updateDeliveryStatus(selectOrderCB.getValue())) {
            pendingOrdersTV.setItems(Order.getRiderOrder(loggedUserInst.userId, false));
            anInfoAlert.setContentText("Status updated successfully.");
        }
        else {
            anErrorAlert.setContentText("Something went wrong. Status was not updated.");
        }
    }
    
}
