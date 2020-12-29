package sample.models;

import java.io.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class PostalMail {

    private String mailType;
    private String from;
    private String refNumber;
    private String address;
    private String note;
    private String toName;
    private LocalDate date;
    private String attachDoc;

    public PostalMail(String mailType, String from, String refNumber, String address, String note, String toName, LocalDate date, String attachDoc) {
        this.mailType = mailType;
        this.from = from;
        this.refNumber = refNumber;
        this.address = address;
        this.note = note;
        this.toName = toName;
        this.date = date;
        this.attachDoc = attachDoc;
    }

    public PostalMail() {

    }

    public String getMailType() {
        return mailType;
    }

    public void setMailType(String mailType) {
        this.mailType = mailType;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getRefNumber() {
        return refNumber;
    }

    public void setRefNumber(String refNumber) {
        this.refNumber = refNumber;
    }

    public String getaddress() {
        return address;
    }

    public void setFromAddress(String address) {
        this.address = address;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public String getToName() {
        return toName;
    }

    public void setToName(String toName) {
        this.toName = toName;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getAttachDoc() {
        return attachDoc;
    }

    public void setAttachDoc(String attachDoc) {
        this.attachDoc = attachDoc;
    }


    // add postal mail function

    public static void addPostalMail (String mailType,PostalMail postalMail){
        try {
            File mailFile;
            if(mailType.equals("Received")){
                mailFile = new File("src/sample/fileDatabase/ReceivedMails.txt");
            } else {
                mailFile = new File("src/sample/fileDatabase/DispatchedMails.txt");
            }

            FileWriter fw = new FileWriter(mailFile,true);
            if(!mailFile.exists()){
                if(mailFile.createNewFile()){
                    System.out.println("Created new Mail file");
                }
            }

            BufferedWriter bw1 = new BufferedWriter(fw);
            if(mailFile.length()==0){
                bw1.write(postalMail.toString());

            } else{
                bw1.write("\n"+postalMail.toString());
            }

            bw1.close();
            fw.close();
        } catch (IOException exception){
            exception.printStackTrace();
        }
    }

    // view mail function

    public static ArrayList<PostalMail> viewMail(String mailType) throws IOException {

        ArrayList<PostalMail> mailArray = new ArrayList<>();
        String currentLine;
        File mailFile;
        if(mailType.equals("Received")){
            mailFile = new File("src/sample/fileDatabase/ReceivedMails.txt");
        } else {
            mailFile = new File("src/sample/fileDatabase/DispatchedMails.txt");
        }

        FileReader fr = new FileReader(mailFile);
        BufferedReader br = new BufferedReader(fr);

            try {
                while ((currentLine = br.readLine()) != null) {

                    PostalMail readMail= new PostalMail();
                    String decryptedText = Crypto.decrypt(currentLine);
                    assert decryptedText != null;
                    String[] userData = decryptedText.split("~");
                    mailSetter(userData,readMail);
                    mailArray.add(readMail);
                }
            } catch (IOException exception) {
                exception.printStackTrace();

            }

            return mailArray;
    }


    // mail edit function

    public static void editMail(String mailType,String referenceNo,PostalMail postalMail) throws IOException {

        File oldFile;
        File tempFile;
        File dump;
        if(mailType.equals("Received")){
            oldFile = new File("src/sample/fileDatabase/ReceivedMails.txt");
            tempFile = new File("src/sample/fileDatabase/tempReceivedMails.txt");
            dump = new File("src/sample/fileDatabase/ReceivedMails.txt");
        } else {
            oldFile = new File("src/sample/fileDatabase/DispatchedMails.txt");
            tempFile = new File("src/sample/fileDatabase/tempDispatchedMails.txt");
            dump = new File("src/sample/fileDatabase/DispatchedMails.txt");
        }

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
            if(userData[0].equals(referenceNo)){
                pw.println(postalMail);
                System.out.println(referenceNo);
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
            System.out.println("Mail record edited successfully");
        } else {
            System.out.println("Error on visitor record edit");
        }

        if (tempFile.renameTo(dump)) {
            System.out.println("Successfully renamed file");
        } else {
            System.out.println("Error on renaming");
        }
    }

    public static void mailSetter(String [] userData,PostalMail readMail){
        readMail.setRefNumber(userData[2]);
        readMail.setFrom(userData[1]);
        readMail.setFromAddress(userData[3]);
        readMail.setNote(userData[4]);
        readMail.setToName(userData[5]);
        readMail.setDate(LocalDate.parse(userData[6]));

    }

    @Override
    public String toString() {
        return Crypto.encrypt(mailType +
                "~" + from +
                "~" + refNumber +
                "~" + address +
                "~" + note +
                "~" + toName +
                "~" + date +
                "~" + attachDoc
                );
    }
}
