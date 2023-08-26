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
    int orderId, customerId, totalPrice, riderId;
    String riderName, customerName, customerAddress, phoneNumber, deliveryStatus;
    static ArrayList<Product> cartList;
    static LocalDate orderDate;
    Boolean delivered;
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
        delivered = false;
        this.setDeliveryStatus(delivered);
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
    
    public static boolean associateRider(int orderId, int riderId, String riderName) {
//        Order.makeOrderCopy();
        ObservableList<Order> tempOrderList = Order.getAllOrders();
        boolean flag = false;
        for(Order order: tempOrderList) {
            if(order.orderId == orderId) {
                order.setRiderId(riderId);
                order.setRiderName(riderName);
                flag = true;
                break;
            }
        }
        if(flag) {
            Order.deleteAllOrders();
            for(Order order: tempOrderList) {
                Order.addOrder(order);
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    public static boolean updateDeliveryStatus(int orderId) {
        ObservableList<Order> tempOrderList = Order.getAllOrders();
        boolean flag = false;
        for(Order order: tempOrderList) {
            if(orderId == order.orderId) {
                order.setDelivered(true);
                flag = true;
                break;
            }
        }
        if(flag) {
            Order.deleteAllOrders();
            for(Order order: tempOrderList) {
                Order.addOrder(order);
            }
            return true;
        }
        else {
            return false;
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
 
    public static ObservableList<Order> getNewOrders() {
        ObservableList<Order> newOrd = FXCollections.observableArrayList();
        Order tempInst = null;
        File orderFile = new File("Order.bin");
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream(orderFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Order)ois.readObject();
                if(tempInst.riderId == 0) {
                    newOrd.add(tempInst);
                }
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
        }
        finally {
            if(ois != null) {
                try {
                    ois.close();
                }
                catch(IOException e) {
                }
            }
            return newOrd;
        }
    }
    
    public static ObservableList<Order> getRiderOrder(int riderId, boolean delivered) {
        ObservableList<Order> riderOrd = FXCollections.observableArrayList();
        Order tempInst = null;
        File orderFile = new File("Order.bin");
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream(orderFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Order)ois.readObject();
                if(delivered) {
                    if(tempInst.delivered) {
                        if(tempInst.riderId == riderId) {
                            riderOrd.add(tempInst);
                        }
                    }
                }
                else {
                    if(!tempInst.delivered) {
                        if(tempInst.riderId == riderId) {
                            riderOrd.add(tempInst);
                        }
                    }
                }
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
        }
        finally {
            if(ois != null) {
                try {
                    ois.close();
                }
                catch(IOException e) {
                }
            }
            return riderOrd;
        }
    }
    
    public static ObservableList<Order> getCustomerOrder(int customerId, boolean delivered) {
        ObservableList<Order> custOrd = FXCollections.observableArrayList();
        Order tempInst = null;
        File orderFile = new File("Order.bin");
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        
        try {
            fis = new FileInputStream(orderFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Order)ois.readObject();
                if(delivered) {
                    if(tempInst.delivered) {
                        if(tempInst.customerId == customerId) {
                            custOrd.add(tempInst);
                        }
                    }
                }
                else {
                    if(!tempInst.delivered) {
                        if(tempInst.customerId == customerId) {
                            custOrd.add(tempInst);
                        }
                    }
                }
            }
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(Exception e) {
        }
        finally {
            if(ois != null) {
                try {
                    ois.close();
                }
                catch(IOException e) {
                }
            }
            return custOrd;
        }
    }
    
    public static ObservableList<Order> getUndeliveredOrder() {
        Order tempInst = null;
        ObservableList<Order> undeliveredList = FXCollections.observableArrayList();
        File orderFile = new File("Order.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(orderFile);
            ois = new ObjectInputStream(fis);
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
            if(ois != null) {
                try {
                    ois.close();
                }
                catch(IOException e) {
                }
            }
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
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        Order tempInst = null;
        File orderFile = new File("Order.bin");
        try {
            fis = new FileInputStream(orderFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Order)ois.readObject();
                allOrders.add(tempInst);
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
            return allOrders;
        }
    }

//    private static void makeOrderCopy() {
//        Order tempInst = null;
//        File orderFile = new File("Order.bin");
//        File orderFile2 = new File("Order2.bin");
//        FileInputStream fis = null;
//        ObjectInputStream ois = null;
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        
//        try {
//            if(orderFile2.exists()) {
//                fos = new FileOutputStream(orderFile2, true);
//                oos = new AppendObjectOutputStream(fos);
//            }
//            else {
//                fos = new FileOutputStream(orderFile2);
//                oos = new ObjectOutputStream(fos);
//            }
//            fis = new FileInputStream(orderFile);
//            ois = new ObjectInputStream(fis);
//            while(true) {
//                tempInst = (Order)ois.readObject();
//                oos.writeObject(tempInst);
//            }
//        }
//        catch(FileNotFoundException e) {
//            errorAlert.setContentText("'Order.bin' file not found!");
//            errorAlert.show();
//        }
//        catch(ClassNotFoundException e) {
//            errorAlert.setContentText("Class not found in 'Order.bin' file!");
//            errorAlert.show();
//        }
//        catch(IOException e) {
//        }
//        finally {
//            try {
//                if(ois != null) ois.close();
//                if(oos != null) oos.close();
//            }
//            catch(IOException e) {
//            }
//        }
//    }
    
    private static void deleteAllOrders() {
        File orderFile = new File("Order.bin");
        if(orderFile.exists()) {
            orderFile.delete();
        }
        else {
            System.out.println("Order.bin file does not exist.");
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

    public boolean getDelivered() {
        return delivered;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
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

    public void setRiderId(int riderId) {
        this.riderId = riderId;
    }

    public void setRiderName(String riderName) {
        this.riderName = riderName;
    }

    public void setDelivered(Boolean delivered) {
        this.delivered = delivered;
        this.setDeliveryStatus(delivered);
    }

    private void setDeliveryStatus(boolean delivered) {
        if(delivered) {
            this.deliveryStatus = "Delivered";
        }
        else {
            this.deliveryStatus = "Pending";
        }
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        //Serializing LocalDate {orderDate}
        out.defaultWriteObject();
        out.writeInt(orderDate.getYear());
        out.writeInt(orderDate.getMonthValue());
        out.writeInt(orderDate.getDayOfMonth());
        
        //Serializing LocalDate {orderDate}
        int size = cartList.size();
        out.writeInt(size);
        for (Product item : cartList) {
            out.writeObject(item);
        }
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        //Deserializing LocalDate {orderDate}
        in.defaultReadObject();
        int year = in.readInt();
        int month = in.readInt();
        int day = in.readInt();
        orderDate = LocalDate.of(year, month, day);
        
        //Deserializing ArrayList {cartList}
        int size = in.readInt();
        cartList = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            Product item = (Product)in.readObject();
            cartList.add(item);
        }
    }
    
}
