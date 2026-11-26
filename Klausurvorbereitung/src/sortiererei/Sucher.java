package sortiererei;

import java.util.ArrayList;

public class Sucher {
	
	int anzahlDurchlaeufe;
	ArrayList<Produkt> produkte;
	long startTimeInNanoTime;
	long suchdauerInNanotime;
	
	public Sucher(ArrayList<Produkt> produkte) {
		this.produkte = produkte;
		this.anzahlDurchlaeufe = 0;
	}
	
	public void startTimer() {
		this.startTimeInNanoTime = System.nanoTime();
	}
	
	public void endTimer() {
		this.suchdauerInNanotime = System.nanoTime() - startTimeInNanoTime;
	}
	
	public int sucheLinear(int id) {
        for (int i = 0; i < produkte.size(); i++) {
            if (produkte.get(i).getId() == id) {
            	this.anzahlDurchlaeufe = i+1;
                return i;
            }
        }
        this.anzahlDurchlaeufe = produkte.size();
        return -1;
    }
	
	 public int sucheBinaer(int id) {
	        int links = 0;
	        int rechts = produkte.size() - 1;
	        int durchlaeufe = 0;

	        while (links <= rechts) {
	        	durchlaeufe++;
	            int mitte = (links + rechts) / 2;
	            Produkt produkt = produkte.get(mitte);

	            if (produkt.getId() == id) {
	            	this.anzahlDurchlaeufe = durchlaeufe;
	                return mitte;
	            } else if (produkt.getId() < id) {
	                links = mitte + 1;
	            } else {
	                rechts = mitte - 1;
	            }
	        }
	        this.anzahlDurchlaeufe = durchlaeufe;
	        return -1;
	    }
	 
	 public int sucheMitSpruengen(int id) {
		    int n = produkte.size();

		    if (n < 0) {
		        return -1;
		    }

		    int sprungweite = Math.max(1, (int) Math.sqrt(n));
		    int blockEnde = sprungweite;
		    int blockAnfang = 0;

		    // Springt blockweise vor, bis der passende Bereich gefunden ist
		    while (blockAnfang < n
		            && produkte.get(Math.min(blockEnde, n) - 1).getId() < id) {
		    	this.anzahlDurchlaeufe++;
		        blockAnfang = blockEnde;
		        blockEnde += sprungweite;

		        if (blockAnfang >= n) {
		            return -1;
		        }
		    }

		    // Durchsucht den gefundenen Bereich der Reihe nach
		    for (int i = blockAnfang; i < Math.min(blockEnde, n); i++) {
		    	this.anzahlDurchlaeufe++;
		        Produkt produkt = produkte.get(i);

		        if (produkt.getId() == id) {
		            return i;
		        }

		        if (produkt.getId() > id) {
		            return -1;
		        }
		    }

		    return -1;
		}

	
}
