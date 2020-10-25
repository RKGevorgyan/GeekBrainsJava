package lesson4;

import java.util.Scanner;

public class XOGame {
    private static char[][] field;
    private static int firstMove = 1;
    private static int coordinateX = 0;
    private static int coordinateY = 0;
    public static void main(String[] args) {
        setFieldSize();
        initField();
        while(true) {
            userMove();
            if (isWin()){
                System.out.println("User win!");
                break;
            }
            if (isDraw()){
                System.out.println("Draw!");
                break;
            }
            computerMove();
            if (isWin()){
                System.out.println("Computer win");
                break;
            }
            if (isDraw()){
                System.out.println("Draw!");
                break;
            }
        }
    }
    public static void setFieldSize(){
        int length=0;
        int width=0;
        while(true){
            Scanner scanner = new Scanner(System.in);
            System.out.println("Write the length of field (greater than 3):");
            length = scanner.nextInt();
            System.out.println("Write the width of field (greater than 3):");
            width = scanner.nextInt();
            if (length != width || length < 3)
                System.out.println("The field must be square with length and width greater than 3");
            else break;
        }
        field = new char[length][width];
    }
    private static void initField() {
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field.length; j++) {
                field[i][j] = '_';
            }
        printField();
    }
    private static void printField(){
        System.out.print("   ");
        for (int i = 1; i <= field.length; i++) {
            System.out.print(i+"  ");
        }
        System.out.println();
        for (int i = 0; i < field.length; i++) {
            System.out.print(i+1+" ");
            for (int j = 0; j < field.length; j++) {
                System.out.print("|");
                System.out.print(field[i][j]);
                System.out.print("|");
            }
            System.out.println();
        }
    }
    public static void userMove(){
        int x,y;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Player moving\n" + "Write X and Y coordinates");
        while(true) {
            x = scanner.nextInt();
            y = scanner.nextInt();
            if (isRightMove(x,y))
                break;
            else System.out.println("Write correct coordinates");
        }
        field[y - 1][x - 1] = 'X';
        printField();
    }
    public static void computerMove(){
        //if (field.length == 3) {
            int cX = field.length - 1;
            int cO = field.length - 1;
            int countXI = 0;
            int countXJ = 0;
            int countDiagonalOneX = 0;
            int countDiagonalTwoX = 0;
            int countOI = 0;
            int countOJ = 0;
            int countDiagonalOneO = 0;
            int countDiagonalTwoO = 0;
            boolean flag = true;
            // win strategy
            label1:
            for (int i = 0; i < field.length; i++) {
                countOI = 0;
                countOJ = 0;
                for (int j = 0; j < field.length; j++) {
                    if (field[i][j] == 'O') {
                        countOI++;
                    }
                    if (field[j][i] == 'O') {
                        countOJ++;
                    }
                    if (i == j) {
                        if (field[i][j] == 'O')
                            countDiagonalOneO++;
                        if (field[i][cO--] == 'O')
                            countDiagonalTwoO++;
                    }
                    if (countOI == field.length - 1) {
                        for (int g = 0; g < field.length; g++) {
                            if (field[i][g] == '_') {
                                field[i][g] = 'O';
                                flag = false;
                                break label1;
                            }
                        }
                    } else if (countOJ == field.length - 1) {
                        for (int l = 0; l < field.length; l++)
                            if (field[l][i] == '_') {
                                field[l][i] = 'O';
                                flag = false;
                                break label1;
                            }
                    } else if (countDiagonalOneO == field.length - 1) {
                        for (int m = 0, n = 0; m < field.length; m++, n++)
                            if (field[m][n] == '_') {
                                field[m][n] = 'O';
                                flag = false;
                                break label1;
                            }
                    } else if (countDiagonalTwoO == field.length - 1) {
                        for (int q = 0, p = field.length - 1; q < field.length; q++, p--)
                            if (field[q][p] == '_') {
                                field[q][p] = 'O';
                                flag = false;
                                break label1;
                            }
                    }
                }
            } // end of win strategy
            // warning detection
        if (flag) {
            int f = 0;
            if (field.length == 3)
                f = 1;
            else f = field.length-3;
                label2:
                for (int i = 0; i < field.length; i++) {
                    countXI = 0;
                    countXJ = 0;
                    for (int j = 0; j < field.length; j++) {
                        if (field[i][j] == 'X')
                            countXI++;
                        if (field[j][i] == 'X')
                            countXJ++;
                        if (i == j) {
                            if (field[i][j] == 'X')
                                countDiagonalOneX++;
                            if (field[i][cX--] == 'X')
                                countDiagonalTwoX++;
                        }
                        if (countXI == field.length - f) {
                            for (int k = 0; k < field.length; k++)
                                if (field[i][k] == '_') {
                                    field[i][k] = 'O';
                                    coordinateX = i;
                                    coordinateY = k;
                                    flag = false;
                                    break label2;
                                }
                        } else if (countXJ == field.length - f) {
                            for (int l = 0; l < field.length; l++)
                                if (field[l][i] == '_') {
                                    field[l][i] = 'O';
                                    coordinateX = l;
                                    coordinateY = i;
                                    flag = false;
                                    break label2;
                                }
                        } else if (countDiagonalOneX == field.length - f) {
                            for (int m = 0, n = 0; m < field.length; m++, n++)
                                if (field[m][n] == '_') {
                                    field[m][n] = 'O';
                                    coordinateX = m;
                                    coordinateY = n;
                                    flag = false;
                                    break label2;
                                }
                        } else if (countDiagonalTwoX == field.length - f) {
                            for (int q = 0, p = field.length - 1; q < field.length; q++, p--)
                                if (field[q][p] == '_') {
                                    field[q][p] = 'O';
                                    coordinateX = q;
                                    coordinateY = p;
                                    flag = false;
                                    break label2;
                                }
                        }
                    } // end of columns
                }// end of rows
        }
            // random move
            while (firstMove == 1) {
                 coordinateX = (int) (Math.random() * (field.length));
                 coordinateY = (int) (Math.random() * (field.length));
                if (field[coordinateX][coordinateY] == '_') {
                    field[coordinateX][coordinateY] = 'O';
                    firstMove++;
                    flag = false;
                }
            }
            // draw strategy
        if(flag){
            int detectXI = 0;
            int detectXJ = 0;
            for (int i = 0; i < field.length; i++){
                if(field[coordinateX][i] == 'X'){
                    detectXI++;
                }
                if (field[i][coordinateY] == 'X'){
                    detectXJ++;
                }
                if (detectXI == 0){
                    if (field[coordinateX][i] == '_') {
                        field[coordinateX][i] = 'O';
                        break;
                    }
                }
                if (detectXJ == 0){
                    if (field[i][coordinateY] == '_'){
                        field[i][coordinateY] = 'O';
                        break;
                    }
                }
            }
        }

            printField();
    }
    public static boolean isRightMove(int x, int y){
        if ((x <= field.length && y <= field.length) && field[y-1][x-1] == '_')
            return true;
        return false;
    }
    public static boolean isWin(){
        int cX = field.length-1;
        int cY = field.length-1;
        int countXI = 0;
        int countYI = 0;
        int countXJ = 0;
        int countYJ = 0;
        int countDiagonalOneX = 0;
        int countDiagonalOneY = 0;
        int countDiagonalTwoX = 0;
        int countDiagonalTwoY = 0;
        for (int i = 0; i < field.length; i++) {
            countXI = 0;
            countYI = 0;
            countXJ = 0;
            countYJ = 0;
            for (int j = 0; j < field.length; j++) {
                if (field[i][j] == 'X')
                    countXI++;
                if (field[j][i] == 'X')
                    countXJ++;
                if (field[i][j] == 'O')
                    countYI++;
                if (field[j][i] == 'O')
                    countYJ++;
                if (i == j) {
                    if (field[i][j] == 'X')
                        countDiagonalOneX++;
                    if (field[i][j] == 'O')
                        countDiagonalOneY++;
                    if (field[i][cX--] == 'X')
                        countDiagonalTwoX++;
                    if (field[i][cY--] == 'O')
                        countDiagonalTwoY++;
                }
                int u = 0;
                if (field.length == 3)
                    u = 0;
                else u = 1;
                    if (countXI == field.length - u || countXJ == field.length - u) {
                        return true;
                    } else if (countYI == field.length - u || countYJ == field.length - u) {
                        return true;
                    } else if (countDiagonalOneX == field.length - u || countDiagonalTwoX == field.length - u) {
                        return true;
                    } else if (countDiagonalOneY == field.length - u || countDiagonalTwoY == field.length - u) {
                        return true;
                    }

            }
        }
        return false;
    }
    public static boolean isDraw(){
        int count = 0;
        for (int i = 0; i < field.length; i++)
            for (int j = 0; j < field.length; j++)
                if (field[i][j] == '_')
                    count++;
        return count == 0;
    }
}
