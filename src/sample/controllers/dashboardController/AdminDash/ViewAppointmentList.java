package sample.controllers.dashboardController.AdminDash;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import sample.controllers.dashboardController.ReceptionistDash.RecepViewAppointController;
import sample.models.Appointment;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class ViewAppointmentList {

    @FXML
    private AnchorPane appointmentAnchor;


    @FXML
    private TableView<Appointment> appointTable;

    @FXML
    private TableColumn<Appointment, String> appointNumberCol;

    @FXML
    private TableColumn<Appointment, String> doctorNameCol;

    @FXML
    private TableColumn<Appointment, String> patientNameCol;

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
    void addAppointment(ActionEvent event) {

    }



    public void initialize() {

            ArrayList<Appointment> appointmentArrayList = Appointment.viewAppointment(true, "Admin", null, null, null);
            ObservableList<Appointment> obsAppointments = FXCollections.observableArrayList();
            obsAppointments.addAll(appointmentArrayList);

            appointNumberCol.setCellValueFactory(new PropertyValueFactory<>("appointmentNo"));
            patientNameCol.setCellValueFactory(new PropertyValueFactory<>("patientName"));
            doctorNameCol.setCellValueFactory(new PropertyValueFactory<>("appointedMedicalOfficer"));
            appointStatusCol.setCellValueFactory(new PropertyValueFactory<>("appointmentStatus"));
            appointTimeCol.setCellValueFactory(new PropertyValueFactory<>("appointmentTime"));
            appointDateCol.setCellValueFactory(new PropertyValueFactory<>("appointmentDate"));

            Callback<TableColumn<Appointment, String>, TableCell<Appointment, String>> cellFactory = (param) -> {
                return new TableCell<Appointment, String>() {
                    @Override
                    public void updateItem(String item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty) {
                            setGraphic(null);
                        } else {
                            viewAppointment = new Button("View");
                            viewAppointment.setOnAction(event -> {
                                ViewAppointController.selectedAppointment = getTableView().getItems().get(getIndex());
                                BorderPane parentBorderPane = (BorderPane) (appointmentAnchor.getParent());
                                try {
                                    Parent viewMODetails = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step3/ViewAppointment.fxml"));
                                    parentBorderPane.setCenter(viewMODetails);
                                    System.out.println("Done");
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            });

                            setGraphic(viewAppointment);
                        }
                        setText(null);
                    }

                    ;
                };
            };


            appointViewCol.setCellFactory(cellFactory);
            appointTable.setItems(obsAppointments);

        }

}
