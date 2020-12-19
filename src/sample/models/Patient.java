package sample.models;

import com.jfoenix.controls.JFXButton;

import java.time.LocalDate;

public class Patient extends User {


    private String bloodGroup;
    private String allergies;

    public Patient(){
    }

    public Patient(String userName, int password, int idNumber, String name, LocalDate dob, String gender, String maritalStatus, String address, int phoneNumber, JFXButton viewUserBtn, JFXButton editUserBtn, JFXButton deleteUserBtn, String bloodGroup, String allergies) {
        super(userName, password, idNumber, name, dob, gender, maritalStatus, address, phoneNumber, viewUserBtn, editUserBtn, deleteUserBtn);
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
    }

    public String getBloodGroup() {
        return bloodGroup;
    }

    public void setBloodGroup(String bloodGroup) {
        this.bloodGroup = bloodGroup;
    }

    public String getAllergies() {
        return allergies;
    }

    public void setAllergies(String allergies) {
        this.allergies = allergies;
    }

    @Override
    public String toString(){
        return Crypto.encrypt(super.getUserName()+"~"+super.getPassword()+"~"
                +super.getName()+"~"+super.getIdNumber()+"~"+super.getDob()+"~"
                +super.getGender()+"~"+super.getMaritalStatus()+"~"+super.getAddress()+
                "~"+super.getPhoneNumber()+"~"+bloodGroup+"~"+allergies+"~");
    }


}
