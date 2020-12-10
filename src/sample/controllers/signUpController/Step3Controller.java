package sample.controllers.signUpController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXSpinner;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import sample.controllers.Main;
import java.io.*;
import javafx.scene.image.Image;


import java.io.File;
import java.util.Timer;
import java.util.TimerTask;


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
    private JFXSpinner profileSpinner;

    @FXML
    private ImageView imageIcon;

    @FXML
    private Circle imageCircle;

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
            String imageDest = "src/sample/database/profileImages/"+newUser.getIdNumber()+".jpg";
            try {

                //calling file copy function

                copyFile(proPicFile,imageDest);
                Image image = new Image("/sample/database/profileImages/"+newUser.getIdNumber()+".jpg",false);

                browseButton.setText("Change profile picture");


            } catch (IOException ioException) {
                ioException.printStackTrace();
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

    private static void copyFile(File source, String dest) throws IOException {
        try (InputStream is = new FileInputStream(source); OutputStream os = new FileOutputStream(dest)) {
            byte[] buffer = new byte[1024];
            int length;
            while ((length = is.read(buffer)) > 0) {
                os.write(buffer, 0, length);
                }
             }
        }

}
