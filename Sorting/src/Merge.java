import java.lang.Comparable;

/**
 * Created by ratul on 12/14/2014.
 */
public class Merge {
	
	public static void sortIterative(Comparable[] arr) {
		int N = arr.length;
		Comparable[] aux = new Comparable[N];
		
		for (int sz = 1 ; sz < N; sz += sz) {
			for (int lo = 0; lo < N-sz; lo += sz+sz) {
				int mid = lo + sz - 1;
				merge(arr, aux, lo, mid, Math.min(N-1, lo+sz+sz-1));
			}
		}
	}

    public static void sort(Comparable[] arr) {
    	Comparable[] aux = new Comparable[arr.length];
        mergeSort(arr, aux, 0, arr.length - 1);
    }

    private static void mergeSort(Comparable[] arr, Comparable[] aux, int lo, int hi) {
    	if (lo >= hi) return;
    	
    	int mid = (lo + hi) / 2;
    	mergeSort(arr, aux, lo, mid);
    	mergeSort(arr, aux, mid+1, hi);
    	merge(arr, aux, lo, mid, hi);
	}

	private static void merge(Comparable[] arr, Comparable[] aux, int lo, int mid, int hi) {
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

            /* Compare i'th and j'th element of the two halves and
             * set it at k'th index in the original array. Increment
             * that half's index. */
            else if (SortUtils.less(aux[j], aux[i])) {
                arr[k] = aux[j++];
            } else {
                arr[k] = aux[i++];
            }
        }

        assert SortUtils.isSorted(arr, lo, hi);
    }

}
