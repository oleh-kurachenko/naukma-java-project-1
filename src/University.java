import java.sql.DataTruncation;

import people.Student;
import people.Teacher;
import teams.Cathedra;
import teams.Faculty;
import teams.Group;
import teams.Specialization;
import utils.DataInput;
import utils.ResizeArray;

/**
 * Represents university
 * 
 * @author Oleh Kurachenko
 */
public class University {

	private Faculty[] faculties = new Faculty[0];

	public void addFaculty() {
		faculties = ResizeArray.resizeArray(true, faculties);
		faculties[faculties.length - 1] = new Faculty();
	}

	public void deleteFaculty() {
		for (int i = 0; i < faculties.length; i++)
			DataInput.println(faculties[i].toString());
		int tempInt = DataInput.getInt(0, this.faculties.length,
				"Enter the number of faculty you want to remove (0 to cansel deleting)");
		if (tempInt != 0) {
			faculties[tempInt - 1] = faculties[faculties.length - 1];
			faculties = ResizeArray.resizeArray(false, faculties);
		}
	}

	public void workWithFaculty() {
		DataInput.println();
		for (int i = 0; i < faculties.length; i++) {
			DataInput.println(faculties[i].toString());
		}
		int tempInt = DataInput.getInt(0, this.faculties.length, "Number of faculty to work with (0 to go back)");
		if (tempInt == 0)
			return;
		tempInt--;

		while (true) {
			DataInput.println("Working with faculty " + faculties[tempInt].getName());
			DataInput.println("1 - to edit name");
			DataInput.println("2 - to create a cathedra");
			DataInput.println("3 - to remove a cathedra");
			DataInput.println("4 - to work with cathedra");
			DataInput.println("5 - to create a specialisation");
			DataInput.println("6 - to remove a specialisation");
			DataInput.println("7 - to work with specialisation");
			DataInput.println("8 - to print all the faculty");
			DataInput.println("9 - to print all the students of faculty in lexicographical order");
			DataInput.println("10 - to print all the teachers of faculty in lexicographical order");
			DataInput.println("0 - to go back");

			int tempInt2 = DataInput.getInt(0, 10, "Action");
			if (tempInt2 == 0)
				return;
			switch (tempInt2) {
			case 1:
				faculties[tempInt].setName(DataInput.getString("New name of faculty " + faculties[tempInt].getName()));
				break;
			case 2:
				faculties[tempInt].addCathedra(new Cathedra(faculties[tempInt].getName()));
				break;
			case 3:
				faculties[tempInt].deleteCathedra();
				break;
			case 4:
				this.workWithCathedra(faculties[tempInt]);
				break;
			case 5:
				faculties[tempInt].addSpecialization(new Specialization(faculties[tempInt].getName()));
				break;
			case 6:
				faculties[tempInt].deleteSpecialization();
				break;
			case 7:
				this.workWithSpecialisation(faculties[tempInt]);
				break;
			case 8:
				faculties[tempInt].printFacultyData();
				break;
			case 9:
				Student[] tempArray = faculties[tempInt].allStudentsToArray();
				Student.sortAlphabetically(tempArray);
				DataInput.println(
						"All the students of faculty " + faculties[tempInt].getName() + " sorted lexicraphically:");
				Student.printArrayOfPersons("	", tempArray);
				break;
			case 10:
				Teacher[] tempArray1 = faculties[tempInt].allTeachersToArray();
				Teacher.sortAlphabetically(tempArray1);
				DataInput.println(
						"All the teachers of faculty " + faculties[tempInt].getName() + " sorted lexicraphically:");
				Teacher.printArrayOfPersons("	", tempArray1);
				break;
			default:
				return;
			}
		}
	}

	public void workWithSpecialisation(Faculty faculty) {
		DataInput.println();
		for (int i = 0; i < faculty.getNumberOfSpecializations(); i++) {
			DataInput.println(faculty.getSpecializations()[i].toString());
		}
		int tempInt = DataInput.getInt(0, faculty.getNumberOfSpecializations(),
				"Number of specialisations to work with (0 to go back)");
		if (tempInt == 0)
			return;
		tempInt--;

		while (true) {
			DataInput.println("Working with specialisation " + faculty.getSpecializations()[tempInt].getName());
			DataInput.println("1 - to edit name");
			DataInput.println("2 - to work with group");
			DataInput.println("3 - to print all the students of specialisation in order of course");
			DataInput.println("4 - to print all the students of specialisation in lexicographical order");
			DataInput.println("5 - to print all data about specialisation");
			DataInput.println("0 - to go back");

			int tempInt2 = DataInput.getInt(0, 5, "Action");

			switch (tempInt2) {
			case 1:
				faculty.getSpecializations()[tempInt].setName(DataInput
						.getString("New name of specialisation" + faculty.getSpecializations()[tempInt].getName()));
				break;
			case 2:
				this.workWithGroup(faculty.getSpecializations()[tempInt]);
				break;
			case 3:
				Student[] tempArray = faculty.getSpecializations()[tempInt].listOfStudents();
				Student.sortByCourse(tempArray);
				DataInput.println("All the students of specialisation "
						+ faculty.getSpecializations()[tempInt].getName() + " sorted by course");
				Student.printArrayOfPersons("	", tempArray);
				break;
			case 4:
				Student[] tempArray1 = faculty.getSpecializations()[tempInt].listOfStudents();
				Student.sortAlphabetically(tempArray1);
				DataInput.println("All the students of specialisation "
						+ faculty.getSpecializations()[tempInt].getName() + " sorted by course");
				Student.printArrayOfPersons("	", tempArray1);
				break;
			case 5:
				faculty.getSpecializations()[tempInt].printSpecialisationData("");
				break;
			default:
				return;
			}
		}
	}

