/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

//import java.net.Authenticator;
//import com.restfb.types.Message;
import javax.mail.PasswordAuthentication;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.mail.Authenticator;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.mail.Message;

/**
 *
 * @author 21695
 */
public class Mail {
   public static void sendMail(String recepient)throws Exception {
   System.out.println("Preparing to send email");
   Properties properties = new Properties();
   
   
   properties.put("mail.smtp.auth","true");
   properties.put("mail.smtp.starttls.enable","true");
   properties.put("mail.smtp.port","587");
   
   String myAccountEmail="moncef.mansour@esprit.tn";
   String password ="Renzolovecs1.6!";
 
   Session session = Session.getInstance(properties, new Authenticator(){
       @Override
       protected PasswordAuthentication getPasswordAuthentication() {
           return new PasswordAuthentication(myAccountEmail, password) ;//To change body of generated methods, choose Tools | Templates.
       }
      
  
       });
   
       Message  message = prepareMessage(session,myAccountEmail, recepient);
// Transport.send(message);
   System.out.println("Message sent successfully");
       
   }

    private static Message prepareMessage(Session session,String myAccountEmail,String recepient) {
        
        try {
        MimeMessage message = new MimeMessage(session);
            message.setFrom(new InternetAddress(myAccountEmail));
            message.setRecipient(Message.RecipientType.TO,new InternetAddress(recepient));
            message.setSubject("My First Email From Java app");
            message.setText("Hey there, look my email!");
        } catch (Exception ex) {
            Logger.getLogger(Mail.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }
    
   
          
   
  
    
}
