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
    }

    /*public void afficherCroix(int i, int j, Graphics2D drawable) {
        Dimension p = getSize();
        int x,y;
        int width, height;

        width = p.width / largeur;
        height = p.height / hauteur;
        x = i*p.width/largeur;
        y = j*p.height/hauteur;

        drawable.drawLine(x, y, x+width, y+height);
        drawable.drawLine(x, y+height, x+width, y);
    }*/

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

        // On quadrille
        for (int i=0; i<=ligne; i++) {
             drawable.drawLine(i*width/colonne, 0, i*width/colonne, height);
             drawable.drawLine(0, i*height/ligne, width, i*height/ligne);
        }
    }
}