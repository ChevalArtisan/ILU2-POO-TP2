package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlLibererEtalTest {


	private Village village;
	private Chef abraracourcix;
	private Gaulois asterix;
	private Gaulois obelix;
	private Druide pano;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("melun", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		asterix = new Gaulois("Asterix", 12);
		obelix = new Gaulois("Obelix", 1000);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		village.installerVendeur(asterix, "joliboutdebois", 1);
	}
	
	@Test
	void testIsVendeur() {
		ControlLibererEtal control= new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
		assertTrue(control.isVendeur("Asterix"));
		assertFalse(control.isVendeur("Obelix"));
	}
	
	@Test
	void testLibererEtal() {
		ControlLibererEtal control= new ControlLibererEtal(new ControlTrouverEtalVendeur(village));
		String[] expect= {"true","Asterix","joliboutdebois","1","0"};
		assertArrayEquals(expect, control.libererEtal("Asterix"));
	}

}
