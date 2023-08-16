package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import java.util.ArrayList;
import javafx.collections.ObservableList;
import static mainpkg.Database.anAlert;

/**
 *
 * @author Jasper
 */

public class Order {
    int orderId;
    int customerId, riderId;
    String customerName, customerAddress, riderName;
    ArrayList<Product> cartList;
    LocalDate orderDate;
    
    public Order(int customerId, String customerName, ArrayList<Product> cartList, LocalDate orderDate, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.cartList = cartList;
        this.orderDate = orderDate;
        this.customerAddress = customerAddress;
        this.orderId = this.generateUniqueOrderId();
    }

    private int generateUniqueOrderId() {
        int uniqueId;
        if(Order.getLastOrderInstance() != null) {
            uniqueId = Order.getLastOrderInstance().orderId++;
            return uniqueId;
        }
        else {
            return uniqueId = 100000;
        }
    }
    
    public void associateRider(int riderId, String riderName) {
        this.riderId = riderId;
        this.riderName = riderName;
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
            System.out.println("fnfe");
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            System.out.println("ioe");
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
        Order tempInst = null;
        File orderFile = new File("Order.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(orderFile.exists()) {
            try {            
                fis = new FileInputStream(orderFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (Order)ois.readObject();
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
        else {
            return null;
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
