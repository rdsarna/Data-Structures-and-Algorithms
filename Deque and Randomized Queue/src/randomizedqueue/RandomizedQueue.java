package randomizedqueue;

import java.util.*;

/**
 * Created by ratul on 12/10/2014.
 */
public class RandomizedQueue<Item> implements Iterable<Item> {

    private static final String DOUBLE = "double";
    private static final String HALF = "half";

    private Item[] array;
    private int lastItemIndex;
    private static final Random random = new Random();

    public RandomizedQueue() {
        this.array = (Item[]) new Object[10];
        this.lastItemIndex = -1;
    }

    public boolean isEmpty() {
        return lastItemIndex == -1;
    }

    public int size() {
        return lastItemIndex + 1;
    }

    public void enqueue(Item item) {
        if (item == null) {
            throw new NullPointerException();
        }

        if (lastItemIndex == array.length - 1) {
            resize(RandomizedQueue.DOUBLE);
        }

        array[++lastItemIndex] = item;
    }

    public Item dequeue() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        int randomIndex = getRandomIndex();
        Item toReturn = array[randomIndex];

        array[randomIndex] = array[lastItemIndex];
        array[lastItemIndex--] = null;

        if (lastItemIndex < array.length / 4) {
            resize(RandomizedQueue.HALF);
        }

        return toReturn;
    }

    private void resize(String change) {
        int newSize;
        if (change.equals(RandomizedQueue.DOUBLE)) {
            newSize = array.length * 2;
        } else {
            newSize = array.length / 2;
        }

        Item[] newArray = Arrays.copyOf(array, newSize);
        array = newArray;
    }

    public Item sample() {
        if (this.isEmpty()) {
            throw new NoSuchElementException();
        }

        int randomIndex = getRandomIndex();
        return array[randomIndex];
    }

    private int getRandomIndex() {
        return random.nextInt(lastItemIndex + 1);
    }

    @Override
    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        Item[] iterableArray;
        int lastIterableItem;

        private RandomizedQueueIterator() {
            iterableArray = Arrays.copyOf(RandomizedQueue.this.array,
                    RandomizedQueue.this.lastItemIndex + 1);
            lastIterableItem = iterableArray.length - 1;
        }

        @Override
        public boolean hasNext() {
            return lastIterableItem > -1;
        }

        @Override
        public Item next() {
            int randomIndex = random.nextInt(lastIterableItem + 1);
            Item toReturn = iterableArray[randomIndex];

            iterableArray[randomIndex] = iterableArray[lastIterableItem];
            iterableArray[lastIterableItem--] = null;

            return toReturn;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }
    }

    public static void main(String[] args) {
        RandomizedQueue<Integer> intRQ = new RandomizedQueue<>();
        intRQ.enqueue(1);
        intRQ.enqueue(2);
        intRQ.enqueue(3);
        intRQ.enqueue(4);
        intRQ.enqueue(5);
        intRQ.enqueue(6);
        intRQ.enqueue(7);
        intRQ.enqueue(8);
        intRQ.enqueue(9);
        intRQ.enqueue(10);
        intRQ.enqueue(11);
        intRQ.enqueue(12);
        intRQ.enqueue(13);
        intRQ.enqueue(14);

        for (Integer i : intRQ) {
            System.out.println(i);
        }

        System.out.println();
        System.out.println("Now dequeueing");
        System.out.println(intRQ.dequeue());
        System.out.println(intRQ.dequeue());
        System.out.println(intRQ.dequeue());
        System.out.println(intRQ.dequeue());
        System.out.println(intRQ.dequeue());
        System.out.println(intRQ.dequeue());
        System.out.println(intRQ.dequeue());
        System.out.println(intRQ.dequeue());
        System.out.println(intRQ.dequeue());
        System.out.println(intRQ.dequeue());

        System.out.println();
        System.out.println("After Dequeueing");
        for (Integer i : intRQ) {
            System.out.println(i);
        }
    }

}
