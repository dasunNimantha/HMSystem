
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

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;
import sample.controllers.dashboardController.AdminDash.AdminController;
import sample.controllers.dashboardController.MODash.MOController;
import sample.controllers.dashboardController.PatientDash.PatientController;
import sample.controllers.dashboardController.ReceptionistDash.ReceptionistController;
import sample.models.Crypto;
import sample.models.User;
import sample.models.UserTasks;
import sample.models.UserValidation;


public class LoginController  extends Thread {


    static String userRole;

    @FXML
    private JFXTextField usrNameField;

    @FXML
    private JFXPasswordField passwdField;

    @FXML
    private BorderPane borderPaneLogin;


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
        BorderPane mainBorderPane = (BorderPane) btnEX.getParent().getParent();
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
                Boolean authCheck = UserValidation.authCheck(userRole, username, password);
                if (authCheck) {
                    Stage stage = (Stage) loginBtn.getScene().getWindow();
                    stage.close();
                    SceneLoader sl = new SceneLoader();

                    ArrayList<User> loggedUserObj= UserTasks.viewUser(false,userRole,userRole,username);

                    switch (userRole){
                        case "Patient":
                            PatientController.loggedUserProfile=loggedUserObj.get(0);
                            break;
                        case "Receptionist":
                            ReceptionistController.loggedUserProfile=loggedUserObj.get(0);
                            break;
                        case "Medical_Officer":
                            MOController.loggedUserProfile=loggedUserObj.get(0);

                    }

                    //MOController.loggedUserProfile = returnData.get(1);
                   // ReceptionistController.loggedUserProfile = returnData.get(1);

                    sl.DashboardLoader(userRole);
                    saveLogData(LocalDate.now(),LocalTime.now(),username,userRole);

                } else {
                    System.out.println("Invalid Username or Password");
                    invalidLabel.setVisible(true);
                }
            } catch (IOException exception) {
                exception.printStackTrace();
            }

        }
    }


    public void saveLogData(LocalDate loggedDate, LocalTime loggedTime,String username,String userRole) throws IOException {
        File logData = new File("src/sample/fileDatabase/logFiles/loginData.txt");
        if(!logData.exists()){
            if(logData.createNewFile()){
                System.out.println("New login log created");
            }
        }

        FileWriter fw = new FileWriter(logData,true);
        BufferedWriter bw = new BufferedWriter(fw);

        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("hh:mm:ss a");
        String encText= Crypto.encrypt(loggedDate.toString()+","+loggedTime.format(dtf)+","+username+","+userRole);
        if(logData.length()==0){
            assert encText != null;
            bw.write(encText);
        } else{
            bw.write("\n"+encText);
        }

        bw.close();
        fw.close();
    }

}





