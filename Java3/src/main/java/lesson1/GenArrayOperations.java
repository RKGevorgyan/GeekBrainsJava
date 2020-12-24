package lesson1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class GenArrayOperations {
    public static void main(String[] args) {
        Integer[] array = {1,2,3,4,5,6,7,8};
        replace(array,0,1);
        System.out.println(Arrays.toString(array));
        List<Integer> list = toArrayList(array);
        System.out.println(list);
    }

    public static <T> void replace(T[] array, int first, int second){
        if(first < array.length && second < array.length) {
            T t = array[first];
            array[first] = array[second];
            array[second] = t;
        } else {
            System.out.println("Index out of bounds");
        }
    }

    public static <T> ArrayList<T> toArrayList(T[] array){
        return new ArrayList<T>(Arrays.asList(array));
    }
}
