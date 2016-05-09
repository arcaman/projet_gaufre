package packageGaufre;

import java.awt.Point;

import javax.print.attribute.standard.DocumentName;

public class Controleur {

	int joueurCourant;
	static Model donneesJeu;

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
		if (donneesJeu.tabGaufre[pointJouee.x][pointJouee.y] == true) {
			// le point n a pas ete joue
			return true;
		} else { // le point a ete joue precedemment
			return false;
		}
	}

	public void jouer() {

	}

	public static void main(String[] args) {
		System.out.println("it works !!!");

		donneesJeu = new Model();
		System.out.println("le contneu de base d une case vaut : " + donneesJeu.tabGaufre[1][1]);

	}

}
