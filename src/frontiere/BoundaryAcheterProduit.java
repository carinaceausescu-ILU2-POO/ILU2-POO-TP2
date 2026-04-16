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
				String[] vendeurs = controlAcheterProduit.donnerNomsVendeurs(produit);
				StringBuilder question2 = new StringBuilder();
				question2.append("Chez quel commerçant voulez-vous acheter des " + produit + " ?\n");
				for (int i = 0; i < vendeurs.length; i++) {
				    question2.append((i + 1) + " - " + vendeurs[i] + "\n");
				}
				int choix = Clavier.entrerEntier(question2.toString());
				System.out.println( nomAcheteur + " se déplace jusqu'à l'étal du vendeur " + vendeurs[choix - 1]);
				System.out.println( "Bonjour " + nomAcheteur);
				int quantite = Clavier.entrerEntier("Combien de " + produit + " voulez-vous acheter ?");
				int quantiteAchetee = controlAcheterProduit.acheterProduit(vendeurs[choix - 1], quantite);
				if (quantiteAchetee == 0) {
				    System.out.println(nomAcheteur + " veut acheter " + quantite 
				        + " " + produit + ", malheureusement il n'y en a plus !");
				} else if (quantiteAchetee < quantite) {
				    System.out.println(nomAcheteur + " veut acheter " + quantite 
				        + " " + produit + ", malheureusement " + vendeurs[choix - 1] 
				        + " n'en a plus que " + quantiteAchetee + ". " 
				        + nomAcheteur + " achète tout le stock de " + vendeurs[choix - 1] + ".");
				} else {
				    System.out.println(nomAcheteur + " achète " + quantiteAchetee 
				        + " " + produit + " à " + vendeurs[choix - 1]);
				}
			}
		}
	}
}
