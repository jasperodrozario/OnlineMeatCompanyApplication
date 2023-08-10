package mainpkg;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 *
 * @author Jasper
 */
public class SceneLoader {
    Stage newStage = new Stage();
    Node sceneNode;
    
    public void loadScene(String fxmlFileName){
        
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
            Scene newScene = new Scene(root);
            newStage.setScene(newScene);
            newStage.show();
        }
        catch(Exception e) {
            System.out.println(e);
        }
        
    }
    
    public Node getSceneRoot(String fxmlFileName) {
        try {
            Parent root = FXMLLoader.load(getClass().getResource(fxmlFileName));
            return root;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
    }
}
