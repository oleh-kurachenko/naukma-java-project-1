package people;

import utils.DataInput;

/**
 * Represents student.
 * 
 * @author Oleh Kurachenko
 */
public class Student extends Person {
	private String specialisation;
	private int course;
	private double avgGrade;

	/**
	 * Creates student with data added from keyboard
	 */
	public Student(String specialisation, int course) {
		super();
		DataInput.println("Creating new student:");
		this.name = DataInput.getFullName("student");
		this.avgGrade = DataInput.getDouble(0, 100, "Average grade");
		this.age = DataInput.getInt(0, 110, "Age");
		this.specialisation = specialisation;
		this.course = course;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return "#Student " + name + ", group: " + specialisation + "-" + course + ", average grade: " + avgGrade + ", "
				+ age + " years old";
	}

	/**
	 * @return the avgGrade
	 */
	public double getAvgGrade() {
		return avgGrade;
	}

	/**
	 * @param avgGrade
	 *            the avgGrade to set
	 */
	public void setAvgGrade(double avgGrade) {
		this.avgGrade = avgGrade;
	}

	/**
	 * @return the specialisation
	 */
	public String getSpecialisation() {
		return specialisation;
	}

	/**
	 * @param specialisation
	 *            the specialisation to set
	 */
	public void setSpecialisation(String specialisation) {
		this.specialisation = specialisation;
	}

	/**
	 * @return the course
	 */
	public int getCourse() {
		return course;
	}

	/**
	 * @param course
	 *            the course to set
	 */
	public void setCourse(int course) {
		this.course = course;
	}

	/**
	 * Sorts Sarray got as a parameter, of {@link Student} by course
	 * 
	 * @param students
	 */
	public static void sortByCourse(Student[] students) {
		Student tempStudent;
		for (int i = 0; i < students.length - 1; i++)
			for (int j = 0; j < students.length - 1 - i; j++)
				if (students[j].getCourse() > students[j + 1].getCourse()
						|| (students[j].getCourse() == students[j + 1].getCourse() && students[j].getSpecialisation()
								.compareTo(students[j + 1].getSpecialisation()) < 0)) {
					tempStudent = students[j];
					students[j] = students[j + 1];
					students[j + 1] = tempStudent;
				}
	}
}
