import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class PriorityQueueSimulatorTester {
	static Random rand= new Random();
	/**
	 * generating the lengths randomly
	 */
	public static void length_generate(Job []array) {
		for (int i=0; i<array.length; i++) {
			int rand_length=rand.nextInt((70 - 1) + 1) + 1;
			array[i].setJobLength(rand_length);
			array[i].setCurrentJobLength(rand_length);
		}
		
	}
	
	/**
	 * generating the names based on the indexes
	 */
	public static void name_generate (Job[] array) {
		for (int i=0; i<array.length;i++) {
			array[i].setJobName("Job_"+ (i+1));
		}
	}
	
	/**
	 * generating the priorities randomly
	 */
	public static void priority_generate (Job[] array) {
		for (int i=0; i<array.length;i++) {
			int rand_pr= rand.nextInt((40 - 1) + 1) + 1;
			array[i].setJobPriority(rand_pr);
			array[i].setFinalPriority(rand_pr);
		}
	}
	
	
//---------------------------don't think we need a method anymore ------------------------------------//
	public static int reset_priority (ArrayListHeap<Integer, Job> heap) {
		if (heap.isEmpty( )) 
			return 0;
		int j=0;
	    int index=0;
		long min= heap.get(j).getValue().getEntryTime();
        for (int k=0; k<heap.size(); k++) {  
        	
                  if(heap.get(k).getValue().getEntryTime() < min){ 
                     min = heap.get(k).getValue().getEntryTime(); 
                    
                     index=k;
                    } 
                  
                    
        }
        return index;
          
	}
	
	/*public static void starvation (ArrayListHeap<Integer, Job> heap) {
		
		long oldest = heap.get(0).getValue().getEntryTime();
		int temp_pos = 0;
		
		for (int i = 1; i<heap.size(); i++) {
			if (oldest < heap.get(i).getValue().getEntryTime()) {
				oldest = heap.get(i).getValue().getEntryTime();
				temp_pos = i;
				
				//oldest = oldest.getValue().getEntryTime();
			}
		}
		heap.get(temp_pos).getValue().setFinalPriority(0);
		upheap(temp_pos);
		heap.get(temp_pos).getValue().setFinalPriority(1);
		
		
	}
	private final void bubbleUp(int position) {
		// base case 
		if (position == 0) return;
		if (compare(heap.get(parent(position)),heap.get(position))>0) {
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
	*/
	
	
	public static void main(String[] args) {
		
		/**
		 * creating the job array
		 */
		Job[] jobsInputArray = new Job [100];
		
		/**
		 * filling the array with deafult job objects
		 */
		for(int i=0; i<jobsInputArray.length;i++) {
			jobsInputArray[i]= new Job("a",0,0,0,0,0,0,0);
		}
		
		/**
		 * setting the name, lengths and priority according to the conditions
		 */
		name_generate(jobsInputArray);
		length_generate(jobsInputArray);
		priority_generate(jobsInputArray);
		
		
		
		/**
		 *dumping the array objects in the heap
		 */
		ArrayListHeap<Integer, Job> heap = new ArrayListHeap<Integer, Job>();
		for(int i=0; i<jobsInputArray.length; i++) {
			heap.insert(jobsInputArray[i].getJobPriority(), jobsInputArray[i]);
			jobsInputArray[i].setEntryTime(i+1);
			
		}
		
		/**
		 * trying the execution thing in a sorted order based on priority 
		 */
		int counter =0;
		int ctr=0;


		
		//for(int i=0; i<heap.size(); i++) {
			
			while(!heap.isEmpty()) {
				
			//for(int i=0; i<heap.size(); i++) {
				//System.out.println(heap.size());
				
				
			//Entry<Integer,Job> executing_job = heap.removeMin();
			//int key= executing_job.getKey();
			//Job value= executing_job.getValue();
			//reducing the length by 1 when it's being executed
			//executing_job.getValue().setCurrentJobLength(executing_job.getValue().getCurrentJobLength()-1);
			
			/**
			 * the counter is to check for the smallest time and reseting the priority
			 */
			//counter++;
			
			//System.out.println(executing_job.toString());
			/**
			 * if the length is more than 0, put it back in the heap
			 */
			
				
			if(heap.min().getValue().getCurrentJobLength()>0) {
				
				//int key= executing_job.getKey();
				//Job value= executing_job.getValue();
				
				heap.min().getValue().setCurrentJobLength(heap.min().getValue().getCurrentJobLength()-1);
				System.out.println("without removing the object");
				System.out.println(heap.min().toString());
				System.out.println();
				counter++;
				
				
			}
			if (heap.min().getValue().getCurrentJobLength()==0) {
				System.out.println();
				System.out.println("when we remove the object");
				System.out.println(heap.removeMin().toString());
				System.out.println();
				
			}
			
			/**
			 * reseting the priority
			 */
			if(counter%30==0) {
				
				//int index=reset_priority(heap);
				//heap.get(index).getValue().setJobPriority(1);
			
				//System.out.println(heap.get(index).getValue().getJobPriority());
				
				/**
				 * starvation process (matched to friends code)
				 */
				Job oldest = heap.get(0).getValue();
				long temp= oldest.getEntryTime();
				int temp_pos=0;
				for(int i=1; i<heap.size();i++) {
					if (temp<heap.get(i).getValue().getEntryTime()) {
						oldest= heap.get(i).getValue();
						temp_pos=i;
						temp=oldest.getEntryTime();
					}
				}
				/**
				 * changing the priority for starvation process
				 */
				oldest.setFinalPriority(0);
				heap.upheap(temp_pos);
				oldest.setFinalPriority(1);
				
			}
			
				}
			
			}
			
			
			 
			
		//}
		
		
		//------------code upto this part works fine----------------
		
		
		 //testing the insertion method from the Sorted List queue class
		 
		/*SortedListPQ<Integer, Job> PQ = new SortedListPQ<Integer, Job>();
		for(int i=0; i<jobsInputArray.length; i++) {
			PQ.insert(jobsInputArray[i].getJobPriority(), jobsInputArray[i]);
			
		}
		
		
		 //testing the removeMin method from the Sorted list queue class
		 
		ArrayList<Entry<Integer,Job>> sorted_array2 = new ArrayList<>( );
		for(int i=0; i<jobsInputArray.length; i++) {
			sorted_array2.add(PQ.removeMin());
		}
		
		
		 //printing out the sorted array from the PQ class
		 
		System.out.println("Method from the SortedListPQ class");
		for (Entry<Integer, Job> sorted: sorted_array2) {
            System.out.println(sorted.toString());
        }
        */
		
		
		
	}


