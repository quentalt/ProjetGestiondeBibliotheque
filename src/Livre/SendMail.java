/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Livre;
import java.awt.event.*;
import java.util.*;
import javax.mail.internet.*;
//import javax.activation.DataHandler;
import static javax.swing.JOptionPane.*;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.PasswordAuthentication;
import javax.mail.Message;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.MimeMessage;
import javax.mail.MessagingException;

/**
 *
 * @author Nicole
 */
public class SendMail extends javax.swing.JFrame implements ActionListener{

    /**
     * Creates new form SendMail
     */
    public SendMail() {
        initComponents();
        //cbStmp.removeAllItems();
        cbStmp.addItem("smtp.gmail.com");
        btnSend.addActionListener(this);
        this.dispose();
    }

        
    
    public void actionPerformed(ActionEvent e) {
        
        
        String ToEmail = txtA.getText();
final String FromEmail = txtDe.getText();
String User = txtuser.getText();
final String FromEmailPassword = ""; //mettre le mot de passe à l'intérieur;
String Subject = areaMsg.getText();

  Properties props = new Properties();
                props.put("mail.smtp.host", cbStmp.getSelectedItem());
                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "587");
                props.put("mail.smtp.socketFactory.port", "587");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
     
        
                Session session = Session.getDefaultInstance(props,new javax.mail.Authenticator() {
                    
                    protected PasswordAuthentication getPasswordAuthentification(){
                        
                        return new PasswordAuthentication(FromEmail,FromEmailPassword);
                        // dans les premières guillemets mettre adresse mail et la deuxième mettre un mot de passe return new PasswordAuthentication("","");
                    }
                    
                    
                });  
                
                try{
                    MimeMessage message = new MimeMessage(session);
                    
                    message.setFrom(new InternetAddress(FromEmail));
                    
                    // insérer dans les guillemets l'adresse mail  message.setFrom(new InternetAddress(""));
                      
                    
                    
                    message.addRecipient(Message.RecipientType.TO,new InternetAddress(ToEmail));
             
                    message.setRecipients(Message.RecipientType.TO,InternetAddress.parse("quentin.altieri@gmail.com"));
              
                    message.setSubject(Subject);
                    
                    message.setText(areaMsg.getText());
                    
                    Transport.send(message);
                    
                    System.out.println("Fait");
                                        
                } catch(MessagingException ex){
                    
                    System.out.println(""+ex);
                }
               
        
        
       /* String mdp = new String(pswd.getPassword());
        if (e.getSource() == btnSend){
            if("".equals(txtA.getText()) & "".equals(txtDe.getText()) && "".equals(txtObj.getText()) && "".equals(txtuser.getText()) && "".equals(mdp)){
                showMessageDialog(this, "Veuillez remplir tous les champs", "Erreur", WARNING_MESSAGE);
                SwingUtilities.updateComponentTreeUI(this);
            }else{
                Properties props = new Properties();
                props.put("mail.smtp.host", cbStmp.getSelectedItem());
                props.put("mail.transport.protocol", "smtp");
                props.put("mail.smtp.starttls.enable", "true");
                props.put("mail.smtp.auth", "true");
                props.put("mail.smtp.port", "465");
                props.put("mail.smtp.socketFactory.port", "465");
                props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");


                
                try {
                    InternetAddress fromAddress = new InternetAddress(txtDe.getText());
                    InternetAddress toAddress = new InternetAddress(txtA.getText());

                    Message message = new MimeMessage(session);
                    message.setFrom(fromAddress);
                    message.setRecipient(Message.RecipientType.TO, toAddress);
                    message.setSubject(txtObj.getText());
                    message.setText(areaMsg.getText());

                    Transport.send(message, txtuser.getText(),new String(pswd.getPassword()));
                    System.out.println("envoie réussi");
                } catch (MessagingException ex) {
                    ex.printStackTrace();
                }
      
        }
 
        }*/
    }
    
    
    
    
    
    
    
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDe = new javax.swing.JLabel();
        lblA = new javax.swing.JLabel();
        lblObj = new javax.swing.JLabel();
        lblstmp = new javax.swing.JLabel();
        lbluser = new javax.swing.JLabel();
        lblpswd = new javax.swing.JLabel();
        lblmsg = new javax.swing.JLabel();
        txtDe = new javax.swing.JTextField();
        txtA = new javax.swing.JTextField();
        txtObj = new javax.swing.JTextField();
        cbStmp = new javax.swing.JComboBox<>();
        txtuser = new javax.swing.JTextField();
        pswd = new javax.swing.JPasswordField();
        jScrollPane1 = new javax.swing.JScrollPane();
        areaMsg = new javax.swing.JTextArea();
        btnSend = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblDe.setText("De");

        lblA.setText("A");

        lblObj.setText("Objet");

        lblstmp.setText("STMP Server");

        lbluser.setText("Utilisateur");

        lblpswd.setText("Mot de Passe");

        lblmsg.setText("Message");

        txtA.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtAActionPerformed(evt);
            }
        });

        txtObj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtObjActionPerformed(evt);
            }
        });

        cbStmp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        pswd.setText("jPasswordField1");

        areaMsg.setColumns(20);
        areaMsg.setRows(5);
        jScrollPane1.setViewportView(areaMsg);

        btnSend.setText("Envoyer");
        btnSend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSendActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblDe)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 117, Short.MAX_VALUE)
                        .addComponent(txtDe, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblA)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblstmp)
                            .addComponent(lbluser)
                            .addComponent(lblpswd)
                            .addComponent(lblmsg)
                            .addComponent(lblObj))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txtObj, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(cbStmp, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtuser, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(pswd)))
                    .addComponent(btnSend, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDe)
                    .addComponent(txtDe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblA)
                    .addComponent(txtA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblObj)
                    .addComponent(txtObj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblstmp)
                    .addComponent(cbStmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbluser)
                    .addComponent(txtuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblpswd)
                    .addComponent(pswd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(lblmsg)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnSend))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtAActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtAActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtAActionPerformed

    private void txtObjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtObjActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObjActionPerformed

    private void btnSendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSendActionPerformed


      // TODO add your handling code here:
    }//GEN-LAST:event_btnSendActionPerformed

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
            java.util.logging.Logger.getLogger(SendMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(SendMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(SendMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(SendMail.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new SendMail().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextArea areaMsg;
    private javax.swing.JButton btnSend;
    private javax.swing.JComboBox<String> cbStmp;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblA;
    private javax.swing.JLabel lblDe;
    private javax.swing.JLabel lblObj;
    private javax.swing.JLabel lblmsg;
    private javax.swing.JLabel lblpswd;
    private javax.swing.JLabel lblstmp;
    private javax.swing.JLabel lbluser;
    private javax.swing.JPasswordField pswd;
    private javax.swing.JTextField txtA;
    private javax.swing.JTextField txtDe;
    private javax.swing.JTextField txtObj;
    private javax.swing.JTextField txtuser;
    // End of variables declaration//GEN-END:variables
}
