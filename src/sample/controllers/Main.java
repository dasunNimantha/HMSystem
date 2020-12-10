package sample.controllers;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Main extends Application {

    private static ScreenController screenController;

    private double xOffset = 0;
    private double yOffset = 0;

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../views/Login.fxml"));

        Scene scene = new Scene(root,1049, 594);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login");
        primaryStage.initStyle(StageStyle.TRANSPARENT);
        scene.setFill(Color.TRANSPARENT);
        root.setOnMousePressed((MouseEvent event) -> {
            xOffset = event.getSceneX();
            yOffset = event.getSceneY();
        });

        // Move around here
        root.setOnMouseDragged((MouseEvent event) -> {
            primaryStage.setX(event.getScreenX() - xOffset);
            primaryStage.setY(event.getScreenY() - yOffset);
        });

        primaryStage.show();
        screenController = new ScreenController(scene);
        screenController.addScreen("login",root);
        screenController.addScreen("SignUp",FXMLLoader.load(getClass().getResource("../views/signUp/Step_1.fxml")));
        screenController.addScreen("2", FXMLLoader.load(getClass().getResource("../views/signUp/Step_2.fxml")));
        screenController.addScreen("3", FXMLLoader.load(getClass().getResource("../views/signUp/Step_3.fxml")));
    }


    public static void changeToScene(String sceneName) {
        screenController.activate(sceneName);
    }
    public static void removeScreen(String name) {
        screenController.removeScreen(name);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
