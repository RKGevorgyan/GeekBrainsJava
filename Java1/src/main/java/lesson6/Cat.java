package lesson6;

public class Cat extends Animal {

    public Cat(String name){
        runDistance = (float) (300-Math.random()*200);
        high = (float) (5-Math.random()*4);
        this.name = name;
    }

    @Override
    public void swim(float swimDistance) {
        System.out.println("Cat's can't swim!");
    }
}
