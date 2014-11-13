package assign2.deque;

import java.util.Iterator;

public class Deque<Item> implements Iterable<Item> {

	private Node<Item> sentinel;
	private int size;
	
	private static class Node<Item> {
		private Item item;
		private Node<Item> next;
		private Node<Item> prev;
	}
	
	public Deque() {
		sentinel = new Node<>();
		sentinel.next = sentinel;
		sentinel.prev = sentinel;
		sentinel.item = null;
		size = 0;
	}
	
	public boolean isEmpty() {
		return size == 0;
	}
	
	public int size() {
		return size;
	}
	
	public void addFirst(Item item) {
		Node<Item> newOne = new Node<>();
		newOne.item = item;
		if (sentinel.prev == null) {
			sentinel.prev = newOne;
			newOne.next = sentinel;
		}
		newOne.next = sentinel.next;
		sentinel.next = newOne;
	}
	
	@Override
	public Iterator<Item> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
