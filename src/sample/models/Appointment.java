package sample.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Appointment {

    private String appointmentNo;
    private String patientName;
    private String patientUserName;
    private String appointedMedicalOfficer;
    private String appointedMoUsername;
    private LocalDate appointmentDate;
    private LocalDate appointmentTime;
    private String symptoms;
    private String appointmentStatus;

    public Appointment(){}

    public Appointment(String appointmentNo, String patientName, String patientUserName, String appointedMedicalOfficer, String appointedMoUsername, LocalDate appointmentDate, LocalDate appointmentTime, String symptoms, String appointmentStatus) {
        this.appointmentNo = appointmentNo;
        this.patientName = patientName;
        this.patientUserName = patientUserName;
        this.appointedMedicalOfficer = appointedMedicalOfficer;
        this.appointedMoUsername = appointedMoUsername;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.symptoms = symptoms;
        this.appointmentStatus = appointmentStatus;
    }

    public String getAppointmentNo() {
        return appointmentNo;
    }

    public void setAppointmentNo(String appointmentNo) {
        this.appointmentNo = appointmentNo;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientUserName() {
        return patientUserName;
    }

    public void setPatientUserName(String patientUserName) {
        this.patientUserName = patientUserName;
    }

    public String getAppointedMedicalOfficer() {
        return appointedMedicalOfficer;
    }

    public void setAppointedMedicalOfficer(String appointedMedicalOfficer) {
        this.appointedMedicalOfficer = appointedMedicalOfficer;
    }

    public String getAppointedMoUsername() {
        return appointedMoUsername;
    }

    public void setAppointedMoUsername(String appointedMoUsername) {
        this.appointedMoUsername = appointedMoUsername;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public LocalDate getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(LocalDate appointmentTime) {
        this.appointmentTime = appointmentTime;
    }

    public String getSymptoms() {
        return symptoms;
    }

    public void setSymptoms(String symptoms) {
        this.symptoms = symptoms;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public static void createAppointment(Appointment appointment) throws IOException {
        try {
            File appointmentFile = new File("src/sample/fileDatabase/Appointments.txt");
            FileWriter fw = new FileWriter(appointmentFile,true);
            if(!appointmentFile.exists()){
                if(appointmentFile.createNewFile()){
                    System.out.println("Created new Appointment file");
                }
            }

            BufferedWriter bw1 = new BufferedWriter(fw);
            if(appointmentFile.length()==0){
                bw1.write(appointment.toString());

            } else{
                bw1.write("\n"+appointment.toString());
            }
            System.out.println("New Appointment added to user "+appointment.getPatientName());
        } catch (IOException exception){
            exception.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return Crypto.encrypt( appointmentNo +
                "~" + patientName +
                "~" + patientUserName +
                "~" + appointedMedicalOfficer +
                "~" + appointedMoUsername +
                "~" + appointmentDate +
                "~" + appointmentTime +
                "~" + symptoms + '\'' +
                "~" + appointmentStatus);
    }
}
