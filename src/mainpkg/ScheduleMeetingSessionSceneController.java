package mainpkg;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Jasper
 */

public class ScheduleMeetingSessionSceneController implements Initializable {

    @FXML
    private TextArea meetDescTF;
    @FXML
    private DatePicker meetDateDP;
    @FXML
    private TableView<MeetingSession> schMeetSessTV;
    @FXML
    private TableColumn<MeetingSession, LocalDateTime> schDateCol;
    @FXML
    private TableColumn<MeetingSession, String> meetDescCol;
    @FXML
    private TableColumn<MeetingSession, String> meetStatCol;
    
    SceneLoader newSceneLoader = new SceneLoader();
    Alert anErrorAlert = new Alert(Alert.AlertType.ERROR);
    Alert anInfoAlert = new Alert(Alert.AlertType.INFORMATION);
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        schDateCol.setCellValueFactory(new PropertyValueFactory<MeetingSession, LocalDateTime>("meetingDateTime"));
        meetDescCol.setCellValueFactory(new PropertyValueFactory<MeetingSession, String>("meetingDescription"));
        meetStatCol.setCellValueFactory(new PropertyValueFactory<MeetingSession, String>("meetingStatus"));
        if(MeetingSession.getAllMeetingSessions() != null) schMeetSessTV.setItems(MeetingSession.getAllMeetingSessions());
    }    

    @FXML
    private void addSchSessBtnOnClick(ActionEvent event) {
        LocalDate meetDate = meetDateDP.getValue();
        LocalTime meetTime = LocalTime.now();
        if(MeetingSession.addMeetingSession(LocalDateTime.of(meetDate, meetTime), meetDescTF.getText())) {
            anInfoAlert.setContentText("Meeting session added successfully.");
            anInfoAlert.show();
            schMeetSessTV.setItems(MeetingSession.getAllMeetingSessions());
            meetDescTF.clear();
            meetDateDP.setValue(null);
        }
        else {
            anErrorAlert.setContentText("Something went wrong. Try again.");
            anErrorAlert.show();
        }
    }

    @FXML
    private void rtrnBtnOnClick(ActionEvent event) throws IOException {
        newSceneLoader.switchScene("RegulatoryOfficerDashboardScene.fxml", event);
    }

    @FXML
    private void markAsCompBtnOnClick(ActionEvent event) {
        
        if(meetDateDP.getValue() == null) {
            anInfoAlert.setContentText("Select meeting date first.");
            anInfoAlert.show();
        }
        else {
            MeetingSession.updateMeetingStatus(meetDateDP.getValue());
        }
    }
    
}
