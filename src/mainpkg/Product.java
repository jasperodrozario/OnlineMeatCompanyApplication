package mainpkg;

/**
 *
 * @author Dell
 */
public class Product {
    String name;
    int quantity, vatRate;
    float price;
    
    public Product(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
//        this.vatRate = vatRate;
    }
    
    public String getProductInfoStr() {
        String toStr;
        toStr = "Product Name: " + name + ", Product Quantity: " + quantity + ", Product Price: " + price;
        return toStr;
    }
}
