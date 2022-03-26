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
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.ServiceOffre;
import com.mycompany.myapp.services.ServiceReclamation;

/**
 *
 * @author ASUS
 */
public class AjoutReclamForm extends Form {
    
    
    Form current;
    public AjoutReclamForm() {
        setTitle("Ajouter une nouvelle reclamation");
        setLayout(BoxLayout.y());
        
        TextField tfdescription_reclamation = new TextField("","description reclamation");
       /* TextField tfdescription_offre= new TextField("", "Description offre");
        TextField tfprix_offre = new TextField("","prix Offre");
        TextField tfreduction= new TextField("", "reduction");
        TextField tfdate_debut_offre = new TextField("", "date debut offre");
        TextField tfdate_fin_offre = new TextField("", "date fin offre");*/
       
        Button btnAddReclamation = new Button("Ajouter la reclamation");
        Button next = new Button("suivant");
        
        btnAddReclamation.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfdescription_reclamation.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        
                        Reclamation r = new Reclamation(tfdescription_reclamation.getText());
                      //  Offre o = new Offre(Integer.parseInt((tfnom_offre.getText().length()==0)),(tfdescription_offre.getText().length()==0),(tfdate_debut_offre.getText().length()==0),(tfdate_fin_offre.getText().length()==0));
                        if( ServiceReclamation.getInstance().addReclamation(r))
                        {
                           Dialog.show("Succés","Votre offre a été bien ajouté",new Command("OK"));
                        }else
                            Dialog.show("ERROR", "Server error", new Command("OK"));
                    } catch (NumberFormatException e) {
                        Dialog.show("ERROR", "Veuillez vérifier vos champs", new Command("OK"));
                    }
                    
                }
                
                
            }
        });
        next.addActionListener(e -> new ListOffreForm(current));
        addAll(tfdescription_reclamation,btnAddReclamation,next);
      //  getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
}
}