package sample.models;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

public class UserTasks {


    // create new user function

    public static void createPatient(String creatorRole,String userType,Patient patientObj) throws IOException {
        if (creatorRole.equals("Admin") || creatorRole.equals("Receptionist")) {
            if (userType.equals("Patient")) {

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
                    bw1.write(patientObj.toString());
                    System.out.println("New Patient created Successfully");
                } else {
                    bw1.write("\n"+patientObj.toString());
                }

                File userValidationFile = new File("src/sample/fileDatabase/userAuthDB.txt");
                FileWriter fw2 = new FileWriter(userValidationFile,true);
                int passwd = patientObj.getPassword();
                String authString = (Crypto.encrypt(userType)+","+Crypto.encrypt(patientObj.getUserName())+","+Crypto.encrypt(Integer.toString(passwd)));

                BufferedWriter bw2 = new BufferedWriter(fw2);
                if(userValidationFile.length()==0){
                    bw2.write(authString);
                } else {
                    bw2.write("\n"+authString);
                }

                bw1.close();
                fw1.close();
                bw2.close();
                fw1.close();

            } else if (userType.equals("Receptionist")) {
                System.out.println("A receptionist");
            }
        }
    }

    // view user details function
    public static ArrayList<User> viewUser(String viewerRole, String userType) throws IOException {
        ArrayList<User> userArraylist = new ArrayList<>();
        if (viewerRole.equals("Admin") || viewerRole.equals("Receptionist")) {
            if (userType.equals("Patient")) {
                String currentLine;

                File userDBFile = new File("src/sample/fileDatabase/"+userType+"DB.txt");
                FileReader fr = new FileReader(userDBFile);
                BufferedReader br = new BufferedReader(fr);


                while ((currentLine = br.readLine()) != null){

                        Patient readPatient = new Patient();
                        String decryptedText = Crypto.decrypt(currentLine);
                        assert decryptedText != null;
                        String [] userData = decryptedText.split("~");
                        readPatient.setUserName(userData[0]);
                        readPatient.setPassword(Integer.parseInt(userData[1]));
                        readPatient.setName(userData[2]);
                        readPatient.setIdNumber(Integer.parseInt(userData[3]));
                        readPatient.setDob(LocalDate.parse(userData[4]));
                        readPatient.setGender(userData[5]);
                        readPatient.setMaritalStatus(userData[6]);
                        readPatient.setAddress(userData[7]);
                        readPatient.setPhoneNumber(Integer.parseInt(userData[8]));
                        readPatient.setBloodGroup(userData[9]);
                        readPatient.setAllergies(userData[10]);
                        userArraylist.add(readPatient);
                    }
                br.close();
                fr.close();
                }

            }

       return userArraylist;
    }


    // user delete function

    public static void deleteUser(String editorRole,String userRole,String idNo,String username) throws IOException {

        // user deletion from main database
        if(editorRole.equals("Admin") || (editorRole.equals("Receptionist"))){
            if (userRole.equals("Patient")){
                String currentLine;

                File oldFile = new File("src/sample/fileDatabase/PatientDB.txt");;
                File tempFile = new File("src/sample/fileDatabase/tempFile.txt");

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

                File dump = new File("src/sample/fileDatabase/PatientDB.txt");
                if(tempFile.renameTo(dump)){
                    System.out.println("Successfully renamed file");
                } else {
                    System.out.println("Error on renaming");
                }
            }

            // userAuth deletion function
            String currentLine;

            File oldAuthFile = new File("src/sample/fileDatabase/userAuthDB.txt");
            File tempAuthFile = new File("src/sample/fileDatabase/tempAuthFile.txt");

            FileWriter fw = new FileWriter(tempAuthFile,true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter pw = new PrintWriter(bw);

            FileReader fr = new FileReader(oldAuthFile);
            BufferedReader br = new BufferedReader(fr);

            while((currentLine = br.readLine()) != null){
                String[] credentials = currentLine.split(",");
                if (Objects.equals(Crypto.decrypt(credentials[1]), username)) {
                    System.out.println("User found : "+username);
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

            if(oldAuthFile.delete()){
                System.out.println("Auth line deleted on user "+username);
            } else {
                System.out.println("Error on auth line deletion");
            }

            File dump = new File("src/sample/fileDatabase/userAuthDB.txt");
            if(tempAuthFile.renameTo(dump)){
                System.out.println("Successfully renamed the file");
            } else {
                System.out.println("Error on renaming");
            }

        }

    }



}
