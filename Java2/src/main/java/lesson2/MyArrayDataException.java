package lesson2;

import java.util.Scanner;

public class MyArrayDataException extends Exception {
    private int i;
    private int j;
    public MyArrayDataException(String message) {
        super(message);
    }
}
