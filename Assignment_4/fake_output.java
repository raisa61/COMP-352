package fake;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class fake_output {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ArrayList<Integer> numbers=new ArrayList<Integer>();
	    FileReader fr;
		try {
			fr = new FileReader("CSTA_test_file1.txt");
			BufferedReader br=new BufferedReader(fr);
		    String line;
		    try {
				while((line=br.readLine())!=null){
				    numbers.add(Integer.parseInt(line));
				    
				}
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
		    catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		
		Object[] objects = numbers.toArray();
		Arrays.sort(objects);
		
		for(int i=0; i<objects.length; i++) {
			System.out.println(objects[i]);
		}
	  
	}

}
