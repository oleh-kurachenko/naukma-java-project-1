package teams;

import people.Student;
import utils.DataInput;

/**
 * Represents specialization - list of {@link Group}
 * 
 * @author Oleh Kurachenko
 * 
 */
public class Specialization {
	private String name;
	private int years;
	private Group[] course;
	private String faculty;

	/**
	 * Constructs specialization from keyboard
	 * 
	 * @param faculty
	 */
	public Specialization(String faculty) {
		super();
		this.faculty = faculty;
		name = DataInput.getString("Name of specialisation");
		years = DataInput.getInt(1, 10, "Number of years to study");
		course = new Group[years];
		for (int i = 0; i < years; i++) {
			course[i] = new Group(i + 1, name);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "#Specialization " + name + ", " + years
				+ " years to study , faculty: " + faculty;
	}

	/**
	 * Prints all the information about specialisation
	 * 
	 * @param prefix
	 */
	public void printSpecialisationData(String prefix) {
		DataInput.println(prefix + toString() + ":");
		for (int i = 0; i < years; i++) {
			course[i].printGroupData(prefix + "	");
		}
		DataInput.println();
	}

	/**
	 * Pushes all courses up and creates new first-year course (reads from
	 * keyboard). Used to go to the new year of study
	 */
	public void pushCoursesUp() {
		for (int i = years - 1; i > 0; i--) {
			course[i] = course[i - 1];
			course[i].increaseAgeForAll();
			course[i].increaseYearOfStudy();
		}
		DataInput.print("New group for " + name + " - ");
		course[0] = new Group(1, name);
	}

	/**
	 * @return list of {@link Student} - list of all student on specialisation
	 */
	public Student[] listOfStudents() {
		int tempArraySize = 0;
		for (int i = 0; i < years; i++) {
			tempArraySize += course[i].getNumberOfStudents();
		}

		Student[] tempArray = new Student[tempArraySize];

		tempArraySize = 0;
		for (int i = 0; i < years; i++)
			for (int j = 1; j <= course[i].getNumberOfStudents(); j++)
				tempArray[tempArraySize++] = course[i].getStudent(j);
		return tempArray;
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
	 * @return the years
	 */
	public int getYears() {
		return years;
	}

	/**
	 * @return the course
	 */
	public Group[] getCourse() {
		return course;
	}

	/**
	 * @return the faculty
	 */
	public String getFaculty() {
		return faculty;
	}
}
