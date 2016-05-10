/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Gaufre.Controleur;
import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.HashMap;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 *
 * @author Adrien
 */
public class FenetreMenu implements Runnable {
    private JFrame f;
    private JPanel conteneurs[];
    private ButtonGroup gr1;
    private ButtonGroup gr2;
    private JRadioButton[] bmode;
    private JRadioButton[] bdiff;
    private HashMap<String,JButton> boutons;
    private Controleur c;
    EcouteurDeBoutonMenu e;

    public void run() {
        f = new JFrame("Menu Principal");
        boutons = new HashMap();
        gr1 = new ButtonGroup();
        gr2 = new ButtonGroup();
        e = new EcouteurDeBoutonMenu(c,gr1,gr2);
        //Fenetre de base
        f.setSize(640, 300);
        f.setResizable(true);
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLocationRelativeTo(null);
        f.setVisible(true);

        //Creation panels
        conteneurs = new JPanel[5];
        for (int i=0;i<5;i++) {
            conteneurs[i]=new JPanel();
        }
        
        //Conteneur 0
        JLabel l1 = new JLabel("Gaufre");
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        
        //Conteneur 3
        JLabel l2 = new JLabel("Selectionner type de partie :");
        l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        //RadioGroup des boutons mode de jeu
        String[] modes = {"Solo", "Deux Joueurs"};
        bmode = new JRadioButton[2];
        for (int i = 0; i < bmode.length; i++) {
            bmode[i] = new JRadioButton(modes[i]);
            gr1.add(bmode[i]);
        }
        bmode[0].setSelected(true);

        //Conteneur 4
        JLabel l3 = new JLabel("Difficulté de la partie (si jeu solo) :");
        //RadioGroup de la difficulté de l'IA
        String[] difficultées = {"Facile", "Moyen", "Difficile", "Hardcore"};
        bdiff = new JRadioButton[4];
        for (int i = 0; i < difficultées.length; i++) {
            bdiff[i] = new JRadioButton(difficultées[i]);            
            gr2.add(bdiff[i]);
        }
        bdiff[0].setSelected(true);
        //Conteneur 2
        String[] nomboutons = {"Valider","Charger","Quitter"};
        for (int i=0; i<nomboutons.length;i++) {
            boutons.put(nomboutons[i],new JButton(nomboutons[i]));
            conteneurs[2].add(boutons.get(nomboutons[i]));
        }
        
        for (int i = 0; i < nomboutons.length; i++) {
            boutons.get(nomboutons[i]).setActionCommand(nomboutons[i]);
            boutons.get(nomboutons[i]).addActionListener(e);
        }

        //Ajout au JPanels
        conteneurs[0].add(l1);
        conteneurs[1].setLayout(new GridLayout(1,2));
        conteneurs[3].setLayout(new BoxLayout(conteneurs[3], BoxLayout.PAGE_AXIS));
        conteneurs[3].add(l2);
        for (int i = 0; i < bmode.length; i++) {
            bmode[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            conteneurs[3].add(bmode[i]);
        }
        conteneurs[4].setLayout(new BoxLayout(conteneurs[4], BoxLayout.PAGE_AXIS));
        conteneurs[4].add(l3);
        for (int i = 0; i < bdiff.length; i++) {
            bdiff[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            conteneurs[4].add(bdiff[i]);
        }
        conteneurs[4].setLayout(new BoxLayout(conteneurs[4], BoxLayout.PAGE_AXIS));
        for (int i=0; i<nomboutons.length;i++) {
            conteneurs[2].add(boutons.get(nomboutons[i]));
        }
        conteneurs[1].add(conteneurs[3], BorderLayout.CENTER);
        conteneurs[1].add(conteneurs[4], BorderLayout.CENTER);
        f.add(conteneurs[0], BorderLayout.NORTH);
        f.add(conteneurs[1], BorderLayout.CENTER);
        f.add(conteneurs[2], BorderLayout.SOUTH);
    }
    
    public HashMap<String,JButton> getButtons() {
        return boutons;
    }
    
    public JButton getBouton(String name) {
        if (boutons.containsKey(name)) {
            return boutons.get(name);
        }
        return null;
    }
    
    
}