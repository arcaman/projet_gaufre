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
import java.util.HashMap;
import javax.swing.*;
import packageGaufre.*;

public class FenetreJeu extends JFrame {

	private JPanel[] conteneurs;
	private JFrame[] frames;
	private JLabel nbcoups;
	private HashMap<String, JButton> boutons;
	private Controleur c;
	private EcouteurDeBoutonJeu e;
	private Grille g;

	public JPanel[] getConteneurs() {
		return conteneurs;
	}

	public void setConteneurs(JPanel[] conteneurs) {
		this.conteneurs = conteneurs;
	}

	public JLabel getNbcoups() {
		return nbcoups;
	}

	public void setNbcoups(JLabel nbcoups) {
		this.nbcoups = nbcoups;
	}

	public HashMap<String, JButton> getBoutons() {
		return boutons;
	}

	public void setBoutons(HashMap<String, JButton> boutons) {
		this.boutons = boutons;
	}

	public packageGaufre.Controleur getC() {
		return c;
	}

	public void setC(packageGaufre.Controleur c) {
		this.c = c;
	}

	public EcouteurDeBoutonJeu getE() {
		return e;
	}

	public void setE(EcouteurDeBoutonJeu e) {
		this.e = e;
	}

	public FenetreJeu(Controleur c, JFrame[] frames) {
		this.frames = frames;
		this.c = c;
		g = new Grille(c.getDonneesJeu().getTabGaufre(), c);
		conteneurs = new JPanel[2];
		boutons = new HashMap();
		e = new EcouteurDeBoutonJeu(c, frames, g);
		String[] nomboutons = { "Nouveau", "Sauvegarder", "Charger", "Quitter", "Annuler", "Refaire", "Aide" };
		conteneurs[0] = new JPanel();
		conteneurs[1] = new JPanel();
		for (int i = 0; i < nomboutons.length; i++) {
			boutons.put(nomboutons[i], new JButton(nomboutons[i]));
			if (i < 4) {
				conteneurs[0].add(boutons.get(nomboutons[i]));
			} else {
				conteneurs[1].add(boutons.get(nomboutons[i]));
			}
		}
		for (int i = 0; i < nomboutons.length; i++) {
			boutons.get(nomboutons[i]).setActionCommand(nomboutons[i]);
			boutons.get(nomboutons[i]).addActionListener(e);
		}

		g.addMouseListener(new EcouteurDeSouris(g, c));

		add(conteneurs[0], BorderLayout.NORTH);
		add(g, BorderLayout.CENTER);
		add(conteneurs[1], BorderLayout.SOUTH);
	}

	public HashMap<String, JButton> getButtons() {
		return boutons;
	}

	public JButton getBouton(String name) {
		if (boutons.containsKey(name)) {
			return boutons.get(name);
		}
		return null;
	}

	public Grille getGrille() {
		return this.g;
	}

}
