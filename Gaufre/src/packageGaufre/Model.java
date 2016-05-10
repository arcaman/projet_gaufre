package packageGaufre;

import joueur.*;
import java.awt.Point;
import java.util.*;

public class Model {

	boolean[][] tabGaufre;
	int lignes;
	int colonnes;
	int joueurCourant;
	Joueur[] tabJoueurs;

	ArrayList<boolean[][]> listeAnnuler;
	ArrayList<boolean[][]> listeRefaire;

	public Model(int lignes, int colonnes, Joueur[] tabJ) {
		this.tabGaufre = new boolean[lignes][colonnes];
		for (int i = 0; i < lignes; i++) {
			for (int j = 0; j < colonnes; j++) {
				this.tabGaufre[i][j] = true;
			}
		}
		this.lignes = lignes;
		this.colonnes = colonnes;
		joueurCourant = 0;
		tabJoueurs = tabJ;
		// System.out.println("dans model "+this.getlignes());

		this.listeAnnuler = new ArrayList<boolean[][]>();
		this.listeRefaire = new ArrayList<boolean[][]>();

	}

	public int getColonnes() {
		return colonnes;
	}

	public ArrayList<boolean[][]> getListeAnnuler() {
		return listeAnnuler;
	}

	public ArrayList<boolean[][]> getListeRefaire() {
		return listeRefaire;
	}

	public int getLignes() {
		return lignes;
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

	public void setColonnes(int colonnes) {
		this.colonnes = colonnes;
	}

	public void setListeAnnuler(ArrayList<boolean[][]> listeAnnuler) {
		this.listeAnnuler = listeAnnuler;
	}

	public void setListeRefaire(ArrayList<boolean[][]> listeRefaire) {
		this.listeRefaire = listeRefaire;
	}

	public void setLignes(int lignes) {
		this.lignes = lignes;
	}

	public void setTabGaufre(boolean[][] tabGaufre) {
		this.tabGaufre = tabGaufre;
	}

	public void setTabGaufreParValeur(boolean[][] newTabGaufre) {
		for (int i = 0; i < this.lignes; i++) {
			for (int j = 0; j < this.colonnes; j++) {
				this.tabGaufre[i][j] = newTabGaufre[i][j];
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

		for (int i = pointJouee.x; i < this.lignes; i++) {
			for (int j = pointJouee.y; j < this.colonnes; j++) {
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
