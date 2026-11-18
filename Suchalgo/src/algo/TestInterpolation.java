package algo;

import java.util.Random;
import java.util.Scanner;

public class TestInterpolation {


	

		public static long[] getSortedList(int laenge){
			Random rand = new Random(111111);
			long[] zahlenliste = new long[laenge];
			long naechsteZahl = 0;
			
			for(int i = 0; i < laenge; i++){
				naechsteZahl += rand.nextInt(3)+1;
				zahlenliste[i] = naechsteZahl;
			}
			
			return zahlenliste;
		}
		
		public static String suchi(long start, long ende, long y, long[] b) {

		    if (start > ende) {
		        return "Nicht gefunden";
		    }

		    if (y < b[(int) start] || y > b[(int) ende]) {
		        return "Nicht gefunden";
		    }

		    long florb = start
		            + ((y - b[(int) start]) * (ende - start))
		            / (b[(int) ende] - b[(int) start]);

		    if (florb < 0 || florb >= b.length) {
		        return "Nicht gefunden";
		    }

		    if (y == b[(int) florb]) {
		        return "Gefunden an Stelle: " + florb;
		    }
		    else if (y < b[(int) florb]) {
		        return suchi(start, florb - 1, y, b);
		    }
		    else {
		        return suchi(florb + 1, ende, y, b);
		    }
		}
		
		public static void main(String[] args){
			final int ANZAHL = 20000000; //20.000.000
			
			long[] a = getSortedList(ANZAHL);
			Scanner scanner = new Scanner(System.in);
			System.out.println("Bitte geben sie die zu suchende Zahl an: ");
			long eingabinski = scanner.nextLong();
			System.out.println("Bitte geben sie die endposition in der Liste an (bei 0 endet das Programm beim Listenende): ");
			long eingabo = scanner.nextLong();
			System.out.println("Bitte geben sie die startposition in der Liste an (bei 0 startet das Programm beim Listenanfang): ");
			long eingabe = scanner.nextLong();
			if (eingabo == 0) {
				eingabo = a.length -1;
			}
			
			long time = System.currentTimeMillis();
			
			System.out.println(suchi(eingabe, eingabo, eingabinski, a));
			
			System.out.println(System.currentTimeMillis() - time + "ms");
		
			
		}
	}

