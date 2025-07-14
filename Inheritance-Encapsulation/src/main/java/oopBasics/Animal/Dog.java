package oopBasics.Animal;

public class Dog extends Animal {

    public Dog(String name, int weight, String gender, String color, int age) {
        super(name, weight, gender, color, age);
    }


    public void sound(){
        System.out.println("Hav hav");
    }

}
