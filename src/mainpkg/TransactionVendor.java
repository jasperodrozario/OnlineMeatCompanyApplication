/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
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
 * @author DELL
 */
public class TransactionVendor implements Serializable {
    
    String product;
    int amount,price;
    LocalDate date;

    public TransactionVendor(String product, int amount, int price, LocalDate date) {
        this.product = product;
        this.amount = amount;
        this.price = price;
        this.date = date;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
    
    public boolean addTransactionReport() {
        
        File transactionFile = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            transactionFile = new File("TransactionReportVendor.bin");
            if(transactionFile.exists()) {
                fos = new FileOutputStream(transactionFile, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(transactionFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);
            return true;
        }
        catch (FileNotFoundException e) {
            return false;
        }
        catch(IOException e) {
            return false;
        }
        finally {
            try {
                if(oos != null) oos.close();
            }
            catch(IOException e) {
            }
        }
    }
    
    
    public static ObservableList<TransactionVendor> getTransactionReport() {
        ObservableList<TransactionVendor> transaction = FXCollections.observableArrayList();
        TransactionVendor tempInst;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        try{
            File f1 = new File("TransactionReportVendor.bin");
            fis = new FileInputStream(f1);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (TransactionVendor)ois.readObject();
                transaction.add(tempInst);
            }
        }
        catch(IOException e) { 
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            try {
                if(ois != null) {
                    ois.close();
                }
            }
            catch(IOException e) {
            }
            return transaction;
        }
    }
    
}
