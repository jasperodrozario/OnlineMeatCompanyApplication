package mainpkg;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */

public class VaccinationUpdate {
    String vaccineName;
    LocalDate vaccinationDate;
    
    public VaccinationUpdate(String vaccineName, LocalDate vaccinationDate) {
        this.vaccineName = vaccineName;
        this.vaccinationDate = vaccinationDate;
    }
}
