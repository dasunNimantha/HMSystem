package sample.controllers;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

public class SceneLoader {

    private static ScreenController screenController;

    private double xOffset = 0;
    private double yOffset = 0;

   //************************* Patient Dashboard Window Loader Function *****************************//

    void DashboardLoader(String role) throws IOException {

        switch (role) {
            case "Admin" -> {
                Parent root1 = FXMLLoader.load(getClass().getResource("../views/dashboard/adminDash/AdminMain.fxml"));
                Stage AdminStage = new Stage();
                Loader(AdminStage, root1);
            }
            case "Receptionist" -> {
                Parent root2 = FXMLLoader.load(getClass().getResource("../views/dashboard/recepDash/ReceptionistMain.fxml"));
                Stage RecepStage = new Stage();
                Loader(RecepStage, root2);
            }
            case "Medical_Officer" -> {
                Parent root3 = FXMLLoader.load(getClass().getResource("../views/dashboard/mODash/MedicalOfficerMain.fxml"));
                Stage MOStage = new Stage();
                Loader(MOStage, root3);
            }
            case "Patient" -> {
                Parent root4 = FXMLLoader.load(getClass().getResource("../views/dashboard/patientDash/PatientMain.fxml"));
                Stage PatientStage = new Stage();
                Loader(PatientStage, root4);
            }
        }
    }


    public static void LoginLoader (){

    }


    // Loader and mouse drag function

    public void Loader(Stage stage,Parent ParentName) {
        Scene scene = new Scene(ParentName,1271,693);
        stage.setScene(scene);
        stage.setTitle("Dashboard");
        stage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        ParentName.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // Move around here
        ParentName.setOnMouseDragged((MouseEvent event) -> {
            stage.setX(event.getScreenX() - xOffset);
            stage.setY(event.getScreenY() - yOffset);
        });
        stage.show();
    }


}
