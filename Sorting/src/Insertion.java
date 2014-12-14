/**
 * Created by ratul on 12/11/2014.
 */
public class Insertion {

    public static void sort(Comparable[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (SortUtils.less(arr[j], arr[j - 1]))
                    SortUtils.swap(arr, j, j - 1);
                else break;
            }
        }
    }

    public static void main(String[] args) {
        Integer[] arr = new Integer[] {13, 4, 6, 8, 32, 20, 4, 5, 1};
        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println();
        sort(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }

}
