package sample.models;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.jfoenix.controls.JFXButton;
import javafx.scene.control.Cell;
import javafx.scene.text.TextAlignment;

import java.io.*;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

public class Admin extends User {

    public Admin(String userName, String password, int idNumber, String name, LocalDate dob, String gender, String maritalStatus, String address, int phoneNumber, String profilePath, JFXButton viewUserBtn) {
        super(userName, password, idNumber, name, dob, gender, maritalStatus, address, phoneNumber, profilePath, viewUserBtn);
    }


    // reference return function



    // reference add function

    public static void addReference(String newSpeciality,String referenceModuleFile) throws IOException {
        File MOSpeciality = new File("src/sample/fileDatabase/reference/"+referenceModuleFile+".txt");
        FileWriter fw = new FileWriter(MOSpeciality,true);
        BufferedWriter bw = new BufferedWriter(fw);
        bw.write(newSpeciality);
        bw.close();
        fw.close();
    }

    // export login log function

    public static void exportLoginLog(boolean all,LocalDate from,LocalDate to,String userRole) throws IOException {
        File loginData= new File("src/sample/fileDatabase/logFiles/loginData.txt");
        FileReader fr = new FileReader(loginData);
        BufferedReader br = new BufferedReader(fr);


        if(!loginData.exists()){
            System.out.println("No log data file found");
        } else {
            Date date = new Date() ;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
            File expLogData = new File("src/sample/fileDatabase/exportedFiles/Logins/"+dateFormat.format(date) + ".csv") ;

            FileWriter fw = new FileWriter(expLogData,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String currentLine;
            while((currentLine = br.readLine())!= null){
                String decryptedLine = Crypto.decrypt(currentLine);
                assert decryptedLine != null;
                String [] logData = decryptedLine.split(",");
                LocalDate loggedDate = LocalDate.parse(logData[0]);
                if(userRole.equals("All")){   // print all user log data
                    if(((loggedDate.isAfter(to)) && (loggedDate.isBefore(from)))){
                        pw.println(decryptedLine);
                    }
                } else {
                    if(((
                            (loggedDate.isAfter(from) || (loggedDate.isEqual(from))) &&
                                    (loggedDate.isBefore(to) || (loggedDate.isEqual(to)))
                    ) && (userRole.equals(logData[3])))){
                        pw.println(decryptedLine);
                    }
                }

            }
            bw.close();
            fw.close();
        }
        br.close();
        fr.close();

    }

    // export login log as pdf function
    public static void exportLoginPDF(LocalDate from,LocalDate to,String userRole){
        try{

            File loginData= new File("src/sample/fileDatabase/logFiles/loginData.txt");
            FileReader fr = new FileReader(loginData);
            BufferedReader br = new BufferedReader(fr);


            if(!loginData.exists()){
                System.out.println("No log data file found");
            } else {
                Date date = new Date() ;
                SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;

                Document document = new Document();
                PdfWriter.getInstance(document,new FileOutputStream("src/sample/fileDatabase/exportedFiles/Logins/"+dateFormat.format(date)+".pdf"));
                document.open();

                document.add(new Paragraph("User Login Activity Report \n\n", FontFactory.getFont(FontFactory.COURIER,20,Font.BOLD)));
                document.add(new Paragraph("Exported Date : "+LocalDate.now()+"\n"+"User Role : "+userRole+"\nLog  From : "+from+"   To : "+to+"\n\n"));

                PdfPTable logTable = new PdfPTable(4);
                PdfPCell dateHeading = new PdfPCell(new Paragraph("Date"));
                PdfPCell timeHeading = new PdfPCell(new Paragraph("Time"));
                PdfPCell userHeading = new PdfPCell(new Paragraph("Username"));
                PdfPCell roleHeading = new PdfPCell(new Paragraph("Role"));

                dateHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
                timeHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
                userHeading.setHorizontalAlignment(Element.ALIGN_CENTER);
                roleHeading.setHorizontalAlignment(Element.ALIGN_CENTER);

                logTable.addCell(dateHeading);
                logTable.addCell(timeHeading);
                logTable.addCell(userHeading);
                logTable.addCell(roleHeading);

                String currentLine;
                int logCount=0;
                while((currentLine = br.readLine())!= null){
                    String decryptedLine = Crypto.decrypt(currentLine);
                    assert decryptedLine != null;
                    String [] logData = decryptedLine.split(",");
                    LocalDate loggedDate = LocalDate.parse(logData[0]);
                    if(userRole.equals("All")){   // print all user log data
                        if(((loggedDate.isAfter(to)) && (loggedDate.isBefore(from)))){
                            String [] splitData = decryptedLine.split(",");
                            logTable.addCell(splitData[0]);
                            logTable.addCell(splitData[1]);
                            logTable.addCell(splitData[2]);
                            logTable.addCell(splitData[3]);

                        }
                    } else {
                        if(((
                                (loggedDate.isAfter(from) || (loggedDate.isEqual(from))) &&
                                        (loggedDate.isBefore(to) || (loggedDate.isEqual(to)))
                        ) && (userRole.equals(logData[3])))){
                            logCount++;
                            String [] splitData = decryptedLine.split(",");
                            logTable.addCell(String.valueOf(logCount));
                            logTable.addCell(splitData[0]);
                            logTable.addCell(splitData[1]);
                            logTable.addCell(splitData[2]);
                            logTable.addCell(splitData[3]);
                        }
                    }

                }
                document.add(logTable);
                document.close();
            }



        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // export patient login credentials as csv function

    public static void exportPatientCred(String adminUsername,String adminName) throws IOException {
        File loginCred= new File("src/sample/fileDatabase/PatientDB.txt");
        FileReader fr = new FileReader(loginCred);
        BufferedReader br = new BufferedReader(fr);


        if(!loginCred.exists()){
            System.out.println("No log data file found");
        } else {
            Date date = new Date() ;
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
            File expLogData = new File("src/sample/fileDatabase/exportedFiles/PatientCred/"+dateFormat.format(date) + ".csv") ;

            FileWriter fw = new FileWriter(expLogData,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            String currentLine;
            while((currentLine = br.readLine())!= null){
                String decryptedLine = Crypto.decrypt(currentLine);
                assert decryptedLine != null;
                String [] patientData = decryptedLine.split("~");
                pw.println(patientData[2]+","+patientData[0]+","+patientData[1]);
            }
            bw.close();
            fw.close();
        }
        br.close();
        fr.close();

    }


}
