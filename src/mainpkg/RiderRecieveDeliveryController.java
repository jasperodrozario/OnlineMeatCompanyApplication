package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.util.converter.IntegerStringConverter;

/**
 * FXML Controller class
 *
 * @author PC
 */
public class RiderRecieveDeliveryController implements Initializable {

    @FXML
    private TableView<Order> recieveOrderTV;
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
    private TableColumn<Order, Void> deliveryStatusCol;

    static Rider loggedUserInst = LoggedUserInstance.riderInst;
    SceneLoader newSceneLoader = new SceneLoader();
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        dateCol.setCellValueFactory(new PropertyValueFactory<Order, LocalDate>("orderDate"));
        orderIdCol.setCellValueFactory(new PropertyValueFactory<Order, Integer>("orderId"));
        locationCol.setCellValueFactory(new PropertyValueFactory<Order, String>("customerAddress"));
        riderNameCol.setCellValueFactory(new PropertyValueFactory<Order, String>("riderName"));
        phoneNumberCol.setCellValueFactory(new PropertyValueFactory<Order, String>("phoneNumber"));
        deliveryStatusCol.setCellFactory(param -> new TableCellWithButton());
        
        recieveOrderTV.setItems(Order.getUndeliveredOrder());
    }

    @FXML
    private void rtrnHomeBtnOnClick(ActionEvent event) throws IOException {
        newSceneLoader.switchScene("CustomerDashboardScene.fxml", event);
    }
    
    public static class TableCellWithButton extends javafx.scene.control.TableCell<Order, Void> {
        private final Button button = new Button("Accept Order");

        public TableCellWithButton() {
            button.setOnAction(event -> {
                // Access the item associated with this cell
                Order order = getTableView().getItems().get(getIndex());
                order.associateRider(loggedUserInst.userId, loggedUserInst.userName);
                // Perform your task here, e.g., show a message
                
            });
        }
    }
}
