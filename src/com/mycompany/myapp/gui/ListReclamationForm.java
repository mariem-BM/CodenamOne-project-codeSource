/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*package com.mycompany.myapp.gui;

//import com.codename1.components.SpanLabel;
//import static com.codename1.push.PushContent.setTitle;
//import com.codename1.ui.Button;
//import com.codename1.components.SpanLabel;
import com.codename1.components.SpanLabel;
import com.codename1.ui.Container;
import com.codename1.ui.Dialog;
import com.codename1.ui.FontImage;
//import com.codename1.ui.Display;
//import com.codename1.ui.EncodedImage;
//import com.codename1.ui.FontImage;
import com.codename1.ui.Form;
import com.codename1.ui.Label;
//import com.codename1.ui.Image;
import com.codename1.ui.TextArea;
import com.codename1.ui.Toolbar;
//import com.codename1.ui.URLImage;
import com.codename1.ui.layouts.BorderLayout;
import com.codename1.ui.layouts.BoxLayout;
import com.codename1.ui.layouts.GridLayout;
import com.codename1.ui.plaf.Style;
//import com.codename1.ui.plaf.Style;
import com.codename1.ui.util.Resources;
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.services.ServiceReclamation;
//import java.awt.BorderLayout;
//import java.awt.BorderLayout;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
/*public class ListReclamationForm extends Form  {
   
   
    Form current;
    
   /* public ListReclamationForm(Resources res) {
    
      setTitle("List Billets");

        SpanLabel sp = new SpanLabel();
        //   ArrayList<Reclamation>list = ServiceReclamation.getInstance().affichageReclamations();
        sp.setText(ServiceReclamation.getInstance().getAllBillets().toString());
        add(sp);
        
    }
}
       // getToolbar().addMaterialCommandToLeftBar("", FontImage.MATERIAL_ARROW_BACK, e -> res.show());
    
  public ListReclamationForm(Resources res){
       super("Newsfeed",BoxLayout.y());
        setTitle("liste des reclamations");
        setLayout(BoxLayout.y());
        
        Toolbar tb = new Toolbar(true);
        current = this;
        setToolbar(tb);
        getTitleArea().setUIID("container");
        tb.addSearchCommand(e -> {
              
          });
        
          getContentPane().setScrollVisible(false);
          
       
        //appel methode affichage
        
   //  ServiceReclamation.getInstance().getAllBillets().toString();
       ArrayList<Reclamation>list = ServiceReclamation.getInstance().affichageReclamations();
        
       for(Reclamation rec : list) {
            
            // addButton(rec.getDescriptionReclamation(),rec.getDateReclamation(),rec.getEtatReclamation(),rec);
       addButton(rec,res); 
       }
       
    }
 /*String description_reclamation,String date_reclamation,String etat_reclamation,
    private void addButton(Reclamation rec,Resources res) {
      
       Container cnt = new Container();
      
     /*   TextArea ta = new TextArea(description_reclamation);
        ta.setUIID("NewsTopLine");
        ta.setEditable(false);
        
      /*  Label descriptionTxt = new Label("description_reclamation :"+description_reclamation,"NewsTopLine2");
        Label dateTxt = new Label("date_reclamation :"+date_reclamation,"NewsTopLine2");
         Label etatTxt = new Label("etat_reclamation :"+etat_reclamation,"NewsTopLine2");
        
        Label objetTxt = new Label("date_reclamation : "+rec.getDateReclamation(),"NewsTopLine2");
        Label dateTxt = new Label("description_reclamation : "+rec.getDescriptionReclamation(),"NewsTopLine2");
        Label etatTxt = new Label("etat_reclamation : "+rec.getEtatReclamation(),"NewsTopLine2" );
        
       // cnt.add(BorderLayout.CENTER, BoxLayout.encloseY(ta));
       /*  cnt.add(BorderLayout.CENTER, BoxLayout.encloseY(BoxLayout.encloseX(dateTxt),BoxLayout.encloseX(descriptionTxt),BoxLayout.encloseX(etatTxt)));
        add(cnt);*/
       
       
       
        //supprimer button
      /*  Label lSupprimer = new Label(" ");
        lSupprimer.setUIID("NewsTopLine");
        Style supprmierStyle = new Style(lSupprimer.getUnselectedStyle());
        supprmierStyle.setFgColor(0xf21f1f);
        
        FontImage suprrimerImage = FontImage.createMaterial(FontImage.MATERIAL_DELETE, supprmierStyle);
        lSupprimer.setIcon(suprrimerImage);
        lSupprimer.setTextPosition(RIGHT);
        
        //click delete icon
        lSupprimer.addPointerPressedListener(l -> {
            
            Dialog dig = new Dialog("Suppression");
            
            if(dig.show("Suppression","Vous voulez supprimer ce reclamation ?","Annuler","Oui")) {
                dig.dispose();
            }
            else {
                dig.dispose();
                 }
                //n3ayto l suuprimer men service Reclamation
                if(ServiceReclamation.getInstance().deleteReclamation(rec.getId())) {
                    new ListReclamationForm(res).show();
                }
           
        });
    
       cnt.add(BorderLayout.CENTER,BoxLayout.encloseY(
                
                BoxLayout.encloseX(objetTxt),
                BoxLayout.encloseX(dateTxt),
                BoxLayout.encloseX(etatTxt)));
        
        
        
        add(cnt);
        
                }
    }


*/
