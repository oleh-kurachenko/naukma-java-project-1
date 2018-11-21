package teams;

import people.*;
import utils.DataInput;
import utils.ResizeArray;

/**
 * Represents Faculty of University, containts {@link Cathedra}'s and
 * {@link Specialization}'s
 * 
 * @author Polina Shlepakova
 */

public class Faculty {

	private String name;
	private Cathedra[] cathedras;
	private Specialization[] specializations;
	private int numberOfCathedras = 0;
	private int numberOfSpecializations = 0;

	/**
	 * Creates a faculty with a given name and empty cathedras and
	 * specializations arrays.
	 * 
	 * @param name
	 *            - faculty's name
	 */
	public Faculty(String name) {
		setName(name);
		cathedras = new Cathedra[0];
		specializations = new Specialization[0];
	}

	/**
	 * Creates new Faculty from keyboard
	 */
	public Faculty() {
		DataInput.println("Creating new faculty:");
		this.name = DataInput.getString("Name");
		this.numberOfCathedras = DataInput.getInt(0, 100, "Number of cathedras");
		this.cathedras = new Cathedra[numberOfCathedras];
		for (int i = 0; i < numberOfCathedras; i++)
			cathedras[i] = new Cathedra(name);
		this.numberOfSpecializations = DataInput.getInt(0, 100, "Number of specialisations");
		this.specializations = new Specialization[numberOfSpecializations];
		for (int i = 0; i < numberOfSpecializations; i++)
			specializations[i] = new Specialization(name);
	}

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
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the numberOfCathedras
	 */
	public int getNumberOfCathedras() {
		return numberOfCathedras;
	}

	/**
	 * @return the numberOfSpecializations
	 */
	public int getNumberOfSpecializations() {
		return numberOfSpecializations;
	}

	/**
	 * Adds a new cathedra to faculty's array of cathedras. If there is no room
	 * in the array, makes array bigger on 1 position and adds cathedra on added
	 * position.
	 * 
	 * @param cathedra
	 *            - a cathedra to add
	 */
	public void addCathedra(Cathedra cathedra) {
		cathedras = ResizeArray.resizeArray(true, cathedras);
		cathedras[numberOfCathedras++] = cathedra;
	}

	/**
	 * Deletes a cathedra from faculty's array of cathedras. The cathedra on the
	 * last position of the array takes a deleted cathedra's place and the last
	 * position gets deleted.
	 * 
	 * @param cathedra
	 *            = a cathedra to delete
	 */
	public void deleteCathedra() {
		for (int i = 0; i < numberOfCathedras; i++)
			DataInput.println(cathedras[i].toString());
		int tempInt = DataInput.getInt(0, this.numberOfCathedras,
				"Enter the number of cathedra you want to remove (0 to cansel deleting)");
		if (tempInt != 0) {
			cathedras[tempInt - 1] = cathedras[--numberOfCathedras];
			cathedras = ResizeArray.resizeArray(false, cathedras);
		}
	}

	/**
	 * @return the cathedras
	 */
	public Cathedra[] getCathedras() {
		return cathedras;
	}

	/**
	 * @return the specializations
	 */
	public Specialization[] getSpecializations() {
		return specializations;
	}

	/**
	 * Adds a new specialization to faculty's array of specializations. If there
	 * is no room in the array, makes array bigger on 1 position and adds
	 * specialization on added position.
	 * 
	 * @param specialization
	 *            - a specialization to add
	 */
	public void addSpecialization(Specialization specialization) {
		specializations = ResizeArray.resizeArray(true, specializations);
		specializations[numberOfSpecializations++] = specialization;
	}

	/**
	 * Deletes a specialization from faculty's array of specialization. The
	 * specialization on the last position of the array takes a deleted
	 * specialization's place and the last position gets deleted.
	 * 
	 * @param specialization
	 *            = a specialization to delete
	 */
	public void deleteSpecialization() {
		for (int i = 0; i < numberOfSpecializations; i++)
			DataInput.println(specializations[i].toString());
		int tempInt = DataInput.getInt(0, this.numberOfSpecializations,
				"Enter the number of specialisation you want to remove (0 to cansel deleting)");
		if (tempInt != 0) {
			specializations[tempInt - 1] = specializations[--numberOfSpecializations];
			specializations = ResizeArray.resizeArray(false, specializations);
		}
	}

	/**
	 * @return array containing all {@link Student}'s which are in the
	 *         {@link Faculty}
	 */
	public Student[] allStudentsToArray() {
		int numberOfStudents = 0;
		for (Specialization s : specializations) {
			numberOfStudents += s.listOfStudents().length;
		}
		Student[] res = new Student[numberOfStudents];
		int currentIndex = 0;
		for (Specialization s : specializations) {
			Student[] students = s.listOfStudents();
			int length = students.length;
			for (int j = 0; j<students.length; j++) {
				res[currentIndex++] = students[j];
			}
		}
		return res;
	}

	/**
	 * @return array containing all {@link Teacher}'s which are in the
	 *         {@link Faculty}
	 */
	public Teacher[] allTeachersToArray() {
		int numberOfTeachers = 0;
		for (Cathedra c : cathedras) {
			numberOfTeachers += c.getTeachers().length;
		}
		Teacher[] res = new Teacher[numberOfTeachers];
		int currentIndex = 0;
		for (Cathedra c : cathedras) {
			Teacher[] teachers = c.getTeachers();
			int length = teachers.length;
			for (int i = currentIndex, j = 0; i < currentIndex + length; i++, j++) {
				res[i] = teachers[j];
			}
			currentIndex++;
		}
		return res;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "Faculty " + name + ", numberOfCathedras: " + numberOfCathedras + ", numberOfSpecializations: "
				+ numberOfSpecializations;
	}

	public void printFacultyData() {
		DataInput.println(this.toString());
		for (int i = 0; i < numberOfCathedras; i++)
			cathedras[i].printCathedraData("	");
		for (int i = 0; i < numberOfSpecializations; i++)
			specializations[i].printSpecialisationData("	");

	}

}
