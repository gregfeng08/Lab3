/**AUTHOR: Gregory Feng
 * FILENAME: Lab3.java
 * SPECIFICATION: Program that takes the input validated grades for your homework, midterm and final and puts it through a 
 * formula that calculates your final grade with weights and tells you if you passed the class or not.
 * FOR: CSE-110 Lab3
 * TIME SPENT: 30 minutes
 */
import java.util.*;
public class Lab3 {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int hmwrkGrade;
		int midtermGrade;
		int finalGrade;
		double weightedGrade;
		hmwrkGrade=parseInput(100,"Homework");
		midtermGrade=parseInput(100,"Midterm");
		finalGrade=parseInput(200,"Final");
		weightedGrade=(finalGrade/2+(float)finalGrade%2/2)*0.50+midtermGrade*0.25+hmwrkGrade*0.25;
		System.out.println("[INFO] Student's Weighted Total is "+weightedGrade);
		if (weightedGrade>=50) {
			System.out.println("[INFO] Student has PASSED the class!");
		} else {
			System.out.println("[INFO] Student has FAILED the class!");
		}
		System.out.println("End.");
		
	}
	
	
	public static boolean isValid(String input, int maxScore) {
		if (Integer.parseInt(input)<=maxScore&&Integer.parseInt(input)>=0) {
			return true;
		} else {
			return false;
		}
	}
	public static int parseInput(int maxScore, String test) {
		Scanner scanner = new Scanner(System.in);
		String input;
		while (true) {
			System.out.printf("%27s",test+" grade out of "+maxScore+": ");
			input = scanner.next();
			try {
				if (isValid(input,maxScore)) {
					break;
				} else {
					System.out.println("Please answer a number between [1-100]");
					continue;
				}
			} catch (Exception e) {
				System.out.println("Please input a numeric answer.");
				System.out.println("Error: "+e);
				continue;
			}
 		}
		return Integer.parseInt(input);
	}
}
