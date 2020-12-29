package sample.models;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Visitor {
    private int idNo;
    private String visitorName;
    private int phoneNo;
    private LocalDate date;
    private LocalTime inTime;
    private LocalTime outTime;
    private String purpose;
    private String note;
    private String attachDoc;

    public Visitor(){

    }

    public Visitor(int idNo, String visitorName, int phoneNo, LocalDate date, LocalTime inTime, LocalTime outTime, String purpose, String note, String attachDoc) {
        this.idNo = idNo;
        this.visitorName = visitorName;
        this.phoneNo = phoneNo;
        this.date = date;
        this.inTime = inTime;
        this.outTime = outTime;
        this.purpose = purpose;
        this.note = note;
        this.attachDoc = attachDoc;
    }


    public int getIdNo() {
        return idNo;
    }

    public void setIdNo(int idNo) {
        this.idNo = idNo;
    }

    public String getVisitorName() {
        return visitorName;
    }

    public void setVisitorName(String visitorName) {
        this.visitorName = visitorName;
    }

    public int getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(int phoneNo) {
        this.phoneNo = phoneNo;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getInTime() {
        return inTime;
    }

    public void setInTime(LocalTime inTime) {
        this.inTime = inTime;
    }

    public LocalTime getOutTime() {
        return outTime;
    }

    public void setOutTime(LocalTime outTime) {
        this.outTime = outTime;
    }

    public String getPurpose() {
        return purpose;
    }

    public void setPurpose(String purpose) {
        this.purpose = purpose;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getAttachDoc() {
        return attachDoc;
    }

    public void setAttachDoc(String attachDoc) {
        this.attachDoc = attachDoc;
    }

    // add visitor

    public static void addVisitor(Visitor visitor) throws IOException {
        try {
            File visitorFile = new File("src/sample/fileDatabase/VisitorRecords.txt");
            FileWriter fw = new FileWriter(visitorFile,true);
            if(!visitorFile.exists()){
                if(visitorFile.createNewFile()){
                    System.out.println("Created new Appointment file");
                }
            }

            BufferedWriter bw1 = new BufferedWriter(fw);
            if(visitorFile.length()==0){
                bw1.write(visitor.toString());

            } else{
                bw1.write("\n"+visitor.toString());
            }

            bw1.close();
            fw.close();
            System.out.println("New visitor record added");
        } catch (IOException exception){
            exception.printStackTrace();
        }

    }

    // view visitor

    public static ArrayList<Visitor> viewComplain(String userRole) throws IOException {

        ArrayList<Visitor> visitorArraylist = new ArrayList<>();
        String currentLine;

        File userDBFile = new File("src/sample/fileDatabase/VisitorRecords.txt");
        FileReader fr = new FileReader(userDBFile);
        BufferedReader br = new BufferedReader(fr);

        if (userRole.equals("Receptionist")) {
            while ((currentLine = br.readLine()) != null) {
                Visitor readVisitor = new Visitor();
                String decryptedText = Crypto.decrypt(currentLine);
                assert decryptedText != null;
                String[] userData = decryptedText.split("~");
                visitorSetter(readVisitor, userData);
                visitorArraylist.add(readVisitor);
            }

        }

        return visitorArraylist;
    }


    // visitor edit function

    public static void editVisitor(int varIdNo,LocalDate varDate,LocalTime varIntime,Visitor visitor) throws IOException {
        File oldFile = new File("src/sample/fileDatabase/VisitorRecords.txt");;
        File tempFile = new File("src/sample/fileDatabase/tempVisitorRecord.txt");

        FileWriter fw = new FileWriter(tempFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);
        FileReader fr = new FileReader(oldFile);
        BufferedReader br = new BufferedReader(fr);

        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            String decryptedText = Crypto.decrypt(currentLine);
            assert decryptedText != null;
            String[] userData = decryptedText.split("~");
            int savedId = Integer.parseInt(userData[0]);
            if((savedId==varIdNo)&&
                    (LocalDate.parse(userData[3]).equals(varDate))&&
                    (LocalTime.parse(userData[4]).equals(varIntime))){
                    pw.println(visitor);
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
            System.out.println("Visitor record edited successfully");
        } else {
            System.out.println("Error on visitor record edit");
        }

        File dump = new File("src/sample/fileDatabase/VisitorRecords.txt");
        if (tempFile.renameTo(dump)) {
            System.out.println("Successfully renamed file");
        } else {
            System.out.println("Error on renaming");
        }
    }

    //visitor delete function

    public static void deleteVisitor(int varId,LocalDate varDate,LocalTime varInTime) throws IOException {
        String currentLine;

        File oldFile = new File("src/sample/fileDatabase/VisitorRecords.txt");
        ;
        File tempFile = new File("src/sample/fileDatabase/VisitorTempFile.txt");

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
            if((savedId==varId)&&
                    (LocalDate.parse(userData[3]).equals(varDate))&&
                    (LocalTime.parse(userData[4]).equals(varInTime))){
                System.out.println("Visitor record deleted");
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
            System.out.println("Visitor record deleted successfully");
        } else {
            System.out.println("Error on user deletion");
        }

        File dump = new File("src/sample/fileDatabase/VisitorRecords.txt");
        if (tempFile.renameTo(dump)) {
            System.out.println("Successfully renamed file");
        } else {
            System.out.println("Error on renaming");
        }


}

    // visitor setter
    private static void visitorSetter(Visitor readVisitor, String[] userData) {
        readVisitor.setIdNo(Integer.parseInt(userData[0]));
        readVisitor.setVisitorName(userData[1]);
        readVisitor.setPhoneNo(Integer.parseInt(userData[2]));
        readVisitor.setDate(LocalDate.parse(userData[3]));
        readVisitor.setInTime(LocalTime.parse(userData[4]));
        readVisitor.setOutTime(LocalTime.parse(userData[5]));
        readVisitor.setPurpose(userData[6]);
        readVisitor.setNote(userData[7]);

    }

    @Override
    public String toString() {
        return (Crypto.encrypt(idNo +
                "~" + visitorName +
                "~" + phoneNo +
                "~" + date +
                "~" + inTime +
                "~" + outTime +
                "~" + purpose +
                "~" + note +
                "~" + attachDoc
                ));
    }
}
