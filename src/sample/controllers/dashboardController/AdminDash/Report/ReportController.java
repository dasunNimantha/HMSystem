package sample.controllers.dashboardController.AdminDash.Report;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import sample.controllers.dashboardController.AdminDash.AdminController;
import sample.models.Admin;

import java.io.IOException;

public class ReportController {

    @FXML
    private JFXDatePicker patientLogFrom;

    @FXML
    private JFXDatePicker patientLogTo;

    @FXML
    private JFXButton patientLogExpCSVBtn;

    @FXML
    private JFXButton patientLogExpPDFBtn;

    @FXML
    private ComboBox<String> doctorCombo;

    @FXML
    private JFXButton appointExpPDFBtn;

    @FXML
    private JFXDatePicker appointFrom;

    @FXML
    private JFXDatePicker appointTo;

    @FXML
    private JFXButton appointExpCSVBtn;

    @FXML
    private ComboBox<String> userRoleCombo;

    @FXML
    private JFXButton userLogExpCSVBtn;

    @FXML
    private JFXDatePicker userLogFrom;

    @FXML
    private JFXDatePicker userLogTo;

    @FXML
    private JFXButton userLogExpPDFBtn;

    @FXML
    void appointExpCSV(ActionEvent event) {

    }

    @FXML
    void appointExpPDF(ActionEvent event) {

    }

    @FXML
    void patientLogExpCSV(ActionEvent event) throws IOException {
        Admin.exportPatientCred("admin","Dasun Nimantha");
    }

    @FXML
    void patientLogExpPDF(ActionEvent event) {

    }

    @FXML
    void userLogExpCSV(ActionEvent event) throws IOException {
        Admin.exportLoginLog(false,userLogFrom.getValue(),userLogTo.getValue(),userRoleCombo.getValue());
    }

    @FXML
    void userLogExpPDF(ActionEvent event) {
        Admin.exportLoginPDF(userLogFrom.getValue(),userLogTo.getValue(),userRoleCombo.getValue());
    }

    public void initialize(){
        userRoleCombo.getItems().setAll("All","Patient","Receptionist","Medical_Officer","Admin");
    }

}
