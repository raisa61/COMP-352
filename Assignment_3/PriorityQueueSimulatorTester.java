import java.util.ArrayList;
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
		
		/**
		 * creating the job array
		 */
		Job[] jobsInputArray = new Job [100];
		
		/**
		 * creating the objects with garbage values
		 */
		Job j1= new Job("a",0,0,0,0,0,0,0); Job j2= new Job("a",0,0,0,0,0,0,0); Job j3= new Job("a",0,0,0,0,0,0,0); 
		Job j4= new Job("a",0,0,0,0,0,0,0); Job j5= new Job("a",0,0,0,0,0,0,0); Job j6= new Job("a",0,0,0,0,0,0,0);
		Job j7= new Job("a",0,0,0,0,0,0,0); Job j8= new Job("a",0,0,0,0,0,0,0); Job j9= new Job("a",0,0,0,0,0,0,0); 
		Job j10= new Job("a",0,0,0,0,0,0,0); Job j11= new Job("a",0,0,0,0,0,0,0); Job j12= new Job("a",0,0,0,0,0,0,0);
		Job j13= new Job("a",0,0,0,0,0,0,0); Job j14= new Job("a",0,0,0,0,0,0,0); Job j15= new Job("a",0,0,0,0,0,0,0); 
		Job j16= new Job("a",0,0,0,0,0,0,0); Job j17= new Job("a",0,0,0,0,0,0,0); Job j18= new Job("a",0,0,0,0,0,0,0);
		Job j19= new Job("a",0,0,0,0,0,0,0); Job j20= new Job("a",0,0,0,0,0,0,0); Job j21= new Job("a",0,0,0,0,0,0,0); 
		Job j22= new Job("a",0,0,0,0,0,0,0); Job j23= new Job("a",0,0,0,0,0,0,0); Job j24= new Job("a",0,0,0,0,0,0,0);
		Job j25= new Job("a",0,0,0,0,0,0,0); Job j26= new Job("a",0,0,0,0,0,0,0); Job j27= new Job("a",0,0,0,0,0,0,0); 
		Job j28= new Job("a",0,0,0,0,0,0,0); Job j29= new Job("a",0,0,0,0,0,0,0); Job j30= new Job("a",0,0,0,0,0,0,0);
		Job j31= new Job("a",0,0,0,0,0,0,0); Job j32= new Job("a",0,0,0,0,0,0,0); Job j33= new Job("a",0,0,0,0,0,0,0); 
		Job j34= new Job("a",0,0,0,0,0,0,0); Job j35= new Job("a",0,0,0,0,0,0,0); Job j36= new Job("a",0,0,0,0,0,0,0);
		Job j37= new Job("a",0,0,0,0,0,0,0); Job j38= new Job("a",0,0,0,0,0,0,0); Job j39= new Job("a",0,0,0,0,0,0,0); 
		Job j40= new Job("a",0,0,0,0,0,0,0); Job j41= new Job("a",0,0,0,0,0,0,0); Job j42= new Job("a",0,0,0,0,0,0,0);
		Job j43= new Job("a",0,0,0,0,0,0,0); Job j44= new Job("a",0,0,0,0,0,0,0); Job j45= new Job("a",0,0,0,0,0,0,0); 
		Job j46= new Job("a",0,0,0,0,0,0,0); Job j47= new Job("a",0,0,0,0,0,0,0); Job j48= new Job("a",0,0,0,0,0,0,0);
		Job j49= new Job("a",0,0,0,0,0,0,0); Job j50= new Job("a",0,0,0,0,0,0,0);
		Job j51= new Job("a",0,0,0,0,0,0,0); Job j52= new Job("a",0,0,0,0,0,0,0); Job j53= new Job("a",0,0,0,0,0,0,0); 
		Job j54= new Job("a",0,0,0,0,0,0,0); Job j55= new Job("a",0,0,0,0,0,0,0); Job j56= new Job("a",0,0,0,0,0,0,0);
		Job j57= new Job("a",0,0,0,0,0,0,0); Job j58= new Job("a",0,0,0,0,0,0,0); Job j59= new Job("a",0,0,0,0,0,0,0); 
		Job j60= new Job("a",0,0,0,0,0,0,0); Job j61= new Job("a",0,0,0,0,0,0,0); Job j62= new Job("a",0,0,0,0,0,0,0);
		Job j63= new Job("a",0,0,0,0,0,0,0); Job j64= new Job("a",0,0,0,0,0,0,0); Job j65= new Job("a",0,0,0,0,0,0,0); 
		Job j66= new Job("a",0,0,0,0,0,0,0); Job j67= new Job("a",0,0,0,0,0,0,0); Job j68= new Job("a",0,0,0,0,0,0,0);
		Job j69= new Job("a",0,0,0,0,0,0,0); Job j70= new Job("a",0,0,0,0,0,0,0); Job j71= new Job("a",0,0,0,0,0,0,0); 
		Job j72= new Job("a",0,0,0,0,0,0,0); Job j73= new Job("a",0,0,0,0,0,0,0); Job j74= new Job("a",0,0,0,0,0,0,0);
		Job j75= new Job("a",0,0,0,0,0,0,0); Job j76= new Job("a",0,0,0,0,0,0,0); Job j77= new Job("a",0,0,0,0,0,0,0); 
		Job j78= new Job("a",0,0,0,0,0,0,0); Job j79= new Job("a",0,0,0,0,0,0,0); Job j80= new Job("a",0,0,0,0,0,0,0);
		Job j81= new Job("a",0,0,0,0,0,0,0); Job j82= new Job("a",0,0,0,0,0,0,0); Job j83= new Job("a",0,0,0,0,0,0,0); 
		Job j84= new Job("a",0,0,0,0,0,0,0); Job j85= new Job("a",0,0,0,0,0,0,0); Job j86= new Job("a",0,0,0,0,0,0,0);
		Job j87= new Job("a",0,0,0,0,0,0,0); Job j88= new Job("a",0,0,0,0,0,0,0); Job j89= new Job("a",0,0,0,0,0,0,0); 
		Job j90= new Job("a",0,0,0,0,0,0,0); Job j91= new Job("a",0,0,0,0,0,0,0); Job j92= new Job("a",0,0,0,0,0,0,0);
		Job j93= new Job("a",0,0,0,0,0,0,0); Job j94= new Job("a",0,0,0,0,0,0,0); Job j95= new Job("a",0,0,0,0,0,0,0); 
		Job j96= new Job("a",0,0,0,0,0,0,0); Job j97= new Job("a",0,0,0,0,0,0,0); Job j98= new Job("a",0,0,0,0,0,0,0);
		Job j99= new Job("a",0,0,0,0,0,0,0); Job j100= new Job("a",0,0,0,0,0,0,0);
		
		
		/**
		 * filling the array with the objects
		 */
		jobsInputArray[0]=j1;jobsInputArray[1]=j2;jobsInputArray[2]=j3;jobsInputArray[3]=j4;jobsInputArray[4]=j5;
		jobsInputArray[5]=j6;jobsInputArray[6]=j7;jobsInputArray[7]=j8;jobsInputArray[8]=j9;jobsInputArray[9]=j10;
		jobsInputArray[10]=j11;jobsInputArray[11]=j12;jobsInputArray[12]=j13;jobsInputArray[13]=j14;jobsInputArray[14]=j15;
		jobsInputArray[15]=j16;jobsInputArray[16]=j17;jobsInputArray[17]=j18;jobsInputArray[18]=j19;jobsInputArray[19]=j20;
		jobsInputArray[20]=j21;jobsInputArray[21]=j22;jobsInputArray[22]=j23;jobsInputArray[23]=j24;jobsInputArray[24]=j25;
		jobsInputArray[25]=j26;jobsInputArray[26]=j27;jobsInputArray[27]=j28;jobsInputArray[28]=j29;jobsInputArray[29]=j30;
		jobsInputArray[30]=j31;jobsInputArray[31]=j32;jobsInputArray[32]=j33;jobsInputArray[33]=j34;jobsInputArray[34]=j35;
		jobsInputArray[35]=j36;jobsInputArray[36]=j37;jobsInputArray[37]=j38;jobsInputArray[38]=j39;jobsInputArray[39]=j40;
		jobsInputArray[40]=j41;jobsInputArray[41]=j42;jobsInputArray[42]=j43;jobsInputArray[43]=j44;jobsInputArray[44]=j45;
		jobsInputArray[45]=j46;jobsInputArray[46]=j47;jobsInputArray[47]=j48;jobsInputArray[48]=j49;jobsInputArray[49]=j50;
		jobsInputArray[50]=j51;jobsInputArray[51]=j52;jobsInputArray[52]=j53;jobsInputArray[53]=j54;jobsInputArray[54]=j55;
		jobsInputArray[55]=j56;jobsInputArray[56]=j57;jobsInputArray[57]=j58;jobsInputArray[58]=j59;jobsInputArray[59]=j60;
		jobsInputArray[60]=j61;jobsInputArray[61]=j62;jobsInputArray[62]=j63;jobsInputArray[63]=j64;jobsInputArray[64]=j65;
		jobsInputArray[65]=j66;jobsInputArray[66]=j67;jobsInputArray[67]=j68;jobsInputArray[68]=j69;jobsInputArray[69]=j70;
		jobsInputArray[70]=j71;jobsInputArray[71]=j72;jobsInputArray[72]=j73;jobsInputArray[73]=j74;jobsInputArray[74]=j75;
		jobsInputArray[75]=j76;jobsInputArray[76]=j77;jobsInputArray[77]=j78;jobsInputArray[78]=j79;jobsInputArray[79]=j80;
		jobsInputArray[80]=j81;jobsInputArray[81]=j82;jobsInputArray[82]=j83;jobsInputArray[83]=j84;jobsInputArray[84]=j85;
		jobsInputArray[85]=j86;jobsInputArray[86]=j87;jobsInputArray[87]=j88;jobsInputArray[88]=j89;jobsInputArray[89]=j90;
		jobsInputArray[90]=j91;jobsInputArray[91]=j92;jobsInputArray[92]=j93;jobsInputArray[93]=j94;jobsInputArray[94]=j95;
		jobsInputArray[95]=j96;jobsInputArray[96]=j97;jobsInputArray[97]=j98;jobsInputArray[98]=j99;jobsInputArray[99]=j100;
		
		
		/**
		 * setting the name, lengths and priority according to the conditions
		 */
		name_generate(jobsInputArray);
		length_generate(jobsInputArray);
		priority_generate(jobsInputArray);
		
		
		/**
		 * printing the initial array objects
		 */
		for (Job jobs: jobsInputArray) {
            System.out.println(jobs.toString());
        }
		
		System.out.println();
		/**
		 *dumping the array objects in the heap
		 */
		ArrayListHeap<Integer, Job> heap = new ArrayListHeap<Integer, Job>();
		for(int i=0; i<jobsInputArray.length; i++) {
			jobsInputArray[i].setEntryTime(i);
			heap.insert(jobsInputArray[i].getJobPriority(), jobsInputArray[i]);
			
		}
		
		/**
		 * removing the objects in a sorted order
		 */
		ArrayList<Entry<Integer,Job>> sorted_array1 = new ArrayList<>( );
		for(int i=0; i<jobsInputArray.length; i++) {
			sorted_array1.add(heap.removeMin());
		}
		
		/**
		 * printing out the sorted array
		 */
		System.out.println("Method from the heap class");
		for (Entry<Integer, Job> sorted: sorted_array1) {
            System.out.println(sorted.toString());
        }
		//------------code upto this part works fine----------------
		
		/*
		 //testing the insertion method from the Sorted List queue class
		 
		SortedListPQ<Integer, Job> PQ = new SortedListPQ<Integer, Job>();
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

}
