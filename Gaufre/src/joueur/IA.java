package joueur;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Random;

public class IA extends Joueur{

	@Override
	public Point jouer() {
		// TODO Auto-generated method stub
		return null;
	}

	public ArrayList<Point> presTraitement(){
		ArrayList<Point> pointsValides = new ArrayList<Point>();
		for(int x = 0; x < model.getTabGaufre().length; x++){
			for(int y = 0; y < model.getTabGaufre().length; y++){
				Point aPlacer = new Point(x, y);
				if(controleur.verifieCoupValideOuNon(aPlacer)){
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
