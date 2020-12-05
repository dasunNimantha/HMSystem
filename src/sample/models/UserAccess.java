package sample.models;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;



public class UserAccess {

    // *************************** User Authentication Function  ************************** //


    public int authCheck(String username, String password) throws IOException {
        String currentLine;
        int statusCode = 0;
        FileReader fr = new FileReader("src/sample/fileDatabase/userDB.txt");
        BufferedReader br = new BufferedReader(fr);
        while((currentLine= br.readLine()) != null){
            String [] credentials = currentLine.split(",");
            if (credentials[0].equals(username) && credentials[1].equals(password)){
                statusCode = 1;
            }
        }
        br.close();
        fr.close();
      return statusCode;
    }

    // ************* User Registration Function ************************ //
}


