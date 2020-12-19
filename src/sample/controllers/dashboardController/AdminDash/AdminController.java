package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTreeTableView;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TreeTableColumn;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.util.Callback;
import sample.models.Patient;
import sample.models.User;
import sample.models.UserTasks;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;


public class AdminController implements Initializable {

    @FXML
    private  BorderPane adminBorderPane;

    @FXML
    private JFXButton patientView;

    @FXML
    private AnchorPane step2Anchor;

    @FXML
    private AnchorPane patientDetailAnchor;

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
        Parent step6 = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step6/step6.fxml"));
        adminBorderPane.setCenter(step6);
    }

    @FXML
    void step7(ActionEvent event) throws IOException {
    }



    @FXML
    void changeToPatientMenu(MouseEvent event) throws IOException {

        BorderPane parentBorderPane = (BorderPane) (step2Anchor.getParent());
        Parent patient = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step2/patientDetails/Step2_Patient.fxml"));
        parentBorderPane.setCenter(patient);

    }



    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }



}

