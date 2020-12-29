package sample.controllers.dashboardController.ReceptionistDash;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTimePicker;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.models.Visitor;

import java.io.IOException;

public class RecepAddVisitor {

    @FXML
    private AnchorPane addComplainAnchor;

    @FXML
    private JFXTextArea purposeField;

    @FXML
    private TextField attachText;

    @FXML
    private JFXButton browseButton;

    @FXML
    private JFXButton addVisitorBtn;

    @FXML
    private TextField noteText;

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
    void addVisitor(ActionEvent event) throws IOException {

        Visitor visitor = new Visitor();

        visitor.setVisitorName(nameText.getText());
        visitor.setIdNo(Integer.parseInt(idNoText.getText()));
        visitor.setPhoneNo(Integer.parseInt(phoneNoText.getText()));
        visitor.setDate(date.getValue());
        visitor.setInTime(inTime.getValue());
        visitor.setOutTime(outTime.getValue());
        visitor.setPurpose(purposeField.getText());
        if(noteText.getText().trim().length()==0){
            visitor.setNote("-");
        } else {
            visitor.setNote(noteText.getText().trim());
        }

        Visitor.addVisitor(visitor);

    }

    @FXML
    void backToComplainListBack(ActionEvent event) throws IOException {
        Parent visitorList = FXMLLoader.load(getClass().getResource("../../../views/dashboard/recepDash/recepVisitorList.fxml"));
        BorderPane subBorderPane = (BorderPane) addComplainAnchor.getParent();
        subBorderPane.setCenter(visitorList);
    }

}
