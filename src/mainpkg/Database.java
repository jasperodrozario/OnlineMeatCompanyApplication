package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;

/**
 *
 * @author Jasper
 */

public class Database {
    
    public static boolean addEmployee(String userType, int userId, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj) {
        
        if (userType == "Regulatory Officer") {
            try {
                File f1 = new File("RegulatoryOfficerUser.bin");
                RegulatoryOfficer newUser = new RegulatoryOfficer(userId, userName, gender, password, userDob, userDoj);
                if (f1.exists()) {
                    FileOutputStream fos = new FileOutputStream(f1, true);
                    AppendObjectOutputStream aoos = new AppendObjectOutputStream(fos);
                    aoos.writeObject(newUser);
                    return true;
                }
                else {
                    FileOutputStream fos = new FileOutputStream(f1);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(newUser);
                    return true;
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        
        else if (userType == "Affiliate Marketer") {
            try {
                File f2 = new File("AffiliateOfficerUser.bin");
                AffiliateMarketer newUser = new AffiliateMarketer(userId, userName, gender, password, userDob, userDoj);
                if (f2.exists()) {
                    FileOutputStream fos = new FileOutputStream(f2, true);
                    AppendObjectOutputStream aoos = new AppendObjectOutputStream(fos);
                    aoos.writeObject(newUser);
                    return true;
                }
                else {
                    FileOutputStream fos = new FileOutputStream(f2);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    oos.writeObject(newUser);
                    return true;
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
        }
        else {
            return false;
        }
        
        
//        if(userType == "Regulatory Officer") {
//            RegulatoryOfficer obj;
//            File fileInst = ""
//        }
//        else if(userType == "Affiliate Marketer") {
//            AffiliateMarketer obj;
//        }
//        
        
    }

    
    public static boolean addCustomer(String userType, int userId, String userName, boolean gender, String password, String address) {
        try {
            File f1 = new File("CustomerUser.bin");
            Customer newUser = new Customer(userType, userId, userName, gender, password, address);
            if (f1.exists()) {
                FileOutputStream fos = new FileOutputStream(f1, true);
                AppendObjectOutputStream aoos = new AppendObjectOutputStream(fos);
                aoos.writeObject(newUser);
                return true;
            }
            else {
                FileOutputStream fos = new FileOutputStream(f1);
                ObjectOutputStream oos = new ObjectOutputStream(fos);
                oos.writeObject(newUser);
                return true;
            }
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    
    public static boolean verifyUserPassword(String userType, int userId, String password) throws FileNotFoundException, IOException, ClassNotFoundException {
        boolean flag = false;
        String fileName = "";
        
        if(userType.equals("Customer")) {
            fileName = "CustomerUser.bin";
        }
        else if(userType.equals("Regulatory Officer")) {
            fileName = "RegulatoryOfficerUser.bin";
        }        
        else if(userType.equals("Affiliate Marketer")) {
            fileName = "AffiliateMarketerUser.bin";
        }
//        else if(userType.equals("Regulatory Officer")) {
//            fileName = "RegulatoryOfficerUser.bin";
//        }        
//        else if(userType.equals("Regulatory Officer")) {
//            fileName = "RegulatoryOfficerUser.bin";
//        }        
//        else if(userType.equals("Regulatory Officer")) {
//            fileName = "RegulatoryOfficerUser.bin";
//        }        
//        else if(userType.equals("Regulatory Officer")) {
//            fileName = "RegulatoryOfficerUser.bin";
//        }        
//        else if(userType.equals("Regulatory Officer")) {
//            fileName = "RegulatoryOfficerUser.bin";
//        }        
        if(userType.equals("Customer")) {
            File userFile = new File(fileName);
            Customer tempInst;
            if(userFile.exists()) {
                FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (Customer)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password == password) {
                            System.out.println("ekhane shomossha hocche");
                            flag = true;
                            return flag;
                        }
                        else {
                            System.out.println("else e shomossha hocche");

                            flag = false;
                        }
                    }
                return flag;
                }
            }
            else {
                System.out.println("last else e shomossha hocche");

                return false;
            }
        }
        
        else if(userType.equals("Regulatory Officer")) {
            File userFile = new File(fileName);
            RegulatoryOfficer tempInst;
            if(userFile.exists()) {
                FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (RegulatoryOfficer)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password == password) {
                            flag = true;
                            return flag;
                        }
                        else {
                            flag = false;
                        }
                    }
                return flag;
                }
            }
            else {
                return false;
            }
        }
        
        else if(userType.equals("Affiliate Marketer")) {
            File userFile = new File(fileName);
            AffiliateMarketer tempInst;
            if(userFile.exists()) {
                FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (AffiliateMarketer)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password == password) {
                            flag = true;
                            return flag;
                        }
                        else {
                            flag = false;
                        }
                    }
                return flag;
                }
            }
            else {
                return false;
            }
        }
        
        else {
            return flag;
        }
    }
    
}