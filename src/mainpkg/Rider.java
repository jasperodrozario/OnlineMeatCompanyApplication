package mainpkg;

import java.time.LocalDate;

/**
 *
 * @author Jasper
 */

public class Rider extends Employee {
    
    String TimeSlot;
    
    public Rider(String userType, int userId, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj) {
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
    
    public boolean login() { 
        LoggedUserInstance.logUserInstance(userType, userId);
        return true;
    }
    
    @Override
    public void changePassword() {
        
    }
}
