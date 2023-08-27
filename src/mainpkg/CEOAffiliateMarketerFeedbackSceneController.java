package mainpkg;

import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class CEOAffiliateMarketerFeedbackSceneController implements Initializable {

    @FXML
    private TextArea feedbackTA;
    @FXML
    private TextField feedbackFileNameTF;

    SceneLoader newSceneLoader = new SceneLoader();
    String fileName = "";
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void chooseFileBtnClick(ActionEvent event) {
        
        File f1 = new File("AffiliateMarketer_Content");
        FileChooser fc = new FileChooser();
        fc.setInitialDirectory(f1);
        File f = fc.showOpenDialog(null);
        if(f!=null) {
            fileName = f.getName().replaceAll(".pdf", "");
            feedbackFileNameTF.setText(fileName);
        }
    }

    @FXML
    private void submitFeedbackBtnOnClick(ActionEvent event) {
        String newFileName = fileName + "_CEOFeedback.bin";
        File f1 = null;
        FileOutputStream fos = null;
        DataOutputStream dos = null;
        
        try{
            f1 = new File("AffiliateMarketer_Feedback/" + newFileName);
            fos = new FileOutputStream(f1);
            dos = new DataOutputStream(fos);
            dos.writeUTF(feedbackTA.getText());
            dos.close();
            feedbackTA.setText(null);
            feedbackFileNameTF.setText(null);
        }
        catch(IOException e){
        }
    }

    @FXML
    private void rtrnHomeBtnOnClick(ActionEvent event) throws IOException {
        newSceneLoader.switchScene("AffiliateMarketerDashboard.fxml", event);
    }
    
}
