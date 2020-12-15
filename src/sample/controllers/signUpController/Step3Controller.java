//package sample.controllers.signUpController;
//
//import com.jfoenix.controls.*;
//import javafx.fxml.FXML;
//import javafx.scene.control.ToggleGroup;
//import javafx.scene.layout.BorderPane;
//import sample.Main;
//
//public class Step3Controller extends Step1Controller {
//
//    @FXML
//    private BorderPane signUpBorderPane;
//
//    @FXML
//    private JFXTextField addrFirstText;
//
//    @FXML
//    private JFXTextField addrSecondText;
//
//    @FXML
//    private JFXTextField addrCityText;
//
//    @FXML
//    private JFXRadioButton marriedRadioBtn;
//
//    @FXML
//    private ToggleGroup maritalStatus;
//
//    @FXML
//    private JFXRadioButton unmrriedRadioBtn;
//
//    @FXML
//    private JFXComboBox<String> bloodGroupCombo;
//
//    @FXML
//    private JFXTextArea allergiesText;
//
//    @FXML
//    private JFXTextField phoneNoText;
//
//    @FXML
//    private JFXRadioButton radioMale;
//
//    @FXML
//    private ToggleGroup genderGrp;
//
//    @FXML
//    private JFXRadioButton radioFemale;
//
//    @FXML
//    private JFXButton backToLogin;
//
//    @FXML
//    private JFXButton btnNext2;
//    @FXML
//    private JFXButton btnPrevFirst;
//
//    @FXML
//    public void initialize() {
//
//        bloodGroupCombo.getItems().addAll("A+","A-","B+","B-","O+","O-","AB+","AB-");
//        bloodGroupCombo.getSelectionModel().selectFirst();
//
//        btnNext2.setOnAction(e -> {
//            newUser.setAddress(addrFirstText.getText() +
//                    "," + addrSecondText.getText() +
//                    "," + addrCityText.getText());
//
//
//            newUser.setPhoneNumber(Integer.parseInt(phoneNoText.getText()));
//            Main.changeToScene("3");
//
//
//        });
//
//        btnPrevFirst.setOnAction(e ->{
//            if(Step1Controller.userRole.equals("Patient")){
//                Main.changeToScene("SignUp");
//            } else if (Step1Controller.userRole.equals("Other")){
//                Main.changeToScene("3");
//            }
//
//        });
//
//        backToLogin.setOnAction(e -> {
//            Main.changeToScene("login");
//        });
//
//    }
//
//}
