package sample.controllers.dashboardController.AdminDash;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import sample.controllers.dashboardController.MODash.MOController;
import sample.models.Enums;
import sample.models.Patient;
import sample.models.User;
import sample.models.UserTasks;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;


public class viewPatientDetails {

    static User selectedPatient;

    @FXML
    private Label nameLabel;

    @FXML
    private Button editBtn;

    @FXML
    private TextField textField;


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
    private TextField genderText;

    @FXML
    private TextField maritalStatusText;

    @FXML
    private TextField addressText;

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

    public void getUsrData(){
        nameLabel.setText(selectedPatient.getName());
        usernameLbl.setText("#"+selectedPatient.getUserName());
        nameText.setText(selectedPatient.getName());
        usernameText.setText(selectedPatient.getUserName());
        idNoText.setText(String.valueOf(selectedPatient.getIdNumber()));
        phoneNoText.setText(String.valueOf(selectedPatient.getPhoneNumber()));
        genderText.setText(selectedPatient.getGender());
        maritalStatusText.setText(selectedPatient.getMaritalStatus());
        addressText.setText(selectedPatient.getAddress());


        Image proPic = new Image("sample/assets/images/dashboard/Maithripala-_Russia_(portrait).jpg");
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
        editedPatient.setName(nameText.getText());
        editedPatient.setUserName(selectedPatient.getUserName());
        editedPatient.setPassword(selectedPatient.getPassword());
        editedPatient.setIdNumber(selectedPatient.getIdNumber());
        editedPatient.setDob(selectedPatient.getDob());
        editedPatient.setAddress(selectedPatient.getAddress());
        editedPatient.setGender(selectedPatient.getGender());
        editedPatient.setMaritalStatus(selectedPatient.getMaritalStatus());
        editedPatient.setPhoneNumber(selectedPatient.getPhoneNumber());
        editedPatient.setBloodGroup(Enums.enumBloodGroup.A_NEGATIVE.getBloodGroup());
        editedPatient.setAllergies("No allergies for this time");

        // call edit user function
        UserTasks.userEditFunction("Admin","Patient",editedPatient);
        usernameLbl.setText("#"+usernameText.getText());
        nameLabel.setText(nameText.getText());

        cancelSave();


    }

    private void cancelSave() {
        nameText.setEditable(false);
        usernameText.setEditable(false);
        idNoText.setEditable(false);
        phoneNoText.setEditable(false);
        genderText.setEditable(false);
        maritalStatusText.setEditable(false);
        addressText.setEditable(false);

        backBtn.setVisible(true);
        editBtn.setVisible(true);
        deleteUserBtn.setVisible(true);
        saveEditBtn.setVisible(false);
        cancelEdit.setVisible(false);
    }



    @FXML
    void backToPatientDetails(ActionEvent event) {

    }

    public void initialize(){
            getUsrData();

        // edit button action
        editBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                nameText.setEditable(true);
                usernameText.setEditable(true);
                idNoText.setEditable(true);
                phoneNoText.setEditable(true);
                genderText.setEditable(true);
                maritalStatusText.setEditable(true);
                addressText.setEditable(true);

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
                    UserTasks.deleteUser("Admin","Patient",idNo,userName);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

            }
        });
    }

}
