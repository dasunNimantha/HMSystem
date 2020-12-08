package sample.controllers.SignUpController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import sample.controllers.Main;

import java.io.File;


public class Step3Controller extends Step1Controller{

    @FXML
    private AnchorPane anchor2;

    @FXML
    private JFXButton backToLogin;

    @FXML
    private JFXButton btnFinish;

    @FXML
    private JFXButton btnPrev2;

    @FXML
    private JFXTextField userNameText;

    @FXML
    private JFXButton browseButton;


    @FXML
    private ImageView imageIcon;

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

        browseButton.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                FileChooser fc = new FileChooser();
                    fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("PNG Files","*.png"),
                            new FileChooser.ExtensionFilter("JPG Files","*.jpg"),
                            new FileChooser.ExtensionFilter("JPEG Files","*.jpeg"));
                File f = fc.showOpenDialog(null);

            }
        });

        btnFinish.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.removeScreen("2");
                Main.removeScreen("3");
                anchor2.setDisable(true);
                userNameText.setDisable(true);
                browseButton.setDisable(true);
                imageIcon.setDisable(true);

            }
        });
    }

}
