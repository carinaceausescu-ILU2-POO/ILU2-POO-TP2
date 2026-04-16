package controleur;

import villagegaulois.Village;

public class ControlAcheterProduit {
	private Village village;
	private ControlTrouverEtalVendeur controlTrouverEtalVendeur;
	private ControlVerifierIdentite controlVerifierIdentite;

	public ControlAcheterProduit(ControlVerifierIdentite controlVerifierIdentite,
			ControlTrouverEtalVendeur controlTrouverEtalVendeur,
			Village village) {
		this.village = village;
		this.controlVerifierIdentite = controlVerifierIdentite;
		this.controlTrouverEtalVendeur = controlTrouverEtalVendeur;
	}
	
	public boolean verifierIdentite(String nomAcheteur) {
		return controlVerifierIdentite.verifierIdentite(nomAcheteur);
	}
	
	public boolean existeVendeursProduit(String produit) {
	    return village.rechercherVendeursProduit(produit) != null;
	}
	
	public String[] donnerNomsVendeurs(String produit) {
	    String[] etatMarche = village.donnerEtatMarche();
	    // de 3 en 3: [nom vendeur, nombre de produits, nom de produit]
	    int count = 0;
	    for (int i = 0; i < etatMarche.length; i += 3) {
	        if (etatMarche[i + 2].equals(produit)) count++;
	    }
	    if (count == 0) return null;
	    String[] noms = new String[count];
	    int j = 0;
	    for (int i = 0; i < etatMarche.length; i += 3) {
	        if (etatMarche[i + 2].equals(produit)) {
	            noms[j++] = etatMarche[i];
	        }
	    }
	    return noms;
	}
	
	public int acheterProduit(String nomVendeur, int quantite) {
	    return village.rechercherEtal(village.trouverHabitant(nomVendeur)).acheterProduit(quantite);
	}

}
