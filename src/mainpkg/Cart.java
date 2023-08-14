package mainpkg;

import java.util.ArrayList;

/**
 *
 * @author Jasper
 */

public class Cart {
    static ArrayList<Product> cartList = new ArrayList();
    public Cart(Product newProduct) {
        cartList.add(newProduct);
    }
}
