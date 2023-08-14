package mainpkg;

/**
 *
 * @author Jasper
 */

public class LoggedUserInstance {
    
    static Customer custInst;
    static Rider riderInst;
    static RegulatoryOfficer regulatoryOfficerInst;
    static AccountOfficer accountOfficerInst;
    static Vendor vendorInst;
    static AffiliateMarketer affiliateMarketerInst;
    static CEO ceoInst;
    static CCE cceInst;
    
    
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
