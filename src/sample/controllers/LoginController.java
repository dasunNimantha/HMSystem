
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
import javafx.scene.control.ToggleGroup;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import sample.Main;
import sample.models.UserAccess;


public class LoginController implements Initializable {

    @FXML

    private Label lblToday;

    @FXML
    private Label lblUpcoming;

    @FXML

    private VBox vTaskItems;

    @FXML

    private ToggleGroup gender;

    @FXML
    private JFXTextField usrNameField;

    @FXML
    private JFXPasswordField passwdField;

    @FXML
    private JFXComboBox<String> userRole;

    @FXML
    void hideInvalidLabelPaswd(KeyEvent event) {
        invalidLabel.setVisible(false);
    }

    @FXML
    void hideInvalidLabelUsername(KeyEvent event) {
        invalidLabel.setVisible(false);
    }

    @FXML
    private JFXButton loginBtn;

    @FXML
    private Label invalidLabel;

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

                Main.changeToScene("SignUp");
            }

        });

        loginBtn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                userAuth();
            }
        });

        userRole.getItems().add("Patient");
        userRole.getItems().add("Receptionist");
        userRole.getItems().add("Medical Officer");
        userRole.getItems().add("Admin");
        userRole.getSelectionModel().selectFirst();

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
                String role = userRole.getValue();

                String username = usrNameField.getText();
                String password = passwdField.getText();
                if ((   username.length()==0
                        &&(password.length()==0))){
                    System.out.println("Invalid Input");
                } else {
                    UserAccess ua = new UserAccess();
                    try {
                        int statusCode = ua.authCheck(role,username, password);
                        if(statusCode==1){
                            System.out.println("Logged In");
                            loginBtn.getScene().getWindow().hide();
                            SceneLoader sl = new SceneLoader();
                            sl.DashboardLoader(role);

                        } else if (statusCode==0) {
                            System.out.println("Invalid Username or Password");
                            invalidLabel.setVisible(true);
                        }
                    } catch (IOException exception) {
                        exception.printStackTrace();
                    }
                }

        };
    }



