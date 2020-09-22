import java.util.List;
import java.util.Scanner;

public class string_generator {
	
//solving with recursion
	public static void string_generate(char []input_string, int index ) {
		if (index == input_string.length) 
        { 
            System.out.println(input_string); 
            return; 
        } 
  
        if (input_string[index] == '*') 
        { 
            
            input_string[index] = '0'; 
            string_generate(input_string, index + 1); 
              
            
            input_string[index] = '1'; 
            string_generate(input_string, index + 1); 
              
            
            input_string[index] = '*'; 
        } 
        else
            string_generate(input_string, index + 1); 
		
		 
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("please enter a string: ");
		Scanner sc= new Scanner(System.in);
		String str= sc.nextLine();
		 
		
        char[] arr = str.toCharArray(); 
        
		string_generate(arr,0);
	}

	}


