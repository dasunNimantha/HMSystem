package sample.models;

import com.jfoenix.controls.JFXButton;

import java.time.LocalDate;

public class Staff extends User {

    private int staffId;
    private String email;
    private LocalDate dateOfJoin;
    private String staffPhoto;

    public Staff(String userName, int password, int idNumber, String name, LocalDate dob, String gender, String maritalStatus, String address, int phoneNumber, JFXButton viewUserBtn, JFXButton editUserBtn, JFXButton deleteUserBtn, int staffId, String email, LocalDate dateOfJoin, String staffPhoto) {
        super(userName, password, idNumber, name, dob, gender, maritalStatus, address, phoneNumber, viewUserBtn, editUserBtn, deleteUserBtn);
        this.staffId = staffId;
        this.email = email;
        this.dateOfJoin = dateOfJoin;
        this.staffPhoto = staffPhoto;
    }

    public int getStaffId() {
        return staffId;
    }

    public void setStaffId(int staffId) {
        this.staffId = staffId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getDateOfJoin() {
        return dateOfJoin;
    }

    public void setDateOfJoin(LocalDate dateOfJoin) {
        this.dateOfJoin = dateOfJoin;
    }

    public String getStaffPhoto() {
        return staffPhoto;
    }

    public void setStaffPhoto(String staffPhoto) {
        this.staffPhoto = staffPhoto;
    }
}
