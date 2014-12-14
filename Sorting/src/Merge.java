/**
 * Created by ratul on 12/14/2014.
 */
public class Merge {

    private void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {
        assert SortUtils.isSorted(arr, lo, mid);
        assert SortUtils.isSorted(arr, mid + 1, hi);

        /* Make a copy of the array in the aux array */
        for (int i = lo; i <= hi; i++) {
            aux[i] = arr[i];
        }

        int i = lo, j = mid+1;
        for (int k = lo; k <= hi; k++) {
            /* When one half has exhausted all its elements */
            if (i > mid) arr[k] = aux[j++];
            else if (j > hi) arr[k] = aux[i++];

            else if (SortUtils.less(aux[i], aux[j])) {
                arr[k] = aux[i++];
            } else {
                arr[k] = aux[j++];
            }
        }

        assert SortUtils.isSorted(arr, lo, hi);
    }

}
