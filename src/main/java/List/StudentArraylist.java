package List;

import java.util.*;

public class StudentArraylist {
    public static void main(String s[]){
        try{
            Scanner scanner =new Scanner(System.in);
            ArrayList<Student> studentList = new ArrayList<Student>();
           while(true){
               System.out.println(
                       "Press 1 to add a student, " +
                               "\n2 to view all the student " +
                               "\n3to delete a student " +
                               "\n4 to sort the student based on age" +
                               "\nAny other key to exit");
            String userAction = scanner.nextLine();
            if(userAction.equals("1")){
                System.out.println("Enter Students name");
                String name = scanner.nextLine();
                System.out.println("Enter Students age");
                int age= Integer.parseInt(scanner.nextLine());
                System.out.println("Enter Students Major");
                String major= (scanner.nextLine());
                studentList.add(new Student(name,major,age));
            }else if (userAction.equals("2")){
                studentList.forEach(student->System.out.println(student));
            }else if(userAction.equals("3")){

                System.out.println("enter the index of the student u want to delete");
                int delIdx= Integer.parseInt(scanner.nextLine());
                if(delIdx >  (studentList.size()-1)){
                    System.out.println("there is no student with that index");
                }else studentList.remove(delIdx);

            }else if(userAction.equals("4")){
                Collections.sort(studentList,new Comparator<Student>(){
                    @Override
                    public int compare(Student s1, Student s2){
                        return Integer.compare(s1.getAge(), s2.getAge());
                    }


                });
                System.out.println("New sorted list is");
                studentList.forEach(student -> System.out.println(student));
            }

           }
        }catch(NumberFormatException nfe){
            System.out.println("Invalid input. Please enter a valid number");
        }

    }
}