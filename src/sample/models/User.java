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
    private int password;
    private int idNumber;
    private String name;
    private LocalDate dob;
    private String gender;
    private String maritalStatus;
    private  String address;
    private int phoneNumber;
    private JFXButton viewUserBtn;
    private JFXButton editUserBtn;
    private JFXButton deleteUserBtn;
    public User() {
    }

    public User(String userName, int password, int idNumber, String name, LocalDate dob, String gender, String maritalStatus, String address, int phoneNumber, JFXButton viewUserBtn, JFXButton editUserBtn, JFXButton deleteUserBtn) {
        this.userName = userName;
        this.password = password;
        this.idNumber = idNumber;
        this.name = name;
        this.dob = dob;
        this.gender = gender;
        this.maritalStatus = maritalStatus;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.viewUserBtn = viewUserBtn;
        this.editUserBtn = editUserBtn;
        this.deleteUserBtn = deleteUserBtn;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getPassword() {
        return password;
    }

    public void setPassword(int password) {
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

    public JFXButton getViewUserBtn() {
        return viewUserBtn;
    }

    public void setViewUserBtn(JFXButton viewUserBtn) {
        this.viewUserBtn = viewUserBtn;
    }

    public JFXButton getEditUserBtn() {
        return editUserBtn;
    }

    public void setEditUserBtn(JFXButton editUserBtn) {
        this.editUserBtn = editUserBtn;
    }

    public JFXButton getDeleteUserBtn() {
        return deleteUserBtn;
    }

    public void setDeleteUserBtn(JFXButton deleteUserBtn) {
        this.deleteUserBtn = deleteUserBtn;
    }

    public static void ViewUserDetails(ActionEvent actionEvent){
        System.out.println("Clicked");
    }

    // functions

}
