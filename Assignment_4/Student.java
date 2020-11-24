
public class Student {
	private String name;

	//might need to add a stack
	
	/**
	 * deault constructor
	 */
	public Student () {
		this.name="";
	}
	/**
	 * @param name
	 */
	public Student(String name) {
		super();
		this.name = name;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	
	@Override
	public String toString() {
		return "Student [name=" + name + "]";
	}

}
