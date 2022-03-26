/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.services;

import com.codename1.io.CharArrayReader;
import com.codename1.io.ConnectionRequest;
import com.codename1.io.JSONParser;
import com.codename1.io.NetworkEvent;
import com.codename1.io.NetworkManager;
import com.codename1.ui.events.ActionListener;
import com.mycompany.myapp.entities.Offre;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
     
     
     //Affichage des offres
     
         public ArrayList<Offre> parseOffres(String jsonText){
        try {
            offres=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Offre o = new Offre();
                float id = Float.parseFloat(obj.get("id").toString());
                o.setId((int)id);
                
                o.setNomOffre(obj.get("nom_offre").toString());
                o.setDescriptionOffre(obj.get("description_offre").toString());
                o.setPrixOffre(((int)Float.parseFloat(obj.get("prix_offre").toString())));
                o.setReduction(((int)Float.parseFloat(obj.get("reduction").toString())));
                o.setDateDebutOffre(obj.get("date_debut_offre").toString());
                o.setDateFinOffre(obj.get("date_fin_offre").toString());
               
                offres.add(o);
            }
            
            
        } catch (IOException ex) {
            
        }
        return offres;
    }
   
      public ArrayList<Offre> getAllOffres(){
        
        String url = Statics.BASE_URL+"/offre/AllOffres";
        req.setUrl(url);
        req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                offres = parseOffres(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return offres;
    }

}
