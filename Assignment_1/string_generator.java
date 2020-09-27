import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class string_generator {

/* solving with recursion */
	public static void RevealStr(char []input_string, int index ) {
		if (index == input_string.length) 
        { 
            //System.out.println(input_string); 
            
			{
			try {
			      FileWriter myWriter = new FileWriter("out_1.txt",true);
			     /* converting the array into a printable string */  
			      String string = new String(input_string);
			      
			      myWriter.write(string+ "\n");
			      
			      myWriter.close();
			}
			 catch (IOException e) {
			      System.out.println("An error occurred.");
			      e.printStackTrace();
			    }

			}
            
            return; 
        } 
  
        if (input_string[index] == '*') 
        { 
            
            input_string[index] = '0'; 
            RevealStr(input_string, index + 1); 
              
            
            input_string[index] = '1'; 
            RevealStr(input_string, index + 1); 
              
            
            input_string[index] = '*'; 
        } 
        else
            RevealStr(input_string, index + 1); 
		
		 
	}

	public static void main(String[] args) {
		
		try {
		      File myObj = new File("out_1.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }
		
		/* getting the string value from user */
		System.out.println("please enter a string: ");
		Scanner sc= new Scanner(System.in);
		String str= sc.nextLine();
		sc.close();
		 
		
        char[] arr = str.toCharArray(); 
              long startTime = System.nanoTime();
		RevealStr(arr,0);
		long  endTime = System.nanoTime();
		long timeElapsed = endTime - startTime;
		System.out.println("Execution time in milliseconds : " +
				timeElapsed / 1000000);	
	}

	}


