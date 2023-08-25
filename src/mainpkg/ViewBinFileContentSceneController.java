package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
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
    private void openCustBinFileBtnOnClick(MouseEvent event) {
        Customer tempObj;
        File fileInst = new File("CustomerUser.bin");
        String tempStr = "";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(fileInst);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempObj = (Customer)ois.readObject();
                tempStr += "Customer ID: " + tempObj.userId + ", Name: " + tempObj.userName + ", Gender: " + tempObj.gender + ", Password: " + tempObj.password + "\n";
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("File Not Found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            displayTextArea.setText(tempStr);
        }
    }

    @FXML
    private void openRegOffBinFileBtnOnClick(MouseEvent event) {
        RegulatoryOfficer tempObj;
        File fileInst = new File("RegulatoryOfficerUser.bin");
        String tempStr = "";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(fileInst);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempObj = (RegulatoryOfficer)ois.readObject();
                tempStr += "Regulatory Officer ID: " + tempObj.userId + ", Name: " + tempObj.userName + ", Gender: " + tempObj.gender + ", Password: " + tempObj.password + "\n";
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("File Not Found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            displayTextArea.setText(tempStr);
        }
    }

    @FXML
    private void openAffMrkBinFileBtnOnClick(MouseEvent event) {
        AffiliateMarketer tempObj;
        File fileInst = new File("AffiliateMarketerUser.bin");
        String tempStr = "";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(fileInst);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempObj = (AffiliateMarketer)ois.readObject();
                tempStr += "AffiliateMarketer ID: " + tempObj.userId + ", Name: " + tempObj.userName + ", Gender: " + tempObj.gender + ", Password: " + tempObj.password + "\n";
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("File Not Found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
            System.out.println("cnfex");
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            displayTextArea.setText(tempStr);
        }
    }

    @FXML
    private void openPPLbtnOnClick(ActionEvent event) {
        Product tempObj;
        File fileInst = new File("ProductPurchaseLog.bin");
        String tempStr = "";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(fileInst);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempObj = (Product)ois.readObject();
                tempStr += tempObj.getProductInfoStr() + "\n";
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("File Not Found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
            System.out.println("unga");
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            displayTextArea.setText(tempStr);
        }
    }

    @FXML
    private void openCartbtnOnClick(ActionEvent event) {
        Product tempObj;
        File fileInst = new File("Cart.bin");
        String tempStr = "";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(fileInst);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempObj = (Product)ois.readObject();
                tempStr += tempObj.getProductInfoStr() + "\n";
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("File Not Found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            displayTextArea.setText(tempStr);
        }
    }

    @FXML
    private void openOrderbtnOnClick(ActionEvent event) {
        Order tempObj;
        File fileInst = new File("Order.bin");
        String tempStr = "";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(fileInst);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempObj = (Order)ois.readObject();
                tempStr += tempObj.toString() + "\n";
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("File Not Found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            displayTextArea.setText(tempStr);
        }
    }

    @FXML
    private void opeVendorbinOnClick(ActionEvent event) {
        Vendor tempObj;
        File fileInst = new File("VendorUser.bin");
        String tempStr = "";
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(fileInst);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempObj = (Vendor)ois.readObject();
                tempStr += tempObj.toString() + "\n";
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("File Not Found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            displayTextArea.setText(tempStr);
        }
    }
}
