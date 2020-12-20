package sample.models;

import com.jfoenix.controls.JFXButton;

import java.time.LocalDate;

public class MedicalOfficer extends Staff{

    public MedicalOfficer(String userName, String password, int idNumber, String name, LocalDate dob, String gender, String maritalStatus, String address, int phoneNumber, String profilePath, JFXButton viewUserBtn, int staffId, String email, LocalDate dateOfJoin, String staffPhoto) {
        super(userName, password, idNumber, name, dob, gender, maritalStatus, address, phoneNumber, profilePath, viewUserBtn, staffId, email, dateOfJoin, staffPhoto);
    }
}
