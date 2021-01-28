package lesson6;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class AfterFourTest {
    @Test
    void array(){
        AfterFour af = new AfterFour();
        int[] ar1 = {1,2,3,4,5,6,3,2,4,5,2,6,4,3,2,1,6,7,};
        int[] expected1 = {3,2,1,6,7};
        int[] ar2 = {5,34,34,34,2,2,7,3,7,5,4,7,4,54,5};
        int[] expected2 = {54,5};
        int[] ar3 = {4,3,2,6,5,4,3,235,2,72,7,2,7,};
        int[] expected3 = {3,235,2,72,7,2,7};
        assertArrayEquals(expected1,af.array(ar1));
        assertArrayEquals(expected2,af.array(ar2));
        assertArrayEquals(expected3,af.array(ar3));
    }

    @Test
    void array2(){
        AfterFour af = new AfterFour();
        int[] ar1 = {1,4,1,4,1,1,1,4};
        int[] ar2 = {1,4,4,4};
        boolean expected = true;
        assertEquals(expected,af.containOneAndFour(ar1));
        assertEquals(expected,af.containOneAndFour(ar2));

    }
}
