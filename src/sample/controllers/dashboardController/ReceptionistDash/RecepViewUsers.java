package sample.controllers.dashboardController.ReceptionistDash;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.controllers.dashboardController.AdminDash.viewPatientDetails;
import sample.controllers.dashboardController.AdminDash.viewMODetails;
import sample.controllers.dashboardController.AdminDash.viewReceptionistDetails;
import java.io.IOException;

public class RecepViewUsers {

    @FXML
    private AnchorPane step2Anchor;



    @FXML
    void changeToPatientMenu(MouseEvent event) throws IOException {
        BorderPane parentBorderPane = (BorderPane) (step2Anchor.getParent());
        Parent patient = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/patientDetails/Step2_Patient.fxml"));
        viewPatientDetails.viewerRole="Receptionist";
        parentBorderPane.setCenter(patient);

    }

    @FXML
    void changeToReceptionist(MouseEvent event) throws IOException {
        BorderPane parentBorderPane = (BorderPane) (step2Anchor.getParent());
        Parent patient = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/recepDetails/Step2_Receptionist.fxml"));
        parentBorderPane.setCenter(patient);
        viewReceptionistDetails.viewrRole="Receptionist";
    }

    @FXML
    void changeToMedicalOfficer(MouseEvent event) throws IOException {
        BorderPane parentBorderPane = (BorderPane) (step2Anchor.getParent());
        Parent mo = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/moDetails/Step2_Doctor.fxml"));
        parentBorderPane.setCenter(mo);
        viewMODetails.viewerRole="Receptionist";
    }


    @FXML
    void changeToAdmin(MouseEvent event) throws IOException {
        BorderPane parentBorderPane = (BorderPane) (step2Anchor.getParent());
        Parent admin = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/adminDetails/Step2_Admin.fxml"));
        parentBorderPane.setCenter(admin);
    }

}
