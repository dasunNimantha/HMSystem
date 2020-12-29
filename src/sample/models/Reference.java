package sample.models;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Reference {

    public static ArrayList<String> returnReference(String referenceModuleFile) throws IOException {
        File MOSpeciality = new File("src/sample/fileDatabase/reference/" + referenceModuleFile + ".txt");
        FileReader fr = new FileReader(MOSpeciality);
        BufferedReader br = new BufferedReader(fr);
        ArrayList<String> complainType = new ArrayList<>();

        String currentLine;
        while ((currentLine = br.readLine()) != null) {
            String decryptedLine = Crypto.decrypt(currentLine);
            assert decryptedLine != null;
            complainType.add(decryptedLine);

        }
        br.close();
        fr.close();
        return complainType;
    }




}
