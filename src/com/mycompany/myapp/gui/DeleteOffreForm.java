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
import com.mycompany.myapp.services.ServiceOffre;

/**
 *
 * @author ASUS
 */
public class DeleteOffreForm extends Form {
    

    
     DeleteOffreForm(Resources res, Offre o) {
        setTitle("Supprimer l'offre");
        setLayout(BoxLayout.y());
   
        
        TextField tfID = new TextField ("", "id offre");
        Button btnSupprimer = new Button("Supprimer l'offre");
        
         btnSupprimer.addActionListener(new ActionListener() {
             
      @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfID.getText().length() == 0)) {
                    Dialog.show("Alert", "Veillez remplir tous les champs s'il vous plait", new Command("OK"));
                } else {
                    System.out.println(tfID.getText());
                    System.out.println(o.getId());
                    System.out.println(o.getNomOffre());
                    System.out.println(o.getDescriptionOffre());
                    System.out.println(o.getPrixOffre());
                    System.out.println(o.getReduction());
                    System.out.println(o.getDateDebutOffre());
                    System.out.println(o.getDateFinOffre());
                    if (ServiceOffre.getInstance().deleteOffre(o)) {
                        Dialog.show("Success", "Offre supprimé avec succés", new Command("OK"));
                    } else {
                        Dialog.show("ERROR", "Erreur de connexion", new Command("OK"));
                    }

                }
            }
        });
        addAll(tfID, btnSupprimer);
       //getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
    }
}

