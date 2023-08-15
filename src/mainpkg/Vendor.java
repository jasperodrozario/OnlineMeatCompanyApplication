package mainpkg;

import java.time.LocalDate;

/**
 *
 * @author DELL
 */

public class Vendor extends Employee {
    
    public Vendor(String userType, int userId, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj) {
        this.userType = userType;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.userDob = userDob;
        this.gender = gender;
        this.userDoj = userDoj;
        
    };
    
    @Override
    public boolean applyForLeave() {
        return true;
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
    
    public static boolean updateVaccineStatus(String vaccineName, LocalDate vaccinationDate) {
        Vaccine newVaccine = new Vaccine(vaccineName, vaccinationDate);
        return newVaccine.addVaccine();
    }
}
