/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;

import static com.codename1.io.Log.e;
import com.codename1.ui.Button;
import com.codename1.ui.Form;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Localisation;
import com.mycompany.myapp.services.ServiceLocalisation;


/**
 *
 * @author skanr
 */
public class HomeLocalisationForm extends Form{
    
     Localisation o;
    Resources res;
    
    public HomeLocalisationForm(Form current) {
    // current=this; //Back
        setTitle("Localisations");
        setLayout(BoxLayout.y());
        
        
     Button btnAddLocalisation = new Button("Ajouter une localisation");
      Button btnListLocalisations = new Button("Consulter les localisations");
      
       
     btnAddLocalisation.addActionListener(e-> new AjoutLocalisationForm().show());
      btnListLocalisations.addActionListener(e-> new ListLocalisationForm(current));
      addAll(btnAddLocalisation,btnListLocalisations);
          
     
     
    
}
}