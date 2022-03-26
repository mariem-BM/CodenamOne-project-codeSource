/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
import com.codename1.ui.layouts.BoxLayout;
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.services.ServiceOffre;

/**
 *
 * @author ASUS
 */
public class DetailOffreForm extends Form {
    
     Form current;
     DetailOffreForm(Offre o) {
        setTitle("Détail de l'offre");
        setLayout(BoxLayout.y());
        
        o = ServiceOffre.getInstance().DetailOffre(o);
          
        Label labelid = new Label(String.valueOf(o.getId()),"id_offre");
        Label labelnom_offre= new Label(String.valueOf(o.getNomOffre()), "nom_offre");
        Label labeldescription_offre= new Label(String.valueOf(o.getDescriptionOffre()), "descriptionçoffre");
        Label labelprix_offre = new Label(String.valueOf(o.getPrixOffre()),"prix_offre");
        Label labelreduction= new Label(String.valueOf(o.getReduction()), "reduction");
        Label labeldate_debut_offre = new Label(String.valueOf(o.getDateDebutOffre()),"date_debut_offre ");
        Label labeldate_fin_offre = new Label(String.valueOf(o.getDateFinOffre()), "date_fin_offre ");
      
       
        Button suivant = new Button("suivant");
                
        suivant.addActionListener(e -> new ListOffreForm(current));
        addAll(suivant,labelid,labelnom_offre,labeldescription_offre,labelprix_offre,labelreduction,labeldate_debut_offre,labeldate_fin_offre);
       
    }
}
    
    

