/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package petitprojet;

import java.util.HashMap;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Adrien
 */
public class FenetreJeu extends JFrame{
    private JPanel conteneur;
    private JButton nouveau;
    private JButton sauvegarder;
    private JButton quitter;
    
    private JButton annuler;
    private JButton refaire;
    private JButton coupalea;
    private JLabel nbcoups;
    private HashMap<String,JButton> boutons;

    public FenetreJeu() {
        //Fenetre de base
        setTitle("Partie en cours");
        setSize(1100, 700);
        setResizable(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        //Conteneur des différents composants
        conteneur = new JPanel();
        boutons = new HashMap();
        String[] nomboutons = {"Nouveau","Sauvegarder","Quitter","Annuler","Refaire","Coup Aleatoire"};
        for (int i=0; i<nomboutons.length;i++) {
            boutons.put(nomboutons[i],new JButton(nomboutons[i]));
            conteneur.add(boutons.get(nomboutons[i]));
        }
        nbcoups = new JLabel("Nombre de Coups : 0");
        
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
