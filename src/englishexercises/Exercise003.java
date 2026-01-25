package englishexercises;

import java.util.Random;
import java.util.Scanner;

public class Exercise003 {

	public static void main(String[] args) {
		System.out.println("Welcome to the fly game!");
		System.out.println("-------------------------------------");
		Scanner sc = new Scanner(System.in);
		Random rd = new Random();
		// Map size
		System.out.println("Introduce the size of the map: ");
		int mapSize = sc.nextInt();
		String[] mapArray = new String[mapSize];
		int flyPosition;
		int positionSelected;
		boolean gameInterruptor = true;

		flyPosition = rd.nextInt(0, mapArray.length);
		while (gameInterruptor) {

			System.out.println("Select the position where u think the fly is");
			positionSelected = sc.nextInt();
			int distanceFromFly;
			if (positionSelected == flyPosition) {
				System.out.println("\nThe player wins! Correct position!");
				System.out.println("Fly position was: " + flyPosition);
				gameInterruptor = false;
			} else {
				distanceFromFly = Math.abs(flyPosition - positionSelected);
				if (distanceFromFly == 1) {
					System.out.println("The fly is in a contiguous position");
					System.out.println("Old fly position: " + flyPosition);
					System.out.println("The fly changed its position!");
					int currentPosition = flyPosition;
					while (flyPosition == currentPosition) {
						flyPosition = rd.nextInt(0, mapArray.length);
					}
				} else {
					System.out.println("Keep looking for the fly!");
					System.out.println("Distance from the fly: " + distanceFromFly);

				}
			}

		}
		System.out.println("-------------------------------------");

		System.out.println("End of the game");

		sc.close();
	}

}
