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
    
    
    
    
            
    
    
}
