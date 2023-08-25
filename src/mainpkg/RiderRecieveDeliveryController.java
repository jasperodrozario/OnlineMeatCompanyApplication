package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
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
    private TableColumn<Order, String> deliveryStatusCol;
    @FXML
    private TextField orderIdTextField;
    
    static Rider loggedUserInst = LoggedUserInstance.riderInst;
    SceneLoader newSceneLoader = new SceneLoader();
    Alert anInfoAlert = new Alert(Alert.AlertType.INFORMATION);
    Alert anErrorAlert = new Alert(Alert.AlertType.ERROR);
    
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
        
        recieveOrderTV.setItems(Order.getUndeliveredOrder());
    }
    
    @FXML
    private void rtrnHomeBtnOnClick(ActionEvent event) throws IOException {
        newSceneLoader.switchScene("CustomerDashboardScene.fxml", event);
    }

    @FXML
    private void acceptOrderBtnOnClick(ActionEvent event) {
        if(loggedUserInst.acceptOrder(Integer.parseInt(orderIdTextField.getText()))) {
            orderIdTextField.setText("");
            anInfoAlert.setContentText("Order accepted successfully!");
            anInfoAlert.show();
        }
        else {
            anErrorAlert.setContentText("Invalid Order ID selected.");
            anErrorAlert.show();
        }
    }
    
}
