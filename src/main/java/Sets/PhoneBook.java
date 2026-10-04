package Sets;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Scanner;
import java.util.TreeMap;

public class PhoneBook {
    private static boolean isNameValid(String name) {
        if (name.matches("^[a-zA-Z' -]+$") == false) {
            System.out.println("Invalid name!");
            return false;
        }
        return false;
    }

    private static boolean isPhoneNumberValid(String phoneNumber) {
        if (phoneNumber.matches("\\+?\\d{1,4}?[-.\\s]?\\(?\\d{1,3}?\\)?[-.\\s]?\\d{1,4}[-.\\s]?\\d{1,9}") == false) {
            System.out.println("Invalid phone number!");
            return false;
        }
        return true;
    }

    public static void main(String s[]) {
        try {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, String> phonebook = new HashMap<>();

            while (true) {
                System.out.println("Press 1 to add an entry in the phonebook," +
                        "\n2 to view all the entries" +
                        "\n3 to search for entries with name" +
                        "\n4 to delete an entry" +
                        "\n5 to sort the entries by name" +
                        "\n6 to write the entries onto a file" +
                        "\nAny other key to exit");
                String userAction = scanner.nextLine();

                if (userAction.equals("1")) {
                    System.out.println("Enter a name");
                    String name = scanner.nextLine();

                    if (!isNameValid(name)) {
                        continue;

                    }
                    if (phonebook.containsKey(name)) {
                        System.out.println("This name already exists! Do you want to replace the number? y/n");
                        String repChoice = scanner.nextLine();
                        // If the user chooses not to replace, skip to the next iteration
                        if (repChoice.equalsIgnoreCase("n")) {
                            continue;
                        }
                    }
                    System.out.println("Enter the phone number");
                    String phoneNumber = scanner.nextLine();
                    if (!isPhoneNumberValid(phoneNumber)) {
                        continue;
                    }
                    phonebook.put(name, phoneNumber);
                    System.out.println("The name and number have been added to the phonebook.");
                } else if (userAction.equals("2")) {
                    for (String name : phonebook.keySet()) {
                        System.out.println(name + ": " + phonebook.get(name));
                    }
                }

                else if (userAction.equals("3")) {
                    System.out.println("Enter the name you want to search");
                    String keyName = scanner.nextLine();
                    // Check if the name exists in the phonebook
                    if (phonebook.containsKey(keyName)) {
                        // Display the phone number associated with the name
                        System.out.println("The phone number you are looking for is " +
                                phonebook.get(keyName));
                    } else {
                        System.out.println("No such name found in the phonebook.");
                    }
                }
                // Option 4: Delete an entry by name
                else if (userAction.equals("4")) {
                    // Prompt the user to enter the name to delete
                    System.out.println("Enter the name you want to delete ");
                    String keyName = scanner.nextLine();
                    // Check if the name exists in the phonebook
                    if (phonebook.containsKey(keyName)) {
                        // Remove the entry from the HashMap
                        phonebook.remove(keyName);
                        System.out.println("The entry has been removed.");
                    } else {
                        System.out.println("No such name found in the phonebook.");
                    }
                }
                // Option 5: Sort the entries by name
                else if (userAction.equals("5")) {
                    // Sort the phoneBook by keys using TreeMap
                    TreeMap phoneBookTreeMap = new TreeMap<String,String>(phonebook);
                    for (Object keyName : phoneBookTreeMap.keySet()) {
                        System.out.println(keyName + ": " + phoneBookTreeMap.get((String)keyName));
                    }
                }
                // Option 6: Write the entries to a text file
                else if (userAction.equals("6")) {
                    // Write the Phonebook entries to a file
                    try (PrintWriter writer = new PrintWriter(new FileWriter("phonebook.txt"))) {
                        for (String name : phonebook.keySet()) {
                            writer.println(name + ": " + phonebook.get(name));
                        }
                        System.out.println("The entries are written to a file");
                    } catch (IOException e) {
                        System.err.println("Error writing to file: " + e.getMessage());
                    }
                }
                // Exit the program if the user enters any other key
                else {
                    break;
                }
            }
        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }
}