package Files;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DirectoryExplorer {
    private static void fileManagement(File file) {
        // Display options to the user
        System.out.println("\nPress 1 to rename the file," +
                "\nPress 2 to delete the file," +
                "\nAny other key to exit");

        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        // Handle user choice
        if (userChoice.equals("1")) {
            // Get new name for the file
            System.out.println("Enter the new name for the file " + file.getName());
            String newfileName = scanner.nextLine();
            // Attempt to rename the file
            boolean changed = file.renameTo(new File(file.getParent(), newfileName));
            //Print message about success or failure of file renaming
            if (changed) {
                System.out.println("Filename successfully changed");
            } else {
                System.out.println("Filename couldn't be changed!");
            }
        } else if (userChoice.equals("2")) {
            // Delete the file
            boolean deleted = file.delete();
            //Print message about success or failure of file deletion
            if (deleted) {
                System.out.println("Filename successfully deleted");
            } else {
                System.out.println("Filename couldn't be deleted!");
            }
        }
    }

    // Method to handle directory management operations (list, rename, or delete)
    private static void directoryManagement(File dirObj) {
        // Display options to the user
        System.out.println("\nPress 1 to list the directory," +
                "\nPress 2 to rename the directory," +
                "\nPress 3 to delete the directory," +
                "\nAny other key to exit");

        Scanner scanner = new Scanner(System.in);
        String userChoice = scanner.nextLine();

        // Handle user choice
        if (userChoice.equals("1")) {
            // List the contents of the directory
            String fileNames[] = dirObj.list();
            if (fileNames.length == 0) {
                System.out.println("The directory is empty!");
            } else {
                for (int i = 0; i < fileNames.length; i++) {
                    System.out.println(fileNames[i]);
                }
            }
        } else if (userChoice.equals("2")) {
            // Rename the directory
            System.out.println("Enter the new name for the directory " + dirObj.getName());
            String newDirName = scanner.nextLine();
            // Attempt to rename the directory
            boolean changed = dirObj.renameTo(new File(dirObj.getParent(), newDirName));
            //Print message about success or failure of dir renaming
            if (changed) {
                System.out.println("Directory name successfully changed");
            } else {
                System.out.println("Directory name couldn't be changed!");
            }
        } else if (userChoice.equals("3")) {
            // Delete the directory
            boolean deleted = dirObj.delete();
            //Print message about success or failure of dir deletion
            if (deleted) {
                System.out.println("Directory successfully deleted");
            } else {
                System.out.println("Directory couldn't be deleted! It might not be empty");
            }
        }
    }


    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
       while(true){
           System.out.println("\nPress 1 for File Management, "+ "\nAny other key to exit");
           String userAction = scanner.nextLine();

           if (userAction.equals("1")){
               System.out.println("Enter the name of the file or directory with the path");
               String fileName = scanner.nextLine();
               File file = new File(fileName);

               if(file.exists()) {
                   if (file.isFile()) {
                       System.out.println(fileName + " is a file");
                       fileManagement(file);
                   } else {
                       System.out.println(fileName + " is a directory");
                       directoryManagement(file);
                   }
               }else{
                   System.out.println(fileName+ " is a not a valid file or directory");
                   System.out.println("To create a file with given name press 1\n"
                           + "To create a directory with given name press 2\n"
                           + "To do nothing and continue, press any other key");

                   String createChoice = scanner.nextLine();

                   if(createChoice.equals("1")){
                       String parentDirStr = file.getParent();
                       File parentDir = new File(parentDirStr);

                       if(!parentDir.exists()){
                           boolean created = parentDir.mkdirs();
                           if(!created){
                               System.out.println("the parent directory could not be created");
                               continue;
                           }
                       }
                       try{
                           file.createNewFile();
                           System.out.println("File Successfully created!");
                       }catch (IOException ioe){
                           System.out.println("unable to create file. " + ioe.getMessage());
                       }
               } else if (createChoice.equals("2")) {
                       boolean created = file.mkdir();
                       if (created) {
                           System.out.println("The directory has been created");
                       } else {
                           System.out.println("The directory couldn't be created");
                       }

                   }
               }
           }else {
               System.out.println("Bye!");
               break;
           }

       }
    }
}