package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class MeetingSessionHistorySceneController implements Initializable {

    @FXML
    private TableView<MeetingSession> schMeetSessTV;
    @FXML
    private TableColumn<MeetingSession, LocalDateTime> schDateCol;
    @FXML
    private TableColumn<MeetingSession, String> meetDescCol;
    @FXML
    private TableColumn<MeetingSession, String> meetStatCol;

    SceneLoader newSceneLoader = new SceneLoader();
    
    /**
     * Initializes the controller class.
     */
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        schDateCol.setCellValueFactory(new PropertyValueFactory<MeetingSession, LocalDateTime>("meetingDateTime"));
        meetDescCol.setCellValueFactory(new PropertyValueFactory<MeetingSession, String>("meetingDescription"));
        meetStatCol.setCellValueFactory(new PropertyValueFactory<MeetingSession, String>("meetingStatus"));
        
        if(MeetingSession.getAllMeetingSessions() != null) {
            for(MeetingSession session: MeetingSession.getAllMeetingSessions()) {
                if(session.meetingStatusBool) {
                    schMeetSessTV.getItems().add(session);
                }
            }
        }

    }    

    @FXML
    private void rtrnBtnOnClick(ActionEvent event) throws IOException {
        newSceneLoader.switchScene("RegulatoryOfficerDashboardScene.fxml", event);
    }
    
}
