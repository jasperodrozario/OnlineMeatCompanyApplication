package mainpkg;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

/**
 *
 * @author Jasper
 */

public class MeetingSession implements Serializable{
    
    String meetingDescription;
    String meetingStatus;
    LocalDateTime meetingDateTime;
    boolean meetingStatusBool = false;
    

    public MeetingSession(LocalDateTime meetingDateTime, String meetingDescription) {
        this.meetingDescription = meetingDescription;
        this.meetingDateTime = meetingDateTime;
        this.setMeetingStatus(meetingStatusBool);
    }

    public String getMeetingDescription() {
        return meetingDescription;
    }

    public LocalDateTime getMeetingDateTime() {
        return meetingDateTime;
    }

    public boolean isMeetingStatusBool() {
        return meetingStatusBool;
    }
    
    public void setMeetingDescription(String meetingDescription) {
        this.meetingDescription = meetingDescription;
    }

    public void setMeetingDateTime(LocalDateTime meetingDateTime) {
        this.meetingDateTime = meetingDateTime;
    }

    public void setMeetingStatusBool(boolean meetingStatusBool) {
        this.meetingStatusBool = meetingStatusBool;
        this.setMeetingStatus(meetingStatusBool);
    }
    
    public void setMeetingStatus(boolean meetingStatusBool) {
        if(meetingStatusBool) {
            this.meetingStatus = "Complete";
        }
        else {
            this.meetingStatus = "Pending";
        }
    }
    
    public static boolean addMeetingSession(LocalDateTime meetTime, String meetDesc) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        File sessionFile = new File("MeetingSession.bin");
        MeetingSession newSession = new MeetingSession(meetTime, meetDesc);
        try {
            if (sessionFile.exists()) {
                fos = new FileOutputStream(sessionFile, true);
                oos = new AppendObjectOutputStream(fos);
            }
            else {
                fos = new FileOutputStream(sessionFile);
                oos = new ObjectOutputStream(fos);
            }
            oos.writeObject(newSession);
            oos.close();
            return true;
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
            return false;
        }
        catch (IOException e) {
            e.printStackTrace();
            return false;
        }
        finally {
            try {
                if(oos != null) oos.close();
            } 
            catch (IOException e) {
            }
        }
    }
    
    public static ObservableList<MeetingSession> getAllMeetingSessions() {
        ObservableList<MeetingSession> allSessions = FXCollections.observableArrayList();
        ObjectInputStream ois = null;
        FileInputStream fis = null;
        MeetingSession tempInst = null;
        File meetFile = new File("MeetingSession.bin");
        try {
            fis = new FileInputStream(meetFile);
            ois = new ObjectInputStream(fis);
            while(true) {
                tempInst = (MeetingSession)ois.readObject();
                allSessions.add(tempInst);
            }
        }
        catch(FileNotFoundException e) {
            allSessions = null;
        }
        catch(IOException e) {
        }
        finally {
            try{
                if(ois != null) {
                    ois.close();
                }
            }
            catch(IOException e) {  
            }
            return allSessions;
        }
    }
    
    private static void deleteAllMeetingSessions() {
        File file = new File("MeetingSession.bin");
        if(file.exists()) {
            file.delete();
        }
        else {
            System.out.println("MeetingSession.bin file does not exist.");
        }
    }
    
    public static boolean updateMeetingStatus(LocalDate meetDate) {
        ObservableList<MeetingSession> tempSessionList = MeetingSession.getAllMeetingSessions();
        boolean flag = false;
        for(MeetingSession session: tempSessionList) {
            if(meetDate == session.meetingDateTime.toLocalDate()) {
                session.setMeetingStatus(true);
                flag = true;
                break;
            }
        }
        if(flag) {
            MeetingSession.deleteAllMeetingSessions();
            for(MeetingSession session: tempSessionList) {
                MeetingSession.addMeetingSession(session.meetingDateTime, session.meetingDescription);
            }
            return true;
        }
        else {
            return false;
        }
    }
    
    private void writeObject(ObjectOutputStream out) throws IOException {
        out.defaultWriteObject();
        out.writeObject(meetingDateTime);
    }

    private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
        in.defaultReadObject();
        meetingDateTime = (LocalDateTime)in.readObject();
    }
    
}
