package frontiere;

import controleur.ControlAcheterProduit;

public class BoundaryAcheterProduit {
	private ControlAcheterProduit controlAcheterProduit;

	public BoundaryAcheterProduit(ControlAcheterProduit controlAcheterProduit) {
		this.controlAcheterProduit = controlAcheterProduit;
	}

	public void acheterProduit(String nomAcheteur) {
		boolean nomAcheteurConnu = controlAcheterProduit.verifierIdentite(nomAcheteur);
		
		if(!nomAcheteurConnu) {
			System.out.println("Je suis désolée " +  nomAcheteur
					+ " mais il faut être un habitant de notre village pour commercer ici.");
		} else {
			String question = "Quel produit voulez-vous acheter ?";
			String produit = Clavier.entrerChaine(question);
			
			if (!controlAcheterProduit.existeVendeursProduit(produit)) {
			    System.out.println("Désolé, personne ne vend ce produit au marché.");
			    return;
			} else {
				
			}
		}
	}
}
