package sample.models;

import com.jfoenix.controls.JFXButton;

import java.io.*;
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

        Date date = new Date() ;
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH-mm-ss") ;
        File expLogData = new File("src/sample/fileDatabase/exportedFiles/"+dateFormat.format(date) + ".txt") ;

        FileWriter fw = new FileWriter(expLogData,true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        if(!loginData.exists()){
            System.out.println("No log data file found");
        }

        String currentLine;
        while((currentLine = br.readLine())!= null){
            String decryptedLine = Crypto.decrypt(currentLine);
            assert decryptedLine != null;
            String [] logData = decryptedLine.split(",");
            LocalDate loggedDate = LocalDate.parse(logData[0]);
            if(userRole==null){
                if(!((loggedDate.isAfter(to)) && (!loggedDate.isBefore(from)))){
                    if(expLogData.length()==0){
                        pw.println(decryptedLine);
                    } else{
                        pw.println(decryptedLine);
                    }
                }
            } else {
                if((!((loggedDate.isAfter(to)) && (!loggedDate.isBefore(from))) && logData[3].equals(userRole))){
                    if(expLogData.length()==0){
                        pw.println(decryptedLine);
                    } else{
                        pw.println(decryptedLine);
                    }
                }
            }

        }

        br.close();
        fr.close();
        bw.close();
        fw.close();
    }
}
