package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.models.Enums;

import java.io.IOException;

public class RecepSignUpStep2 extends RecepSignUpStep1 {

    @FXML
    private JFXButton backToUserList;

    @FXML
    private AnchorPane signUp2Anchor;

    @FXML
    private AnchorPane signUp3Anchor;


    // Step 2 nodes

    @FXML
    private JFXTextField addrFirstText;

    @FXML
    private JFXTextField addrSecondText;

    @FXML
    private JFXTextField addrCityText;

    @FXML
    private JFXComboBox<String> genderDropDown;

    @FXML
    private JFXComboBox<String> maritalDropDown;



    @FXML
    void back1(ActionEvent event) {
        BorderPane tempBorderPane = (BorderPane) signUp2Anchor.getParent();
        tempBorderPane.setCenter(ReceptionistDetails.signUpRecepMap.get("step1"));
    }

    @FXML
    void backToUserList(ActionEvent event) throws IOException {
        AnchorPane acp = (AnchorPane) backToUserList.getParent();
        BorderPane parentBorderPane = (BorderPane) (acp.getParent());
        Parent user = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/recepDetails/Step2_Receptionist.fxml"));
        parentBorderPane.setCenter(user);

    }

    @FXML
    void changeToNext2(ActionEvent event) {   // next button on step 1

        receptionist.setAddress(
                addrFirstText.getText().trim()+
                        ","+addrSecondText.getText().trim()+
                        ","+addrSecondText.getText().trim());

        receptionist.setGender(genderDropDown.getValue());
        receptionist.setMaritalStatus(maritalDropDown.getValue());


        BorderPane tempBorderPane = (BorderPane) signUp2Anchor.getParent();
        tempBorderPane.setCenter(ReceptionistDetails.signUpRecepMap.get("step3"));
    }




    public void initialize(){

        genderDropDown.getItems().add(Enums.enumGender.MALE.getGender());
        genderDropDown.getItems().add(Enums.enumGender.FEMALE.getGender());
        genderDropDown.getSelectionModel().selectFirst(); //In here,this method is not working for some weird reason

        maritalDropDown.getItems().add(Enums.enumMaritalStatus.MARRIED.getMaritalStatus());
        maritalDropDown.getItems().add(Enums.enumMaritalStatus.UNMARRIED.getMaritalStatus());
        maritalDropDown.getSelectionModel().selectFirst();
    }


}