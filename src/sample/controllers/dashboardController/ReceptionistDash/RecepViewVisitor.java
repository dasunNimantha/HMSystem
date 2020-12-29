package sample.controllers.dashboardController.ReceptionistDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.models.Visitor;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalTime;

public class RecepViewVisitor {

    public static Visitor selectedVisitor;
    private static int oldIdNo;
    private LocalTime oldInTime;
    private LocalDate oldDate;

    @FXML
    private AnchorPane visitorAnchor;

    @FXML
    private JFXButton backBtn;

    @FXML
    private TextField attachText;

    @FXML
    private JFXButton browseButton;

    @FXML
    private TextField noteText;

    @FXML
    private JFXButton editBtn;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private JFXButton cancelBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private TextField idNoText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField phoneNoText;

    @FXML
    private JFXTimePicker inTime;

    @FXML
    private JFXTimePicker outTime;

    @FXML
    private JFXDatePicker date;

    @FXML
    private JFXTextArea purposeField;

    @FXML
    private TextField dateText;

    @FXML
    private TextField inTimeText;

    @FXML
    private TextField outTimetext;

    @FXML
    void back(ActionEvent event) throws IOException {
        Parent visitorList = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/RecepVisitorList.fxml"));
        BorderPane tempBorderPane = (BorderPane) (visitorAnchor.getParent());
        tempBorderPane.setCenter(visitorList);
    }

    @FXML
    void cancelEdit(ActionEvent event) {
        getVisitorData();
        cancelBtn.setVisible(false);
        saveBtn.setVisible(false);
        editBtn.setVisible(true);
        backBtn.setVisible(true);
        deleteBtn.setVisible(true);

        nameText.setEditable(false);
        idNoText.setEditable(false);
        noteText.setEditable(false);
        phoneNoText.setEditable(false);
        purposeField.setEditable(false);

    }

    @FXML
    void deleteVisitor(ActionEvent event) throws IOException {

       Visitor.deleteVisitor(Integer.parseInt(idNoText.getText()),LocalDate.parse(dateText.getText()),LocalTime.parse(inTimeText.getText()));
        Parent visitorList = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/RecepVisitorList.fxml"));
        BorderPane tempBorderPane = (BorderPane) (visitorAnchor.getParent());
        tempBorderPane.setCenter(visitorList);
    }

    @FXML
    void editVisitor(ActionEvent event) {
        backBtn.setVisible(false);
        saveBtn.setVisible(true);
        editBtn.setVisible(false);
        deleteBtn.setVisible(false);
        cancelBtn.setVisible(true);
        dateText.setVisible(false);
        inTimeText.setVisible(false);
        outTimetext.setVisible(false);
        nameText.setEditable(true);
        idNoText.setEditable(true);
        phoneNoText.setEditable(true);
        date.setEditable(true);
        noteText.setEditable(true);
        purposeField.setEditable(true);
        date.setVisible(true);
        inTime.setVisible(true);
        outTime.setVisible(true);

    }

    @FXML
    void saveVisitor(ActionEvent event) throws IOException {

        Visitor visitor = new Visitor();
        visitor.setVisitorName(nameText.getText().trim());
        visitor.setIdNo(Integer.parseInt(idNoText.getText().trim()));
        visitor.setPhoneNo(Integer.parseInt(phoneNoText.getText().trim()));
        visitor.setDate(date.getValue());
        visitor.setInTime(inTime.getValue());
        visitor.setOutTime(outTime.getValue());
        visitor.setPurpose(purposeField.getText());
        visitor.setNote(noteText.getText());

        Visitor.editVisitor(oldIdNo,oldDate,oldInTime,visitor);


        date.setVisible(false);
        inTime.setVisible(false);
        outTime.setVisible(false);

        dateText.setText(date.getValue().toString());
        inTimeText.setText(inTime.getValue().toString());
        outTimetext.setText(outTime.getValue().toString());

        dateText.setVisible(true);
        inTimeText.setVisible(true);
        outTimetext.setVisible(true);

        saveBtn.setVisible(false);
        cancelBtn.setVisible(false);
        editBtn.setVisible(true);
        backBtn.setVisible(true);

        nameText.setEditable(false);
        idNoText.setEditable(false);
        noteText.setEditable(false);
        phoneNoText.setEditable(false);
        purposeField.setEditable(false);
    }

    public void initialize(){
       getVisitorData();

        oldIdNo= selectedVisitor.getIdNo();
        oldDate= selectedVisitor.getDate();
        oldInTime=selectedVisitor.getInTime();

    }

    public void getVisitorData(){
        nameText.setText(selectedVisitor.getVisitorName());
        idNoText.setText(String.valueOf(selectedVisitor.getIdNo()));
        phoneNoText.setText(String.valueOf(selectedVisitor.getPhoneNo()));
        inTimeText.setText(String.valueOf(selectedVisitor.getInTime()));
        outTimetext.setText(String.valueOf(selectedVisitor.getOutTime()));
        dateText.setText(String.valueOf(selectedVisitor.getDate()));
        purposeField.setText(selectedVisitor.getPurpose());
        noteText.setText(selectedVisitor.getNote());
        date.setValue(selectedVisitor.getDate());
        inTime.setValue(selectedVisitor.getInTime());
        outTime.setValue(selectedVisitor.getOutTime());
    }

}
