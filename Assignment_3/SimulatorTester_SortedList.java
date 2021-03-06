import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class SimulatorTester_SortedList{
	
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
		

		/**
		 * to keep track of the time
		 */
		 long current_time1=0;
		 
		 /**
		  * to find the sum of the wait times
		  */
		 long sum_wait1=0;
		 
		 /**
		  * to keep track of the priority changes
		  */
		 int pri_count1=0;
		
		 /**
		  * taking user input for the size of the array, 100 or 1000 or 10,000 or 100,000 or 1000000
		  */
		 System.out.println("Please enter the size you would like to execute from the options below: ");
		 System.out.println("Press /'1'/ for size 100");
		 System.out.println("Press /'2'/ for size 1000");
		 System.out.println("Press /'3'/ for size 10000");
		 System.out.println("Press /'4'/ for size 100000");
		 System.out.println("Press /'5'/ for size 1000000");
		 System.out.println();
		 System.out.print("Enter your choice-->");
		 Scanner sc= new Scanner(System.in);
		 int choice= sc.nextInt();
		 int size = 0;
		 
		 if(choice==1) {size=100;} if(choice==2) {size=1000;} if(choice==3) {size=10000;} if(choice==4) {size=100000;} if(choice==5) {size=1000000;}
		
		
		/**
		 * creating the job array
		 */
		Job[] jobsInputArray = new Job [size];

		/**
		 * filling the array with default job objects
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
		
		//setting all the end times to 0
		for(int i=0; i<jobsInputArray.length; i++) {
			jobsInputArray[i].setEndTime(0);
		}
		
		
		/**
		 * dumping the array objects in the sorted list
		 */
		SortedListPQ<Integer,Job> pq = new SortedListPQ<Integer,Job>();
		long startTime1 = System.nanoTime();
		for(int i=0; i<jobsInputArray.length; i++) {
			pq.insert(jobsInputArray[i].getFinalPriority(), jobsInputArray[i]);
			jobsInputArray[i].setEntryTime(i+1);
			current_time1++;
		}
		
		/**
		 * doing the execution
		 */
		int counter1=0;
		while (!pq.isEmpty()) {
			
		if(pq.min().getValue().getCurrentJobLength()>0) {
				
				pq.min().getValue().setCurrentJobLength(pq.min().getValue().getCurrentJobLength()-1);
				
				/**
				 * increasing the cycle, each time a job is being executed
				 */
				pq.min().getValue().setEndTime(pq.min().getValue().getEndTime()+1);
				
				
				/**
				 * setting the wait time
				 */
				pq.min().getValue().setWaitTime(Math.abs(pq.min().getValue().getEndTime()-pq.min().getValue().getEntryTime()-pq.min().getValue().getJobLength()));
				sum_wait1+= Math.abs(pq.min().getValue().getEntryTime());
				
				/**
				 * removing from the pq with highest priority
				 */
				Entry<Integer,Job> executing_job = pq.removeMin();
				Job value= executing_job.getValue();
				int key= executing_job.getKey();
				/**
				 * putting it back in the pq after all the values if the length is not 0
				 */
				pq.insert(key, value);
				counter1++; // increasing the counter1 to check for the number of the jobs executed
				current_time1++;
				
			}
		
		   /**
		    * we remove the object when the current job length is 0
		    */
		       if (pq.min().getValue().getCurrentJobLength()==0) {
                pq.removeMin();

		       }
		       
		       /**
				 * resetting the priority
				 */
				if(counter1%30==0) {
					current_time1++;
					/**
					 * looking for the oldest job in the pq
					 */
			        Position<Entry<Integer,Job>> walk = pq.first();
					System.out.println("The p is " + walk.getElement().getValue().toString());
					Job oldest = pq.first_element();
					long temp= oldest.getEntryTime();
					int temp_pos=0;
					while(walk!=null) {
						if(temp<pq.get_element(walk).getValue().getEntryTime()) {
							oldest=pq.get_element(walk).getValue();
							temp=oldest.getEntryTime();	
						}
						walk=pq.after_position(walk);
						
					}
					
					
					//}
					/**STARVATION PROCESS
					 * checking if the oldest job in the pq has been executed or not, if not, then reset priority
					 * if the initial job length and the current job length is same, means it has never been executed before, cause we 
					 * decrease the current job length by 1 each time we execute a job
					 */
					if (oldest.getJobLength()==oldest.getCurrentJobLength()) { 
				   	oldest.setFinalPriority(1);
				   	pq.min().setKey(1);
				   	pq.min().setValue(oldest);
				   	pri_count1++; //we increase the counter1 here, after the starvation process
					}
						
				}
				
			}
				
				long  endTime1 = System.nanoTime();
				long timeElapsed = endTime1 - startTime1;
				
				
				/**
				 * printing the outputs
				 */
				System.out.println();
				System.out.println("Current System Time(cycles): "+current_time1);
				System.out.println("Total number of jobs executed: " + jobsInputArray.length + " jobs");
				System.out.println("Average Process Waiting Time: " + (sum_wait1/jobsInputArray.length) + " cycles" );
				System.out.println("Total number of priority changes: "+pri_count1);
				System.out.println("Actual system time needed to execute all jobs: " + (timeElapsed / 1000000) + " ms");	 
				
				}
					
			
		
	}

