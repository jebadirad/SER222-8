import org.junit.Test;

import static org.junit.Assert.*;
import java.util.concurrent.ThreadLocalRandom;
/**
 * Tests for EbadiradSorting.
 *
 * @author JonDavid Ebadirad
 * @verison 1.0
 */
public class EbadiradSortingTest {
    String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
    Integer[] b = {1, 2, 4 , 6 ,8, 2, 1, 3,2, 0, 10};

    @Test
    public void quickSort() {
        EbadiradSorting.quicksortmid(a);
        assertTrue(EbadiradSorting.isSorted(a));
        for(int iterator = 0; iterator < 30; iterator ++){
            int maxLength = ThreadLocalRandom.current().nextInt(0, 101);
            b = new Integer[maxLength];
            for(int i = 0; i < maxLength; i ++){
                b[i] = ThreadLocalRandom.current().nextInt(-50, 51);
            }
            EbadiradSorting.quicksortmid(b);
            assertTrue(EbadiradSorting.isSorted(b));
        }

    }

    @Test
    public void mergesort() {
        for(int iterator = 0; iterator < 30; iterator ++){
            int maxLength = ThreadLocalRandom.current().nextInt(0, 101);
            b = new Integer[maxLength];
            for(int i = 0; i < maxLength; i ++){
                b[i] = ThreadLocalRandom.current().nextInt(-50, 51);
            }
            EbadiradSorting.mergesort(b);
            assertTrue(EbadiradSorting.isSorted(b));
        }
    }
    @Test
    public void getMiddleTest(){
            Integer[] data = {1 , 2 , 3};
            Integer middle;
            middle = EbadiradSorting.getMiddleIndex(data, 0, 1 , 2);
            assertEquals((Integer) 1, middle);

            data = new Integer[]{1 , 3 , 2};
            middle = EbadiradSorting.getMiddleIndex(data, 0, 1 , 2);
            assertEquals((Integer) 2, middle);

            data = new Integer[]{2 , 1 , 3};
            middle = EbadiradSorting.getMiddleIndex(data, 0, 1 , 2);
            assertEquals((Integer) 0, middle);

            data = new Integer[]{2 , 3 , 1};
            middle = EbadiradSorting.getMiddleIndex(data, 0, 1 , 2);
            assertEquals((Integer) 0, middle);

            data = new Integer[]{3 , 1 , 2};
            middle = EbadiradSorting.getMiddleIndex(data, 0, 1 , 2);
            assertEquals((Integer) 2, middle);

            data = new Integer[]{3 , 2 , 1};
            middle = EbadiradSorting.getMiddleIndex(data, 0, 1 , 2);
            assertEquals((Integer) 1, middle);

            data = new Integer[]{1, 1, 2};
            middle = EbadiradSorting.getMiddleIndex(data, 0 ,1 ,2 );
            assertEquals((Integer)2, middle);

            data = new Integer[]{1, 2, 2};
            middle = EbadiradSorting.getMiddleIndex(data, 0 ,1 ,2 );
            assertEquals((Integer)1, middle);

            data = new Integer[]{1, 2, 1};
            middle = EbadiradSorting.getMiddleIndex(data, 0 ,1 ,2 );
            assertEquals((Integer)1, middle);
    }
    @Test
    public void swapTest(){
        Integer[] data = {1,2,3};
        EbadiradSorting.swap(data, 0, 1);
        assertEquals((Integer)2, data[0]);
        assertEquals((Integer)1, data[1]);
    }
    @Test
    public void arrayPartTest(){
        Integer[] data = {1,2,3};
        Comparable<Integer>[] leftHalf = EbadiradSorting.arrayPart(data, 0,1);
        assertEquals((Integer)1, (Integer)leftHalf.length);
        assertEquals((Integer)1, leftHalf[0]);
    }
}