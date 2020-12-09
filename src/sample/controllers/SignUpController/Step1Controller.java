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
import sample.controllers.Main;
import sample.controllers.SceneLoader;
import sample.models.User;

import java.util.ArrayList;

public class Step1Controller {

    @FXML
    private JFXButton backToLogin;

    @FXML
    private JFXButton btnNext1;

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
    private JFXRadioButton radioFemale;

    @FXML
    void backToLogin(ActionEvent event) {

    }

    static User newUser = new User();

    @FXML
    public void initialize() {
        btnNext1.setOnAction(e -> {
            newUser.setName(firstNameText.getText() +" "+ lastNameText.getText());
            newUser.setIdNumber(Integer.parseInt(idNoText.getText()));
            newUser.setPassword(Integer.parseInt(idNoText.getText()));
            newUser.setDob(dob.getValue());
            if (radioMale.isSelected()) {
                newUser.setGender("Male");
            } else if (radioFemale.isSelected()) {
                newUser.setGender("Female");
            }
            Main.changeToScene("2");
        });

        backToLogin.setOnAction(event -> {
                Main.changeToScene("login");
        });


    }

}
