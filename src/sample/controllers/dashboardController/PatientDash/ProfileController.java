package sample.controllers.dashboardController.PatientDash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import sample.models.Patient;
import sample.models.UserTasks;

import java.io.*;
import java.time.LocalDate;


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
    private ImageView editImage;

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
    void proAdd(MouseEvent event) {
        FileChooser fc = new FileChooser();

        FileChooser.ExtensionFilter fileExtensions =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg");
        fc.getExtensionFilters().add(fileExtensions);
        File proPicFile = fc.showOpenDialog(null);
        String imageDest = "src/sample/fileDatabase/profileImages/"+PatientController.patientData[3]+".jpg";
        try {
            //calling file copy function
            copyFile(proPicFile,imageDest);
            Patient patient = new Patient();
            patient.setUserName(PatientController.patientData[0]);
            patient.setPassword(PatientController.patientData[1]);
            patient.setName(PatientController.patientData[2]);
            patient.setIdNumber(Integer.parseInt(PatientController.patientData[3]));
            patient.setDob(LocalDate.parse(PatientController.patientData[4]));
            patient.setGender(PatientController.patientData[5]);
            patient.setMaritalStatus(PatientController.patientData[6]);
            patient.setAddress(PatientController.patientData[7]);
            patient.setPhoneNumber(Integer.parseInt(PatientController.patientData[8]));
            patient.setProfilePath(imageDest);
            patient.setBloodGroup(PatientController.patientData[10]);
            patient.setAllergies(PatientController.patientData[11]);

            UserTasks.userEditFunction("Patient","Patient",patient,PatientController.patientData[0]);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

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

        String imagePath = PatientController.patientData[9];
        Image proPic = new Image(imagePath);
        profileCircle.setFill(new ImagePattern(proPic));

    }

    private static void copyFile(File source, String dest) throws IOException {
        try (InputStream is = new FileInputStream(source); OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
            }
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }


}
