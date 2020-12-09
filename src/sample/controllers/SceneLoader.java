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

    void pDashboardLoader() throws IOException {
        Stage patientDashboardStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../views/Dashboard/ReceptionistMain.fxml"));
        Scene scene = new Scene(root,1271,693);
        patientDashboardStage.setScene(scene);
        patientDashboardStage.setTitle("Dashboard");
        patientDashboardStage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // Move around here
        root.setOnMouseDragged((MouseEvent event) -> {
            patientDashboardStage.setX(event.getScreenX() - xOffset);
            patientDashboardStage.setY(event.getScreenY() - yOffset);
        });
        patientDashboardStage.show();

    }
    public static void changeToScene(String sceneName) {
        screenController.activate(sceneName);
    }
}
