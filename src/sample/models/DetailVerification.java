package sample.models;
import javafx.scene.control.TextField;


public class DetailVerification {

    public static boolean validName(TextField txt){
        return txt.getText().trim().matches("^[a-zA-Z\\s]*$") && (!txt.getText().trim().isEmpty());
    }

    public static boolean validateUserName (TextField txt){
        return txt.getText().trim().matches("^[a-zA-Z0-9]{4,10}$") && (!txt.getText().trim().isEmpty());
    }
    public static boolean validEmail(TextField txt) {
        return txt.getText().matches("^(.+)@(.+)$")
                || (txt.getText().isEmpty());
    }

    public static boolean validateNIC(TextField txt) {
        return txt.getText().matches("^(\\d{9}|\\d{12})") && (!txt.getText().trim().isEmpty());
    }

    public static boolean validatePhoneNo(TextField txt) {
        return txt.getText().matches("^(\\d{10})[0-9]+") && (!txt.getText().trim().isEmpty());
    }

    public static boolean validateStaffId(TextField txt) {
        return txt.getText().matches("^(\\d{5})[0-9]+") && (!txt.getText().trim().isEmpty());
    }
}
