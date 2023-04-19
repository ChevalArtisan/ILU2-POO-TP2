package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlVerifierIdentiteTest {
	
	private Village village;
	private Chef abraracourcix;
	private Gaulois asterix;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("le village des irréductibles", 10, 5);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		asterix = new Gaulois("Asterix", 12);
		village.ajouterHabitant(asterix);
	}
	@Test
	void testVerifierIdentite() {
		ControlVerifierIdentite control=new ControlVerifierIdentite(village); 
		assertTrue(control.verifierIdentite("Asterix"));
		assertTrue(control.verifierIdentite("Abraracourcix"));
		assertFalse(control.verifierIdentite("ChristopheDechavannes"));
	}

}
