package de.futurehome.tanksimulator;
public class Tank {
	
	private double fuellstand;
	private double prozents ;
		
	

	public Tank(double fuellstand) {
		this.fuellstand = fuellstand;
	}

	public double getFuellstand() {
		return fuellstand;
	}

	public void setFuellstand(double fuellstand) {
		this.fuellstand = fuellstand;
	}
    public void setProzents(double prozents) {
		this.prozents = prozents;
	}
    public double getProzents() {
    	return prozents;
    }
}
