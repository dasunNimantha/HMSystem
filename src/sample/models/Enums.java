package sample.models;

public class Enums {

    public enum enumUsers  {
        ADMIN("Admin"),
        RECEPTIONIST("Receptionist"),
        MEDICALOFFICER("Medical Officer"),
        PATIENT("Patient");

        private final String Role;
        enumUsers(String role){
            this.Role = role;
        }

        public String getRole(){
            return Role;
        }
    }

    public enum enumGender{
        MALE("Male"),
        FEMALE("Female");

        private final String Gender;
        enumGender(String gender){
            this.Gender=gender;
        }

        public String getGender(){
            return Gender;
        }
    }

    public enum enumMaritalStatus{
        MARRIED("Married"),
        UNMARRIED("Unmarried");

        private final String MaritalStatus;
        enumMaritalStatus(String maritalStatus){
            this.MaritalStatus=maritalStatus;
        }

        public String getMaritalStatus(){
            return MaritalStatus;
        }
    }

    public enum enumBloodGroup{

        A_POSITIVE("A+"),
        A_NEGATIVE("A-"),
        B_POSITIVE("B+"),
        B_NEGATIVE("B-"),
        O_POSITIVE("O+"),
        O_NEGATIVE("O-"),
        AB_POSITIVE("AB+"),
        AB_NEGATIVE("AB-");


        private final String BloodGroup;
        enumBloodGroup(String bloodGroup){
            this.BloodGroup=bloodGroup;
        }

        public String getBloodGroup(){
            return BloodGroup;
        }
    }

}
