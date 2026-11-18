package prim;

import java.util.ArrayList;
import java.util.Scanner;

public class Primzahlen {
	public static String isPrim(long zahl) {
		if (zahl <= 1) {
			return "Keine Primzahl";
		}
		for (long i = 2; i <= Math.sqrt(zahl); i++) {
			if (zahl % i == 0) {
				return "Keine Primzahl";
			}
		}
		return "Primzahl";
	}

	public static void main(String[] args) {
		ArrayList<Long> eingaben = new ArrayList<>();
		long keinBockMehr = 1;
		Scanner scanner = new Scanner(System.in);
		do {
			System.out.println("Zahl hinzufügen (1), losrechnen? (2)");
			int martinFischer = scanner.nextInt();
			if (martinFischer == 1 || martinFischer == 2) {
				if (martinFischer == 1) {
					System.out.print("Bitte Zahl eingeben: ");
					long eingabe = scanner.nextLong();
					eingaben.add(eingabe);
					keinBockMehr = martinFischer;
				} else {
					for (int i = 0; i < eingaben.size(); i++) {
						long startzeit = System.nanoTime();

						String antwort = isPrim(eingaben.get(i));
						System.out.println(antwort);

						long endzeit = System.nanoTime();
						long optimusTime = endzeit - startzeit;
						System.out.println("Gebrauchte Zeit: " + optimusTime);
					}
				}
			} else {
				System.out.println("Keine gültige Antwort");
			}
		} while (keinBockMehr == 1);
		scanner.close();
	}
}
