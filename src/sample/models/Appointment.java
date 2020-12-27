package sample.models;

import de.jensd.fx.glyphs.testapps.App;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;

public class Appointment {

    private String appointmentNo;
    private String patientName;
    private String patientUserName;
    private String appointedMedicalOfficer;
    private String appointedMoUsername;
    private LocalDate appointmentDate;
    private String appointmentTime;
    private String symptoms;
    private String appointmentStatus;

    public Appointment(){}

    public Appointment(String appointmentNo, String patientName, String patientUserName, String appointedMedicalOfficer, String appointedMoUsername, LocalDate appointmentDate, String appointmentTime, String symptoms, String appointmentStatus) {
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

    public String getAppointmentTime() {
        return appointmentTime;
    }

    public void setAppointmentTime(String appointmentTime) {
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

    // create appointment function

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

            bw1.close();
            fw.close();
        } catch (IOException exception){
            exception.printStackTrace();
        }

    }

    // view appointment details

    public static ArrayList<Appointment> viewAppointment (boolean allUsers,String viewerRole,String patientUserName,String appointmentId){

        String currentLine;
        ArrayList <Appointment> appointmentArray = new ArrayList<>();
        try {

            File appointmentFile = new File("src/sample/fileDatabase/Appointments.txt");
            FileReader fr = new FileReader(appointmentFile);
            BufferedReader br = new BufferedReader(fr);
            while ((currentLine = br.readLine()) != null) {
                Appointment readAppointment = new Appointment();
                String decryptedText = Crypto.decrypt(currentLine);
                assert decryptedText != null;
                String[] userData = decryptedText.split("~");
                if(!allUsers){
                    if(viewerRole.equals("Patient")){
                        if(userData[0].equals(appointmentId) && (userData[2]).equals(patientUserName)){
                            appointmentSetter(readAppointment,userData);
                            appointmentArray.add(readAppointment);
                        }
                    } else {
                        appointmentSetter(readAppointment,userData);
                        appointmentArray.add(readAppointment);
                    }
                } else {
                    if(viewerRole.equals("Receptionist")){
                        appointmentSetter(readAppointment,userData);
                        appointmentArray.add(readAppointment);
                    }

                    else if (viewerRole.equals("Medical_Officer")){
                        if(userData[7].equals("Approved")){

                        }
                    }
                    else if((userData[2]).equals(patientUserName)){
                        appointmentSetter(readAppointment,userData);
                        appointmentArray.add(readAppointment);
                    } else {
                        appointmentSetter(readAppointment,userData);
                        appointmentArray.add(readAppointment);
                    }
                }



            }
            br.close();
            fr.close();
        } catch (IOException exception){
            exception.printStackTrace();
        }

        return appointmentArray;
    }


    // edit appointment function

    public static void editAppointment(String editorRole,String appointmentId,Appointment appointmentObj) throws IOException {

        File oldFile = new File("src/sample/fileDatabase/Appointments.txt");;
        File tempFile = new File("src/sample/fileDatabase/appointTempFile.txt");

        FileWriter fw = new FileWriter(tempFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        FileReader fr = new FileReader(oldFile);
        BufferedReader br = new BufferedReader(fr);

        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            Appointment readAppointment = new Appointment();
            String decryptedText = Crypto.decrypt(currentLine);
            assert decryptedText != null;
            String[] userData = decryptedText.split("~");
            if(editorRole.equals("Receptionist")){
                if (userData[0].equals(appointmentId)){
                    pw.println(appointmentObj);
                } else {
                    pw.println(currentLine);
                }
            }
        }

        pw.flush();
        pw.close();
        fr.close();
        br.close();
        bw.close();
        fw.close();

        if (oldFile.delete()) {
            System.out.println("User " + appointmentObj.patientUserName + " edited successfully");
        } else {
            System.out.println("Error on appointment edit");
        }

        File dump = new File("src/sample/fileDatabase/Appointments.txt");
        if (tempFile.renameTo(dump)) {
            System.out.println("Successfully renamed file");
        } else {
            System.out.println("Error on renaming");
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
                //  "~" + symptoms +
                "~" + appointmentStatus);
    }

    public static void appointmentSetter(Appointment appointment,String[] userData){
        appointment.setAppointmentNo(userData[0]);
        appointment.setPatientName(userData[1]);
        appointment.setPatientUserName(userData[2]);
        appointment.setAppointedMedicalOfficer(userData[3]);
        appointment.setAppointedMoUsername(userData[4]);
        appointment.setAppointmentDate(LocalDate.parse(userData[5]));
        appointment.setAppointmentTime(userData[6]);
        //   appointment.setSymptoms(userData[7]);
        appointment.setAppointmentStatus(userData[7]);
    }
}
