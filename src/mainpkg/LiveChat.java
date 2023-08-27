package mainpkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import static mainpkg.Order.errorAlert;

/**
 *
 * @author Jasper
 */

public class LiveChat {
    public static boolean liveChat(int user1Id, boolean user1, int user2Id, boolean user2, String msg) {
        String tempStr = user1Id + "-" + user2Id + ".bin";
        String msgStr;
        File f1 = new File("Live Chat/"+tempStr);
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        try {
            if(f1.exists()) {
                fos = new FileOutputStream(f1, true);
                dos = new DataOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(f1);
                dos = new DataOutputStream(fos);
            }
            if(user1) {
                msgStr = user1Id + ": " + msg;
                dos.writeUTF(msgStr);
                return true;
            }
            else if(user2) {
                msgStr = user2Id + ": " + msg;
                dos.writeUTF(msgStr);
                return true;
            }
            return false;
        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch(IOException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                if(dos != null) {
                    dos.close();
                }
            }
            catch(IOException e) {
            }
        }
    }
    public static String readChat(int user1Id, int user2Id) {
        String pathName = user1Id + "-" + user2Id + ".bin";
        String msg = "";
        Order tempInst = null;
        File userFile = new File("Live Chat/" + pathName);
        FileInputStream fis = null;
        DataInputStream dis = null;
        try {            
            fis = new FileInputStream(userFile);
            dis = new DataInputStream(fis);
            msg = dis.readUTF();
        }
        catch(FileNotFoundException e) {
            errorAlert.setContentText("'Order.bin' file not found!");
            errorAlert.show();
        }
        catch(IOException e) {
        }
        finally {
            try {
                if(dis != null) dis.close();
            }
            catch(IOException e) {
            }
            return msg;
        }
    }
}
