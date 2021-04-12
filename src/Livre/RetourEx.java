/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Livre;

import java.util.*;

/**
 *
 * @author Maggie
 */
public class RetourEx {
    public int CodeBarreExemplaire;
    public int CodeBarreEmprunteur;
    public Date DateRetourMax;
    public Date DateRetour;
    public int idEmprunt;
    
    
    public int getCodeBEx(){
        return CodeBarreExemplaire;
    }
    
    public void setCodeBEx(){
        this.CodeBarreExemplaire=CodeBarreExemplaire;
    }
    
    public int getCodeBEmp(){
        return CodeBarreEmprunteur;
    }
    
    public void setCodeBEmp(){
        this.CodeBarreEmprunteur=CodeBarreEmprunteur;
    }
    
    public Date getDateRetourMax(){
        return DateRetourMax;
    }
    
    public void setDateRetourMax(){
        this.DateRetourMax=DateRetourMax;
    }
    
    public Date getDateRetour(){
        return DateRetour;
    }
    
    public void setDateRetour(){
        this.DateRetour=DateRetour;
    }
    
    public int getidEmprunt(){
        return idEmprunt;
    }
    
    public void setidEmprunt(){
        this.idEmprunt=idEmprunt;
    }
    
    /**
     * Constructeur
     * @param CodeBEx
     * @param CodeBEmp
     * @param DateRetourMax
     * @param DateRetour
     * @param idEmp
     */
    
    public RetourEx(int CodeBEx, int CodeBEmp, Date DateRetourMax, Date DateRetour, int idEmp){
        this.CodeBarreExemplaire=CodeBEx;
        this.CodeBarreEmprunteur=CodeBEmp;
        this.DateRetourMax=DateRetourMax;
        this.DateRetour=DateRetour;
        this.idEmprunt=idEmp;
    }
    
    public String toString(){
        return "Informations sur l'emprunt:\n" + "\n" + getCodeBEx() + "\n" + getCodeBEmp() + "\n" + getDateRetourMax() + "\n" + getDateRetour() + "\n" + getidEmprunt();
    }
    
   
    
}
