/**
 * Implements various sorting algorithms.
 *
 * @author JonDavid Ebadirad, Acuna, Sedgewick
 * @verison 1.0
 */

public class EbadiradSorting {

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

    /**
     * method used to quicksort an array based on a middle value
     * @param a an array to be sorted. 
     */
    public static void quicksortmid(Comparable[] a) {
        quickSort(a, 0, a.length -1);
        
    }

    /**
     * method used to quick sort an array recursivly
     * @param data the array to sort
     * @param min the left most index
     * @param max the right most index
     * @param <T> the array must be Comparable.
     */
    public static <T extends Comparable<T>>
    void quickSort(T[] data, int min, int max){
        if(min < max){
            int middleIndex = (min + max) / 2;
            int middle = getMiddleIndex(data, min, middleIndex, max);
            middleIndex = partition(data, min, max, middle);
            quickSort(data, min, middleIndex  - 1);
            quickSort(data, middleIndex + 1, max);
        }
    }

    /**
     * method used to get the middle value's index out of three elements from an array
     * @param data the array we are sorting
     * @param first the index of the first value in question
     * @param second the index of the second value in question
     * @param third the index of the third value in question
     * @param <T> the array must be Comparable
     * @return the index of the middle value, will always be first, second or third.
     */
    public static<T extends Comparable<T>>
    int getMiddleIndex(T[]data, int first, int second, int third){
        int middleValue = second;
            //check if middle is between max and min
            if(data[second].compareTo(data[first])< 0){
                if(data[second].compareTo(data[third]) <0) {
                    //max is smallest, min is largest
                    if (data[third].compareTo(data[first]) < 0) {
                        middleValue = third;
                    }else if(data[third].compareTo(data[first]) == 0) {
                        middleValue = second;
                    } else {
                        middleValue = first;
                    }
                }
            }else if(data[second].compareTo(data[first])> 0){
                if(data[second].compareTo(data[third]) > 0){
                    //min is smallest, max is largest
                    if (data[third].compareTo(data[first]) < 0) {
                        middleValue = first;
                    }else if(data[third].compareTo(data[first]) == 0) {
                          middleValue = second;
                    }else {
                        middleValue = third;
                    }
                }
            }else{
                //second equal first
                middleValue = third;
            }
           return middleValue;
    }

    /**
     * used in quick sort to partition and sort the array
     * @param data the array to be sorted
     * @param min the index of the left most element
     * @param max the index of the right most element
     * @param middleIndex the index of the value that is the middle value
     * @param <T> the data must be comparable.
     * @return the index of the value that is greater than the middle value.
     */
    private static <T extends Comparable<T>>
    int partition(T[] data, int min, int max, int middleIndex){
        int left, right;
        T partitionElement = data[middleIndex];
        swap(data, middleIndex, min);
        left = min;
        right = max;

        while(left < right){
            while(left < right && data[left].compareTo(partitionElement) <= 0){
                left ++;
            }
            while(data[right].compareTo(partitionElement) > 0){
                right --;
            }
            if(left < right){
                swap(data, left, right);
            }
        }
        swap(data, min, right);
        return right;
    }

    /**
     * swaps the values in an array based on the index
     * @param data the array that we are looking at to swap elements in
     * @param index1 the index of the first value to swap
     * @param index2 the index of the second value to swap
     * @param <T> The array type must be Comparable
     */
    public static <T extends Comparable<T>>
    void swap(T[] data, int index1, int index2){
        T temp = data[index1];
        data[index1] = data[index2];
        data[index2] = temp;
    }

    /**
     * Sorts an array and updates the array from the parameter
     * with the sorted array
     * @param a the array to be sorted, this method modifies the original array
     */
    public static void mergesort(Comparable[] a) {
        Comparable[] temp = mergesortRec(a);
        for(int i = 0; i < temp.length; i ++){
            a[i] = temp[i];
        }
    }

    /**
     *
     * recursive method used in merge sort
     * @param a an array to be sorted
     * @return a sorted array
     */
    public static Comparable[] mergesortRec(Comparable[] a){
        Comparable[] sorted;
        int mid = a.length / 2;
        if(mid > 0 ){
            Comparable[] left = arrayPart(a, 0, mid);
            Comparable[] right = arrayPart(a, mid, a.length );
            left = mergesortRec(left);
            right = mergesortRec(right);
            sorted = merge(left, right);
        }else{
            sorted = a ;
        }


        return sorted;
    }

    /**
     *
     * partitions an array from start index up to end index
     * @param data the array we are copying out
     * @param start the index that we are starting
     * @param end the index we are ending, exclusive
     * @return a subsection of the array
     */
    public static Comparable[] arrayPart(Comparable[] data, int start, int end){

        Comparable[] leftOver = new Comparable[end - start];
        for(int i = 0; start < end; i++){
               leftOver[i] = data[start];
               start ++;
        }

        return leftOver;
    }

    /**
     * Merges two unsorted arrays into a sorted array
     * @param a an array
     * @param b another array
     * @return a sorted array
     */
    public static Comparable[] merge(Comparable[] a, Comparable[] b){
        Comparable[] temp = new Comparable[a.length + b.length];
        int first1 = 0;
        int first2 = 0;
        int index = 0;
        while(first1 < a.length && first2 < b.length){
            if(a[first1].compareTo(b[first2]) < 0){
                temp[index] = a[first1];
                first1++;
            }
            else{
                temp[index] = b[first2];
                first2++;
            }
            index++;
        }

        while(first1 < a.length){
            temp[index] = a[first1];
            first1++;
            index++;
        }

        while(first2 < b.length){
            temp[index] = b[first2];
            first2++;
            index++;
        }

        return temp;
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