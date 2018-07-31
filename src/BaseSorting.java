/**
 * Implements various sorting algorithms.
 *
 * @author (your name), Acuna, Sedgewick
 * @verison (version)
 */

public class BaseSorting {

    /**
     * Entry point for sample output.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //Q1
        String[] a = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        quicksortmid(a);
        assert isSorted(a); //requires assertions enabled.
        show(a);

        //Q2
        String[] b = {"S", "O", "R", "T", "E", "X", "A", "M", "P", "L", "E"};
        mergesort(b);
        assert isSorted(b);
        show(b);
    }

    public static void quicksortmid(Comparable[] a) {
        //TODO: implement this.
        quickSort(a, 0, a.length -1);
        
    }

    public static <T extends Comparable<T>>
    void quickSort(T[] data, int min, int max){
        if(min < max){

            int middleIndex = (min + max) / 2;
            int middle = getMiddleIndex(data, min, max, middleIndex);
            partition(data, min, max, middle);
            //middleIndex = partition(data, min, max, middle);
            quickSort(data, min, middleIndex);
            quickSort(data, middleIndex, max);
        }
    }
    public static<T extends Comparable<T>>
    int getMiddleIndex(T[]data, int first, int second, int third){
        int middleValue = second;
            //check if middle is between max and min
            if(data[second].compareTo(data[first])< 0){
                if(data[second].compareTo(data[third]) <0) {
                    //max is smallest, min is largest
                    if (data[third].compareTo(data[first]) < 0) {
                        middleValue = third;
                    } else {
                        middleValue = first;
                    }
                }
            }else if(data[second].compareTo(data[first])> 0){
                if(data[second].compareTo(data[third]) > 0){
                    //min is smallest, max is largest
                    if (data[third].compareTo(data[first]) < 0) {
                        middleValue = first;
                    } else {
                        middleValue = third;
                    }
                }
            }
           return middleValue;
    }
    public static <T extends Comparable<T>>
    int partition(T[] data, int min, int max, int middleIndex){


        return 0;
    }

    public static <T extends Comparable<T>>
    void swap(T[] data, int index1, int index2){
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    public static void mergesort(Comparable[] a) {
        //TODO: implement this.
    }

    /**
     * Displays contents of array, space separated.
     * @author Sedgewick
     * @param a Array to display.
     */
    private static void show(Comparable[] a) {
        for (Comparable a1 : a)
            System.out.print(a1 + " ");

        System.out.println();
    }

    /**
     * Checks if array is in sorted order.
     * @author Sedgewick
     * @param a Array to be checked.
     * @return Returns true if array is sorted.
     */
    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++)
            if (less(a[i], a[i-1]))
                return false;

        return true;
    }

    //See previous method.
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }
}