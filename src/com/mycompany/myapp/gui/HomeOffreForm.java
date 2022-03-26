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
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.services.ServiceOffre;


/**
 *
 * @author ASUS
 */
public class HomeOffreForm extends Form{
    
     Offre o;
    Resources res;
    
    public HomeOffreForm(Form current) {
    // current=this; //Back
        setTitle("Offres");
        setLayout(BoxLayout.y());
        
        
     Button btnAddOffre = new Button("Ajouter une offre");
      Button btnListBillets = new Button("List Billets");
      
       
     btnAddOffre.addActionListener(e-> new AjoutOffreForm().show());
      btnListBillets.addActionListener(e-> new ListOffreForm(current));
      addAll(btnAddOffre,btnListBillets);
          
     
     
    
}
}