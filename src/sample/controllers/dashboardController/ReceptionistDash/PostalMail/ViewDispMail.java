package sample.controllers.dashboardController.ReceptionistDash.PostalMail;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextArea;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import sample.models.PostalMail;

import java.io.IOException;

public class ViewDispMail {

    public static PostalMail selectedMail;
    public static String oldRefNumber;

    @FXML
    private AnchorPane viewMailAnchor;

    @FXML
    private JFXButton backBtn;

    @FXML
    private JFXTextArea noteText;

    @FXML
    private TextField dateText;

    @FXML
    private TextField fromText;

    @FXML
    private TextField toAddressText;

    @FXML
    private TextField toText;

    @FXML
    private TextField referenceNoText;


    @FXML
    private JFXButton cancelEdit;

    @FXML
    private JFXButton saveBtn;

    @FXML
    private TextField idNoText1;

    @FXML
    private TextField idNoText11;

    @FXML
    private JFXButton editBtn;

    @FXML
    private JFXButton deleteBtn;

    @FXML
    private JFXDatePicker datePicker;

    @FXML
    void backToDisp(ActionEvent event) {

    }

    @FXML
    void cancelEdit(ActionEvent event) {

        getMailData();
        cancelEdit.setVisible(false);
        saveBtn.setVisible(false);
        editBtn.setVisible(true);
        deleteBtn.setVisible(true);
        backBtn.setVisible(true);
        datePicker.setVisible(false);
        dateText.setVisible(true);

    }

    @FXML
    void deleteMail(ActionEvent event) {

    }

    @FXML
    void editMail(ActionEvent event) {
        fromText.setEditable(true);
        toAddressText.setEditable(true);
        toText.setEditable(true);
        dateText.setEditable(true);
        noteText.setEditable(true);
        referenceNoText.setEditable(true);
        dateText.setVisible(false);
        datePicker.setVisible(true);

        backBtn.setVisible(false);
        deleteBtn.setVisible(false);
        saveBtn.setVisible(true);
        cancelEdit.setVisible(true);
        editBtn.setVisible(false);
    }

    @FXML
    void saveEdit(ActionEvent event) throws IOException {

        PostalMail postalMail = new PostalMail();
        postalMail.setMailType("Dispatched");
        postalMail.setRefNumber(referenceNoText.getText().trim());
        postalMail.setToName(toText.getText().trim());
        postalMail.setNote(noteText.getText().trim());
        postalMail.setFromAddress(toAddressText.getText().trim());
        postalMail.setDate(datePicker.getValue());
        postalMail.setFrom(fromText.getText().trim());

        PostalMail.editMail("Dispatched",oldRefNumber,postalMail);

        dateText.setText(datePicker.getValue().toString());
        dateText.setVisible(true);
        datePicker.setVisible(false);
        editBtn.setVisible(true);
        saveBtn.setVisible(false);
        backBtn.setVisible(true);
        deleteBtn.setVisible(true);
        cancelEdit.setVisible(false);

    }


    public void getMailData(){
        fromText.setEditable(false);
        toAddressText.setEditable(false);
        toText.setEditable(false);
        dateText.setEditable(false);
        noteText.setEditable(false);
        referenceNoText.setEditable(false);

        fromText.setText(selectedMail.getFrom());
        toAddressText.setText(selectedMail.getaddress());
        toText.setText(selectedMail.getToName());
        dateText.setText(selectedMail.getDate().toString());
        datePicker.setValue(selectedMail.getDate());
        noteText.setText(selectedMail.getNote());
        referenceNoText.setText(selectedMail.getRefNumber());
    }

    public void initialize(){
        oldRefNumber= selectedMail.getRefNumber();
        getMailData();

    }


}
