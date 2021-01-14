package sample.controllers.dashboardController.PatientDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import javafx.embed.swing.SwingFXUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import sample.models.DetailVerification;
import sample.models.Patient;
import sample.models.UserTasks;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.time.LocalDate;
import java.util.Optional;


public class ProfileController {

    public static Image imgOfProPic;
    public boolean canBeSaved;
    static String oldUserName;
    static String newUserName;


    @FXML
    private AnchorPane profileAnchor;

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
    private ImageView editImage;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton cancelEditBtn;

    @FXML
    private JFXButton editProfileBtn;

    @FXML
    private JFXSpinner waitSpinner;

    @FXML
    private JFXButton changePassBtn;



    @FXML
    void changePass(ActionEvent event) {

    }

    @FXML
    void proAdd(MouseEvent event) throws IOException {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter fileExtensions =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg");
        fc.getExtensionFilters().add(fileExtensions);

        boolean valid = false;
        final long sizeLimit = (1024L * 1024L*2);
        while(!valid) {
            File chosenProPic = fc.showOpenDialog(null);
            if(chosenProPic!=null){
                if (sizeLimit >= chosenProPic.length()) {
                    imgOfProPic = new Image(chosenProPic.toURI().toString());
                    profileCircle.setFill(null);
                    waitSpinner.setVisible(true);

                    saveToFile(imgOfProPic); // call image copy function

                    new java.util.Timer().schedule(
                            new java.util.TimerTask() {
                                @Override
                                public void run() {
                                    waitSpinner.setVisible(false);
                                    profileCircle.setFill(new ImagePattern(imgOfProPic));

                                }
                            },
                            1900
                    );

                    PatientController.typeCastedPatient.setProfilePath("ProfileImages\\"+PatientController.typeCastedPatient.getIdNumber()+".jpg");
                    UserTasks.userEditFunction("Patient","Patient",PatientController.typeCastedPatient,oldUserName);
                    valid=true;
                } else {
                    Alert largeFileAlert = new Alert(Alert.AlertType.INFORMATION);
                    largeFileAlert.setHeaderText("Size limit exceeded");
                    largeFileAlert.setContentText("Maximum file size of the image should be 2MB");
                    largeFileAlert.showAndWait();
                }
            } else {
                System.out.println("No image selected");
                valid=true;
            }


        }


    }

    // image copy function
    public void saveToFile(Image image) throws IOException {
        File fileOutput = new File("ProfileImages\\" + PatientController.typeCastedPatient.getIdNumber() + ".jpg");
        BufferedImage BI = SwingFXUtils.fromFXImage(image, null);
        ImageIO.write(BI, "jpg", fileOutput);

    }

    @FXML
    void saveProEdit(ActionEvent event) throws IOException {
        nonEditable();
        Patient editedPatient = new Patient();

        boolean nameVer=DetailVerification.validName(nameText);
        if(!nameVer){
            canBeSaved=false;
            System.out.println("Invalid Name");
        } else {
            editedPatient.setName(nameText.getText().trim());
            canBeSaved=true;
        }

        boolean userNameVer=DetailVerification.validateUserName(usernameText);
        if(!userNameVer){
            canBeSaved=false;
            System.out.println("Invalid User Name");
        } else {
            editedPatient.setUserName(usernameText.getText().trim());
            canBeSaved=true;
            newUserName=usernameText.getText().trim();
        }

        boolean idVer=DetailVerification.validateNIC(idNoText);
        if(!idVer){
            canBeSaved=false;
            System.out.println("Invalid NIC");
        } else {
            editedPatient.setIdNumber(Integer.parseInt(idNoText.getText().trim()));
            canBeSaved=true;
        }


        boolean phoneVer=DetailVerification.validatePhoneNo(phoneNoText);
        if(!phoneVer){
            canBeSaved=false;
            System.out.println("Invalid PhoneNo");
        } else {
            editedPatient.setPhoneNumber(Integer.parseInt(phoneNoText.getText().trim()));
            canBeSaved=true;
        }

        if(canBeSaved) {
            editedPatient.setDob(LocalDate.parse(dobText.getText()));
            editedPatient.setAddress(addr1Text.getText().trim()+
                    ","+addr2Text.getText().trim()+
                    ","+addr3Text.getText().trim());

            editedPatient.setGender(genderText.getText().trim());
            editedPatient.setMaritalStatus(maritalText.getText().trim());
            editedPatient.setBloodGroup(bloodGrpText.getText().trim());
            editedPatient.setAllergies(allergiesText.getText().trim());

            UserTasks.userEditFunction("Patient","Patient",editedPatient,oldUserName);
            oldUserName=newUserName;
        }


    }

    @FXML
    void cancelEdit(ActionEvent event) {
        nonEditable();
    }

    @FXML
    void editProfile(ActionEvent event) {

        editImage1.setVisible(true);
        editImage.setVisible(true);
        editProfileBtn.setVisible(false);
        changePassBtn.setVisible(false);
        cancelEditBtn.setVisible(true);
        saveBtn.setVisible(true);
        nameText.setEditable(true);
        changePassBtn.setVisible(false);
        usernameText.setEditable(true);
        bloodGrpText.setEditable(true);
        idNoText.setEditable(true);
        phoneNoText.setEditable(true);
        dobText.setEditable(true);
        addr1Text.setEditable(true);
        addr2Text.setEditable(true);
        addr3Text.setEditable(true);

    }

    public void nonEditable(){  // function to hide save buttons and disable edit
        editImage1.setVisible(false);
        editImage.setVisible(false);
        saveBtn.setVisible(false);
        editProfileBtn.setVisible(true);
        changePassBtn.setVisible(true);
        cancelEditBtn.setVisible(false);

        nameText.setEditable(false);
        usernameText.setEditable(false);
        bloodGrpText.setEditable(false);
        idNoText.setEditable(false);
        phoneNoText.setEditable(false);
        dobText.setEditable(false);
        addr1Text.setEditable(false);
        addr2Text.setEditable(false);
        addr3Text.setEditable(false);
    }

    public void initialize() throws FileNotFoundException {

        // setting profile data from the loaded object
        oldUserName=PatientController.typeCastedPatient.getUserName();
        nameLabel.setText(PatientController.typeCastedPatient.getName());
        usernameLbl.setText("#" + PatientController.typeCastedPatient.getUserName());
        nameText.setText(PatientController.typeCastedPatient.getName());
        usernameText.setText(PatientController.typeCastedPatient.getUserName());
        idNoText.setText(String.valueOf(PatientController.typeCastedPatient.getIdNumber()));
        phoneNoText.setText(String.valueOf(PatientController.typeCastedPatient.getPhoneNumber()));
        dobText.setText(String.valueOf(PatientController.typeCastedPatient.getDob()));
        genderText.setText(PatientController.typeCastedPatient.getGender());
        maritalText.setText(PatientController.typeCastedPatient.getMaritalStatus());
        bloodGrpText.setText(PatientController.typeCastedPatient.getBloodGroup());
        allergiesText.setText(PatientController.typeCastedPatient.getAllergies());

        String[] addr = PatientController.typeCastedPatient.getAddress().split(",");
        addr1Text.setText(addr[0]);
        addr2Text.setText(addr[1]);
        addr3Text.setText(addr[2]);

        // set profile image
        String imagePath = PatientController.typeCastedPatient.getProfilePath();
        FileInputStream input = new FileInputStream(imagePath);
        Image img = new Image(input);
        profileCircle.setFill(new ImagePattern(img));

    }
}
