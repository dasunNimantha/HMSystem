package sample.models;

import com.jfoenix.controls.JFXButton;

import javax.swing.*;
import java.time.LocalDate;

public class MedicalOfficer extends Staff{

    public MedicalOfficer(){

    }

    private String speciality;


    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public String getSpeciality() {
        return speciality;
    }

    public MedicalOfficer(String userName, String password, int idNumber, String name, LocalDate dob, String gender, String maritalStatus, String address, int phoneNumber, String profilePath, JFXButton viewUserBtn, int staffId, String email, LocalDate dateOfJoin, String staffPhoto, String speciality) {
        super(userName, password, idNumber, name, dob, gender, maritalStatus, address, phoneNumber, profilePath, viewUserBtn, staffId, email, dateOfJoin, staffPhoto);
        this.speciality = speciality;
    }

    @Override
    public String toString(){
        return Crypto.encrypt(super.getUserName()+"~"+super.getPassword()+"~"+super.getStaffId()+"~"+super.getStaffPhoto()
                +"~"+getEmail()+"~"+super.getName()+"~"+super.getIdNumber()+"~"+super.getDob()+"~"
                +super.getGender()+"~"+super.getMaritalStatus()+"~"+super.getAddress()+
                "~"+super.getPhoneNumber()+"~"+super.getProfilePath()+"~"+speciality+"~");
    }
}
