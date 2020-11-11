import java.util.ArrayList;
import java.util.Comparator;

public class ArrayListHeap<K,V> extends AbstractPriorityQueue<K,V> {
	
	protected ArrayList<Entry<K,V>> heap = new ArrayList<>( );
	
	/**
	 * creating empty priority queue based on the natural order of the keys
	 */
	public ArrayListHeap( ) { super( ); }
	
	/**
	 * creating empty priority key using comparator to order the keys
	 */
	public ArrayListHeap(Comparator<K> comp) { super(comp); }
	
	/**
	 * getting the node values
	 */
	protected int parent(int j)
	{ 
		return (j-1) / 2; 
	} 
	
	protected int left(int j) 
	{ 
		return 2*j + 1; 
	}
	
	protected int right(int j) 
	{
		return 2*j + 2; 
	}
	
	protected boolean hasLeft(int j) 
	{ 
		return left(j) < heap.size( );
	}
	
	protected boolean hasRight(int j) 
	{ 
		return right(j) < heap.size( ); 
	}
	
	/**
	 * swapping the entries at indexes of the arraylist
	 */
	protected void swap(int i, int j) 
	{
		Entry<K,V> temp = heap.get(i);
		heap.set(i, heap.get(j));
		heap.set(j, temp);

	}
	
	/**
	 * upheap method to use during insertion
	 */
	protected void upheap(int j) {
		while (j > 0) //continue until you reach the root
		{ 
			int p = parent(j);
			if (compare(heap.get(j), heap.get(p)) >= 0) 
				break; //heap property verified
			
			swap(j, p);
			j = p; //continue from the parents location
			
		}
	}
	
	/**
	 * downheap method to use during removal
	 */
	protected void downheap(int j) 
	{
		while (hasLeft(j))  // continue to bottom (or break statement)
		{ 
			 int leftIndex = left(j);
			 int smallChildIndex = leftIndex; // although right may be smaller
			 
			 if (hasRight(j))
			 {
			   int rightIndex = right(j);
			   if (compare(heap.get(leftIndex), heap.get(rightIndex)) > 0)
			       smallChildIndex = rightIndex; // right child is smaller
			 }
			 if (compare(heap.get(smallChildIndex), heap.get(j)) >= 0)
			     break; // heap property has been restored
			 
			 swap(j, smallChildIndex);
			 j = smallChildIndex; // continue at position of the child
		}
	}
	
	/**
	 * method to return the size of the heap
	 * @return
	 */
	public int size( ) 
	{ 
		return heap.size( ); 
	}
	
	/**
	 * returns but does not remove the minimum(highest priority) key
	 * @return
	 */
	public Entry<K,V> min( ) {
		if (heap.isEmpty( )) 
			return null;
		return heap.get(0);

	}
	
	public V smallest_time () {
		if (heap.isEmpty( )) 
			return null;
		return heap.get(0).getValue();
		
	}
	
	/**
	 * Inserting an entry in the heap and doing upheap 
	 */
	public Entry<K,V> insert(K key, V value) throws IllegalArgumentException // O(nlogn)
	{
		checkKey(key); // auxiliary key-checking method (could throw exception)
		
		Entry<K,V> newest = new PQEntry<>(key, value); //creating an entry
		
		heap.add(newest); // add to the end of the list
		upheap(heap.size( ) - 1); // upheap newly added entry
		return newest;
		
	}
	
	/**
	 * removes and returns the entry with the highest priority key
	 */
	public Entry<K,V> removeMin( ) { // O(nlogn)
		if (heap.isEmpty( )) 
			return null;
		
	
		Entry<K,V> answer = heap.get(0); //getting the  answer from the root
		swap(0, heap.size( ) - 1); //putting the minimum item at the end
		heap.remove(heap.size( ) - 1); //removing it from the end
		downheap(0); //downheaping to restore the heap property
		
		return answer;
	}

	public boolean isEmpty() {
		// TODO Auto-generated method stub
		if (heap.size()==0) return true;
		 return false;
	}
	
	public Entry<K,V> get (int i) {
		
		return heap.get(i);
	}
	
}
