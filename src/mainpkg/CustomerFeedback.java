package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jasper
 */

public class CustomerFeedback implements Serializable{
    int orderId, customerId;
    String customerName, feedbackStr;
    LocalDate feedbackDate = LocalDate.now();

    public CustomerFeedback(int orderId, int customerId, String customerName, String feedbackStr) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.feedbackStr = feedbackStr;
    }
    
    public static boolean addCustomerFeedback(int orderId, int customerId, String customerName, String feedbackStr) {
        CustomerFeedback newCustomerFeedback = new CustomerFeedback(orderId, customerId, customerName, feedbackStr);
        File feedbackFile = new File("CustomerFeedback.bin");
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            
            if (feedbackFile.exists()) {
                fos = new FileOutputStream(feedbackFile, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(feedbackFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newCustomerFeedback);
            oos.close();
            return true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                if(oos != null) oos.close();
            } 
            catch (IOException e) {
            }
        }
    }
    
    public static ObservableList<CustomerFeedback> getAllCustomerFeedback() {
        ObservableList<CustomerFeedback> allCustomerFeedbacks = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        CustomerFeedback tempInst = null;
        File feedbackFile = new File("CustomerFeedback.bin");
        try {
            fis = new FileInputStream(feedbackFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (CustomerFeedback)ois.readObject();
                allCustomerFeedbacks.add(tempInst);
            }
        }
        catch(FileNotFoundException e) {
            allCustomerFeedbacks = null;
        }
        catch(IOException e) {
        }
        finally {
            try{
                if(ois != null) {
                    ois.close();
                }
            }
            catch(IOException e) {  
            }
            return allCustomerFeedbacks;
        }
    }
    
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(feedbackDate);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        feedbackDate = (LocalDate)in.readObject();
    }
    
}
