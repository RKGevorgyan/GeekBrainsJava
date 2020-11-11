package lesson7;

public class MainClass {
    public static void main(String[] args) {
        Plate plate = new Plate(52);
        Cat[] cats = new Cat[10];

        cats[0] = new Cat("Barsik",5);
        cats[1] = new Cat("Akira",6);
        cats[2] = new Cat("Bleu",7);
        cats[3] = new Cat("Cleo",8);
        cats[4] = new Cat("Diva",9);
        cats[5] = new Cat("Jewel",5);
        cats[6] = new Cat("Latte",6);
        cats[7] = new Cat("Sahara",7);
        cats[8] = new Cat("Shadow",8);
        cats[9] = new Cat("Sheba",4);

        for (Cat cat : cats){
            cat.eat(plate);
            System.out.println(cat.getName() + " Satiety: " + cat.getSatiety());
        }
        plate.info();
        plate.addFood(20);
        plate.info();
    }
}
