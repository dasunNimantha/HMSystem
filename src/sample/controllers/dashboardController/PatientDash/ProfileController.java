package sample.controllers.dashboardController.PatientDash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import java.io.FileNotFoundException;


public class ProfileController  {

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
    private TextField bloodGrpText;

    @FXML
    private TextField allergiesText;

    @FXML
    private TextField addr1Text;

    @FXML
    private TextField addr2Text;

    @FXML
    private TextField addr3Text;

    @FXML
    private ImageView editImage1;

    @FXML
    private JFXButton editProfileBtn;

    @FXML
    private JFXButton changePassBtn;

    @FXML
    void changePass(ActionEvent event) {

    }

    @FXML
    void editProfile(ActionEvent event) {
        editImage1.setVisible(true);

        nameText.setEditable(true);
        usernameText.setEditable(true);
        idNoText.setEditable(true);
        phoneNoText.setEditable(true);
        dobText.setEditable(true);
        addr1Text.setEditable(true);
        addr2Text.setEditable(true);
        addr3Text.setEditable(true);

    }

    public void initialize() throws FileNotFoundException {
        nameLabel.setText(PatientController.patientData[2]);
        usernameLbl.setText("#"+PatientController.patientData[0]);
        nameText.setText(PatientController.patientData[2]);
        usernameText.setText(PatientController.patientData[2]);
        idNoText.setText(PatientController.patientData[3]);
        phoneNoText.setText(PatientController.patientData[8]);
        dobText.setText(PatientController.patientData[4]);
        genderText.setText(PatientController.patientData[5]);
        maritalText.setText(PatientController.patientData[6]);
        bloodGrpText.setText(PatientController.patientData[10]);

        String[] addr = PatientController.patientData[7].split(",");
        addr1Text.setText(addr[0]);
        addr2Text.setText(addr[1]);
        addr3Text.setText(addr[2]);

        String imagePath = "sample/assets/images/dashboard/Maithripala-_Russia_(portrait).jpg";
        Image proPic = new Image(imagePath);
        profileCircle.setFill(new ImagePattern(proPic));


    }


}
