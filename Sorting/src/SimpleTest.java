
public class SimpleTest {

	public static void main(String[] args) {
        Integer[] arr = new Integer[] {13, 4, 6, 8, 32, 20, 4, 5, 1};
        for (int i : arr) {
            System.out.println(i);
        }

        System.out.println();
        Merge.sortIterative(arr);
        for (int i : arr) {
            System.out.println(i);
        }
    }
	
}
