package Files;

import java.io.File;
import java.util.Scanner;

public class DirectoryExplorer {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the file or directory with the path");
        String fileName = scanner.nextLine();
        File file = new File(fileName);
        if(file.exists()) {
            if (file.isFile()) {
                System.out.println(fileName + " is a file");
            } else {
                System.out.println(fileName + " is a directory");
            }
        }else{
            System.out.println(fileName+ "is a not a valid file or directory");
        }
    }
}