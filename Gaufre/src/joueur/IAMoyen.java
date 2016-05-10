package joueur;

import java.awt.Point;
import java.util.ArrayList;

import packageGaufre.Controleur;
import packageGaufre.Model;

public class IAMoyen extends IA{

	public IAMoyen (Controleur c ,int tmp){
		super(c ,tmp);
	}
	
	public Point jouer() {
		return niveauMoyen();
	}
	
	private Point niveauMoyen(){
	
		Point p1 = new Point(1,0);
		Point p2 = new Point(0,1);
		
		if(controleur.getDonneesJeu().getCase(p2)){
			if (!controleur.getDonneesJeu().getCase(p1)){
				return p2;
			}
		}
		
		if(controleur.getDonneesJeu().getCase(p1)){
			if(!controleur.getDonneesJeu().getCase(p2)){
				return p1;
			}
		}

		//recuperer points valides sauf p1 p2
		ArrayList<Point> pointsValides= presTraitement();
		
		//si la list est vide
		if(pointsValides.size() == 0){
			return p1;
		}
		
		
		//sinon renvoie un point aléatoire
		
		return pointAleatoire(pointsValides);
	}
	
	private ArrayList<Point> presTraitement(){
		
		ArrayList<Point> pointsValides = new ArrayList<Point>();		
		for(int x = 0; x < controleur.getDonneesJeu().getLignes(); x++){
			for(int y = 0; y < controleur.getDonneesJeu().getColonnes(); y++){
				if(!(((x==1)&&(y==0)) || ((x==0)&&(y==1)))){
					Point aPlacer = new Point(x, y);
					if(controleur.coupEstValide(aPlacer)){
						pointsValides.add(aPlacer);
					}
				}
			}
		}
		return pointsValides;
	}
	
}
