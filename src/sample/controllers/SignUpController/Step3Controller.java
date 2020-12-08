package sample.controllers.SignUpController;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.layout.AnchorPane;
import sample.controllers.Main;


public class Step3Controller extends Step1Controller{

    @FXML
    private AnchorPane anchor2;

    @FXML
    private JFXButton backToLogin;

    @FXML
    private JFXButton btnFinish;

    @FXML
    private JFXButton btnPrev2;

    public void initialize(){
        btnPrev2.setOnAction(e ->{
            Main.changeToScene("2");
        });

        backToLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.changeToScene("login");
            }
        });
    }

}
