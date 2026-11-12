package PetCareScheduler;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class PetCareScheduler {
   private static Scanner scanner = new Scanner(System.in);
    private static Map<String, Pet> petList = new HashMap<>();
    private static List<Appointment> appointments = new ArrayList<>();
    public static void main(String[] args){
        Boolean running = true;
        loadPetdata();
        while(running){
            System.out.println("welcome to PetCare");
            System.out.println( "what transaction do you wish to carry out? \nEnter: \n1" +
                    " to register pets\n2 to book appointment \n3 to display record" +"\n4 save data"+
                    " \n5 to generate report \n6 to save and exit");
            String usersChoice = scanner.nextLine();
            switch (usersChoice){
                case "1":
                    registerPet();
                    break;

                case "2":
                    bookAppointment();
                    break;
                case "3":
                    displayRecord();
                    break;
                case "4":
                    savedata();
                    break;
                case "5":
                    generateReport();
                    break;
                case "6":
                    savedata();
                    running = false;
                    break;
                default:
                    System.out.println("Invalid choice. Please select 1-6.");

            }

        }


    }

    private static void generateReport() {
    }

    private static void registerPet(){
        System.out.println("Enter Id");
        String id = scanner.nextLine();
        System.out.println("Enter name");
        String name = scanner.nextLine();
        System.out.println("Enter pet owner");
        String owner = scanner.nextLine();
        System.out.println("Enter pet Breed");
        String breed = scanner.nextLine();
        System.out.println("Enter pet Age");
        int age = scanner.nextInt();
        System.out.println("Enter pet Contact info");
        String contactInfo = scanner.nextLine();


        Pet pet = new Pet(id,name,breed,age,contactInfo,owner);
        petList.put(id, pet);
        System.out.println("pet successfully added");


    }
    private static void bookAppointment(){
        System.out.println("Enter pet Id");
        String id = scanner.nextLine().trim();
        Pet pet = petList.get(id);
        if(pet == null){
            System.out.println("Error: pet not found, Register pet first");
            return;
        }
        System.out.println("Enter appointment type(Vet/ Visit/ Vaccination/grooming)");
        String appointmentType = scanner.nextLine();
        System.out.println("Enter appointment date in the format DD/MM/YYYY");
        String date = scanner.nextLine();
        System.out.println("Enter appointment time HH/MM/SS");
        String time = scanner.nextLine();
        Appointment appointment = new Appointment(appointmentType,date,time);
        pet.addAppointment(appointment);
        appointments.add(appointment);
    }

    private static void loadPetdata(){
        try(
                ObjectInputStream in = new ObjectInputStream(new FileInputStream("petdata.ser"))
                ){
            petList = (HashMap<String, Pet>)  in.readObject();
            System.out.println("List of pet loaded");
        } catch (FileNotFoundException e) {
            System.out.println("No saved data found. Starting fresh.");
        }catch (IOException|ClassNotFoundException e){
            System.out.println("Error loading data: " + e.getMessage());
        }
    }
    private static void savedata(){
        try{
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("petdata.ser"));
            out.writeObject(petList);
        }catch (IOException e){
            System.out.println("Error saving data"+ e.getMessage());
        }
    }
    private static  void displayRecord(){
        System.out.println("Enter pet ID");
        String id = scanner.nextLine().trim();
        Pet pet = petList.get(id);
        if(pet ==null){
            System.out.println("Pet not found");
            return;
        }
        System.out.println("\n Pet "+pet.getName()+":");
        if (pet.getAppointmentsList().isEmpty()){
            System.out.println("appointment list is empty");
        }else{
            for(Appointment a : pet.getAppointmentsList()){
                System.out.println(a);
            }
        }
    }
}