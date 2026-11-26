package sortiererei;

import java.util.ArrayList;
import java.util.Comparator;

public class Suchsystem {
	
	public static void main(String[] args) {
		ArrayList<Produkt> katalog = new ArrayList<>();
		for (int i = 1; i <= 3; i++) {
			katalog.add(new Produkt(i-1, "Produkt " + i));
		}
		katalog.sort(Comparator.comparingInt(Produkt::getId));
	
		Sucher sucher = new Sucher(katalog);

		sucher.startTimer();
		System.out.println(sucher.sucheLinear(2));
		sucher.endTimer();
		System.out.print("Lineare Suche: ");
		System.out.println(sucher.suchdauerInNanotime/1000);
		System.out.println("Anzahl Durchläufe: "+ sucher.anzahlDurchlaeufe);
		
		sucher.startTimer();
		System.out.println(sucher.sucheBinaer(2));
		sucher.endTimer();
		System.out.print("Binäre Suche: ");
		System.out.println(sucher.suchdauerInNanotime/1000);
		System.out.println("Anzahl Durchläufe:" + sucher.anzahlDurchlaeufe);
		

		sucher.startTimer();
		System.out.println(sucher.sucheMitSpruengen(2));
		sucher.endTimer();
		System.out.print("Sprungsuche: ");
		System.out.println(sucher.suchdauerInNanotime/1000);
		System.out.println("Anzahl Durchläufe:" + sucher.anzahlDurchlaeufe);

	}
}
