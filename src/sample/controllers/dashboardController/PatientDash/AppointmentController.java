package sample.controllers.dashboardController.PatientDash;

import com.jfoenix.controls.JFXComboBox;
import javafx.fxml.FXML;
import sample.models.Admin;
import sample.models.Crypto;
import sample.models.UserTasks;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class AppointmentController {

    @FXML
    private JFXComboBox<String> specialityCombo;




    public void initialize() throws IOException {
         // call reference function
         ArrayList <String> speciality = UserTasks.returnReference("SpecialityRef");
         int count = speciality.size();
         for (String s : speciality) {
            specialityCombo.getItems().add(s);
        }
    }
}
