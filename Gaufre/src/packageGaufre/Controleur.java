package packageGaufre;

import java.awt.Point;

import javax.print.attribute.standard.DocumentName;

public class Controleur {

	static Model donneesJeu;

	public Controleur(Model m) {
		donneesJeu = m;
	}

	public boolean verifiePartieFinieOuNon() {

		boolean partieFinie;

		if (donneesJeu.tabGaufre[0][1] == false && donneesJeu.tabGaufre[1][0] == false) {
			partieFinie = true; // le process du jeu consiste à supprimer du
								// coin gauche en bas à droite. Du coup si ces
								// deux cases sont vides,
								// cela signifie que toute la gaufre est mangee
		} else {
			partieFinie = false;
		}

		return partieFinie;

	}

	public boolean verifieCoupValideOuNon(Point pointJouee) {
		return donneesJeu.getCase(pointJouee);
	}

	public static void jouer(Point pointJouee) {

		// boucle attente pour savoir si c est l ia ou un joueur qui joue.

		// recuperation d un point depuis l algorithme ou depuis le joueur avec
		// l ecouteur d event
		donneesJeu.manger(pointJouee);

	}

	public static void main(String[] args) {

		int longueur = 5;
		int largeur = 3;
		int nbJoueurs = 2;

		Model model = new Model(longueur, largeur, nbJoueurs);
		Controleur controleur = new Controleur(model);

		System.out.println("le contneu de base d une case vaut : " + donneesJeu.tabGaufre[1][1]);

		controleur.moteur();
		// System.out.println("le contneu de base d une case vaut : " +
		// donneesJeu.tabGaufre[1][1]);

	}

	public void moteur() {

		Point[] tabPoints = new Point[5];
		tabPoints[0] = new Point(2, 1);
		tabPoints[1] = new Point(1, 0);
		tabPoints[2] = new Point(0, 1);

		int valI = 0;

		while (verifiePartieFinieOuNon() == false) {

			afficherPlateauJeu(); // fonction personnelle de vue

			Point pointJouee = tabPoints[valI]; // point que l on recupere avec
												// l ia ou via le mouse listener
			donneesJeu.joueurSuivant();

			Controleur.jouer(pointJouee);

			valI++;
		}

		afficherPlateauJeu();

		// ici la partie est finie donc le joueur suivant a perdu. Ce joueur est
		// incremente en fin de boucle donc c est ok
		System.out.println("le joueur numero : " + donneesJeu.getJoueurCourant() + " a perdu");
	}

	// vue temporaire pour tests persos
	public void afficherPlateauJeu() {
		for (int i = 0; i < donneesJeu.largeur; i++) {
			for (int j = 0; j < donneesJeu.longueur; j++) {

				if (i == 0 && j == 0) {
					System.out.print("O");
				} else if (donneesJeu.tabGaufre[j][i]) {
					System.out.print("X");
				} else {
					System.out.print("=");
				}

			}
			System.out.println();
		}

		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();
		System.out.println();

	}

}
