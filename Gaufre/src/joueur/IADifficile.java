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
	
	public boolean[] tableauVersListe (boolean[][] t){
		boolean[] result = new boolean[controleur.getDonneesJeu().getLignes() + controleur.getDonneesJeu().getColonnes()];
		int ligne = controleur.getDonneesJeu().getColonnes() -1;
		int colonne = 0;
		for(int i = 0; i < result.length; i++){
			
			if(colonne >= controleur.getDonneesJeu().getLignes()){
				result[i] = false;
			}else if(ligne < 0){
					result[i] = true;
			}else{
				if(t[colonne][ligne]){
					result[i] = true;
					colonne++;
				}else{
					result[i] = false;
					ligne--;
				}
			}
			
		}
		return result;
	}
	
	public boolean[][] listeVersTableau (boolean[] listeHautDroite){
		// H = 0, D = 1
		boolean[][] result = new boolean[controleur.getDonneesJeu().getLignes()][controleur.getDonneesJeu().getColonnes()];
		int ligne = controleur.getDonneesJeu().getColonnes() -1;
		int colonne = 0;
		
		for(int i = 0; i < listeHautDroite.length; i++){
			if(listeHautDroite[i]){
				remplirColonne(result, colonne, ligne);
				colonne++;
			}else{
				remplirLigne(result, colonne, ligne);
				ligne--;
			}
		}
		return result;
	}
	
	private boolean[][] remplirLigne(boolean[][] aRemplir, int colonne, int ligne){
		for(int i = colonne; i< controleur.getDonneesJeu().getLignes(); i++){
			aRemplir[i][ligne] = false;
		}
		return aRemplir;
		
	}
	
	private boolean[][] remplirColonne(boolean[][] aRemplir, int colonne, int ligne){
		for(int i = ligne; i>= 0; i--){
			aRemplir[colonne][i] = true;
		}
		return aRemplir;
		
	}
	
}
