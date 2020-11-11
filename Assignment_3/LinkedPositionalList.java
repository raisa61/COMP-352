
public class LinkedPositionalList<E> implements PositionalList<E> {
	
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
	 } //----------- end of nested Node class -----------
	 
	/**
	 *  instance variables of the LinkedPositionalList
	 */
	  private Node<E> header; 
	  private Node<E> trailer; 
	  private int size = 0; // number of elements in the list
	 
	  /**
	   * constructing a new empty list
	   */
	  public LinkedPositionalList( ) {
	  header = new Node<>(null, null, null); // create header
	  trailer = new Node<>(null, header, null); // trailer is preceded by header
	  header.setNext(trailer); // header is followed by trailer
	  }

	  /**
	   * validating the position and returning it as a node
	   * @param p
	   * @return
	   * @throws IllegalArgumentException
	   */
	  private Node<E> validate(Position<E> p) throws IllegalArgumentException {
		   if (!(p instanceof Node)) throw new IllegalArgumentException("Invalid p");
		   Node<E> node = (Node<E>) p; // safe cast
		   if (node.getNext( ) == null) // convention for defunct node
		   throw new IllegalArgumentException("p is no longer in the list");
		   return node;
		   }
	  
	  /**
	   * returning the given node as a position
	   * @param node
	   * @return
	   */
	  private Position<E> position(Node<E> node) {
		   if (node == header || node == trailer)
		   return null; // do not expose user to the sentinels
		   return node;
		   }
	  
	  /**
	   * returning the number of elements in a list
	   */
	  public int size( ) { return size; }
	  
	  /**
	   * to check if the list is empty
	   */
	  public boolean isEmpty( ) { return size == 0; }
	  
	  /**
	   * returning the first position
	   */
	  public Position<E> first( ) {
		   return position(header.getNext( ));
		   }
	  
	  /**
	   * returning the last position
	   */
	  public Position<E> last( ) {
		   return position(trailer.getPrev( ));
		   }
	  
	  /**
	   * returns the position before position p
	   */
	  public Position<E> before(Position<E> p) throws IllegalArgumentException {
		   Node<E> node = validate(p);
		   return position(node.getPrev( ));
		   }
	  
	  /**
	   * returns the position after position p
	   */
	  public Position<E> after(Position<E> p) throws IllegalArgumentException {
		   Node<E> node = validate(p);
		   return position(node.getNext( ));
		   }
	  
	  /**
	   * to add a node between two nodes
	   * @param e
	   * @param pred
	   * @param succ
	   * @return
	   */
	  private Position<E> addBetween(E e, Node<E> pred, Node<E> succ) {
		   Node<E> newest = new Node<>(e, pred, succ); // create and link a new node
		   pred.setNext(newest);
		   succ.setPrev(newest);
		   size++;
		   return newest;
		   }
	  
	  /**
	   * adding element at the head
	   */
	  public Position<E> addFirst(E e) {
		   return addBetween(e, header, header.getNext( )); // just after the header
		   }
      
	  /**
	   * adding element at the end
	   */
	  public Position<E> addLast(E e) {
		   return addBetween(e, trailer.getPrev( ), trailer); // just before the trailer
		   }
	  
	  /**
	   * adding before given position
	   */
	  public Position<E> addBefore(Position<E> p, E e)
	   throws IllegalArgumentException {
	   Node<E> node = validate(p);
	   return addBetween(e, node.getPrev( ), node);
	   }
	  
	  /**
	   * adding after a position
	   */
	  public Position<E> addAfter(Position<E> p, E e)
	   throws IllegalArgumentException {
	   Node<E> node = validate(p);
	   return addBetween(e, node, node.getNext( ));
	   }
	  
	  /**
	   * replaces the element at position p and returns the old element
	   */
	  public E set(Position<E> p, E e) throws IllegalArgumentException {
		   Node<E> node = validate(p);
		   E answer = node.getElement( );
		   node.setElement(e);
		   return answer;
		   }
	  
	  /**
	   * removes the element stored at position p and returns it
	   */
	   public E remove(Position<E> p) throws IllegalArgumentException {
		   Node<E> node = validate(p);
		   Node<E> predecessor = node.getPrev( );
		   Node<E> successor = node.getNext( );
		   predecessor.setNext(successor);
		   successor.setPrev(predecessor);
		   size--;
		   E answer = node.getElement( );
		   node.setElement(null); // help with garbage collection
		   node.setNext(null); // and convention for defunct node
		   node.setPrev(null);
		   return answer;
		   }
	  
	  
}
