package joueur;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import packageGaufre.Controleur;

public class IADifficileTest {

	Joueur jDifficile;
	int longueur;
	int largeur;
	Controleur controleur;
	
	@Before
	public void init() {
		longueur = 5;
		largeur = 4;
		int nbJoueurs = 2;
		controleur = new Controleur(longueur, largeur, nbJoueurs);
		jDifficile = new IADifficile(controleur,1000);
	}
	
	@Test
	public void test() {
		//H = true
		//D = false
		boolean[] listeTest = new boolean[longueur + largeur];
		listeTest[0] = false;
		listeTest[1] = true;
		listeTest[2] = false;
		listeTest[3] = true;
		listeTest[4] = false;
		listeTest[5] = true;
		listeTest[6] = false;
		listeTest[7] = true;
		listeTest[8] = true;
		
		boolean[][] verif = new boolean[longueur][largeur];
		for(int i=0;i<longueur;i++)
			for(int j=0;j < largeur;j++)
				verif[i][j] = false;
		
		verif[0][0] = true ;
		verif[0][1] = true ;
		verif[0][2] = true ;
		verif[1][0] = true ;
		verif[1][1] = true ;
		verif[2][0] = true ;

		
		boolean[][] test = jDifficile.listeVersTableau(listeTest);
		
		for(int i=0;i<longueur;i++)
			for(int j=0;j < largeur;j++)
				assertEquals(test[i][j], verif[i][j]);
		
		boolean[] testTableauVersListe = jDifficile.tableauVersListe(verif);
		for(int i=0;i<listeTest.length;i++){
			assertEquals(testTableauVersListe[i], listeTest[i]);
		}
		
		
	}
	



}
