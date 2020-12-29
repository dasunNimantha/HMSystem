package sample.models;

import sample.controllers.dashboardController.AdminDash.ComplainList;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;

public class Complain {
    private String complaintUserName; // if the complaint is a patient
    private int complainID;
    private String complainType;
    private String complaintBy;
    private String phoneNo;
    private LocalDate complainedDate;
    private String description;
    private String note;
    private String attachDocPath;
    private String actionTaken;

    public Complain(String complaintUserName, int complainID, String complainType, String complaintBy, String phoneNo, LocalDate complainedDate, String description, String note, String attachDocPath, String actionTaken) {
        this.complaintUserName = complaintUserName;
        this.complainID = complainID;
        this.complainType = complainType;
        this.complaintBy = complaintBy;
        this.phoneNo = phoneNo;
        this.complainedDate = complainedDate;
        this.description = description;
        this.note = note;
        this.attachDocPath = attachDocPath;
        this.actionTaken = actionTaken;
    }

    public Complain() {

    }

    public String getComplaintUserName() {
        return complaintUserName;
    }

    public void setComplaintUserName(String complaintUserName) {
        this.complaintUserName = complaintUserName;
    }

    public int getComplainID() {
        return complainID;
    }

    public void setComplainID(int complainID) {
        this.complainID = complainID;
    }

    public String getComplainType() {
        return complainType;
    }

    public void setComplainType(String complainType) {
        this.complainType = complainType;
    }

    public String getComplaintBy() {
        return complaintBy;
    }

    public void setComplaintBy(String complaintBy) {
        this.complaintBy = complaintBy;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDate getComplainedDate() {
        return complainedDate;
    }

    public void setComplainedDate(LocalDate complainedDate) {
        this.complainedDate = complainedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAttachDocPath() {
        return attachDocPath;
    }

    public void setAttachDocPath(String attachDocPath) {
        this.attachDocPath = attachDocPath;
    }

    public String getActionTaken() {
        return actionTaken;
    }

    public void setActionTaken(String actionTaken) {
        this.actionTaken = actionTaken;
    }

    // create complain function

    public static void createComplain(Complain complain){
        try {
            File complainFile = new File("src/sample/fileDatabase/Complains.txt");
            FileWriter fw = new FileWriter(complainFile,true);
            if(!complainFile.exists()){
                if(complainFile.createNewFile()){
                    System.out.println("Created new Appointment file");
                }
            }

            BufferedWriter bw1 = new BufferedWriter(fw);
            if(complainFile.length()==0){
                bw1.write(complain.toString());

            } else{
                bw1.write("\n"+complain.toString());
            }

            bw1.close();
            fw.close();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }


    public static ArrayList<Complain> viewComplain(boolean allComplains,String viewerRole,String userName) throws IOException {

        ArrayList<Complain> complainArray = new ArrayList<>();
        String currentLine;
        File complainFile = new File("src/sample/fileDatabase/Complains.txt");
        FileReader fr = new FileReader(complainFile);
        BufferedReader br = new BufferedReader(fr);

        if(allComplains && ((viewerRole).equals("Admin")|| viewerRole.equals("Receptionist"))) {

            try {
                while ((currentLine = br.readLine()) != null) {

                    Complain readComplain = new Complain();
                    String decryptedText = Crypto.decrypt(currentLine);
                    assert decryptedText != null;
                    String[] userData = decryptedText.split("~");
                    complainSetter(userData,readComplain);
                    complainArray.add(readComplain);
                }
            } catch (IOException exception) {
                exception.printStackTrace();

            }

        } else {
            while ((currentLine = br.readLine()) != null) {

                Complain readComplain = new Complain();
                String decryptedText = Crypto.decrypt(currentLine);
                assert decryptedText != null;
                String[] userData = decryptedText.split("~");
                if(userData[1].equals(userName)){
                    readComplain.setComplainID(Integer.parseInt(userData[0]));
                    complainSetter(userData,readComplain);
                    complainArray.add(readComplain);

                }

            }
        }


        return complainArray;
    }

    // edit complain record funtion

    public static void editComplain(String editorRole, int returnedComplainId, Complain complain) throws IOException {
        if (editorRole.equals("Admin")) {
            String currentLine;
            File oldFile = new File("src/sample/fileDatabase/Complains.txt");
            File tempFile = new File("src/sample/fileDatabase/ComplainsTempFile.txt");

            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(oldFile);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                String decryptedText = Crypto.decrypt(currentLine);
                assert decryptedText != null;
                String[] userData = decryptedText.split("~");
                int savedId = Integer.parseInt(userData[0]);
                if(savedId == returnedComplainId){
                    pw.println(complain.toString());
                }
                else {
                    pw.println(currentLine);
                }

            }
            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            if (oldFile.delete()) {
                System.out.println("Complain " + returnedComplainId + " edited successfully");
            } else {
                System.out.println("Error on user edit");
            }

            File dump = new File("src/sample/fileDatabase/Complains.txt");
            if (tempFile.renameTo(dump)) {
                System.out.println("Successfully renamed file");
            } else {
                System.out.println("Error on renaming");
            }
        }
    }


    // complain delete function


    public static void deleteComplain(int complainId) throws IOException {

            String currentLine;
            File oldFile = new File("src/sample/fileDatabase/Complains.txt");
            ;
            File tempFile = new File("src/sample/fileDatabase/ComplainTempFile.txt");

            FileWriter fw = new FileWriter(tempFile, true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(oldFile);
            BufferedReader br = new BufferedReader(fr);

            while ((currentLine = br.readLine()) != null) {
                String decryptedText = Crypto.decrypt(currentLine);
                assert decryptedText != null;
                String[] userData = decryptedText.split("~");
                int savedId = Integer.parseInt(userData[0]);
                if(savedId == complainId){
                    System.out.println("Complain Found");
                } else {
                    pw.println(currentLine);

                }

            }

            pw.flush();
            pw.close();
            fr.close();
            br.close();
            bw.close();
            fw.close();

            if (oldFile.delete()) {
                System.out.println("Complain " + complainId + " deleted successfully");
            } else {
                System.out.println("Error on user deletion");
            }

            File dump = new File("src/sample/fileDatabase/Complains.txt");
            if (tempFile.renameTo(dump)) {
                System.out.println("Successfully renamed file");
            } else {
                System.out.println("Error on renaming");
            }
    }

    private static void complainSetter(String []userData,Complain readComplain){
        readComplain.setComplainID(Integer.parseInt(userData[0]));
        if(userData[1].length()==0){
            readComplain.setComplaintBy("-");
        } else {
            readComplain.setComplaintUserName(userData[1]);
        }
        readComplain.setComplaintBy(userData[2]);
        readComplain.setPhoneNo(userData[3]);
        readComplain.setComplainedDate(LocalDate.parse(userData[4]));
        readComplain.setComplainType(userData[5]);
        readComplain.setDescription(userData[6]);
        readComplain.setNote(userData[7]);
        readComplain.setActionTaken(userData[9]);
    }

    @Override
    public String toString() {
            return Crypto.encrypt(
                    complainID +
                            "~" + complaintUserName +
                            "~" + complaintBy +
                            "~" + phoneNo +
                            "~" + complainedDate +
                            "~" + complainType +
                            "~" + description +
                            "~" + note +
                            "~" + attachDocPath +
                            "~" + actionTaken

            );
        }
}

