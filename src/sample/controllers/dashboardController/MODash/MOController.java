package sample.controllers.dashboardController.MODash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class MOController {

    public static String objEncString;
    private final String [] decryptedData = objEncString.split("~");

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
    private BorderPane recepBorderPane;

    @FXML
    void step1(ActionEvent event) throws IOException {
        Parent step1 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/mODash/Step1.fxml"));
        recepBorderPane.setCenter(step1);

    }

    @FXML
    void step2(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/mODash/Step2.fxml"));
        recepBorderPane.setCenter(step2);

    }

    @FXML
    void step3(ActionEvent event) throws IOException {
        Parent step3 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/mODash/Step3.fxml"));
        recepBorderPane.setCenter(step3);

    }

    @FXML
    void step4(ActionEvent event) throws IOException {
        Parent step4 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/mODash/Step4.fxml"));
        recepBorderPane.setCenter(step4);


    }

    @FXML
    void step5(ActionEvent event) {

    }

    @FXML
    void step6(ActionEvent event) {

    }

    @FXML
    void step7(ActionEvent event) {

    }

}
