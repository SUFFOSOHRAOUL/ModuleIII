package org.raoulscode;

public class Animal {
    private String name;
    private String food;
    public Animal(String name, String food){
        this.name =name;
        this.food = food;
    }

    public String sound(){
        return null;
    }
    public void setFood(String foodName){
        this.food = foodName;
    }
    public String getName(){
        return this.food;
    }

    public String toString(){
        return name.concat("says").concat(sound()).concat("I like eating "+ this.food);
    }
}

class Dog extends Animal{
    public Dog(String name,String food){
        super(name,food );
    }

    public String sound(){
        return "Woof";
    }
}
class Cat extends Animal{
    public Cat (String name, String food){
        super(name,food );
    }
    public String sound(){
        return "Moew";
    }
}
class Cow extends Animal{
    public Cow (String name ,String food){
        super(name,food );

    }
    public String sound(){
        return "Moo";
    }
}