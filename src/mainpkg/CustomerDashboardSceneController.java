/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.BorderPane;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class CustomerDashboardSceneController implements Initializable {

    @FXML
    private BorderPane customerBorderPane;

    SceneLoader newSceneOpener = new SceneLoader();

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void beefMenuItemOnClick(ActionEvent event) {
        customerBorderPane.setCenter(newSceneOpener.getSceneRoot("BeefScene.fxml"));
    }

    @FXML
    private void muttonMenuItemOnClick(ActionEvent event) {
        customerBorderPane.setCenter(newSceneOpener.getSceneRoot("MuttonScene.fxml")); 
    }

    @FXML
    private void poultryMenuItemOnClick(ActionEvent event) {
        customerBorderPane.setCenter(newSceneOpener.getSceneRoot("PoultryScene.fxml"));
    }

    @FXML
    private void fishMenuItemOnClick(ActionEvent event) {
        customerBorderPane.setCenter(newSceneOpener.getSceneRoot("FishScene.fxml"));
    }

    @FXML
    private void groceryMenuItemOnClick(ActionEvent event) {
        customerBorderPane.setCenter(newSceneOpener.getSceneRoot("GroceryScene.fxml"));
    }

    @FXML
    private void viewOrderMIOnClick(ActionEvent event) {
        customerBorderPane.setCenter(newSceneOpener.getSceneRoot("TrackOrderScene.fxml"));
    }

    @FXML
    private void orderHistMIOnClick(ActionEvent event) {
        customerBorderPane.setCenter(newSceneOpener.getSceneRoot("ViewOrderHistoryScene.fxml"));
    }
    
}
