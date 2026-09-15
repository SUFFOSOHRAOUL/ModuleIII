package org.raoulscode;

import java.util.Scanner;

public class AnimalFarm {

        public static void main(String s[]){

            Scanner scanner = new Scanner(System.in);
            Animal[] myAnimals = new Animal[10];
            int anmlIdx =0;
            while(true){
                System.out.println("press 1 to view the animals, "+"\n2 to add animals. " + "\nany other key to exit");

                String userAction =scanner.nextLine();
            if(userAction.equals("1")){
            for(int i =0; i<myAnimals.length;i++){
            if(myAnimals[i] != null){
                System.out.println(myAnimals[i]);}
            }
            }
             else if (userAction.equals("2")){
                if(anmlIdx==10){
                    System.out.println("10 animals added already. Cannot add any more animals!");
                    continue;
                }
                System.out.println("Which animal do you want to create? \nPress 1 for dog, "+
                        "\n2 for cat "+
                        "\n3 for cow" );
                String animalChoice = scanner.nextLine();
                if(animalChoice.equals ("1")){
                    System.out.println("Enter the name of the dog");
                    String dogName = scanner.nextLine();
                    Animal anmlTmp = new Dog(dogName, "crackers");
                    myAnimals[anmlIdx++] = anmlTmp;
                } else if (animalChoice.equals("2")) {
                    System.out.println("Enter the name of the cat");
                    String catName = scanner.nextLine();
                    Animal anmlTmp = new Cat(catName, "crackers");
                    myAnimals[anmlIdx++] = anmlTmp;
                } else if (animalChoice.equals("3")) {
                    System.out.println("Enter the name of the cow");
                    String cowName = scanner.nextLine();
                    Animal anmlTmp = new Cow(cowName, "crackers");
                    myAnimals[anmlIdx++] = anmlTmp;
                }
            } else {
                break;

                }
            }



        }

}