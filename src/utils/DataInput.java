package utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import teams.Group;

/**
 * Class allows to read data from System.in
 * 
 * @author Oleh Kurachenko, Polina Shlepakova
 * @version 1.6
 */
public final class DataInput {

	/**
	 * Tries to get long from System.in and writes prompt to System.out, until correct 
	 * long would be read
	 * 
	 * @param prompt
	 * @return long from System.in
	 */
	public static long getLong(String prompt) {
		prompt = prompt + ">";
		long tempLong = 0;
		boolean read = false;
		while (!read) {
			read = true;
			try {
				println(prompt);
				tempLong = getLong();
			} catch (Exception e) {
				println("Long value must be entered!");
				read = false;
			}
		}
		return tempLong;
	}

	/**
	 * Reads long from System.in
	 * 
	 * @return long from System.in
	 */
	private static long getLong() throws Exception {
		String s = getString();
		return Long.valueOf(s).longValue();
	}

	/**
	 * Reads long from System.in and writes prompt and requirements to value to 
	 * System.out
	 * 
	 * @param lowerLimit
	 * @param upperLimit
	 * @param prompt
	 * @return long from System.in
	 */
	public static long getLong(long lowerLimit, long upperLimit, String prompt) {
		long value;
		do {
			value = Long.valueOf(
					getLong(prompt + "(must be in [" + lowerLimit + ".."
							+ upperLimit + "] range)")).longValue();
		} while (!(value >= lowerLimit && value <= upperLimit));
		return value;
	}

	/**
	 * Reads char from System.in and writes prompt to System.out
	 * 
	 * @param prompt
	 * @return char from System.in
	 */
	public static char getChar(String prompt) {
		System.out.print(prompt + ">");
		return getChar();
	}

	/**
	 * Reads char from System.in
	 * 
	 * @return char from System.in
	 */
	public static char getChar() {
		String s = getString();
		return s.charAt(0);
	}

	/**
	 * Reads char from System.in and writes prompt and requirements to value to 
	 * System.out
	 * 
	 * @param lowerLimit
	 * @param upeerLimit
	 * @param prompt
	 * @return char from System.in
	 */
	public static char getChar(char lowerLimit, char upeerLimit, String prompt) {
		char value;
		do {
			value = getChar(prompt + "(must be in [" + lowerLimit + ".."
					+ upeerLimit + "] range)");
		} while (!(value >= lowerLimit && value <= upeerLimit));
		return value;
	}

	/**
	 * Reads int from System.in and writes prompt to System.out
	 * 
	 * @param prompt
	 * @return int from System.in
	 */
	public static int getInt(String prompt) {
		prompt = prompt + ">";
		int tempInt = 0;
		boolean red = false;
		while (!red) {
			red = true;
			try {
				println(prompt);
				tempInt = getInt();
			} catch (Exception e) {
				println("Integer value must be entered!");
				red = false;
			}
		}
		return tempInt;
	}

	/**
	 * Reads int from System.in
	 * 
	 * @return int from System.in
	 */
	public static int getInt() {
		String s = "";
		s = getString();

		return Integer.valueOf(s).intValue();
	}

	/**
	 * Reads int from System.in and writes prompt and requirements to value to 
	 * System.out
	 * 
	 * @param lowerLimit
	 * @param upperLimit
	 * @param prompt
	 * @return int from System.in
	 */
	public static int getInt(int lowerLimit, int upperLimit, String prompt) {
		int value;
		do {
			value = Integer.valueOf(
					getInt(prompt + "(must be in [" + lowerLimit + ".."
							+ upperLimit + "] range)")).intValue();
		} while (!(value >= lowerLimit && value <= upperLimit));
		return value;
	}

	/**
	 * Reads double from System.in
	 * 
	 * @return double from System.in
	 */
	public static double getDouble() {
		String s = getString();
		return Double.valueOf(s).doubleValue();
	}

	/**
	 * Reads double from System.in and writes prompt to System.out
	 * 
	 * @param prompt
	 * @return double from System.in
	 */
	public static double getDouble(String prompt) {
		prompt = prompt + ">";
		double tempDouble = 0;
		boolean red = false;
		while (!red) {
			red = true;
			try {
				println(prompt);
				tempDouble = getDouble();
			} catch (Exception e) {
				println("Double value must be entered!");
				red = false;
			}
		}
		return tempDouble;
	}

	/**
	 * Reads double from System.in and writes prompt and requirements to value to 
	 * System.out
	 * 
	 * @param lowerLimit
	 * @param upperLimit
	 * @param prompt
	 * @return double from System.in
	 */
	public static double getDouble(double lowerLimit, double upperLimit, String prompt) {
		double value;
		do {
			value = Double.valueOf(
					getDouble(prompt + "(must be in [" + lowerLimit + ".."
							+ upperLimit + "] range)")).doubleValue();
		} while (!(value >= lowerLimit && value <= upperLimit));
		return value;
	}

	/**
	 * Reads String from System.in and writes prompt to System.out
	 * 
	 * @param prompt
	 * @return String from System.in
	 * @throws IOException
	 */
	public static String getString(String prompt) {
		System.out.print(prompt + ">");
		return getString();
	}

