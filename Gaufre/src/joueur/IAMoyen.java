package joueur;

import java.awt.Point;

import packageGaufre.Controleur;
import packageGaufre.Model;

public class IAMoyen extends IA{

	public IAMoyen (Model m , Controleur c ,int tmp){
		this.model = m;
		this.controleur = c;
		this.temps = tmp;
	}
	
	public Point jouer() {
		return niveauMoyen();
	}
	
	private Point niveauMoyen(){
	
		Point p1 = new Point(1,0);
		Point p2 = new Point(0,1);
		
		if(model.getCase(p2)){
			if (!model.getCase(p1)){
				return p2;
			}	
		}
		
		if(model.getCase(p1)){
			if(!model.getCase(p2)){
				return p1;
			}
		}

		return pointAleatoire(presTraitement());
	}
	
}
