package joueur;
import packageGaufre.*;

import java.awt.Point;
import java.util.ArrayList;

public class IAFacile extends IA{

	
	public IAFacile (Controleur c ,int tmp){
		super(c ,tmp);
	}
	
	public Point jouer() {
		return niveauFacile();
	}
	
	private Point niveauFacile(){
		return pointAleatoire(presTraitement());
	}
	
	private ArrayList<Point> presTraitement(){
		
		ArrayList<Point> pointsValides = new ArrayList<Point>();		
		for(int x = 0; x < controleur.getDonneesJeu().getLongueur(); x++){
			for(int y = 0; y < controleur.getDonneesJeu().getLargeur(); y++){
				Point aPlacer = new Point(x, y);
				if(controleur.coupEstValide(aPlacer)){
					pointsValides.add(aPlacer);
				}
			}
		}
		return pointsValides;
	}

}
