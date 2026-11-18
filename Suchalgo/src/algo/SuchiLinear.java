package algo;

import java.util.Random;
import java.util.Scanner;

public class SuchiLinear {


	

	    public static long[] getSortedList(int laenge) {
	        Random rand = new Random(111111);
	        long[] zahlenliste = new long[laenge];
	        long naechsteZahl = 0;

	        for (int i = 0; i < laenge; i++) {
	            naechsteZahl += rand.nextInt(3) + 1;
	            zahlenliste[i] = naechsteZahl;
	        }

	        return zahlenliste;
	    }

	    public static String lineareSuche(long[] liste, long gesucht) {

	        for (int i = 0; i < liste.length; i++) {
	            if (liste[i] == gesucht) {
	                return "Gefunden an Stelle: " + i;
	            }
	        }

	        return "Nicht gefunden";
	    }

	    public static void main(String[] args) {

	        final int ANZAHL = 20000000; // 20.000.000

	        long[] a = getSortedList(ANZAHL);

	        Scanner scanner = new Scanner(System.in);

	        System.out.println("Bitte geben Sie die zu suchende Zahl an:");
	        long suchwert = scanner.nextLong();

	        long startZeit = System.currentTimeMillis();

	        System.out.println(lineareSuche(a, suchwert));

	        long endZeit = System.currentTimeMillis();

	        System.out.println("Laufzeit: " + (endZeit - startZeit) + " ms");

	        scanner.close();
	    }
	
}
