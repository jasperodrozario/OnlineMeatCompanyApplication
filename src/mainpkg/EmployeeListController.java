/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Dell
 */
public class EmployeeListController implements Initializable {

    @FXML
    private TextArea employeeListDisplayTA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void viewEmpListBtnOnClick(MouseEvent event) {
        String tempStr = "Regulatory Officer:\n";
        try {
            File userFile = new File("RegulatoryOfficerUser.bin");
            RegulatoryOfficer tempInst;
            FileInputStream fis = new FileInputStream(userFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (RegulatoryOfficer)ois.readObject();
                tempStr += "Id: " + tempInst.userId + ", Name: " + tempInst.userName + "\n";
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            e.printStackTrace();
        }
        finally {
            employeeListDisplayTA.setText(tempStr);
        }
    }
    
}
