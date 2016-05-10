/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author Vince
 */
import java.awt.*;
import javax.swing.*;
import IHM.*;
import Gaufre.*;

public class Gaufre {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int lignes = 3;
	int colonnes = 5;
	int nbJoueurs = 2;

	Controleur controleur = new Controleur(lignes, colonnes);
		// System.out.println("main controleur: " + controleur);
		// System.out.println("le contneu de base d une case vaut : " +
		// controleur.donneesJeu.tabGaufre[1][1]);

	//controleur.moteur();
		// System.out.println("le contneu de base d une case vaut : " +
		// donneesJeu.tabGaufre[1][1]);
        
        SwingUtilities.invokeLater(new FenetreJeu(controleur));
    }

}
