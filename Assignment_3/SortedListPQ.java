import java.util.ArrayList;
import java.util.Comparator;

public class SortedListPQ<K,V> extends AbstractPriorityQueue<K,V>  {
	
	private ArrayList<Entry<K,V>> list;
	private Comparator<K> comp;
	
	  /**
	   *  Constructor
	   */
	  public SortedListPQ() {
	    list = new ArrayList<Entry<K,V>>();
	  }
	  
	  /**
	   * to check if the queue is empty
	   */
	  public boolean isEmpty() {
		    return list.size() == 0;
		  }
	  
	  /**
	   * inserting an element in the sorted list (right position)
	   */
	  public Entry<K,V> insert(K key, V value) {
		  checkKey(key); 
		  Entry<K,V> newest = new PQEntry<>(key, value);
		  
		  //if the new key is the smallest, add it to the beginning
		  Entry<K,V>start=list.get(0); 
		  if (comp.compare(start.getKey(),newest.getKey())>0) {
			  list.add(0,newest);
		  }
		  
		//if the key is largest, we'll add it to the end
		  Entry<K,V>last=list.get(list.size()-1);
		  if(comp.compare(last.getKey(), newest.getKey())<0) {
			  list.add(list.size()-1,newest);
		  }
		  
		  //to add the key between two keys
		  int p=1;
		  while (p!=list.size()-1) {
			  Entry<K,V> before = list.get(p);
			  Entry<K,V> after = list.get(p+1);
			  
			  if ((comp.compare(before.getKey(),newest.getKey())<0) && (comp.compare(after.getKey(),newest.getKey())>0)) {
				  list.add(p+1,newest);
			  }
			  p++;
		  }
		  return newest;
		  
	  }
	  
	  public Entry<K,V> min() {
		    if (list.size() == 0)
		      return null;
		    else
		      return list.get(0);   // the first element is smallest
		  }
	  
	  public Entry<K,V> removeMin() {
		    if (list.size() == 0)
		      return null;
		    else                                  
		      return list.remove(0);  // and return the smallest element
		  }



}
