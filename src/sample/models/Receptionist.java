package sample.models;

import com.jfoenix.controls.JFXButton;

import java.time.LocalDate;

public class Receptionist extends Staff {

    public Receptionist(){

    }

    public Receptionist(String userName, String password, int idNumber, String name, LocalDate dob, String gender, String maritalStatus, String address, int phoneNumber, String profilePath, JFXButton viewUserBtn, int staffId, String email, LocalDate dateOfJoin, String staffPhoto) {
        super(userName, password, idNumber, name, dob, gender, maritalStatus, address, phoneNumber, profilePath, viewUserBtn, staffId, email, dateOfJoin, staffPhoto);
    }

    @Override
    public String toString(){
        return Crypto.encrypt(super.getUserName()+"~"+super.getPassword()+"~"+super.getStaffId()+"~"+super.getStaffPhoto()
                +"~"+getEmail()+"~"+super.getName()+"~"+super.getIdNumber()+"~"+super.getDob()+"~"
                +super.getGender()+"~"+super.getMaritalStatus()+"~"+super.getAddress()+
                "~"+super.getPhoneNumber()+"~"+super.getProfilePath()+"~");
    }
}
