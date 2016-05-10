/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petitprojet;

import java.util.HashMap;
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
public class FenetrePartie extends JFrame {

    private JPanel conteneur;
    private ButtonGroup gr1;
    private ButtonGroup gr2;
    private JRadioButton[] bmode;
    private JRadioButton[] bdiff;
    private HashMap<String,JButton> boutons;

    public FenetrePartie() {
        //Fenetre de base
        setTitle("Choix du type de partie");
        setSize(1100, 700);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        conteneur = new JPanel();

        JLabel l1 = new JLabel("Nouvelle Partie");
        JLabel l2 = new JLabel("Selectionner type de partie :");

        //RadioGroup des boutons mode de jeu
        gr1 = new ButtonGroup();
        String[] modes = {"Solo", "Deux Joueurs"};
        bmode = new JRadioButton[2];
        for (int i = 0; i < bmode.length; i++) {
            bmode[i] = new JRadioButton(modes[i]);
            gr1.add(bmode[i]);
        }
        bmode[0].setEnabled(true);

        JLabel l3 = new JLabel("Difficulté de la partie (si jeu solo) :");

        //RadioGroup de la difficulté de l'IA
        gr2 = new ButtonGroup();
        String[] difficultées = {"Facile", "Moyen", "Difficile", "Hardcore"};
        bdiff = new JRadioButton[4];
        for (int i = 0; i < difficultées.length; i++) {
            bdiff[i] = new JRadioButton(difficultées[i]);
            gr2.add(bdiff[i]);
        }
        bdiff[0].setSelected(true);

        //Ajout au JPanel
        conteneur.add(l1);
        conteneur.add(l2);
        for (int i = 0; i < bmode.length; i++) {
            conteneur.add(bmode[i]);
        }
        conteneur.add(l3);
        for (int i = 0; i < bdiff.length; i++) {
            conteneur.add(bdiff[i]);
        }
        boutons = new HashMap();
        String[] nomboutons = {"Valider","Quitter","Charger"};
        for (int i=0; i<nomboutons.length;i++) {
            boutons.put(nomboutons[i],new JButton(nomboutons[i]));
            conteneur.add(boutons.get(nomboutons[i]));
        }

        setContentPane(conteneur);
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
