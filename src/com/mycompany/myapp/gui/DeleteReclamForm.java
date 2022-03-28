/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Command;
import com.codename1.ui.Dialog;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.ServiceOffre;
import com.mycompany.myapp.services.ServiceReclamation;

/**
 *
 * @author ASUS
 */
public class DeleteReclamForm extends Form {
    
     DeleteReclamForm(Resources res, Reclamation r) {
        setTitle("Supprimer la reclamation");
        setLayout(BoxLayout.y());
   
        
        TextField tfID = new TextField ("", "id reclamation");
        Button btnSupprimerReclam = new Button("Supprimer la reclamation");
        
    
 btnSupprimerReclam.addActionListener(new ActionListener() {
             
      @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfID.getText().length() == 0)) {
                    Dialog.show("Alert", "Veillez remplir tous les champs s'il vous plait", new Command("OK"));
                } else {
                    System.out.println(tfID.getText());
                    System.out.println(r.getId());
                    System.out.println(r.getDescriptionReclamation());
                    System.out.println(r.getEtatReclamation());
                    System.out.println(r.getDateReclamation());
                
                    if (ServiceReclamation.getInstance().deleteReclamation(r)) {
                        Dialog.show("Success", "reclamation supprimé avec succés", new Command("OK"));
                    } else {
                        Dialog.show("ERROR", "Erreur de connexion", new Command("OK"));
                    }

                }
            }
        });
        addAll(tfID,btnSupprimerReclam);
       //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
}


