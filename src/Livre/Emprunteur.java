/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Livre;


/**
 *
 * @author Nicole
 */
public class Emprunteur {
    public String nom;
    public String prenom;
    public String adresse;
    public String mail;
    
    public String getNom(){
        return nom;
    }
    
    public void setNom(){
        this.nom=nom;
    }
    
    public String getPrenom(){
        return prenom;
    }
    
    public void setPrenom(){
        this.prenom=prenom;
    }
    
    public String getAdresse(){
        return adresse;
    }
    
    public void setAdresse(){
        this.adresse=adresse;
    }
    
    public String getMail(){
        return mail;
    }
    
    public void setMail(){
        this.mail=mail;
    }
    
    /**
     * 
     * @param nom
     * @param prenom
     * @param adr
     * @param mail 
     */
    
    public Emprunteur(String nom, String prenom, String adr, String mail){
        this.prenom=prenom;
        this.nom=nom;
        this.adresse=adr;
        this.mail=mail;
    }
    
    public String toString(){
        return "L'emprunteur: " + getNom() + " " + getPrenom() + ".\n Adresse: " + getAdresse() + ".\n EMail: " + getMail() + ".";
    }
}
