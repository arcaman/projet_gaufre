package packageGaufre;

import java.awt.Point;
import java.io.*;

import javax.print.attribute.standard.DocumentName;

import joueur.*;

public class Controleur implements java.io.Serializable {

	Model donneesJeu;

	public Controleur(int lignes, int colonnes, int nbJoueurs) {
		Joueur[] tabJ = new Joueur[nbJoueurs];
		tabJ[0] = new IAFacile(this, 1000);
		// tabJ[0] = new IAMoyen(this,1000);
		tabJ[1] = new IAMoyen(this, 1000);
		// System.out.println("this: " + this);

		donneesJeu = new Model(lignes, colonnes, tabJ);

		// System.out.println("ia facile taille tableau: " +
		// tabJ[0].controleur.getDonneesJeu().getlignes());

	}

	public boolean partieFinie() {

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

	public boolean coupEstValide(Point pointJouee) {
		return donneesJeu.getCase(pointJouee);
	}

	public Model getDonneesJeu() {
		return donneesJeu;
	}

	public boolean[][] creationTableauHistoriquePlateauJeu() {

		boolean[][] tabGaufreHistorique = new boolean[donneesJeu.lignes][donneesJeu.colonnes];

		boolean[][] tabCourante = donneesJeu.getTabGaufre();

		for (int i = 0; i < donneesJeu.lignes; i++) {
			for (int j = 0; j < donneesJeu.colonnes; j++) {
				tabGaufreHistorique[i][j] = tabCourante[i][j];
			}
		}

		return tabGaufreHistorique;

	}

	public void annuler() {
		donneesJeu.annuler();
	}

	public void refaire() {
		donneesJeu.refaire();
	}

	public void moteur() {

		afficherPlateauJeu(); // fonction personnelle de vue

		while (!partieFinie()) {

			donneesJeu.listeAnnuler.add(creationTableauHistoriquePlateauJeu());

			Joueur j = donneesJeu.getJoueur(donneesJeu.getJoueurCourant());
			Point pointJouee;
			do {
				pointJouee = j.jouer();
				System.out.println("joueur " + donneesJeu.getJoueurCourant() + "veut jouer" + pointJouee);
			} while (!coupEstValide(pointJouee));

			donneesJeu.manger(pointJouee);

			afficherPlateauJeu(); // fonction personnelle de vue

			// ecriture dans arraylist annuler pour pouvoir revenir en arriere

			donneesJeu.joueurSuivant();

		}

		donneesJeu.listeAnnuler.add(creationTableauHistoriquePlateauJeu());
		// ici la partie est finie donc le joueur suivant a perdu. Ce joueur est
		// incremente en fin de boucle donc c est ok
		System.out.println("le joueur numero : " + donneesJeu.getJoueurCourant() + " a perdu");

		// System.out.println("Affichage des valeurs dans le sens inverse pour
		// verifier que stockage ok");
		// for (int i = donneesJeu.listeAnnuler.size() - 1; i >= 0; i--) {
		// System.out.println("Affichage un cran avant");
		// afficherPlateauJeuAvecParametre(donneesJeu.listeAnnuler.get(i));
		// }

		// System.out.println("--------");
		// afficherPlateauJeu();
		// this.annuler();
		// this.annuler();
		// this.refaire();
		// afficherPlateauJeu();
		// System.out.println("--------");

	}

	// vue temporaire pour tests persos
	public void afficherPlateauJeu() {
		for (int i = 0; i < donneesJeu.lignes; i++) {
			for (int j = 0; j < donneesJeu.colonnes; j++) {

				if (i == 0 && j == 0) {
					System.out.print("O");
				} else if (donneesJeu.tabGaufre[i][j]) {
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

	public void afficherPlateauJeuAvecParametre(boolean[][] gaufrinette) {
		for (int i = 0; i < donneesJeu.lignes; i++) {
			for (int j = 0; j < donneesJeu.colonnes; j++) {

				if (i == 0 && j == 0) {
					System.out.print("O");
				} else if (gaufrinette[i][j]) {
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

	}

	public void sauvegarder() {

		ObjectOutputStream oos = null;

		try {
			final FileOutputStream fichier = new FileOutputStream("donneesJeu.ser");
			oos = new ObjectOutputStream(fichier);
			oos.writeObject(donneesJeu);
			oos.flush();
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (oos != null) {
					oos.flush();
					oos.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	public void charger() {
		ObjectInputStream ois = null;
		try {
			final FileInputStream fichierIn = new FileInputStream("donneesJeu.ser");
			ois = new ObjectInputStream(fichierIn);
			donneesJeu = (Model) ois.readObject();
		} catch (final java.io.IOException e) {
			e.printStackTrace();
		} catch (final ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			try {
				if (ois != null) {
					ois.close();
				}
			} catch (final IOException ex) {
				ex.printStackTrace();
			}
		}
	}

}
