package sample.controllers;
import sample.models.Crypto;

import com.jfoenix.controls.JFXButton;
import com.sun.glass.ui.CommonDialogs;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.stage.FileChooser;

import java.io.File;
import java.util.List;

public class SignUpController {

    public JFXButton btnPrevious1;
    @FXML
    private JFXButton exitBtn;

    @FXML
    private JFXButton backToLogin;

    @FXML
    void ExitsignUp(ActionEvent event) {
            exitBtn.getScene().getWindow().hide();
            System.exit(0);
    }

    @FXML
    void backToLogin(ActionEvent event) {
        SceneLoader sl = new SceneLoader();
        sl.loginLoader();
        backToLogin.getScene().getWindow().hide();
    }
    public void initialize(){



//        fileChooserBtn.setOnAction(new EventHandler<ActionEvent>() {
//            @Override
//            public void handle(ActionEvent actionEvent) {
////                FileChooser fc = new FileChooser();
////                fc.getExtensionFilters().add(
////                        new FileChooser.ExtensionFilter("Image Files", "*.jpg","*.jpeg"));
////                File f = fc.showOpenDialog(null);
//                String test = Crypto.encrypt("Dasun");
//                System.out.println(test);
//
//            }
//        });
    }

}