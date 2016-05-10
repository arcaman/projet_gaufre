package IHM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

class EcouteurDeSouris implements MouseListener {
    Grille g;

    // Ecouteur de souris a besoin de connaitre l'aire de dessin car elle doit
    // changer le message que celle ci affiche
    public EcouteurDeSouris(Grille g) {
        this.g = g;
    }

    public void mousePressed(MouseEvent e) {}
    public void mouseEntered(MouseEvent e) {}
    public void mouseExited(MouseEvent e) {}
    
    public void mouseClicked(MouseEvent e) {
        g.traiterClic(e.getPoint());
        g.repaint();
    }
    
    public void mouseReleased(MouseEvent e) {}
}