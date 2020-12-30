package sample.controllers.dashboardController.MODash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.models.MedicalOfficer;
import sample.models.Patient;
import sample.models.User;

import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

public class MOController {

    public static User loggedUserProfile;
    public static MedicalOfficer typeCastedMO;

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
   private JFXButton logOutBtn;

    @FXML
    private BorderPane moBorderPane;

    @FXML
    void step1(ActionEvent event) throws IOException {
        Parent step1 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/mODash/Step1.fxml"));
        moBorderPane.setCenter(step1);

    }

    @FXML
    void step2(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/mODash/Step2.fxml"));
        moBorderPane.setCenter(step2);
    }

    @FXML
    void step3(ActionEvent event) throws IOException {
    }

    @FXML
    void step4(ActionEvent event) throws IOException {

    }

    @FXML
    void step5(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/mODash/Profile.fxml"));
        moBorderPane.setCenter(step2);
    }

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label nameLabel;

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

    public void initialize(){

        typeCastedMO = (MedicalOfficer) loggedUserProfile;

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

        String[] splitName = typeCastedMO.getName().split("\\s+");
        if(typeCastedMO.getGender().equals("Male")){
            nameLabel.setText("Mr."+splitName[0]);
        } else {
            if(typeCastedMO.getMaritalStatus().equals("Married")){
                nameLabel.setText("Mrs."+splitName[0]);
            } else {
                nameLabel.setText("Ms."+splitName[0]);
            }
        }

    }
}


