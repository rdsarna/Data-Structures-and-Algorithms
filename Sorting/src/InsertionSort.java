/**
 * Created by ratul on 12/11/2014.
 */
public class InsertionSort {

    public static void insertionSort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (less(arr[j], arr[j-1]))
                    swap(arr, j, j-1);
                else break;
            }
        }
    }

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {13, 4, 6, 8, 32, 20, 4, 5, 1};
        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println();
        insertionSort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
