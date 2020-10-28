package lesson2;

import java.util.Arrays;

public class HomeWork2 {
    public static void main(String[] args) {
        System.out.println("Exercise 1:");
        int[] array1 = {1,0,0,1,0,1,0,1,1};
        System.out.println(Arrays.toString(array1)+ " -> " +Arrays.toString(swap(array1))+"\n");
        System.out.println("Exercise 2:");
        System.out.println(Arrays.toString(createArray())+"\n");
        System.out.println("Exercise 3:");
        int[] array2 = {1,5,3,2,11,4,5,2,4,8,9,1};
        System.out.println(Arrays.toString(array2)+ " -> " +Arrays.toString(multiplyLessThanSix(array2))+"\n");
        System.out.println("Exercise 4:");
        fillDiagonal(10,10);
        System.out.println("Exercise 5:");
        int[] array3 = {1,50,-93,-52,20,40,505,-2,1488,8,9,1};
        System.out.println(Arrays.toString(array3) + " -> " + minAndMax(array3)+"\n");
        System.out.println("Exercise 6:");
        int[] array4 = {2, 2, 2, 1, 2, 2, 10, 1};
        System.out.println("O(n^2) -> " + leftEqualsRight(array4));
        System.out.println("O(n) -> " + leftEqualsRightModified(array4)+"\n");
        System.out.println("Exercise 7:");
        int[] array5 = {1,2,3,4,5,6,7,8,9};
        System.out.println(Arrays.toString(displace(array5,3))+"\n");
    }
// exercise 1
    private static int[] swap(int[] array){
        for (int i=0; i< array.length;i++){
            if (array[i]==0) array[i]=1;
            else array[i]=0;
        }
        return array;
    }
// exercise 2
    private static int[] createArray(){
        int [] array = new int[8];
        for (int i=0,j=0; i< array.length; j+=3,i++){
            array[i]=j;
        }
        return array;
    }
// exercise 3
    private static int[] multiplyLessThanSix(int[] array){
        for (int i=0; i< array.length;i++){
            if (array[i]<6) array[i]*=2;
        }
        return array;
    }
// exercise 4
    private static void fillDiagonal(int a, int b){
        // checking row and column equality
        if (a!=b) {
            System.out.println("Write the same number for columns and lines");
            return;
        }
        // filling diagonals of square array
        int[][] square = new int[a][b];
        int c = square.length-1;
        for (int i=0,j = 0;i< square.length; j++,i++) {
            if (i == j)
                square[i][j] = 1;
            square[i][c--]=1;
        }
        // printing filled square array
        for (int i=0; i< square.length;i++) {
            for (int j = 0; j < square.length; j++)
                System.out.print(square[i][j]+"\t");
            System.out.println();
        }
        System.out.println();
    }
// exercise 5
    private static String minAndMax(int[] array){
        int max=array[0];
        int min=array[0];
        for (int i=1; i<array.length; i++) {
            if (max < array[i])
                max = array[i];
            if (min > array[i])
                min = array[i];
        }
        return "Max: " + max + " Min: " + min;
    }
// exercise 6
    private static boolean leftEqualsRight(int[] array){
        int iterations = 0;
        int leftSum = 0;
        int rightSum;
        for (int i=0; i< array.length-1; i++){
            rightSum=0;
            leftSum+=array[i];
            for (int j=i+1; j< array.length; j++){
                iterations++;
                rightSum+=array[j];
            }
            if (leftSum==rightSum) {
//                System.out.println("Zero-based equality index: "+i);
                System.out.print("iterations: " + iterations + " -> ");
                return true;
            }
        }
        System.out.print("iterations: " + iterations + " -> ");
        return false;
    }
// exercise 6 modified
    private static boolean leftEqualsRightModified(int[] array){
        int iterations = 0;
        int sumLeft = array[0];
        int sumRight = array[array.length-1];
        for (int i = 1, j = array.length-2; i< array.length ; i++, j--) {
            iterations++;
            if (Math.abs(i-j)==1&&sumLeft==sumRight){
                System.out.print("iterations: " + iterations + " -> ");
                return true;
            }else if (sumLeft==sumRight){
                sumLeft += array[i];
                sumRight += array[j];
            } else if (sumLeft>sumRight){
                sumRight += array[j];
                i--;
            } else {
                sumLeft += array[i];
                j++;
            }
        }
        System.out.print("iterations: " + iterations + " -> ");
        return false;
    }

// exercise 7
    private static int[] displace(int[] array, int n){
        // no need to move
        if (n % array.length == 0) {
            return array;
        }
        // n is positive
        else if (n > 0){
            if (n > array.length)
            // n = how many shifts do we need
            n = n - ( n / array.length ) * array.length;
            for (int k = 0; k < n; k++) {
                int c = array[array.length - 1];
                for (int i = array.length - 1; i > 0; i--) {
                    array[i] = array[i - 1];
                }
                array[0] = c;
            }
        }
        // n is negative
        else if (n < 0){
            if ( (-n) > array.length)
            // n = how many shifts do we need
            n = - ( (-n) - ( (-n) / array.length ) * array.length );
            for (int k = 0; k < (-n); k++) {
                int c = array[0];
                for (int i = 0; i < array.length-1; i++) {
                    array[i] = array[i + 1];
                }
                array[array.length-1] = c;
            }
        }
        return array;
    }
}
