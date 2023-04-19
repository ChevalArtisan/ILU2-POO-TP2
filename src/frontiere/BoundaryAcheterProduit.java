package frontiere;

import java.util.Scanner;

import controleur.ControlAcheterProduit;
import personnages.Gaulois;
import villagegaulois.Etal;

public class BoundaryAcheterProduit {
	private Scanner scan = new Scanner(System.in);
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		System.out.println("Que voulez vous acheter ?");
		String nomProduit=scan.next();
		if(!controlAcheterProduit.isProduitDispo(nomProduit)) {
			System.out.println("Aucune étal ne vend des"+ nomProduit);
		}else {
			System.out.println("Chez quel commerçant voulez-vous acheter des "+ nomProduit);
			int commercantChoisi=-1;
			Gaulois[] listeCommercant=controlAcheterProduit.listeVendeursProduits(nomProduit);		
			int nbCommercant=listeCommercant.length;
			for (int i = 0; i <nbCommercant; i++) {
				System.out.println("-"+(i+1)+" "+listeCommercant[i].getNom());
			}
			do {
				commercantChoisi=scan.nextInt();
			} while (commercantChoisi<0 ||commercantChoisi>nbCommercant);
			scan.close();
			commercantChoisi--;
			String nomVendeur=listeCommercant[commercantChoisi].getNom();
			Etal etal=controlAcheterProduit.getEtal(nomVendeur);
			int stock=etal.getQuantite();
			System.out.println(nomAcheteur+" se déplace jusqu'à l'étal du vendeur "+ nomVendeur);
			System.out.println("Bonjour "+nomAcheteur+"\n Combien de fleurs voulez-vous acheter ?");
			int quantiteAchete=-1;
			do {
				quantiteAchete=scan.nextInt();
				if (quantiteAchete<1) {
					System.out.println("Rentrez un nombre superieur à 1");
				}else if (quantiteAchete>stock) {
					System.out.println("Il n'y a pas assez de "+nomProduit+", il n'en reste que "+stock);
				}scan.close();

			} while (quantiteAchete<1 || quantiteAchete>stock);
			etal.acheterProduit(quantiteAchete);
			System.out.println(nomAcheteur+" a achete "+quantiteAchete+" a "+nomVendeur);
		}
	}
}
