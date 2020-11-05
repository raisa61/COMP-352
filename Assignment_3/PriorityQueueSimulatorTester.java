import java.util.Random;

public class PriorityQueueSimulatorTester {

	public static void main(String[] args) {
		
		/**
		 * creating the job array
		 */
		Job[] jobsInputArray = new Job [100];
		
		/**
		 * genration of random job lengths between 1 and 70
		 */
		Random rand= new Random();
		int rand1=rand.nextInt((70 - 1) + 1) + 1;
		int rand2=rand.nextInt((70 - 1) + 1) + 1;
		int rand3=rand.nextInt((70 - 1) + 1) + 1;
		int rand4=rand.nextInt((70 - 1) + 1) + 1;
		int rand5=rand.nextInt((70 - 1) + 1) + 1;
		int rand6=rand.nextInt((70 - 1) + 1) + 1;
		int rand7=rand.nextInt((70 - 1) + 1) + 1;
		int rand8=rand.nextInt((70 - 1) + 1) + 1;
		int rand9=rand.nextInt((70 - 1) + 1) + 1;
		int rand10=rand.nextInt((70 - 1) + 1) + 1;
		
		/**
		 * generation of random job priorities
		 */
		int pr1= rand.nextInt((40 - 1) + 1) + 1;
		int pr2= rand.nextInt((40 - 1) + 1) + 1;
		int pr3= rand.nextInt((40 - 1) + 1) + 1;
		int pr4= rand.nextInt((40 - 1) + 1) + 1;
		int pr5= rand.nextInt((40 - 1) + 1) + 1;
		int pr6= rand.nextInt((40 - 1) + 1) + 1;
		int pr7= rand.nextInt((40 - 1) + 1) + 1;
		int pr8= rand.nextInt((40 - 1) + 1) + 1;
		int pr9= rand.nextInt((40 - 1) + 1) + 1;
		int pr10= rand.nextInt((40 - 1) + 1) + 1;
		
		/**
		 * creating the jobs (creating 10 for test)
		 */
		Job j1= new Job("JOB_1",rand1,rand1,pr1,pr1,0,0,0); 
		Job j2= new Job("JOB_2",rand2,rand2,pr2,pr2,0,0,0); 
		Job j3= new Job("JOB_3",rand3,rand3,pr3,pr3,0,0,0); 
		Job j4= new Job("JOB_4",rand4,rand4,pr4,pr4,0,0,0); 
		Job j5= new Job("JOB_5",rand5,rand5,pr5,pr5,0,0,0); 
		Job j6= new Job("JOB_6",rand6,rand6,pr6,pr6,0,0,0); 
		Job j7= new Job("JOB_7",rand7,rand7,pr7,pr7,0,0,0); 
		Job j8= new Job("JOB_8",rand8,rand8,pr8,pr8,0,0,0); 
		Job j9= new Job("JOB_9",rand9,rand9,pr9,pr9,0,0,0); 
		Job j10= new Job("JOB_10",rand10,rand10,pr10,pr10,0,0,0); 
		
		/**
		 * filling the array with the objects
		 */
		jobsInputArray[0]=j1;
		jobsInputArray[1]=j2;
		jobsInputArray[2]=j3;
		jobsInputArray[3]=j4;
		jobsInputArray[4]=j5;
		jobsInputArray[5]=j6;
		jobsInputArray[6]=j7;
		jobsInputArray[7]=j8;
		jobsInputArray[8]=j9;
		jobsInputArray[9]=j10;
		
		//getting null pointer error for these parts
		/**
		 * printing the initial array objects
		 */
		for(int i=0; i<jobsInputArray.length; i++) {
			System.out.println(jobsInputArray[i].toString());
		}
		
		System.out.println();
		/**
		 *dumping the array objects in the heap
		 */
		ArrayListHeap<Integer, Job> heap = new ArrayListHeap<Integer, Job>();
		for(int i=0; i<jobsInputArray.length; i++) {
			heap.insert(jobsInputArray[i].getJobPriority(), jobsInputArray[i]);
			
		}
		
		/**
		 * removing the objects in a sorted order
		 */
		for(int i=0; i<jobsInputArray.length; i++) {
			System.out.println(heap.removeMin());
			
		}
		
		
	}

}
