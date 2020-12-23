package sample.controllers.dashboardController.PatientDash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Font;
import sample.models.Appointment;
import sample.models.MedicalOfficer;
import sample.models.User;
import sample.models.UserTasks;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class AppointmentController {

    static ArrayList <String> speciality;
    static int appointmentPageVisitCount = 0;

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
    private Label appointDateText;

    @FXML
    void changeToSuccess(ActionEvent event) throws IOException {

        Appointment appointment = new Appointment();
        appointment.setAppointmentNo(123);
        appointment.setAppointmentStatus("Pending");
     //   appointment.setAppointedMedicalOfficer(doctorSelectCombo.getValue());

        Parent root = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/AppointSuccess.fxml"));
        BorderPane subBorderPane = (BorderPane) appointmentAnchor.getParent();
        subBorderPane.setCenter(root);

        appointmentPageVisitCount=0;

    }

    @FXML
    void anotherAppointment(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2_Appoinment.fxml"));
        BorderPane subBorderPane = (BorderPane) successAnchor.getParent();
        subBorderPane.setCenter(root);

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
            ArrayList<User> returnedAllDoctorList =UserTasks.viewUser("Patient","Medical_Officer");
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
            appointmentPageVisitCount++;
        }

    }


    // css files

    static File comboCss = new File ("src/sample/assets/styles/Combo.css");
    static String cmcss = comboCss.toString();
}
