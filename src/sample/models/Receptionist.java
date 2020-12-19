package sample.models;

import com.jfoenix.controls.JFXButton;

import java.time.LocalDate;

public class Receptionist extends Staff {

    public Receptionist(String userName, int password, int idNumber, String name, LocalDate dob, String gender, String maritalStatus, String address, int phoneNumber, JFXButton viewUserBtn, JFXButton editUserBtn, JFXButton deleteUserBtn, int staffId, String email, LocalDate dateOfJoin, String staffPhoto) {
        super(userName, password, idNumber, name, dob, gender, maritalStatus, address, phoneNumber, viewUserBtn, editUserBtn, deleteUserBtn, staffId, email, dateOfJoin, staffPhoto);
    }
}
