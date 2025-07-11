package oopBasics;


public class MainApp {
    public static void main(String[] args) {
        Cat cat =new Cat("Felix",8,"Male","White",2);
        Dog dog =new Dog("Thomas",15,"Male","Gray",4);

        Woman woman = new Woman("Alexa",60,"Female","Olive",24, cat,null);
        Man man = new Man("John",85,"Male","Light",27,null, dog);

        System.out.println(woman);
        System.out.println(man);
    }
}