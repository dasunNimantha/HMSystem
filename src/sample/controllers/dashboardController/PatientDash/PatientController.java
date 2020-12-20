package sample.controllers.dashboardController.PatientDash;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.testapps.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class PatientController {

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
    private JFXButton AppointmentBtn;

    @FXML
    private BorderPane recepBorderPane;

    @FXML
    private AnchorPane appointmentAnchor;



    @FXML
    void step1(ActionEvent event) throws IOException {
        Parent step1 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step1.fxml"));
        recepBorderPane.setCenter(step1);
    }

    @FXML
    void step2(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2.fxml"));
        recepBorderPane.setCenter(step2);
    }

    @FXML
    void step3(ActionEvent event) throws IOException {
        Parent step3 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step3.fxml"));
        recepBorderPane.setCenter(step3);
    }

    @FXML
    void step4(ActionEvent event) throws IOException {
        Parent step4 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step4.fxml"));
        recepBorderPane.setCenter(step4);
    }

    @FXML
    void step5(ActionEvent event) throws IOException {
        Parent step5 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step5.fxml"));
        recepBorderPane.setCenter(step5);
    }
    @FXML
    void step6(ActionEvent event) {

    }
    @FXML
    private AnchorPane addComplaintAnchor;{

    }

    @FXML
    private ComboBox<String> complaintCombo;{

    }


    @FXML
    void addAppointment(ActionEvent event) throws IOException {
        Parent addAppointment = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2_Appoinment.fxml"));
        BorderPane tempBorderPane = (BorderPane) (appointmentAnchor.getParent());
        tempBorderPane.setCenter(addAppointment);
    }

    @FXML
    void makeComplaint(ActionEvent event) throws IOException {
        Parent addAppointment = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step4_Complaint.fxml"));
        BorderPane tempBorderPane = (BorderPane) (addComplaintAnchor.getParent());
        tempBorderPane.setCenter(addAppointment);

    }

    public void initialize(){


    }


    public void backToPatientDetails(ActionEvent actionEvent) {
    }

    public void saveEdit(ActionEvent actionEvent) {
    }

    public void cancelEdit(ActionEvent actionEvent) {
    }
}




