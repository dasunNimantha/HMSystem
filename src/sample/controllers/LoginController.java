
package sample.controllers;
import javafx.scene.control.Hyperlink;
import sample.sceneLoaders.SignUpLoader;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;


public class LoginController implements Initializable {

    @FXML
    private Label lblToday;

    @FXML
    private Label lblUpcoming;

    @FXML
    private VBox vTaskItems;

    @FXML
    private Hyperlink signUpLink;

    @FXML
    private Button btnEX;

    @FXML
    private void closeWindow(MouseEvent event) {
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void closBtnColour(MouseEvent event) {
        btnEX.setStyle("-fx-background-color: red");
    }


    @FXML
    void resetExBtn(MouseEvent event) {
        btnEX.setStyle("-fx-background-color: grey");
    }

    @FXML
    void loadSignUp(ActionEvent event) throws Exception {
        signUpLink.getScene().getWindow().hide();
        SignUpLoader sup = new SignUpLoader();
        sup.start();

    }

}
