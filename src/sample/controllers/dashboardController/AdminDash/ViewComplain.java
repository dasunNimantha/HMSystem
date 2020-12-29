package sample.controllers.dashboardController.AdminDash;

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
import sample.controllers.dashboardController.PatientDash.PatientController;
import sample.models.Complain;
import sample.models.Reference;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;

public class ViewComplain {

    public static Complain selectedComplain;
    static ArrayList<String> complainType;

    @FXML
    private AnchorPane addComplainAnchor;

    @FXML
    private Label dateText;


    @FXML
    private TextField complainByText;

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
    private ComboBox<String> complainCombo;

    @FXML
    private JFXButton editBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton backBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    void actionTaken(ActionEvent event) throws IOException {
        actionLAabel.setText("Action Taken");
        selectedComplain.setActionTaken("Action Taken");
        Complain.editComplain("Admin", selectedComplain.getComplainID(),selectedComplain);

    }


    @FXML
    void deleteComplain(ActionEvent event) throws IOException {
        Complain.deleteComplain(selectedComplain.getComplainID());
        Parent complainList = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step5/Step5.fxml"));
        BorderPane tempBorderPane = (BorderPane) addComplainAnchor.getParent();
        tempBorderPane.setCenter(complainList);
    }


    @FXML
    void editComplain(ActionEvent event) {

        complainCombo.getSelectionModel().select(selectedComplain.getComplainType());
        backBtn.setVisible(false);
        saveBtn.setVisible(true);
        editBtn.setVisible(false);
        deleteBtn.setVisible(false);
        cancelBtn.setVisible(true);

        complainByText.setEditable(true);
        phoneNo.setEditable(true);
        descriptionField.setEditable(true);
        noteText.setEditable(true);
        complainTypeText.setVisible(false);
        complainCombo.setVisible(true);
    }

    @FXML
    void cancelEdit(ActionEvent event) {
        deleteBtn.setVisible(true);
        backBtn.setDisable(false);
        backBtn.setVisible(true);
        editBtn.setVisible(true);
        saveBtn.setVisible(false);
        cancelBtn.setVisible(false);
        complainCombo.setVisible(false);
        complainTypeText.setVisible(true);

        dateText.setText("  "+selectedComplain.getComplainedDate().toString());
        complainByText.setEditable(false);
        complainByText.setText("  "+selectedComplain.getComplaintBy());
        phoneNo.setText("  "+selectedComplain.getPhoneNo());
        actionLAabel.setText(selectedComplain.getActionTaken());
        complainTypeText.setText("  "+selectedComplain.getComplainType());
        descriptionField.setText("  "+selectedComplain.getDescription());
        noteText.setText("  "+selectedComplain.getNote());
    }

    @FXML
    void saveComplain(ActionEvent event) throws IOException {
        Complain complain = new Complain();
        complain.setComplainID(selectedComplain.getComplainID());
        complain.setComplainedDate(selectedComplain.getComplainedDate());
        complain.setComplaintBy(complainByText.getText().trim());
        complain.setActionTaken(selectedComplain.getActionTaken());
        complain.setPhoneNo(phoneNo.getText().trim());
        complain.setComplainType(complainCombo.getSelectionModel().getSelectedItem());
        complain.setDescription(descriptionField.getText().trim());
        complain.setNote(noteText.getText().trim());

        Complain.editComplain("Admin", selectedComplain.getComplainID(), complain);

        saveBtn.setVisible(false);
        cancelBtn.setVisible(false);
        editBtn.setVisible(true);
        backBtn.setVisible(true);

    }

    @FXML
    void backToFeedBack(ActionEvent event) throws IOException {
        Parent feedBack = FXMLLoader.load(getClass().getResource("../../../views/dashboard/adminDash/Step5/Step5.fxml"));
        BorderPane tempBorderPane = (BorderPane) (addComplainAnchor.getParent());
        tempBorderPane.setCenter(feedBack);
    }

    public void initialize() throws IOException {
            getComplainData();

    }

    public void getComplainData() throws IOException {
        dateText.setText("  "+selectedComplain.getComplainedDate().toString());
        complainByText.setEditable(false);
        complainByText.setText("  "+selectedComplain.getComplaintBy());
        phoneNo.setText("  "+selectedComplain.getPhoneNo());
        actionLAabel.setText(selectedComplain.getActionTaken());
        complainTypeText.setText("  "+selectedComplain.getComplainType());
        descriptionField.setText("  "+selectedComplain.getDescription());
        noteText.setText("  "+selectedComplain.getNote());

        complainType = Reference.returnReference("ComplainTypeRef");
        Collections.sort(complainType);
        for (String s : complainType) {
            complainCombo.getItems().add(s);
        }

    }


}
