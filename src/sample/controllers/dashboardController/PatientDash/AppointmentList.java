package sample.controllers.dashboardController.PatientDash;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import sample.models.Appointment;
import java.io.IOException;
import java.time.LocalDate;
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
    private TableColumn<Appointment, String> appointViewCol;

    @FXML
    private Button viewAppointment;

    @FXML
    void addAppointment(ActionEvent event) throws IOException {
        Parent add = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2_Appoinment.fxml"));
        BorderPane tempBorderPane = (BorderPane) appointmentAnchor.getParent();
        tempBorderPane.setCenter(add);
    }

    public void initialize(){

        ArrayList<Appointment> appointmentArrayList = Appointment.viewAppointment(true,"Patient",null,null,null);
        ObservableList<Appointment> obsAppointments = FXCollections.observableArrayList();
        obsAppointments.addAll(appointmentArrayList);


        appointNumberCol.setCellValueFactory(new PropertyValueFactory<>("appointmentNo"));
        doctorNameCol.setCellValueFactory(new PropertyValueFactory<>("appointedMedicalOfficer"));
        appointStatusCol.setCellValueFactory(new PropertyValueFactory<>("appointmentStatus"));
        appointTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
        appointDateCol.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));

        Callback<TableColumn<Appointment,String>, TableCell<Appointment,String>> cellFactory=(param) ->{
            return new TableCell<Appointment,String>(){
                @Override
                public void updateItem(String item,boolean empty){
                    super.updateItem(item,empty);
                    if(empty){
                        setGraphic(null);
                    } else {
                        viewAppointment = new Button("View");
                        viewAppointment.setOnAction(event -> {
                            ViewAppointController.selectedAppointment= getTableView().getItems().get(getIndex());
                            BorderPane parentBorderPane = (BorderPane) (appointmentAnchor.getParent());
                            try {
                                Parent viewMODetails = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2_viewAppointment.fxml"));
                                parentBorderPane.setCenter(viewMODetails);
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        });

                        setGraphic(viewAppointment);
                    }
                    setText(null);
                };
            };
        };


        appointViewCol.setCellFactory(cellFactory);
        appointTable.setItems(obsAppointments);

    }
}
