package sample.controllers.SignUpController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.fxml.FXML;
import sample.controllers.Main;


public class Step2Controller extends Step1Controller {

    @FXML
    private JFXTextField addrFirstText;

    @FXML
    private JFXTextField addrSecondText;

    @FXML
    private JFXTextField addrCityText;

    @FXML
    private JFXRadioButton marriedRadioBtn;

    @FXML
    private JFXRadioButton unmarriedRadioBtn;

    @FXML
    private JFXTextField phoneNoText;

    @FXML
    private JFXButton backToLogin;

    @FXML
    private JFXButton btnNext2;

    @FXML
    private JFXButton btnPrev1;

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
            newUser.setPhoneNumber(Integer.parseInt(phoneNoText.getText()));
            Main.changeToScene("3");


        });

        btnPrev1.setOnAction(e ->{
            Main.changeToScene("SignUp");
        });

        backToLogin.setOnAction(e -> {
                Main.changeToScene("login");
        });

    }

}
