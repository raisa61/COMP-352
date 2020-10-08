import java.util.Scanner;

public class MagicBoard_iterative {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
//taking user input for the board size
		boolean size_condition=false;
		while(!size_condition) 
		{
		     System.out.println("Please input the size of the board (between 5 and 20): ");
		     int size= sc.nextInt();
		
		     if((size<5) || (size>20)) 
		     {
			    System.out.println("You did not enter the right value, Please try again with values between 5 and 20");
			    size_condition=false;
		     }
		     else 
		     {
		    	 size_condition=true;
		     }
		
		}

//taking user input for deciding the start index
		
	}

}
