import java.util.ArrayList;
import java.util.LinkedList;

public class DoublyLinkedList {

	// Nested node class
	private static class Node {
		private String key;
		private Student value;

		private Node prev;

		private Node next;

		/**
		 * 
		 * @param key_pass   The VIN
		 * @param value_pass The Student
		 * @param p          The previous node
		 * @param n          The next node
		 */
		public Node(String key_pass, Student value_pass, Node p, Node n) {
			key = key_pass;
			value = value_pass;
			prev = p;
			next = n;
		}

		/**
		 * 
		 * @return key of node
		 */
		public String getKey() {
			return key;
		}

		/**
		 * 
		 * @return The Student of node
		 */
		public Student getValue() {
			return value;
		}

		/**
		 * 
		 * @return Previous node
		 */
		public Node getPrev() {
			return prev;
		}

		/**
		 * 
		 * @return Next node
		 */
		public Node getNext() {
			return next;
		}

		/**
		 * 
		 * @param p Previous node
		 */
		public void setPrev(Node pre) {
			prev = pre;
		}

		/**
		 * 
		 * @param n NExt node
		 */
		public void setNext(Node nex) {
			next = nex;
		}

	} // ----------- end of nested Node class -----------

	private Node header;

	private Node trailer;

	private int size = 0;

	/**
	 * Create empty list
	 */
	public DoublyLinkedList() {
		header = new Node(null, null, null, null);
		trailer = new Node(null, null, header, null);
		header.setNext(trailer);
	}

	/**
	 * 
	 * @return Size of linked list
	 */
	public int size() {
		return size;
	}

	/**
	 * 
	 * @return If linked list is empty
	 */
	public boolean isEmpty() {
		return size == 0;
	}

	/**
	 * 
	 * @return First element in list
	 */
	public String firstKey() {
		if (isEmpty())
			return null;
		return header.getNext().getKey(); // first element is after header
	}

	/**
	 * 
	 * @return Last element in list
	 */
	public String lastKey() {
		if (isEmpty())
			return null;
		return trailer.getPrev().getKey(); // last element is before trailer
	}

	/**
	 * 
	 * @return First Student in list
	 */
	public Student firstValue() {
		if (isEmpty())
			return null;
		return header.getNext().getValue(); // first element is after header
	}

	/**
	 * 
	 * @return Last Student in list
	 */
	public Student lastValue() {
		if (isEmpty())
			return null;
		return trailer.getPrev().getValue(); // last element is before trailer
	}

	/**
	 * 
	 * @param key_pass   VIN
	 * @param value_pass Student of VIN Adds this element to front of list
	 */
	public void addFirst(String key_pass, Student value_pass) {
		addBetween(key_pass, value_pass, header, header.getNext()); // place just after the header
	}

	/**
	 * 
	 * @param key_pass   VIN
	 * @param value_pass Student of VIN Adds this element to end of list
	 */
	public void addLast(String key_pass, Student value_pass) {
		addBetween(key_pass, value_pass, trailer.getPrev(), trailer); // place just before the trailer
	}

	/**
	 * Removes and return the first element in the list.
	 */
	public void removeFirst() {
		if (isEmpty())
			return; // nothing to remove
		remove(header.getNext()); // first element is beyond header
	}

	/**
	 * Removes and returns the last element in the list.
	 */
	public void removeLast() {
		if (isEmpty())
			return; // nothing to remove
		remove(trailer.getPrev());
	}

	/**
	 * 
	 * @param key_pass    VIN to be added
	 * @param value_pass  Student to be added
	 * @param predecessor Previous node
	 * @param successor   Next node Adds this elements between nodes
	 */
	private void addBetween(String key_pass, Student value_pass, Node pred, Node succ) {
		// Create a new node
		Node newest = new Node(key_pass, value_pass, pred, succ);

		pred.setNext(newest);
		succ.setPrev(newest);
		// Increment size
		size++;
	}

	/**
	 * Removes a node
	 * 
	 * @param node to be removed
	 */
	private void remove(Node node) {
		Node predecessor = node.getPrev();
		Node successor = node.getNext();
		predecessor.setNext(successor);
		successor.setPrev(predecessor);
		size--;

	}

