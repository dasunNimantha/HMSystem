package sample.controllers.dashboardController.MODash;

import de.jensd.fx.glyphs.testapps.App;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import sample.controllers.dashboardController.PatientDash.ViewAppointController;
import sample.models.Appointment;
import sample.models.Patient;
import sample.models.User;
import sample.models.UserTasks;

import java.io.IOException;
import java.util.ArrayList;

public class moAppointmentList {

    static Appointment selectedAppointment;


    @FXML
    private AnchorPane appointmentAnchor;

    @FXML
    private TableView<Appointment> appointTable;

    @FXML
    private TableColumn<Appointment, String> appointNumberCol;

    @FXML
    private TableColumn<Appointment, String> appointDateCol;

    @FXML
    private TableColumn<Appointment, String> appointTimeCol;

    @FXML
    private TableColumn<Appointment, String> appointStatusCol;

    @FXML
    private TableColumn<Appointment, String> appointViewCol;

    @FXML
    private Button viewAppointment;

    public void initialize() throws IOException {
        ArrayList<Appointment> appointmentArrayList = Appointment.viewAppointment(true,"Medical_Officer",null,null,MOController.typeCastedMO.getUserName());
        ObservableList<Appointment> obsAppointments = FXCollections.observableArrayList();
        obsAppointments.addAll(appointmentArrayList);

        appointNumberCol.setCellValueFactory(new PropertyValueFactory<>("appointmentNo"));
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
                            moViewAppointController.selectedAppointment= getTableView().getItems().get(getIndex());
                            BorderPane parentBorderPane = (BorderPane) (appointmentAnchor.getParent());
                            try {
                                Parent viewMODetails = FXMLLoader.load(getClass().getResource("../../../views/dashboard/moDash/moViewAppointment.fxml"));
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
