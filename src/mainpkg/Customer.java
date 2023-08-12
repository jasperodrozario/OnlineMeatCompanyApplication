package mainpkg;

import java.time.LocalDate;

/**
 *
 * @author Jasper
 */

public class Customer extends User{
    
    public String address;
    
    public Customer(String userType, int userId, String userName, boolean gender, String password, String address) {
        this.userType = userType;
        this.userId = userId;
        this.userName = userName;
        this.password = password;
        this.gender = gender;
        this.address = address;
    };
   
    public void changePassword() {
        
    }
    
    
}
