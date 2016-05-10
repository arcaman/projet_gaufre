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

class EcouteurDeBoutonMenu implements ActionListener {
    Controleur c;
    private ButtonGroup gr1;
    private ButtonGroup gr2;
    
    public EcouteurDeBoutonMenu(Controleur c, ButtonGroup gr1, ButtonGroup gr2) {
        this.c=c;
        this.gr1=gr1;
        this.gr2=gr2;
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
        ButtonModel nbjoueur = gr1.getSelection();
        //c.valider();
    }

    private void charger() {
        //c.charger();
    }
}
