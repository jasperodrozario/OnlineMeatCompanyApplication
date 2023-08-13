package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.chart.PieChart;

/**
 *
 * @author Dell
 */
public class Product implements Serializable{
    String name;
    int quantity, vatRate;
    float price;
    
    public Product(String name, int quantity, float price) {
        this.name = name;
        this.quantity = quantity;
        this.price = price;
//        this.vatRate = vatRate;
        Product.addToProductPurchaseLogFile(this);
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
                    beefBoneInCount++;
                }
                else if(tempInst.name.equals("Beef Tehari Cut")) {
                    beefTehariCutCount++;
                }
                else if(tempInst.name.equals("Beef Tenderloin Steak")) {
                    beefTenderloinSteakCount++;
                }
                else if(tempInst.name.equals("Beef T-Bone Steak")) {
                    beefTBoneSteakCount++;
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
    
    
    
}
