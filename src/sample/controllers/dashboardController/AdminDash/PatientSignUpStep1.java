package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
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
import sample.models.Enums;
import sample.models.Patient;
import sample.models.Enums;
import sample.models.User;

import java.io.IOException;
import java.util.ArrayList;

public class PatientSignUpStep1 {


    static User patient = new Patient();

    @FXML
    private JFXButton backToPatientList;

    @FXML
    private AnchorPane signUp3Anchor;

    // Step 1 nodes

    @FXML
    private AnchorPane signUp1Anchor;

    @FXML
    private AnchorPane signUp2Anchor;

    @FXML
    private JFXTextField firstNameText;

    @FXML
    private JFXTextField lastNameText;

    @FXML
    private JFXTextField idNoText;

    @FXML
    private JFXTextField userNameText;

    @FXML
    private JFXTextField telephoneNo;

    @FXML
    private JFXDatePicker dobPicker;


    // Step 2 nodes

    @FXML
    private JFXTextField addrFirstText;

    @FXML
    private JFXTextField addrSecondText;

    @FXML
    private JFXTextField addrCityText;

    @FXML
    private JFXComboBox<Enums.enumGender> genderDropDown;

    @FXML
    private JFXComboBox<Enums.enumMaritalStatus> maritalDropDown;


    @FXML
    void backToPatientList(ActionEvent event) throws IOException {
        AnchorPane acp = (AnchorPane) backToPatientList.getParent();
        BorderPane parentBorderPane = (BorderPane) (acp.getParent());
        Parent patient = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/patientDetails/Step2_Patient.fxml"));
        parentBorderPane.setCenter(patient);
    }

    @FXML
    void changeToNext1(MouseEvent event) {
        patient.setName(firstNameText.getText()+lastNameText.getText());
        patient.setUserName(userNameText.getText());
        patient.setIdNumber(Integer.parseInt(idNoText.getText()));
        patient.setDob(dobPicker.getValue());
        patient.setPhoneNumber(Integer.parseInt(telephoneNo.getText()));

        BorderPane tempBorderPane = (BorderPane) signUp1Anchor.getParent();
        tempBorderPane.setCenter(AdminController.screenMap.get("step2"));

    }


    @FXML
    void back1(ActionEvent event) {
        BorderPane tempBorderPane = (BorderPane) signUp2Anchor.getParent();
        tempBorderPane.setCenter(AdminController.screenMap.get("step1"));
    }



    @FXML
    void back2(ActionEvent event) {
        BorderPane tempBorderPane = (BorderPane) signUp3Anchor.getParent();
        tempBorderPane.setCenter(AdminController.screenMap.get("step2"));
    }

    public void initialize(){

    }


}