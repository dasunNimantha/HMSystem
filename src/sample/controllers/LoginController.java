
package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import sample.models.UserAccess;


public class LoginController implements Initializable {

    @FXML
    private Label lblToday;

    @FXML
    private Label lblUpcoming;

    @FXML
    private VBox vTaskItems;

    @FXML
    private JFXTextField usrNameField;

    @FXML
    private JFXPasswordField passwdField;

    @FXML
    private JFXComboBox<?> userRole;

    @FXML
    private JFXButton loginBtn;

    @FXML
    private Button btnEX;

    @FXML
    private void closeWindow(MouseEvent event) {
        btnEX.getScene().getWindow().hide();
        System.exit(0);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        loadSignUp.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                SceneLoader sl = new SceneLoader();
                sl.signUpLoader();
                loadSignUp.getScene().getWindow().hide();
            }
        });

        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                userAuth();
            }
        });
    }

    @FXML
    private Hyperlink loadSignUp;


    @FXML
    void closBtnColour(MouseEvent event) {
        btnEX.setStyle("-fx-background-color: red");
    }


    @FXML
    void resetExBtn(MouseEvent event) {
        btnEX.setStyle("-fx-background-color: grey");
    }

    private void userAuth(){
                String username = usrNameField.getText();
                String password = passwdField.getText();
                if ((username.equals("") &&(password.equals("")))){
                    System.out.println("Invalid Input");
                } else {
                    UserAccess ua = new UserAccess();
                    try {
                        int statusCode = ua.authCheck(username, password);
                        if(statusCode==1){
                            System.out.println("Logged In");
                            SceneLoader sl = new SceneLoader();
                            sl.pDashboardLoader();
                            loginBtn.getScene().getWindow().hide();
                        } else {
                            System.out.println("Invalid Username or Password");
                        }
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

        };
    }



