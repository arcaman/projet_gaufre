package packageGaufre;

public class ExecutionGaufre {

	public static void main(String[] args) {

		int longueur = 5;
		int largeur = 3;
		int nbJoueurs = 2;

		Controleur controleur = new Controleur(longueur, largeur, nbJoueurs);
		// System.out.println("main controleur: " + controleur);
		// System.out.println("le contneu de base d une case vaut : " +
		// controleur.donneesJeu.tabGaufre[1][1]);

		controleur.moteur();
		// System.out.println("le contneu de base d une case vaut : " +
		// donneesJeu.tabGaufre[1][1]);

	}

}
