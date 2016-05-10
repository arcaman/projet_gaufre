/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Gaufre.*;
import java.awt.*;
import javax.swing.*;

/**
 *
 * @author givaudav
 */
public class IHM implements Runnable{  
    public void run() {
        int lignes = 6;
	int colonnes = 5;
	int nbJoueurs = 2;

        Controleur c = new Controleur(lignes, colonnes);
        
        JFrame[] frames = new JFrame[2];
        frames[0] = new FenetreMenu(c,frames);
        frames[1] = new FenetreJeu(c,frames);
        
        frames[0].setSize(640, 300);
        frames[0].setResizable(true);
        frames[0].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frames[0].setLocationRelativeTo(null);
        frames[0].setVisible(true);
        //Seconde Fenetre
        frames[1].setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
        frames[1].setResizable(true);
        frames[1].setSize(1366, 768);
        frames[1].setLocationRelativeTo(null);
        frames[1].setVisible(false);
        
    }
    
    public static void main(String[] args) {
        SwingUtilities.invokeLater(new IHM());
    }
}
