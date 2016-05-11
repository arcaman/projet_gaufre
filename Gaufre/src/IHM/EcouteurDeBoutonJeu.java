/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import packageGaufre.Controleur;
import java.awt.event.*;
import static java.lang.System.exit;

import javax.imageio.ImageIO;
import javax.swing.JFileChooser;
import javax.swing.JFrame;

class EcouteurDeBoutonJeu implements ActionListener {
	private Controleur c;
	private JFrame frames[];
	private Grille g;

	public EcouteurDeBoutonJeu(Controleur c, JFrame[] frames, Grille g) {
		this.c = c;
		this.frames = frames;
		this.g = g;
	}

	public void actionPerformed(ActionEvent e) {
		String action = e.getActionCommand();
		if (action.equals("Quitter"))
			quitter();
		else if (action.equals("Nouveau"))
			nouveau();
		else if (action.equals("Sauvegarder"))
			sauvegarder();
		else if (action.equals("Charger"))
			charger();
		else if (action.equals("Annuler"))
			annuler();

		else if (action.equals("Refaire"))
			refaire();
		else if (action.equals("Aide"))
			aide();
		else
			System.out.println("Erreur Bouton");
	}

	private void quitter() {
		exit(0);
	}

	private void nouveau() {
		// c.nouveau();
	}

	private void sauvegarder() {

		String fichierSauvegarder = null;
		JFileChooser ouvertureFenetre = new JFileChooser();
		int checkEtatFenetre = ouvertureFenetre.showOpenDialog(null);
		if (checkEtatFenetre == ouvertureFenetre.APPROVE_OPTION) {
			fichierSauvegarder = ouvertureFenetre.getSelectedFile().getAbsolutePath();
			c.sauvegarder(fichierSauvegarder);
		}

	}

	private void charger() {

		String fichierCharger = null;
		JFileChooser ouvertureFenetre = new JFileChooser();
		int checkEtatFenetre = ouvertureFenetre.showOpenDialog(null);
		if (checkEtatFenetre == ouvertureFenetre.APPROVE_OPTION) {
			fichierCharger = ouvertureFenetre.getSelectedFile().getAbsolutePath();
			c.charger(fichierCharger);
			g.repaint();
		}

	}

	private void annuler() {
		c.annuler();
		g.repaint();
	}

	private void refaire() {
		c.refaire();
		g.repaint();
	}

	private void aide() {
		// c.aide();
	}
}
