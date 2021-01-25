package lesson6;

public class AfterFour {
    private static int index;

    public int[] array(int[] array){
        if (array.length==0)
            throw new RuntimeException();
        for(int i = array.length-1; i > 0; i--){
            if (array[i]==4){
                index = i;
                break;
            }
        }
        int[] newArray = new int[array.length-index-1];
        for (int i = index+1, j = 0; i<array.length;j++,i++){
            newArray[j] = array[i];
        }
        return newArray;
    }

    public boolean containOneAndFour(int[] array){
        boolean one = false;
        boolean four = false;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == 4){
                one = true;
            }
            if (array[i] == 1){
                four = true;
            }
        }
        return one && four;
    }


}
