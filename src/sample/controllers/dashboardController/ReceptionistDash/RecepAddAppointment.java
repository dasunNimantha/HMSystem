package sample.controllers.dashboardController.ReceptionistDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.shape.Circle;
import org.controlsfx.control.textfield.TextFields;
import sample.models.*;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class RecepAddAppointment {

    static ArrayList<String> speciality;
    public static int appointmentPageVisitCount = 0;
    static String localAppointTime;
    private static String selectedDoctorUsername;
    private static Appointment appointment;
    private static int patientCount;
    private static String selectedPatientUserName;
    private static ArrayList<User> returnedPatientList;


    @FXML
    private ComboBox<String> specialityCombo;

    @FXML
    private ComboBox<User> doctorSelectCombo;

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
    private TextField symptomText1;

    @FXML
    private Label doctorProNameLbl;

    @FXML
    private TextField symptomText2;

    @FXML
    private TextField symptomText3;

    @FXML
    private BorderPane doctorDetailsBorder;


    @FXML
    private AnchorPane timeLabel;

    @FXML
    private Circle docProfile;

    @FXML
    private AnchorPane policyAnchor;

    @FXML
    private AnchorPane timeAnchor;

    @FXML
    private TextField selectPatientText;



    public RecepAddAppointment() throws IOException {
    }



    @FXML
    void changeToSuccess(ActionEvent event) throws IOException {

        if(selectPatientText.getText()!= null){
            for (int i=0; i<patientCount;i++){
               if(selectPatientText.getText().trim().equals(returnedPatientList.get(i).getUserName())){
                   selectedPatientUserName=returnedPatientList.get(i).getUserName();
                   appointment = new Appointment();
                   appointment.setAppointmentStatus("Approved");
                   appointment.setPatientName(returnedPatientList.get(i).getName());
                   appointment.setPatientUserName(selectedPatientUserName);
                   appointment.setAppointedMedicalOfficer("Dr."+doctorSelectCombo.getValue().getName());
                   appointment.setSymptoms(symptomText1.getText());
                   appointment.setAppointedMoUsername(selectedDoctorUsername);

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
                   appointment.setAppointmentNo(appointmentNo);

                   Appointment.createAppointment(appointment); //call appointment create function

                   Parent root = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/recepAppointSuccess.fxml"));
                   BorderPane subBorderPane = (BorderPane) appointmentAnchor.getParent();
                   subBorderPane.setCenter(root);

                   AnchorPane successAnchor = (AnchorPane)subBorderPane.getChildren().get(0);
                   Label timeLabel= (Label) successAnchor.getChildren().get(2);
                   timeLabel.setText(localAppointTime);
                   Label dateLabel = (Label) successAnchor.getChildren().get(1);
                   dateLabel.setText(formattedDate);

               } else {
                   System.out.println("Invalid Username");
               }
            }

        }

        appointmentPageVisitCount=0;

    }


    @FXML
    void anotherAppointment(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/recepAddAppointment.fxml"));
        BorderPane subBorderPane = (BorderPane) successAnchor.getParent();
        subBorderPane.setCenter(root);

    }

    @FXML
    void viewCreatedAppointment(ActionEvent event) throws IOException {
        ArrayList<Appointment> returnedArray= Appointment.viewAppointment(false,"Patient",selectedPatientUserName,appointment.getAppointmentNo(),null);
        RecepViewAppointController.selectedAppointment = returnedArray.get(0);
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/recepViewAppointment.fxml"));
        BorderPane subBorderPane = (BorderPane) successAnchor.getParent();
        subBorderPane.setCenter(step2);
        appointmentPageVisitCount=0;
    }

    @FXML
    void backToAppointList(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/recepAppointmentList.fxml"));
        BorderPane subBorderPane = (BorderPane) appointmentAnchor.getParent();
        subBorderPane.setCenter(step2);
        appointmentPageVisitCount=0;
    }

    public void initialize() throws IOException  {


        if (appointmentPageVisitCount == 0) {
            //get all user data
            returnedPatientList = UserTasks.viewUser(true,"Receptionist","Patient",null);

            patientCount = returnedPatientList.size();
            String[] patientUserNameList = new String[patientCount];
            for (int i=0; i<patientCount;i++){
                patientUserNameList[i] = returnedPatientList.get(i).getUserName();
            }
            TextFields.bindAutoCompletion(selectPatientText, patientUserNameList);




            // call reference function

            speciality = Reference.returnReference("SpecialityRef");
            specialityCombo.getItems().add("ALL");
            for (String s : speciality) {
                specialityCombo.getItems().add(s);
            }
            specialityCombo.getSelectionModel().selectFirst();


            // call read user function to get all doctor objects
            ArrayList<User> returnedAllDoctorList = UserTasks.viewUser(true, "Patient", "Medical_Officer", null);
            ObservableList<User> mos = FXCollections.observableArrayList(); //put object into observable list

            for (User user : returnedAllDoctorList) {
                mos.add(new User(user.getUserName(), user.getName()));
            }

            specialityCombo.getSelectionModel().selectedItemProperty().addListener((var,oldValue,newValue) ->{
                if(newValue.equals("ALL")){         // show all doctors if ALL item selected
                    doctorSelectCombo.getItems().clear();
                    doctorSelectCombo.setPromptText("Select");
                    for (User user : returnedAllDoctorList) {
                        mos.add(new User(user.getUserName(), user.getName()));
                    }
                } else {
                    doctorSelectCombo.getItems().clear();
                    for (User user : returnedAllDoctorList) {
                        MedicalOfficer mo = ((MedicalOfficer) user);
                        if (newValue.equals(mo.getSpeciality())) {
                            mos.add(new User(user.getUserName()
                                    , user.getName()));
                        }
                    } if(doctorSelectCombo.getItems().size()==0){
                        doctorSelectCombo.setPromptText("No doctors available");

                    } else {
                        doctorSelectCombo.setPromptText("Select");
                    }


                }

            });

            doctorSelectCombo.setItems(mos);  // add newly created MO objects to combo list
            doctorSelectCombo.getSelectionModel().selectedItemProperty().addListener((var, oldValue, newValue) -> {
                if (newValue != null) {
                    selectedDoctorUsername= doctorSelectCombo.getSelectionModel().getSelectedItem().getUserName();
                    String selectedDoctorName = doctorSelectCombo.getSelectionModel().getSelectedItem().getName();
                    doctorProNameLbl.setText("Dr."+selectedDoctorName);
                    appointConBtn.setDisable(false);
                    doctorDetailsBorder.setCenter(null);
                    doctorDetailsBorder.setCenter(timeAnchor);
                    timeAnchor.setDisable(false);
                    timeAnchor.setVisible(true);


                } else {
                    timeAnchor.setVisible(false);
                    doctorDetailsBorder.setCenter(null);
                    doctorDetailsBorder.setCenter(policyAnchor);
                    appointConBtn.setDisable(true);
                    timeAnchor.setDisable(true);
                }
            });



            // ~~~~~~~~~~~~~~~~~~~~ Toggle time button function ~~~~~~~~~~~~~~~~~~~~~~ //

            for (int i = 0; i < 6; i++) {
                ToggleButton button = (ToggleButton) timeBtn.getToggles().get(i);
                button.selectedProperty().addListener((observable, oldValue, newValue) -> {


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

}
