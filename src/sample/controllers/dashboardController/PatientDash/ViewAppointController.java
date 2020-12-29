package sample.controllers.dashboardController.PatientDash;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import sample.models.*;

import java.io.IOException;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ViewAppointController {

    static Appointment selectedAppointment;
    private static MedicalOfficer medicalOfficer;
    private static Patient patient;


    @FXML
    private AnchorPane viewAppointAnchor;

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
    private Circle doctorProfilePic;

    @FXML
    private Label doctorNameLbl;

    @FXML
    private Label doctorSpecialityLbl;

    @FXML
    private Label statusLbl;

    @FXML
    private TextField appointmentNoLbl;

    @FXML
    private Label timeLbl;

    @FXML
    private Label ampmLbl;

    @FXML
    private Label dateLbl;

    @FXML
    private Label monthLbl;


    public void getAppointmentData(){

        patientName.setText(selectedAppointment.getPatientName());
        genderText.setText(patient.getGender());
        bloodTypeText.setText(patient.getBloodGroup());
        doctorNameLbl.setText(selectedAppointment.getAppointedMedicalOfficer());
        doctorSpecialityLbl.setText(medicalOfficer.getSpeciality());
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

        String imagePath1 = "sample/assets/images/dashboard/Maithripala-_Russia_(portrait).jpg";
        Image proPic1 = new Image(imagePath1);
        patientProfileImage.setFill(new ImagePattern(proPic1));
        patientProfileImage.setEffect(new DropShadow(+15d, 0d, +2d, Color.GREY));

        String imagePath2 = "sample/assets/images/dashboard/rajitha.jpg";
        Image proPic2 = new Image(imagePath2);
        doctorProfilePic.setFill(new ImagePattern(proPic2));
        doctorProfilePic.setEffect(new DropShadow(+15d, 0d, +2d, Color.GREY));

        // Age calculator
        LocalDate today = LocalDate.now();
        LocalDate dob = patient.getDob();


        Period p = Period.between(dob, today);
        ageText.setText(String.valueOf(p.getYears()));


    }

    public void initialize() throws IOException {

        //get corresponding patient details
        ArrayList<User> returnedPatientArray = UserTasks.viewUser(false,"Patient","Patient",selectedAppointment.getPatientUserName());
        if(returnedPatientArray.size() == 0){
            System.out.println("No patient record returned");
        }

        patient = (Patient) returnedPatientArray.get(0);

        // get corresponding medical officer details
        ArrayList<User> returnedMoArray = UserTasks.viewUser(false,"Patient","Medical_Officer",selectedAppointment.getAppointedMoUsername());
        if(returnedMoArray.size() == 0){
            System.out.println("No doctor record returned");
        }
        medicalOfficer = (MedicalOfficer) returnedMoArray.get(0);
        getAppointmentData();
    }

}
