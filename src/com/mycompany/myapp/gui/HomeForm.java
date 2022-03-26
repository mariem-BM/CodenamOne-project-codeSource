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
/**
 *
 * @author ASUS
 */
public class HomeForm extends Form {
    
    Form current;
    public HomeForm() {
        
       current=this; //Back
        setTitle("Home");
        setLayout(BoxLayout.y());
        
        add(new Label("Choose an option"));
        Button btnAjoutReclamation = new Button("Add Reclamation");
        Button addButton= new Button("List Reclamations");
       Button btnSupprimerReclamation = new Button("supprimer Reclamations");
        
        //btnAddReclamation.addActionListener(e-> new AddReclamationForm(current).show());
        //btnListReclamation.addActionListener(e-> new ListReclamationForm(current).show());
      
        addAll(btnAjoutReclamation,addButton,btnSupprimerReclamation);
          
        
    }

    HomeForm(Form current) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
