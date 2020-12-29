package sample.controllers.dashboardController.ReceptionistDash.PostalMail;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.models.PostalMail;

import java.time.LocalDate;

public class RecepAddDispMail {

    @FXML
    private AnchorPane recMailAnchor;

    @FXML
    private JFXTextArea purposeField;

    @FXML
    private JFXButton addVisitorBtn;

    @FXML
    private TextField idNoText;

    @FXML
    private TextField nameText;

    @FXML
    private TextField phoneNoText;

    @FXML
    private TextField nameText1;

    @FXML
    private TextField phoneNoText1;

    @FXML
    private JFXTextArea purposeField1;

    @FXML
    private JFXButton backBtn;

    @FXML
    private JFXTextArea note;

    @FXML
    private JFXButton addMailBtn;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    private TextField fromText;

    @FXML
    private TextField fromAddr;

    @FXML
    private TextField toText;

    @FXML
    private TextField refNo;

    @FXML
    private JFXTextArea purposeField11;

    @FXML
    void addMail(ActionEvent event) {
        PostalMail postalMail = new PostalMail();
        postalMail.setMailType("Dispatched");
        postalMail.setFrom(fromText.getText());
        postalMail.setFromAddress(fromAddr.getText());
        postalMail.setDate(LocalDate.now());
        postalMail.setRefNumber(refNo.getText());
        postalMail.setToName(toText.getText());
        postalMail.setNote(note.getText());

        PostalMail.addPostalMail("Dispatched",postalMail);
    }


    @FXML
    void backToList(ActionEvent event) {

    }

    public void initialize(){

        datePicker.setValue(LocalDate.now());
    }

}
