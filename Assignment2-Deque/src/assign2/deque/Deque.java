package assign2.deque;

import java.util.Iterator;

public class Deque<T> implements Iterable<T> {

	private Node head;
	private int size;
	
	private static class Node<T> {
		private T item;
		private Node<T> next;
		private Node<T> prev;
	}
	
	@Override
	public Iterator<T> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
