/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package IHM;

import Gaufre.Controleur;
import java.awt.event.*;
import static java.lang.System.exit;
import javax.swing.ButtonGroup;
import javax.swing.ButtonModel;
import javax.swing.JFrame;

class EcouteurDeBoutonMenu implements ActionListener {
    private Controleur c;
    private JFrame frames[];
    
    public EcouteurDeBoutonMenu(Controleur c, JFrame[] frames) {
        this.c=c;
        this.frames=frames;
    }

    public void actionPerformed(ActionEvent e) {
        String action = e.getActionCommand();
        if(action.equals("Quitter"))
                quitter();
        else if(action.equals("Charger"))
                charger();
        else if(action.equals("Valider"))
                valider();
        else 
                System.out.println("Erreur Bouton");
    }
    
    private void quitter() {
        exit(0);
    }

    private void valider() {
        //ButtonModel nbjoueur = gr1.getSelection();
        //c.valider();
        frames[0].setVisible(false);
        frames[1].setVisible(true);
    }

    private void charger() {
        //c.charger();
    }
}
