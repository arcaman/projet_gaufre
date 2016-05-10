/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Gaufre.Controleur;
import java.awt.event.*;
import static java.lang.System.exit;
import javax.swing.JFrame;

class EcouteurDeBoutonJeu implements ActionListener {
    private Controleur c;
    private JFrame frames[];
    
    public EcouteurDeBoutonJeu(Controleur c,JFrame[] frames) {
        this.c=c;
        this.frames=frames;
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("Quitter"))
                quitter();
        else if(action.equals("Nouveau"))
                nouveau();
        else if(action.equals("Sauvegarder"))
                sauvegarder();
        else if(action.equals("Charger"))
                charger();
        else if(action.equals("Annuler"))
                annuler();
        else if(action.equals("Refaire"))
                refaire();
        else if(action.equals("Aide"))
                aide();
        else 
                System.out.println("Erreur Bouton");
    }
    
    private void quitter() {
        exit(0);
    }

    private void nouveau() {
        //c.nouveau();
    }

    private void sauvegarder() {
        //c.sauvegarder();
    }

    private void charger() {
        //c.charger();
    }

    private void annuler() {
        //c.annuler();
    }

    private void refaire() {
        //c.refaire();
    }

    private void aide() {
        //c.aide();
    }
}
