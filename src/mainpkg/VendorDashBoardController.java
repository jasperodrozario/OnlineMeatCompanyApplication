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
 * @author DELL
 */
public class VendorDashBoardController implements Initializable {

    @FXML
    private BorderPane vendorDashboardBorderPane;

    SceneLoader newSceneOpener = new SceneLoader();
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void productRequirementsMenuItemOnClick(ActionEvent event) {
        vendorDashboardBorderPane.setCenter(newSceneOpener.getSceneRoot("ProductRequirementSceneVendor.fxml"));
        
    }

    @FXML
    private void productQualityMenuItemOnClick(ActionEvent event) {
        vendorDashboardBorderPane.setCenter(newSceneOpener.getSceneRoot("ProductQualitySceneVendor.fxml"));
    }

    @FXML
    private void quotationReportsMenuItemOnClick(ActionEvent event) {
        vendorDashboardBorderPane.setCenter(newSceneOpener.getSceneRoot("QuotationReportSceneVendor.fxml"));
    }

    @FXML
    private void productDemandMenuItemOnClick(ActionEvent event) {
        vendorDashboardBorderPane.setCenter(newSceneOpener.getSceneRoot("ProductDemandSceneVendor.fxml"));
    }

    @FXML
    private void farmCostMenuItemOnClick(ActionEvent event) {
        vendorDashboardBorderPane.setCenter(newSceneOpener.getSceneRoot("MonthlyFarmCostSceneVendor.fxml"));
    }

    @FXML
    private void vaccinationMenuItemOnClick(ActionEvent event) {
        vendorDashboardBorderPane.setCenter(newSceneOpener.getSceneRoot("ProductQualitySceneVendor.fxml"));
    }

    @FXML
    private void transactionMenuItemOnClick(ActionEvent event) {
        vendorDashboardBorderPane.setCenter(newSceneOpener.getSceneRoot("ProductQualitySceneVendor.fxml"));
    }

    @FXML
    private void reportButtonOnClick(ActionEvent event) {
        vendorDashboardBorderPane.setCenter(newSceneOpener.getSceneRoot("ProductQualitySceneVendor.fxml"));
    }

    @FXML
    private void contactInfoMenuItemOnClick(ActionEvent event) {
        vendorDashboardBorderPane.setCenter(newSceneOpener.getSceneRoot("ProductQualitySceneVendor.fxml"));
    }
    
}
