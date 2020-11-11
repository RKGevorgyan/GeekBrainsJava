package lesson7;

public class Plate {
    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public void addFood(int n){
        food += n;
    }

    public boolean decreaseFood(int n) {
        if (n > food || food == 0){
            System.out.println("Not enough food");
            return false;
        }
        if ((food-n) >= 0)
        food -= n;
        return true;
    }

    public void info() {
        System.out.println("plate: " + food);
    }
}
