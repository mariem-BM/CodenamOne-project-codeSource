/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.ConnectionRequest;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.utils.Statics;
import java.util.ArrayList;

/**
 *
 * @author ASUS
 */
public class ServiceOffre {
    
    public ArrayList<Offre> offres;
    
     //singleton 
    public static ServiceOffre instance=null;
    public boolean resultOK;
    //initilisation connection request 
    private ConnectionRequest req;
    
    private ServiceOffre() {
         req = new ConnectionRequest();
    }
    public static ServiceOffre getInstance() {
        if (instance == null) {
            instance = new ServiceOffre();
        }
        return instance;
    }
    
     public boolean addOffre(Offre o) {
        System.out.println(o);
       // description_reclamation="+reclamation.getDescriptionReclamation(
      // String url = Statics.BASE_URL + "offre/ajoutOffrejson/" + o.getNomOffre()+"?description_offre=" + o.getDescriptionOffre() + "&prix_offre=" + o.getPrixOffre()+ "&reduction=" + o.getReduction()+ "&date_debut_offre=" + o.getDateDebutOffre()+ "&date_fin_offre=" + o.getDateFinOffre();
  String url = Statics.BASE_URL + "/offre/ajoutOffrejson?nom_offre="+o.getNomOffre()+"&description_offre="+o.getDescriptionOffre()+"&prix_offre="+o.getPrixOffre()+"&reduction="+o.getReduction()+"&date_debut_offre"+o.getDateDebutOffre()+"&date_fin_offre"+o.getDateFinOffre();
    
       req.setUrl(url);

       req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOK = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return resultOK;
    }

}
