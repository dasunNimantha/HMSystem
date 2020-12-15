package sample.models;

import java.time.LocalDate;

public class Receptionist extends Staff {



    public Receptionist(String userName, String name, String gender, int phoneNumber, int idNumber, LocalDate dob, String address, String maritalStatus, String profilePicture, int staffId, String email, LocalDate dateOfJoin, String staffPhoto) {
        super(userName, name, gender, phoneNumber, idNumber, dob, address, maritalStatus, idNumber, profilePicture, staffId, email, dateOfJoin, staffPhoto);
    }
}
