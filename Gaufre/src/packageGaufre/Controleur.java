package packageGaufre;

import java.awt.Point;

import javax.print.attribute.standard.DocumentName;

public class Controleur {

	static int joueurCourant = 1; // au debut on part du principe que le joueur
									// 1 commence
	static Model donneesJeu;

	public static boolean verifiePartieFinieOuNon() {

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

	public static boolean verifieCoupValideOuNon(Point pointJouee) {
		if (donneesJeu.tabGaufre[pointJouee.x][pointJouee.y] == true) {
			// le point n a pas ete joue
			return true;
		} else { // le point a ete joue precedemment
			return false;
		}
	}

	public static void jouer(Point pointJouee) {

		// boucle attente pour savoir si c est l ia ou un joueur qui joue.

		// recuperation d un point depuis l algorithme ou depuis le joueur avec
		// l ecouteur d event

		donneesJeu.manger(pointJouee);

	}

	public static void main(String[] args) {
		System.out.println("it works !!!");

		donneesJeu = new Model();

		moteur();
		// System.out.println("le contneu de base d une case vaut : " +
		// donneesJeu.tabGaufre[1][1]);

	}

	public static void moteur() {

		while (verifiePartieFinieOuNon() == false) {

			Point pointJouee = new Point(0, 0); // point que l on recupere avec
												// l ia ou via le mouse listener

			jouer(pointJouee);
			joueurCourant = ((joueurCourant + 1) / 2) + 1;

		}

		// ici la partie est finie donc le joueur suivant a perdu. Ce joueur est
		// incremente en fin de boucle donc c est ok

		System.out.println("le joueur numero : " + joueurCourant + " a perdu");

	}

}
