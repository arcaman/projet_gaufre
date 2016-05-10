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
		boolean[] result = new boolean[controleur.getDonneesJeu().getLongueur() + controleur.getDonneesJeu().getLargeur()];
		int ligne = controleur.getDonneesJeu().getLargeur() -1;
		int colonne = 0;
		for(int i = 0; i < result.length; i++){
			
			if(colonne >= controleur.getDonneesJeu().getLongueur()){
				System.out.println("depasse colonne => H" + i);

				result[i] = false;
			}else if(ligne < 0){
				System.out.println("depasse ligne => D" + i);

					result[i] = true;
			}else{
				System.out.println("pas depassement");

				if(t[colonne][ligne]){
					System.out.println("dans D");
					result[i] = true;
					colonne++;
					System.out.println("colonne = " + colonne);
					afficherListeHautDroite(result);
	
				}else{
					System.out.println("dans H");
					result[i] = false;
					ligne--;
					System.out.println("ligne = " + ligne);
					afficherListeHautDroite(result);
	
				}
			}
			
		}
		afficherListeHautDroite(result);
		return result;
	}
	
	public boolean[][] listeVersTableau (boolean[] listeHautDroite){
		// H = 0, D = 1
		boolean[][] result = new boolean[controleur.getDonneesJeu().getLongueur()][controleur.getDonneesJeu().getLargeur()];
		int ligne = controleur.getDonneesJeu().getLargeur() -1;
		int colonne = 0;
		
		afficherPlateauJeu(result);
		for(int i = 0; i < listeHautDroite.length; i++){
			if(listeHautDroite[i]){
				System.out.println("dans D");
				remplirColonne(result, colonne, ligne);
				colonne++;
				System.out.println("colonne");
				afficherPlateauJeu(result);
			}else{
				System.out.println("dans H");
				remplirLigne(result, colonne, ligne);
				ligne--;
				System.out.println("ligne");
				afficherPlateauJeu(result);
			}
		}
		return result;
	}
	
	private boolean[][] remplirLigne(boolean[][] aRemplir, int colonne, int ligne){
		for(int i = colonne; i< controleur.getDonneesJeu().getLongueur(); i++){
			System.out.println("i = " + i + "j=" +ligne);
			aRemplir[i][ligne] = false;
		}
		return aRemplir;
		
	}
	
	private boolean[][] remplirColonne(boolean[][] aRemplir, int colonne, int ligne){
		for(int i = ligne; i>= 0; i--){
			System.out.println("i = " + colonne + "j=" +i);
			aRemplir[colonne][i] = true;
		}
		return aRemplir;
		
	}
	
	public void afficherListeHautDroite(boolean[] hd ) {
		for (int i = 0; i < hd.length; i++) {
			if(hd[i])
				System.out.print("D");
			else
				System.out.print("H");
		}
		System.out.println();

		
	}
	
	public void afficherPlateauJeu(boolean[][] PJ) {
		
		System.out.println("laaaaaa2");
		for (int i = 0; i < PJ[i].length; i++) {
			for (int j = 0; j < PJ.length; j++) {

				if (i == 0 && j == 0) {
					System.out.print("O");
				} else if (PJ[j][i]) {
					System.out.print("X");
				} else {
					System.out.print("=");
				}

			}
			System.out.println();
		}
		System.out.println("plus laaaaaa2");
		
	}
	
	
}
