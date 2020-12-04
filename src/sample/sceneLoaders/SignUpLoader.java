package sample.sceneLoaders;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class SignUpLoader extends Application {
    private double xOffset = 0;
    private double yOffset = 0;

    public void start() throws Exception {

            Stage  SignUpstage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../views/SignUp.fxml"));
            Scene scene = new Scene(root,1049, 594);
            SignUpstage.setScene(scene);
            SignUpstage.setTitle("Login");
            SignUpstage.initStyle(StageStyle.TRANSPARENT);
            scene.setFill(Color.TRANSPARENT);
            root.setOnMousePressed((MouseEvent event) -> {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            });

            // Move around here
            root.setOnMouseDragged((MouseEvent event) -> {
                SignUpstage.setX(event.getScreenX() - xOffset);
                SignUpstage.setY(event.getScreenY() - yOffset);
            });

            SignUpstage.show();
        }

    @Override
    public void start(Stage stage) throws Exception {

    }
}




