package Sets;

import List.Task;

import java.util.HashMap;
import java.util.Scanner;

public class TaskSet {
    public static void main(String s[]) {

        try {
            Scanner scanner = new Scanner(System.in);
            HashMap<String, Task> taskList = new HashMap<>();

            while (true) {
                System.out.println("Press 1 to add an entry in the TaskList," +
                        "\n2 to view all the Tasks" +
                        "\n3 to search for entries with task name" +
                        "\n4 to delete an Task" +
                        "\nAny other key to exit");
                String userAction = scanner.nextLine();
                if (userAction.equals("1")) {
                    System.out.println("Enter a the task name.");
                    String taskName = scanner.nextLine();

                    if (taskList.containsKey(taskName)) {
                        System.out.println("This name already exists! Do you want to replace the task? y/n");
                        String repChoice = scanner.nextLine();
                        // If the user chooses not to replace, skip to the next iteration
                        if (repChoice.equalsIgnoreCase("n")) {
                            continue;
                        }
                    }
                    System.out.println("Enter the task Description");
                    String taskDescription = scanner.nextLine();

                    System.out.println("Enter the task priority");
                    String taskPriority = scanner.nextLine();

                    System.out.println("Enter the Status");
                    String taskStatus = scanner.nextLine();
                    Task task = new Task(taskName,taskDescription,taskPriority,taskStatus);

                    taskList.put("Morning Routing",task );


                    System.out.println("The name and number have been added to the phonebook.");
                } else if (userAction.equals("2")) {
                    for (String name :taskList.keySet()) {
                        System.out.println(name + ": " + taskList.get(name));
                    }
                }

                else if (userAction.equals("3")) {
                    System.out.println("Enter the name you want to search");
                    String keyName = scanner.nextLine();
                    // Check if the name exists in the phonebook
                    if (taskList.containsKey(keyName)) {
                        // Display the phone number associated with the name
                        System.out.println("The phone number you are looking for is " +
                                taskList.get(keyName));
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
                    if (taskList.containsKey(keyName)) {
                        // Remove the entry from the HashMap
                        taskList.remove(keyName);
                        System.out.println("The entry has been removed.");
                    } else {
                        System.out.println("No such name found in the phonebook.");
                    }
                }

            }

        } catch (NumberFormatException nfe) {
            System.out.println("Invalid input. Please enter a valid number.");
        }
    }




    public static class Task {
        private String name;
        private String description;
        private String priority;
        private String status;

        public Task(String name, String status, String priority, String description) {
            this.name = name;
            this.status = status;
            this.priority = priority;
            this.description = description;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public String getPriority() {
            return priority;
        }

        public void setPriority(String priority) {
            this.priority = priority;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @Override
        public String toString() {
            return "Task{" +
                    "name='" + name + '\'' +
                    ", description='" + description + '\'' +
                    ", priority='" + priority + '\'' +
                    ", status='" + status + '\'' +
                    '}';
        }
    }
}