package sample.controllers.dashboardController.ReceptionistDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.models.Complain;

import java.io.IOException;

public class RecepViewComplain {

    public static Complain selectedComplain;

    @FXML
    private AnchorPane addComplainAnchor;

    @FXML
    private Label dateText;

    @FXML
    private Label complaintBy;

    @FXML
    private JFXTextArea descriptionField;

    @FXML
    private TextField attachText;

    @FXML
    private JFXButton browseButton;

    @FXML
    private Label actionLAabel;

    @FXML
    private TextField noteText;

    @FXML
    private TextField phoneNo;

    @FXML
    private TextField complainTypeText;

    @FXML
    void backToFeedBack(ActionEvent event) throws IOException {
        Parent feedBack = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/Step5.fxml"));
        BorderPane tempBorderPane = (BorderPane) (addComplainAnchor.getParent());
        tempBorderPane.setCenter(feedBack);
    }

    public void initialize(){

        dateText.setText("  "+selectedComplain.getComplainedDate().toString());
        complaintBy.setText("  "+selectedComplain.getComplaintBy());
        phoneNo.setText("  "+selectedComplain.getPhoneNo());
        actionLAabel.setText(selectedComplain.getActionTaken());
        complainTypeText.setText("  "+selectedComplain.getComplainType());
        descriptionField.setText("  "+selectedComplain.getDescription());
        noteText.setText("  "+selectedComplain.getNote());

    }

}

