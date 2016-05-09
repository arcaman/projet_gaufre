package joueur;

import java.awt.Point;

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

		return pointAleatoire(presTraitement());
	}
	
}
