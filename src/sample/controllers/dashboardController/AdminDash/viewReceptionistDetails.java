package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
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
import sample.models.Enums;
import sample.models.Patient;
import sample.models.Receptionist;
import sample.models.UserTasks;

import java.io.IOException;
import java.time.LocalDate;

public class viewReceptionistDetails {

    static Receptionist selectedUser;
    public static String viewrRole;

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
    private ComboBox<String> genderCombo;

    @FXML
    private ComboBox<String> maritalStatusCombo;


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


    @FXML
    private Label passwdLbl;



    public void backToRecepDetails(ActionEvent actionEvent) throws IOException {
        BorderPane parentBorderPane = (BorderPane) editBtn.getParent().getParent();
        Parent recep = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/recepDetails/Step2_Receptionist.fxml"));
        parentBorderPane.setCenter(recep);

    }

    final String oldUsername = selectedUser.getUserName();

    public void getUsrData() {

        nameLabel.setText(selectedUser.getName());
        usernameLbl.setText("#" + selectedUser.getUserName());
        passwordText.setText(selectedUser.getPassword());
        nameText.setText(selectedUser.getName());
        usernameText.setText(selectedUser.getUserName());
        idNoText.setText(String.valueOf(selectedUser.getIdNumber()));
        phoneNoText.setText(String.valueOf(selectedUser.getPhoneNumber()));
        String[] addr = selectedUser.getAddress().split(",");
        addrLine1.setText(addr[0]);
        addrLine2.setText(addr[1]);
        addrLine3.setText(addr[2]);
        genderText.setText(selectedUser.getGender());
        maritalText.setText(selectedUser.getMaritalStatus());
        datePicker.setPromptText(selectedUser.getDob().toString());
        String imagePath = selectedUser.getProfilePath();
        Image proPic = new Image(imagePath);
        staffIdText.setText(String.valueOf(selectedUser.getStaffId()));
        staffEmailText.setText(selectedUser.getEmail());
        dateOfJoinText.setText(selectedUser.getDateOfJoin().toString());
        profileCircle.setFill(new ImagePattern(proPic));
    }

    @FXML
    void saveEdit(ActionEvent event) throws IOException {

        Receptionist editedRecep = new Receptionist();

        editedRecep.setName(nameText.getText().trim());
        editedRecep.setUserName(usernameText.getText().trim());
        editedRecep.setPassword(passwordText.getText().trim());
        editedRecep.setIdNumber(Integer.parseInt(idNoText.getText().trim()));
        editedRecep.setAddress(addrLine1.getText().trim() + "," + addrLine2.getText().trim() + "," + addrLine3.getText().trim());
        editedRecep.setPhoneNumber(Integer.parseInt(phoneNoText.getText()));
        editedRecep.setProfilePath(selectedUser.getProfilePath());

        if (datePicker.getValue() == null) {
            editedRecep.setDob(selectedUser.getDob());
        } else {
            editedRecep.setDob(datePicker.getValue());
        }
        if (genderCombo.getValue() == null) {
            editedRecep.setGender(selectedUser.getGender());
        } else {
            editedRecep.setGender(genderCombo.getValue());
        }
        if (maritalStatusCombo.getValue() == null) {
                editedRecep.setMaritalStatus(selectedUser.getMaritalStatus());
        } else {
                editedRecep.setMaritalStatus(maritalStatusCombo.getValue());
        }

        editedRecep.setDateOfJoin(LocalDate.parse(dateOfJoinText.getText()));
        editedRecep.setStaffId(Integer.parseInt(staffIdText.getText().trim()));
        editedRecep.setEmail(staffEmailText.getText().trim());
        // call edit user function
        UserTasks.userEditFunction("Admin", "Receptionist", editedRecep, oldUsername);
        usernameLbl.setText("#" + usernameText.getText());
        nameLabel.setText(nameText.getText());
        cancelSave();


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
            addrLine1.setEditable(false);
            addrLine2.setEditable(false);
            addrLine3.setEditable(false);
            staffEmailText.setEditable(false);
            staffIdText.setEditable(false);
            dateOfJoinText.setEditable(false);
            genderText.setVisible(true);
            maritalText.setVisible(true);
            backBtn.setVisible(true);
            editBtn.setVisible(true);
            deleteUserBtn.setVisible(true);
            saveEditBtn.setVisible(false);
            cancelEdit.setVisible(false);
        }




    public void initialize() {
        if(viewrRole.equals("Receptionist")){
            passwordText.setVisible(false);
            editBtn.setVisible(false);
            passwdLbl.setVisible(false);
            passwdLbl.setManaged(true);
            deleteUserBtn.setVisible(false);

        }
        getUsrData();

        editBtn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent actionEvent) {

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
                staffEmailText.setEditable(true);
                staffIdText.setEditable(true);
                phoneNoText.setEditable(true);
                addrLine1.setEditable(true);
                addrLine2.setEditable(true);
                addrLine3.setEditable(true);
                genderText.setVisible(false);
                maritalText.setVisible(false);
                genderCombo.setVisible(true);
                genderCombo.setPromptText(selectedUser.getGender());
                maritalStatusCombo.setVisible(true);
                maritalStatusCombo.setPromptText(selectedUser.getMaritalStatus());
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
                    UserTasks.deleteUser("Admin", "Receptionist", idNo, userName);
                } catch (IOException exception) {
                    exception.printStackTrace();
                }

            }
        });
    }

    public void cancelEdit(ActionEvent actionEvent) {
        cancelSave();
        getUsrData();
    }

}

