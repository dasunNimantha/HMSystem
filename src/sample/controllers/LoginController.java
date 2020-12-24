
package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicReference;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import sample.Main;
import sample.controllers.dashboardController.AdminDash.AdminController;
import sample.controllers.dashboardController.MODash.MOController;
import sample.controllers.dashboardController.PatientDash.PatientController;
import sample.controllers.dashboardController.ReceptionistDash.ReceptionistController;
import sample.models.UserValidation;


public class LoginController  extends Thread {


    static String userRole;

    @FXML
    private JFXTextField usrNameField;

    @FXML
    private JFXPasswordField passwdField;

    @FXML
    private Button backBtn;


    @FXML
    private Label lblName;


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
    private JFXTextField hidenText;

    @FXML
    private static AnchorPane mainAnchor;

    @FXML
    private JFXButton userBtnRole;

    @FXML
    private void closeWindow(MouseEvent event) {
        btnEX.getScene().getWindow().hide();
        System.exit(0);
    }


    @FXML
    void roleSelect(ActionEvent event) throws IOException {


        AnchorPane root2 = FXMLLoader.load(this.getClass().getResource("../views/LoginCredEnter.fxml"));
        BorderPane mainBorderPane = (BorderPane) hidenText.getParent().getParent();
        mainBorderPane.setCenter(root2);
        final Node source = (Node) event.getSource();
        userRole = source.getId();

    }

    @FXML
    void backToRoleSelect(MouseEvent event) throws IOException {
        BorderPane borderPaneLogin = (BorderPane) backBtn.getParent().getParent();
        AnchorPane root2 = FXMLLoader.load(this.getClass().getResource("../views/LoginSelect.fxml"));
        borderPaneLogin.setCenter(root2);



    }


    public void initialize(URL url, ResourceBundle rb) {

//        Font.loadFont(getClass().getResourceAsStream("../assets/fonts/Quicksand.ttf"),14);
//        lblName.setFont(Font.font("Quicksand", FontWeight.BOLD, FontPosture.REGULAR,20));
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


    private void userAuth()  {

        String username = usrNameField.getText().trim();
        String password = passwdField.getText().trim();
        if ((username.length() == 0
                && (password.length() == 0))) {
            System.out.println("Invalid Input");
        } else {
            try {
                ArrayList <String> returnData = UserValidation.authCheck(userRole, username, password);
                if ((returnData.get(0)).equals("1")) {

                    Stage stage = (Stage) loginBtn.getScene().getWindow();
                    stage.close();
                    SceneLoader sl = new SceneLoader();
                    PatientController.loggedUserProfile=returnData.get(1);
                    sl.DashboardLoader(userRole);


                } else {
                    System.out.println("Invalid Username or Password");
                    invalidLabel.setVisible(true);
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        }
    }

}





