
public interface PositionalList<E> {
	
	/**
	 * returns the number of elements in the list
	 */
	int size( );
	
	/**
	 * checking whether the list is empty
	 */
	boolean isEmpty( );

	/**
	 * returns the first position in the list
	 */
	Position<E> first( );

	/**
	 * returns the last position in the list
	 */
	Position<E> last( );
	
	/**
	 * returns the position before p
	 */
	Position<E> before(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * returns the position after p
	 */
	Position<E> after(Position<E> p) throws IllegalArgumentException;
	
	/**
	 * inserting element at index 0
	 */
	Position<E> addFirst(E e);
	
	/**
	 * inserting element at the end
	 */
	Position<E> addLast(E e);
	
	/**
	 * inserting element before given index
	 */
	Position<E> addBefore(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * inserting element after given index
	 */
	Position<E> addAfter(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * replacing the element stored at position p
	 */
	E set(Position<E> p, E e) throws IllegalArgumentException;
	
	/**
	 * removing the element stored at position p
	 */
	E remove(Position<E> p) throws IllegalArgumentException;
	
}
