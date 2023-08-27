package mainpkg;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TextArea;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Jasper
 */
public class AuditReportViewSceneController implements Initializable {

    @FXML
    private TextArea auditRprtTA;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void openAuditRprtBtnOnClick(ActionEvent event) {
        File f1 = new File("Audit Report");
        FileChooser fc = new FileChooser();
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter(".bin"));
        fc.setInitialDirectory(f1);
        File f = fc.showOpenDialog(null);
        if(f!=null) {
            try {
                Scanner sc = new Scanner(f);
                String str = "";
                while(sc.hasNextLine()) {
                    str += sc.nextLine()+"\n";
                }
                auditRprtTA.setText(str);
            }
            catch(FileNotFoundException e) {
                
            }
        }
    }

    @FXML
    private void rtrnHomeBtnOnClick(ActionEvent event) {
    }
    
}
