package englishexercises;

import java.util.Scanner;

public class Exercise002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int arrayLength;
		int initialValue;
		int increases;

		System.out.println("Introduce the length of the array: ");
		arrayLength = sc.nextInt();
		int[] array = new int[arrayLength];
		System.out.println("Introduce the initial value: ");
		initialValue = sc.nextInt();
		System.out.println("Introduce the increases: ");
		increases = sc.nextInt();

		for (int i = 0; i < array.length; i++) {
			array[i] = initialValue + (increases * i);

		}
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i]);
			if (i < array.length - 1) {
				System.out.print(", ");
			}

		}

		sc.close();
	}

}