	/**
	 * Reads String from System.in
	 * 
	 * @return String from System.in
	 * @throws IOException
	 */
	public static String getString() {
		String s = "";
		try {
			InputStreamReader isr = new InputStreamReader(System.in);
			BufferedReader br = new BufferedReader(isr);
			s = br.readLine();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	
	/**
	 * @return correct person's name
	 */
	public static String getPersonName() {
		return getName(3, "Person");
	}
	
	/**
	 * @return correct Faculty's name
	 */
	public static String getFacultyName() {
		return getName(2, "Faculty");
	}
	
	/**
	 * @return correct Specialization's name
	 */
	public static String getSpecializationName() {
		return getName(1, "Specialization");
	}
	
	/**
	 * @return correct Cathedra's name
	 */
	public static String getCathedraName() {
		return getName(2, "Cathedra");
	}
	
	/**
	 * @param prompt - a String to prompt the user with
	 * @return correct person's name
	 */
	public static String getPersonName(String prompt) {
		return getName(prompt, 3, "Person");
	}
	
	/**
	 * @param prompt - a String to prompt the user with
	 * @return correct Faculty's name
	 */
	public static String getFacultyName(String prompt) {
		return getName(prompt, 2, "Faculty");
	}
	
	/**
	 * @param prompt - a String to prompt the user with
	 * @return correct Specialization's name
	 */
	public static String getSpecializationName(String prompt) {
		return getName(prompt, 1, "Specialization");
	}
	
	/**
	 * @param prompt - a String to prompt the user with
	 * @return correct Cathedra's name
	 */
	public static String getCathedraName(String prompt) {
		return getName(prompt, 2, "Cathedra");
	}
	
	/**
	 * Returns correct name of something (see isName).
	 * @param minAmountOfWords - the minimum amount of words a string should contain in order for the input to be correct
	 * @param whoseName - an object or person whose name should be taken (prompts the user with it). 
	 * For example, if it's value is "Person", than after an incorrect input, method will write: "Person's name should..."
	 * @return correct name
	 */
	public static String getName(int minAmountOfWords, String whoseName) {
		String s;
		boolean isCorrect = false;
		do {
			s = getString();
			if(isName(s, minAmountOfWords)) {
				isCorrect = true;
			} else {
				println(whoseName + "'s name should start with a letter, contain only letters, spaces and hyphens and consist of at least " + minAmountOfWords + " words!");
			}
		} while (!isCorrect);
		return s;
	}
	
	/**
	 * Returns correct name of something (see isName).
	 * @param prompt - a String to prompt user with
	 * @param minAmountOfWords - the minimum amount of words a string should contain in order for the input to be correct
	 * @param whoseName - an object or person whose name should be taken (prompts the user with it). 
	 * For example, if it's value is "Person", than after an incorrect input, method will write: "Person's name should..."
	 * @return correct name
	 */
	public static String getName(String prompt, int minAmountOfWords, String whoseName) {
		String s;
		boolean isCorrect = false;
		do {
			s = getString(prompt);
			if(isName(s, minAmountOfWords)) {
				isCorrect = true;
			} else {
				println(whoseName + "'s name should start with a letter, contain only letters, spaces and hyphens and consist of at least " + minAmountOfWords + " words!");
			}
		} while (!isCorrect);
		return s;
	}
	
	/**
	 * A string can be a name if: 
	 * 		It contains at least minAmountOfWords words. 
	 * 		It consists of only letters, spaces and hyphens (optional). 
	 * 		First character is a letter. 
	 * 
	 * @param str - a string to check
	 * @param minAmountOfWords - the minimum amount of words a string should contain in order for method to return true.
	 * @return true if string can be a name, otherwise false
	 */
	public static boolean isName(String str, int minAmountOfWords) {
		int length = str.length();
		/* string is empty or 1st char isn't a letter */
		if(length == 0 || !Character.isLetter(str.charAt(0))) return false;
		int words = 0;
		boolean inWord = false;
		for(int i = 0; i < length; i++) {
			char chr = str.charAt(i);
			/* string has something else, except letters, spaces and hyphens */
			if(!(Character.isLetter(chr) || Character.isWhitespace(chr) || chr == '-')) {
				return false;
			/* beginning of a word */
			} else if(!inWord && Character.isLetter(chr)) {
				words++;
				inWord = true;
			/* end of a word */
			} else if(inWord && Character.isWhitespace(chr)) {
				inWord = false;
			/* hyphen is not between 2 words */
			} else if(chr == '-') {
				if (i == length - 1) return false;
				if(!(Character.isLetter(str.charAt(i - 1)) && Character.isLetter(str.charAt(i + 1)))) return false;
			}
		}
		if (words >= minAmountOfWords) return true;
		else return false;
	}
	
	/**
	 * Prints string s to System.out
	 * @param s
	 */
	public static void print(String s) {
		System.out.print(s);
	}

	/**
	 * Prints string s + '\n' to System.out 
	 * @param s
	 */
	public static void println(String s) {
		System.out.println(s);
	}
	
	/**
	 * Prints '\n' to System.out
	 */
	public static void println() {
		System.out.println();
	}
	
	public static String getWord(String prompt) {
		String tempString;
		boolean isGood;
		do {
			tempString = getString(prompt + " (must be word containing only letters)");
			isGood = true;
			for (int i = 0; i<tempString.length() && isGood; i++) if (!Character.isLetter(tempString.charAt(i))) isGood = false;
		} while (!isGood);
		return tempString;
	}
	
	public static String firstToUppercase(String string) {
		return string.substring(0, 1).toUpperCase() + string.substring(1, string.length()).toLowerCase();
	}
	
	private static String getNameFirstLast(String nameOwnerPerson) {
		return firstToUppercase(getWord("First name of " + nameOwnerPerson)) + " " + firstToUppercase(getWord("Last name of " + nameOwnerPerson));
	}

	private static String getNameSlavianic(String nameOwnerPerson) {
		return firstToUppercase(getWord("Last name of " + nameOwnerPerson)) + " " + firstToUppercase(getWord("First name of " + nameOwnerPerson)) + " " + firstToUppercase(getWord("Father's name of " + nameOwnerPerson));
	}
	
	public static String getFullName(String nameOwnerPerson) {
		return getNameFirstLast(nameOwnerPerson);
	}
}