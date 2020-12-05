package sample.controllers;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

public class PatientDboardController implements Initializable {

    public VBox pnl_scroll;
    public Label lbl_currentprojects;
    public Label lbl_pending;
    public Label lbl_completed;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }

    public void handleButtonAction(MouseEvent mouseEvent) {
    }
}