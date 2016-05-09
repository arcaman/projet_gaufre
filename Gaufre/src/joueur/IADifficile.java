package joueur;

import java.awt.Point;

import packageGaufre.Controleur;
import packageGaufre.Model;

public class IADifficile extends IA{

	public IADifficile (Controleur c ,int tmp){
		super(c ,tmp);
	}
	
	public Point jouer() {
		Point resultat = niveauMoyen();
		return (resultat);
			
		
	}
	
	private Point niveauMoyen(){
		
		
		return null;
	}
	
	
}
