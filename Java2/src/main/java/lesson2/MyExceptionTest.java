package lesson2;

public class MyExceptionTest {
    public static void main(String[] args) {
        String[][] array = {{"87","6","0","75"},{"8","9","l","2"},{"5","8","2","3"},{"7","0","7","9"}};

        try{
            System.out.println(sumArray(array));
        } catch (MyArraySizeException | MyArrayDataException e){
            e.printStackTrace();
        }
    }

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
       if (!(array.length == 4 && array[0].length == 4))
           throw new MyArraySizeException("Array size must be 4x4");
       int sum = 0;
        for (int i = 0; i < array.length; i++)
            for (int j = 0; j < array.length; j++){
                try {
                    sum += Integer.parseInt(array[i][j]);
                }catch (NumberFormatException e){
                    throw new MyArrayDataException("Exception in array["+i+"]["+j+"]");
                }
            }
        return sum;
    }
}
