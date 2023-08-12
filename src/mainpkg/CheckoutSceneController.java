/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;

/**
 * FXML Controller class
 *
 * @author Jasper
 */
public class CheckoutSceneController implements Initializable {

    Order newOrder;
    LocalDate currentDate = LocalDate.now();
    Alert anAlert = new Alert(Alert.AlertType.INFORMATION);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void confirmOrderBtnOnClick(ActionEvent event) {
        File f1 = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        try {
            f1 = new File("OrderLog.bin");
            newOrder = new Order(1234, 4321, "jasper", Cart.cartList, currentDate, "45/A");
            if (f1.exists()) {
                fos = new FileOutputStream(f1, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(f1);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newOrder);
            oos.close();
            anAlert.setTitle("Order Successfully Confirmed!");
            anAlert.setContentText("Payment Method: Cash on delivery");
            anAlert.show();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            anAlert.setAlertType(Alert.AlertType.ERROR);
            anAlert.setContentText("Oops! Something went wrong. Try again.");
            anAlert.show();
        }
        catch (IOException e) {
            e.printStackTrace();
            anAlert.setAlertType(Alert.AlertType.ERROR);
            anAlert.setContentText("Oops! Something went wrong. Try again.");
            anAlert.show();
        }
        finally {
            try {
                if(oos != null) oos.close();
            } 
            catch (IOException e) {
            }
        }
    }
    
}
