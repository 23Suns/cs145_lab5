package pascalstriangle.practice;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ConsolePascalsTriangle {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int choice;

		do {
			System.out.println("Pascal's Triangle Generator Menu:");
			System.out.println("1. Generate Pascal's Triangle (Default Size: 5)");
			System.out.println("2. Generate Pascal's Triangle (Custom Size)");
			System.out.println("0. Exit");
			System.out.print("Enter your choice: ");

			choice = scanner.nextInt();

			switch (choice) {
				case 1:
					generateAndDisplayTriangle(5); // Default size
					break;
				case 2:
					int numRows = getValidInput("Enter the desired number of rows: ", scanner);
					generateAndDisplayTriangle(numRows);
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

	private static void generateAndDisplayTriangle(int numRows) {
		List<List<Integer>> triangle = generateTriangleRecursive(numRows);
		displayConsole(triangle);
	}

	private static List<List<Integer>> generateTriangleRecursive(int numRows) {
		List<List<Integer>> triangle = new ArrayList<>();
		for (int i = 0; i < numRows; i++) {
			triangle.add(generateRowRecursive(i));
		}
		return triangle;
	}

	private static List<Integer> generateRowRecursive(int rowNum) {
		List<Integer> row = new ArrayList<>();
		if (rowNum == 0) {
			row.add(1);
			return row;
		}
		List<Integer> previousRow = generateRowRecursive(rowNum - 1);
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

	private static void displayConsole(List<List<Integer>> triangle) {
		int maxRowLength = triangle.get(triangle.size() - 1).size(); // Find max row length for padding
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
