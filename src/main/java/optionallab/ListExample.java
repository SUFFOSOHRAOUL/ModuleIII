package optionallab;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class ListExample {
    public static void main(String[] args){
        //creating a list
        List<String> fruits =new ArrayList<>();
        //Adding elements
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        System.out.println("Fruits: "+ fruits);
        //Accessing an el
          String firstFruit = fruits.get(0);
        System.out.println("First fruit: " + firstFruit);


        //linked List

        LinkedList<String> animals = new LinkedList<>();
        animals.add("Dog");
        animals.add("Cat");
        animals.add("Elephant");

        //Sets

        HashSet<String> colors = new HashSet<>();

        colors.add("Red");
        colors.add("Green");
        colors.add("Red");
        System.out.println("Colors: " + colors);
    }
}