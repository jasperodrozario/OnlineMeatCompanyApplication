package mainpkg;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import static mainpkg.Database.anAlert;

/**
 *
 * @author Jasper
 */

public class Customer extends User{
    
    public String address;
    
    public Customer(String userType, String userName, boolean gender, String password, String address) {
        this.userType = userType;
        this.userId = Customer.generateUniqueUserId();
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.address = address;
    };
    
    public static int generateUniqueUserId() {
        int newId;
        
        if(Customer.getLastCustomerInstance() != null) {
            newId = Customer.getLastCustomerInstance().userId + 1;
            return newId;
        }
        else {
            return newId = 10000;
        }
    }
    
    public static Customer getLastCustomerInstance() {
        Customer lastInst = null;
        File userFile = new File("CustomerUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        if(userFile.exists()) {
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    try {
                        lastInst = (Customer)ois.readObject();
                    }
                    catch (EOFException eof) {
                        // End of file reached
                        return lastInst;
                    }
                }
            }
            catch(FileNotFoundException e) {
                anAlert.setContentText("'CustomerUser.bin' file not found!");
                anAlert.show();
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in 'CustomerUser.bin' file!");
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
    
    @Override
    public boolean login() {
        LoggedUserInstance.logUserInstance(userType, userId);
        return true;
    }
    
    @Override
    public boolean changePassword() {
        return true;
    }
    
    public boolean addToCart(String productName, int productQuantity, int vatRate, float productPrice) {
        Product newProduct = new Product(productName, productQuantity, vatRate, productPrice);
        Cart.addProduct(newProduct);
        return true;
    }
    
    public boolean checkOut() {
        File cartFile = new File("Cart.bin");
        if(cartFile.exists()) {
            return true;
        }
        else {
            return false;
        }
    }
    
    public boolean confirmOrder() {
        Order newOrder = new Order(userId, userName, Cart.getCartArrayList(), address);
        return Order.addOrder(newOrder);
    }
    
}
