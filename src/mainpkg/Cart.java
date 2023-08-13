package mainpkg;

import java.util.ArrayList;

/**
 *
 * @author Jasper
 */

public class Cart {
    
    static ArrayList<Product> cartList = new ArrayList();
    
    public static void addToCart(String productName, int quantity, float price) {
        Product thisProduct = new Product(productName, quantity, price);
        int i;
        
        if(!cartList.isEmpty()) {
            for(i=0; i<cartList.size(); i++) {
                if(cartList.get(i).name.equals(productName)) {
                    cartList.get(i).quantity += quantity;
                }
                else {
                    cartList.add(thisProduct);
                }
            }
        }
        else {
            cartList.add(thisProduct);
        }
        
    }
    
}