	public void workWithGroup(Specialization specialization) {
		DataInput.println();
		for (int i = 0; i < specialization.getYears(); i++) {
			DataInput.println(specialization.getCourse()[i].toString());
		}
		int tempInt = DataInput.getInt(0, specialization.getYears(), "Number of group to work with (0 to go back)");
		if (tempInt == 0)
			return;
		tempInt--;

		while (true) {
			DataInput.println("Working with group " + specialization.getCourse()[tempInt].toString());
			DataInput.println("1 - to edit student");
			DataInput.println("2 - to print all infornation about group");
			DataInput.println("3 - to print the students in group");
			DataInput.println("4 - to print the students in group in lexigraphical order");
			DataInput.println("5 - to add student");
			DataInput.println("6 - to remove student");
			DataInput.println("0 - to edit name");

			int tempInt2 = DataInput.getInt(0, 6, "Action");

			switch (tempInt2) {
			case 1:
				this.workWithStudent(specialization.getCourse()[tempInt]);
				break;
			case 2:
				specialization.getCourse()[tempInt].printGroupData("");
				break;
			case 3:
				Student.printArrayOfPersons("	", specialization.getCourse()[tempInt].getGroup());
				break;
			case 4:
				Student.sortAlphabetically(specialization.getCourse()[tempInt].getGroup());
				Student.printArrayOfPersons("	", specialization.getCourse()[tempInt].getGroup());
				break;
			case 5:
				specialization.getCourse()[tempInt].addStudent(new Student(specialization.getName(), tempInt + 1));
				break;
			case 6:
				specialization.getCourse()[tempInt].deleteStudent();
				break;
			default:
				return;
			}
		}
	}

	public void workWithStudent(Group group) {
		DataInput.println();
		group.printGroupData("");

		int tempInt = DataInput.getInt(0, group.getNumberOfStudents(), "Number of student to work with (0 to go back)");
		if (tempInt == 0)
			return;
		tempInt--;

		while (true) {
			DataInput.println("Working with student " + group.getGroup()[tempInt].getName());
			DataInput.println("1 - to edit name");
			DataInput.println("2 - to edit age");
			DataInput.println("3 - to edit avarage grade");
			DataInput.println("4 - to print student data");
			DataInput.println("0 - to go back");

			int tempInt2 = DataInput.getInt(0, 4, "Action");

			switch (tempInt2) {
			case 1:
				group.getGroup()[tempInt].editName();
				break;
			case 2:
				group.getGroup()[tempInt].editAge();
				break;
			case 3:
				group.getGroup()[tempInt].setAvgGrade(DataInput.getDouble(0, 100, "New avarage grade"));
				break;
			case 4:
				DataInput.println(group.getGroup()[tempInt].toString());
				break;
			default:
				return;
			}
		}
	}

	public void workWithCathedra(Faculty faculty) {
		DataInput.println();
		for (int i = 0; i < faculty.getNumberOfCathedras(); i++) {
			DataInput.println(faculty.getCathedras()[i].toString());
		}
		int tempInt = DataInput.getInt(0, faculty.getNumberOfCathedras(),
				"Number of cathedra to work with (0 to go back)");
		if (tempInt == 0)
			return;
		tempInt--;

		while (true) {

			DataInput.println("Working with cathedra " + faculty.getCathedras()[tempInt].getName());
			DataInput.println("1 - to edit name");
			DataInput.println("2 - to add teacher");
			DataInput.println("3 - to remove teacher");
			DataInput.println("4 - to edit teacher");
			DataInput.println("5 - to print all the teachers of cathedra in lexicographical order");
			DataInput.println("6 - to print all cathedra data");
			DataInput.println("0 - to go back");

			int tempInt2 = DataInput.getInt(0, 6, "Action");

			switch (tempInt2) {
			case 1:
				faculty.getCathedras()[tempInt].setName(
						DataInput.getString("New name for cathedra of " + faculty.getCathedras()[tempInt].toString()));
				break;
			case 2:
				faculty.getCathedras()[tempInt].addTeacher(new Teacher(faculty.getCathedras()[tempInt].getName()));
				break;
			case 3:
				faculty.getCathedras()[tempInt].deleteTeacher();
				break;
			case 4:
				workWithTeacher(faculty.getCathedras()[tempInt]);
				break;
			case 5:
				Teacher[] tempTeacherArray = faculty.getCathedras()[tempInt].getTeachers();
				Teacher.sortAlphabetically(tempTeacherArray);
				DataInput.println("Teachers of cathedra of" + faculty.getCathedras()[tempInt].getName()
						+ " int lexicographical order:");
				Teacher.printArrayOfPersons("	", tempTeacherArray);
				break;
			case 6:
				faculty.getCathedras()[tempInt].printCathedraData("");
				break;
			default:
				return;
			}
		}
	}

