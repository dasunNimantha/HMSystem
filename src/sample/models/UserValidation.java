package sample.models;

import javafx.scene.control.Alert;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;


public class UserValidation {

    // *************************** User Authentication Function  ************************** //


    public static Boolean authCheck(String role, String username, String password) throws IOException {
        boolean authenticated = false;
        try {
            FileReader fr2 = new FileReader("src/sample/fileDatabase/" + role + "DB.txt");
            BufferedReader br2 = new BufferedReader(fr2);
            String currentLine;
            while ((currentLine = br2.readLine()) != null) {
                String decryptedText = Crypto.decrypt(currentLine);
                assert decryptedText != null;
                String[] userData = decryptedText.split("~");
                if ((userData[0].equals(username) && (userData[1]).equals(password))) {
                    authenticated = true;
                    break;
                }
            }
            br2.close();
            fr2.close();

        } catch (Exception exception){
            exception.printStackTrace();
        }
        return authenticated;
    }
    // *************************** User Registration Function ************************ //
}


