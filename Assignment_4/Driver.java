import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.util.*;

public class Driver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner kb = new Scanner(System.in);
		int choice;

		/*
		 * Prompt user to choose either default values or enter their own
		 */
		System.out.println(
				"Press \n(1) to use the default values: size=2000, threshold = 1000, keyLength=8 generate 100 keys"
						+ "\n(2) to use your own values");
		choice = kb.nextInt();
		if (choice != 1 && choice != 2) {
			System.out.println("Your input is not valid");
			System.exit(0);
		}

		IntelligentSIDC mySIDC = null;

		// User use their own values
		if (choice == 2) {
			System.out.println("What is the size (total number of Keys?");
			int size = kb.nextInt();
			mySIDC = new IntelligentSIDC(size);

			System.out.println("What is the threshold that will determine if we will use Data Structure or Sequence?");
			int threshold = kb.nextInt();
			mySIDC.setThreshold(threshold);

			System.out.println("What is the key length?");
			int keylength = kb.nextInt();
			//mySIDC.setKeyLength(keylength);

			System.out.println("generate, how many keys");
			int gen = kb.nextInt();
			mySIDC.generate(gen);
		}
		// Default values
		else if (choice == 1) {
			mySIDC = new IntelligentSIDC(2000);
			mySIDC.setThreshold(1000);
			//mySIDC.setKeyLength(10);
			mySIDC.generate(100);

		}

		LinkedList<String> sor = mySIDC.allKeys();

		// allkeys
		System.out.println("Test method: allkeys(), but also print values");
		for (String element : sor) {
			Student Student = mySIDC.getValue(element);
			System.out.println(element + " " + Student.toString());

		}
		;
		System.out.println();
		// add(key,value)
		System.out.println("Test method add(key,value)- 3 times");
		System.out.println(
				"key=22345678, name=Raisa");
		System.out.println(
				"key=42345678, name=Johnathan");
		System.out.println(
				"key=52345678, name=Raymond");
		System.out.println();

		mySIDC.add("22345678", "Raisa");
		mySIDC.add("42345678", "Johnathan");
		mySIDC.add("52345678", "Raymond");
		sor = mySIDC.allKeys();
		for (String element : sor) { //
			Student Student = mySIDC.getValue(element);
			System.out.println(element + " " + Student.toString());

		}

		System.out.println();

		// remove(key)
		System.out.println("Test method: remove(key)-2 times\nkey= 123456783\nLast key");
		System.out.println();

		mySIDC.remove("123456783");
		mySIDC.remove(sor.getLast());

		sor = mySIDC.allKeys();
		for (String element : sor) {
			Student Student = mySIDC.getValue(element);
			System.out.println(element + " " + Student.toString());

		}

		System.out.println();

		System.out.print("First value " + sor.getFirst() + ": ");

		System.out.println(mySIDC.getValue(sor.getFirst()));
		System.out.print("Last value  " + sor.getLast() + ": ");
		System.out.println(mySIDC.getValue(sor.getLast()));

		System.out.println();
		//nextKey()
		System.out.println("Test method: nextkey(): first key");
		System.out.println(mySIDC.nextKey(sor.getFirst()));

		System.out.println();
		//prevKey()
		System.out.println("Test method: prevkey(): last key");
		System.out.println(mySIDC.prevKey(sor.getLast()));

		System.out.println();
		//rangeKey()
		System.out.println("Test method: rangeKey(key1,key2)");
		System.out.println();
		mySIDC.rangeKey(sor, sor.getFirst(), sor.getLast());

	}

}
