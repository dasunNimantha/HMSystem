package sample.controllers.dashboardController.ReceptionistDash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import sample.controllers.dashboardController.PatientDash.PatientController;

import java.util.Arrays;

public class ProfileController {

    @FXML
    private AnchorPane addComplaintAnchor;

    @FXML
    private Label nameLabel;

    @FXML
    private Circle profileCircle;

    @FXML
    private Label usernameLbl;

    @FXML
    private TextField nameText;

    @FXML
    private TextField usernameText;

    @FXML
    private TextField idNoText;

    @FXML
    private TextField phoneNoText;

    @FXML
    private TextField dobText;

    @FXML
    private TextField genderText;

    @FXML
    private TextField maritalText;

    @FXML
    private TextField addr1Text;

    @FXML
    private TextField addr2Text;

    @FXML
    private TextField addr3Text;


    @FXML
    private TextField staffId;

    @FXML
    private TextField staffEmail;


    @FXML
    private JFXButton editProfileBtn;

    @FXML
    private JFXButton changePassBtn;

    @FXML
    void changePass(ActionEvent event) {

    }

    @FXML
    void editProfile(ActionEvent event) {

    }


    public void initialize(){


        String imagePath = ReceptionistController.typeCastedRecep.getProfilePath();
        Image proPic = new Image(imagePath);
        profileCircle.setFill(new ImagePattern(proPic));

        nameLabel.setText(ReceptionistController.typeCastedRecep.getName());
        usernameLbl.setText("#"+ReceptionistController.typeCastedRecep.getUserName());
        nameText.setText(ReceptionistController.typeCastedRecep.getName());
        usernameText.setText(ReceptionistController.typeCastedRecep.getUserName());
        idNoText.setText(String.valueOf(ReceptionistController.typeCastedRecep.getIdNumber()));
        phoneNoText.setText(String.valueOf(ReceptionistController.typeCastedRecep.getPhoneNumber()));
        dobText.setText(String.valueOf(ReceptionistController.typeCastedRecep.getDob()));
        genderText.setText(ReceptionistController.typeCastedRecep.getGender());
        maritalText.setText(ReceptionistController.typeCastedRecep.getMaritalStatus());
        staffId.setText(String.valueOf(ReceptionistController.typeCastedRecep.getStaffId()));
        staffEmail.setText(ReceptionistController.typeCastedRecep.getEmail());

        String[] addr = ReceptionistController.typeCastedRecep.getAddress().split(",");
        addr1Text.setText(addr[0]);
        addr2Text.setText(addr[1]);
        addr3Text.setText(addr[2]);

    }
}
