package hw2;

public class Dog extends Animal{
    private final String voice;
    private int uniCatValue;
    public Dog(String name, int age, String voice, int uniCatValue) {
        super(name, age);
        this.voice = voice;
        this.uniCatValue = uniCatValue;
    }
    @Override
    public void makeSound() {
        System.out.println("sound:" +voice);
    }
}
