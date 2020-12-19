package sample.models;

import com.jfoenix.controls.JFXButton;
import javafx.event.ActionEvent;

import java.io.*;
import java.lang.reflect.Array;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.SortedMap;

public class UserTasks {


    // create new user function

    public static void createPatient(String creatorRole,String userType,Patient patientObj) throws IOException {
        if (creatorRole.equals("Admin") || creatorRole.equals("Receptionist")) {
            if (userType.equals("Patient")) {

                // write patient data to DB files
                File userDBFile = new File("src/sample/fileDatabase/"+userType+"DB.txt");
                FileWriter fw1 = new FileWriter(userDBFile,true);

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
                bw2.close();;
                fw1.close();

            } else if (userType.equals("Receptionist")) {
                System.out.println("A receptionist");
            }
        }
    }

    // view user details function
    public static ArrayList<User> viewUser(String viewerRole, String userType) throws IOException {
        ArrayList<User> userArraylist = new ArrayList<User>();
        if (viewerRole.equals("Admin") || viewerRole.equals("Receptionist")) {
            if (userType.equals("Patient")) {
                String currentLine;

                File userDBFile = new File("src/sample/fileDatabase/"+userType+"DB.txt");
                FileReader fr = new FileReader(userDBFile);
                BufferedReader br = new BufferedReader(fr);


                while ((currentLine = br.readLine()) != null){

                        Patient readPatient = new Patient();
                        String decryptedText = Crypto.decrypt(currentLine);
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




}
