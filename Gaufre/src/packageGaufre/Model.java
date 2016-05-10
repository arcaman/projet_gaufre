package packageGaufre;

import joueur.*;
import java.awt.Point;
import java.util.*;

public class Model {

	boolean[][] tabGaufre;
	int longueur;
	int largeur;
	int joueurCourant;
	Joueur[] tabJoueurs;

	ArrayList<boolean[][]> listeAnnuler;
	ArrayList<boolean[][]> listeRefaire;

	public Model(int longueur, int largeur, Joueur[] tabJ) {
		this.tabGaufre = new boolean[longueur][largeur];
		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {
				this.tabGaufre[i][j] = true;
			}
		}
		this.longueur = longueur;
		this.largeur = largeur;
		joueurCourant = 0;
		tabJoueurs = tabJ;
		// System.out.println("dans model "+this.getLongueur());

		this.listeAnnuler = new ArrayList<boolean[][]>();
		this.listeRefaire = new ArrayList<boolean[][]>();

	}

	public int getLargeur() {
		return largeur;
	}

	public ArrayList<boolean[][]> getListeAnnuler() {
		return listeAnnuler;
	}

	public ArrayList<boolean[][]> getListeRefaire() {
		return listeRefaire;
	}

	public int getLongueur() {
		return longueur;
	}

	public int getNbJoueurs() {
		return tabJoueurs.length;
	}

	public boolean[][] getTabGaufre() {
		return tabGaufre;
	}

	public int getJoueurCourant() {
		return joueurCourant + 1;
	}

	public Joueur getJoueur(int indice) {
		return tabJoueurs[indice - 1];
	}

	public void setLargeur(int largeur) {
		this.largeur = largeur;
	}

	public void setListeAnnuler(ArrayList<boolean[][]> listeAnnuler) {
		this.listeAnnuler = listeAnnuler;
	}

	public void setListeRefaire(ArrayList<boolean[][]> listeRefaire) {
		this.listeRefaire = listeRefaire;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}

	public void setTabGaufre(boolean[][] tabGaufre) {
		this.tabGaufre = tabGaufre;
	}

	public void setTabGaufreParValeur(boolean[][] newTabGaufre) {
		for (int i = 0; i < this.largeur; i++) {
			for (int j = 0; j < this.longueur; j++) {
				this.tabGaufre[j][i] = newTabGaufre[j][i];
			}
		}
	}

	public void setJoueurCourant(int joueurCourant) {
		this.joueurCourant = joueurCourant;
	}

	public void setTabJoueurs(Joueur[] tabJoueurs) {
		this.tabJoueurs = tabJoueurs;
	}

	public void joueurSuivant() {
		this.joueurCourant = joueurCourant + 1;
		if (joueurCourant >= getNbJoueurs()) {
			this.joueurCourant = 0;
		}
	}

	public void manger(Point pointJouee) {

		for (int i = pointJouee.x; i < this.longueur; i++) {
			for (int j = pointJouee.y; j < this.largeur; j++) {
				this.tabGaufre[i][j] = false;
			}
		}

	}

	public void refaire() {
		// on effectue l operation 2 fois car il faut revenir a son propre etat
		// anterieur.
		for (int i = 0; i < 2; i++) {
			int dernierElementHistorique = this.listeRefaire.size() - 1;

			if (dernierElementHistorique >= 0) {
				setTabGaufreParValeur(this.listeRefaire.get(dernierElementHistorique));
				this.listeAnnuler.add(this.listeRefaire.get(dernierElementHistorique));
				this.listeRefaire.remove(dernierElementHistorique);
			}
		}

	}

	public void annuler() {
		// on effectue l operation 2 fois car il faut revenir a son propre etat
		// anterieur. Par exemple, A joue, B joue et A rejoue. Si il annule On
		// revient a l etat initial

		for (int i = 0; i < 2; i++) {
			int dernierElementHistorique = this.listeAnnuler.size() - 1;
			if (dernierElementHistorique >= 0) {
				setTabGaufreParValeur(this.listeAnnuler.get(dernierElementHistorique));
				this.listeRefaire.add(this.listeAnnuler.get(dernierElementHistorique));
				this.listeAnnuler.remove(dernierElementHistorique);
			}
		}

	}

	public boolean getCase(Point pointJouee) {
		return tabGaufre[pointJouee.x][pointJouee.y];
	}

}
