import java.util.Stack;
//Assignment (3)
//Programming Question 
//Written by: (Marwan Jabbour, 40151859)
//-----------------------------------------------------

/**
 * 
 * @author marwanjabbour Name and ID (Marwan Jabbour, 40151859) Comp 352
 *         Assignment 3, Due Date Sunday, June 14, 2020
 */

public class Date {

	int day;
	int month;
	int year;
	Stack<Date> accidents = null;

	/**
	 * Default constructor
	 */
	public Date() {

	}

	/**
	 * 
	 * @param day   of date
	 * @param month of date
	 * @param year  of date
	 */
	public Date(int day, int month, int year) {

		this.day = day;
		this.month = month;
		this.year = year;
	}

	/**
	 * @return Date as a string
	 */
	public String toString() {
		return "day: " + this.day + ", month: " + this.month + ", year: " + this.year;
	}

	/**
	 * 
	 * @return Stack of 3 random dates
	 */
	public Stack<Date> randomDates() {
		Stack<Date> accidents = new Stack<Date>();
		for (int i = 0; i < 3; i++) {
			int day_temp = (int) (Math.random() * 29);
			int month_temp = (int) (Math.random() * 12);
			int year_temp = (int) (Math.random() * 2019);
			accidents.push(new Date(day_temp, month_temp, year_temp));
		}

		return accidents;
	}

}
