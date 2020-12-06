package sample.controllers;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.TextFormatter;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class SignUpController implements Initializable {

    public JFXButton btnPrevious1;
    @FXML
    private JFXButton exitBtn;

    @FXML
    private JFXButton backToLogin;

    @FXML
    private JFXButton btnNext1;

    @FXML
    private JFXTextField fullName;

    @FXML
    private AnchorPane step1Anchor;

    @FXML
    void toUppercase(KeyEvent event) {
        fullName.textProperty().addListener((ov, oldValue, newValue) -> {
            fullName.setText(newValue.toUpperCase());
        });
    }


    @FXML
    private BorderPane signUpBorderPane;

    @FXML
    void nextStep(ActionEvent event) throws IOException {

        switch (btnNext1.getId()) {
            case "btnNext1" -> {
                Parent step2 = FXMLLoader.load(getClass().getResource("../views/SignUp/Step_2.fxml"));
                signUpBorderPane.setCenter(step2);
                btnPrevious1.setVisible(true);
                btnNext1.setId("btnNext2");
                btnPrevious1.setId("btnPrevious2");
            }
            case "btnNext2" -> {
                Parent step3 = FXMLLoader.load(getClass().getResource("../views/SignUp/Step_3.fxml"));
                signUpBorderPane.setCenter(step3);
                btnPrevious1.setVisible(true);
                btnNext1.setId("btnNext3");
                btnPrevious1.setId("btnPrevious3");
            }
        }
    }

    @FXML
    void backPrevStep(ActionEvent event) throws IOException {
        switch (btnPrevious1.getId()) {
            case "btnPrevious2" -> {
                signUpBorderPane.setCenter(null);
                btnPrevious1.setVisible(false);
                btnNext1.setId("btnNext1");
                btnPrevious1.setId("btnPrevious1");
            }
            case "btnPrevious3" -> {
                Parent step2 = FXMLLoader.load(getClass().getResource("../views/SignUp/Step_2.fxml"));
                signUpBorderPane.setCenter(step2);
                btnPrevious1.setVisible(true);
                btnNext1.setId("btnNext2");
                btnPrevious1.setId("btnPrevious2");
            }
        }
    }

    @FXML
    void ExitsignUp(ActionEvent event) {
            exitBtn.getScene().getWindow().hide();
            System.exit(0);
    }

    @FXML
    void backToLogin(ActionEvent event) {
        backToLogin.getScene().getWindow().hide();
        SceneLoader sl = new SceneLoader();
        sl.loginLoader();

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }


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