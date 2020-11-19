package lesson1;

public class Test {
    public static void main(String[] args) {
        Dodge dodge[] = new Dodge[5];
        dodge[0] = new Human(1400,3);
        dodge[1] = new Robot(4300,4);
        dodge[2] = new Cat(600,5);
        dodge[3] = new Human(2100,2);
        dodge[4] = new Robot(3500,5);

        Obstacle obstacle[] = new Obstacle[11];
        obstacle[0] = new Treadmill(100);
        obstacle[1] = new Wall(1);
        obstacle[2] = new Treadmill(20);
        obstacle[3] = new Wall(2);
        obstacle[4] = new Treadmill(15);
        obstacle[5] = new Wall(1);
        obstacle[6] = new Treadmill(79);
        obstacle[7] = new Treadmill(54);
        obstacle[8] = new Wall(3);
        obstacle[9] = new Treadmill(120);
        obstacle[10] = new Wall(4);

        for (Dodge d : dodge)
            for (Obstacle o : obstacle){
                if (o.getClass() == Treadmill.class)
                    if (d.run(((Treadmill) o).getDistance())){}

                if (o.getClass() == Wall.class)
                    if(d.jump(((Wall) o).getHeight())){}
            }
    }
}
