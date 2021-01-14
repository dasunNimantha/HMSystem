package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressIndicator;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.models.UserTasks;

import java.io.IOException;

public class RecepSignUpStep3 extends RecepSignUpStep1 {

    @FXML
    private AnchorPane signUp3Anchor;

    @FXML
    private BorderPane signUpBorderPane;

    @FXML
    private ProgressIndicator progressInd3;

    @FXML
    private Label step3Label;

    @FXML
    private AnchorPane finishPageAnchor;

    @FXML
    private JFXDatePicker dateOfJoin;

    @FXML
    private TextField staffIdText;

    @FXML
    private TextField staffEmailText;

    @FXML
    private JFXComboBox<?> specialityDropDown;

    @FXML
    private Button attachDocBtn;

    @FXML
    private Button staffPhotoBtn;

    @FXML
    private JFXButton backToUserList;

    @FXML
    private JFXButton btnFinish;

    @FXML
    void backToUserList(ActionEvent event) throws IOException {
        AnchorPane acp = (AnchorPane) backToUserList.getParent();
        BorderPane parentBorderPane = (BorderPane) (acp.getParent());
        Parent recep = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/recepDetails/Step2_Receptionist.fxml"));
        parentBorderPane.setCenter(recep);

    }

    @FXML
    void back2(ActionEvent event) {
        BorderPane tempBorderPane = (BorderPane) signUp3Anchor.getParent();
        tempBorderPane.setCenter(ReceptionistDetails.signUpRecepMap.get("step2"));
    }

    @FXML
    void FinishSignUp(ActionEvent event) throws IOException {

        receptionist.setStaffId(Integer.parseInt(staffIdText.getText()));
        receptionist.setEmail(staffEmailText.getText());
        receptionist.setDateOfJoin(dateOfJoin.getValue());
        receptionist.setStaffPhoto("Not Submitted");

        receptionist.setProfilePath("ProfileImages\\default.png");
        // pass object to write to the patientDB.txt file
        UserTasks.createPatient("Admin","Receptionist",receptionist);


        //go back to patient list after finish
        AnchorPane acp = (AnchorPane) backToUserList.getParent();
        BorderPane parentBorderPane = (BorderPane) (acp.getParent());
        Parent recep = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/recepDetails/Step2_Receptionist.fxml"));
        parentBorderPane.setCenter(recep);

    }

}
