package sample.controllers.dashboardController.ReceptionistDash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.controllers.dashboardController.PatientDash.AddAppointController;
import sample.models.Patient;
import sample.models.Receptionist;
import sample.models.User;
import sample.models.UserTasks;

import java.io.IOException;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class ReceptionistController {

    public static User loggedUserProfile;
    public static Receptionist typeCastedRecep;

    @FXML
    private Label newAppo;

    @FXML
    private Label totPatient;


    @FXML
    private AnchorPane mainAnchor;

    public static String objEncString;

    @FXML
    private JFXButton recepBtn1;

    @FXML
    private JFXButton recepBtn2;

    @FXML
    private JFXButton recepBtn3;

    @FXML
    private JFXButton recepBtn4;

    @FXML
    private JFXButton recepBtn5;

    @FXML
    private JFXButton recepBtn6;

    @FXML
    private AnchorPane step2Anchor;

    @FXML
    private AnchorPane step6Anchor;

    @FXML
    private AnchorPane step3Anchor;

    @FXML
    private BorderPane recepBorderPane;



    @FXML
    void home(ActionEvent event) throws IOException {
        Parent step1 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Step1.fxml"));
        recepBorderPane.setCenter(step1);
    }

    @FXML
    void viewAppointment(ActionEvent event) throws IOException {
        Parent appointment = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/recepAppointmentList.fxml"));
        recepBorderPane.setCenter(appointment);
        AddAppointController.appointmentPageVisitCount=0;
    }



    @FXML
    void viewUsers(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Users.fxml"));
        recepBorderPane.setCenter(step2);
    }

    @FXML
    void postalMail(ActionEvent event) throws IOException {
        Parent mail = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/PostalMail/PostalMail.fxml"));
        recepBorderPane.setCenter(mail);
    }


    @FXML
    void step4(ActionEvent event) throws IOException {
       Parent step4 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/recepVisitorList.fxml"));
       recepBorderPane.setCenter(step4);
    }


    @FXML
    void step6(ActionEvent event) throws IOException {
        Parent step4 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Step5.fxml"));
        recepBorderPane.setCenter(step4);
    }


    @FXML
    void step7(ActionEvent event) throws IOException {
        Parent step7 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Profile.fxml"));
        recepBorderPane.setCenter(step7);
    }

    @FXML
    void logOut(ActionEvent event) throws IOException, InterruptedException {
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

    @FXML
    private Label nameLabel;

    @FXML
    private Label welcomeLbl;

    public void initialize() throws IOException {

        typeCastedRecep = (Receptionist) loggedUserProfile;

        int [] counter = UserTasks.dataCounter("Receptionist");
        totPatient.setText(String.valueOf(counter[0]));
        newAppo.setText(String.valueOf(counter[1]));

        Date dt = new Date();
        Calendar c = Calendar.getInstance();
        c.setTime(dt);
        int hours = c.get(Calendar.HOUR_OF_DAY);

        if(hours>=1 && hours<=12){
           welcomeLbl.setText("Good Morning,");
        }else if(hours>=12 && hours<=16){
            welcomeLbl.setText("Good Afternoon,");
        }else if(hours>=16 && hours<=21) {
            welcomeLbl.setText("Good Evening,");
        }

        String[] splitName = typeCastedRecep.getName().split("\\s+");
        if(typeCastedRecep.getGender().equals("Male")){
            nameLabel.setText("Mr."+splitName[0]);
        } else {
            if(typeCastedRecep.getMaritalStatus().equals("Married")){
                nameLabel.setText("Mrs."+splitName[0]);
            } else {
                nameLabel.setText("Ms."+splitName[0]);
            }
        }




    }

}
