package sample.models;

import java.time.LocalDate;

public abstract class Staff extends User {

    public Staff(String userName, String name, String gender, int phoneNumber, int idNumber, LocalDate dob, String address, String maritalStatus, int password, String profilePicture, int staffId, String email, LocalDate dateOfJoin, String staffPhoto) {
        super(userName, name, gender, phoneNumber, idNumber, dob, address, maritalStatus, password, profilePicture);
        this.staffId = staffId;
        this.email = email;
        this.dateOfJoin = dateOfJoin;
        this.staffPhoto = staffPhoto;
    }

    private int staffId;
    private String email;
    private LocalDate dateOfJoin;
    private String staffPhoto;

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
