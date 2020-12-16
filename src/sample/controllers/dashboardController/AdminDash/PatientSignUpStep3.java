package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.input.ContextMenuEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.models.Enums;

import java.io.IOException;

public class PatientSignUpStep3 {

    @FXML
    private JFXButton backToPatientList;

    @FXML
    private AnchorPane signUp2Anchor;

    @FXML
    private ProgressIndicator progressInd3;

    @FXML
    private Label step3Label;


    @FXML
    private AnchorPane signUp3Anchor;

    @FXML
    private JFXComboBox<String> bloodGrp;

    @FXML
    void clickTest(ActionEvent event) {
        step3Label.setVisible(false);
        progressInd3.setStyle("-fx-accent:green");
    }
    @FXML
    void backToPatientList(ActionEvent event) throws IOException {
        AnchorPane acp = (AnchorPane) backToPatientList.getParent();
        BorderPane parentBorderPane = (BorderPane) (acp.getParent());
        Parent patient = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/patientDetails/Step2_Patient.fxml"));
        parentBorderPane.setCenter(patient);
    }

    @FXML
    void back2(ActionEvent event) {
        BorderPane tempBorderPane = (BorderPane) signUp3Anchor.getParent();
        tempBorderPane.setCenter(AdminController.screenMap.get("step2"));
    }

    public void initialize(){
        bloodGrp.getItems().addAll(
                Enums.enumBloodGroup.A_NEGATIVE.getBloodGroup(),
                Enums.enumBloodGroup.A_POSITIVE.getBloodGroup(),
                Enums.enumBloodGroup.B_POSITIVE.getBloodGroup(),
                Enums.enumBloodGroup.B_NEGATIVE.getBloodGroup(),
                Enums.enumBloodGroup.O_POSITIVE.getBloodGroup(),
                Enums.enumBloodGroup.O_NEGATIVE.getBloodGroup(),
                Enums.enumBloodGroup.AB_POSITIVE.getBloodGroup(),
                Enums.enumBloodGroup.AB_NEGATIVE.getBloodGroup());
    }

}
