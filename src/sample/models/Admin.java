package sample.models;

import com.jfoenix.controls.JFXButton;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Admin extends User {

    public Admin(String userName, String password, int idNumber, String name, LocalDate dob, String gender, String maritalStatus, String address, int phoneNumber, String profilePath, JFXButton viewUserBtn) {
        super(userName, password, idNumber, name, dob, gender, maritalStatus, address, phoneNumber, profilePath, viewUserBtn);
    }


    // reference return function



    // reference add function

    public static void addReference(String newSpeciality,String referenceModuleFile) throws IOException {
        File MOSpeciality = new File("src/sample/fileDatabase/reference/"+referenceModuleFile+".txt");
        FileWriter fw = new FileWriter(MOSpeciality,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(newSpeciality);
        bw.close();
        fw.close();
    }
}
