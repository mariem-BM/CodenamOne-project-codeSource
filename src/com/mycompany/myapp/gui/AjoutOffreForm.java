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
import com.mycompany.myapp.services.ServiceOffre;
import com.mycompany.myapp.entities.Offre;

/**
 *
 * @author ASUS
 */
public class AjoutOffreForm extends Form {
    
     Form current;
    public AjoutOffreForm() {
        setTitle("Ajouter une nouvelle offre");
        setLayout(BoxLayout.y());
        
        TextField tfnom_offre = new TextField("","Nom offre");
        TextField tfdescription_offre= new TextField("", "Description offre");
        TextField tfprix_offre = new TextField("","prix Offre");
        TextField tfreduction= new TextField("", "reduction");
        TextField tfdate_debut_offre = new TextField("", "date debut offre");
        TextField tfdate_fin_offre = new TextField("", "date fin offre");
        Button btnAddOffre = new Button("Ajouter l'Offre");
        Button next = new Button("suivant");
        btnAddOffre.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                if ((tfnom_offre.getText().length()==0)||( tfdescription_offre.getText().length()==0)||(tfprix_offre.getText().length()==0)||(tfreduction.getText().length()==0)||(tfdate_debut_offre.getText().length()==0)||(tfdate_fin_offre.getText().length()==0))
                    Dialog.show("Alert", "Please fill all the fields", new Command("OK"));
                else
                {
                    try {
                        
                        Offre o = new Offre(tfnom_offre.getText(),tfdescription_offre.getText(), Integer.parseInt(tfprix_offre.getText()),Integer.parseInt(tfreduction.getText()),tfdate_debut_offre.getText().toString(),tfdate_fin_offre.getText().toString());
                      //  Offre o = new Offre(Integer.parseInt((tfnom_offre.getText().length()==0)),(tfdescription_offre.getText().length()==0),(tfdate_debut_offre.getText().length()==0),(tfdate_fin_offre.getText().length()==0));
                        if( ServiceOffre.getInstance().addOffre(o))
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
        addAll(tfnom_offre,tfdescription_offre,tfprix_offre,tfreduction,tfdate_debut_offre,tfdate_fin_offre,btnAddOffre,next);
      //  getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> previous.showBack());
                
    }
    
    
    
}
