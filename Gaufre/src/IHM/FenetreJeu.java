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
import Gaufre.*;

public class FenetreJeu implements Runnable {

    private JPanel[] conteneurs;
    private JFrame f;
    private JLabel nbcoups;
    private HashMap<String, JButton> boutons;
    private Controleur c;
    private EcouteurDeBoutonJeu e;

    public FenetreJeu(Controleur c) {
        this.c = c;
    }

    public void run() {
        // Creation d'une fenetre
        f = new JFrame("Gaufre");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setResizable(true);
        f.setSize(1366, 768);
        f.setVisible(true);

        //Conteneur des différents composants
        conteneurs = new JPanel[2];
        boutons = new HashMap();
        e = new EcouteurDeBoutonJeu(c);
        String[] nomboutons = {"Nouveau", "Sauvegarder", "Charger", "Quitter", "Annuler", "Refaire", "Aide"};
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

        Grille grille = new Grille(c.getDonneesJeu().getTabGaufre());
        grille.addMouseListener(new EcouteurDeSouris(grille));

        f.add(conteneurs[0], BorderLayout.NORTH);
        f.add(grille, BorderLayout.CENTER);
        f.add(conteneurs[1], BorderLayout.SOUTH);
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

}
