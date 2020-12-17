package lesson1.fruits;

public class Apple extends Fruit {
    private static final float weight = 1.0f;

    @Override
    public float getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Apple";
    }
}
