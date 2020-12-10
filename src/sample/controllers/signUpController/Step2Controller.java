package sample.controllers.signUpController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.BorderPane;
import sample.models.User;
import sample.controllers.Main;

public class Step2Controller extends Step1Controller {

    @FXML
    private BorderPane signUpBorderPane;

    @FXML
    private JFXTextField addrFirstText;

    @FXML
    private JFXTextField addrSecondText;

    @FXML
    private JFXTextField addrCityText;

    @FXML
    private JFXRadioButton marriedRadioBtn;

    @FXML
    private ToggleGroup maritalStatus;

    @FXML
    private JFXRadioButton unmarriedRadioBtn;

    @FXML
    private JFXTextField phoneNoText;

    @FXML
    private JFXRadioButton radioMale;

    @FXML
    private ToggleGroup genderGrp;

    @FXML
    private JFXRadioButton radioFemale;

    @FXML
    private JFXButton backToLogin;

    @FXML
    private JFXButton btnNext2;

    @FXML
    private JFXButton btnPrevFirst;

    @FXML
    public void initialize() {
        btnNext2.setOnAction(e -> {
            newUser.setAddress(addrFirstText.getText() +
                    "\n" + addrSecondText.getText() +
                    "\n" + addrCityText.getText());

            if (marriedRadioBtn.isSelected()) {
                newUser.setGender("Married");
            } else if (unmarriedRadioBtn.isSelected()) {
                newUser.setGender("Unmarried");
            }
            if (radioMale.isSelected()) {
                newUser.setGender("Male");
            } else if (radioFemale.isSelected()) {
                newUser.setGender("Female");
            }

            newUser.setPhoneNumber(Integer.parseInt(phoneNoText.getText()));
            Main.changeToScene("3");


        });

        btnPrevFirst.setOnAction(e ->{
            Main.changeToScene("SignUp");
        });

        backToLogin.setOnAction(e -> {
                Main.changeToScene("login");
        });

    }

}
