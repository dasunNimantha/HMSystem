package sample.controllers.DashboardController;

import com.jfoenix.controls.JFXButton;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;

public class DashboardController {

    @FXML
    private JFXButton btn1;

    @FXML
    void mouseClicked(MouseEvent event) {
        System.out.println("Clicked");
        btn1.setStyle("-fx-background-color: orange");
    }

}
