package sample.controllers.dashboardController.PatientDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.models.Complain;
import sample.models.Reference;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;

public class ComplainController {

    static ArrayList<String> complainType;

    @FXML
    private AnchorPane addComplainAnchor;

    @FXML
    private ComboBox<String> complainCombo;

    @FXML
    private Label dateText;

    @FXML
    private Label complaintBy;

    @FXML
    private TextField phoneNo;

    @FXML
    private JFXTextArea descriptionField;

    @FXML
    private TextField noteText;

    @FXML
    private TextField attachText;

    @FXML
    private JFXButton browseButton;

    @FXML
    private Label actionLAabel;

    @FXML
    private JFXButton confirmComplainBtn;

    @FXML
    void confirmComplain(ActionEvent event) {

        Complain complain = new Complain();
        complain.setComplaintUserName(PatientController.typeCastedPatient.getUserName());
        complain.setComplainedDate(LocalDate.now());
        complain.setComplaintBy(PatientController.typeCastedPatient.getName());
        complain.setPhoneNo(phoneNo.getText().trim());
        complain.setComplainType(complainCombo.getSelectionModel().getSelectedItem());
        complain.setDescription(descriptionField.getText().trim());
        if(noteText.getText().trim().length()!=0){
            complain.setNote(noteText.getText().trim());
        } else {
            complain.setNote("-");
        }

        // generate complain id
        DateFormat df = new SimpleDateFormat("MMddHHmm");
        Date dateObj = new Date();
        String complainId =(df.format(dateObj));

        complain.setComplainID(Integer.parseInt(complainId));
        complain.setActionTaken("No action yet");
        Complain.createComplain(complain);

    }

    @FXML
    void backToFeedBack(ActionEvent event) throws IOException {
        Parent feedBack = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step4.fxml"));
        BorderPane tempBorderPane = (BorderPane) (addComplainAnchor.getParent());
        tempBorderPane.setCenter(feedBack);
    }

    public void initialize() throws IOException {

        complainType = Reference.returnReference("ComplainTypeRef");
        Collections.sort(complainType);
        for (String s : complainType) {
            complainCombo.getItems().add(s);
        }


        dateText.setText("  "+LocalDate.now().toString());
        complaintBy.setText("  "+PatientController.typeCastedPatient.getName());
        phoneNo.setText("  "+PatientController.typeCastedPatient.getPhoneNumber());






    }

}
