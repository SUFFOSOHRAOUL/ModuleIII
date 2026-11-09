package FinalProjectCorrection;


import FinalProject.Mood;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class MmoodTracker {
    public  static  void main (String[] args){
        ArrayList<Mmood> myMoodList = new ArrayList() ;
        Scanner scanner = new Scanner(System.in);

        while(true) {
            System.out.println("Press 'a' to add mood\n" +
                    "'d' to delete mood(s)\n" +
                    "'e' to edit mood\n" +
                    "'s' to search for moods\n" +
                    "'M' to get all moods\n" +
                    "'w' to write the moods to a file\n" +
                    "Type 'Exit' to exit");
            String menuOption = scanner.nextLine();
            switch(menuOption) {
                case "a":    //add code to add mood

                    System.out.println("Enter the mood name");
                    String mmoodName = scanner.nextLine();
                    System.out.println("Are you tracking the mood for a current day? y/n");
                    String isForCurrentDate = scanner.nextLine();
                    Mmood mmoodToAdd = null;
                    if (isForCurrentDate.equalsIgnoreCase("n")) {
                        try {
                            System.out.println("Input the date in MM/dd/yyyy format:");
                            String mmoodDateStr = scanner.nextLine();
                            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                            LocalDate mmoodDate = LocalDate.parse(mmoodDateStr, dateFormatter);
                            System.out.println("Input the time in HH:mm:ss format:");
                            String mmoodTimeStr = scanner.nextLine();
                            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            LocalTime mmoodTime = LocalTime.parse(mmoodTimeStr, timeFormatter);
                            System.out.println("Add notes about thi mood");
                            String mmoodNotes = scanner.nextLine();
                            if (mmoodNotes.strip().equalsIgnoreCase("")) {
                                mmoodToAdd = new Mmood(mmoodName, mmoodDate, mmoodTime);
                            } else {
                                mmoodToAdd = new Mmood(mmoodName, mmoodDate, mmoodTime, mmoodNotes);
                            }
                        } catch (DateTimeParseException dfe) {
                            System.out.println("Incoreect format of date or time. Cannot create mood. \n" + dfe);
                            continue;
                        }
                    } else {
                        System.out.println("Add noyes about this mood");
                        String mmoodNotes = scanner.nextLine();
                        if (mmoodName.strip().equalsIgnoreCase("")) {
                            mmoodToAdd = new Mmood(mmoodName);
                        } else {
                            mmoodToAdd = new Mmood(mmoodName, mmoodNotes);

                        }
                    }
                    try {
                        boolean isValid = isMoodValid(mmoodToAdd, myMoodList);
                        if (isValid) {
                            myMoodList.add(mmoodToAdd);
                            System.out.println("the mood has been added to the tracker");
                            continue;
                        }
                    } catch (InvalidMmoodException ime) {
                        System.out.println("The mood is not valid");
                    }
                    continue;
                case "d":    //add code to delete mood
                    System.out.println("Enter '1' to delete all moods by date\n" +
                            "Enter '2' to delete a specific mood");
                    String deleteVariant = scanner.nextLine();
                    if(deleteVariant.equals("1")){

                    try {
                        System.out.println("Enter the Date of the Moods you want to delete in the format MM/dd/yyyy");
                        String dateString = scanner.nextLine();
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        LocalDate moodDate = LocalDate.parse(dateString, dateFormatter);
                        boolean areMoodsDeleted = deleteMoods(moodDate, myMoodList);
                        if (areMoodsDeleted) {
                            System.out.println("The moods have been deleted");
                        } else {
                            System.out.println("No matching moods found");
                        }

                    } catch (DateTimeParseException dfe) {
                        System.out.println("The moods have been deleted");
                        continue;
                    }
            }else if (deleteVariant.equals("2")){
                        try{
                        System.out.println("Enter the mood name");
                        mmoodName = scanner.nextLine();
                        System.out.println("Input the date in MM/dd/yyyy format:");
                        String moodDateStr = scanner.nextLine();
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                        System.out.println("Input the time in HH:mm:ss format:");
                        String moodTimeStr = scanner.nextLine();
                        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);
                        Mmood delMood = new Mmood(mmoodName, moodDate, moodTime);
                        boolean isMoodDeleted = deleteMoods(delMood,myMoodList);
                        if(isMoodDeleted) {
                            System.out.println("The mood has been deleted");
                        } else {
                            System.out.println("No matching mood found");
                        }
                    } catch (DateTimeParseException dfe) {
                    System.out.println("Incorrect format of date or time. Cannot delete mood.");
                    continue;
                }
                    }

                    continue;
                case "e": 	//add code to edit mood
                    Mmood moodToEdit = null;
                    try {
                        System.out.println("Enter the mood name");
                        mmoodName = scanner.nextLine();
                        System.out.println("Input the date in MM/dd/yyyy format:");
                        String moodDateStr = scanner.nextLine();
                        DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                        LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                        System.out.println("Input the time in HH:mm:ss format:");
                        String moodTimeStr = scanner.nextLine();
                        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                        LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);
                        System.out.println("Add new notes about this mood");
                        String moodNotes = scanner.nextLine();
                        if(moodNotes.strip().equalsIgnoreCase("")) {
                            System.out.println("No notes entered");
                            continue;
                        } else {
                            moodToEdit = new Mmood(mmoodName, moodDate, moodTime, moodNotes);
                            boolean isMoodEdited = editMood(moodToEdit, myMoodList);
                            if(isMoodEdited) {
                                System.out.println("The mood has been successfully edited");
                            } else {
                                System.out.println("No matching mood could be found");
                            }
                        }
                    } catch (DateTimeParseException dfe) {
                        System.out.println("Incorrect format of date or time. Cannot create mood.");
                        continue;
                    }

                    continue;
                case "s":
                    System.out.println("Enter '1' to search for all moods by date\n"+
                            "Enter '2' to search for a specific mood");
                    String searchVariant = scanner.nextLine();
                    if(searchVariant.equals("1")) {
                        try {
                            System.out.println("Input the date in MM/dd/yyyy format:");
                            String moodDateStr = scanner.nextLine();
                            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                            LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                            searchMoods(moodDate, myMoodList);
                        } catch (DateTimeParseException dfe) {
                            System.out.println("Incorrect format of date. Cannot search mood.");
                            continue;
                        }
                    } else if (searchVariant.equals("2")) {
                        try {
                            System.out.println("Enter the mood name");
                            mmoodName = scanner.nextLine();
                            System.out.println("Input the date in MM/dd/yyyy format:");
                            String moodDateStr = scanner.nextLine();
                            DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
                            LocalDate moodDate = LocalDate.parse(moodDateStr, dateFormatter);
                            System.out.println("Input the time in HH:mm:ss format:");
                            String moodTimeStr = scanner.nextLine();
                            DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
                            LocalTime moodTime = LocalTime.parse(moodTimeStr, timeFormatter);
                            Mmood delMood = new Mmood(mmoodName, moodDate, moodTime);
                            searchMoods(delMood, myMoodList);
                        } catch (DateTimeParseException dfe) {
                            System.out.println("Incorrect format of date or time. Cannot search mood.");
                            continue;
                        }
                    }
//add code to search mood

                    continue;
                case "M": 	//add code to get all moods
                    for(Mmood moodObj: myMoodList) {
                        System.out.println(moodObj);
                    }

                    continue;
                case "w":
                    //add code to write mood to a file
                    try (PrintWriter writer = new PrintWriter(new FileWriter("Moods.txt"))) {
                        for (Mmood mood : myMoodList) {
                            writer.println(mood+"\n\n");
                        }
                        System.out.println("The entries are written to a file");
                    } catch (IOException e) {
                        System.err.println("Error writing to file: " + e.getMessage());
                    }


                    continue;
                case "Exit": 	System.out.println("Thank you for using the MoodTracker. Goodbye!");
                    break;
                default: 	System.out.println("Not a valid input!");
                    continue;
            }
        }
    }
    public  static boolean isMoodValid(Mmood mmood, ArrayList<Mmood> myMoodList) throws InvalidMmoodException{
       for (Mmood tempMmood: myMoodList){
           if (tempMmood.equals(mmood)){
               throw new InvalidMmoodException();
           }
       }
       return true;
    }
    public static boolean deleteMoods(LocalDate mmoodate, ArrayList<Mmood> myMoodsList){
        boolean removed = false;
        for(Mmood tempMood: myMoodsList){
            if(tempMood.getDate().equals(mmoodate)){
                myMoodsList.remove(tempMood);
                removed = true;
            }
        }
        return removed;
    }
    public static boolean deleteMoods(Mmood mood, ArrayList<Mmood> myMoodsList){
        boolean removed = false;
        for(Mmood tempMood: myMoodsList){
            if(tempMood.equals(mood)){
                myMoodsList.remove(tempMood);
                removed = true;
            }
        }
        return removed;
    }
    public static boolean editMood(Mmood moodToEdit, ArrayList<Mmood> myMoodList) {
        for(Mmood tempMood: myMoodList) {
            if (tempMood.equals(moodToEdit)) {
                tempMood.setNote(moodToEdit.getNote());
                return true;
            }
        }
        return false;
    }
    public static void searchMoods(LocalDate moodDate, ArrayList<Mmood> moodsList) {
        boolean found = false;
        for(Mmood tempMood: moodsList) {
            if (tempMood.getDate().equals(moodDate)) {
                found = true;
                System.out.println(tempMood);
            }
        }
        if(!found) {
            System.out.println("No matching records could be found!");
        }
    }
    public static void searchMoods(Mmood mood, ArrayList<Mmood> moodsList) {
        boolean found = false;
        for(Mmood tempMood: moodsList) {
            if (tempMood.equals(mood)) {
                found = true;
                System.out.println(tempMood);
            }
        }
        if(!found) {
            System.out.println("No matching records could be found!");
        }
    }

}