package sample.models;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;

public class Ratings {

    private String ratedUsername;
    private double rating;
    private LocalDate thoughtAddedDate;
    private String thoughts;

    public String getRatedUsername() {
        return ratedUsername;
    }

    public void setRatedUsername(String ratedUsername) {
        this.ratedUsername = ratedUsername;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public LocalDate getThoughtAddedDate() {
        return thoughtAddedDate;
    }

    public void setThoughtAddedDate(LocalDate thoughtAddedDate) {
        this.thoughtAddedDate = thoughtAddedDate;
    }

    public String getThoughts() {
        return thoughts;
    }

    public void setThoughts(String thoughts) {
        this.thoughts = thoughts;
    }


    public static void writeFeedback(Ratings rating) throws IOException {

        File ratingFile = new File("src/sample/fileDatabase/UserRatings.txt");
        FileWriter fw = new FileWriter(ratingFile, true);
        BufferedWriter bw = new BufferedWriter(fw);

        if (!ratingFile.exists()) {
            if (ratingFile.createNewFile()) {
                System.out.println("Created new ratings database file");
            }
        }
        if (ratingFile.length() == 0) {   // check if the file is empty
            bw.write(rating.toString());
        } else {
            bw.write("\n" + rating.toString());
        }
        bw.close();
        fw.close();

    }

    public static ArrayList<Ratings> viewRating(String userName) throws IOException {

        ArrayList<Ratings> ratingArray = new ArrayList<>();
        String currentLine;
        File rateFile = new File("src/sample/fileDatabase/UserRatings.txt");

        FileReader fr = new FileReader(rateFile);
        BufferedReader br = new BufferedReader(fr);

        try {
            while ((currentLine = br.readLine()) != null) {
                Ratings readRating= new Ratings();
                String[] userData = currentLine.split("~");
                if(userData[0].equals(userName)){
                    rateSetter(userData,readRating);
                    ratingArray.add(readRating);
                    break;
                }

            }
        } catch (IOException exception) {
            exception.printStackTrace();

        }
        br.close();
        fr.close();
        return ratingArray;
    }


    //rating edit function
    public static void updateRating(Ratings ratings,String userName) throws IOException {

        File oldFile = new File("src/sample/fileDatabase/UserRatings.txt");
        File tempFile = new File("src/sample/fileDatabase/tempRatings.txt");

        if(tempFile.exists()){
            if(tempFile.delete()){
                System.out.println("TempFile found and deleted");
            }
        }

        FileWriter fw = new FileWriter(tempFile, true);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter pw = new PrintWriter(bw);

        FileReader fr = new FileReader(oldFile);
        BufferedReader br = new BufferedReader(fr);

        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            String[] userData = currentLine.split("~");
            if(userData[0].equals(userName)){
                pw.println(ratings);
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
            System.out.println("Rating record edited successfully");

            File dump = new File("src/sample/fileDatabase/UserRatings.txt");
            if (tempFile.renameTo(dump)) {
                System.out.println("Successfully renamed file");
            } else {
                System.out.println("Error on renaming");
            }
        } else {
            System.out.println("Error on deleting oldRating file");
        }



    }

    private static void rateSetter(String[] userData, Ratings readRating) {
        readRating.setRatedUsername(userData[0]);
        readRating.setRating(Double.parseDouble(userData[1]));
        readRating.setThoughts(userData[2]);
        readRating.setThoughtAddedDate(LocalDate.parse(userData[3]));

    }

    @Override
    public String toString(){
        return ratedUsername+"~"+
                rating+"~"+
                thoughts+"~"+
                thoughtAddedDate;
    }
}
