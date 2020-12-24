package sample.controllers.dashboardController.PatientDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.models.*;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class AddAppointController {

    static ArrayList <String> speciality;
    static int appointmentPageVisitCount = 0;
    static String localAppointTime;

    @FXML
    private ComboBox<String> specialityCombo;

    @FXML
    private ComboBox<String> doctorSelectCombo;

    @FXML
    private JFXButton appointConBtn;

    @FXML
    private AnchorPane appointmentAnchor;

    @FXML
    private AnchorPane successAnchor;

    @FXML
    private JFXDatePicker appointDatePicker;

    @FXML
    private ToggleGroup timeBtn;

    @FXML
    private ToggleButton timeBtn1;

    @FXML
    private RadioButton radio1;

    @FXML
    private RadioButton radio2;


    @FXML
    private ToggleGroup group;



    @FXML
    void changeToSuccess(ActionEvent event) throws IOException {

        Appointment appointment = new Appointment();
        appointment.setAppointmentStatus("Pending");
        appointment.setPatientName(PatientController.patientData[2]);
        appointment.setPatientUserName(PatientController.patientData[0]);
        appointment.setAppointedMedicalOfficer(doctorSelectCombo.getValue());
        // appointment.setAppointedMoUsername();

        // set local Date

        String formattedDate = appointDatePicker.getValue().format(DateTimeFormatter.ofPattern("dd MMM,yyyy"));
        appointment.setAppointmentDate(appointDatePicker.getValue());

        // set appointment time
        String selectedTimeText = ((ToggleButton)timeBtn.getSelectedToggle()).getText(); // get selected time
        // convert of time text to local time
        if(selectedTimeText.length()==3){
            char ch1 = selectedTimeText.charAt(0);
            char ch2 = selectedTimeText.charAt(1);
            localAppointTime = ch1+".00"+" "+ch2+"M";

        } else if(selectedTimeText.length()==4) {
            char ch1 = selectedTimeText.charAt(0);
            char ch2 = selectedTimeText.charAt(1);
            char ch3 = selectedTimeText.charAt(2);
            localAppointTime = ch1+ch2+" "+ch3+"M";
        }

        appointment.setAppointmentTime(localAppointTime);

        // generate appointment no
        DateFormat df = new SimpleDateFormat("MMddHHmmss");
        Date dateObj = new Date();
        String appointmentNo =(df.format(dateObj));
        appointment.setAppointmentNo((appointmentNo+PatientController.patientData[3]));

        Appointment.createAppointment(appointment); //call appointment create function

        Parent root = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/AppointSuccess.fxml"));
        BorderPane subBorderPane = (BorderPane) appointmentAnchor.getParent();
        subBorderPane.setCenter(root);

        AnchorPane successAnchor = (AnchorPane)subBorderPane.getChildren().get(0);
        Label timeLabel= (Label) successAnchor.getChildren().get(2);
        timeLabel.setText(localAppointTime);
        Label dateLabel = (Label) successAnchor.getChildren().get(1);
        dateLabel.setText(formattedDate);

        appointmentPageVisitCount=0;

    }



    @FXML
    void anotherAppointment(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2_Appoinment.fxml"));
        BorderPane subBorderPane = (BorderPane) successAnchor.getParent();
        subBorderPane.setCenter(root);

    }


    @FXML
    void backToAppointList(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2.fxml"));
        BorderPane subBorderPane = (BorderPane) appointmentAnchor.getParent();
        subBorderPane.setCenter(step2);
        appointmentPageVisitCount=0;
    }

    public void initialize() throws IOException {

        // call reference function
        if(appointmentPageVisitCount==0){
            speciality = UserTasks.returnReference("SpecialityRef");
            specialityCombo.getItems().add("ALL");
            for (String s : speciality) {
                specialityCombo.getItems().add(s);
            }

            specialityCombo.getSelectionModel().selectFirst();

            // listen for speciality selection
            ArrayList<User> returnedAllDoctorList =UserTasks.viewUser(true,"Patient","Medical_Officer",null);
            int doctorObjCount = returnedAllDoctorList.size();
            for(int i = 0; i<doctorObjCount; i++){
                doctorSelectCombo.getItems().add("Dr."+returnedAllDoctorList.get(i).getName());
            }
            //show all doctors by default

            specialityCombo.getSelectionModel().selectedItemProperty().addListener(
                    (var,oldValue,newValue) ->
                    {
                        doctorSelectCombo.getItems().clear(); // clear previously showed doctors
                        for (int i = 0; i < doctorObjCount; i++) {
                            MedicalOfficer obj = (MedicalOfficer) returnedAllDoctorList.get(i);
                            if (obj.getSpeciality().equals(newValue)) {
                                doctorSelectCombo.getItems().add(obj.getName());
                            }
                        }

//                            if(returnedDoctorList.size()==0){
//                                doctorSelectCombo.setPromptText("Not available for this speciality");
//                                doctorSelectCombo.getStyleClass().add(cmcss);
//                            }

                    });

            doctorSelectCombo.getSelectionModel().selectedItemProperty().addListener((var,oldValue,newValue) ->{
                if(newValue!= null){
                    appointConBtn.setDisable(false);
                } else{
                    appointConBtn.setDisable(true);
                }
            });

            // ~~~~~~~~~~~~~~~~~~~~ Toggle time button function ~~~~~~~~~~~~~~~~~~~~~~ //

            for(int i =0;i<6;i++) {
                ToggleButton button = (ToggleButton) timeBtn.getToggles().get(i);
                button.selectedProperty().addListener((observable, oldValue, newValue) -> {

                    // If selected, color the background red
                    if (newValue) {
                        button.setStyle(
                                "-fx-background-color:  #448AFF;" +
                                        "-fx-text-fill: white");
                    } else {
                        button.setStyle(
                                "-fx-background-color: white;" +
                                        "-fx-text-fill: black");
                    }
                });
            }
            // ~~~~~~~~~~~~~~~~~~~~ ~~~~~~~~~~~~~~~~~~~~~~~~~ ~~~~~~~~~~~~~~~~~~~~~~ //
            appointmentPageVisitCount++;

        }

    }


    // css files

    static File comboCss = new File ("src/sample/assets/styles/Combo.css");
    static String cmcss = comboCss.toString();
}
