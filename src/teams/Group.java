package teams;

import utils.DataInput;
import people.Student;

/**
 * Represents group of {@link Student}
 * 
 * @author Oleh Kurachenko
 */
public class Group {
	private Student[] group;
	private int numberOfStudents;
	private int yearOfStudy;
	private String specialization;

	/**
	 * Constructs first-year empty group
	 * 
	 * @param yearOfStudy
	 * @param specialization
	 */
	public Group(String specialization) {
		super();
		this.yearOfStudy = 1;
		this.specialization = specialization;
		this.numberOfStudents = 0;
		this.group = new Student[0];
	}

	/**
	 * Creates group with data added from keyboard
	 */
	public Group(int yearOfStudy, String specialisation) {
		super();
		this.specialization = specialisation;
		DataInput.println("Creating group (" + specialisation + "-"
				+ yearOfStudy + "):");
		this.numberOfStudents = DataInput
				.getInt(0, 10000, "Number of students");
		this.group = new Student[numberOfStudents];
		this.yearOfStudy = yearOfStudy;
		for (int i = 0; i < numberOfStudents; i++) {
			DataInput.print("Student " + (i + 1) + " - ");
			group[i] = new Student(specialization, yearOfStudy);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "#Group " + specialization + "-" + yearOfStudy
				+ ", number of students: " + numberOfStudents;
	}

	/**
	 * Prints all data of group
	 * 
	 * @param prefix
	 *            - is being put before every String printed to System.out
	 */
	public void printGroupData(String prefix) {
		DataInput.println(prefix + toString() + ":");
		Student.printArrayOfPersons(prefix+"	", group);
	}

	/**
	 * Get the student by his number in group [1..N]
	 * 
	 * @return the group
	 */
	public Student getStudent(int numberInGroup) {
		return group[numberInGroup - 1];
	}

	/**
	 * @return the numberOfStudents
	 */
	public int getNumberOfStudents() {
		return numberOfStudents;
	}

	/**
	 * @return the yearOfStudy
	 */
	public int getYearOfStudy() {
		return yearOfStudy;
	}

	/**
	 * @return the specialization
	 */
	public String getSpecialization() {
		return specialization;
	}

	/**
	 * Adds a new student to group
	 * 
	 * @param newStudent
	 */
	public void addStudent(Student newStudent) {
		Student[] tempGroup = new Student[numberOfStudents + 1];
		for (int i = 0; i < numberOfStudents; i++)
			tempGroup[i] = group[i];
		tempGroup[numberOfStudents++] = newStudent;
		group = tempGroup;
	}
	
	/**
	 * Deletes a student from the group
	 * 
	 * @param student
	 */
	public void deleteStudent() {
		printGroupData("");
		int tempInt = DataInput.getInt(0, this.numberOfStudents, "Enter the number of student you want to remove (0 to cansel deleting)");
		if (tempInt != 0) {
			tempInt--;
			for (int i = tempInt; i<this.numberOfStudents-1; i++) group[i] = group[i+1];
			Student[] tempGroup = new Student[--this.numberOfStudents];
			for (int i = 0; i<this.numberOfStudents; i++) tempGroup[i] = group[i];
			group = tempGroup;
		}
	}

	/**
	 * Increases year of study
	 */
	public void increaseYearOfStudy() {
		this.yearOfStudy++;
		for (int i = 0; i<this.numberOfStudents; i++) {
			group[i].makeOlder();
			group[i].setCourse(yearOfStudy);
		}
	}

	/**
	 * @return the group
	 */
	public Student[] getGroup() {
		return group;
	}

	/**
	 * Increases age for all the group
	 */
	public void increaseAgeForAll() {
		for (int i = 0; i < this.numberOfStudents; i++) {
			this.group[i].makeOlder();
		}
	}
}
