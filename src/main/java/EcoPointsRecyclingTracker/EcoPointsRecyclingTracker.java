package EcoPointsRecyclingTracker;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class EcoPointsRecyclingTracker {
    private static Scanner scanner =  new Scanner(System.in);
    private  static Map<String, HouseHold> households = new HashMap<>();
    public static void main(String[] args){
        boolean running = true;
        loadHouseholdsFromFile();

        while(running){
            System.out.println("\n=== Eco-Points Recycling Tracker ===");
            System.out.println("1. Register Household");
            System.out.println("2. Log Recycling Event");
            System.out.println("3. Display Households");
            System.out.println("4. Display Household Recycling Events");
            System.out.println("5. Generate Reports");
            System.out.println("6. Save and Exit");
            System.out.print("Choose an option: ");

            String choice = scanner. nextLine();
            switch (choice) {
                case "1":
                    registerHousehold();
                    break;
                case "2":
                    logRecyclingEvent();
                    break;
                case "3":
                    displayHouseholds();
                    break;
                case "4":
                    displayHouseholdEvents();
                    break;
                case "5":
                    generateReports();
                    break;
                case "6":
                    saveHouseholdsToFile();
                    running = false;
                    System.out.println("Data saved. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-6.");
            }

        }

    }
    private static void registerHousehold(){
        System.out.println("Enter household ID: ");
        String id = scanner.nextLine().trim();
        if(households.containsKey(id)) {
            System.out.println("Error: Household ID already exists");
            return;
        }
        System.out.println("Enter household name: ");
        String name = scanner.nextLine().trim();
        System.out.println("Enter household address: ");
        String address = scanner.nextLine().trim();

        HouseHold household = new HouseHold(id,name,address);
        households.put(id, household);
        System.out.println("Household registered successfully on " + household.getJoinDate());
    }
    private static  void logRecyclingEvent(){
        System.out.println("Enter household ID: ");
        String id = scanner.nextLine().trim();
        HouseHold household = households.get(id);

        if(household == null){
            System.out.println("Error: Household ID not found");
            return;
        }
        System.out.println("Enter material type (plastic/glass/metal.paper): ");
        String material = scanner.nextLine().trim();
        double weight = 0.0;
        while (true){
            try{
                System.out.println("Enter weight in kilograms: ");
                weight = Double.parseDouble(scanner.nextLine());
                if(weight <=0)throw new IllegalArgumentException();
                break;
            } catch (NumberFormatException e){
                System.out.println("Invalid weight. Must be a positive number");
            }catch(IllegalArgumentException e){
                System.out.println("Invalid weigt. Must be positive number");
            }
        }
        RecyclingEvent event = new RecyclingEvent(material,weight);

        household.addEvent(event);
        System.out.println("Recycling event logged! Points earned: "+ event.getEcoPoints());
    }
    private static void displayHouseholds(){
        if(households.isEmpty()){
            System.out.println("No households registrated.");
            return;
        }
        System.out.println("\nRegistered Households");

        for(HouseHold h : households.values()){
            System.out.println("ID: " + h.getId() +
                    ", Name: " + h.getName() +
                    ", Address: " + h.getAddress() +
                    ", Joined: " + h.getJoinDate());
        }
    }
    private static void displayHouseholdEvents(){
        System.out.println("Enter household ID");
        String id = scanner.nextLine().trim();
        HouseHold houseHold = households.get(id);

        if(houseHold == null){
          System.out.println("Household not found. ");
          return;
        }
        System.out.println("\n Recycling Events for " + houseHold.getName() + ":");

        if (houseHold.getEvents().isEmpty()){
            System.out.println("No event logged. ");
        }else{
            for (RecyclingEvent e : houseHold.getEvents()){
                System.out.println(e);
            }
            System.out.println("Total Weight: " + houseHold.getTotalWeigh() + " kg");
            System.out.println("Total Points: " + houseHold.getTotalPoint() + " pts");
        }
    }
    private static void generateReports(){
        if(households.isEmpty()){
            System.out.println("No Households registered. ");
            return;
        }
        HouseHold top = null;
        for (HouseHold h : households.values()){
            if(top == households.values()){
                if (top == null || h.getTotalPoint() > top.getTotalPoint()) {
                    top = h;
                }
            }
            System.out.println("\nHousehold with Highest Points:");
            System.out.println("ID: " + top.getId() +
                    ", Name: " + top.getName() +
                    ", Points: " + top.getTotalPoint());

        }
        double totalWeight = 0.0;
        for (HouseHold h : households.values()) {
            totalWeight += h.getTotalWeigh();
        }
        System.out.println("Total Community Recycling Weight: " + totalWeight + " kg");
    }
    private static void saveHouseholdsToFile(){
        try{
            ObjectOutputStream out = new ObjectOutputStream( new FileOutputStream("households.ser"));
            out.writeObject(households);
        }catch (IOException e){
            System.out.println("Error saving data: "+ e.getMessage());
        }
    }
    @SuppressWarnings("unchecked")
    private static void loadHouseholdsFromFile() {
        try (

                ObjectInputStream in = new ObjectInputStream(new FileInputStream("households.ser"))
        ) {
            households = (Map<String, HouseHold>) in.readObject();

            System.out.println("Household data loaded.");
        } catch (FileNotFoundException e) {

            System.out.println("No saved data found. Starting fresh.");
        } catch (IOException | ClassNotFoundException e) {
            // Handle other errors, like if the file is corrupted or unreadable
            System.out.println("Error loading data: " + e.getMessage());
        }
    }


}