package joueur;

import java.awt.Point;
import java.util.ArrayList;

public class IAFacile extends Joueur{

	
	public IAFacile (boolean[][] g, int tmp){
		this.gaufre = g;
		this.temps = tmp;
	}
	
	Point jouer() {
		niveauFacile();
		return (new Point());
			
		
	}
	
	private void niveauFacile(){
		
	}
	
	private ArrayList<Point> presTraitement(){
		ArrayList<Point> pointsValides= new ArrayList<Point>();
		for(int x = 0; x < gaufre.length; x++){
			for(int y = 0; y < gaufre.length; y++){
				Point aPlacer = new Point(x, y);
				//if(Controleur.estValide){
					
				//}
			}
		}
		return pointsValides;
	}
}
