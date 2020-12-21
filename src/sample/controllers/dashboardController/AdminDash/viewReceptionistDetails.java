package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import sample.models.Patient;
import sample.models.Receptionist;

import java.io.IOException;

public class viewReceptionistDetails {

    static Receptionist selectedRecep;

    @FXML
    private TextField staffIdText;

    @FXML
    private Button editBtn;

    @FXML
    private TextField staffEmailText;

    @FXML
    private Label nameLabel;

    @FXML
    private Circle profileCircle;

    @FXML
    private Label usernameLbl;


    @FXML
    private Button backBtn;

    @FXML
    private Button saveEditBtn;

    @FXML
    private Button cancelEdit;

    @FXML
    private Button deleteUserBtn;

    @FXML
    private TextField nameText;

    @FXML
    private TextField usernameText;

    @FXML
    private TextField idNoText;

    @FXML
    private TextField phoneNoText;

    @FXML
    private TextField passwordText;

    @FXML
    private ComboBox<?> genderCombo;

    @FXML
    private ComboBox<?> maritalStatusCombo;

    @FXML
    private ComboBox<?> bloodGroupCombo;


    @FXML
    private TextField dateOfJoinText;

    @FXML
    private TextField addrLine1;

    @FXML
    private TextField addrLine2;

    @FXML
    private TextField addrLine3;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private TextField genderText;

    @FXML
    private TextField maritalText;


    public void backToRecepDetails(ActionEvent actionEvent) throws IOException {
        BorderPane parentBorderPane = (BorderPane) editBtn.getParent().getParent();
        Parent recep = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/recepDetails/Step2_Receptionist.fxml"));
        parentBorderPane.setCenter(recep);

  }

    final  String oldUsername = selectedRecep.getUserName();

    public void getUsrData(){

        nameLabel.setText(selectedRecep.getName());
        usernameLbl.setText("#"+selectedRecep.getUserName());
        passwordText.setText(selectedRecep.getPassword());
        nameText.setText(selectedRecep.getName());
        usernameText.setText(selectedRecep.getUserName());
        idNoText.setText(String.valueOf(selectedRecep.getIdNumber()));
        phoneNoText.setText(String.valueOf(selectedRecep.getPhoneNumber()));
        String [] addr = selectedRecep.getAddress().split(",");
        addrLine1.setText(addr[0]);
        addrLine2.setText(addr[1]);
        addrLine3.setText(addr[2]);
        genderText.setText(selectedRecep.getGender());
        maritalText.setText(selectedRecep.getMaritalStatus());
        datePicker.setPromptText(selectedRecep.getDob().toString());
        String imagePath = selectedRecep.getProfilePath();
        Image proPic = new Image(imagePath);
        staffIdText.setText(String.valueOf(selectedRecep.getStaffId()));
        staffEmailText.setText(selectedRecep.getEmail());
        dateOfJoinText.setText(toString());
        profileCircle.setFill(new ImagePattern(proPic));
    }

  public void initialize(){
        getUsrData();
  }
    public void saveEdit(ActionEvent actionEvent) {
    }

    public void cancelEdit(ActionEvent actionEvent) {
    }
}

