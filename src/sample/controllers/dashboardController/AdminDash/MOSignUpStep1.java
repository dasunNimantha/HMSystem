package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.models.Enums;
import sample.models.MedicalOfficer;

import java.io.IOException;

public class MOSignUpStep1 extends MedicalOfficerDetails {

    static MedicalOfficer medicalOfficer = new MedicalOfficer();


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
    private JFXButton backToUserList;

    @FXML
    void backToUserList(ActionEvent event) throws IOException {
        AnchorPane acp = (AnchorPane) backToUserList.getParent();
        BorderPane parentBorderPane = (BorderPane) (acp.getParent());
        Parent user = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/moDetails/viewMODetails.fxml"));
        parentBorderPane.setCenter(user);

    }

    @FXML
    void changeToNext11(ActionEvent event) {
        medicalOfficer.setName(firstNameText.getText().trim()+" "+lastNameText.getText().trim());
        medicalOfficer.setUserName(userNameText.getText().trim());
        medicalOfficer.setIdNumber(Integer.parseInt(idNoText.getText().trim()));
        medicalOfficer.setPassword(idNoText.getText().trim());
        medicalOfficer.setDob(dobPicker.getValue());
        medicalOfficer.setPhoneNumber(Integer.parseInt(telephoneNo.getText().trim()));

        BorderPane tempBorderPane = (BorderPane) signUp1Anchor.getParent();
        tempBorderPane.setCenter(MedicalOfficerDetails.signUpmoMap.get("step2"));
    }




    @FXML
    void back1(ActionEvent event) {
        BorderPane tempBorderPane = (BorderPane) signUp2Anchor.getParent();
        tempBorderPane.setCenter(MedicalOfficerDetails.signUpmoMap.get("step1"));
    }


    public void initialize() throws IOException {

    }

}
