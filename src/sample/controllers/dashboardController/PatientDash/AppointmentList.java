package sample.controllers.dashboardController.PatientDash;

import com.jfoenix.controls.JFXButton;
import de.jensd.fx.glyphs.testapps.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.models.Appointment;
import sample.models.User;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class AppointmentList {

    @FXML
    private AnchorPane appointmentAnchor;


    @FXML
    private TableView<Appointment> appointTable;

    @FXML
    private TableColumn<Appointment, String> appointNumberCol;

    @FXML
    private TableColumn<Appointment, String> doctorNameCol;

    @FXML
    private TableColumn<Appointment, LocalDate> appointDateCol;

    @FXML
    private TableColumn<Appointment, String> appointTimeCol;

    @FXML
    private TableColumn<Appointment, String> appointStatusCol;

    @FXML
    private JFXButton AppointmentBtn;

    @FXML
    void addAppointment(ActionEvent event) throws IOException {
        Parent add = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2_Appoinment.fxml"));
        BorderPane tempBorderPane = (BorderPane) appointmentAnchor.getParent();
        tempBorderPane.setCenter(add);
    }

    public void initialize(){

        ArrayList<Appointment> appointmentArrayList = Appointment.viewAppointment("Patient",PatientController.patientData[0]);
        ObservableList<Appointment> obsAppointments = FXCollections.observableArrayList();
        obsAppointments.addAll(appointmentArrayList);

        appointNumberCol.setCellValueFactory(new PropertyValueFactory<>("appointmentNo"));
        doctorNameCol.setCellValueFactory(new PropertyValueFactory<>("appointedMedicalOfficer"));
        appointStatusCol.setCellValueFactory(new PropertyValueFactory<>("appointmentStatus"));
        appointTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        appointTable.setItems(obsAppointments);
    }
}
