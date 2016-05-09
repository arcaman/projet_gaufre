package joueur;

import java.awt.Point;

abstract class Joueur {

	boolean[][] gaufre;
	int temps;
	
	abstract Point jouer();
	
}