	/**
	 * 
	 * @param key_pass The VIN to be checked for
	 * @return If the VIN is found
	 */
	public boolean contains(String key_pass) {
		int i = 1;
		boolean flag = false;
		Node current = header;

		// Check if list is empty
		if (header == null) {
			System.out.println("List is empty");
			return false;
		}
		while (current != null && current.key != null) {
			// Compare value to be searched with every node in the doubly linked list
			if (current.key.equals(key_pass)) {
				flag = true;
				break;
			}
			current = current.next;
			i++;
		}

		return (flag);
	}

	/**
	 * 
	 * @return The doubly linked list lexicographically sorted by VIN
	 */
	public DoublyLinkedList sortList() {
		Node current = null, index = null;
		String key_tempo;
		Student value_tempo;

		// Check if list is empty
		if (header == null) {
			return this;
		} else {
			for (current = header.next; current.next != null && current.key != null; current = current.next) {
				for (index = current.next; index != null && index.key != null; index = index.next) {

					if (current.getKey().compareTo(index.getKey()) > 0) {
						key_tempo = current.getKey();
						value_tempo = current.getValue();

						current.key = index.getKey();
						current.value = index.getValue();

						index.key = key_tempo;
						index.value = value_tempo;

					}

				}
			}
			return this;
		}
	}

	/**
	 * 
	 * @param n The key whose node will be deleted
	 * @return True, if deletion was success
	 */
	public boolean deleteKey(String n) {
		// list is NULL or empty key is given
		if ((header == null && header.next == null) || n.isEmpty())
			return false;

		Node current = header;
		int i;

		for (i = 0; current != null && i < size; i++) {
			current = current.next;
			if (current.getKey().equals(n)) {
				break;
			}
		}

		if (current == null)
			return false;

		// Delete node associated with key
		remove(current);
		return true;

	}

	/**
	 * 
	 * @param key_pass The VIN whose value will be returned
	 * @return The Student with that key
	 */
	public Student getValueFromKey(String key_pass) {
		Node current = header;

		if (header == null && current.next == null) {
			return null;
		} else {
			for (current = header.next; current.next != null; current = current.next) {

				if (current.getKey().equals(key_pass)) {
					return (Student) current.getValue();
				}
			}
			return null;

		}
	}

	/**
	 * 
	 * @param key_pass VIN
	 * @return The next VIN in the list
	 */
	public String nextKey(String key_pass) {
		Node current = header;
		if (header == null && current.next == null)
			return null;
		else {
			for (current = header.next; current.next != null; current = current.next) {
				if (current.getKey().equals(key_pass)) {
					if (current.next != null)
						return current.next.getKey();

				}
			}
		}
		return null;
	}
	
	public void addHere(String k, Student v) {
		Node current = header;
		for (current = header.next; current.next != null; current = current.next) {
			if (k.compareTo(current.key)<0) {
				this.addBetween (k,v,current.prev,current);
				break;
			}
		}
	}
	

	/**
	 * 
	 * @param key_pass VIN
	 * @return The previous VIN in the list
	 */
	public String prevKey(String key_pass) {
		Node current = trailer;
		if (trailer == null)
			return null;
		else {
			for (current = trailer.prev; current.prev != null; current = current.prev) {
				if (current.getKey().equals(key_pass)) {
					if (current.prev != null)
						return current.prev.getKey();

				}
			}
		}
		return null;
	}

	/**
	 * 
	 * @param date_pass The date whose previous accidents will be found
	 * @return ArrayList of previous accidents
	 */
	/*public ArrayList<String> prevAccids(Date date_pass) {
		ArrayList<String> accidents = new ArrayList();
		Node current = trailer;
		if (trailer == null)
			return null;
		else {
			for (current = trailer.prev; current.prev != null; current = current.prev) {
				if (current.getValue().toString().equals(date_pass.toString())) {
					accidents.add(current.getKey());
				}
			}
		}
		return accidents;
	}*/

	/**
	 * 
	 * @return Lexicographically sorted list
	 */
	public LinkedList<String> allKeys() {
		LinkedList<String> sorted = new LinkedList<String>();

		Node current = trailer;
		if (trailer == null)
			return null;
		else {
			for (current = header; current.next != null; current = current.next) {
				if (current.key != null)
					sorted.add(current.getKey());
			}

		}
		return sorted;

	}
}
