/**
 * Created by ratul on 12/16/2014.
 */
public class Quick {

    public void sort(Comparable[] arr) {
        SortUtils.shuffle(arr);
        sort(arr, 0, arr.length - 1);
    }

    private void sort(Comparable[] arr, int lo, int hi) {
        if (lo >= hi) return;

        int partition = partition(arr, lo, hi);
        sort(arr, lo, partition-1);
        sort(arr, partition+1, hi);
    }

    private static int partition(Comparable[] arr, int lo, int hi) {
        int i = lo;
        int j = hi + 1;

        while (true) {
            while (SortUtils.less(arr[++i], arr[lo])) {
                if (i == hi) break;
            }

            while (SortUtils.less(arr[lo], arr[--j])) {
                if (j == lo) break;
            }

            if (i >= j) break;
            SortUtils.swap(arr, i, j);
        }

        SortUtils.swap(arr, lo, j);

        return j;
    }

}
