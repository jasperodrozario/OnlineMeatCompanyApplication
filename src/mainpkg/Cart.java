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
import static mainpkg.Database.anAlert;

/**
 *
 * @author Jasper
 */

public class Cart {
    
    public static void addProduct(Product newProduct) {
        File cartFile = new File("Cart.bin");
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        ArrayList<Product> tempProdList;
        
        int i;
        boolean flag = false;
        
        if(cartFile.exists()) {
            tempProdList = Cart.getCart();
            for(i=0; i<tempProdList.size(); i++) {
                if(tempProdList.get(i).name == newProduct.name) {
                    flag = true;
                    tempProdList.get(i).quantity += newProduct.quantity;
                    break;
                }
            }
        }
        if(!flag){
            try {
                if(cartFile.exists()) {
                    fos = new FileOutputStream(cartFile, true);
                    oos = new AppendObjectOutputStream(fos);
                }
                else {
                    fos = new FileOutputStream(cartFile);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(newProduct);
                oos.close();
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
            finally {
                try {
                    if(oos != null) oos.close();
                } 
                catch (IOException e) {
                }
            }
        }
    }
    
    public static ArrayList<Product> getCart() {
        ArrayList<Product> cartItemsList = new ArrayList();
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
            anAlert.setContentText("'Cart.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'Cart.bin' file!");
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
            return cartItemsList;
        }
    }
    
    public static void deleteCart() {
        File cartFile = new File("Cart.bin");
        if(cartFile.exists()) {
            cartFile.delete();
        }
        else {
            anAlert.setContentText("Cart file does not exist.");
            anAlert.show();
        }           
    }
}
