package mainpkg;

import java.time.LocalDate;

/**
 *
 * @author Dell
 */

public abstract class Employee extends User{
    protected LocalDate userDob, userDoj;
    public abstract boolean applyForLeave();

    public LocalDate getUserDob() {
        return userDob;
    }

    public LocalDate getUserDoj() {
        return userDoj;
    }

    public void setUserDob(LocalDate userDob) {
        this.userDob = userDob;
    }

    public void setUserDoj(LocalDate userDoj) {
        this.userDoj = userDoj;
    }
}
