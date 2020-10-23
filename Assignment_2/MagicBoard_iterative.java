import java.util.Scanner;
import java.util.Stack;

public class MagicBoard_iterative {
	
    public static boolean traverse(int i, int j, int[][] board) {

        Stack<Integer> options;
        boolean[] visited;
    	
        options = new Stack<Integer>();
        visited = new boolean[board.length*board.length];
        
        //change the format from a[i][j] to a[i*board.length+j] and adding the starting point to stack
        int current_point = i*board.length+j;
        options.add(current_point);
        while(!options.isEmpty()){
            current_point = options.pop();
            i = current_point/board.length;
            j = current_point%board.length;
            if(!visited[current_point]){
                int step = board[i][j];
                /**
                 * variable for new row number
                 * @param new_i
                 */
                int new_i = i;
                /**
                 * variable for new column number
                 * @param new_j
                 */
                int new_j = j;
                /**
                 * variable to keep current_point value
                 * @param new_val
                 */
                int new_val = current_point;
                if(i-step >= 0){
                    new_i -= step;
                    new_val = new_i*board.length+new_j;
                    if(board[new_i][new_j]!=0 && !visited[new_val]) options.add(new_val); 
                    else if(board[new_i][new_j]==0) return true;
                    new_i=i;
                }
                if(i+step < board.length){
                    new_i += step;
                    new_val = new_i*board.length+new_j;
                    if(board[new_i][new_j]!=0 && !visited[new_val]) options.add(new_val); 
                    else if(board[new_i][new_j]==0) return true;
                    new_i=i;
                }
                if(j-step >= 0){
                    new_j -= step;
                    new_val = new_i*board.length+new_j;
                    if(board[new_i][new_j]!=0 && !visited[new_val]) options.add(new_val); 
                    else if(board[new_i][new_j]==0) return true;
                    new_j=j;
                }
                if(j+step < board.length){
                    new_j += step;
                    new_val = new_i*board.length+new_j;
                    if(board[new_i][new_j]!=0 && !visited[new_val]) options.add(new_val); 
                    else if(board[new_i][new_j]==0) return true;
                    new_j=j;
                }
                
                visited[current_point] = true;
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
		
      
        System.out.println(traverse(start_row,start_col,board));
        sc.close();
	}

}
