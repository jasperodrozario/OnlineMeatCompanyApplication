package mainpkg;

import java.time.LocalDate;

/**
 *
 * @author Jasper
 */

public class LoggedUserInstance {
    
    static Customer custInst = null;
    static Rider riderInst = null;
    static RegulatoryOfficer regulatoryOfficerInst = null;
    static AccountOfficer accountOfficerInst = null;
    static Vendor vendorInst = null;
    static AffiliateMarketer affiliateMarketerInst = null;
    static CEO ceoInst = null;
    static CCE cceInst = null;
    static LocalDate curDate = LocalDate.now();
    
    
    public static void logUserInstance(String userType, int userId) {
        
        if(userType.equals("Customer")) {
            custInst = Database.getCustomerUserInstance(userId);
        }
        else if(userType.equals("Rider")) {
            riderInst = Database.getRiderUserInstance(userId);
        }
        else if(userType.equals("Regulatory Officer")) {
            regulatoryOfficerInst = Database.getRegulatoryOfficerUserInstance(userId);
        }
        else if(userType.equals("Account Officer")) {
            accountOfficerInst = Database.getAccountOfficerUserInstance(userId);
        }
        else if(userType.equals("Vendor")) {
            vendorInst = Database.getVendorUserInstance(userId);
        }
        else if(userType.equals("Affiliate Marketer")) {
            affiliateMarketerInst = Database.getAffiliateMarketerUserInstance(userId);
        }
        else if(userType.equals("CEO")) {
            ceoInst = Database.getCEOUserInstance(userId);
        }
        else if(userType.equals("CCE")) {
            cceInst = Database.getCCEUserInstance(userId);
        }
        
//        File thisFile = new File("UserLoginHistory.bin");
//        FileOutputStream fos = null;
//        ObjectOutputStream oos = null;
//        
//        try {
//
//            if (thisFile.exists()) {
//                fos = new FileOutputStream(thisFile, true);
//                oos = new AppendObjectOutputStream(fos);
//            }
//            else {
//                fos = new FileOutputStream(thisFile);
//                oos = new ObjectOutputStream(fos);
//            }
//            oos.writeObject(user);
//            oos.close();
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        catch (IOException e) {
//            System.out.println("stfu");
//            e.printStackTrace();
//        }
//        finally {
//            try {
//                if(oos != null) oos.close();
//            } 
//            catch (IOException e) {
//            }
//        } 
    }
    
}
