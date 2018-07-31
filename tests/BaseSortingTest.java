import org.junit.Test;

import static org.junit.Assert.*;
import java.util.concurrent.ThreadLocalRandom;
public class BaseSortingTest {
    String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
    Integer[] b = {1, 2, 4 , 6 ,8, 2, 1, 3,2, 0, 10};

    @Test
    public void quickSort() {
        BaseSorting.quicksortmid(a);
        assertTrue(BaseSorting.isSorted(a));
        for(int iterator = 0; iterator < 30; iterator ++){
            int maxLength = ThreadLocalRandom.current().nextInt(0, 101);
            b = new Integer[maxLength];
            for(int i = 0; i < maxLength; i ++){
                b[i] = ThreadLocalRandom.current().nextInt(-50, 51);
            }
            BaseSorting.quicksortmid(b);
            assertTrue(BaseSorting.isSorted(b));
        }

    }

    @Test
    public void mergesort() {
    }
    @Test
    public void getMiddleTest(){
            Integer[] data = {1 , 2 , 3};
            Integer middle;
            middle = BaseSorting.getMiddleIndex(data, 0, 1 , 2);
            assertEquals((Integer) 1, middle);

            data = new Integer[]{1 , 3 , 2};
            middle = BaseSorting.getMiddleIndex(data, 0, 1 , 2);
            assertEquals((Integer) 2, middle);

            data = new Integer[]{2 , 1 , 3};
            middle = BaseSorting.getMiddleIndex(data, 0, 1 , 2);
            assertEquals((Integer) 0, middle);

            data = new Integer[]{2 , 3 , 1};
            middle = BaseSorting.getMiddleIndex(data, 0, 1 , 2);
            assertEquals((Integer) 0, middle);

            data = new Integer[]{3 , 1 , 2};
            middle = BaseSorting.getMiddleIndex(data, 0, 1 , 2);
            assertEquals((Integer) 2, middle);

            data = new Integer[]{3 , 2 , 1};
            middle = BaseSorting.getMiddleIndex(data, 0, 1 , 2);
            assertEquals((Integer) 1, middle);

            data = new Integer[]{1, 1, 2};
            middle = BaseSorting.getMiddleIndex(data, 0 ,1 ,2 );
            assertEquals((Integer)2, middle);

            data = new Integer[]{1, 2, 2};
            middle = BaseSorting.getMiddleIndex(data, 0 ,1 ,2 );
            assertEquals((Integer)1, middle);

            data = new Integer[]{1, 2, 1};
            middle = BaseSorting.getMiddleIndex(data, 0 ,1 ,2 );
            assertEquals((Integer)1, middle);
    }
}