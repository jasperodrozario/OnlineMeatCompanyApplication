package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author Jasper
 */

public class Cart{
    
    static Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    
    public static boolean addProduct(Product newProduct) {
        File cartFile = new File("Cart.bin");
        ObservableList<Product> tempCartItemsList = FXCollections.observableArrayList();
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        boolean flag = true;
        
        try {
            if(cartFile.exists()) {
                tempCartItemsList = Cart.getCart();
                fos = new FileOutputStream(cartFile);
                oos = new ObjectOutputStream(fos);
                for(Product item: tempCartItemsList) {
                    if(item.name.equals(newProduct.name)) {
                        flag = false;
                        item.quantity += newProduct.quantity;
                        item.price += newProduct.price;
                    }
                }
                if(flag) {
                    tempCartItemsList.add(newProduct);
                }
                for(Product item: tempCartItemsList) {
                    oos.writeObject(item);
                }
                oos.close();
                return true;
            }
            else {
                fos = new FileOutputStream(cartFile);
                oos = new ObjectOutputStream(fos);
                oos.writeObject(newProduct);
                oos.close();
                return true;
            }
        }
        catch (IOException e) {
            return false;
        }
        finally {
            try {
                oos.close();
            }
            catch(Exception e) {
            }
            return false;
        }
    }
    
    public static float getTotalPrice() {
        float totalPrice = 0;
        for(Product item: Cart.getCartArrayList()) totalPrice += item.price;
        return totalPrice;
    }
    
    public static ObservableList<Product> getCart() {
        ObservableList<Product> cartItemsList = FXCollections.observableArrayList();
        Product tempInst;
        File cartFile = new File("Cart.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(cartFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Product)ois.readObject();
                cartItemsList.add(tempInst);
            }
        }
        catch(FileNotFoundException e) {
        }
        catch(ClassNotFoundException e) {
            errorAlert.setContentText("Class not found in 'Cart.bin' file!");
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
            return cartItemsList;
        }
    }
    
    public static ArrayList<Product> getCartArrayList() {
        ArrayList<Product> cartItemsArrayList = new ArrayList();
        for (Product item : Cart.getCart()) {
            cartItemsArrayList.add(item);
        }
        return cartItemsArrayList;
    }
    
    public static boolean deleteCart() {
        File cartFile = new File("Cart.bin");
        if(cartFile.exists()) {
            cartFile.delete();
            return true;
        }
        else {
            errorAlert.setContentText("Cart file does not exist.");
            errorAlert.show();
            return false;
        }           
    }
}
