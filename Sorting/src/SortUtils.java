/**
 * Created by ratul on 12/14/2014.
 */
public class SortUtils {

    public static boolean less(Comparable a, Comparable b) {
        return a.compareTo(b) < 0;
    }

    public static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static boolean isSorted(Comparable[] arr, int lo, int hi) {
        for (int i = lo; i < hi; i++) {
            if (SortUtils.less(arr[i+1], arr[i]))
                return false;
        }
        return true;
    }
}
