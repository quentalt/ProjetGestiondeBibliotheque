/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Livre;

import com.sun.jdi.connect.spi.Connection;


/**
 *
 * @author quentin
 */

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
    /**
     * @param args the command line arguments
     * @return 
     */
public class LivreDatabase  {       
		
        static Connection con;
	static PreparedStatement pst;
	static ResultSet rs;
        
        private int DateDAchat;
                
         private int Duree_vie;
        
        public LivreDatabase(){
            
            getConnection();
        }
	
        public Connection getConnection(){
		try {
		Class.forName("com.mysql.cj.jdbc.Driver");
		String url = "jdbc:mysql://localhost:3306/projet_bibliotheque";
		con = (Connection) DriverManager.getConnection(url,"root","");
		
                
                }catch(ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return con;
	}
        


public void displayTable()throws SQLException{
     
 

		String select = "Select CodeBarre, Auteur, Titre, Prix, Resume, MotsClefs, DateDAchat,DureeDeVie from ouvrage";
		// Step 4
		rs = pst.executeQuery(select);
		// Step 5
		while (rs.next())
		{
			System.out.println("Code-Barre:    " + rs.getInt("CodeBarre"));
                        System.out.println(" Auteur: " + rs.getString("Auteur"));
			System.out.println("Titre:    " + rs.getString("Titre"));
                        System.out.println("Prix       " + rs.getInt("Prix"));
                        System.out.println("Résumé       " + rs.getInt("Resume"));
                        System.out.println("Mots-clefs       " + rs.getInt("MotsClefs"));
			System.out.println("Date d'Achat: " + rs.getString("DateDAchat"));
                        System.out.println("Duree de vie: " + rs.getString("DureeDeVie"));
                }
}

    /**
     *
     * @param nouveaulivre
     */
    public void savelivre(Livre nouveaulivre){
    
    try{
        
        int new_id = getCodeBarre()+1;
        String query = "INSERT INTO ouvrage CodeBarre, Auteur, Titre, Prix, Resume, MotsClefs, DateDAchat,DureeDeVie from ouvrage) VALUES ("
                + new_id
                +"," + nouveaulivre.getTitre()
                +","+ nouveaulivre.getAuteur()
                +"," + nouveaulivre.getPrix()
                +"," + nouveaulivre.getResume()
                + "," + nouveaulivre.getMotsClefs()
                + "," + nouveaulivre.getDate_achat()
                + "," + nouveaulivre.getDuree_vie()+")";
                
        int rs = pst.executeUpdate(query);
        if (rs ==0){
            
            System.out.println("L'insertion des données a échoué: "
                     +"," + nouveaulivre.getTitre()
                +","+ nouveaulivre.getAuteur()
                +"," + nouveaulivre.getPrix()
                +"," + nouveaulivre.getResume()
                + "," + nouveaulivre.getMotsClefs()
                + "," + nouveaulivre.getDate_achat()
                + "," + nouveaulivre.getDuree_vie());

        }
                
    }
    catch(Exception e){
        System.out.println(e);
    }
   
        try {
            con.close();
        } catch (IOException ex) {
            Logger.getLogger(LivreDatabase.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    

public int getCodeBarre() throws SQLException {
    
    try{
        
        String select = "SELECT MAX(CodeBarre) FROM ouvrage";
        
        rs = pst.executeQuery(select);
        
        rs.next();
        
    }
    
    catch(Exception e) {
        
        System.out.println(e);
    }
    
    return rs.getInt(1);
}

public  int getDate_achat() throws SQLException{
    
 
    try{
        
         String select = "SELECT DateDAchat FROM ouvrage";
        
        rs = pst.executeQuery(select);
        
        rs.next();
        
        DateDAchat = rs.getInt(1);
        
        
    }
    
    catch(Exception e) {
        
        System.out.println(e);
        
        
    }
    
    return DateDAchat;
}

public int getDuree_vie() {
    
 
    try{
        
         String select = "SELECT DureeDeVie FROM ouvrage";
        
        rs = pst.executeQuery(select);
        
        rs.next();
        
        Duree_vie = rs.getInt(1);
        
        
    }
    
    catch(Exception e) {
        
        System.out.println(e);
        
        
    }
    
    return Duree_vie;
}

}


        




    




