package IHM;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import packageGaufre.*;

class EcouteurDeSouris implements MouseListener {
	Grille g;
	Controleur c;

	// Ecouteur de souris a besoin de connaitre l'aire de dessin car elle doit
	// changer le message que celle ci affiche
	public EcouteurDeSouris(Grille g, Controleur c) {
		this.g = g;
		this.c = c;
	}

	public void mousePressed(MouseEvent e) {
	}

	public void mouseEntered(MouseEvent e) {
	}

	public void mouseExited(MouseEvent e) {
	}

	public void mouseClicked(MouseEvent e) {

		int x = e.getPoint().x * c.getDonneesJeu().getColonnes() / g.getSize().width;
		int y = e.getPoint().y * c.getDonneesJeu().getLignes() / g.getSize().height;
//		int x = g.getSize().width / e.getPoint().x ;
//		int y = e.getPoint().y * c.getDonneesJeu().getLignes() / g.getSize().height;

		Point p = new Point(x, y);

		c.moteur();

		g.repaint();
	}

	public void mouseReleased(MouseEvent e) {
	}
}