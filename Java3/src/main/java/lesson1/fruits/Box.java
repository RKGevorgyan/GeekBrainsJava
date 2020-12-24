package lesson1.fruits;

import java.util.ArrayList;
import java.util.List;

public class Box<T extends Fruit> {
    private final List<T> list = new ArrayList<>();
    private float weight = 0.0f;


    public void addFruit(T t){
        list.add(t);
    }

    public List<T> getList() {
        return list;
    }

    public float getWeight(){
        weight = this.getList().size() * this.getList().get(0).getWeight();
        return weight;
    }

    public boolean compare(Box<T> box){
        return box.getWeight() == this.getWeight();
    }

    public void pourOver(Box<T> box){
        if (box.equals(this)){
            System.out.println("To pour, choose another box");
        }else {
           for (int i = 0; i < this.list.size(); i++){
               box.list.add(this.getList().get(i));
           }
           this.list.clear();
        }
    }

    @Override
    public String toString() {
        return "Box{" +
                "list=" + list +
                '}';
    }
}
