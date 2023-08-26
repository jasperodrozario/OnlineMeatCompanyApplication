package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class TaxReportAccountant implements Serializable{
    
    int ammount;
    LocalDate date;
    String month;


    
    
    public static boolean addTaxReport() {
        
        File taxReport = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            taxReport = new File("Tax Report.bin");
            if(taxReport.exists()) {
                fos = new FileOutputStream(taxReport, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(taxReport);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(taxReport);
            return true;
        }
        catch (FileNotFoundException e) {
            return false;
        }
        catch(IOException e) {
            return false;
        }
        finally {
            try {
                if(oos != null) oos.close();
            }
            catch(IOException e) {
            }
        }
    }
    
    
    public static TaxReportAccountant readFile() {
        TaxReportAccountant studInst = null;
        File newFile = new File("Tax Report.bin");

        try {
            FileInputStream fis = new FileInputStream(newFile);
            ObjectInputStream ois = new ObjectInputStream(fis);
            studInst = (TaxReportAccountant)ois.readObject();
            ois.close();
            return studInst;
        }
        catch(ClassNotFoundException e) {
            e.printStackTrace();
            return studInst;
        }
        catch(IOException e) {
            return studInst;
        }
    }
    
    public String getToString() {
        String tempStr;
        tempStr = date + ", " + month + ", " + ammount;
        return tempStr;
    }
    
            
    
    
}
