package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import javafx.scene.control.Alert;
import static mainpkg.Database.anAlert;

/**
 *
 * @author DELL
 */

public class VaccinationUpdate {
    
    public static boolean addVaccine(String vaccineName, LocalDate vaccinationDate) {
        
        Vaccine newVaccine = new Vaccine(vaccineName, vaccinationDate);
        
        File vaccinationUpdateFile = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            vaccinationUpdateFile = new File("VaccinationUpdates.bin");
            if(vaccinationUpdateFile.exists()) {
                fos = new FileOutputStream(vaccinationUpdateFile, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(vaccinationUpdateFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newVaccine);
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
