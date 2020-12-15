//package sample.controllers.signUpController;
//
//import com.jfoenix.controls.*;
//import javafx.fxml.FXML;
//import javafx.scene.control.ToggleGroup;
//import sample.Main;
//import sample.models.User;
//
//public class Step1Controller {
//
//    @FXML
//    private JFXButton backToLogin;
//
//    @FXML
//    private JFXButton btnNext1;
//
//    @FXML
//    private JFXTextField firstNameText;
//
//    @FXML
//    private JFXTextField lastNameText;
//
//    @FXML
//    private JFXTextField idNoText;
//
//    @FXML
//    private JFXDatePicker datePicker;
//
//    @FXML
//    private JFXTextField userNameText;
//
//    @FXML
//    private JFXRadioButton maleRadio;
//
//    @FXML
//    private ToggleGroup gender;
//
//    @FXML
//    private JFXRadioButton femaleRadio;
//
//    @FXML
//    private ToggleGroup maritalStatus;
//
//    @FXML
//    private JFXRadioButton marriedRadio;
//
//    @FXML
//    private JFXRadioButton unmarriedRadio;
//
//    @FXML
//    private JFXComboBox<String> roleCombo;
//
//     User newUser = new User();
//    public static String userRole;
//
//    @FXML
//    public void initialize() {
//
////      roleCombo.getItems().addAll("Patient","Receptionist","Medical Officer","Admin");
////      roleCombo.getSelectionModel().selectFirst();
////
//        btnNext1.setOnAction(e -> {
//            newUser.setName(firstNameText.getText() +" "+ lastNameText.getText());
//            newUser.setIdNumber(Integer.parseInt(idNoText.getText()));
//            newUser.setPassword(Integer.parseInt(idNoText.getText()));
//            newUser.setDob(datePicker.getValue());
//            newUser.setUserName(userNameText.getText());
//
//            if(maleRadio.isSelected()){
//                newUser.setGender("Male");
//            } else if (femaleRadio.isSelected()){
//                newUser.setGender("Female");
//            }
//
//            if(marriedRadio.isSelected()){
//                newUser.setMaritalStatus("Married");
//            } else if (unmarriedRadio.isSelected()){
//                newUser.setMaritalStatus("Unmarried");
//            }
//
//            if(roleCombo.getValue().equals("Patient")){
//                Main.changeToScene("3");
//                userRole="Patient";
//            } else {
//                Main.changeToScene("2");
//                userRole="Other";
//            }
//
//        });
//
//        backToLogin.setOnAction(event -> {
//            Main.changeToScene("login");
//        });
//
//
//    }
//
//}
