package mainpkg;

import java.io.Serializable;

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

    public int getUserId() {
        return userId;
    }

    public String getUserType() {
        return userType;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public boolean isGender() {
        return gender;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setGender(boolean gender) {
        this.gender = gender;
    }
    
}
