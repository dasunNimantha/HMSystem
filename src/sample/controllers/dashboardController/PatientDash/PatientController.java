package sample.controllers.dashboardController.PatientDash;

import com.jfoenix.controls.JFXButton;
import com.sun.scenario.effect.impl.sw.java.JSWBlend_SOFT_LIGHTPeer;
import de.jensd.fx.glyphs.testapps.App;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.JavaFXBuilderFactory;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import org.w3c.dom.ls.LSOutput;

import java.io.IOException;
import java.net.URL;
import java.util.Arrays;

public class PatientController {

    public static String objEncString;
    private final String [] decryptedData = objEncString.split("~");
    private static int count;


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
    void step1(ActionEvent event) throws IOException {

        Parent step2 = FXMLLoader.load(this.getClass().getResource("../../../views/dashboard/patientDash/Step1.fxml"));
        subBorderPane.setCenter(step2);
        patientBtn1.setRipplerFill(Color.valueOf("blue"));


    }

    @FXML
    void step2(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2.fxml"));
        subBorderPane.setCenter(step2);
        patientBtn2.setRipplerFill(Color.valueOf("blue"));
    }

    @FXML
    void step3(ActionEvent event) throws IOException {
        Parent step3 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step3.fxml"));
        subBorderPane.setCenter(step3);
        patientBtn3.setRipplerFill(Color.valueOf("blue"));
    }

    @FXML
    void step4(ActionEvent event) throws IOException {
        Parent step4 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step4.fxml"));
        subBorderPane.setCenter(step4);
        patientBtn4.setRipplerFill(Color.valueOf("blue"));
    }

    @FXML
    void step5(ActionEvent event) throws IOException {
        Parent step5 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step5.fxml"));
        subBorderPane.setCenter(step5);
        patientBtn6.setRipplerFill(Color.valueOf("red"));
    }
    @FXML
    void step6(ActionEvent event) {

    }

    @FXML
    void addAppointment(ActionEvent event) throws IOException {
        Parent add = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step2_Appoinment.fxml"));
        subBorderPane.setCenter(add);
    }

    public void initialize() {

        count++;
        if(count<2){
            String[] name = decryptedData[2].split(" ");

            if((decryptedData[5].equals("Male"))){
                welcomeName.setText("Mr."+name[0]);
            } else {
                if(decryptedData[6].equals("Married")){
                    welcomeName.setText("Mrs."+name[0]);
                } else {
                    welcomeName.setText("Ms."+name[0]);
                }

            }

    }

    }



   }




