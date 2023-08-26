
package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;

/**
 *
 * @author Dell
 */
public class Policy implements Serializable{
    String policy;

    public Policy(String policy) {
        this.policy = policy;
    }
    
    
    public boolean addPolicy(String policy) {
        
        File policyFile = null;
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;

        try {
            policyFile = new File("Policy.bin");
            if(policyFile.exists()) {
                fos = new FileOutputStream(policyFile, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(policyFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(this);
            return true;
        }
        catch (FileNotFoundException e) {
            return false;
        }
        catch(IOException e) {
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
}
