package mainpkg;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

/**
 *
 * @author Jasper
 */
public abstract class User implements Serializable{
    protected int userId;
    protected String userType, userName, password, phoneNumber;
    protected boolean gender;
    
    public abstract boolean login();
    public abstract boolean changePassword();
}
