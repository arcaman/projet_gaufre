/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import packageGaufre.Controleur;
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
public class FenetreMenu extends JFrame {
    private JPanel conteneurs[];
    private JFrame frames[];
    private ButtonGroup gr1;
    private ButtonGroup gr2;
    private JRadioButton[] j1;
    private JRadioButton[] j2;
    private HashMap<String,JButton> boutons;
    private Controleur c;
    EcouteurDeBoutonMenu e;
    
    public JPanel[] getConteneurs() {
        return conteneurs;
    }

    public void setConteneurs(JPanel[] conteneurs) {
        this.conteneurs = conteneurs;
    }

    public ButtonGroup getGr1() {
        return gr1;
    }

    public void setGr1(ButtonGroup gr1) {
        this.gr1 = gr1;
    }

    public ButtonGroup getGr2() {
        return gr2;
    }

    public void setGr2(ButtonGroup gr2) {
        this.gr2 = gr2;
    }

    public JRadioButton[] getBmode() {
        return j1;
    }

    public void setBmode(JRadioButton[] bmode) {
        this.j1 = bmode;
    }

    public JRadioButton[] getBdiff() {
        return j2;
    }

    public void setBdiff(JRadioButton[] bdiff) {
        this.j2 = bdiff;
    }

    public HashMap<String, JButton> getBoutons() {
        return boutons;
    }

    public void setBoutons(HashMap<String, JButton> boutons) {
        this.boutons = boutons;
    }

    public Controleur getC() {
        return c;
    }

    public void setC(Controleur c) {
        this.c = c;
    }

    public EcouteurDeBoutonMenu getE() {
        return e;
    }

    public void setE(EcouteurDeBoutonMenu e) {
        this.e = e;
    }
    
    public FenetreMenu(Controleur c, JFrame[] frames) {
        this.frames=frames;
        boutons = new HashMap();
        gr1 = new ButtonGroup();
        gr2 = new ButtonGroup();
        e = new EcouteurDeBoutonMenu(c,frames);
        //Fenetre de base
        this.c = c;

        //Creation panels
        conteneurs = new JPanel[5];
        for (int i=0;i<5;i++) {
            conteneurs[i]=new JPanel();
        }
        
        //Conteneur 0
        JLabel l1 = new JLabel("Gaufre");
        l1.setFont(new Font("Arial", Font.BOLD, 20));
        
        //Conteneur 3
        JLabel l2 = new JLabel("Joueur 1 :");
        l2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        String[] modes = {"Humain", "Facile", "Moyen", "Difficile"};
        j1 = new JRadioButton[4];
        for (int i = 0; i < j1.length; i++) {
            j1[i] = new JRadioButton(modes[i]);
            gr1.add(j1[i]);
        }
        j1[0].setSelected(true);

        //Conteneur 4
        JLabel l3 = new JLabel("Joueur 2 :");
        String[] difficultées = {"Humain", "Facile", "Moyen", "Difficile"};
        j2 = new JRadioButton[4];
        for (int i = 0; i < difficultées.length; i++) {
            j2[i] = new JRadioButton(difficultées[i]);            
            gr2.add(j2[i]);
        }
        j2[0].setSelected(true);
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
        for (int i = 0; i < j1.length; i++) {
            j1[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            conteneurs[3].add(j1[i]);
        }
        conteneurs[4].setLayout(new BoxLayout(conteneurs[4], BoxLayout.PAGE_AXIS));
        conteneurs[4].add(l3);
        for (int i = 0; i < j2.length; i++) {
            j2[i].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
            conteneurs[4].add(j2[i]);
        }
        conteneurs[4].setLayout(new BoxLayout(conteneurs[4], BoxLayout.PAGE_AXIS));
        for (int i=0; i<nomboutons.length;i++) {
            conteneurs[2].add(boutons.get(nomboutons[i]));
        }
        conteneurs[1].add(conteneurs[3], BorderLayout.CENTER);
        conteneurs[1].add(conteneurs[4], BorderLayout.CENTER);
        add(conteneurs[0], BorderLayout.NORTH);
        add(conteneurs[1], BorderLayout.CENTER);
        add(conteneurs[2], BorderLayout.SOUTH);
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