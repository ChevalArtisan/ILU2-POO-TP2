package frontiere;

import controleur.ControlLibererEtal;

public class BoundaryLibererEtal {
	private ControlLibererEtal controlLibererEtal;

	public BoundaryLibererEtal(ControlLibererEtal controlLibererEtal) {
		this.controlLibererEtal = controlLibererEtal;
	}

	public void libererEtal(String nomVendeur) {
		controlLibererEtal.isVendeur(nomVendeur);
		boolean vendeurReconnu=controlLibererEtal.isVendeur(nomVendeur);
		if(!vendeurReconnu) {
			System.out.println("Mais vous n'etes pas inscrit sur notre marché aujourd'hui");
		}else {
			String[] donneesEtals=controlLibererEtal.libererEtal(nomVendeur);
			System.out.println("Vous avez vendu "+donneesEtals[4]+" sur "+donneesEtals[3]+""+donneesEtals[2]);
			System.out.println("Au revoir"+ nomVendeur+". Passez une bonne journée");
		}
	}

}
