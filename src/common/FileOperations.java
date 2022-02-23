package common;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class FileOperations {

    public static boolean saveData(String fileName, String data){
        try {
            File file = new File(fileName);
            FileWriter fr = new FileWriter(file, true);

            fr.write(data);
            fr.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public static List<String> readData(String fileName) throws Exception {
        List<String> lines = Collections.emptyList();
        try
        {
            lines = Files.readAllLines(Paths.get(fileName), StandardCharsets.UTF_8);
        }
        catch (IOException e)
        {
            throw new Exception("Error while reading from file");
        }
        return lines;
    }

    public static boolean renameFile(String originalFile, String updatedFile){
        try{
            File org = new File(originalFile);
            File updated = new File(updatedFile);

            deleteFile(originalFile);
            updated.renameTo(org);
            return true;
        } catch (Exception ex){
            System.out.println("Error while renaming file");
            return false;
        }
    }

    public static void deleteFile(String fileName){
        try{
            File file = new File(fileName);
            Files.deleteIfExists(file.toPath());
        } catch (Exception ex){
            System.out.println("Error while deleting file-"+fileName);
        }
    }
}
