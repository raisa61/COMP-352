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
		System.out.println("Welcome to the CVR program by Marwan Jabbour");
		System.out.println(
				"Press \n(1) to use the default values: size=2000, threshold = 1000, keyLength=10 generate 100 keys"
						+ "\n(2) to use your own values");
		choice = kb.nextInt();
		if (choice != 1 && choice != 2) {
			System.out.println("Your input is not valid");
			System.exit(0);
		}

		CVR myCVR = null;

		// User use their own values
		if (choice == 2) {
			System.out.println("What is the size (total number of VINs?");
			int size = kb.nextInt();
			myCVR = new CVR(size);

			System.out.println("What is the threshold that will determine if we will use Data Structure or Sequence?");
			int threshold = kb.nextInt();
			myCVR.setThreshold(threshold);

			System.out.println("What is the key length?");
			int keylength = kb.nextInt();
			myCVR.setKeyLength(keylength);

			System.out.println("generate, how many keys");
			int gen = kb.nextInt();
			myCVR.generate(gen);
		}
		// Default values
		else if (choice == 1) {
			myCVR = new CVR(2000);
			myCVR.setThreshold(1000);
			myCVR.setKeyLength(10);
			myCVR.generate(100);

		}

		LinkedList<String> sor = myCVR.allKeys();

		// allkeys
		System.out.println("Test method: allkeys(), but also print values");
		for (String element : sor) {
			Vehicle vehicle = myCVR.getValue(element);
			System.out.println(element + " " + vehicle.toString());

		}
		;
		System.out.println();
		// add(key,value)
		System.out.println("Test method add(key,value)- 3 times");
		System.out.println(
				"key=A123456789, owner=marwan, brand=tesla, dates are: (1, 2, 2000), (4, 3, 1999), (1, 1, 2010), (10, 11, 1989)");
		System.out.println(
				"key=B123456789, owner=Johnathan, brand=GMC, dates are: (1, 2, 2000), (4, 3, 1999), (1, 1, 2010), (10, 11, 1989)");
		System.out.println(
				"key=D123456789, owner=Raymond, brand=TOKO, dates are: (1, 2, 2000), (4, 3, 1999), (1, 1, 2010), (10, 11, 1989)");
		System.out.println();

		Date d1 = new Date(1, 2, 2000);
		Date d2 = new Date(4, 3, 1999);
		Date d3 = new Date(1, 1, 2010);
		Date d4 = new Date(10, 11, 1989);

		Stack<Date> accidents_pass = new Stack<Date>();
		accidents_pass.push(d1);
		accidents_pass.push(d2);
		accidents_pass.push(d3);
		accidents_pass.push(d4);

		myCVR.add("A123456789", "Alex", "tesla", 98765, accidents_pass);
		myCVR.add("B123456789", "Johnathan", "GMC", 11111, accidents_pass);
		myCVR.add("D123456789", "Raymond", "TOKO", 22222, accidents_pass);
		sor = myCVR.allKeys();
		for (String element : sor) { //
			Vehicle vehicle = myCVR.getValue(element);
			System.out.println(element + " " + vehicle.toString());

		}

		System.out.println();

		// remove(key)
		System.out.println("Test method: remove(key)-2 times\nkey= A123456789\nLast key");
		System.out.println();

		myCVR.remove("A123456789");
		myCVR.remove(sor.getLast());

		sor = myCVR.allKeys();
		for (String element : sor) {
			Vehicle vehicle = myCVR.getValue(element);
			System.out.println(element + " " + vehicle.toString());

		}

		System.out.println();

		System.out.print("Value of " + sor.getFirst() + ": ");

		System.out.println(myCVR.getValue(sor.getFirst()));
		System.out.print("Value of " + sor.getLast() + ": ");
		System.out.println(myCVR.getValue(sor.getLast()));

		System.out.println();
		//nextKey()
		System.out.println("Test method: nextkey(): first key");
		System.out.println(myCVR.nextKey(sor.getFirst()));

		System.out.println();
		//prevKey()
		System.out.println("Test method: prevkey(): last key");
		System.out.println(myCVR.prevKey(sor.getLast()));

		System.out.println();
		//prevAccids()
		System.out.println("Test method: prevAccids(): first key");
		System.out.println();
		ArrayList<Date> ss = myCVR.prevAccids(sor.getFirst());
		System.out.println(sor.getFirst());

		System.out.println(ss);

		ArrayList<Date> bb = myCVR.prevAccids("B123456789");

		System.out.println("\nTest method: prevAccids(): B123456789");
		System.out.println();
		System.out.println(bb);

		System.out.println("Thanks for using the CVR program by Marwan Jabbour");

		//
		//
		//
		//
		// The below commented code was used to generate the output files, they have no
		// purpose
		// Kindly, ignore them, as I have simply included them as proof that it was I
		// who generated the output files
		//
		//
		//
		//

		/*
		 * PrintWriter pw = null; try { pw = new PrintWriter(new
		 * FileOutputStream("Output_From_Input_3.txt")); } catch (FileNotFoundException
		 * e) { // TODO Auto-generated catch block
		 * System.out.println("Error has occured, File not found"); System.exit(0); }
		 * pw.println("Welcome to the CVR program by Marwan Jabbour");
		 * 
		 * Scanner kb=null; Scanner kb_1=null;
		 * 
		 * try { kb_1= new Scanner (new FileInputStream ("input_3.txt")); kb= new
		 * Scanner (new FileInputStream ("input_3.txt"));
		 * 
		 * } catch (FileNotFoundException e2) {
		 * System.out.println("Error has occured, File not found"); System.exit(0); }
		 * int count=0;
		 * 
		 * while (kb_1.hasNextLine()) { count++; kb_1.nextLine(); }
		 * 
		 * 
		 * CVR myCVR2=new CVR(count); while (kb.hasNextLine()) { String
		 * temp=kb.nextLine(); String []line=temp.split(" "); for (int
		 * i=0;i<line.length;i++) { System.out.println (i+" "+line[i]); }
		 * 
		 * String VIN=line[0]; myCVR2.setKeyLength(VIN.length()); String owner=line[1];
		 * String brand=line[2]; double price=Double.parseDouble(line[3]); String
		 * day1=line[5]; day1=day1.substring(0, day1.length()-1); String month1=line[7];
		 * month1=month1.substring(0,month1.length()-1); String year1=line[9]; Date
		 * d1=new Date
		 * (Integer.parseInt(day1),Integer.parseInt(month1),Integer.parseInt(year1));
		 * 
		 * String day2=line[11]; day2=day2.substring(0, day2.length()-1); String
		 * month2=line[13]; month2=month2.substring(0,month2.length()-1); String
		 * year2=line[15]; Date d2=new Date
		 * (Integer.parseInt(day2),Integer.parseInt(month2),Integer.parseInt(year2));
		 * 
		 * 
		 * 
		 * String day3=line[17]; day3=day3.substring(0, day3.length()-1); String
		 * month3=line[19]; month3=month3.substring(0,month3.length()-1); String
		 * year3=line[21]; System.out.println (day1+" "+month1+" "+year1+
		 * " "+day2+" "+month2+" "+year2+ " "+day3+" "+month3+" "+year3+ " "); Date
		 * d3=new Date
		 * (Integer.parseInt(day3),Integer.parseInt(month3),Integer.parseInt(year3));
		 * 
		 * Stack<Date>tempo=new Stack<Date>(); tempo.push(d1); tempo.push(d2);
		 * tempo.push(d3);
		 * 
		 * 
		 * myCVR2.add(VIN, owner, brand, price, tempo); }
		 * 
		 * pw.println("Output of Input File: input_1.txt"); pw.println
		 * ("---------------------------------");
		 * 
		 * pw.println(); pw.println("Test method getKeyLength()"); pw.println
		 * (myCVR2.getKeyLength());
		 * 
		 * 
		 * pw.println(); pw.println("Test method getValue(): 2UGFMKWANWXUZLVHI");
		 * pw.println("----------------------------------"); pw.println
		 * (myCVR2.getValue("2UGFMKWANWXUZLVHI"));
		 * 
		 * pw.println("Test method getValue(): 35G11J5WD2S0D2YJG");
		 * pw.println("----------------------------------"); pw.println
		 * (myCVR2.getValue("35G11J5WD2S0D2YJG"));
		 * 
		 * 
		 * pw.println(); pw.println("Test method nextKey(): 2UGFMKWANWXUZLVHI");
		 * pw.println("----------------------------------"); pw.println
		 * (myCVR2.nextKey("2UGFMKWANWXUZLVHI"));
		 * 
		 * pw.println(); pw.println("Test method prevKey(): 35G11J5WD2S0D2YJG");
		 * pw.println("----------------------------------"); pw.println
		 * (myCVR2.prevKey("35G11J5WD2S0D2YJG"));
		 * 
		 * pw.println(); pw.println("Test method prevAccids(): 2UGFMKWANWXUZLVHI");
		 * pw.println("----------------------------------"); pw.println
		 * (myCVR2.prevAccids("2UGFMKWANWXUZLVHI"));
		 * 
		 * 
		 * pw.println("Thanks for using the CVR program by Marwan Jabbour"); pw.close();
		 * 
		 * /*
		 * 
		 * 
		 * 
		 * 
		 * pw.println("Case 7"); pw.println("--------"); pw.println();
		 * 
		 * pw.println("Size: 100000"); pw.println("Threshold: 8000");
		 * pw.println("KeyLength: 17"); pw.println("Generate: 5000 keys\n");
		 * 
		 * Scanner kb2 = new Scanner(System.in);
		 * System.out.println("Welcome to the CVR program by Marwan Jabbour");
		 * 
		 * System.out.println("What is the size (total number of VINs?"); int size =
		 * kb.nextInt(); CVR myCVR = new CVR(size);
		 * 
		 * System.out.
		 * println("What is the threshold that will determine if we will use Data Structure or Sequence?"
		 * ); int threshold = kb.nextInt(); myCVR.setThreshold(threshold);
		 * 
		 * System.out.println("What is the key length?"); int keylength = kb.nextInt();
		 * myCVR.setKeyLength(keylength);
		 * 
		 * System.out.println("generate, how many keys"); int gen = kb.nextInt();
		 * myCVR.generate(gen);
		 * 
		 * LinkedList<String> sor = myCVR.allKeys();
		 * pw.println("Test method allKeys()"); pw.println();
		 * 
		 * System.out.println("allkeys"); for (String element : sor) { Vehicle vehicle =
		 * myCVR.getValue(element); String own = vehicle.getOwner(); String bra =
		 * vehicle.getBrand(); double pr = vehicle.getPrice(); // ArrayList<Date> acc =
		 * myCVR.prevAccids(element);
		 * 
		 * // System.out.println(element); pw.print(element + "   owner: " + own +
		 * "   brand: " + bra + "   price: $" + pr + " "); pw.println();
		 * 
		 * } pw.println(); System.out.println(); pw.println(
		 * "Test method add(key,value) : \n\nkey=A123456789 \nowner= Alex \nbrand=tesla \nprice=98765 \ndate1= 1/2/2000\ndate2= 4/3/1999\ndate3=1/1/2010\ndate4=10/11/1989\n"
		 * ); System.out.println("add(key,value)"); pw.println(
		 * "Test method add(key,value) : \n\nkey=B123456789 \nowner= Johnathan \nbrand=GMC \nprice=11111 \ndate1= 1/2/2000\ndate2= 4/3/1999\ndate3=1/1/2010\ndate4=10/11/1989\n"
		 * ); System.out.println("add(key,value)"); Date d1 = new Date(1, 2, 2000); Date
		 * d2 = new Date(4, 3, 1999); Date d3 = new Date(1, 1, 2010); Date d4 = new
		 * Date(10, 11, 1989);
		 * 
		 * Stack<Date> accidents_pass = new Stack<Date>(); accidents_pass.push(d1);
		 * accidents_pass.push(d2); accidents_pass.push(d3); accidents_pass.push(d4);
		 * 
		 * myCVR.add("A123456789", "Alex", "tesla", 98765, accidents_pass);
		 * myCVR.add("B123456789", "Johnathan", "GMC", 11111, accidents_pass);
		 * myCVR.add("C123456789", "boy", "toyo", 1111, accidents_pass);
		 * myCVR.add("D123456789", "boy", "toyo", 1111, accidents_pass); pw.println();
		 * sor = myCVR.allKeys(); for (String element : sor) { //
		 * System.out.println(element); Vehicle vehicle = myCVR.getValue(element);
		 * String own = vehicle.getOwner(); String bra = vehicle.getBrand(); double pr =
		 * vehicle.getPrice(); // ArrayList<Date> acc = myCVR.prevAccids(element);
		 * System.out.println(element); pw.print(element + "   owner: " + own +
		 * "   brand: " + bra + "   price: $" + pr + " ");
		 * 
		 * pw.println();
		 * 
		 * } pw.println();
		 * 
		 * System.out.println();
		 * 
		 * pw.println("Test method removeKey(): key=A123456789");
		 * pw.println("Test method removeKey(): key=last key"); pw.println();
		 * 
		 * System.out.println("remove(key)");
		 * 
		 * myCVR.remove("A123456789"); myCVR.remove(sor.getLast());
		 * 
		 * sor = myCVR.allKeys(); for (String element : sor) { //
		 * System.out.println(element); Vehicle vehicle = myCVR.getValue(element);
		 * String own = vehicle.getOwner(); String bra = vehicle.getBrand(); double pr =
		 * vehicle.getPrice(); // ArrayList<Date> acc = myCVR.prevAccids(element);
		 * 
		 * // System.out.println(element); pw.print(element + "   owner: " + own +
		 * "   brand: " + bra + "   price: $" + pr + " "); pw.println();
		 * 
		 * }
		 * 
		 * System.out.println(); pw.println();
		 * pw.println("Test method getValue(): first key");
		 * pw.println("----------------------------------");
		 * 
		 * pw.println();
		 * 
		 * System.out.println("getvalue"); System.out.print("Value of " + sor.getFirst()
		 * + ": "); pw.println("Value of " + sor.getFirst() + ": ");
		 * pw.println(myCVR.getValue(sor.getFirst())); pw.println();
		 * 
		 * pw.println("Test method getValue(): last key");
		 * pw.println("----------------------------------"); pw.println();
		 * 
		 * pw.println("Value of " + sor.getLast() + ": ");
		 * pw.println(myCVR.getValue(sor.getLast()));
		 * 
		 * System.out.println(myCVR.getValue(sor.getFirst()));
		 * System.out.print("Value of " + sor.getLast() + ": ");
		 * System.out.println(myCVR.getValue(sor.getLast()));
		 * 
		 * pw.println(); pw.println("Test method nextKey(): first key");
		 * pw.println("----------------------------------");
		 * pw.println(myCVR.nextKey(sor.getFirst()));
		 * 
		 * System.out.println(); System.out.println("nextkey");
		 * System.out.println(myCVR.nextKey(sor.getFirst()));
		 * System.out.println(myCVR.nextKey(sor.getLast()));
		 * 
		 * pw.println(); pw.println("Test method prevKey(): last key");
		 * pw.println("----------------------------------");
		 * pw.println(myCVR.prevKey(sor.getLast()));
		 * 
		 * System.out.println(); System.out.println("prevkey");
		 * System.out.println(myCVR.prevKey(sor.getLast()));
		 * System.out.println(myCVR.prevKey(sor.getFirst()));
		 * 
		 * pw.println(); pw.println("Test method prevAccids(): first key");
		 * pw.println("----------------------------------");
		 * 
		 * System.out.println(); System.out.println("prevAccids"); ArrayList<Date> ss =
		 * myCVR.prevAccids(sor.getFirst()); System.out.println(sor.getFirst());
		 * 
		 * pw.print(ss); System.out.println(ss);
		 * 
		 * for (Date d : ss) { System.out.println(d); }
		 * 
		 * pw.println(); pw.println();
		 * 
		 * pw.println("Test method prevAccids(): key: B123456789");
		 * pw.println("----------------------------------");
		 * 
		 * ArrayList<Date> bb = myCVR.prevAccids("B123456789"); pw.print(bb);
		 * 
		 * for (Date d : bb) { System.out.println(d); } pw.println();
		 * pw.println("Thanks for using the CVR program"); pw.close();
		 */
	}

}
