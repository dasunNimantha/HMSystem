package sample.models;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.datamodels.treetable.RecursiveTreeObject;

import java.awt.event.ActionEvent;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public  class User extends RecursiveTreeObject<User> {
    private String userName;
    private String password;
    private int idNumber;
    private String name;
    private LocalDate dob;
    private String gender;
    private String maritalStatus;
    private  String address;
    private int phoneNumber;
    private String profilePath;
    private JFXButton viewUserBtn;

    public User() {
    }

    public User(String userName, String password, int idNumber, String name, LocalDate dob, String gender, String maritalStatus, String address, int phoneNumber,String profilePath, JFXButton viewUserBtn) {
        this.userName = userName;
        this.password = password;
        this.idNumber = idNumber;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.profilePath = profilePath;
        this.viewUserBtn = viewUserBtn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public  void setProfilePath(String profilePath){this.profilePath = profilePath;}

    public String getProfilePath(){return profilePath;}

    public JFXButton getViewUserBtn() {
        return viewUserBtn;
    }

    public void setViewUserBtn(JFXButton viewUserBtn) {
        this.viewUserBtn = viewUserBtn;
    }


    public static void ViewUserDetails(ActionEvent actionEvent){
        System.out.println("Clicked");
    }

    // functions

}
