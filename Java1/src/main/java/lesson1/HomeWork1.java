package lesson1;

import java.util.Scanner;

public class HomeWork1 {
    // exercise 1
    public static void main(String[] args) {
        // exercise 2
        byte b = 1;
        short sh = 3567;
        int i = -305060707;
        long l = 10102030405L;
        float f = 3.6753f;
        double d = 256897.242424;
        char c = '*';
        String s = "Hello World";

        // exercises 3-6
        System.out.println(calculate(1,2,3,4));
        System.out.println(within(10,10));
        System.out.println(isPositive(23456));
        System.out.println(isNegative(-100));

        // exercises 7,8
        try(Scanner scanner = new Scanner(System.in)) {
            System.out.println("Write your name: ");
            String name = scanner.nextLine();
            helloStranger(name);
            System.out.println("Write year: ");
            int year = scanner.nextInt();
            System.out.println(isLeapYear(year));
        }

    }
    private static double calculate(double a, double b, double c, double d){
        return a*(b+(c/d));
    }

    private static boolean within(double a, double b){
        if ((a+b)>=10&&(a+b)<=20) {
            return true;
        } else return false;
    }

    private static String isPositive(int d){
        return d>=0 ? "Number "+d+" is positive" : "Number " +d+ " is negative";
    }

    private static boolean isNegative(int i){
        return i<0;
    }

    private static void helloStranger(String name){
        System.out.println("Hello, " + name);
    }

    private static String isLeapYear(int year){
        if (year%100==0&&year%400!=0)
            return year+" isn't a leap year";
        return year%4==0 ? year + " is a leap year " : year+ " isn't a leap year";
    }

}
