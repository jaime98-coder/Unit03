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
		int[] mapArray = new int[mapSize];
		int flyPosition;
		int positionSelected;
		boolean isGameActive = true;

		flyPosition = rd.nextInt(0, mapArray.length);
		// almaceno en la posición aleatoria el valor 1, significando esto que ahí está
		// la mosca FLY
		mapArray[flyPosition] = 1;
		while (isGameActive) {

			System.out.println("Select the position where u think the fly is");
			positionSelected = sc.nextInt();
			int distanceFromFly;
			if (positionSelected >= 0 && positionSelected < mapSize) {
				if (mapArray[positionSelected] == 1) {
					System.out.println("\nThe player wins! Correct position!");
					System.out.println("Fly position was: " + flyPosition);
					isGameActive = false;
				} else {
					distanceFromFly = Math.abs(flyPosition - positionSelected);
					if (distanceFromFly == 1) {
						System.out.println("Close! The fly is in a contiguous position");
						System.out.println("Old fly position: " + flyPosition);
						System.out.println("The fly changed its position!");
						mapArray[flyPosition] = 0;
						int currentPosition = flyPosition;
						while (flyPosition == currentPosition) {
							flyPosition = rd.nextInt(0, mapArray.length);
						}
						mapArray[flyPosition] = 1;
					} else {
						System.out.println("Keep looking for the fly!");
						System.out.println("Distance from the fly: " + distanceFromFly);

					}
				}
			} else {
				System.out.println("Invalid position. Please stay inside the map size");
			}

		}
		System.out.println("-------------------------------------");

		System.out.println("End of the game");

		sc.close();
	}

}
