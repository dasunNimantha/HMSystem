package sample.controllers.DashboardController;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class ReceptionistController {

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
        Parent step1 = FXMLLoader.load(getClass().getResource("../../views/Dashboard/Step1.fxml"));
        recepBorderPane.setCenter(step1);
    }

    @FXML
    void step2(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../views/Dashboard/Step2.fxml"));
        recepBorderPane.setCenter(step2);
    }

    @FXML
    void step3(ActionEvent event) {

    }

    @FXML
    void step4(ActionEvent event) {

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
