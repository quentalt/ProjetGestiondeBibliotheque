/**Package de classes pour la manipulation de la biblioth�que*/
package Livre;

import java.util.Date;


/**Déclaration de la classe LIVRE*/
public class Livre extends jFrame {   

   

   

        public String titre;
	public String auteur;
        public String motsClefs;
        public int codeBarre;
        public String resume ;
        public double prix;
        //public int date_achat;
	public Date date_achat;
        public int Duree_vie;

   

     //Création des méthodes accesseurs & mutateurs

   public String getMotsClefs() {
        return motsClefs;
    }

    public void setMotsClefs(String motsClefs) {
        this.motsClefs = motsClefs;
    }

// public int getint_achat()
    public Date getDate_achat() {
        return date_achat;
    }

    public void setDate_achat(Date date_achat) {
        this.date_achat = date_achat;
    }

         
    public int getDuree_vie() {
        return Duree_vie;
    }

    public void setDuree_vie(int Duree_vie) {
        this.Duree_vie = Duree_vie;
    }
        


    public int getCodeBarre() {
        return codeBarre;
    }

    public void setCodeBarre(int codeBarre) {
        this.codeBarre = codeBarre;
    }


        
        
    public String getAuteur() {
        return auteur;
    }

    public void setAuteur(String auteur) {
        this.auteur = auteur;
    }

    public String getTitre() {
        return titre;
    }

    public void setTitre(String titre) {
        this.titre = titre;
    }


    public String getResume() {
        return resume;
    }

    public void setResume(String resume) {
        this.resume = resume;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

  
	/**Constructeur
         * 
         * @param y
         * @param t
         * @param a
         * @param e
         * @param val
         * @param resum 
         */

	public Livre(int y, String t, String a, String mtclef, String val, String resum, int codeBar, int duree_vie, Date date_ach, double p)
	{
                	this.Duree_vie = duree_vie;
		this.titre=t;
                	this.prix = p;
		this.auteur=a;
		this.motsClefs = mtclef;
                	this.resume = resum;
                	this.codeBarre = codeBar;
                	this.date_achat = date_ach;
                
	}
        
                @Override
 public String toString()
	{
		
		 
		return " les infos sur l'ouvrage: " +titre+ ","+ auteur + "," + motsClefs+ ","+ date_achat +","+prix+","+codeBarre+","+Duree_vie+",";
		
	}	


   
}