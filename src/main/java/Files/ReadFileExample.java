package Files;
import java.nio.file.Files;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

public class ReadFileExample {
    public static void main(String[] args){
        Scanner scanner =new Scanner(System.in);

        System.out.println("Enter the name of the file you want to read.");
        Path filePath = Paths.get(scanner.nextLine());

        try{
            String content = Files.readString(filePath);
            System.out.println(content);
        }catch(IOException e){
            System.err.println("Error reading file: " + e.getMessage());
        }

    }
}