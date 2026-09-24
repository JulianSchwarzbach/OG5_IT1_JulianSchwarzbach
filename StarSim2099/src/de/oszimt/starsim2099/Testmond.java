package de.oszimt.starsim2099;

public class Testmond {
	
	public static void main(String[] args) {
		double posX = (double)(Math.random() * 160);
		double posY = (double)(Math.random() * 50);
		String erzArt = "Uran";
		String name = "Max Musterpilot";
		
		Mond meinMond = new Mond();
		meinMond.setErzArt(erzArt);
		meinMond.setName(name);
		meinMond.setPosX(posX);
		meinMond.setPosY(posY);
		
		if (meinMond.getErzArt().equals(erzArt))
			System.out.println("Implementierung 'Name'  korrekt!");
		
		if (meinMond.getName().equals(name))
			System.out.println("Implementierung 'Name'  korrekt!");
		
		if (meinMond.getPosX() == posX)
			System.out.println("Implementierung 'Position X' korrekt!");
		
		if (meinMond.getPosY() == posY)
			System.out.println("Implementierung 'Position Y' korrekt!");
	}

}

