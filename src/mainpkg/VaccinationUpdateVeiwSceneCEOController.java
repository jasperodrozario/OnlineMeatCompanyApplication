/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class VaccinationUpdateVeiwSceneCEOController implements Initializable {

    @FXML
    private TextArea vaccineUpdateArea;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void veiwVaccineBinOnClick(ActionEvent event) {
        
//        
//        File fileInst = new File("VaccinationUpdate.bin");
//        String tempStr = "";
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
    }
    
}
