package joueur;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

import packageGaufre.Controleur;

public class IA extends Joueur{

	@Override
	public Point jouer() {
		// TODO Auto-generated method stub
		return null;
	}

	public IA (Controleur c ,int tmp){
		this.controleur = c;
		this.temps = tmp;
	}
	
	public ArrayList<Point> presTraitement(){
		//System.out.println("ta mère ");
		
		ArrayList<Point> pointsValides = new ArrayList<Point>();
		//System.out.println("ta mère ");

		//System.out.println("ta mère2 " + controleur.getDonneesJeu().getLongueur());

		
		for(int x = 0; x < controleur.getDonneesJeu().getLignes(); x++){
			//System.out.println("x="+x);;
			for(int y = 0; y < controleur.getDonneesJeu().getColonnes(); y++){
				//System.out.println("y="+y);;
				Point aPlacer = new Point(x, y); //affichage du point ecrit
				//System.out.println(aPlacer);
				if(controleur.coupEstValide(aPlacer)){
					pointsValides.add(aPlacer);
				}
			}
		}
		return pointsValides;
	}
	
	public Point pointAleatoire(ArrayList<Point> pointsValides){
		Random r = new Random();
		int indiceResultat = r.nextInt(pointsValides.size());
		
		return pointsValides.get(indiceResultat);
	}
	
}
