package turing;

public class Human extends Animal {
    private Cat cat;
    private Dog dog;

    public Human(String name, int weight, String gender, String color, int age, Cat cat, Dog dog) {
        super(name, weight, gender,color, age);
        this.cat = cat;
        this.dog = dog;

    }

    public Cat getCat() {
        return cat;
    }

    public void setCat(Cat cat) {
        this.cat = cat;
    }

    public Dog getDog() {
        return dog;
    }

    public void setDog(Dog dog) {
        this.dog = dog;
    }

    @Override
    public String toString() {
        return "Human{" +
                "Person=" + super.toString() +
                "  Cat=" + cat +
                ", Dog=" + dog +
                '}';
    }
}
