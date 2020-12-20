package sample.controllers.dashboardController.ReceptionistDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import java.net.URL;
import java.util.ResourceBundle;

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
    private AnchorPane step2Anchor;

    @FXML
    private AnchorPane step6Anchor;

    @FXML
    private AnchorPane step3Anchor;

    @FXML
    private JFXComboBox<String> dropGender;

    @FXML
    private JFXComboBox<String> dropMaritial;

    @FXML
    private BorderPane recepBorderPane;

    @FXML
    private JFXTextField textSID;

    @FXML
    private JFXButton editSettings;

    @FXML
    private JFXTextField textUserName;

    @FXML
    private JFXTextField textDj;

    @FXML
    private JFXTextField textEmail;

    @FXML
    private JFXTextField textID;

    @FXML
    private JFXTextField textPhone;

    @FXML
    private JFXTextArea textAddress;

    @FXML
    private JFXTextField textDOB;

    @FXML
    private JFXTextField textName;


    @FXML
    void disList(MouseEvent event) {

    }

    @FXML
    void recList(MouseEvent event) {

    }

    @FXML
    void addVisLoad(MouseEvent event) {

    }


    @FXML
    void step1(ActionEvent event) throws IOException {
        Parent step1 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Step1.fxml"));
        recepBorderPane.setCenter(step1);
    }

    @FXML
    void step2(ActionEvent event) throws IOException {
        Parent step2 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Step2.fxml"));
        recepBorderPane.setCenter(step2);
    }

    @FXML
    void step3(ActionEvent event) throws IOException {
        Parent step3 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Postal/Step3.fxml"));
        recepBorderPane.setCenter(step3);
    }

    @FXML
    void step4(ActionEvent event) throws IOException {
        Parent step4 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Visitor/Step4.fxml"));
        recepBorderPane.setCenter(step4);
    }

    @FXML
    void step5(ActionEvent event) throws IOException {
        Parent step5 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Step5.fxml"));
        recepBorderPane.setCenter(step5);
    }


    @FXML
    void step6(ActionEvent event) throws IOException {
        Parent step6 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Step6.fxml"));
        recepBorderPane.setCenter(step6);
    }

    @FXML
    void test(ActionEvent event) throws IOException {


    }
    @FXML
    void profileEditable(MouseEvent event) {
        textID.setEditable(true);
        textSID.setEditable(true);
        textDOB.setEditable(true);
        textAddress.setEditable(true);
        textDj.setEditable(true);
        textEmail.setEditable(true);
        textName.setEditable(true);
        textPhone.setEditable(true);
        textUserName.setEditable(true);
        editSettings.setText("Save Changes");


    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        //dropMaritial.getItems().removeAll(dropMaritial.getItems());
        dropMaritial.getItems().add("Married");
        dropMaritial.getItems().add("UnMarried");
    }




}
