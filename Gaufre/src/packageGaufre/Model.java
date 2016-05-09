package packageGaufre;

import java.awt.Point;
import java.util.*;

public class Model {

	boolean[][] tabGaufre;
	static int longueur = 5;
	static int largeur = 3;
	static int nbJoueurs = 2;

	ArrayList<Boolean[][]> listeAnnuler;
	ArrayList<Boolean[][]> listeRefaire;

	public Model() {
		this.tabGaufre = new boolean[longueur][largeur];
		for (int i = 0; i < longueur; i++) {
			for (int j = 0; j < largeur; j++) {
				this.tabGaufre[i][j] = true;
			}
		}

	}

	public static int getLargeur() {
		return largeur;
	}

	public ArrayList<Boolean[][]> getListeAnnuler() {
		return listeAnnuler;
	}

	public ArrayList<Boolean[][]> getListeRefaire() {
		return listeRefaire;
	}

	public static int getLongueur() {
		return longueur;
	}

	public static int getNbJoueurs() {
		return nbJoueurs;
	}

	public boolean[][] getTabGaufre() {
		return tabGaufre;
	}

	public static void setLargeur(int largeur) {
		Model.largeur = largeur;
	}

	public void setListeAnnuler(ArrayList<Boolean[][]> listeAnnuler) {
		this.listeAnnuler = listeAnnuler;
	}

	public void setListeRefaire(ArrayList<Boolean[][]> listeRefaire) {
		this.listeRefaire = listeRefaire;
	}

	public static void setLongueur(int longueur) {
		Model.longueur = longueur;
	}

	public static void setNbJoueurs(int nbJoueurs) {
		Model.nbJoueurs = nbJoueurs;
	}

	public void setTabGaufre(boolean[][] tabGaufre) {
		this.tabGaufre = tabGaufre;
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
