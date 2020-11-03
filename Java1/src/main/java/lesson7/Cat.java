package lesson7;

public class Cat {
    private String name;
    private int appetite;
    private boolean satiety;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
        satiety = false;
    }

    public void eat(Plate p) {
        if (satiety){
            System.out.println("The cat " + name + " is not hungry");
            return;
        }
        if(p.decreaseFood(appetite))
            satiety = true;
    }

    public void setSatiety(boolean satiety) {
        this.satiety = satiety;
    }

    public boolean getSatiety() {
        return satiety;
    }

    public String getName() {
        return name;
    }
}
