package sample.controllers.dashboardController.AdminDash;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import sample.models.Admin;

import java.io.IOException;

public class ReportController {

    @FXML
    private DatePicker fromDate;

    @FXML
    private DatePicker toDate;

    @FXML
    private JFXButton loginExport;


    @FXML
    private ComboBox<String> userRoleCombo;

    @FXML
    void exportLogin(ActionEvent event) throws IOException {

        Admin.exportLoginLog(false,fromDate.getValue(),toDate.getValue(),userRoleCombo.getValue());

    }

    public void initialize(){
        userRoleCombo.getItems().addAll("Patient","Receptionist,","Medical_Officer","Admin");
    }

}
