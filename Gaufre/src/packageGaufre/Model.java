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

	ArrayList<Boolean[][]> listeAnnuler;
	ArrayList<Boolean[][]> listeRefaire;

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
		System.out.println("dans model "+this.getLongueur());
	}

	public int getLargeur() {
		return largeur;
	}

	public ArrayList<Boolean[][]> getListeAnnuler() {
		return listeAnnuler;
	}

	public ArrayList<Boolean[][]> getListeRefaire() {
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

	public void setListeAnnuler(ArrayList<Boolean[][]> listeAnnuler) {
		this.listeAnnuler = listeAnnuler;
	}

	public void setListeRefaire(ArrayList<Boolean[][]> listeRefaire) {
		this.listeRefaire = listeRefaire;
	}

	public void setLongueur(int longueur) {
		this.longueur = longueur;
	}


	public void setTabGaufre(boolean[][] tabGaufre) {
		this.tabGaufre = tabGaufre;
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

	}

	public void annuler() {

	}

	public boolean getCase(Point pointJouee) {
		return tabGaufre[pointJouee.x][pointJouee.y];
	}

}
