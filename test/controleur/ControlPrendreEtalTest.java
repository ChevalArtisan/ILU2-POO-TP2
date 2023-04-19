package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlPrendreEtalTest {
	

	private Village village;
	private Chef abraracourcix;
	private Gaulois asterix;
	private Gaulois obelix;
	private Druide pano;

	@BeforeEach
	public void initialiserSituation() {
		System.out.println("Initialisation...");
		village = new Village("melun", 10, 2);
		abraracourcix = new Chef("Abraracourcix", 10, village);
		village.setChef(abraracourcix);
		asterix = new Gaulois("Asterix", 12);
		obelix = new Gaulois("Obelix", 1000);
		village.ajouterHabitant(asterix);
		village.ajouterHabitant(obelix);
		pano = new Druide("pano", 1, 2, 8);
		village.ajouterHabitant(pano);
	};
	@Test
	void testResteEtal() {
		ControlPrendreEtal control=new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		assertTrue(control.resteEtals());
		village.installerVendeur(obelix, "ඞ", 10);
		village.installerVendeur(asterix, "sususamogus", 1);
		assertFalse(control.resteEtals());
		
	}
	
	@Test
	void testPrendreEtal() {
		ControlPrendreEtal control=new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		assertEquals(0, control.prendreEtal("Asterix", "sugoma", 2));
		assertEquals(1, control.prendreEtal("Obelix", "sugoma", 2));

	}
	
	@Test 
	void testControlIdentite() {
		ControlPrendreEtal control=new ControlPrendreEtal(new ControlVerifierIdentite(village), village);
		assertTrue(control.verifierIdentite("Asterix"));
		assertFalse(control.verifierIdentite("DanielConversano"));
	}

}
