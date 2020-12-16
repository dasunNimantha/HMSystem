package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import sample.controllers.dashboardController.AdminDash.AdminController;
import sample.models.Receptionist;

import java.io.IOException;

public class PatientSignUp {

    @FXML
    private BorderPane signUpBorderPane;

    @FXML
    private JFXTextField firstNameText;

    @FXML
    private JFXTextField lastNameText;

    @FXML
    private JFXTextField idNoText;

    @FXML
    private JFXTextField userNameText;

    @FXML
    private JFXButton backToPatientList;

    @FXML
    private JFXButton next;


    @FXML
    private AnchorPane signUp1Anchor;


    @FXML
    private AnchorPane signUp2Anchor;

    @FXML
    private AnchorPane signUp3Anchor;



    @FXML
    void backToPatientList(ActionEvent event) throws IOException {
        AnchorPane acp = (AnchorPane) backToPatientList.getParent();
        BorderPane parentBorderPane = (BorderPane) (acp.getParent());
        Parent patient = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/patientDetails/Step2_Patient.fxml"));
        parentBorderPane.setCenter(patient);
    }

    @FXML
    void changeToNext1(MouseEvent event) {
        BorderPane tempBorderPane = (BorderPane) signUp1Anchor.getParent();
        tempBorderPane.setCenter(AdminController.screenMap.get("step2"));
    }


    @FXML
    void back1(ActionEvent event) {
        BorderPane tempBorderPane = (BorderPane) signUp2Anchor.getParent();
        tempBorderPane.setCenter(AdminController.screenMap.get("step1"));
    }


    @FXML
    void changeToNext2(ActionEvent event) {
        BorderPane tempBorderPane = (BorderPane) signUp2Anchor.getParent();
        tempBorderPane.setCenter(AdminController.screenMap.get("step3"));
    }

    @FXML
    void back2(ActionEvent event) {
        BorderPane tempBorderPane = (BorderPane) signUp3Anchor.getParent();
        tempBorderPane.setCenter(AdminController.screenMap.get("step2"));
    }


}