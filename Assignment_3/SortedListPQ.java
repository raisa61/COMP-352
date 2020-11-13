import java.util.Comparator;


//An implementation of a priority queue with a sorted list.
public class SortedListPQ<K,V> extends AbstractPriorityQueue<K,V> {
	
	//---------------- nested Node class ----------------
		 private static class Node<E> implements Position<E> {
		 private E element; // reference to the element stored at this node
		 private Node<E> prev; // reference to the previous node in the list
		 private Node<E> next; // reference to the subsequent node in the list
		 public Node(E e, Node<E> p, Node<E> n) {
		 element = e;
		 prev = p;
		 next = n;
		 }
		 public E getElement( ) throws IllegalStateException {
		 if (next == null) // convention for defunct node
		 throw new IllegalStateException("Position no longer valid");
		 return element;
		 }
		 public Node<E> getPrev( ) {
		 return prev;
		 }
		 public Node<E> getNext( ) {
		 return next;
		 }
		 public void setElement(E e) {
		 element = e;
		 }
		 public void setPrev(Node<E> p) {
		 prev = p;
		 }
		 public void setNext(Node<E> n) {
		 next = n;
		 }
		
		 } //----------- end
		 
		 public Node<Entry<K,V>> header; 
		 public Node<Entry<K,V>> trailer; 
		 public int size=0;
// primary collection of priority queue entries
	private PositionalList<Entry<K,V>> list = new LinkedPositionalList<>( );

//Creates an empty priority queue based on the natural ordering of its keys.
public SortedListPQ( ) { super( ); }
//Creates an empty priority queue using the given comparator to order keys.
public SortedListPQ(Comparator<K> comp) { super(comp); }

//Inserts a key-value pair and returns the entry created.
public Entry<K,V> insert(K key, V value) throws IllegalArgumentException {
	checkKey(key); // auxiliary key-checking method (could throw exception)
	Entry<K,V> newest = new PQEntry<>(key, value);
	Position<Entry<K,V>> walk = list.last( );
	
// walk backward, looking for smaller key
	while (walk != null && compare(newest, walk.getElement( )) < 0)
		walk = list.before(walk);
	if (walk == null)
		list.addFirst(newest); // new key is smallest
	else
		list.addAfter(walk, newest); // newest goes after walk
	return newest;
}

//Returns (but does not remove) an entry with minimal key.
 public Entry<K,V> min( ) {
	 if (list.isEmpty( )) return null;
 return list.first( ).getElement( );
 }

 //Removes and returns an entry with minimal key.
 public Entry<K,V> removeMin( ) {
	 if (list.isEmpty( )) return null;
 return list.remove(list.first( ));
 }

//Returns the number of items in the priority queue.
 public int size( ) { return list.size( ); }
 

//checks if the queue is empty
public boolean isEmpty() {
	// TODO Auto-generated method stub
	if (list.size()==0) return true;
	 return false;
}

//returning the first element in the list
public V first_element() {
	
	return list.first().getElement().getValue();
}

//to return the first position in a list
public Position<Entry<K, V>> first( ) {
	return list.first();
	
}

//to get the element at a given position
public Entry<K,V> get_element(Position<Entry<K,V>> p) {
	
	return p.getElement();
	
}

//method to return the position as a node 
public Node<Entry<K, V>> validate(Position<Entry<K,V>> p) throws IllegalArgumentException {
	   if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
	   Node<Entry<K,V>> node = (Node<Entry<K,V>>) p; // safe cast
	   if (node.getNext( ) == null) // convention for defunct node
	   throw new IllegalArgumentException("p is no longer in the list");
	   return node;
	   }


//returning the given node as a position
public Position<Entry<K, V>> position(Node<Entry<K,V>> node) {
	   if (node == header || node == trailer)
	   return null; // do not expose user to the sentinels
	   return node;
	   }

//to accsess the position after the given position
public Position<Entry<K, V>> after(Position<Entry<K, V>> p) {
	Node<Entry<K,V>> node = validate(p);
	System.out.println();
	System.out.println("The string is " +p);
	return position(node.getNext( ));
	
}

//method to remove a position
public Entry<K, V> remove(Position<Entry<K, V>> p) throws IllegalArgumentException {
	if (list.isEmpty( )) return null;
	return list.remove(p);
}




}
