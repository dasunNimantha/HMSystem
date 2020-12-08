package sample.controllers.SignUpController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import sample.controllers.SceneLoader;

public class Step1Controller {

    @FXML
    private JFXButton backToLogin;

    @FXML
    private JFXButton btnNext1;

    @FXML
    private BorderPane signUpBorderPane;

    @FXML
    private JFXTextField firstNameText;

    @FXML
    private JFXTextField lastNameText;

    @FXML
    private JFXTextField idNoText;

    @FXML
    private JFXDatePicker dob;

    @FXML
    private JFXRadioButton radioMale;

    @FXML
    private ToggleGroup genderGrp;

    @FXML
    private JFXRadioButton radioFemale;

    @FXML
    void backToLogin(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        btnNext1.setOnAction(e -> {
            SceneLoader.changeToScene("2");



        });

        backToLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SceneLoader.changeToScene("login");
            }
        });


    }

}
