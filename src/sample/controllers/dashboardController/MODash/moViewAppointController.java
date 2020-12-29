package sample.controllers.dashboardController.MODash;
import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import sample.models.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class moViewAppointController {

    static Appointment selectedAppointment;
    private static Patient patient;

    @FXML
    private AnchorPane moAppointAnchor;

    @FXML
    private Circle patientProfileImage;

    @FXML
    private Label patientName;

    @FXML
    private TextField ageText;

    @FXML
    private TextField genderText;

    @FXML
    private TextField bloodTypeText;

    @FXML
    private TextField appointmentNoLbl;

    @FXML
    private Label statusLbl;

    @FXML
    private Label timeLbl;

    @FXML
    private Label ampmLbl;

    @FXML
    private Label dateLbl;

    @FXML
    private Label monthLbl;

    @FXML
    private JFXButton completeBtn;

    @FXML
    void backFromViewAppo(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/moDash/Step2.fxml"));
        BorderPane subBorderPane = (BorderPane) moAppointAnchor.getParent();
        subBorderPane.setCenter(step2);
    }

    @FXML
    void completeAppo(ActionEvent event) throws IOException {
        selectedAppointment.setAppointmentStatus("Completed");
        Appointment.editAppointment("Medical_Officer",selectedAppointment.getAppointmentNo(),selectedAppointment);
        statusLbl.setText("Completed");
    }


    public void getAppointmentData() {
        patientName.setText(selectedAppointment.getPatientName());
        genderText.setText(patient.getGender());
        bloodTypeText.setText(patient.getBloodGroup());
        appointmentNoLbl.setText(selectedAppointment.getAppointmentNo());
        statusLbl.setText(selectedAppointment.getAppointmentStatus());

        if(selectedAppointment.getAppointmentTime().length()==7){
            char ch1 = selectedAppointment.getAppointmentTime().charAt(0);
            char ch2 = selectedAppointment.getAppointmentTime().charAt(5);
            timeLbl.setText(ch1+".00");
            ampmLbl.setText(ch2+"M");

        } else if (selectedAppointment.getAppointmentTime().length()==8){
            char ch1 = selectedAppointment.getAppointmentTime().charAt(0);
            char ch2 = selectedAppointment.getAppointmentTime().charAt(1);
            char ch3 = selectedAppointment.getAppointmentTime().charAt(5);

            timeLbl.setText(ch1+ch2+".00");
            ampmLbl.setText(ch3+"M");
        }

        String formattedDate = selectedAppointment.getAppointmentDate().format(DateTimeFormatter.ofPattern("dd MMM,yyyy"));
        String [] splittedDate = formattedDate.split("(?!^)");
        dateLbl.setText(splittedDate[0]+splittedDate[1]);
        monthLbl.setText(splittedDate[3]+splittedDate[4]+splittedDate[5]);

        // Age calculator

        LocalDate today = LocalDate.now();
        LocalDate dob = patient.getDob();

        Period p = Period.between(dob, today);
        ageText.setText(String.valueOf(p.getYears()));


    }

    public void initialize() throws IOException {
        ArrayList<User> returnedPatientArray = UserTasks.viewUser(false,"Patient","Patient",selectedAppointment.getPatientUserName());
        if(returnedPatientArray.size() == 0){
            System.out.println("No patient record returned");
        }
        patient = (Patient) returnedPatientArray.get(0);
        getAppointmentData();
        if(selectedAppointment.getAppointmentStatus().equals("Completed")){
            completeBtn.setDisable(true);
        }
    }

}
