package sample.models;

import java.time.LocalDate;

public class Patient extends User {

    public Patient(String userName, String name, String gender, int phoneNumber, int idNumber, LocalDate dob, String address, String maritalStatus, String profilePicture, String bloodGroup, String allergies) {
        super(userName, name, gender, phoneNumber, idNumber, dob, address, maritalStatus, idNumber, profilePicture);
        this.bloodGroup = bloodGroup;
        this.allergies = allergies;
    }

    private String bloodGroup;
    private String allergies;

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
}
