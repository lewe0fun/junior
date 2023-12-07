package hw2;

public class Cat extends Animal {
    private final String voice;
    private String uniqCatValue;

    public Cat(String name, int age, String voice, String uniqCatValue) {
        super(name, age);
        this.voice = voice;
        this.uniqCatValue = uniqCatValue;
    }

    @Override
    public void makeSound() {
        System.out.println("cat say:"+voice);
    }
}
