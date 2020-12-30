package sample.controllers.dashboardController.MODash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import sample.controllers.dashboardController.ReceptionistDash.ReceptionistController;

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
    private JFXButton editProfileBtn;

    @FXML
    private JFXButton changePassBtn;

    @FXML
    private TextField staffId;

    @FXML
    private TextField staffEmail;

    @FXML
    void changePass(ActionEvent event) {

    }

    @FXML
    void editProfile(ActionEvent event) {

    }

    public void initialize(){

        String imagePath = MOController.typeCastedMO.getProfilePath();
        Image proPic = new Image(imagePath);
        profileCircle.setFill(new ImagePattern(proPic));

        nameLabel.setText(MOController.typeCastedMO.getName());
        usernameLbl.setText("#"+MOController.typeCastedMO.getUserName());
        nameText.setText(MOController.typeCastedMO.getName());
        usernameText.setText(MOController.typeCastedMO.getUserName());
        idNoText.setText(String.valueOf(MOController.typeCastedMO.getIdNumber()));
        phoneNoText.setText(String.valueOf(MOController.typeCastedMO.getPhoneNumber()));
        dobText.setText(String.valueOf(MOController.typeCastedMO.getIdNumber()));
        genderText.setText(MOController.typeCastedMO.getGender());
        maritalText.setText(MOController.typeCastedMO.getMaritalStatus());
        staffId.setText(String.valueOf(ReceptionistController.typeCastedRecep.getStaffId()));
        staffEmail.setText(MOController.typeCastedMO.getEmail());

        String[] addr = MOController.typeCastedMO.getAddress().split(",");
        addr1Text.setText(addr[0]);
        addr2Text.setText(addr[1]);
        addr3Text.setText(addr[2]);
    }

}
