package sample.controllers.dashboardController.ReceptionistDash.PostalMail;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class PostalMainController {

    @FXML
    private JFXButton dispBtn;

    @FXML
    private AnchorPane mailAnchor;


    @FXML
    void addDispMail(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../../../views/dashboard/recepDash/PostalMail/recepAddDispMail.fxml"));
        BorderPane subBorderPane = (BorderPane) mailAnchor.getParent();
        subBorderPane.setCenter(root);
    }

    @FXML
    void addRecMail(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../../../views/dashboard/recepDash/PostalMail/recepAddRecMail.fxml"));
        BorderPane subBorderPane = (BorderPane) mailAnchor.getParent();
        subBorderPane.setCenter(root);
    }

    @FXML
    void changeToAdmin(MouseEvent event) {

    }

    @FXML
    void viewDispMail(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../../../views/dashboard/recepDash/PostalMail/DispatchedMailList.fxml"));
        BorderPane subBorderPane = (BorderPane) mailAnchor.getParent();
        subBorderPane.setCenter(root);
    }

    @FXML
    void viewRecMail(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../../../../views/dashboard/recepDash/PostalMail/RecievedMailList.fxml"));
        BorderPane subBorderPane = (BorderPane) mailAnchor.getParent();
        subBorderPane.setCenter(root);
    }





}