	public void workWithTeacher(Cathedra cathedra) {
		DataInput.println();
		cathedra.printCathedraData("");
		int tempInt = DataInput.getInt(0, cathedra.getNumberOfTeachers(),
				"Number of teachers to work with (0 to go back)");
		if (tempInt == 0)
			return;
		tempInt--;

		while (true) {
			DataInput.println("Working with teacher " + cathedra.getTeachers()[tempInt].getName());
			DataInput.println("1 - to edit name");
			DataInput.println("2 - to edit age");
			DataInput.println("3 - to print information about teacher");
			DataInput.println("0 - to go back");

			int tempInt2 = DataInput.getInt(0, 3, "Action");

			switch (tempInt2) {
			case 1:
				cathedra.getTeachers()[tempInt].editName();
				break;
			case 2:
				cathedra.getTeachers()[tempInt].editAge();
				break;
			case 3:
				DataInput.println(cathedra.getTeachers()[tempInt].toString());
				break;
			default:
				return;
			}
		}
	}

	public static void main(String[] args) {

		University u = new University();

		while (true) {
			DataInput.println();
			DataInput.println("1 - to create a faculty");
			DataInput.println("2 - to remove a faculty");
			DataInput.println("3 - to work with a faculty");
			DataInput.println("4 - print all student in order of course");
			DataInput.println("5 - find teacher by name");
			DataInput.println("6 - find student by name");
			DataInput.println("7 - print all university data");
			DataInput.println("0 - exit");

			// temp high number
			int tempInt = DataInput.getInt(0, 7, "Action");

			switch (tempInt) {
			case 1:
				u.addFaculty();
				break;
			case 2:
				u.deleteFaculty();
				break;
			case 3:
				u.workWithFaculty();
				break;
			case 4:
				int tempSize = 0;
				for (int i = 0; i < u.faculties.length; i++)
					tempSize += u.faculties[i].allStudentsToArray().length;
				Student[] tempArray = new Student[tempSize], tempArray2;
				tempSize = 0;
				for (int i = 0; i < u.faculties.length; i++) {
					tempArray2 = u.faculties[i].allStudentsToArray();
					for (int j = 0; j < tempArray2.length; j++)
						tempArray[tempSize++] = tempArray2[j];
				}
				Student.sortByCourse(tempArray);
				DataInput.println("All the student of university sorted by course:");
				Student.printArrayOfPersons("	", tempArray);
				break;
			case 5:
				DataInput.println("Enter data to find teacher in university");
				String tempName = DataInput.getFullName("Teacher");
				boolean found = false;
				DataInput.println("Found:");
				for (Faculty faculty : u.faculties) {
					for (Cathedra cathedra : faculty.getCathedras()) {
						for (Teacher teacher : cathedra.getTeachers()) {
							if (teacher.getName().equals(tempName)) {
								found = true;
								DataInput.println(teacher.toString() + "in fackulty " + faculty.getName());
							}
						}
					}
				}
				if (!found)
					DataInput.println("nobody");
				break;
			case 6:
				DataInput.println("Enter data to find student in university");
				String tempName1 = DataInput.getFullName("Teacher");
				boolean found1 = false;
				DataInput.println("Found:");
				for (Faculty faculty : u.faculties) {
					for (Specialization specialization : faculty.getSpecializations())
						for (Group group : specialization.getCourse())
							for (Student student : group.getGroup())
								if (student.getName().equals(tempName1)) {
									found1 = true;
									DataInput.println(student.toString() + "in fackulty " + faculty.getName());
								}
				}
				if (!found1)
					DataInput.println("nobody");
				break;
			case 7:
				DataInput.println();
				DataInput.println("University:");
				for (int i = 0; i < u.faculties.length; i++)
					u.faculties[i].printFacultyData();
				break;
			default:
				return;
			}
		}
	}

}
