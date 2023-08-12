package mainpkg;

import java.time.LocalDate;
import java.util.ArrayList;

/**
 *
 * @author Jasper
 */

public class Order {
    int orderId, customerId, riderId;
    String customerName, customerAddress, riderName;
    ArrayList<Product> cartList;
    LocalDate orderDate;
    
    public Order(int orderId, int customerId, String customerName, ArrayList<Product> cartList, LocalDate orderDate, String customerAddress) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.customerName = customerName;
        this.cartList = cartList;
        this.orderDate = orderDate;
        this.customerAddress = customerAddress;
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
        String toStr = "OrderID: " + orderId + ", Customer Name: " + customerName + ", Order Date: " + orderDate + ", Customer Addresss: " + customerAddress;
        return toStr;
    }
    
    public void associateRider(int riderId, String riderName) {
        this.riderId = riderId;
        this.riderName = riderName;
    }
    
}
