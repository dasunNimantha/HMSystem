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
import sample.controllers.dashboardController.ReceptionistDash.ReceptionistController;
import sample.models.UserTasks;
import java.io.*;



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
    void proAdd(MouseEvent event) {
        FileChooser fc = new FileChooser();
        FileChooser.ExtensionFilter fileExtensions =
                new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg");
        fc.getExtensionFilters().add(fileExtensions);

        File proPicFile = fc.showOpenDialog(null);
        String imageDest = "src/sample/fileDatabase/profileImages/"+PatientController.typeCastedPatient.getIdNumber()+".jpg";
        try {
            //calling file copy function
            copyFile(proPicFile,imageDest);
            PatientController.typeCastedPatient.setProfilePath("sample/fileDatabase/profileImages/"+PatientController.typeCastedPatient.getIdNumber()+".jpg");

            //call user edit function to store the image
            UserTasks.userEditFunction("Patient","Patient",PatientController.typeCastedPatient,PatientController.typeCastedPatient.getUserName());
            Thread.sleep(2000);
            //update static patient object profile path
            String imagePath = PatientController.typeCastedPatient.getProfilePath();
            Image proPic = new Image(imagePath);
            profileCircle.setFill(new ImagePattern(proPic));

        } catch (IOException | InterruptedException ioException) {
            ioException.printStackTrace();
        }

    }

    @FXML
    void editProfile(ActionEvent event) {
        editImage1.setVisible(true);

        nameText.setEditable(true);
        changePassBtn.setVisible(false);
        usernameText.setEditable(true);
        idNoText.setEditable(true);
        phoneNoText.setEditable(true);
        dobText.setEditable(true);
        addr1Text.setEditable(true);
        addr2Text.setEditable(true);
        addr3Text.setEditable(true);

    }

    public void initialize() throws FileNotFoundException {


        nameLabel.setText(PatientController.typeCastedPatient.getName());
        usernameLbl.setText("#"+PatientController.typeCastedPatient.getUserName());
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

       String imagePath = PatientController.typeCastedPatient.getProfilePath();
       Image proPic = new Image(imagePath);
       profileCircle.setFill(new ImagePattern(proPic));

    }

    private static void copyFile(File source, String dest) throws IOException {
        if (source != null) {

            File destPath = new File(dest);
            if(destPath.exists()){
                if(destPath.delete()){
                    System.out.println("deleted prev image");
                }
            }
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
}
