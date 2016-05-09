package joueur;

import java.awt.Point;
import java.util.ArrayList;

import packageGaufre.Controleur;
import packageGaufre.Model;

public class IADifficile extends IA{

	public IADifficile (Model m , Controleur c ,int tmp){
		this.model = m;
		this.controleur = c;
		this.temps = tmp;
	}
	
	public Point jouer() {
		Point resultat = niveauMoyen();
		return (resultat);
			
		
	}
	
	private Point niveauMoyen(){
		
		
		return null;
	}
	
	
}
