package packageGaufre;

public class ExecutionGaufre {

	public static void main(String[] args) {

		int lignes = 3;
		int colonnes = 5;
		int nbJoueurs = 2;

		Controleur controleur = new Controleur(lignes, colonnes, nbJoueurs);
		// System.out.println("main controleur: " + controleur);
		// System.out.println("le contneu de base d une case vaut : " +
		// controleur.donneesJeu.tabGaufre[1][1]);

		controleur.moteur();
		// System.out.println("le contneu de base d une case vaut : " +
		// donneesJeu.tabGaufre[1][1]);

	}

}
