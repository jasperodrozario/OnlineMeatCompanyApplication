package mainpkg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 *
 * @author Jasper
 */

public class LiveChat {
    public static boolean liveChat(int user1Id, boolean user1, int user2Id, boolean user2, String msg) {
        String tempStr = user1Id + "-" + user2Id + ".bin";
        String msgStr;
        File f1 = new File(tempStr);
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
                msgStr = user1 + ": " + msg;
                dos.writeUTF(msgStr);
                return true;
            }
            else if(user2) {
                msgStr = user1 + ": " + msg;
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
}
