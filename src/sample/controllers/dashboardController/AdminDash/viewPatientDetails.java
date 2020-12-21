package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import sample.controllers.dashboardController.MODash.MOController;
import sample.models.Enums;
import sample.models.Patient;
import sample.models.User;
import sample.models.UserTasks;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;


public class viewPatientDetails {

    static Patient selectedUser;

    @FXML
    private Label nameLabel;

    @FXML
    private Button editBtn;

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
    private TextField passwordText;

    @FXML
    private ComboBox<String> genderCombo;

    @FXML
    private ComboBox<String> maritalStatusCombo;

    @FXML
    private ComboBox<String> bloodGroupCombo;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private TextField addrLine1;

    @FXML
    private TextField addrLine2;

    @FXML
    private TextField addrLine3;

    @FXML
    private TextArea allergiesField;


    @FXML
    private Circle profileCircle;

    @FXML
    private Button saveEditBtn;

    @FXML
    private Button cancelEdit;

    @FXML
    private Button backBtn;

    @FXML
    private Button deleteUserBtn;

    @FXML
    private TextField genderText;

    @FXML
    private TextField maritalText;

    @FXML
    private TextField bloodText;


    final  String oldUsername = selectedUser.getUserName();

    public void getUsrData(){

        nameLabel.setText(selectedUser.getName());
        usernameLbl.setText("#"+selectedUser.getUserName());
        passwordText.setText(selectedUser.getPassword());
        nameText.setText(selectedUser.getName());
        usernameText.setText(selectedUser.getUserName());
        idNoText.setText(String.valueOf(selectedUser.getIdNumber()));
        phoneNoText.setText(String.valueOf(selectedUser.getPhoneNumber()));
        String [] addr = selectedUser.getAddress().split(",");
        addrLine1.setText(addr[0]);
        addrLine2.setText(addr[1]);
        addrLine3.setText(addr[2]);
        genderText.setText(selectedUser.getGender());
        bloodText.setText(selectedUser.getBloodGroup());
        maritalText.setText(selectedUser.getMaritalStatus());
        allergiesField.setText(selectedUser.getAllergies());
        datePicker.setPromptText(selectedUser.getDob().toString());
        String imagePath = selectedUser.getProfilePath();
        Image proPic = new Image(imagePath);
        profileCircle.setFill(new ImagePattern(proPic));
    }

    @FXML
    void cancelEdit(ActionEvent event) {

        cancelSave();
        getUsrData();
    }


    @FXML
    void saveEdit(ActionEvent event) throws IOException {

        Patient editedPatient = new Patient();
        editedPatient.setName(nameText.getText().trim());
        editedPatient.setUserName(usernameText.getText().trim());
        editedPatient.setPassword(passwordText.getText().trim());
        editedPatient.setIdNumber(Integer.parseInt(idNoText.getText().trim()));
        editedPatient.setAddress(addrLine1.getText().trim() + "," + addrLine2.getText().trim() + "," + addrLine3.getText().trim());
        editedPatient.setPhoneNumber(Integer.parseInt(phoneNoText.getText()));
        editedPatient.setProfilePath(selectedUser.getProfilePath());

        if (datePicker.getValue() == null) {
            editedPatient.setDob(selectedUser.getDob());
        } else {
            editedPatient.setDob(datePicker.getValue());
        }
        if (genderCombo.getValue() == null) {
            editedPatient.setGender(selectedUser.getGender());
        } else {
            editedPatient.setGender(genderCombo.getValue());
            if (bloodGroupCombo.getValue() == null) {
                editedPatient.setBloodGroup(selectedUser.getBloodGroup());
            } else {
                editedPatient.setBloodGroup(bloodGroupCombo.getValue());
            }

            if (maritalStatusCombo.getValue() == null) {
                editedPatient.setMaritalStatus(selectedUser.getMaritalStatus());
            } else {
                editedPatient.setMaritalStatus(maritalStatusCombo.getValue());
            }
            editedPatient.setAllergies(allergiesField.getText());
            // call edit user function
            UserTasks.userEditFunction("Admin", "Patient", editedPatient, oldUsername);
            usernameLbl.setText("#" + usernameText.getText());
            nameLabel.setText(nameText.getText());

            cancelSave();

        }

        }


