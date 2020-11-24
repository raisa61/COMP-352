import java.util.*;

public class IntelligentSIDC {

	// Properties of IntelligentSIDC
	private int threshold;
	private int keyLength;
	private int size = 0;
	private int max_size;
	// We stored values in a sequence at first
	boolean sequence_first = false;

	// ADT: entries>=threshold
	private TreeMap<String, Student> records_2 = new TreeMap<>();

	// Sequence: entries<threshold
	private DoublyLinkedList records_1 = new DoublyLinkedList();

	// Sample Reference values
	private static final String alphaNumeric = "0123456789";
	private static final String[] names = { "Raisa", "Johnny", "Jasmine", "Samuel", "David", "Joseph", "Carter",
			"Owen", "Wyatt", "John", "Jack", "Luke", "Jayden", "Dylan", "Grayson", "Levi", "Isaac", "Gabriel", "Julian",
			"Mateo", "Anthony", "Jaxon", "Lincoln" };


	/**
	 * Default constructor
	 */
	public IntelligentSIDC() {

	}

	/**
	 * Constructor
	 * 
	 * @param n Size of IntelligentSIDC
	 */
	public IntelligentSIDC(int n) {
		max_size = n;
	}

	/**
	 * 
	 * @param size_pass number of entries
	 * @return True, if we should use the ADT
	 */
	public boolean GreatherThanThreshold(int size_pass) {
		if (size_pass >= threshold)
			return true;
		else
			return false;
	}

	/**
	 * Sets the threshold of the IntelligentSIDC
	 * 
	 * @param threshold_pass The threshold to be set
	 */
	public void setThreshold(int threshold_pass) {

		// Must be between 100 and 500K
		if (threshold_pass < 100 || threshold_pass > 500000) {
			System.out.println("Error, threshold must be between 100 and 500,000");
			System.exit(0);
		}

		this.threshold = threshold_pass;
	}

	/**
	 * 
	 * @return The threshold
	 */
	public int getThreshold() {
		return this.threshold;
	}


	/**
	 * 
	 * @param n How many keys to be generated
	 */
	public void generate(int n) {

		// If the number of entries plus the number of generated keys is more than size,
		// we cannot
		if (size + n > max_size) {
			System.out.println("Sorry, the maximum size of " + max_size + " has been reached");
			return;
		}

		// Use ADT
		if (GreatherThanThreshold(n + size)) {
			if (sequence_first == true) {
				changeADT();
			}
			for (int i = 0; i < n; i++) {

				// Generate random values for Student and for SIDC
				String name = names[((int) (Math.random() * names.length))];
				System.out.println(name);
				//Stack<Date> acc = new Stack<Date>();
				//acc = new Date().randomDates();
				Student temp = new Student(name);
				String temp_SIDC = generateSIDC(keyLength);
				if (!records_2.containsKey(temp_SIDC)) {
					records_2.put(temp_SIDC, temp);
					size++;
					// Duplicate key
				} else if (records_2.containsKey(temp_SIDC)) {
					i--;
					continue;
				}
			}

		}
		// Use sequence
		else if (!GreatherThanThreshold(n + size)) {
			sequence_first = true;
			for (int i = 0; i < n; i++) {
				// Generate random values for Student and for SIDC
				String name = names[((int) (Math.random() * names.length))];
				//Stack<Date> acc = new Stack<Date>();
				//acc = new Date().randomDates();
				Student temp = new Student(name);
				String temp_SIDC = generateSIDC(keyLength);
				if (size == 0) {
					records_1.addFirst(temp_SIDC, temp);
					size++;
					// Duplicate key
				} else if (!records_1.contains(temp_SIDC)) {

					records_1.addFirst(temp_SIDC, temp);
					size++;

				} else if (records_1.contains(temp_SIDC)) {
					i--;
					continue;
				}
			}
		}
		System.out.println("Finished generating new keys");
		// Must sort the keys in the end
		sort();

	}

	/**
	 * 
	 * @param keyLength of the SIDCS
	 * @return A random SIDC with the given key length
	 */
	public static String generateSIDC(int keyLength) {
		StringBuilder sb = new StringBuilder();
		while (keyLength-- != 0) {
			int ch = (int) (Math.random() * alphaNumeric.length());
			sb.append(alphaNumeric.charAt(ch));
		}
		return sb.toString();
	}

	/**
	 * 
	 * @return LinkedList with all keys sorted
	 */
	public LinkedList<String> allKeys() {

		LinkedList<String> sorted = new LinkedList<String>();

		// ADT
		if (GreatherThanThreshold(size)) {
			Set<String> keys = records_2.keySet();
			sorted.addAll(keys);
		//Sequence
		} else {
			//Calls method for linked list allkeys(), see the class DoublyLinkedList
			sorted = records_1.allKeys();
		}

		return sorted;
	}

	/**
	 * Sorts the keys in the IntelligentSIDC
	 */
	public void sort() {
		if (!GreatherThanThreshold(size)) {
			records_1 = records_1.sortList();
		}
	}
	
