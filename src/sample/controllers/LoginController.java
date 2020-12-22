
package sample.controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.ResourceBundle;

import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.controllers.dashboardController.AdminDash.AdminController;
import sample.controllers.dashboardController.MODash.MOController;
import sample.controllers.dashboardController.PatientDash.PatientController;
import sample.controllers.dashboardController.ReceptionistDash.ReceptionistController;
import sample.models.Admin;
import sample.models.MedicalOfficer;
import sample.models.UserValidation;


public class LoginController  extends Thread {


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
        Parent root2 = FXMLLoader.load(getClass().getResource("../views/LoginCredEnter.fxml"));
        borderPaneLogin.setCenter(root2);
        final Node source = (Node) event.getSource();
        userRole = source.getId();
    }

    @FXML
    void backToRoleSelect(MouseEvent event) throws IOException {
        Parent root3 = FXMLLoader.load(getClass().getResource("../views/LoginRoleSelect.fxml"));
        System.out.println(credAnchor.getParent());

    }


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


        private void userAuth()  {

            String username = usrNameField.getText().trim();
            String password = passwdField.getText().trim();
            if ((username.length() == 0
                    && (password.length() == 0))) {
                System.out.println("Invalid Input");
            } else {
                try {
                    String[] returnData = UserValidation.authCheck(userRole, username, password);
                    if (returnData[0].equals("1")) {

                        Stage stage = (Stage) loginBtn.getScene().getWindow();
                        stage.close();
                        SceneLoader sl = new SceneLoader();

                        switch (userRole) {
                            case "Patient" -> PatientController.objEncString = returnData[1];
                            case "Receptionist" -> ReceptionistController.objEncString = returnData[1];
                            case "Medical_Officer" -> MOController.objEncString = returnData[1];
                            case "Admin" -> AdminController.objEncString = returnData[1];
                        }

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





