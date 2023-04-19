package frontiere;

import java.util.Scanner;

import controleur.ControlPrendreEtal;

public class BoundaryPrendreEtal {
	private ControlPrendreEtal controlPrendreEtal;
	private Scanner scan = new Scanner(System.in);

	public BoundaryPrendreEtal(ControlPrendreEtal controlChercherEtal) {
		this.controlPrendreEtal = controlChercherEtal;
	}

	public void prendreEtal(String nomVendeur) {
		if (!controlPrendreEtal.verifierIdentite(nomVendeur)){
			System.out.println("Je suis desole "+nomVendeur+" mais il faut etre un habitant du village peut commercer ici");
		}else {
			System.out.println("Bonjour "+nomVendeur+", je vais regarder si je peux vous trouver un etal");
			if (controlPrendreEtal.resteEtals()) {
				System.out.println("Je suis desole "+nomVendeur+", je n'ai plus d'etals de libre");
			} else {
				installerVendeur(nomVendeur);
			}
		}
	}

	private void installerVendeur(String nomVendeur) {
		StringBuilder message = new StringBuilder();
		message.append("C'est parfait, il me reste un étal pour vous");
		message.append(" Il me faudrait quelques renseignements");
		message.append(" Quel produit souhaitez-vous vendre ?");
		System.out.println(message);
		String produit=scan.nextLine();
		System.out.println("Combien souhaitez vous en vendre ?");
		int nbProduit=scan.nextInt();
		int numetal=controlPrendreEtal.prendreEtal(nomVendeur, produit, nbProduit);
		if(numetal!=-1) {
			System.out.println("Le vendeur "+nomVendeur+" s'est installe à l'etal n°"+numetal);
		};
	}
}
