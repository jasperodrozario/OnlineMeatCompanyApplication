/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpkg;

/**
 *
 * @author Dell
 */
public class Product {
    String name;
    int quantity;
    float price;
    public Product(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
    
    public String getProductInfo() {
        String tempStr;
        tempStr = "Product Name: " + name;
        return tempStr;
    }
}
