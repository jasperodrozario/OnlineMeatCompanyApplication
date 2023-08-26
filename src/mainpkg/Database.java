package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

/**
 *
 * @author Jasper
 */

public class Database {
    
    static Alert anAlert = new Alert(Alert.AlertType.ERROR);
    
    public static boolean addUser(String userType, String userName, boolean gender, String password, LocalDate userDob, LocalDate userDoj, String phoneNumber, String address) {
        
        File f1 = null;
        FileOutputStream fos = null;      
        ObjectOutputStream oos = null;
        
        if (userType == "Customer") {
            try {
                f1 = new File("CustomerUser.bin");
                Customer newUser = new Customer(userType, userName, gender, password, phoneNumber, address);
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
        else if (userType == "Regulatory Officer") {
            try {
                f1 = new File("RegulatoryOfficerUser.bin");
                RegulatoryOfficer newUser = new RegulatoryOfficer(userType, userName, gender, password, userDob, userDoj, phoneNumber);
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
        else if (userType == "Affiliate Marketer") {
            try {
                f1 = new File("AffiliateMarketerUser.bin");
                AffiliateMarketer newUser = new AffiliateMarketer(userType, userName, gender, password, userDob, userDoj, phoneNumber);
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
                Rider newUser = new Rider(userType, userName, gender, password, userDob, userDoj, phoneNumber);
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
                AccountOfficer newUser = new AccountOfficer(userType, userName, gender, password, userDob, userDoj, phoneNumber);
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
                Vendor newUser = new Vendor(userType, userName, gender, password, userDob, userDoj, phoneNumber);
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
                CEO newUser = new CEO(userType, userName, gender, password, userDob, userDoj, phoneNumber);
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
                CCE newUser = new CCE(userType, userName, gender, password, userDob, userDoj, phoneNumber);
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

    
//    public static boolean addCustomer(String userType, int userId, String userName, boolean gender, String password, String address) {
//        File f1 = null;
//        FileOutputStream fos = null;      
//        ObjectOutputStream oos = null;
//        
//        if (userType == "Customer") {
//            try {
//                f1 = new File("CustomerUser.bin");
//                Customer newUser = new Customer(userType, userId, userName, gender, password, address);
//                if (f1.exists()) {
//                    fos = new FileOutputStream(f1, true);
//                    oos = new AppendObjectOutputStream(fos);
//                }
//                else {
//                    fos = new FileOutputStream(f1);
//                    oos = new ObjectOutputStream(fos);
//                }
//                oos.writeObject(newUser);
//                oos.close();
//                return true;
//            }
//            catch (FileNotFoundException e) {
//                e.printStackTrace();
//                return false;
//            }
//            catch (IOException e) {
//                e.printStackTrace();
//                return false;
//            }
//            finally {
//                try {
//                    if(oos != null) oos.close();
//                } 
//                catch (IOException e) {
//                }
//            }   
//        }
//        else {
//            anAlert.setContentText("Unknown user type");
//            anAlert.show();
//            return false;
//        }
//    }
    
//    public static <T> boolean addUser(T userInst, String userType) {
//        File f1 = null;
//        FileOutputStream fos = null;      
//        ObjectOutputStream oos = null;
//        
//        if(userType.equals("Customer")) {
//            f1 = new File("CustomerUser.bin");
//        }
//        else if(userType.equals("Rider")) {
//            f1 = new File("RiderUser.bin");
//        }
//        else if(userType.equals("Regulatory Officer")) {
//            f1 = new File("RegulatoryOfficerUser.bin");
//        }
//        else if(userType.equals("Account Officer")) {
//            f1 = new File("AccountOfficerUser.bin");
//        }
//        else if(userType.equals("Vendor")) {
//            f1 = new File("VendorUser.bin");
//        }
//        else if(userType.equals("Affiliate Marketer")) {
//            f1 = new File("AffiliateMarketerUser.bin");
//        }
//        else if(userType.equals("CEO")) {
//            f1 = new File("CEOUser.bin");
//        }
//        else if(userType.equals("CCE")) {
//            f1 = new File("CCEUser.bin");
//        }
//        else {
//            anAlert.setContentText("Unknown user type");
//            anAlert.show();
//        }
//        
//        try {
//            if (f1.exists()) {
//                fos = new FileOutputStream(f1, true);
//                oos = new AppendObjectOutputStream(fos);
//            }
//            else {
//                fos = new FileOutputStream(f1);
//                oos = new ObjectOutputStream(fos);
//            }
//            oos.writeObject(userInst);
//            oos.close();
//            return true;
//        }
//        catch (FileNotFoundException e) {
//            e.printStackTrace();
//            return false;
//        }
//        catch (IOException e) {
//            e.printStackTrace();
//            return false;
//        }
//        finally {
//            try {
//                if(oos != null) oos.close();
//            } 
//            catch (IOException e) {
//            }
//        }
//    }
    
    public static boolean verifyUserPassword(String userType, int userId, String password) {
        boolean flag = false;
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        
        if(userType.equals("Customer")) {
            Customer tempInst;
            File userFile = new File("CustomerUser.bin");

            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (Customer)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password.equals(password)) {
                            flag = tempInst.login();
                            break;
                        }
                        else {
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
            RegulatoryOfficer tempInst;
            File userFile = new File("RegulatoryOfficerUser.bin");
            
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (RegulatoryOfficer)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password.equals(password)) {
                            flag = tempInst.login();
                            break;
                        }
                    }
                    else {
                        flag = false;
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
            AffiliateMarketer tempInst;
            File userFile = new File("AffiliateMarketerUser.bin");
            
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (AffiliateMarketer)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password.equals(password)) {
                            flag = tempInst.login();
                            break;
                        }
                        else {
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
            Rider tempInst;
            File userFile = new File("RiderUser.bin");

            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (Rider)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password.equals(password)) {
                            flag = tempInst.login();
                            break;
                        }
                        else {
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
            AccountOfficer tempInst;
            File userFile = new File("AccountOfficerUser.bin");

            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (AccountOfficer)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password.equals(password)) {
                            flag = tempInst.login();
                            break;
                        }
                        else {
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
            Vendor tempInst;
            File userFile = new File("VendorUser.bin");
            
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (Vendor)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password.equals(password)) {
                            flag = tempInst.login();
                            break;
                        }
                        else {
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
            CEO tempInst;
            File userFile = new File("CEOUser.bin");
            
            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (CEO)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password.equals(password)) {
                            flag = tempInst.login();
                            break;
                        }
                        else {
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
            CCE tempInst;
            File userFile = new File("CCEUser.bin");

            try {            
                fis = new FileInputStream(userFile);
                ois = new ObjectInputStream(fis);
                while(true) {
                    tempInst = (CCE)ois.readObject();
                    if(tempInst.userId == userId) {
                        if(tempInst.password.equals(password)) {
                            flag = tempInst.login();
                            break;
                        }
                        else {
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
    
    public static Customer getCustomerUserInstance(int userId) {
        Customer tempInst = null;
        File userFile = new File("CustomerUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Customer)ois.readObject();
                if(tempInst.userId == userId) {
                    return tempInst;
                }
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'CustomerUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'CustomerUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return tempInst;
        }
    }
    
    public static RegulatoryOfficer getRegulatoryOfficerUserInstance(int userId) {
        RegulatoryOfficer tempInst = null;
        File userFile = new File("RegulatoryOfficerUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (RegulatoryOfficer)ois.readObject();
                if(tempInst.userId == userId) {
                    return tempInst;
                }
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'RegulatoryOfficerUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'RegulatoryOfficerUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return tempInst;
        }
    }
    public static Rider getRiderUserInstance(int userId) {
        Rider tempInst = null;
        File userFile = new File("RiderUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Rider)ois.readObject();
                if(tempInst.userId == userId) {
                    return tempInst;
                }
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'RiderUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'RiderUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return tempInst;
        }
    }
    public static AccountOfficer getAccountOfficerUserInstance(int userId) {
        AccountOfficer tempInst = null;
        File userFile = new File("AccountOfficerUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (AccountOfficer)ois.readObject();
                if(tempInst.userId == userId) {
                    return tempInst;
                }
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'AccountOfficerUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'AccountOfficerUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return tempInst;
        }
    }
    public static Vendor getVendorUserInstance(int userId) {
        Vendor tempInst = null;
        File userFile = new File("VendorUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Vendor)ois.readObject();
                if(tempInst.userId == userId) {
                    return tempInst;
                }
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'VendorUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'VendorUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return tempInst;
        }
    }
    public static AffiliateMarketer getAffiliateMarketerUserInstance(int userId) {
        AffiliateMarketer tempInst = null;
        File userFile = new File("AffiliateMarketerUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (AffiliateMarketer)ois.readObject();
                if(tempInst.userId == userId) {
                    return tempInst;
                }
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'AffiliateMarketerUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'AffiliateMarketerUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return tempInst;
        }
    }
    public static CEO getCEOUserInstance(int userId) {
        CEO tempInst = null;
        File userFile = new File("CEOUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (CEO)ois.readObject();
                if(tempInst.userId == userId) {
                    return tempInst;
                }
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'CEOUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'CEOUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return tempInst;
        }
    }
    public static CCE getCCEUserInstance(int userId) {
        CCE tempInst = null;
        File userFile = new File("CCEUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (CCE)ois.readObject();
                if(tempInst.userId == userId) {
                    return tempInst;
                }
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'CCEUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'CCEUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return tempInst;
        }
    }
    
    public static ObservableList<Employee> getAllAccountOfficers() {
        ObservableList<Employee> accOffList = FXCollections.observableArrayList();
        AccountOfficer tempInst = null;
        File userFile = new File("AccountOfficerUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (AccountOfficer)ois.readObject();
                accOffList.add(tempInst);
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'AccountOfficerUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'AccountOfficerUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return accOffList;
        }
    }
    
    public static ObservableList<Employee> getAllRegulatoryOfficers() {
        ObservableList<Employee> regOffList = FXCollections.observableArrayList();
        RegulatoryOfficer tempInst = null;
        File userFile = new File("RegulatoryOfficerUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (RegulatoryOfficer)ois.readObject();
                regOffList.add(tempInst);
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'RegulatoryOfficerUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'RegulatoryOfficerUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return regOffList;
        }
    }
    
    public static ObservableList<Employee> getAllVendors() {
        ObservableList<Employee> vendorList = FXCollections.observableArrayList();
        Vendor tempInst = null;
        File userFile = new File("VendorUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (Vendor)ois.readObject();
                vendorList.add(tempInst);
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'VendorUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'VendorUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return vendorList;
        }
    }
    
    public static ObservableList<Employee> getAllCCE() {
        ObservableList<Employee> cceList = FXCollections.observableArrayList();
        CCE tempInst = null;
        File userFile = new File("CCEUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (CCE)ois.readObject();
                cceList.add(tempInst);
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'CCEUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'CCEUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return cceList;
        }
    }
    
    public static ObservableList<Employee> getAllAffiliateMarketers() {
        ObservableList<Employee> affMarkList = FXCollections.observableArrayList();
        AffiliateMarketer tempInst = null;
        File userFile = new File("AffiliateMarketerUser.bin");
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {            
            fis = new FileInputStream(userFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (AffiliateMarketer)ois.readObject();
                affMarkList.add(tempInst);
            }
        }
        catch(FileNotFoundException e) {
            anAlert.setContentText("'AffiliateMarketerUser.bin' file not found!");
            anAlert.show();
        }
        catch(ClassNotFoundException e) {
            anAlert.setContentText("Class not found in 'AffiliateMarketerUser.bin' file!");
            anAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(ois != null) ois.close();
            }
            catch(IOException e) {
            }
            return affMarkList;
        }
    }
    
}