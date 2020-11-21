package lesson1;

public class Cat implements Dodge{
    private int maxDistance;
    private int maxJump;

    public Cat(int maxDistance, int maxJump) {
        this.maxDistance = maxDistance;
        this.maxJump = maxJump;
    }

    public boolean run(int distance){
        boolean flag = false;
        if (maxDistance > distance && maxDistance > 0) {
            System.out.println("Cat is running " + distance);
            flag = true;
        }
        else {
            System.out.println("Reached max Distance");
        }
        maxDistance-=distance;
        return flag;
    }
    public boolean jump(int height){
        boolean flag = false;
        if (maxJump > height && maxJump > 0) {
            System.out.println("Cat is jumping " + height);
            flag = true;
        }
        else {
            System.out.println("Reached max Height");
        }
        maxJump-=height;
        return flag;

    }
}
