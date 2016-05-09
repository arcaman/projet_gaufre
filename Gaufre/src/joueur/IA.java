package joueur;

import java.awt.Point;
import java.util.ArrayList;

public class IA extends Joueur{

	private int difficultee; // 0, 1, 2 resp. facile, moyen, difficile
	private boolean[][] gaufre;
	private int temps;
	
	public IA (int difficultee, boolean[][] gaufre, int temps){
		this.difficultee = difficultee;
		this.gaufre = gaufre;
		this.temps = temps;
	}
	
	Point jouer() {
		switch (difficultee){
			 case 0 :
			 	
				 break;
			 case 1 :
				 
		 		break;
			 case 2 :
				 
		 		break;		 			
			 default:
				 
				break;
		}
		return (new Point());
			
		
	}
	
	private void niveauFacile(){
		
	}
	
	private void niveauMoyen(){
		
	}
	
	private void niveauDifficile(){
		
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
