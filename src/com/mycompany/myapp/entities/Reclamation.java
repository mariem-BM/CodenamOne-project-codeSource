/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.myapp.entities;

import java.util.Date;

/**
 *
 * @author ASUS
 */
public class Reclamation {
    
    private int id;
    private String description_reclamation;
    private String etat_reclamation;
    private String date_reclamation;

    public Reclamation() {
    }

    
    
    
    public Reclamation(int id, String description_reclamation, String etat_reclamation, String date_reclamation) {
        this.id = id;
        this.description_reclamation = description_reclamation;
        this.etat_reclamation = etat_reclamation;
        this.date_reclamation = date_reclamation;
    }

    public Reclamation(String description_reclamation, String etat_reclamation, String date_reclamation) {
        this.description_reclamation = description_reclamation;
        this.etat_reclamation = etat_reclamation;
        this.date_reclamation = date_reclamation;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescriptionReclamation() {
        return description_reclamation;
    }

    public void setDescriptionReclamation(String description_reclamation) {
        this.description_reclamation = description_reclamation;
    }

    public String getEtatReclamation() {
        return etat_reclamation;
    }

    public void setEtatReclamation(String etat_reclamation) {
        this.etat_reclamation = etat_reclamation;
    }

    public String getDateReclamation() {
        return date_reclamation;
    }

    public void setDateReclamation(String date_reclamation) {
        this.date_reclamation = date_reclamation;
    }

    public Reclamation(String description_reclamation) {
        this.description_reclamation = description_reclamation;
    }

    public Reclamation(String description_reclamation, String date_reclamation) {
        this.description_reclamation = description_reclamation;
        this.date_reclamation = date_reclamation;
    }

    @Override
    public String toString() {
        return "Reclamation{" + "id=" + id + ", description_reclamation=" + description_reclamation + ", etat_reclamation=" + etat_reclamation + ", date_reclamation=" + date_reclamation + '}';
    }
    
    
        
    
}
