package controleur;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import personnages.Chef;
import personnages.Druide;
import personnages.Gaulois;
import villagegaulois.Village;

class ControlAfficherVillageTest {


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
	}
	
	@Test
	public void testDonnerNom() {
		ControlAfficherVillage control=new ControlAfficherVillage(village);
		String[] expect={"Abraracourcix","Asterix","Obelix","le druide pano"};
		System.out.println(control.donnerNomsVillageois().toString());
		assertArrayEquals(expect,control.donnerNomsVillageois());
	}
	
	@Test 
	public void testDonnerNbEtal() {
		ControlAfficherVillage control = new ControlAfficherVillage(village);
		assertEquals(control.donnerNbEtals(),5);
	}
	
	@Test
	public void testDonnerNomVillage() {
		ControlAfficherVillage control=new ControlAfficherVillage(village);
		assertEquals("melun",control.donnerNomVillage());
	}
}
