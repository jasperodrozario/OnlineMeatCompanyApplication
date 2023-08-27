package mainpkg;

import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

/**
 *
 * @author Jasper
 */

class AppendObjectOutputStream extends ObjectOutputStream{
    public AppendObjectOutputStream(OutputStream out) throws IOException {
        super(out);
    }
    
    @Override
    public void writeStreamHeader() throws IOException {
        
    }
}
