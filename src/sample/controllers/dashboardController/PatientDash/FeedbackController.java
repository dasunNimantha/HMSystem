package sample.controllers.dashboardController.PatientDash;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import org.controlsfx.control.Rating;
import sample.models.Ratings;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
public class FeedbackController {

    public static Ratings ratingsObj;

    @FXML
    private AnchorPane addComplaintAnchor;

    @FXML
    private Rating ratingStar;

    @FXML
    private Label ratingLbl;

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

    @FXML
    void ratingStar(MouseEvent event) throws IOException {
        if(ratingsObj!=null){
            Ratings newRating = new Ratings();
            newRating.setThoughtAddedDate(ratingsObj.getThoughtAddedDate());
            newRating.setThoughts(ratingsObj.getThoughts());
            newRating.setRatedUsername(ratingsObj.getRatedUsername());
            newRating.setRating(ratingStar.getRating());
            ratingLbl.setText(Double.toString(ratingStar.getRating()));

            Ratings.updateRating(newRating,PatientController.typeCastedPatient.getUserName());
        }

    }


    public void initialize() throws IOException {

        ArrayList<Ratings> returnedRatingArray = Ratings.viewRating(PatientController.typeCastedPatient.getUserName());

        if(returnedRatingArray.size()!=0){
           ratingsObj = returnedRatingArray.get(0);
           ratingStar.setRating(ratingsObj.getRating());
           ratingLbl.setText(String.valueOf(ratingsObj.getRating()));

        } else {
            ratingStar.setRating(0.0);
            ratingLbl.setText("0.0");
            Ratings rateObj = new Ratings();
            rateObj.setRating(0.0);
            rateObj.setRatedUsername(PatientController.typeCastedPatient.getUserName());
            rateObj.setThoughts("sdsvsv");
            rateObj.setThoughtAddedDate(LocalDate.now());
            Ratings.writeFeedback(rateObj);
            ratingsObj=rateObj;
        }

        String imagePath = PatientController.typeCastedPatient.getProfilePath();
        FileInputStream input = new FileInputStream(imagePath);
        Image img = new Image(input);
        proCircle.setFill(new ImagePattern(img));

    }
}
