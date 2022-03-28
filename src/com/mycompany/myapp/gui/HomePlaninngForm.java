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
import com.mycompany.myapp.entities.Planinng;
import com.mycompany.myapp.services.ServicePlaninng;


/**
 *
 * @author skanr
 */
public class HomePlaninngForm extends Form{
    
     Planinng o;
    Resources res;
    
    public HomePlaninngForm(Form current) {
    // current=this; //Back
        setTitle("Planinngs");
        setLayout(BoxLayout.y());
        
        
     Button btnAddPlaninng = new Button("Ajouter un planinng");
      Button btnListPlaninngs = new Button("Consulter les planinngs");
      
       
     btnAddPlaninng.addActionListener(e-> new AjoutPlaninngForm().show());
      btnListPlaninngs.addActionListener(e-> new ListPlaninngForm(current));
      addAll(btnAddPlaninng,btnListPlaninngs);
          
     
     
    
}
}