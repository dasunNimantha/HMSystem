package sample.models;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class Appointment {

    private int appointmentNo;
    private Patient patient;
    private LocalDate appointmentDate;
    private LocalDate appointmentTime;
    private String symptoms;
    private MedicalOfficer appointedMedicalOfficer;
    private String appointmentStatus;

    public Appointment(int appointmentNo, Patient patient, LocalDate appointmentDate, LocalDate appointmentTime, String symptoms, MedicalOfficer appointedMedicalOfficer, String appointmentStatus) {
        this.appointmentNo = appointmentNo;
        this.patient = patient;
        this.appointmentDate = appointmentDate;
        this.appointmentTime = appointmentTime;
        this.symptoms = symptoms;
        this.appointedMedicalOfficer = appointedMedicalOfficer;
        this.appointmentStatus = appointmentStatus;
    }

    public int getAppointmentNo() {
        return appointmentNo;
    }

    public void setAppointmentNo(int appointmentNo) {
        this.appointmentNo = appointmentNo;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
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

    public MedicalOfficer getAppointedMedicalOfficer() {
        return appointedMedicalOfficer;
    }

    public void setAppointedMedicalOfficer(MedicalOfficer appointedMedicalOfficer) {
        this.appointedMedicalOfficer = appointedMedicalOfficer;
    }

    public String getAppointmentStatus() {
        return appointmentStatus;
    }

    public void setAppointmentStatus(String appointmentStatus) {
        this.appointmentStatus = appointmentStatus;
    }

    public void createAppointment(Appointment appointment) throws IOException {
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
            System.out.println("New Appointment added to user "+appointment.getPatient().getName());
        } catch (IOException exception){
            exception.printStackTrace();
        }

    }

    @Override
    public String toString() {
        return Crypto.encrypt( appointmentNo +
                "~" + patient +
                "~" + appointmentDate +
                "~" + appointmentTime +
                "~" + symptoms + '\'' +
                "~" + appointedMedicalOfficer +
                "~" + appointmentStatus);
    }
}
