package sample.controllers.dashboardController.ReceptionistDash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.controllers.dashboardController.PatientDash.AddAppointController;
import sample.models.UserTasks;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class ReceptionistController {

    public static String loggedUserProfile;
    static String [] receptionistData;

    @FXML
    private Label newAppo;

    @FXML
    private Label totPatient;

    public static String objEncString;

    @FXML
    private JFXButton recepBtn1;

    @FXML
    private JFXButton recepBtn2;

    @FXML
    private JFXButton recepBtn3;

    @FXML
    private JFXButton recepBtn4;

    @FXML
    private JFXButton recepBtn5;

    @FXML
    private JFXButton recepBtn6;

    @FXML
    private AnchorPane step2Anchor;

    @FXML
    private AnchorPane step6Anchor;

    @FXML
    private AnchorPane step3Anchor;

    @FXML
    private BorderPane recepBorderPane;



    @FXML
    void step1(ActionEvent event) throws IOException {
        Parent step1 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Step1.fxml"));
        recepBorderPane.setCenter(step1);
    }

    @FXML
    void viewAppointment(ActionEvent event) throws IOException {
        Parent appointment = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/recepAppointmentList.fxml"));
        recepBorderPane.setCenter(appointment);
        AddAppointController.appointmentPageVisitCount=0;
    }


    @FXML
    void step2(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Step2.fxml"));
        recepBorderPane.setCenter(step2);
    }

    @FXML
    void postalMail(ActionEvent event) throws IOException {
        Parent mail = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/PostalMail/PostalMail.fxml"));
        recepBorderPane.setCenter(mail);
    }


    @FXML
    void step4(ActionEvent event) throws IOException {
       Parent step4 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/recepVisitorList.fxml"));
       recepBorderPane.setCenter(step4);
    }


    @FXML
    void step5(ActionEvent event) throws IOException {

    }

    @FXML
    void step6(ActionEvent event) throws IOException {

    }

    @FXML
    void step3(ActionEvent event) throws IOException {

    }

    @FXML
    void step7(ActionEvent event) throws IOException {
        Parent step7 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Profile.fxml"));
        recepBorderPane.setCenter(step7);
    }

    @FXML
    void logOut(ActionEvent event) {

    }

    @FXML
    private Label nameLabel;

    @FXML
    private Label welcomeLbl;

    public void initialize() throws IOException {

        receptionistData = loggedUserProfile.split("~");
        int [] counter = UserTasks.dataCounter("Receptionist");
        totPatient.setText(String.valueOf(counter[0]));
        newAppo.setText(String.valueOf(counter[1]));

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        int hours = c.get(Calendar.HOUR_OF_DAY);

        if(hours>=1 && hours<=12){
           welcomeLbl.setText("Good Morning");
        }else if(hours>=12 && hours<=16){
            welcomeLbl.setText("Good Afternoon");
        }else if(hours>=16 && hours<=21) {
            welcomeLbl.setText("Good Evening");
        }

        String[] splitName = receptionistData[5].split("\\s+");
        if(receptionistData[8].equals("Male")){
            nameLabel.setText("Mr."+splitName[0]);
        } else {
            if(receptionistData[9].equals("Married")){
                nameLabel.setText("Mrs."+splitName[0]);
            } else {
                nameLabel.setText("Ms."+splitName[0]);
            }
        }




    }

}
