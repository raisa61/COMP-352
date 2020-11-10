package first;
import java.util.ArrayList;

public class MinHeap {
	private ArrayList<Job> minHeap;
	private static int capacity;
	private static int counter = 0;
	
	/**
	 * Helping method which returns the index of the parent
	 * @param position - int
	 * @return int which is the index of the parent of position
	 */
	private int parent(int position) {
		return (position-1)/2;
	}
	
	/**
	 * Helping method which returns index of the left child
	 * @param position - int
	 * @return int which is the index of the left child
	 */
	private final int leftChild(int position) {
		return 2*(position) + 1; 
	}
	
	/**
	 * Helping method which returns index of the right child
	 * @param position - int
	 * @return int which is the index of the right child
	 */
	private final int rightChild(int position) {
		return 2*(position) + 2; 
	}
	
	/**
	 * Method to check if there is a left child
	 * @param position - positon of the current parent
	 * @return boolean - true or false
	 */
	private final boolean hasLeft(int position) {
		if (leftChild(position) >= capacity-1)
			return false;
		else 
			return true;
	}
	
	/**
	 *  Method to check if there is a right child
	 * @param position - position of the current parent
	 * @return boolean - true or false
	 */
	private final boolean hasRight(int position) {
		if (rightChild(position) >= capacity)
			return false;
		else 
			return true;
	}
	
	
	
	/**
	 * Constructor
	 */
	public MinHeap() {
		MinHeap.capacity = 0;
		minHeap = new ArrayList<Job>();
	}
	
	
	/**
	 * Insert Object to the Heap
	 * @param value - int
	 */
	public void insert(Job value) {
		// first element and it is already a heap
		if(capacity == 0) {
			capacity++;
			minHeap.add(value);
			
		} else {
			capacity++;
			minHeap.add(value);
			// verify minHeap
			if(minHeap.get(capacity-1).compare(minHeap.get(parent(capacity-1)))) {
				bubbleUp(capacity-1);
			}
		} 
	}
	
	
	/**
	 * Helping method to restore the state of a minHeap
	 * @param position - int, position of the current Job
	 */

	private final void bubbleUp(int position) {
		// base case 
		if (position == 0) return;
		if (minHeap.get(parent(position)).compare(minHeap.get(position))) {
			return;
		} else {
			// swapping parent and child to restore minHeap
//			Job temp = minHeap.get(parent(position));
	//		minHeap.set(parent(position), minHeap.get(position));
		//	minHeap.set(position, temp);
			swap(parent(position), position);
			bubbleUp(parent(position));
		}
	}
	

