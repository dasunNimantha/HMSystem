package sample.controllers.signUpController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import sample.controllers.Main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;


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

        backToLogin.setOnAction(e ->{
                Main.changeToScene("login");
        });

        browseButton.setOnAction(e ->  {
                FileChooser fc = new FileChooser();
                    fc.getExtensionFilters().addAll(new FileChooser.ExtensionFilter("JPG Files","*.jpg"),
                            new FileChooser.ExtensionFilter("JPEG Files","*.jpeg"),
                            new FileChooser.ExtensionFilter("PNG Files","*.png"));
                File proPicFile = fc.showOpenDialog(null);
                try {
                    FileInputStream fis = new FileInputStream(proPicFile);

                } catch (FileNotFoundException exception) {
                    System.out.println("File Not Found");
                }
        });

        btnFinish.setOnAction(e -> {
                Main.removeScreen("2");
                Main.removeScreen("3");
                anchor2.setDisable(true);
                userNameText.setDisable(true);
                browseButton.setDisable(true);
                imageIcon.setDisable(true);
        });
    }

}
