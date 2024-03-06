
/**
 * Name: Joshua Henderson
 * Date: February 29, 2024
 * Project: Word Search Program
 * Purpose: This program provides an interactive tool for generating Pascal's Triangle or providing an explanation with a 'default size' triangle (5 rows). 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PascalsTriangle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			// menu display and prompt for user choice
			System.out.println("\nPascal's Triangle Generator");
			System.out.println("1. Formula with Example");
			System.out.println("2. Generate Pascal's Triangle");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();
			
			// switch statement for different choices
			switch (choice) {
				case 1:
					System.out.println(showFormula());
					generateTriangle(5); // Default
					break;
				case 2:
					int numRows = getValidInput("Enter the desired number of rows: ", scanner);
					generateTriangle(numRows);
					break;
				case 0:
					System.out.println("Exiting the program. Goodbye!");
					break;
				default:
					System.out.println("Invalid choice. Please try again.");
			}
		} while (choice != 0);
		scanner.close();
	}

	// checks for input validation (positive integer for number of rows)
	private static int getValidInput(String prompt, Scanner scanner) {
		int input;
		do {
			System.out.print(prompt);
			input = scanner.nextInt();
			if (input <= 0) {
				System.out.println("Error: Please enter a positive number of rows.");
			}
		} while (input <= 0);
		return input;
	}

	// generate and display a triangle given user input or with the default value
	private static void generateTriangle(int numRows) {
		List<List<Integer>> triangle = generateRecursiveTriangle(numRows);
		displayOutput(triangle);
	}

	// 
	private static String showFormula() {
		StringBuilder sb  = new StringBuilder();
		sb.append("\nThe Formula: (n+1)C(r) = (n)C(r - 1) + (n)C(r).");
		sb.append("\nTriangular number pattern where each number is the sum of the two numbers above it (with 1s at the edges). It's useful in various fields like probability and combinatorics.");
		return sb.toString();
	}

	private static List<List<Integer>> generateRecursiveTriangle(int numRows) {
		List<List<Integer>> triangle = new ArrayList();
		for (int i = 0; i < numRows; i++) {
			triangle.add(generateRow(i));
		}
		return triangle;
	}

	private static List<Integer> generateRow(int rowNum) {
		List<Integer> row = new ArrayList<>();
		if (rowNum == 0) {
			row.add(1);
			return row;
		}
		List<Integer> previousRow = generateRow(rowNum - 1);
		for (int col = 0; col <= rowNum; col++) {
			if (col == 0 || col == rowNum) {
				row.add(1);
			} else {
				int value = previousRow.get(col - 1) + previousRow.get(col);
				row.add(value);
			}
		}
		return row;
	}

	private static void displayOutput(List<List<Integer>> triangle) {
		int maxRowLength = triangle.get(triangle.size() - 1).size();
		System.out.println();
		for (List<Integer> row : triangle) {
			int padding = maxRowLength - row.size();

			for (int i = 0; i < padding; i++) {
				System.out.print(" ");
			}
			String formattedRow = row.stream()
					.map(Object::toString)
					.reduce((a, b) -> a + " " + b)
					.orElse("");

			System.out.println(formattedRow);
		}
	}
}