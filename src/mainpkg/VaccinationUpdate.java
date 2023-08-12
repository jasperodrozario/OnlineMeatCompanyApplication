package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;

/**
 *
 * @author DELL
 */

public class VaccinationUpdate implements Serializable {
    String vaccineName;
    LocalDate vaccinationDate;
    
    public VaccinationUpdate(String vaccineName, LocalDate vaccinationDate) {
        this.vaccineName = vaccineName;
        this.vaccinationDate = vaccinationDate;
    }
}
