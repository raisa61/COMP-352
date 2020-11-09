import java.util.Comparator;

public class AbstractPriorityQueue<K,V> {
	
   /**
    *nested class
    * @param <K>
    * @param <V>
    */
	protected static class PQEntry<K,V> implements Entry<K,V> {
		private K k;
		private V v;
		
		public PQEntry(K key, V value) {
			k=key;
			v=value;	
	}
		/**
		 * methods from the interface
		 */
		public K getKey( ) { return k; }
		public V getValue( ) { return v; }
		
		/**
		 * setters
		 */
		protected void setKey(K key) { k = key; }
		protected void setValue(V value) { v = value; }
		
		@Override
		public String toString() {
			return v + ".";
		}
		
		}
	
	//end of the nested class
	private Comparator<K> comp;
	
	/**
	 * empty priority queue using the given comparator to compare keys
	 * @param c
	 */
	protected AbstractPriorityQueue(Comparator<K> c) { comp = c; }
	
	/**
	 * empty priority queue based on the natural ordering of its keys.
	 */
	protected AbstractPriorityQueue( ) { this(new DefaultComparator<K>( )); }
	
	/**
	 * method for comparing two entries according to their keys
	 */
	protected int compare(Entry<K,V> a, Entry<K,V> b) {
		return comp.compare(a.getKey( ), b.getKey( ));
	}
	
	/**
	 * determining whether a key is valid or not
	 */
	protected boolean checkKey(K key) throws IllegalArgumentException {
		try {
			return (comp.compare(key,key) == 0); //checking if key can be compared to itself
		}
		catch (ClassCastException e) {
			throw new IllegalArgumentException("Incompatible key");
		}
	}
	
	/** error in these parts Idk how to determine the size, should I introduce a size variable??
	 * returning the size
	 
	public int size() {
		return AbstractPriorityQueue.size();
	}
	
	 * checking whether the priority queue is empty
	 //Kim: even for this you can go AbstractPriorityQueue.size()==0
	 //I need to know what you're trying to do cause check this out
	 //lets say we're doing this in main
        PriorityQueue<String> pq=
                new PriorityQueue<String>(a,b);
     //....
      // you can do while (pq.size() != 0)
        //{
          //  System.out.println(pq.remove()); ...
        //}
    //}
	 
	public boolean isEmpty( ) { return size( ) == 0; }
	*/
	
}
