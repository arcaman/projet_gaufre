package packageGaufre;

public class ExecutionGaufre {

	public static void main(String[] args) {

		int lignes = 3;
		int colonnes = 5;
		int nbJoueurs = 2;

		Controleur controleur = new Controleur(lignes, colonnes, nbJoueurs);

		//controleur.charger();
		controleur.moteur();
		//controleur.sauvegarder();

	}

}
