package Files;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

public class ReadFileExampleWithScanner {
    public static void main(String args){
        try{
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter the name of the new file you want to read");
            Scanner fileScanner = new Scanner (new FileReader(scanner.nextLine()));
                while(fileScanner.hasNext()){
                    String fileLine = fileScanner.nextLine();
                    System.out.println(fileLine);
                }
                fileScanner.close();
            }catch (FileNotFoundException e){
            System.err.println("Error reading file: " + e.getMessage());
        }

    }
}