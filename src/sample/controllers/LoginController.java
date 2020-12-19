
package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import sample.Main;
import sample.models.UserValidation;


public class LoginController implements Initializable {


    static String userRole;

    @FXML
    private JFXTextField usrNameField;

    @FXML
    private JFXPasswordField passwdField;

    @FXML
    private AnchorPane credAnchor;


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
    private BorderPane borderPaneLogin;

    @FXML
    private JFXButton userBtnRole;

    @FXML
    private void closeWindow(MouseEvent event) {
        btnEX.getScene().getWindow().hide();
        System.exit(0);
    }



    @FXML
    void roleSelect(ActionEvent event) throws IOException {
        Parent root2 = FXMLLoader.load(getClass().getResource("../views/LoginCredEnter.fxml"));
        borderPaneLogin.setCenter(root2);
        final Node source = (Node) event.getSource();
        userRole = source.getId();
    }

    @FXML
    void backToRoleSelect(MouseEvent event) {
     //  BorderPane tempBorderPane = (BorderPane) credAnchor.getParent().getParent();
     //  tempBorderPane.setCenter(Main.loginMap.get("roleSelect"));
        System.out.println(credAnchor.getParent());
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }

    @FXML
    void sendAuth(ActionEvent event) {
        userAuth();
    }

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
                if ((   username.length()==0
                        &&(password.length()==0))){
                    System.out.println("Invalid Input");
                } else {
                    UserValidation ua = new UserValidation();
                    try {
                        int statusCode = ua.authCheck(userRole,username, password);
                        if(statusCode==1){
                            System.out.println("Logged In");
                            loginBtn.getScene().getWindow().hide();
                            SceneLoader sl = new SceneLoader();
                            sl.DashboardLoader(userRole);

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



