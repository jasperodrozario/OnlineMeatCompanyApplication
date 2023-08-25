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
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author Jasper
 */

public class Order implements Serializable{
    int orderId, customerId, riderId, totalPrice;
    String customerName, customerAddress, phoneNumber, riderName;
    ArrayList<Product> cartList;
    LocalDate orderDate;
    boolean delivered = false;
    static Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    
    public Order(int customerId, String customerName, ArrayList<Product> cartList, String phoneNumber, String customerAddress) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.cartList = cartList;
        this.phoneNumber = phoneNumber;
        this.customerAddress = customerAddress;
        orderId = this.generateUniqueOrderId();
        orderDate = LocalDate.now();
        for(Product item: cartList) totalPrice += item.price;
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
            errorAlert.setContentText("'Order.bin' file not found!");
            errorAlert.show();
        }
        catch(ClassNotFoundException e) {
            errorAlert.setContentText("Class not found in 'Order.bin' file!");
            errorAlert.show();
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
 
    public static Order getRiderOrder(int riderId) {
        Order tempInst = null;
        File orderFile = new File("Order.bin");
        try {
            FileInputStream fis = new FileInputStream(orderFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Order)ois.readObject();
                if(!tempInst.delivered) {
                    if(tempInst.riderId == riderId) {
                        return tempInst;
                    }
                }
            }
        }
        catch(Exception e) {
        }
        finally {
            return tempInst;
        }
    }
    
    public static ObservableList<Order> getCustomerDeliveredOrder(int customerId) {
        Order tempInst = null;
        ObservableList<Order> custOrd = FXCollections.observableArrayList();
        File orderFile = new File("Order.bin");
        try {
            FileInputStream fis = new FileInputStream(orderFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Order)ois.readObject();
                if(tempInst.delivered) {
                    if(tempInst.customerId == customerId) {
                        custOrd.add(tempInst);
                    }
                }
            }
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            return custOrd;
        }
    }
    
    public static ObservableList<Order> getUndeliveredOrder() {
        Order tempInst = null;
        ObservableList<Order> undeliveredList = FXCollections.observableArrayList();
        File orderFile = new File("Order.bin");
        try {
            FileInputStream fis = new FileInputStream(orderFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Order)ois.readObject();
                if(!tempInst.delivered) {
                    undeliveredList.add(tempInst);
                }
            }
        }
        catch(IOException e) {
        }
        catch(Exception e) {
            e.printStackTrace();
        }
        finally {
            return undeliveredList;
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
                errorAlert.setContentText("'Order.bin' file not found!");
                errorAlert.show();
            }
            catch(ClassNotFoundException e) {
                errorAlert.setContentText("Class not found in 'Order.bin' file!");
                errorAlert.show();
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
    
    public static ObservableList<Order> getAllOrders() {
        ObservableList<Order> allOrders = FXCollections.observableArrayList();
        Order tempInst = null;
        File orderFile = new File("Order.bin");
        try {
            FileInputStream fis = new FileInputStream(orderFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Order)ois.readObject();
                allOrders.add(tempInst);
            }
        }
        catch(Exception e) {
        }
        finally {
            return allOrders;
        }
    }

    public int getOrderId() {
        return orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public int getRiderId() {
        return riderId;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public String getCustomerName() {
        return customerName;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getRiderName() {
        return riderName;
    }

    public ArrayList<Product> getCartList() {
        return cartList;
    }

    public LocalDate getOrderDate() {
        return orderDate;
    }

    public boolean isDelivered() {
        return delivered;
    }

    public static Alert getErrorAlert() {
        return errorAlert;
    }
    
    
    
    public String getOrderInfoStr() {
        String toStr = "OrderID: " + orderId + ", CustomerId: " + customerId + ", Customer Name: " + customerName + ", Order Date: " + orderDate + ", Customer Addresss: " + customerAddress;
        return toStr;
    }

    @Override
    public String toString() {
        return "Order{" + "orderId = " + orderId + ", customerId = " + customerId + ", riderId = " + riderId + ", totalPrice = " + totalPrice + ", customerName = " + customerName + ", customerAddress = " + customerAddress + ", phoneNumber = " + phoneNumber + ", riderName = " + riderName + ", cartList = " + cartList + ", orderDate = " + orderDate + ", delivered = " + delivered + '}';
    }
    
}
