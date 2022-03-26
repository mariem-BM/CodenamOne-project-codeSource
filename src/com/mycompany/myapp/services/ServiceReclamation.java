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
import com.mycompany.myapp.entities.Reclamation;
import com.mycompany.myapp.utils.Statics;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 *
 * @author ASUS
 */
public class ServiceReclamation {
    public ArrayList<Reclamation> reclamations;
    //singleton
    
    public static ServiceReclamation instance = null ;
    
    // Initialisation connexion request
     public static boolean resultOk = true;
    private ConnectionRequest req;
    
    
    public static ServiceReclamation getInstance() {
        if(instance == null )
            
         instance = new ServiceReclamation();  
        return instance;
       }
    
    
    public ServiceReclamation(){
        
        req = new ConnectionRequest();
    }
             /************************************Ajout reclam **********************/
    
    public void ajouterReclamation(Reclamation reclamation) {
        String url =Statics.BASE_URL+"/reclamation/ajoutReclamationjson/1?description_reclamation="+reclamation.getDescriptionReclamation() ;
        
        req.setUrl(url);
        req.addResponseListener((e) ->{
        
            String str = new String(req.getResponseData()) ; //Response json li jerbtha f navigateur
            System.out.println("data== "+str);
    });
        
        NetworkManager.getInstance().addToQueueAndWait(req); //exceution de la request sinon yetaada chay
        
        
    }
    /************Test affichage 2********************/
    public ArrayList<Reclamation> parseBillets(String jsonText){
        try {
            reclamations=new ArrayList<>();
            JSONParser j = new JSONParser();
            Map<String,Object> tasksListJson = 
               j.parseJSON(new CharArrayReader(jsonText.toCharArray()));
            
            List<Map<String,Object>> list = (List<Map<String,Object>>)tasksListJson.get("root");
            for(Map<String,Object> obj : list){
                Reclamation b = new Reclamation();
                float id = Float.parseFloat(obj.get("id").toString());
                b.setId((int)id);
              
                b.setDescriptionReclamation(obj.get("description_reclamation").toString());
                  b.setEtatReclamation(obj.get("etat_reclamation").toString());
                   b.setDateReclamation(obj.get("date_reclamation").toString());
               //b.setLocalisation(((int)Float.parseFloat(obj.get("localisation").toString())));
                reclamations.add(b);
            }
        } catch (IOException ex) {
            
        }
        return reclamations;
    }
    
    public ArrayList<Reclamation> getAllBillets(){
        
        String url = Statics.BASE_URL+"/reclamation/AllReclamations";
        req.setUrl(url);
       // req.setPost(false);
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                reclamations = parseBillets(new String(req.getResponseData()));
                req.removeResponseListener(this);
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        return reclamations;
    }
    
   
    /**************************Affichage ********************/
    
    public ArrayList<Reclamation>affichageReclamations() {
         ArrayList<Reclamation> result = new ArrayList<> ();
    
  String url = Statics.BASE_URL+"/reclamation/AllReclamations";
  req.setUrl(url);
  //req.setPost(false);
  req.addResponseListener(new ActionListener<NetworkEvent>() {
        @Override
        public void actionPerformed(NetworkEvent evt) {
        JSONParser jsonp;
        jsonp = new JSONParser();
        
        try{
            Map<String,Object>mapReclamations = jsonp.parseJSON(new CharArrayReader(new String(req.getResponseData()).toCharArray() ));
        
        List<Map<String,Object>> listOfMaps = (List<Map<String,Object>>) mapReclamations.get("root");
       
        for(Map<String,Object> obj : listOfMaps ) {
            Reclamation re = new Reclamation() ;
            
            //id est tjrs float dans codename one
            float id = Float.parseFloat(obj.get("id").toString());
            
            String description_reclamation = obj.get("description_reclamation").toString() ;
            String etat_reclamation = obj.get("etat_reclamation").toString() ;
      
        re.setId((int) id);
        re.setDescriptionReclamation(description_reclamation);
        re.setEtatReclamation(etat_reclamation);
       //date la reclam 
       // re.setDateReclamation(date_reclamation);
        
       String DateConverter = obj.get("date_reclamation").toString().substring(obj.get("date_reclamation").toString().indexOf("timestamp") + 10 , obj.get("date_reclamation").toString().lastIndexOf("}"));
       Date currentTime = new Date(Double.valueOf(DateConverter).longValue() * 1000);
        
       SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd") ;
       String  dateString = formatter.format(currentTime);
       re.setDateReclamation(dateString);
       //insert data into arrayist resukt 
        
        result.add(re);
        }
        
                
        }catch(Exception ex){
            ex.printStackTrace();
            
        }
        
        }
  } );
            NetworkManager.getInstance().addToQueueAndWait(req); //exceution de la request sinon yetaada chay

   return result;
    
    }
          
/*************Detail reclam *************************/
    
    public Reclamation DetailReclamation(int id ,Reclamation reclamation ){
        String url = Statics.BASE_URL+"reclamation/detailReclamationjson"+id; 
        req.setUrl(url);
        
        String str = new String (req.getResponseData());
    req.addResponseListener((evt) -> {
        
    JSONParser jsonp = new JSONParser();
    try{
        Map<String,Object>obj = jsonp.parseJSON(new CharArrayReader(new String (str).toCharArray()));
        
        reclamation.setDescriptionReclamation(obj.get("description_reclamation").toString());
        reclamation.setEtatReclamation(obj.get("etat_reclamation").toString());
        
    }catch(IOException ex){
        System.out.println("error related to sql :("+ex.getMessage());
    }
    
    System.out.println("data === "+str);
    });
       NetworkManager.getInstance().addToQueueAndWait(req); //exceution de la request sinon yetaada chay 
    return reclamation ;
    }
    
    //delete 2
    public boolean deleteBillet(Reclamation r) {
        String url = Statics.BASE_URL +"/reclamation/deleteReclamationjson?id="+r.getId();
//création de l'URL
        req.setUrl(url);// Insertion de l'URL de notre demande de connexion
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                resultOk = req.getResponseCode() == 200; //Code HTTP 200 OK
                req.removeResponseListener(this); //Supprimer cet actionListener       
            }
        });
        NetworkManager.getInstance().addToQueueAndWait(req);
        System.out.println(resultOk);
        return resultOk;
    }
    
    //delete
    public boolean deleteReclamation(int id ) {
        String url = Statics.BASE_URL +"/reclamation/deleteReclamationjson?id="+id;
        
        req.setUrl(url);
        
        req.addResponseListener(new ActionListener<NetworkEvent>() {
            @Override
            public void actionPerformed(NetworkEvent evt) {
                    
                    req.removeResponseCodeListener(this);
            }
        });
        
        NetworkManager.getInstance().addToQueueAndWait(req);
        return  resultOk;
    }
}