        private void cancelSave () {
            nameText.setEditable(false);
            usernameText.setEditable(false);
            passwordText.setEditable(false);
            idNoText.setEditable(false);
            phoneNoText.setEditable(false);
            addrLine1.setEditable(false);
            addrLine2.setEditable(false);
            addrLine3.setEditable(false);
            allergiesField.setEditable(false);
            addrLine1.setEditable(false);
            addrLine2.setEditable(false);
            addrLine3.setEditable(false);

            genderText.setVisible(true);
            maritalText.setVisible(true);
            bloodText.setVisible(true);
            backBtn.setVisible(true);
            editBtn.setVisible(true);
            deleteUserBtn.setVisible(true);
            saveEditBtn.setVisible(false);
            cancelEdit.setVisible(false);
        }


        @FXML
        void backToPatientDetails (ActionEvent event) throws IOException {
            BorderPane parentBorderPane = (BorderPane) backBtn.getParent().getParent();
            Parent patient = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/patientDetails/Step2_Patient.fxml"));
            parentBorderPane.setCenter(patient);

    }

    public void initialize() {
            getUsrData();

            // edit button action
            editBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {

                    bloodGroupCombo.getItems().addAll(
                            Enums.enumBloodGroup.A_NEGATIVE.getBloodGroup(),
                            Enums.enumBloodGroup.A_POSITIVE.getBloodGroup(),
                            Enums.enumBloodGroup.B_POSITIVE.getBloodGroup(),
                            Enums.enumBloodGroup.B_NEGATIVE.getBloodGroup(),
                            Enums.enumBloodGroup.O_POSITIVE.getBloodGroup(),
                            Enums.enumBloodGroup.O_NEGATIVE.getBloodGroup(),
                            Enums.enumBloodGroup.AB_POSITIVE.getBloodGroup(),
                            Enums.enumBloodGroup.AB_NEGATIVE.getBloodGroup()
                    );

                    genderCombo.getItems().addAll(
                            Enums.enumGender.MALE.getGender(),
                            Enums.enumGender.FEMALE.getGender()
                    );

                    maritalStatusCombo.getItems().addAll(
                            Enums.enumMaritalStatus.MARRIED.getMaritalStatus(),
                            Enums.enumMaritalStatus.UNMARRIED.getMaritalStatus()
                    );

                    nameText.setEditable(true);
                    usernameText.setEditable(true);
                    passwordText.setEditable(true);
                    idNoText.setEditable(true);
                    phoneNoText.setEditable(true);
                    addrLine1.setEditable(true);
                    addrLine2.setEditable(true);
                    addrLine3.setEditable(true);
                    genderText.setVisible(false);
                    maritalText.setVisible(false);
                    bloodText.setVisible(false);
                    genderCombo.setVisible(true);
                    genderCombo.setPromptText(selectedUser.getGender());
                    maritalStatusCombo.setVisible(true);
                    maritalStatusCombo.setPromptText(selectedUser.getMaritalStatus());
                    bloodGroupCombo.setVisible(true);
                    bloodGroupCombo.setPromptText(selectedUser.getBloodGroup());
                    allergiesField.setEditable(true);
                    backBtn.setVisible(false);
                    editBtn.setVisible(false);
                    deleteUserBtn.setVisible(false);
                    saveEditBtn.setVisible(true);
                    cancelEdit.setVisible(true);

                }
            });


            deleteUserBtn.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent actionEvent) {
                    // pop up box for confirming deletion

                    String idNo = idNoText.getText();
                    String userName = usernameText.getText();
                    try {
                        UserTasks.deleteUser("Admin", "Patient", idNo, userName);
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }

                }
            });
        }


}
