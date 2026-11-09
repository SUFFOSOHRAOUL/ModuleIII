package FinalProject;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Scanner;

public class MoodTracker {

    public static void main(String s[]){


        Scanner scanner = new Scanner(System.in);
        ArrayList<Mood> moodList = new ArrayList<>();
        while(true){
            System.out.println("\n Enter the letter corresponding to the operation you want to do:\na : Add\nd : Delete \ne : edit \ns : search \nexit : to exit application ");
            String userInput = scanner.nextLine();
            switch(userInput){
                case "a": {
                    System.out.println("Enter the moods name: \n");
                    String name = scanner.nextLine();
                    LocalDate date = LocalDate.now();
                    LocalTime time = LocalTime.now();
                    System.out.println("Enter the note: \n");
                    String note = scanner.nextLine();
                    Mood myMood = new Mood(name, date, time, note);
                    for( Mood mood:moodList){
                        if (mood.equals(myMood)){
                            System.out.println("Mood already exist");
                        }else{
                            moodList.add(myMood);
                        }
                    }
                }

            break;
                case "d": {
                    System.out.println("Enter the index of the mood you to delete");

                    int id = Integer.parseInt(scanner.nextLine());
                    if (id > moodList.size()) {
                        System.out.println("invalid input, try again");

                    } else {
                        moodList.remove(id);
                    }
                }
                    break;
                case "e": {
                    System.out.println("enter the index of the mood you want to update");
                    int id = Integer.parseInt(scanner.nextLine());
                    if (id > moodList.size()) {
                        System.out.println("invalid input, try again");

                    } else {
                        System.out.println("Enter the moods name: \n");
                        String name = scanner.nextLine();
                        LocalDate date = LocalDate.now();
                        LocalTime time = LocalTime.now();
                        System.out.println("Enter the  note: \n");
                        String note = scanner.nextLine();
                        Mood newMood = new Mood(name, date, time, note);
                        moodList.set(id,newMood);
                    }

                }
                  break;
                case"s": {
                    System.out.println("Enter the moods name: \n");
                    String name = scanner.nextLine();
                    Optional<Mood> match = moodList.stream().filter(mood -> mood.getName().equals(name)).findAny();
                    if (match.isPresent()) {
                        System.out.println("Found mood " + match.toString()); // Output: Bob
                    } else {
                        System.out.println("mood not found.");
                    }

                }
                case "Exit":{
                    System.out.println("Thank you for using the MoodTracker. Goodbye!");
                    break;
                }
                default:{
                    System.out.println("Not a valid input!");
                    continue;
                }
            }

        }
    }
}