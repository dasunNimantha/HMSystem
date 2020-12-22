package sample.models;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class UserTasks {


    // create new user function

    public static void createPatient(String creatorRole,String userType,User userObj) throws IOException {
        if (creatorRole.equals("Admin") || creatorRole.equals("Receptionist")) {


                // write patient data to DB files
                File userDBFile = new File("src/sample/fileDatabase/"+userType+"DB.txt");
                FileWriter fw1 = new FileWriter(userDBFile,true);
                if(!userDBFile.exists()){
                    if(userDBFile.createNewFile()){
                        System.out.println("Created new "+userType+" database file");
                    }
                }
                BufferedWriter bw1 = new BufferedWriter(fw1);
                if (userDBFile.length()==0){   // check if the file is empty
                    bw1.write(userObj.toString());
                    System.out.println("New "+userType+" created Successfully");
                } else {
                    bw1.write("\n"+userObj.toString());
                }

                bw1.close();
                fw1.close();

        }
    }

    // view user details function
    public static ArrayList<User> viewUser(String viewerRole, String userType) throws IOException {
        ArrayList <User> userArraylist = new ArrayList<>();

        if (viewerRole.equals("Admin") || viewerRole.equals("Receptionist")) {

                String currentLine;

                File userDBFile = new File("src/sample/fileDatabase/"+userType+"DB.txt");
                FileReader fr = new FileReader(userDBFile);
                BufferedReader br = new BufferedReader(fr);

                if(userType.equals("Patient")){
                    while ((currentLine = br.readLine()) != null){

                        Patient readPatient = new Patient();
                        String decryptedText = Crypto.decrypt(currentLine);
                        assert decryptedText != null;
                        String [] userData = decryptedText.split("~");
                        readPatient.setUserName(userData[0]);
                        readPatient.setPassword((userData[1]));
                        readPatient.setName(userData[2]);
                        readPatient.setIdNumber(Integer.parseInt(userData[3]));
                        readPatient.setDob(LocalDate.parse(userData[4]));
                        readPatient.setGender(userData[5]);
                        readPatient.setMaritalStatus(userData[6]);
                        readPatient.setAddress(userData[7]);
                        readPatient.setPhoneNumber(Integer.parseInt(userData[8]));
                        readPatient.setProfilePath(userData[9]);
                        readPatient.setBloodGroup(userData[10]);
                        readPatient.setAllergies(userData[11]);
                        userArraylist.add(readPatient);
                    }
                } else if (userType.equals("Receptionist")){
                    while ((currentLine = br.readLine()) != null){

                        Receptionist readReceptionist = new Receptionist();
                        String decryptedText = Crypto.decrypt(currentLine);
                        assert decryptedText != null;
                        String [] userData = decryptedText.split("~");
                        readReceptionist.setUserName(userData[0]);
                        readReceptionist.setPassword((userData[1]));
                        readReceptionist.setStaffId(Integer.parseInt(userData[2]));
                        readReceptionist.setStaffPhoto(userData[3]);
                        readReceptionist.setEmail(userData[4]);
                        readReceptionist.setName(userData[5]);
                        readReceptionist.setIdNumber(Integer.parseInt(userData[6]));
                        readReceptionist.setDob(LocalDate.parse(userData[7]));
                        readReceptionist.setGender(userData[8]);
                        readReceptionist.setMaritalStatus(userData[9]);
                        readReceptionist.setAddress(userData[10]);
                        readReceptionist.setPhoneNumber(Integer.parseInt(userData[11]));
                        readReceptionist.setProfilePath(userData[12]);
                        userArraylist.add(readReceptionist);
                    }
                }else if(userType.equals("Medical_Officer")){
                    while ((currentLine = br.readLine()) != null) {
                        MedicalOfficer readMO = new MedicalOfficer();
                        String decryptedText = Crypto.decrypt(currentLine);
                        assert decryptedText != null;
                        String[] userData = decryptedText.split("~");
                        readMO.setUserName(userData[0]);
                        readMO.setPassword((userData[1]));
                        readMO.setStaffId(Integer.parseInt(userData[2]));
                        readMO.setStaffPhoto(userData[3]);
                        readMO.setEmail(userData[4]);
                        readMO.setName(userData[5]);
                        readMO.setIdNumber(Integer.parseInt(userData[6]));
                        readMO.setDob(LocalDate.parse(userData[7]));
                        readMO.setGender(userData[8]);
                        readMO.setMaritalStatus(userData[9]);
                        readMO.setAddress(userData[10]);
                        readMO.setPhoneNumber(Integer.parseInt(userData[11]));
                        readMO.setProfilePath(userData[12]);
                        readMO.setSpeciality(userData[13]);
                        userArraylist.add(readMO);
                    }
                }

                br.close();
                fr.close();
                }


       return userArraylist;
    }




    // user delete function

    public static void deleteUser(String editorRole,String userRole,String idNo,String username) throws IOException {

        // user deletion from main database
        if(editorRole.equals("Admin") || (editorRole.equals("Receptionist"))){
                String currentLine;

                File oldFile = new File("src/sample/fileDatabase/"+userRole+"DB.txt");;
                File tempFile = new File("src/sample/fileDatabase/"+userRole+"tempFile.txt");

                FileWriter fw = new FileWriter(tempFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                FileReader fr = new FileReader(oldFile);
                BufferedReader br = new BufferedReader(fr);

                while((currentLine = br.readLine()) != null){
                    String decryptedText = Crypto.decrypt(currentLine);
                    assert decryptedText != null;
                    String [] userData = decryptedText.split("~");
                    if(((userData[0].equals(username)))) {
                        System.out.println("\nUser found : "+username);
                    } else{
                        pw.println(currentLine);

                    }

                }

                pw.flush();
                pw.close();
                fr.close();
                br.close();
                bw.close();
                fw.close();

                if(oldFile.delete()){
                    System.out.println("User "+username+" deleted successfully");
                } else {
                    System.out.println("Error on user deletion");
                }

                File dump = new File("src/sample/fileDatabase/"+userRole+"DB.txt");
                if(tempFile.renameTo(dump)){
                    System.out.println("Successfully renamed file");
                } else {
                    System.out.println("Error on renaming");
                }
            }

    }

    // edit user function

    public static void userEditFunction(String editorRole,String userType,User userObj,String oldUsername) throws IOException {
        if((editorRole.equals("Admin") || (editorRole.equals("Receptionist")))){
                String currentLine;
            System.out.println("edit function called");
                File oldFile = new File("src/sample/fileDatabase/"+userType+"DB.txt");;
                File tempFile = new File("src/sample/fileDatabase/"+userType+"tempFile.txt");

                FileWriter fw = new FileWriter(tempFile,true);
                BufferedWriter bw = new BufferedWriter(fw);
                PrintWriter pw = new PrintWriter(bw);

                FileReader fr = new FileReader(oldFile);
                BufferedReader br = new BufferedReader(fr);

                while((currentLine = br.readLine()) != null){
                    String decryptedText = Crypto.decrypt(currentLine);
                    assert decryptedText != null;
                    String [] userData = decryptedText.split("~");

                    if((userData[0].equals(oldUsername))) {
                       pw.println(userObj.toString());
                    } else{
                        pw.println(currentLine);

                    }

                }

                pw.flush();
                pw.close();
                fr.close();
                br.close();
                bw.close();
                fw.close();

                if(oldFile.delete()){
                    System.out.println("User "+userObj.getUserName()+" edited successfully");
                } else {
                    System.out.println("Error on user edit");
                }

                File dump = new File("src/sample/fileDatabase/"+userType+"DB.txt");
                if(tempFile.renameTo(dump)){
                    System.out.println("Successfully renamed file");
                } else {
                    System.out.println("Error on renaming");
                }
            }


        }

    public static ArrayList<String> returnReference(String referenceModuleFile) throws IOException {
        File MOSpeciality = new File("src/sample/fileDatabase/reference/"+referenceModuleFile+".txt");
        FileReader fr = new FileReader(MOSpeciality);
        BufferedReader br = new BufferedReader(fr);
        ArrayList <String> speciality  = new ArrayList<>();

        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            String decryptedLine = Crypto.decrypt(currentLine);
            assert decryptedLine != null;
            speciality.add(decryptedLine);

        }
        br.close();
        fr.close();
        return speciality;
    }

    // return doctors names with speciality

    public static ArrayList<String> returnMOWithSpeciality(String speciality){
        return null;
    }

    }


