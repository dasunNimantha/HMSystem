package sample.controllers.dashboardController.PatientDash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ComboBox;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.models.Crypto;
import sample.models.Patient;
import sample.models.User;
import sample.models.UserTasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class PatientController {

    public static String loggedUserusername;
    static ArrayList<User>PatientProfile;

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
    private  Label welcomeName;


    @FXML
    private JFXButton AppointmentBtn;

    @FXML
    private  BorderPane mainBorderPane;

    @FXML
    private BorderPane subBorderPane;

    @FXML
    private AnchorPane appointmentAnchor;

    @FXML
    private JFXButton logOutBtn;

    @FXML
    void step1(ActionEvent event) throws IOException {

        Parent step2 = FXMLLoader.load(this.getClass().getResource("../../../views/dashboard/patientDash/Step1.fxml"));
        subBorderPane.setCenter(step2);
        patientBtn1.setRipplerFill(Color.valueOf("blue"));
        AppointmentController.appointmentPageVisitCount=0;


    }

    @FXML
    void step2(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2.fxml"));
        subBorderPane.setCenter(step2);
        patientBtn2.setRipplerFill(Color.valueOf("blue"));
        AppointmentController.appointmentPageVisitCount=0;
    }

    @FXML
    void step3(ActionEvent event) throws IOException {
        Parent step3 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step3.fxml"));
        subBorderPane.setCenter(step3);
        patientBtn3.setRipplerFill(Color.valueOf("blue"));
        AppointmentController.appointmentPageVisitCount=0;
    }

    @FXML
    void step4(ActionEvent event) throws IOException {
        Parent step4 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step4.fxml"));
        subBorderPane.setCenter(step4);
        patientBtn4.setRipplerFill(Color.valueOf("blue"));
        AppointmentController.appointmentPageVisitCount=0;
    }

    @FXML
    void step5(ActionEvent event) throws IOException {
        Parent step5 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step5.fxml"));
        subBorderPane.setCenter(step5);
        patientBtn6.setRipplerFill(Color.valueOf("red"));
        AppointmentController.appointmentPageVisitCount=0;
    }

    @FXML
    void step6(ActionEvent event) {

    }
    @FXML
    private AnchorPane addComplaintAnchor;

    @FXML
    private ComboBox<String> complaintCombo;


    @FXML
    void addAppointment(ActionEvent event) throws IOException {
        Parent add = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2_Appoinment.fxml"));
        subBorderPane.setCenter(add);
    }

    public void makeComplaint(ActionEvent actionEvent) throws IOException {
        Parent addAppointment = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step4_Complaint.fxml"));
        BorderPane tempBorderPane = (BorderPane) (addComplaintAnchor.getParent());
        tempBorderPane.setCenter(addAppointment);

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
     PatientProfile=UserTasks.viewUser(false,"Patient","Patient", loggedUserusername);

    }



}




