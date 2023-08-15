package mainpkg;

/**
 *
 * @author Jasper
 */

public class Customer extends User{
    
    public String address;
    
    public Customer(String userType, int userId, String userName, boolean gender, String password, String address) {
        this.userType = userType;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.address = address;
    };
   
    @Override
    public boolean login() { 
        LoggedUserInstance.logUserInstance(userType, userId);
        return true;
    }
    
    @Override
    public boolean changePassword() {
        return true;
        
    }
    
    public void addToCart(String productName, int productQuantity, float productPrice) {
        Product newProduct = new Product(productName, productQuantity, productPrice);
        Cart.addProduct(newProduct);
    }
    
    public boolean confirmOrder() {
        Order newOrder = new Order(userId, userName, Cart.getCart(), LoggedUserInstance.curDate, address);
        return Order.addOrder(newOrder);
    }
    
}
