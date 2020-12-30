package sample.controllers.dashboardController.PatientDash;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import org.controlsfx.control.Rating;

import java.io.IOException;

public class FeedbackController {

    @FXML
    private AnchorPane addComplaintAnchor;

    @FXML
    private Rating ratingStar;

    @FXML
    private Circle proCircle;

    @FXML
    void makeComplain(ActionEvent event) throws IOException {
        Parent makeComplain = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/Step4_Complaint.fxml"));
        BorderPane tempBorderPane = (BorderPane) (addComplaintAnchor.getParent());
        tempBorderPane.setCenter(makeComplain);
    }


    @FXML
    void viewComplain(ActionEvent event) throws IOException {
        Parent makeComplain = FXMLLoader.load(getClass().getResource("../../../views/dashboard/patientDash/ComplainsList.fxml"));
        BorderPane tempBorderPane = (BorderPane) (addComplaintAnchor.getParent());
        tempBorderPane.setCenter(makeComplain);
    }



    public void initialize(){

        String imagePath = PatientController.typeCastedPatient.getProfilePath();
        Image proPic = new Image(imagePath);
        proCircle.setFill(new ImagePattern(proPic));

    }
}
