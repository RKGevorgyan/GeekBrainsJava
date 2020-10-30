package lesson6;

public class Dog extends Animal {

    public Dog(String name){
        this.name = name;
        runDistance = (float) (700-Math.random()*200);
        swimDistance = (float) (20-Math.random()*10);
        high = (float) (1.5-Math.random()*0.5);
    }
}
