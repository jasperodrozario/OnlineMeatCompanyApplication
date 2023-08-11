package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import javafx.scene.control.Alert;

/**
 *
 * @author Jasper
 */

public class Database {
    
    static Alert anAlert = new Alert(Alert.AlertType.ERROR);
    
    public static boolean addEmployee(String userType, int userId, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj) {
        
        File f1 = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        if (userType == "Regulatory Officer") {
            try {
                f1 = new File("RegulatoryOfficerUser.bin");
                RegulatoryOfficer newUser = new RegulatoryOfficer(userType, userId, userName, gender, password, userDob, userDoj);
                if (f1.exists()) {
                    fos = new FileOutputStream(f1, true);
                    oos = new AppendObjectOutputStream(fos);
                }
                else {
                    fos = new FileOutputStream(f1);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(newUser);
                oos.close();
                return true;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            finally {
                try {
                    if(oos != null) oos.close();
                }
                catch(IOException e) {
                }
            }
        }
        
        else if (userType == "Affiliate Marketer") {
            try {
                f1 = new File("AffiliateMarketerUser.bin");
                AffiliateMarketer newUser = new AffiliateMarketer(userType, userId, userName, gender, password, userDob, userDoj);
                if (f1.exists()) {
                    fos = new FileOutputStream(f1, true);
                    oos = new AppendObjectOutputStream(fos);
                }
                else {
                    fos = new FileOutputStream(f1);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(newUser);
                oos.close();
                return true;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            finally {
                try {
                    if(oos != null) oos.close();
                } 
                catch (IOException e) {
                }
            }   
        }
        else if (userType == "Rider") {
            try {
                f1 = new File("RiderUser.bin");
                Rider newUser = new Rider(userType, userId, userName, gender, password, userDob, userDoj);
                if (f1.exists()) {
                    fos = new FileOutputStream(f1, true);
                    oos = new AppendObjectOutputStream(fos);
                }
                else {
                    fos = new FileOutputStream(f1);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(newUser);
                oos.close();
                return true;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            finally {
                try {
                    if(oos != null) oos.close();
                } 
                catch (IOException e) {
                }
            }   
        }
        else if (userType == "Account Officer") {
            try {
                f1 = new File("AccountOfficerUser.bin");
                AccountOfficer newUser = new AccountOfficer(userType, userId, userName, gender, password, userDob, userDoj);
                if (f1.exists()) {
                    fos = new FileOutputStream(f1, true);
                    oos = new AppendObjectOutputStream(fos);
                }
                else {
                    fos = new FileOutputStream(f1);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(newUser);
                oos.close();
                return true;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            finally {
                try {
                    if(oos != null) oos.close();
                } 
                catch (IOException e) {
                }
            }   
        }
        else if (userType == "Vendor") {
            try {
                f1 = new File("VendorUser.bin");
                Vendor newUser = new Vendor(userType, userId, userName, gender, password, userDob, userDoj);
                if (f1.exists()) {
                    fos = new FileOutputStream(f1, true);
                    oos = new AppendObjectOutputStream(fos);
                }
                else {
                    fos = new FileOutputStream(f1);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(newUser);
                oos.close();
                return true;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            finally {
                try {
                    if(oos != null) oos.close();
                } 
                catch (IOException e) {
                }
            }   
        }
        else if (userType == "CEO") {
            try {
                f1 = new File("CEOUser.bin");
                CEO newUser = new CEO(userType, userId, userName, gender, password, userDob, userDoj);
                if (f1.exists()) {
                    fos = new FileOutputStream(f1, true);
                    oos = new AppendObjectOutputStream(fos);
                }
                else {
                    fos = new FileOutputStream(f1);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(newUser);
                oos.close();
                return true;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            finally {
                try {
                    if(oos != null) oos.close();
                } 
                catch (IOException e) {
                }
            }   
        }
        else if (userType == "CCE") {
            try {
                f1 = new File("CCEUser.bin");
                CCE newUser = new CCE(userType, userId, userName, gender, password, userDob, userDoj);
                if (f1.exists()) {
                    fos = new FileOutputStream(f1, true);
                    oos = new AppendObjectOutputStream(fos);
                }
                else {
                    fos = new FileOutputStream(f1);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(newUser);
                oos.close();
                return true;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            finally {
                try {
                    if(oos != null) oos.close();
                } 
                catch (IOException e) {
                }
            }   
        }
        else {
            anAlert.setContentText("Unknown user type");
            anAlert.show();
            return false;
        }
    }

    
    public static boolean addCustomer(String userType, int userId, String userName, boolean gender, String password, String address) {
        File f1 = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        if (userType == "Customer") {
            try {
                f1 = new File("CustomerUser.bin");
                Customer newUser = new Customer(userType, userId, userName, gender, password, address);
                if (f1.exists()) {
                    fos = new FileOutputStream(f1, true);
                    oos = new AppendObjectOutputStream(fos);
                }
                else {
                    fos = new FileOutputStream(f1);
                    oos = new ObjectOutputStream(fos);
                }
                oos.writeObject(newUser);
                oos.close();
                return true;
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
                return false;
            }
            catch (IOException e) {
                e.printStackTrace();
                return false;
            }
            finally {
                try {
                    if(oos != null) oos.close();
                } 
                catch (IOException e) {
                }
            }   
        }
        else {
            anAlert.setContentText("Unknown user type");
            anAlert.show();
            return false;
        }
    }
    
    
    public static boolean verifyUserPassword(String userType, int userId, String password) {
        boolean flag;
        
        if(userType.equals("Customer")) {
            flag = false;
            Customer tempInst;
            File userFile = new File("CustomerUser.bin");
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
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
            catch(FileNotFoundException e) {
                anAlert.setContentText("User file not found!");
                anAlert.show();
                return false;
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in user file!");
                anAlert.show();
                return false;
            }
            catch(IOException e) {
                return false;
            }
            finally {
                try {
                    if(ois != null) ois.close();
                }
                catch(IOException e) {
                }
            }
        }
        else if(userType.equals("Regulatory Officer")) {
            flag = false;
            RegulatoryOfficer tempInst;
            File userFile = new File("RegulatoryOfficerUser.bin");
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
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
            catch(FileNotFoundException e) {
                anAlert.setContentText("User file not found!");
                anAlert.show();
                return false;
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in user file!");
                anAlert.show();
                return false;
            }
            catch(IOException e) {
                return false;
            }
            finally {
                try {
                    if(ois != null) ois.close();
                }
                catch(IOException e) {
                }
            }
        }
        else if(userType.equals("Affiliate Marketer")) {
            flag = false;
            AffiliateMarketer tempInst;
            File userFile = new File("AffiliateMarketerUser.bin");
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
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
            catch(FileNotFoundException e) {
                anAlert.setContentText("User file not found!");
                anAlert.show();
                return false;
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in user file!");
                anAlert.show();
                return false;
            }
            catch(IOException e) {
                return false;
            }
            finally {
                try {
                    if(ois != null) ois.close();
                }
                catch(IOException e) {
                }
            }
        }
        else if(userType.equals("Rider")) {
            flag = false;
            Rider tempInst;
            File userFile = new File("RiderUser.bin");
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (Rider)ois.readObject();
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
            catch(FileNotFoundException e) {
                anAlert.setContentText("User file not found!");
                anAlert.show();
                return false;
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in user file!");
                anAlert.show();
                return false;
            }
            catch(IOException e) {
                return false;
            }
            finally {
                try {
                    if(ois != null) ois.close();
                }
                catch(IOException e) {
                }
            }
        }
        else if(userType.equals("Account Officer")) {
            flag = false;
            AccountOfficer tempInst;
            File userFile = new File("AccountOfficerUser.bin");
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (AccountOfficer)ois.readObject();
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
            catch(FileNotFoundException e) {
                anAlert.setContentText("User file not found!");
                anAlert.show();
                return false;
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in user file!");
                anAlert.show();
                return false;
            }
            catch(IOException e) {
                return false;
            }
            finally {
                try {
                    if(ois != null) ois.close();
                }
                catch(IOException e) {
                }
            }
        }
        else if(userType.equals("Vendor")) {
            flag = false;
            Vendor tempInst;
            File userFile = new File("VendorUser.bin");
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (Vendor)ois.readObject();
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
            catch(FileNotFoundException e) {
                anAlert.setContentText("User file not found!");
                anAlert.show();
                return false;
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in user file!");
                anAlert.show();
                return false;
            }
            catch(IOException e) {
                return false;
            }
            finally {
                try {
                    if(ois != null) ois.close();
                }
                catch(IOException e) {
                }
            }
        }
        else if(userType.equals("CEO")) {
            flag = false;
            CEO tempInst;
            File userFile = new File("CEOUser.bin");
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (CEO)ois.readObject();
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
            catch(FileNotFoundException e) {
                anAlert.setContentText("User file not found!");
                anAlert.show();
                return false;
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in user file!");
                anAlert.show();
                return false;
            }
            catch(IOException e) {
                return false;
            }
            finally {
                try {
                    if(ois != null) ois.close();
                }
                catch(IOException e) {
                }
            }
        }
        else if(userType.equals("CCE")) {
            flag = false;
            CCE tempInst;
            File userFile = new File("CCEUser.bin");
            FileInputStream fis = null;
            ObjectInputStream ois = null;
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (CCE)ois.readObject();
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
            catch(FileNotFoundException e) {
                anAlert.setContentText("User file not found!");
                anAlert.show();
                return false;
            }
            catch(ClassNotFoundException e) {
                anAlert.setContentText("Class not found in user file!");
                anAlert.show();
                return false;
            }
            catch(IOException e) {
                return false;
            }
            finally {
                try {
                    if(ois != null) ois.close();
                }
                catch(IOException e) {
                }
            }
        }
        else {
            anAlert.setContentText("Unknown user type!");
            return false;
        } 
    }
}