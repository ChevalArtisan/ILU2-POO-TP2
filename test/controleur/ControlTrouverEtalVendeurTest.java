package controleur;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlTrouverEtalVendeurTest {


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
		pano = new Druide("pano", 1, 2, 8);
		village.ajouterHabitant(pano);
		village.installerVendeur(asterix, "fions de vendée",50 );
	}
	@Test
	void testTrouverEtal() {
		ControlTrouverEtalVendeur control = new ControlTrouverEtalVendeur(village) ;
		assertNull(control.trouverEtalVendeur("Obelix"));
		assertEquals(control.trouverEtalVendeur("Asterix"),village.rechercherEtal(asterix));
	}

}
