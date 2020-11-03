package lesson6;

public class Test {
    public static void main(String[] args) {
        Cat cat = new Cat("Barsik");
        Dog dog = new Dog("Sharik");

        cat.run(100);
        cat.jump(2);
        cat.swim(10);

        dog.run(300);
        dog.swim(13);
        dog.jump(1);
    }
}
