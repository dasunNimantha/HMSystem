package sample.controllers.dashboardController.PatientDash;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.shape.Circle;
import sample.models.*;

import java.io.IOException;
import java.util.ArrayList;

public class ViewAppointController {

    public  static Appointment selectedAppointment;

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

        System.out.println(selectedAppointment.getAppointmentDate());
        System.out.println(selectedAppointment.getAppointmentTime());

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
       //medicalOfficer = (MedicalOfficer) returnedMoArray.get(0);
        getAppointmentData();
    }

}
