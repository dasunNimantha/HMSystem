package sample.controllers.signUpController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDatePicker;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import sample.controllers.Main;
import sample.models.User;

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
    private JFXTextField userNameText;


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
            newUser.setUserName(userNameText.getText());
            Main.changeToScene("2");
        });

        backToLogin.setOnAction(event -> {
                Main.changeToScene("login");
        });


    }

}
