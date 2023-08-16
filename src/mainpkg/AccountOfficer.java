package mainpkg;
//abcd
import java.time.LocalDate;

/**
 *
 * @author DELL
 */
public class AccountOfficer extends Employee {
    
    public AccountOfficer(String userType, int userId, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj) {
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
    
    public static boolean submitAuditReport(String auditReportStr, LocalDate curDate) {
        return AuditReportEditAccountant.addReport(auditReportStr, curDate);
    }
    
    public static boolean submitQuotationReport(String quotatioReportStr){
        return QuotationReport.addReport(quotatioReportStr);
    }
}
