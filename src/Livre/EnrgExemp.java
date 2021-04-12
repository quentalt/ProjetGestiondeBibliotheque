/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Livre;

import java.awt.event.*;
import java.util.*;
import java.sql.*;
import javax.swing.*;
import java.text.*;
import static javax.swing.JOptionPane.INFORMATION_MESSAGE;
import static javax.swing.JOptionPane.WARNING_MESSAGE;
import static javax.swing.JOptionPane.showMessageDialog;
import net.proteanit.sql.DbUtils;
import org.joda.time.DateTime;
import org.joda.time.DateTimeZone;

/**
 *
 * @author Nicole
 */

class Id
{
	public final String nom;
	public final int num;
	
	public Id(String nom,int num)
	{
		this.nom = nom;
		this.num = num;
	}
	
	public String toString()
	{
		return nom;
	}
}
public class EnrgExemp extends javax.swing.JFrame implements ActionListener{
    Bibliotheque mySQLConnect;
    /**
     * Creates new form EnrgExemp
     */
    public EnrgExemp() {
        initComponents();
        cbEmp.removeAllItems();
        cbOuvrage.removeAllItems();
        showemprunt();
        showemprunteur();
        showouvrage();
        
        btnV.addActionListener(this);
    }

    public void showemprunteur(){
        
        this.mySQLConnect = new Bibliotheque();
        String sql = "SELECT * FROM emprunteur";
        //final JComboBox<Id> cbEmpr = new JComboBox<Id>();
        //DefaultComboBoxModel model = new DefaultComboBoxModel();
        //Vector model = new Vector();
        try{
            PreparedStatement stmt = mySQLConnect.connect().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                //Pour affecter une valeur de base de données à un Combobox 
                //String Nprenom = rs.getString("nom")+" "+ rs.getString("prenom");
                //int id = rs.getInt("CodeBarre");
                //cbEmp.addItem(new Id(Nprenom, id));
                //cbEmp.addItem(new Id(rs.getString("nom")+" "+ rs.getString("prenom"), rs.getInt("CodeBarre")));
                //model.insertElementAt(rs.getString("nom")+" "+ rs.getString("prenom"), rs.getInt("CodeBarre"));
                //cbEmp.addItem(rs.getString("nom")+" "+ rs.getString("prenom"));
                //cbEmp.insertItemAt(rs.getString("nom")+" "+ rs.getString("prenom"), rs.getInt("CodeBarre"));
                //cbEmp = new JComboBox(model);
                //cbEmp.addItem(new cb(rs.));
                //cbEmp.setSelectedIndex(rs.getInt("CodeBarre"));
                cbEmp.addItem(rs.getString("CodeBarre"));
            }
            //cbEmp = new JComboBox(model);
        }catch(SQLException a){
            a.printStackTrace();
        }finally{
            mySQLConnect.disconnect();
        }  
    }
    
    
    public void showemprunt(){        
        this.mySQLConnect = new Bibliotheque();
        String sql = "SELECT * FROM emprunt";
        //Object data[][] = new String[8][4];
        try{
            PreparedStatement stmt = mySQLConnect.connect().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            tab.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(SQLException a){
            a.printStackTrace();
        }finally{
            mySQLConnect.disconnect();
        }  
    }
    
    public void showouvrage(){        
        this.mySQLConnect = new Bibliotheque();
        String sql = "SELECT * FROM ouvrage";
        try{
            PreparedStatement stmt = mySQLConnect.connect().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()){
                
                //Pour affecter une valeur de base de données à un Combobox 
                cbOuvrage.addItem(rs.getString("CodeBarre"));
                //cbOuvrage.addItem(rs.getString("titre")+" par "+ rs.getString("auteur"));
                //cbOuvrage.insertItemAt(rs.getString("titre")+" "+ rs.getString("auteur"), rs.getInt("CodeBarre"));
                //cbOuvrage.setSelectedIndex(rs.getInt("CodeBarre"));
            }
        }catch(SQLException a){
            a.printStackTrace();
        }finally{
            mySQLConnect.disconnect();
        }  
    }
    
    public void verif(){
        this.mySQLConnect = new Bibliotheque();
        String sql = "SELECT COUNT(*) AS nb FROM emprunt WHERE CodeBarreEmprunteur = '" + cbEmp.getSelectedItem().toString() +"'";
        try{
            PreparedStatement stmt = mySQLConnect.connect().prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
            //System.out.println(sql);
            //int r = rs.getInt(1);
            //System.out.println(r);
            //verifier si l'emprunteur a plus de 3 exemplaire
            rs.next();
            if (rs.getInt("nb") < 3){
                System.out.println(txtdateEmp.getText());
                //String pattern = "yyyy-MM-dd";
                //SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
                //String dateR = simpleDateFormat.format(new Date());
                //System.out.println(dateR);
                DateFormat format = new SimpleDateFormat("MM/DD/YYYY");
                java.util.Date date = new DateTime( DateTimeZone.forID( "America/Denver" ) ).plusWeeks( 3 ).withTimeAtStartOfDay().toDate();
                System.out.println("Date emprunt après 3 semaines "+ date);
                
                String sql2 ="INSERT INTO emprunteur (CodeBarreExemplaire, CodeBarreEmprunteur, DateRetourMax, DateRetour)"
                + "VALUES ('" + cbOuvrage.getSelectedItem() + "', '" + cbEmp.getSelectedItem() + "','" + txtdateEmp.getText() + "','" + txtdateEmp.getText() + "')";
                try{
                    PreparedStatement stmt2 = mySQLConnect.connect().prepareStatement(sql);
                    stmt2.executeUpdate();
                }catch(SQLException a){
                    a.printStackTrace();
                    showMessageDialog(this, "Erreur dans la saisie des informations", "Erreur de saisie", WARNING_MESSAGE);
                }finally{
                    mySQLConnect.disconnect();
                    showMessageDialog(this, "Emprunteur enregistrer.", "Validation", INFORMATION_MESSAGE);
                    showouvrage();
                }
            }
        }catch(SQLException a){
            a.printStackTrace();
        }finally{
            mySQLConnect.disconnect();
        }
    }
    
    public void actionPerformed(ActionEvent e){
        if (e.getSource() == btnV){
            verif();
                System.out.println(cbEmp.getSelectedItem().toString());
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnV = new javax.swing.JButton();
        cbEmp = new javax.swing.JComboBox<>();
        cbOuvrage = new javax.swing.JComboBox<>();
        txtdateEmp = new javax.swing.JFormattedTextField();
        btnA = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tab = new javax.swing.JTable();
        lblidEmp = new javax.swing.JLabel();
        lblidOuvrage = new javax.swing.JLabel();
        ldlDateR = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnV.setText("Valider");
        btnV.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVActionPerformed(evt);
            }
        });

        cbEmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbOuvrage.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnA.setText("Annuler");

        tab.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(tab);

        lblidEmp.setText("Emprunteur");

        lblidOuvrage.setText("Ouvrage");

        ldlDateR.setText("Date d'emprunt");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblidEmp)
                .addGap(18, 18, 18)
                .addComponent(cbEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnV)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 398, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(btnA)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(ldlDateR)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(131, 131, 131)
                                        .addComponent(lblidOuvrage)
                                        .addGap(18, 18, 18)
                                        .addComponent(cbOuvrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtdateEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)))))))
                .addGap(0, 62, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbOuvrage, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblidEmp)
                            .addComponent(lblidOuvrage))
                        .addGap(46, 46, 46))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ldlDateR)
                        .addComponent(txtdateEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnV)
                    .addComponent(btnA))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVActionPerformed

          if(evt.getSource()== btnV) {
            
      String dateEmp = txtdateEmp.getText();
      
 
    
    this.mySQLConnect = new Bibliotheque();
                
       
        
   String sql = "INSERT INTO emprunt (DateRetour) values ('"
                    + dateEmp+"')";
        
        
        try{
                PreparedStatement stmt = mySQLConnect.connect().prepareStatement(sql);
                stmt.executeUpdate();
        } catch(SQLException a){
              a.printStackTrace();
                         showMessageDialog(this, "Livre ajouter", "Validation", INFORMATION_MESSAGE);
            
            
        } finally{
            mySQLConnect.disconnect();
        
          //showMessageDialog(this,"Erreur dans la saisie des informations","Erreur de saisie", WARNING_MESSAGE);

        }
        }
    

// TODO add your handling code here:
    }//GEN-LAST:event_btnVActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EnrgExemp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EnrgExemp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EnrgExemp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EnrgExemp.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EnrgExemp().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnA;
    private javax.swing.JButton btnV;
    private javax.swing.JComboBox<String> cbEmp;
    private javax.swing.JComboBox<String> cbOuvrage;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblidEmp;
    private javax.swing.JLabel lblidOuvrage;
    private javax.swing.JLabel ldlDateR;
    private javax.swing.JTable tab;
    private javax.swing.JFormattedTextField txtdateEmp;
    // End of variables declaration//GEN-END:variables
}
