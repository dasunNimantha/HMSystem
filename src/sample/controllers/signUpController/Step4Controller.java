//package sample.controllers.signUpController;
//
//import com.jfoenix.controls.JFXButton;
//import com.jfoenix.controls.JFXSpinner;
//import javafx.fxml.FXML;
//import javafx.scene.image.ImageView;
//import javafx.scene.shape.Circle;
//import javafx.stage.FileChooser;
//import sample.Main;
//import java.io.*;
//
//
//import java.io.File;
//
//
//public class Step4Controller extends Step1Controller{
//
//    @FXML
//    private JFXButton backToLogin;
//
//    @FXML
//    private JFXButton btnFinish;
//
//    @FXML
//    private JFXButton btnPrev2;
//
//    @FXML
//    private JFXButton browseButton;
//
//    @FXML
//    private JFXSpinner profileSpinner;
//
//    @FXML
//    private ImageView imageIcon;
//
//    @FXML
//    private Circle imageCircle;
//
//    public void initialize(){
//        btnPrev2.setOnAction(e ->{
//            Main.changeToScene("2");
//        });
//
//        backToLogin.setOnAction(e ->{
//            Main.changeToScene("login");
//        });
//
//        browseButton.setOnAction(e ->  {
//            FileChooser fc = new FileChooser();
//
//            FileChooser.ExtensionFilter fileExtensions =
//                    new FileChooser.ExtensionFilter("Image Files", "*.jpg", "*.jpeg");
//            fc.getExtensionFilters().add(fileExtensions);
//            File proPicFile = fc.showOpenDialog(null);
//            String imageDest = "src/sample/database/profileImages/"+newUser.getIdNumber()+".jpg";
//            try {
//                //calling file copy function
//                copyFile(proPicFile,imageDest);
//                newUser.setProfilePicture(imageDest);
//                browseButton.setText("Change profile picture");
//
//            } catch (IOException ioException) {
//                ioException.printStackTrace();
//            }
//
//        });
//
//        btnFinish.setOnAction(e -> {
//
//         //   newUser.newSignUpWrite(newUser.toString(),);
//            Main.removeScreen("SignUp");
//            Main.removeScreen("2");
//            Main.removeScreen("3");
//            browseButton.setDisable(true);
//            imageIcon.setDisable(true);
//        });
//    }
//
//    private static void copyFile(File source, String dest) throws IOException {
//        try (InputStream is = new FileInputStream(source); OutputStream os = new FileOutputStream(dest)) {
//            byte[] buffer = new byte[1024];
//            int length;
//            while ((length = is.read(buffer)) > 0) {
//                os.write(buffer, 0, length);
//            }
//        }
//    }
//
//}
