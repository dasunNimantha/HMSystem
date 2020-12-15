package sample.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public abstract class User {
    private String userName;
    private String name;
    private String gender;
    private int phoneNumber;
    private int idNumber;
    private LocalDate dob;
    private  String address;
    private String maritalStatus;
    private int password;
    private String profilePicture;

    public User(String userName, String name, String gender, int phoneNumber, int idNumber, LocalDate dob, String address, String maritalStatus, int password, String profilePicture) {
        this.userName = userName;
        this.name = name;
        this.gender = gender;
        this.phoneNumber = phoneNumber;
        this.idNumber = idNumber;
        this.dob = dob;
        this.address = address;
        this.maritalStatus = maritalStatus;
        this.password = idNumber;
        this.profilePicture = profilePicture;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {

        this.userName = userName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public int getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(int idNumber) {
        this.idNumber = idNumber;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public int getPassword() {
        return password;
    }


    public void setPassword(int password) {
        this.password = password;
    }

    public String getProfilePicture() {
        return profilePicture;
    }

    public void setProfilePicture(String profilePicture) {
        this.profilePicture = profilePicture;
    }

    // functions

    public void newSignUpWrite(String userData,String roleFileName){
        try {
            File userDBFile = new File("src/sample/database/"+roleFileName+".txt");
            FileWriter fw = new FileWriter(userDBFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            if (userDBFile.length()==0){   // check the file is empty
                bw.write(userData);
            } else {
                bw.write("\n"+userData);
            }

            bw.close();
            fw.close();

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    @Override
    public String toString(){
        return name+"|"+userName+"|"+idNumber+"|"+dob+"|"+gender+"|"+maritalStatus+"|"+address+"|"+phoneNumber+"|"+profilePicture;
    }
}
