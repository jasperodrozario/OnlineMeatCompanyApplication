package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javafx.beans.binding.Bindings;
import javafx.beans.property.SimpleFloatProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Alert;


/**
 *
 * @author Dell
 */
public class Product implements Serializable{
    String name;
    int quantity, vatRate;
    float price, orgPrice;
    static Alert errorAlert = new Alert(Alert.AlertType.ERROR);
    
    public Product(String name, int quantity, int vatRate, float price) {
        this.name = name;
        this.quantity = quantity;
        orgPrice = price;
        this.price = orgPrice*quantity;
        this.vatRate = vatRate;
    }

    public String getName() {
        return name;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getVatRate() {
        return vatRate;
    }

    public float getPrice() {
        return price;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setVatRate(int vatRate) {
        this.vatRate = vatRate;
    }

    public void setPrice(float price) {
        this.price = price;
    }
    
    public String getProductInfoStr() {
        String toStr;
        toStr = "Product Name: " + name + ", Product Quantity: " + quantity + ", Product Price: " + price;
        return toStr;
    }
    
    public static void addToProductPurchaseLogFile(Product thisProduct) {
        
        File f1 = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;

        try {
            f1 = new File("ProductPurchaseLog.bin");
            if (f1.exists()) {
                fos = new FileOutputStream(f1, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(f1);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(thisProduct);
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
    
    public static ObservableList<PieChart.Data> getProductSaleRatioChart() {
        ObservableList<PieChart.Data> pieDataSet = FXCollections.observableArrayList();
        
        int beefBoneInCount = 0;
        int beefTehariCutCount = 0;
        int beefTenderloinSteakCount = 0;
        int beefTBoneSteakCount = 0;
        
        File thisFile = null;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        Product tempInst = null;
        try{
            thisFile = new File("ProductPurchaseLog.bin");
            fis = new FileInputStream(thisFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Product)ois.readObject();
                if(tempInst.name.equals("Beef Bone In")) {
                    beefBoneInCount += tempInst.quantity;
                }
                else if(tempInst.name.equals("Beef Tehari Cut")) {
                    beefTehariCutCount += tempInst.quantity;
                }
                else if(tempInst.name.equals("Beef Tenderloin Steak")) {
                    beefTenderloinSteakCount += tempInst.quantity;
                }
                else if(tempInst.name.equals("Beef T-Bone Steak")) {
                    beefTBoneSteakCount += tempInst.quantity;
                }
            }

        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
        }
        finally {
            pieDataSet.add(new PieChart.Data("Beef Bone In", beefBoneInCount));
            pieDataSet.add(new PieChart.Data("Beef Tehari Cut", beefTehariCutCount));
            pieDataSet.add(new PieChart.Data("Beef Tenderloin Steak", beefTenderloinSteakCount));
            pieDataSet.add(new PieChart.Data("Beef T-Bone Steak", beefTBoneSteakCount)); 
            return pieDataSet;
        }
    }
    
    public static Product getProductInstance(SimpleStringProperty productName) {
        Product tempInst = null;
        File userFile = new File("Cart.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Product)ois.readObject();
                if(tempInst.name.equals(productName)) {
                    return tempInst;
                }
            }
        }
        catch(FileNotFoundException e) {
            errorAlert.setContentText("'Cart.bin' file not found!");
            errorAlert.show();
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
            return tempInst;
        }
    }
    
}
