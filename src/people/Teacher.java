package people;

import teams.*;
import utils.DataInput;

/**
 * Represents teacher
 * 
 * @author Polina Shlepakova
 * @e
 */

public class Teacher extends Person {

	private String cathedra;

	/**
	 * Constructor from keyboard
	 * 
	 * @param cathedra
	 *            - cathedra to which teacher belongs
	 */
	public Teacher(String cathedra) {
		setCathedra(cathedra);
		DataInput.println("Creating new teacher:");
		this.name = DataInput.getFullName("Name");
		this.age = DataInput.getInt(0, 110, "Age");
	}

	/**
	 * 
	 * @return name of {@link Cathedra} for a teacher
	 */
	public String getCathedra() {
		return cathedra;
	}

	/**
	 * 
	 * @param new
	 *            name of {@link Cathedra} for a teacher
	 */
	public void setCathedra(String cathedra) {
		this.cathedra = cathedra;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "#Teacher " + name + ", age: " + age + ", cathedra: " + cathedra;
	}
}
