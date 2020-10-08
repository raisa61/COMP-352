import java.util.Scanner;
import java.util.Arrays;
import java.util.Random;

public class MagicBoard_iterative {
	
//method for printing the 2d array as a matrix
	public static void printRow(int[] row) {
        for (int i : row) {
            System.out.print(i);
            System.out.print("\t");
        }
        System.out.println();
        System.out.println();
    }

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc= new Scanner(System.in);
		
//taking user input for the board size
		boolean size_condition=false;
		int size = 0;
		int start_index=0;
		while(!size_condition) 
		{
		     System.out.println("Please input the size of the board (between 5 and 20): ");
		     size= sc.nextInt();
		
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
		System.out.println("Please choose a starting index from the 4 options stated below: ");
		System.out.println("Press \"1\" for \"top-left\"");
		System.out.println("Press \"2\" for \"top-right\"");
		System.out.println("Press \"3\" for \"bottom-left\"");
		System.out.println("Press \"4\" for \"bottom-right\"");
		
		boolean start_index_condition=false;
		while(!start_index_condition)
		{
		     System.out.println("Enter your option: ");
		     start_index=sc.nextInt();
		     
		     if ((start_index<1) || (start_index>4)) 
		     {
		    	 System.out.println("You did not enter the right value, Please try again with values between 1 and 4");
		    	 start_index_condition=false;
		     }
		     else 
		     {
		    	 start_index_condition=true;
		     }
		  
		}

//creating a board with the given size
		int board [] [] = new int [size] [size];

//filling the rest of the cells with other numbers except 0
		for (int i = 0; i < board.length; i++) {
		    for (int j = 0; j < board[i].length; j++) {
		        board[i][j] = 1+(int)(Math.random()*(size-1));
		    }
		}
		

		
//making changes according to the start index so that after choosing the index, it's never 0
		if (start_index==1) {
			board[0][0]= 1+(int)(Math.random()*(size-1));
			
                        /*making one cell zero based on the chosen start_index, 
			if the random values are the row and col of the start index, 
			just choose the next cell for 0*/
			int zero_row=(int)(Math.random()*size-1);
			int zero_column=(int)(Math.random()*size-1);
			if((zero_row !=0) && (zero_column !=0))
			{
			   board[zero_row][zero_column]=0;
			}
			else
			{
				 board[zero_row+1][zero_column+1]=0;
			}
			
		}
		if (start_index==2) {
			board[0][size-1]= 1+(int)(Math.random()*(size-1));
			
			int zero_row=(int)(Math.random()*size-1);
			int zero_column=(int)(Math.random()*size-1);
			if((zero_row !=0) && (zero_column !=size-1))
			{
			   board[zero_row][zero_column]=0;
			}
			else
			{
				 board[zero_row+1][zero_column+1]=0;
			}
		}
		if (start_index==3) {
			board[size-1][0]= 1+(int)(Math.random()*(size-1));
			int zero_row=(int)(Math.random()*size-1);
			int zero_column=(int)(Math.random()*size-1);
			if((zero_row !=size-1) && (zero_column !=0))
			{
			   board[zero_row][zero_column]=0;
			}
			else
			{
				 board[zero_row+1][zero_column+1]=0;
			}
		}
		if (start_index==4) {
			board[size-1][size-1]= 1+(int)(Math.random()*(size-1));
			int zero_row=(int)(Math.random()*size-1);
			int zero_column=(int)(Math.random()*size-1);
			if((zero_row !=size-1) && (zero_column !=size-1))
			{
			   board[zero_row][zero_column]=0;
			}
			else
			{
				 board[zero_row+1][zero_column+1]=0;
			}
		}
		
//printing the final board
		for(int[] row : board) {
            printRow(row);
        }
		
		
	}

}