	/**
	 * 
	 * @param key_pass The SIDC
	 * @param owner_pass The owner
	 * @param brand_pass The brand
	 * @param price_pass The price
	 * @param accidents_pass The accidents as a stack
	 * Adds a Student with these values
	 */

	public void add(String key_pass, String name_pass) {

		//no space
		if (size == max_size) {
			System.out.println("Sorry, the maximum size of " + max_size + " has been reached");
			return;
		}

		Student Student_pass = new Student(name_pass);
		//ADT
		if (GreatherThanThreshold(size)) {

			//Duplicate
			if (records_2.containsKey(key_pass)) {
				System.out.println("Could not add the key " + key_pass + " because it is already there");
			}

			else {
				//Must change ADT if we were previously using sequence
				if (sequence_first == true) {
					changeADT();
				}

				records_2.put(key_pass, Student_pass);
				//Increment number of entries by 1
				size++;
			}
		}

		//sequence 
		else if (!GreatherThanThreshold(size)) {
			sequence_first = true;
			//deuplicate
			if (records_1.contains(key_pass)) {
				System.out.println("Could not add the key " + key_pass + " because it is already there");
			}

			
			//CHECK
			
			records_1.addHere(key_pass, Student_pass);
			//increment size by 1
			size++;
		}
		
	}

	/**
	 * 
	 * @param key_pass The key whose value will be removed
	 */
	public void remove(String key_pass) {
		//ADT
		if (GreatherThanThreshold(size)) {
			//Decrement size and remove key
			if (records_2.remove(key_pass) != null)
				size--;
			else {
				System.out.println("Sorry could not delete that key");
			}
		//Sequence
		} else if (!GreatherThanThreshold(size)) {
			//Decrement size and remove key
			if (records_1.deleteKey(key_pass))
				size--;
			else {
				System.out.println("Sorry could not delete that key");
			}
		}
		
	}

	/**
	 * 
	 * @param key_pass The key whose value will be found
	 * @return The Student associated with that key
	 */
	public Student getValue(String key_pass) {
		if (GreatherThanThreshold(size)) {
			return records_2.get(key_pass);
		}

		else
			return records_1.getValueFromKey(key_pass);
	}

	/**
	 * 
	 * @param key_pass a key 
	 * @return The next key
	 */
	public String nextKey(String key_pass) {
		if (GreatherThanThreshold(size)) {
			if (records_2.higherEntry(key_pass) == null)
				return null;
			return records_2.higherEntry(key_pass).getKey();
		} else {
			return records_1.nextKey(key_pass);
		}
	}

	/**
	 * 
	 * @param key_pass a key
	 * @return the previous key
	 */
	public String prevKey(String key_pass) {
		if (GreatherThanThreshold(size)) {
			if (records_2.lowerEntry(key_pass) == null)
				return null;
			return records_2.lowerEntry(key_pass).getKey();
		} else {
			return records_1.prevKey(key_pass);
		}
	}

	/**
	 * Change ADT from sequence to treemap
	 */
	public void changeADT() {
		while (!records_1.isEmpty()) {
			String key_temp = records_1.firstKey();
			Student Student_temp = records_1.firstValue();
			records_1.removeFirst();
			records_2.put(key_temp, Student_temp);
		}
		sequence_first = false;
	}

	/**
	 * 
	 * @param key_pass The key whose previous accidents will be found
	 * @return The previous accidents of that key
	 */
	/*public ArrayList<Date> prevAccids(String key_pass) {

		Stack<Date> accidents = this.getValue(key_pass).getAccidents();
		Stack<Date> tmpStack3 = new Stack<Date>();

		Stack<Date> tmpStack1 = new Stack<Date>();*/
		
		//Push the elements into tmpStack1 from accidents
		/*while (!accidents.isEmpty()) {
			Date tmp = accidents.pop();
			tmpStack3.push(tmp);
			while (!tmpStack1.isEmpty() && (tmp.year > tmpStack1.peek().year
					|| (tmp.year == tmpStack1.peek().year && tmp.month > tmpStack1.peek().month)
					|| (tmp.year == tmpStack1.peek().year && tmp.month == tmpStack1.peek().month
							&& tmp.day > tmpStack1.peek().day))) {
				accidents.push(tmpStack1.pop());
			}

			tmpStack1.push(tmp);
		}*/

	//	Stack<Date> temp = new Stack<Date>();

		//Push elements back into temp stack
	/*	while (!tmpStack1.isEmpty()) {
			temp.push(tmpStack1.pop());
		}

		ArrayList<Date> tmpStack2 = new ArrayList<Date>();*/

		//To preserve order push the elements into another temporary stack
		/*while (!temp.isEmpty()) {
			tmpStack2.add(temp.pop());
		}*/

		//Return the elements back into accidents
		/*while (!tmpStack3.isEmpty()) {
			accidents.push(tmpStack3.pop());
		}*/

		//Return the temporary stack 2 that we used to preserve order
		//return tmpStack2;

	}

//}
