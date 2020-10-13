import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class MagicBoard_recursive {
	
    public static boolean traverse(int i, int j, int[][] board, boolean[][] visited) {
		// base case how to stop the program if we find a 0
		if (board[i][j] == 0) {			
			return true;
		}
		
		else {
			System.out.println("visiting : ("+i+ ","+j+")." );
			/**
			 *  check if we already visited this node or not
			 */
			if (visited[i][j]) {
				System.out.println("visited this cell already");
				return false;
			}	
			/**
			 *  reach here means we have not visited before, so we mark it as visited
			 */
			visited[i][j] = true;
			
			/**
			 *  getting all the possible adjacent cells and put them in an array of array of int to know the positions
			 */
			int[][] adjacent_cells = new int[4][2];
			
			/**
			 *  going north 
			 */
			if (i - board[i][j] >= 0) {
				int[] north = {i - board[i][j], j};
				adjacent_cells[0] = north;
			}
			
			/**
			 *  going south 
			 */
			if (i + board[i][j] < board.length) {
				int[] south = {i + board[i][j], j};
				adjacent_cells[1] = south;
			}
			/**
			 * going east
			 */
			if (j + board[i][j] < board.length) {
				int[] east = {i, j + board[i][j]};
				adjacent_cells[2] = east;
			}
			
			/**
			 *  going west
			 */
			if (j - board[i][j] >= 0) {
				int[] west = {i, j - board[i][j]};
				adjacent_cells[3] = west;
			}
			
			/**
			 *  for loop to explore all the adjacent cells of a cell
			 */
			for (int cells = 0; cells < 4; cells++) {
				
				if (traverse(adjacent_cells[cells][0], adjacent_cells[cells][1],board, visited))
					return true;
			}			
		}
		return false;
	}

/**
 * here, i and j are the start indexes
 * @param i
 * @param j
 * @return
 */
public static int[] [] create_board(int size, int start_row,int start_col) {
	int board [] [] = new int [size] [size];
	
	for (int i = 0; i < board.length; i++) {
	    for (int j = 0; j < board[i].length; j++) {
	    	
	        board[i][j] = 1+(int)(Math.random()*(size-1));
	    }
	}
/**
 * making the 0 cell for top-left start
 */
	if ((start_row==0)&&(start_col==0))
	{
		board[0][0]= 1+(int)(Math.random()*(size-1));
		
        
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
	
/**
 * making the 0 cell for top-right start
 */
	if ((start_row==0)&&(start_col==size-1)) {
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

/**
 * making the 0 cell for the bottom-left start
 */
	if ((start_row==size-1)&&(start_col==0)) {
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

/**
 * making the 0 cell for the bottom-right part
 */

	if ((start_row==size-1)&&(start_col==size-1)) {
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
	return board;
	
}

/**
 * method for printing the board
 * @param args
 */

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
	
		
		 int size; int start_row=0; int start_col=0;
		Scanner sc= new Scanner(System.in);
		System.out.println("Please input the size of the board (between 5 and 20): ");
	    size= sc.nextInt();

	    
	    System.out.println("Please choose a starting index from the 4 options stated below: ");
		System.out.println("Press \"1\" for \"top-left\"");
		System.out.println("Press \"2\" for \"top-right\"");
		System.out.println("Press \"3\" for \"bottom-left\"");
		System.out.println("Press \"4\" for \"bottom-right\"");
		System.out.println("Enter your option: ");
	    int start_index=sc.nextInt();
	    
	    if(start_index==1) { start_row=0; start_col=0;}
	    if(start_index==2) { start_row=0; start_col=size-1;}
	    if(start_index==3) { start_row=size-1; start_col=0;}
	    if(start_index==4) { start_row=size-1; start_col=size-1;}
	    
		
		int[][]board = create_board(size,start_row,start_col);
		for(int[] row : board) {
            printRow(row);
        }
		
	
		
		boolean [] [] flag = new boolean [size][size];
		
      
        System.out.println(traverse(start_row,start_col,board,flag));
	sc.close();
	}

}
