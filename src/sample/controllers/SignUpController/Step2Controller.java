package sample.controllers.SignUpController;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXRadioButton;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.AnchorPane;
import sample.controllers.Main;
import sample.controllers.SceneLoader;

public class Step2Controller extends Step1Controller {

    @FXML
    private AnchorPane anchor2;

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
    private JFXRadioButton unmrriedRadioBtn;

    @FXML
    private Label phoneNoLbl;

    @FXML
    private JFXTextField phoneNoText;

    @FXML
    private JFXButton backToLogin;

    @FXML
    private JFXButton btnNext2;

    @FXML
    private JFXButton btnPrev1;

    @FXML
    void backToLogin(ActionEvent event) {

    }

    @FXML
    void nextStep(ActionEvent event) {

    }

    @FXML
    void prevStep1(ActionEvent event) {

    }

    @FXML
    public void initialize() {
        btnNext2.setOnAction(e -> {
            newUser.setAddress(addrFirstText.getText() +
                    "\n" + addrSecondText.getText() +
                    "\n" + addrCityText.getText());

            if (marriedRadioBtn.isSelected()) {
                newUser.setGender("Married");
            } else if (unmrriedRadioBtn.isSelected()) {
                newUser.setGender("Unmarried");
            }
            newUser.setPhoneNumber(Integer.parseInt(phoneNoText.getText()));
            System.out.println(newUser.toString());
            Main.changeToScene("3");


        });

        btnPrev1.setOnAction(e ->{
            Main.changeToScene("SignUp");
        });

        backToLogin.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Main.changeToScene("login");
            }
        });

    }

}
