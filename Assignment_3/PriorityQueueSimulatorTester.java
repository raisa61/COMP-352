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
	
	
	public static void main(String[] args) {
		int pri_count=0;
		
		/**
		 * to keep track of the time
		 */
		 long current_time=0;
		 float Average=0;
		
		
		/**
		 * creating the job array
		 */
		Job[] jobsInputArray = new Job [100];
		
		/**
		 * filling the array with deafult job objects
		 */
		for(int i=0; i<jobsInputArray.length;i++) {
			jobsInputArray[i]= new Job("a",0,0,0,0,0);
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
		long startTime = System.nanoTime();
		ArrayListHeap<Integer, Job> heap = new ArrayListHeap<Integer, Job>();
		for(int i=0; i<jobsInputArray.length; i++) {
			heap.insert(jobsInputArray[i].getJobPriority(), jobsInputArray[i]);
			jobsInputArray[i].setEntryTime(i+1);
			current_time++;
			heap.get(i).getValue().setEndTime(0);
			
			
		}
		
		/**
		 * trying the execution thing in a sorted order based on priority 
		 */
		int counter =0;
		//int ctr=0;

		    
			while(!heap.isEmpty()) {
			
				//heap.min().getValue().setCycle_counter(0);
			if(heap.min().getValue().getCurrentJobLength()>0) {
				
				heap.min().getValue().setCurrentJobLength(heap.min().getValue().getCurrentJobLength()-1);
				
			
				
				/**
				 * increasing the cycle, each time a job is being executed
				 */
				heap.min().getValue().setEndTime(heap.min().getValue().getEndTime()+1);
				
				/**
				 * setting the wait time
				 */
				//heap.min().getValue().setWaitTime(1);
				heap.min().getValue().setWaitTime(Math.abs(heap.min().getValue().getEndTime()-heap.min().getValue().getEntryTime()-heap.min().getValue().getJobLength()));
				/*
				int i;
				long sum=0;
				long avg=0;
				
				for (i=0; i<99;i++) {
					sum += heap.get(i).getValue().getWaitTime();
					System.out.println("sum:"+sum); 
				}
				avg = Math.abs(sum) / 100;
				Average=avg;
			*/
				
				/**
				 * removing from the heap with highest priority
				 */
				Entry<Integer,Job> executing_job = heap.removeMin();
				int key= executing_job.getKey();
				Job value= executing_job.getValue();
				
				/**
				 * putting it back in the heap after all the values if the length is not 0
				 */
				heap.insert(key, value);
				
				System.out.println("without removing the object");
				System.out.println(heap.min().toString());
				System.out.println();
				counter++;
				
				current_time++;
				
			}
			
			/**
			 * reseting the priority
			 */
			if(counter%30==0) {
				
				current_time++;
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
				pri_count++;
				
			}
			

			
			if (heap.min().getValue().getCurrentJobLength()==0) {

				
				
		        //to check if all the jobs are getting out of the heap or not
				System.out.println("when we remove the object");
				System.out.println(heap.removeMin().toString());
				
				
				
			}
			
			
			
				}
			long  endTime = System.nanoTime();
			long timeElapsed = endTime - startTime;
			
			System.out.println("Pri_count:"+pri_count);
			
			System.out.println("current time:"+current_time);
			
			System.out.println("avg:"+Average); 
			System.out.println("Execution time in milliseconds : " +
					timeElapsed / 1000000);	 
			
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


