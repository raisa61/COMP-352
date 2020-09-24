import java.util.Stack;
public class string_generator_loop {

	public static void printAllCombinations(String input_string)
	{
		// creating an empty stack 
		Stack<String> stack = new Stack<String>();
		// pushing the pattern into the stack
		stack.push(input_string);		

		int index_star;

		// looping till stack is empty
		while (!stack.empty())
		{
			// popping string from stack and process it
			String string1 = stack.pop();

			// index_star stores position of first occurrence of wildcard
			// pattern in curr
			if ((index_star = string1.indexOf('*')) != -1)
			{
				// replace '*' with 0 and 1 and push it to the stack
				for (char chr = '0'; chr <= '1'; chr++)
				{
					string1 = string1.substring(0, index_star) + chr +
							string1.substring(index_star + 1);
					stack.push(string1);
				}
			}

			// If no wildcard pattern is found, print the string
			else
				{
				//System.out.println(string1);
				try {
				      FileWriter myWriter = new FileWriter("out_2.txt",true);
				      myWriter.write(string1 + "\n");
				      
				      myWriter.close();
				}
				 catch (IOException e) {
				      System.out.println("An error occurred.");
				      e.printStackTrace();
				    }

				}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try {
		      File myObj = new File("out_2.txt");
		      if (myObj.createNewFile()) {
		        System.out.println("File created: " + myObj.getName());
		      } else {
		        System.out.println("File already exists.");
		      }
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		      e.printStackTrace();
		    }

		System.out.println("please enter a string: ");
		Scanner sc= new Scanner(System.in);
		String str= sc.nextLine();
		

		printAllCombinations(str);
			
		}
		
			

	}


