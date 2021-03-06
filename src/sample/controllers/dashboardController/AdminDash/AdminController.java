package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;


public class AdminController implements Initializable {

    public static String objEncString;

    @FXML
    private BorderPane adminBorderPane;

    @FXML
    private JFXButton patientView;

    @FXML
    private AnchorPane step2Anchor;

    @FXML
    private AnchorPane patientDetailAnchor;


    @FXML
    private AnchorPane mainAnchor;

    @FXML
    private JFXButton Step2_patientBtn;

    @FXML
    private JFXButton addPatientBtn;

    @FXML
    private AnchorPane signUp1Anchor;

    @FXML
    private JFXButton next;

    @FXML
    private Label nameLabel;

    @FXML
    private JFXButton logoutBtn;

    @FXML
    void step1(ActionEvent event) throws IOException {
        Parent step1 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Home.fxml"));
        adminBorderPane.setCenter(step1);
    }

    @FXML
    void step2(ActionEvent event) throws IOException {
        Parent users = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/Step2.fxml"));
        adminBorderPane.setCenter(users);
    }


    @FXML
    void step3(ActionEvent event) throws IOException {
        Parent step3 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step3/Step3.fxml"));
        adminBorderPane.setCenter(step3);

    }

    @FXML
    void step4(ActionEvent event) throws IOException {
        Parent step4 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step4/Step4.fxml"));
        adminBorderPane.setCenter(step4);
    }

    @FXML
    void step5(ActionEvent event) throws IOException {
        Parent step5 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step5/Step5.fxml"));
        adminBorderPane.setCenter(step5);
    }

    @FXML
    void step6(ActionEvent event) throws IOException {
       // Parent step6 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step6/Step5.fxml"));
       // adminBorderPane.setCenter(step6);
    }

    @FXML
    void step7(ActionEvent event) throws IOException {
    }



    @FXML
    void changeToPatientMenu(MouseEvent event) throws IOException {
        BorderPane parentBorderPane = (BorderPane) (step2Anchor.getParent());
        Parent patient = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/patientDetails/Step2_Patient.fxml"));
        parentBorderPane.setCenter(patient);
        viewPatientDetails.viewerRole="Admin";

    }

    @FXML
    void changeToReceptionist(MouseEvent event) throws IOException {
        BorderPane parentBorderPane = (BorderPane) (step2Anchor.getParent());
        Parent patient = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/recepDetails/Step2_Receptionist.fxml"));
        parentBorderPane.setCenter(patient);
        viewReceptionistDetails.viewrRole="Admin";
    }

    @FXML
    void changeToMedicalOfficer(MouseEvent event) throws IOException {
        BorderPane parentBorderPane = (BorderPane) (step2Anchor.getParent());
        Parent mo = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/moDetails/Step2_Doctor.fxml"));
        parentBorderPane.setCenter(mo);
        viewReceptionistDetails.viewrRole="Admin";
    }


    @FXML
    void changeToAdmin(MouseEvent event) throws IOException {
        BorderPane parentBorderPane = (BorderPane) (step2Anchor.getParent());
        Parent admin = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/adminDetails/Step2_Admin.fxml"));
        parentBorderPane.setCenter(admin);

    }

    @FXML
    void logOut(ActionEvent event) throws IOException, InterruptedException {
        // clear received object when login

        Stage stage = (Stage) mainAnchor.getScene().getWindow(); // close dashboard
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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



}

