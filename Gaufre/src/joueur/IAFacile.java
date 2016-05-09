package joueur;
import packageGaufre.*;

import java.awt.Point;

public class IAFacile extends IA{

	
	public IAFacile (Model m , Controleur c ,int tmp){
		this.model = m;
		this.controleur = c;
		this.temps = tmp;
	}
	
	public Point jouer() {
		return niveauFacile();
	}
	
	private Point niveauFacile(){
		return pointAleatoire(presTraitement());
	}
	

}
