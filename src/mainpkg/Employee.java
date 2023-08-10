package mainpkg;

import java.time.LocalDate;

/**
 *
 * @author Jasper
 */

public abstract class Employee extends User{
    protected LocalDate userDob, userDoj;
    public abstract boolean applyForLeave();
}
