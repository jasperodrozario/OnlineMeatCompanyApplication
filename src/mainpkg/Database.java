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
                RegulatoryOfficer newUser = new RegulatoryOfficer(userType, userId, userName, gender, password, userDob, userDoj);
                System.out.println(newUser.userId);
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
                AffiliateMarketer newUser = new AffiliateMarketer(userType, userId, userName, gender, password, userDob, userDoj);
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
        boolean flag;
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
            flag = false;
            File userFile = new File("CustomerUser.bin");
            Customer tempInst;
            if(userFile.exists()) {
                FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (Customer)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password.equals(password)) {
                            System.out.println("password milla gese!");
                            flag = true;
                            break;
                        }
                        else {
                            System.out.println("password milenai :)");
                            flag = false;
                        }
                    }
                }
                return flag;
            }
            else {
                System.out.println("File e to nai beta!");
                return false;
            }
        }
        else if(userType.equals("Regulatory Officer")) {
            flag = false;
            File userFile = new File("RegulatoryOfficerUser.bin");
            RegulatoryOfficer tempInst;
            if(userFile.exists()) {
                FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (RegulatoryOfficer)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password.equals(password)) {
                            System.out.println("password milla gese!");
                            flag = true;
                            break;
                        }
                        else {
                            System.out.println("password milenai :)");
                            flag = false;
                        }
                    }
                }
                return flag;
            }
            else {
                System.out.println("File e to nai beta!");
                return false;
            }
        }
        else if(userType.equals("Affiliate Marketer")) {
            flag = false;
            File userFile = new File("AffiliateMarketerUser.bin");
            AffiliateMarketer tempInst;
            if(userFile.exists()) {
                FileInputStream fis = new FileInputStream(userFile);
                ObjectInputStream ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (AffiliateMarketer)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password.equals(password)) {
                            System.out.println("password milla gese!");
                            flag = true;
                            break;
                        }
                        else {
                            System.out.println("password milenai :)");
                            flag = false;
                        }
                    }
                }
                return flag;
            }
            else {
                System.out.println("File e to nai beta!");
                return false;
            }
        }
        else {
            System.out.println("UserType e to thik nai hala!");
            return false;
        }
    }
    
}