package sample.controllers.dashboardController.PatientDash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.controllers.dashboardController.AdminDash.viewMODetails;
import sample.models.Patient;
import sample.models.User;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class PatientController {

    public static  User loggedUserProfile;
    public static Patient typeCastedPatient;
    private static boolean  isLoaded = false;

    @FXML
    private JFXButton patientBtn1;

    @FXML
    private JFXButton patientBtn2;

    @FXML
    private JFXButton patientBtn3;

    @FXML
    private JFXButton patientBtn4;

    @FXML
    private JFXButton patientBtn6;


    @FXML
    private Circle smallProPic;

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label nameLabel;

    @FXML
    private  BorderPane mainBorderPane;

    @FXML
    private BorderPane subBorderPane;

    @FXML
    private JFXButton logOutBtn;

    @FXML
    void step1(ActionEvent event) throws IOException {

        Parent step2 = FXMLLoader.load(this.getClass().getResource("../../../views/dashboard/patientDash/Step1.fxml"));
        subBorderPane.setCenter(step2);
    }

    @FXML
    void step2(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2.fxml"));
        subBorderPane.setCenter(step2);
    }

    @FXML
    void step3(ActionEvent event) throws IOException {
        Parent step3 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/moDetails/Step2_Doctor.fxml"));
        subBorderPane.setCenter(step3);
        viewMODetails.viewerRole="Patient";
    }

    @FXML
    void step4(ActionEvent event) throws IOException {
        Parent step4 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step4.fxml"));
        subBorderPane.setCenter(step4);
    }

    @FXML
    void step5(ActionEvent event) throws IOException {
        Parent step5 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step5.fxml"));
        subBorderPane.setCenter(step5);
    }


    @FXML
    void logOut(ActionEvent event) throws InterruptedException, IOException {
        // clear received object when login


        Stage stage = (Stage) logOutBtn.getScene().getWindow(); // close dashboard
        stage.close();

        HashMap<String,Parent> loginMap = new HashMap<>();
        AtomicReference<Double> xOffset = new AtomicReference<>((double) 0);
        AtomicReference<Double> yOffset = new AtomicReference<>((double) 0);

        // open login window
        Parent root = FXMLLoader.load(getClass().getResource("../../../views/Login.fxml"));

        Scene scene = new Scene(root,1049, 594);
        Stage backToLogin = new Stage();
        backToLogin.setScene(scene);
        backToLogin.setTitle("Login");
        backToLogin.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        root.setOnMousePressed((MouseEvent mevent) -> {
            xOffset.set(mevent.getSceneX());
            yOffset.set(mevent.getSceneY());
        });

        // Move around here
        root.setOnMouseDragged((MouseEvent mevent) -> {
            backToLogin.setX(mevent.getScreenX() - xOffset.get());
            backToLogin.setY(mevent.getScreenY() - yOffset.get());
        });

        TimeUnit.MILLISECONDS.sleep(150);
        backToLogin.show();
        loginMap.put("roleSelect",root);

    }

    public void initialize() throws IOException {

        if(!isLoaded){
            typeCastedPatient = (Patient)loggedUserProfile;
            isLoaded=true;
        }

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        int hours = c.get(Calendar.HOUR_OF_DAY);

        if(hours>=1 && hours<=12){
            welcomeLabel.setText("Good Morning,");
        }else if(hours>=12 && hours<=16){
            welcomeLabel.setText("Good Afternoon,");
        }else if(hours>=16 && hours<=21) {
            welcomeLabel.setText("Good Evening,");
        }

        String[] splitName = typeCastedPatient.getName().split("\\s+");
        if(typeCastedPatient.getGender().equals("Male")){
            nameLabel.setText("Mr."+splitName[0]);
        } else {
            if(typeCastedPatient.getMaritalStatus().equals("Married")){
                nameLabel.setText("Mrs."+splitName[0]);
            } else {
                nameLabel.setText("Ms."+splitName[0]);
            }
        }



   }
}




