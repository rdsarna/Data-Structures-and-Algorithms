import java.util.Comparator;

/**
 *
 */
public class Heap {

    public static void sort(Comparable[] arr) {
        

        int N = arr.length;

        /* Convert the array into a Max based Priority Queue */
        for (int k = N/2; k >= 1; k--) {
            sink(arr, k, N);
        }

        /* Sort the max PQ */
        while (N > 1) {
            SortUtils.swap(arr, 1, N--);
            sink(arr, 1, N);
        }
    }

    private static void sink(Comparable[] arr, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            if (j < N && SortUtils.less(arr[j], arr[j+1]))
                j += 1;
            if (!SortUtils.less(arr[k], arr[j])) break;
            SortUtils.swap(arr, k, j);
            k = j;
        }
    }

}
