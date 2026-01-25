package englishexercises;

import java.util.Scanner;

public class Exercise001 {

	public static void main(String[] args) {
		int[] array = new int[10];
		Scanner sc = new Scanner(System.in);
		String answer;
		int value;
		int position;
		boolean programInterruptor = true;
		System.out.println("Welcome to the program");
		do {
			System.out.println("\na. Show values");
			System.out.println("b. Introduce a value");
			System.out.println("c. Exit");
			System.out.println("Select an option");
			answer = sc.next();
			switch (answer) {
			case "a":
				System.out.println("Show values selected");
				for (int i = 0; i < array.length; i++) {
					System.out.print(array[i] + "\t");
				}
				System.out.println();
				break;
			case "b":
				System.out.println("Introduce a value selected");
				System.out.println("Introduce a value: ");
				value = sc.nextInt();
				System.out.println("Introduce a position for the value: ");
				position = sc.nextInt();
				array[position] = value;
				break;
			case "c":
				System.out.println("Exiting the program...");
				programInterruptor = false;
				break;
			default:
				System.out.println("Please select a valid option");
				break;
			}
		} while (programInterruptor);
		System.out.println("End of the program");
		sc.close();
	}

}
