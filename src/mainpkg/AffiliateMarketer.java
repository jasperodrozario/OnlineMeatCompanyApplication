package mainpkg;

import java.time.LocalDate;

/**
 *
 * @author Jasper
 */

public class AffiliateMarketer extends Employee {
    
    public AffiliateMarketer(int userId, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj) {
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
    public void changePassword() {
        
    }
}
