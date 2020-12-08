package sample.controllers;

import javafx.event.EventHandler;
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

   //************************* Patient Dashboard Window Loader Function *****************************//

    void pDashboardLoader() throws IOException {
        Stage patientDashboardStage = new Stage();
        Parent root = FXMLLoader.load(getClass().getResource("../views/Dashboard/PatientDashboard.fxml"));
        Scene scene = new Scene(root,1271,623);
        patientDashboardStage.setScene(scene);
        patientDashboardStage.show();

    }
    public static void changeToScene(String sceneName) {
        screenController.activate(sceneName);
    }
}
