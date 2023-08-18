package mainpkg;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import static mainpkg.Database.anAlert;

/**
 *
 * @author Jasper
 */

public class Order implements Serializable{
    int orderId;
    int customerId, riderId;
    String customerName, customerAddress, riderName;
    ArrayList<Product> cartList;
    LocalDate orderDate;
    
    public Order(int customerId, String customerName, ArrayList<Product> cartList, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.cartList = cartList;
        this.customerAddress = customerAddress;
        orderId = this.generateUniqueOrderId();
        orderDate = LocalDate.now();
    }
    
    public static boolean addOrder(Order newOrder) {
        File orderFile;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            orderFile = new File("Order.bin");
            if (orderFile.exists()) {
                fos = new FileOutputStream(orderFile, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(orderFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newOrder);
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
        
    private int generateUniqueOrderId() {
        int newId;
        
        if(Order.getLastOrderInstance() != null) {
            newId = Order.getLastOrderInstance().orderId + 1;
            return newId;
        }
        else {
            return newId = 10000;
        }
    }
    
    public void associateRider(int riderId, String riderName) {
        this.riderId = riderId;
        this.riderName = riderName;
    }
    
    public static Order getOrderInstance(int orderId) {
        Order tempInst = null;
        File userFile = new File("Order.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Order)ois.readObject();
                if(tempInst.orderId == orderId) {
                    return tempInst;
                }
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'Order.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'Order.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return tempInst;
        }
    }
 
    public static Order getLastOrderInstance() {
        Order lastInst = null;
        File orderFile = new File("Order.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(orderFile.exists()) {
            try {            
                fis = new FileInputStream(orderFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    try {
                        lastInst = (Order)ois.readObject();
                    }
                    catch (EOFException eof) {
                        // End of file reached
                        return lastInst;
                    }
                }
            }
            catch(FileNotFoundException e) {
                anAlert.setContentText("'Order.bin' file not found!");
                anAlert.show();
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in 'Order.bin' file!");
                anAlert.show();
            }
            catch(IOException e) {
            }
            finally {
                try {
                    if(ois != null) ois.close();
                }
                catch(IOException e) {
                }
                return lastInst;
            }
        }
        else {
            return lastInst;
        }
    }
    
    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAdress() {
        return customerAddress;
    }

    public ArrayList<Product> getCartList() {
        return cartList;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }
    
    public String getOrderInfoStr() {
        String toStr = "OrderID: " + orderId + ", CustomerId: " + customerId + ", Customer Name: " + customerName + ", Order Date: " + orderDate + ", Customer Addresss: " + customerAddress;
        return toStr;
    }
    
}
