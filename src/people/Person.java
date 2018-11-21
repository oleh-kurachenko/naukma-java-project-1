package people;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Parameter;

import utils.DataInput;

/**
 * Abstract class for Teacher and Student.
 * 
 * @author Polina Shlepakova, Oleh Kurachenko
 */

abstract class Person {
	protected String name;
	protected int age;

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	protected void setName(String name) {
		this.name = name;
	}

	/**
	 * Edits {@link Person} name (from keyboard), shows a warning prompt
	 */
	public void editName() {
		DataInput.println("WARNING! You are trying to edit a name!");
		if (DataInput.getString("If you want to that, enter 'y'").toUpperCase().charAt(0) == 'Y')
			this.name = DataInput.getFullName("person");
	}

	/**
	 * Edits {@link Person} age (from keyboard), shows a warning prompt
	 */
	public void editAge() {
		DataInput.println("WARNING! You are trying to edit age!");
		int tempI = DataInput.getInt(0, 110, "New age to set it or '-1' to dismiss");
		if (tempI != -1)
			this.age = tempI;
		else
			DataInput.println("Age wasn't changed");
	}

	/**
	 * make {@link Person} older
	 */
	public void makeOlder() {
		age++;
	}
	
	/**
	 * Sorts array got as a parameter, of {@link Person} lexicographically to name
	 * @param persons
	 */
	public static void sortAlphabetically(Person[] persons) {
		Person tempPerson;
		for (int i = 0; i < persons.length - 1; i++)
			for (int j = 0; j < persons.length - 1 - i; j++)
				if (persons[j].getName().compareTo(persons[j + 1].getName()) > 0) {
					tempPerson = persons[j];
					persons[j] = persons[j + 1];
					persons[j + 1] = tempPerson;
				}
	}
	
	public static void printArrayOfPersons(String prompt, Person[] persons) {
		for (int  i = 0; i<persons.length; i++) {
			DataInput.println(prompt + (i+1) + ": " + persons[i]);
		}
		DataInput.println();
	}

}
