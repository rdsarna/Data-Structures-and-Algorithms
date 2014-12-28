import java.util.Arrays;

/**
 * Created by ratul on 12/27/2014.
 */
public class MaxPQ<Key extends Comparable<Key>> {

    private Key[] arr;
    private int N;

    /**
     * Creates an empty priority queue.
     */
    public MaxPQ() {
        arr = (Key[]) new Comparable[11];
        N = 0;
    }

    /**
     * Copy constructor that makes a deep copy of the
     * given MaxPQ.
     * @param copy MaxPQ whose copy is to be constructed.
     */
    public MaxPQ(MaxPQ<Key> copy) {
        this.arr = (Key[]) new Comparable[copy.arr.length];
        System.arraycopy(copy.arr, 0, this.arr, 0, copy.arr.length);
        this.N = copy.N;
    }

    /**
     * Creates a priority queue with the given keys.
     * @param a array of keys to be added to the new PQ
     */
    /*public MaxPQ(Key[] a) {

    }*/

    /**
     * Inserts a key into the priority queue
     * @param v The key to be inserted
     */
    public void insert(Key v) {
        arr[++N] = v;
        swim(N);
    }

    /**
     * Returns and removes the largest key.
     * @return The largest key in the PQ
     */
    public Key delMax() {
        Key max = arr[1];
        SortUtils.swap(arr, 1, N);
        arr[N--] = null;
        sink(1);
        return max;
    }

    /**
     * Returns true iff the priority queue is empty.
     */
    public boolean isEmpty() {
        return N < 1;
    }

    /**
     * Returns the largest key in the priority queue.
     */
    public Key max() {
        return arr[1];
    }

    /**
     * Returns the number of entries in the priority queue.
     */
    public int size() {
        return N;
    }

    /* Sinks the key at the given index to its correct position
       in the heap. */
    private void sink(int index) {
        while (2 * index <= N) {
            int childIndex = 2 * index;
            if (childIndex < N &&
                    SortUtils.less(arr[childIndex], arr[childIndex+1])) {
                childIndex += 1;
            }
            if (SortUtils.less(arr[childIndex], arr[index]))
                break;
            SortUtils.swap(arr, index, childIndex);
            index = childIndex;
        }
    }

    private void swim(int index) {
        while (index > 1 &&
                SortUtils.less(arr[index / 2], arr[index])) {
            SortUtils.swap(arr, index/2, index);
            index /= 2;
        }
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("[");
        MaxPQ<Key> copyPQ = new MaxPQ<Key>(this);
        while (!copyPQ.isEmpty()) {
            result.append(copyPQ.delMax().toString());
            result.append(", ");
        }
        result.delete(result.length() - 2, result.length());
        result.append("]");
        return result.toString();
    }

    public static void main(String[] args) {
        MaxPQ<String> pq = new MaxPQ<String>();
        pq.insert("T");
        pq.insert("A");
        pq.insert("S");
        pq.insert("V");
        pq.insert("M");
        pq.insert("J");
        pq.insert("B");
        pq.insert("R");
        pq.insert("Z");

        System.out.println(pq.delMax());
        System.out.println(pq.toString());
        System.out.println(pq.delMax());
        System.out.println(pq.delMax());
        System.out.println(pq.toString());
    }

}
