/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

/**
 *
 * @author Vince
 */
import java.awt.*;
import javax.swing.*;

class Grille extends JComponent {
    private boolean[][] b;
    private int ligne;
    private int colonne;

    public Grille(boolean[][] b) {
        this.b = b;
        ligne = b.length;
        colonne = b[0].length;
    }

    public void traiterClic(Point m) {
        Dimension p = getSize();
        int i,j;

        j = m.x * colonne / p.width;
        i = m.y * ligne / p.height;
        b[i][j] = !b[i][j];
    }
    
    public void manger(Point pointJouee) {
                Dimension p = getSize();
                int x = pointJouee.x * colonne / p.width;
                int y = pointJouee.y * ligne / p.height;

		for (int i = y; i < this.ligne; i++) {
			for (int j = x; j < this.colonne; j++) {
				this.b[i][j] = false;
			}
		}

	}

    public void afficherCroix(int i, int j, Graphics2D drawable) {
        Dimension p = getSize();
        int x,y;
        int width, height;

        width = p.width /colonne;
        height = p.height / ligne;
        x = i*p.width/colonne;
        y = j*p.height/ligne;

        drawable.drawLine(x, y, x+width, y+height);
        drawable.drawLine(x, y+height, x+width, y);
    }

    public void paintComponent(Graphics g) {
        // Graphics 2D est le vrai type de l'objet passé en paramètre
        // Le cast permet d'avoir acces a un peu plus de primitives de dessin
        Graphics2D drawable = (Graphics2D) g;

        // On reccupere quelques infos provenant de la partie JComponent
        int width = getSize().width;
        int height = getSize().height;

        // On efface tout
        drawable.setPaint(Color.white);
        drawable.fillRect(0, 0, width, height);
        drawable.setPaint(Color.black);
        
        

        //Quadrillage
        for (int i=0; i<=colonne; i++)
             drawable.drawLine(i*width/colonne, 0, i*width/colonne, height);
        
        for (int i=0; i<=ligne; i++)
             drawable.drawLine(0, i*height/ligne, width, i*height/ligne);
        

        // On affiche les cases mangées
        for (int i=0; i<ligne; i++) {
            for (int j=0; j<colonne; j++) {
                if (b[i][j] != true) {
                    afficherCroix(j,i,drawable);
                }
            }
        }
    }
}