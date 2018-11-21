package teams;

import people.Teacher;
import utils.DataInput;
import utils.ResizeArray;

/**
 * Represents cathedra that containing teachers
 * 
 * @author Polina Shlepakova
 */

public class Cathedra {

	private String name;
	private String facultyName;
	private Teacher[] teachers;
	private int numberOfTeachers = 0;

	/**
	 * @param name
	 *            - name of the cathedra
	 * @param faculty
	 *            - faculty to which cathedra belongs
	 */
	public Cathedra(String faculty) {
		DataInput.println("Creating new cathedra:");
		this.name = DataInput.getString("Cathedra name (like cathedra of: )");
		setFaculty(faculty);
		this.numberOfTeachers = DataInput.getInt(0, 100, "Number of teachers in cathedra " + name);
		teachers = new Teacher[numberOfTeachers];
		for (int i = 0; i < numberOfTeachers; i++) {
			teachers[i] = new Teacher(name);
		}
	}

	/**
	 * @return name of the cathedra
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            - a name of the cathedra to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return faculty to which cathedra belongs
	 */
	public String getFaculty() {
		return facultyName;
	}

	/**
	 * @param facultyName
	 *            - a faculty to set
	 */
	public void setFaculty(String facultyName) {
		this.facultyName = facultyName;
	}

	/**
	 * @return an array of teachers
	 */
	public Teacher[] getTeachers() {
		return teachers;
	}

	/**
	 * @return number of teachers that belong to the cathedra
	 */
	public int getNumberOfTeachers() {
		return numberOfTeachers;
	}

	/**
	 * Adds new teacher to cathedra's array of teachers. If there is no room in
	 * the array, makes array bigger on 1 position and adds teacher on added
	 * position.
	 * 
	 * @param teacher
	 *            - a teacher to add
	 */
	public void addTeacher(Teacher teacher) {
		teachers = ResizeArray.resizeArray(true, teachers);
		teachers[numberOfTeachers++] = teacher;
	}

	/**
	 * Deletes a teacher from cathedra's array of teachers. The teacher on the
	 * last position of the array takes a deleted teacher's place and the last
	 * position gets deleted.
	 * 
	 * @param teacher
	 */
	public void deleteTeacher() {
		printCathedraData("");
		int tempInt = DataInput.getInt(0, this.numberOfTeachers,
				"Enter the number of teacher you want to remove (0 to cansel deleting)");
		if (tempInt != 0) {
			teachers[tempInt - 1] = teachers[--numberOfTeachers];
			teachers = ResizeArray.resizeArray(false, teachers);
		}
	}

	@Override
	public String toString() {
		return "Cathedra of " + name + ", in " + facultyName + " faculty, numberOfTeachers: " + numberOfTeachers;
	}

	/**
	 * Prints all the information about {@link Cathedra} and it's data to
	 * System.out
	 * 
	 * @param prompt
	 */
	public void printCathedraData(String prompt) {
		DataInput.println(prompt + this.toString());
		Teacher.printArrayOfPersons(prompt+"	", teachers);
	}
}
