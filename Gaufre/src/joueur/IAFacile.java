package joueur;
import packageGaufre.*;

import java.awt.Point;

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
	

}
