package utils;
import people.*;
import teams.*;

/**
 * Contains methods that resize arrays either up or down.
 * 
 * @author Polina Shlepakova
 */

public class ResizeArray {

	/**
	 * Resizes an array of Strings either up or down.
	 * 
	 * @param addOnePosition - if true, adds a position to array, otherwise deletes one position from it.
	 * @param inputArray - an array to resize
	 * @return resized array
	 */
	public static String[] resizeArray(boolean addOnePosition, String[] inputArray) {
		int outputArrayLength = inputArray.length;
		if (addOnePosition) {
			outputArrayLength++;
		} else {
			outputArrayLength--;
		}
		String[] outputArray = new String[outputArrayLength];
		for(int i = 0; i < outputArrayLength; i++) {
			if (!(addOnePosition && i == outputArrayLength - 1))
			outputArray[i] = inputArray[i];
		}
		return outputArray;
	}
	
	/**
	 * Resizes an array of Teachers either up or down.
	 * 
	 * @param addOnePosition - if true, adds a position to array, otherwise deletes one position from it.
	 * @param inputArray - an array to resize
	 * @return resized array
	 */
	public static Teacher[] resizeArray(boolean addOnePosition, Teacher[] inputArray) {
		int outputArrayLength = inputArray.length;
		if (addOnePosition) {
			outputArrayLength++;
		} else {
			outputArrayLength--;
		}
		Teacher[] outputArray = new Teacher[outputArrayLength];
		for(int i = 0; i < outputArrayLength; i++) {
			if (!(addOnePosition && i == outputArrayLength - 1))
			outputArray[i] = inputArray[i];
		}
		return outputArray;
	}
	
	/**
	 * Resizes an array of Students either up or down.
	 * 
	 * @param addOnePosition - if true, adds a position to array, otherwise deletes one position from it.
	 * @param inputArray - an array to resize
	 * @return resized array
	 */
	public static Student[] resizeArray(boolean addOnePosition, Student[] inputArray) {
		int outputArrayLength = inputArray.length;
		if (addOnePosition) {
			outputArrayLength++;
		} else {
			outputArrayLength--;
		}
		Student[] outputArray = new Student[outputArrayLength];
		for(int i = 0; i < outputArrayLength; i++) {
			if (!(addOnePosition && i == outputArrayLength - 1))
			outputArray[i] = inputArray[i];
		}
		return outputArray;
	}
	
	/**
	 * Resizes an array of Cathedras either up or down.
	 * 
	 * @param addOnePosition - if true, adds a position to array, otherwise deletes one position from it.
	 * @param inputArray - an array to resize
	 * @return resized array
	 */
	public static Cathedra[] resizeArray(boolean addOnePosition, Cathedra[] inputArray) {
		int outputArrayLength = inputArray.length;
		if (addOnePosition) {
			outputArrayLength++;
		} else {
			outputArrayLength--;
		}
		Cathedra[] outputArray = new Cathedra[outputArrayLength];
		for(int i = 0; i < outputArrayLength; i++) {
			if (!(addOnePosition && i == outputArrayLength - 1))
			outputArray[i] = inputArray[i];
		}
		return outputArray;
	}
	
	/**
	 * Resizes an array of Specializations either up or down.
	 * 
	 * @param addOnePosition - if true, adds a position to array, otherwise deletes one position from it.
	 * @param inputArray - an array to resize
	 * @return resized array
	 */
	public static Specialization[] resizeArray(boolean addOnePosition, Specialization[] inputArray) {
		int outputArrayLength = inputArray.length;
		if (addOnePosition) {
			outputArrayLength++;
		} else {
			outputArrayLength--;
		}
		Specialization[] outputArray = new Specialization[outputArrayLength];
		for(int i = 0; i < outputArrayLength; i++) {
			if (!(addOnePosition && i == outputArrayLength - 1))
			outputArray[i] = inputArray[i];
		}
		return outputArray;
	}
	
	/**
	 * Resizes an array of {@link Faculty} either up or down.
	 * 
	 * @param addOnePosition - if true, adds a position to array, otherwise deletes one position from it.
	 * @param inputArray - an array to resize
	 * @return resized array
	 */
	public static Faculty[] resizeArray(boolean addOnePosition, Faculty[] inputArray) {
		int outputArrayLength = inputArray.length;
		if (addOnePosition) {
			outputArrayLength++;
		} else {
			outputArrayLength--;
		}
		Faculty[] outputArray = new Faculty[outputArrayLength];
		for(int i = 0; i < outputArrayLength; i++) {
			if (!(addOnePosition && i == outputArrayLength - 1))
			outputArray[i] = inputArray[i];
		}
		return outputArray;
	}
	
	
}
