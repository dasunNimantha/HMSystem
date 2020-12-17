package sample.models;

public class UserTasks {

    public void createPatient(String CreatorRole,String userType,User useObj) {
        if (CreatorRole.equals("Admin") || CreatorRole.equals("Receptionist")) {
            if (userType.equals("Patient")) {


            } else if (userType.equals("Receptionist")) {



            }
        }
    }
}
