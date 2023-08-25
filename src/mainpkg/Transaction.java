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

public class Transaction implements Serializable{
    int orderId;
    float ammount;
    LocalDate transactionDate;

    public Transaction(int orderId, float ammount, LocalDate transactionDate) {
        this.orderId = orderId;
        this.ammount = ammount;
        this.transactionDate = transactionDate;
        this.addTransaction();
    }

    public void addTransaction() {
        File transactionFile;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            transactionFile = new File("Transaction.bin");
            if(transactionFile.exists()) {
                fos = new FileOutputStream(transactionFile, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(transactionFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);
            oos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
        }
        finally {
            try {
                if(oos != null) oos.close();
            } 
            catch (IOException e) {
            }
        }
    }
    
    public static ObservableList<Transaction> getAllTransaction() {
        ObservableList<Transaction> transList = FXCollections.observableArrayList();
        
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        Transaction tempInst = null;
        File orderFile = new File("Transaction.bin");
        try {
            fis = new FileInputStream(orderFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Transaction)ois.readObject();
                transList.add(tempInst);
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
        }
        finally {
            try{
                if(ois != null) {
                    ois.close();
                }
            }
            catch(IOException e) {  
            }
            return transList;
        }
    }
    
    public int getOrderId() {
        return orderId;
    }

    public float getAmmount() {
        return ammount;
    }

    public LocalDate getTransactionDate() {
        return transactionDate;
    }
    
}
