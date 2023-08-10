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
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class ViewBinFileContentSceneController implements Initializable {

    @FXML
    private TextArea displayTextArea;
    
    Alert anAlert = new Alert(Alert.AlertType.ERROR);
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openCustBinFileBtnOnClick(MouseEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {
        Customer tempObj;
        File fileInst = new File("CustomerUser.bin");
        String tempStr = "";
        if(fileInst.exists()) {
            FileInputStream fis = new FileInputStream(fileInst);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true) {
                tempObj = (Customer)ois.readObject();
                tempStr += "Customer ID: " + tempObj.userId + ", Name: " + tempObj.userName + ", Gender: " + tempObj.gender + ", Password: " + tempObj.password + "\n";
                displayTextArea.setText(tempStr);
            }

        }
        else {
            anAlert.setContentText("File Not Found!");
            anAlert.show();
        }
    }

    @FXML
    private void openRegOffBinFileBtnOnClick(MouseEvent event) throws FileNotFoundException, IOException, ClassNotFoundException {
        RegulatoryOfficer tempObj;
        File fileInst = new File("RegulatoryOfficerUser.bin");
        String tempStr = "";
        if(fileInst.exists()) {
            FileInputStream fis = new FileInputStream(fileInst);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true) {
                tempObj = (RegulatoryOfficer)ois.readObject();
                System.out.println(tempObj.userId);
                tempStr += "Regulatory Officer ID: " + tempObj.userId + ", Name: " + tempObj.userName + ", Gender: " + tempObj.gender + ", Password: " + tempObj.password + "\n";
                displayTextArea.setText(tempStr);
            }

        }
        else {
            anAlert.setContentText("File Not Found!");
            anAlert.show();
        }
    }
}
