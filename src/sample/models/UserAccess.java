package sample.models;

import javafx.scene.control.Alert;

import javax.swing.*;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;


public class UserAccess {

    // *************************** User Authentication Function  ************************** //


    public int authCheck(String role,String username, String password) throws IOException  {
        String currentLine;
        int statusCode = 0;
        FileReader fr = null;
        try {
            fr = new FileReader("src/sample/database/userDB.txt");
            BufferedReader br = new BufferedReader(fr);
            while((currentLine= br.readLine()) != null){
                String [] credentials = currentLine.split(",");
                if (    (Objects.equals(Crypto.decrypt(credentials[0]),role)
                        && Objects.equals(Crypto.decrypt(credentials[1]), username)
                        && Objects.equals(Crypto.decrypt(credentials[2]), password))){
                    statusCode = 1;
                }
    }
            br.close();
            fr.close();
        } catch (IOException e) {
            e.printStackTrace();
        }


        return statusCode;
    }

    // *************************** User Registration Function ************************ //
}


