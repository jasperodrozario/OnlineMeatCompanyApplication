package mainpkg;

import java.io.IOException;
import java.io.Serializable;
import javafx.scene.control.Button;

/**
 *
 * @author Jasper
 */

public class ButtonSerializable extends Button implements Serializable{
    public ButtonSerializable(String btnName) throws IOException {
        super(btnName);
    }
    
}
