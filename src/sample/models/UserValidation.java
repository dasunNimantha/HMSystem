package sample.models;

import javafx.scene.control.Alert;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Objects;


public class UserValidation {

    // *************************** User Authentication Function  ************************** //


    public static String[] authCheck(String role,String username, String password) throws IOException {
        String[] returnData = new String[2];
        try {
            FileReader fr2 = new FileReader("src/sample/fileDatabase/" + role + "DB.txt");
            BufferedReader br2 = new BufferedReader(fr2);
            String currentLine;
            while ((currentLine = br2.readLine()) != null) {
                String decryptedText = Crypto.decrypt(currentLine);
                assert decryptedText != null;
                String[] userData = decryptedText.split("~");
                if ((userData[0].equals(username) && (userData[1]).equals(password))) {
                    returnData[0] = "1";
                    returnData[1] = decryptedText;

                } else {
                    returnData[0] = "0";
                }
            }

            br2.close();
            fr2.close();



        } catch (Exception exception){
            exception.printStackTrace();
        }
        return returnData;
    }
    // *************************** User Registration Function ************************ //
}


