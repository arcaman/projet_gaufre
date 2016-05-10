package joueur;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import packageGaufre.Controleur;

public class IA extends Joueur{


	public IA (Controleur c ,int tmp){
		this.controleur = c;
		this.temps = tmp;
	}
	
	@Override
	public Point jouer() {
		// TODO Auto-generated method stub
		return null;
	}
	
	public Point pointAleatoire(ArrayList<Point> pointsValides){
		Random r = new Random();
		int indiceResultat = r.nextInt(pointsValides.size());
		
		return pointsValides.get(indiceResultat);
	}
	
	
	public boolean[][] listeVersTableau (boolean[] listeHautDroite){
		return null;
	}
	
	public boolean[] tableauVersListe (boolean[][] t){
		return null;
	}
}
