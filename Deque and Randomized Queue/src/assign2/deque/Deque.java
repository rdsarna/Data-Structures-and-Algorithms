package assign2.deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

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
		if (item == null) {
			throw new NullPointerException();
		}
		Node<Item> newOne = new Node<>();
		newOne.item = item;
		newOne.next = sentinel.next;
		newOne.prev = sentinel;
		sentinel.next.prev = newOne;
		sentinel.next = newOne;
		size += 1;
	}
	
	public void addLast(Item item) {
		if (item == null) {
			throw new NullPointerException();
		}
		Node<Item> newOne = new Node<>();
		newOne.item = item;
		newOne.next = sentinel;
		newOne.prev = sentinel.prev;
		sentinel.prev.next = newOne;
		sentinel.prev = newOne;
		size += 1;
	}
	
	public Item removeFirst() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		Node<Item> returnNode = sentinel.next;
		Item returnItem = returnNode.item;
		
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		size -= 1;
		return returnItem;
	}
	
	public Item removeLast() {
		if (this.isEmpty()) {
			throw new NoSuchElementException();
		}
		Node<Item> returnNode = sentinel.prev;
		Item returnItem = returnNode.item;
		
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = sentinel;
		size -= 1;
		return returnItem;
	}
	
	@Override
	public Iterator<Item> iterator() {
		return new DequeIterator();
	}
	
	private class DequeIterator implements Iterator<Item> {
		Node<Item> curr;

		public DequeIterator() {
			curr = sentinel.next;
		}
		
		@Override
		public boolean hasNext() {
			return curr.next.prev != sentinel;
		}

		@Override
		public Item next() {
			if (!hasNext()) {
				throw new NoSuchElementException();
			}
			Item returnItem =curr.item;
			curr = curr.next;
			return returnItem;
		}

		@Override
		public void remove() {
			throw new UnsupportedOperationException();
		}
	}
	
	@Override
	public String toString() {
		StringBuilder str = new StringBuilder();
		str.append("[");
		for (Item i : this) {
			str.append(i + ", ");
		}
		str.append("]");
		return str.toString();
	}

	public static void main(String[] args) {
		Deque<Integer> deque = new Deque<>();
		deque.addFirst(3);
		deque.addFirst(2);
		deque.addFirst(1);
//		System.out.println(deque);
		deque.addLast(4);
		deque.addLast(5);
//		System.out.println(deque);
		int i = deque.removeFirst();
//		System.out.println(i);
//		System.out.println(deque);
		
		for (int x : deque) {
			System.out.println(x);
			for (int y : deque) {
				System.out.println(y);
			}
		}
	}

}
