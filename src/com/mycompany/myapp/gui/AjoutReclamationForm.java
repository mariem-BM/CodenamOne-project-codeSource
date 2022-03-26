/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.gui;
import com.codename1.components.InfiniteProgress;
import com.codename1.ui.Button;
import com.codename1.ui.Dialog;
//import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.TextField;
import com.codename1.ui.Toolbar;
//import com.codename1.ui.Toolbar;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.ServiceReclamation;
import java.text.SimpleDateFormat;
import java.util.Date;


/**
 *
 * @author ASUS
 */
public class AjoutReclamationForm extends BaseForm {
    Form current;
    public AjoutReclamationForm(Resources res){
       // super("Newsfeed",BoxLayout.y());
        
         setTitle("Reclamer");
        setLayout(BoxLayout.y());
        
        
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("container");
        tb.addSearchCommand(e -> {
              
          });
        
          getContentPane().setScrollVisible(false);
          
          
         TextField tfdescription_reclamation = new TextField("","description recamation");
         tfdescription_reclamation.setUIID("TextFieldBlack");
           
            Button btnAjouter = new Button("Reclamer");
          
          //on click btn
          btnAjouter.addActionListener((e) -> {
              
          try {
              
              if(tfdescription_reclamation.getText() == ""){
                 Dialog.show("veuillez verifier les donnes","","annuler", "OK") ;
              }
              else{
                  InfiniteProgress ip = new InfiniteProgress() ; //loading after insert data
             final Dialog iDialog = ip.showInfiniteBlocking();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd") ;
             
            Reclamation r = new Reclamation(String.valueOf(tfdescription_reclamation.getText()).toString(),
            format.format(new Date())) ;
            
            System.out.println("data reclamation =="+r);
            
              //apppel de la methode ajout reclam
              ServiceReclamation.getInstance().ajouterReclamation(r);
              
              iDialog.dispose();
              // affichage des reclam apres l'ajout
            new ListReclamationForm(res).show();
            //   ServiceReclamation.getInstance().affichageReclamations();
           
              
              refreshTheme();
              }
          }catch(Exception ex){
              ex.printStackTrace();
          }
          
          });
        
         Button btnListReclams = new Button("List Reclam");
      btnListReclams.addActionListener(e-> new ListReclamationForm(res).show());
       // addAll(btnListReclams);
                  addAll(tfdescription_reclamation,btnAjouter,btnListReclams);
               //    getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e-> res.showBack());
                
    }
    
    
}
