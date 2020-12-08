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
    /************************* SignUp Window Loader Function *****************************/
    public void signUpLoader(){
        Stage signUpStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../views/SignUp/Step_1.fxml"));
            Scene scene = new Scene(root,1049,594);
            signUpStage.setScene(scene);
            final double[] xOffset = new double[1];
            final double[] yOffset = new double[1];
            signUpStage.setTitle("Sign Up");
            signUpStage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            root.setOnMousePressed(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    xOffset[0] = event.getSceneX();
                    yOffset[0] = event.getSceneY();
                }
            });
            root.setOnMouseDragged(new EventHandler<MouseEvent>() {
                @Override
                public void handle(MouseEvent event) {
                    signUpStage.setX(event.getScreenX() - xOffset[0]);
                    signUpStage.setY(event.getScreenY() - yOffset[0]);
                }
            });


            signUpStage.show();
            screenController = new ScreenController(scene);
            screenController.addScreen("1", root);
            screenController.addScreen("2", FXMLLoader.load(getClass().getResource("../views/SignUp/Step_2.fxml")));
            screenController.addScreen("3", FXMLLoader.load(getClass().getResource("../views/SignUp/Step_3.fxml")));
            screenController.addScreen("login",FXMLLoader.load(getClass().getResource("../views/Login.fxml")));

        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
    /************************* Login Window Loader Function *****************************/
    public void loginLoader(){
        Stage loginStage = new Stage();
        try {
            Parent root = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));
            Scene scene = new Scene(root,1049,594);
            loginStage.setScene(scene);



            loginStage.show();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

   //************************* Patient Dashboard Window Loader Function *****************************//

    public void pDashboardLoader() throws IOException {
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