	/**
	 * Method to restore the heap property
	 * @param position - position of a job
	 */
	/*
	private final void heapify(int position) {
		// No existing child
		if (leftChild(position) >= capacity || rightChild(position) >= capacity) {
			return;
		}
		// only left child 
		else if (leftChild(position) < capacity || rightChild(position) >= capacity){
			int left = leftChild(position);	// return left child position
		}
		int left = leftChild(position);	// return left child position
		int right = rightChild(position);	// return left child position
		
		if(minHeap.get(position).compare(minHeap.get(left)) && minHeap.get(position).compare(minHeap.get(right))) {
			return;
		} else {
			// true if left has better priority than right
			if (minHeap.get(left).compare(minHeap.get(right))) {
				Job temp = minHeap.get(position);
				minHeap.set(position, minHeap.get(left));
				minHeap.set(left, temp);
				heapify(left);
				
			} else if (minHeap.get(right).compare(minHeap.get(left))){
				Job temp = minHeap.get(position);
				minHeap.set(position, minHeap.get(right));
				minHeap.set(right, temp);
				heapify(right);
				
			} else if (minHeap.get(right).equalPriority(minHeap.get(left))) {
				// right entered before left
				if (minHeap.get(right).getEntryTime() < minHeap.get(right).getEntryTime()){
					Job temp = minHeap.get(position);
					minHeap.set(position, minHeap.get(right));
					minHeap.set(right, temp);
					heapify(right);
				} else {
					Job temp = minHeap.get(position);
					minHeap.set(position, minHeap.get(left));
					minHeap.set(left, temp);
					heapify(left);					
				}
			}
		}
	}
	*/
	private final void heapify(int position) {
		
		// No existing child
		if (leftChild(position) >= capacity && rightChild(position) >= capacity) {
			System.out.println("No more children");
			return;
		}
		
		// only left child 
		if (leftChild(position) <= capacity-1 && rightChild(position) >= capacity) {
			// if this is true swap left with pos
			if (minHeap.get(leftChild(position)).compare(minHeap.get(position))){
				System.out.println("swap when there's only 1 left");
				swap(leftChild(position), position);
				return;
			}	
			else {
				System.out.println("parent is smaller than left");
				return;
			}
		}
		
		// parent is smaller than children
		if(minHeap.get(position).compare(minHeap.get(leftChild(position))) && minHeap.get(position).compare(minHeap.get(rightChild(position)))) {
			System.out.println("parent is smaller than children");
			return;
		}	
		
		else {
			int left = leftChild(position);		// return left child position
			int right = rightChild(position);	// return left child position
			
			// true if left has higher priority than right
			if (minHeap.get(left).compare(minHeap.get(right))) {
				System.out.println("swapping left");
				swap(left, position);
				heapify(left);
				
			} 
			
			// right has higher priority
			else if (minHeap.get(right).compare(minHeap.get(left))){
				System.out.println("swapping right");
				swap(right, position);
				heapify(right);				
			} 
			
			// equal priority
			else if (minHeap.get(right).equalPriority(minHeap.get(left))) {
				// right entered before left
				if (minHeap.get(right).getEntryTime() < minHeap.get(right).getEntryTime()){
					System.out.println("swap right2");
					swap(right, position);
					heapify(right);
				} else {
					System.out.println("swap left2");
					swap(left, position);
					heapify(left);					
				}		
			}
		}	
	}
	
	// swapping 2 nodes in the heap
	private void swap(int job1, int job2) {
//		System.out.println("SWAPPING");
		Job temp = minHeap.get(job1);
		minHeap.set(job1, minHeap.get(job2));
		minHeap.set(job2, temp);
	}
	
	public void removeMin() {
		Job temp = minHeap.get(0);	
		if (temp.getCurrentJobLength() == 0) {
			minHeap.set(0, minHeap.get(capacity-1));
			minHeap.set(capacity-1, null);
			capacity--;		
			heapify(0);	//until min heap is restored
			counter++;
		}
		
		else {
			minHeap.set(0, minHeap.get(capacity-1));
			minHeap.set(capacity-1, temp);
			temp.setCurrentJobLength(temp.getCurrentJobLength()-1);
			bubbleUp(capacity-1);
//			if (hasLeft(0) && hasRight(0)) {
	//			heapify(1);
		//		heapify(2);
			//}
			
			if (hasLeft(0)) {
				heapify(1);
			}
			if (hasRight(0)) {
				heapify(2);
			}

		}
		
		heapify(0);	//until min heap is restored
		counter++;
		if (counter % 30 == 0) {
			starvationProcess();
		}
		
	}
	
	/**
	 * 
	 */
	public void starvationProcess() {
		Job oldest = minHeap.get(0);
		long temp = oldest.getEntryTime();
		int temp_pos = 0;
		
		for (int i = 1; i<minHeap.size(); i++) {
			if (temp < minHeap.get(i).getEntryTime()) {
				oldest = minHeap.get(i);
				temp_pos = i;
				temp = oldest.getEntryTime();
			}
		}
		// changing priority for starvation process
		// putting 0 so that it moves to the root
		oldest.setFinalPriority(0);
		bubbleUp(temp_pos);	
		oldest.setFinalPriority(1);
	}
	
	public void print() {
		for (int i = 0; i < minHeap.size(); i++) {
			System.out.println(minHeap.get(i));
			//System.out.println(" ---> ");
		}
	}
	
	
	
}
