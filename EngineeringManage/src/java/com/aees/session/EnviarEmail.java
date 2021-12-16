/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aees.session;

import com.aeroman.aees.entities.grant.PrcDetparam;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.activation.DataHandler;
import javax.activation.FileDataSource;
import javax.mail.Address;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.SendFailedException;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

/**
 *
 * @author saplic
 */
public class EnviarEmail {
    
    private String host = null;    
    String nombreArchivo = "";
    String directorioRemoto ="";
    List listaArchivos = new ArrayList();
    List listaRutas = new ArrayList();
    List tallies = new ArrayList();
    List correos = new ArrayList();
    List correoscc = new ArrayList(); 
    List correosError = new ArrayList();
    
    
    
    public void sendEmailHours(List<PrcDetparam> listParam, String workOrder, String cola) {

        try {
            // se obtiene el objeto Session. La configuración es para una cuenta de gmail.
            // se obtiene el objeto Session. La configuración es para
            Properties email = new Properties();
            email.load(EnviarEmail.class.getResourceAsStream("/com/aees/util/mail.properties"));

            host = email.getProperty("Correo.host");

            String titulo
                    = " Notificación Horas Ingeniería Exportadas hacia AECAS \n";
            String from = email.getProperty("Correo.envio"); //quien lo manda

            // Se compone la parte del texto
            String msgText = " Buen día, <br/>\n"
                    + " El reporte final aprobado de las horas de Ingeniería referente a la Orden de Trabajo: " + workOrder
                    + " del Avión con registro " + cola + ", ya se encuentra cargado en el sistema AECAS.<br/><br/>"
                    + " Este es un correo de notificación, favor no responder a este mensaje.<br/>"
                    + "__________________________________________________________________________________________________"
                    + "<br/>\n"
                    + "<br/>\n Good Day. <br/>\n"
                    + "\n The final report approved engineering hours concerning the Work Order: " + workOrder
                    + " the registration Airplane: " + cola + ", is already loaded into the system AECAS. <br/><br/>"
                    + "This is a notification email, please do not reply this message.";

            String[] bcco = new String[correos.size()];
            Iterator iteratorcc = correos.iterator();
            int contadorcc = 0;
            while (iteratorcc.hasNext()) {
                bcco[contadorcc] = (String) iteratorcc.next();
                contadorcc++;
            }

            String corTemp = "";
            StringBuilder sb = new StringBuilder();
            for (PrcDetparam cor : listParam) {
                sb.append(corTemp);
                sb.append(cor.getValor());
                sb.append(",");
            }
            corTemp = sb.toString();

            String[] de = corTemp.split(",");

            //envia correo
            sendEmailInit(titulo, from, de, null, bcco, msgText, null);

        } catch (Exception e) {
            Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, e);
        }
    }
    
    public Boolean val(Object val){
       Boolean isNotNull=true;
       Integer esp=0;
       String evaluar;
       if(val==null){
           isNotNull=false;
           return isNotNull;
       }
       evaluar=val.toString();
       if(evaluar.isEmpty()){
           isNotNull=false;
           return isNotNull;
       }     
        for (int i = 0; i < evaluar.length(); i++) {
            if(evaluar.charAt(i)==' '){
                esp++;
            }
        }
        if(evaluar.length()==esp){
            isNotNull=false;
            return isNotNull;
        }
       return isNotNull;
    }
    
     public Boolean valObject(Object[] valores){
        Boolean nNolo=true;
        Integer nuls=0;
        if(valores==null){
            nNolo=false;
            return nNolo;
        }
        for (int i = 0; i < valores.length; i++) {
            if(valores[i]==null){
                nuls++;
            }
        }
        if(nuls==valores.length)
            return false;
        return nNolo;
    }
     
     public void sendEmailInit(String titulo, String from, String[] to, String[] cco, String[] bcco, String msgText, String att) {
       Object[] atts = null;
       if (att != null)
               atts = new Object[] { att };
      
       
       sendEmailAtt(titulo, from, to, cco, bcco, msgText, atts);
    }
    public void sendEmailAtt(String titulo, String from, String[] to, String[] cco, String[] bcco, String msgText, Object[] att) {
       boolean debug = false;
       // create some properties and get the default Session
       Properties props = new Properties();
       props.put("mail.smtp.host", host);
       Session session = Session.getInstance(props, null);
       session.setDebug(debug);
    
       try {
               // create a message
               Message msg = new MimeMessage(session);
               msg.setFrom(new InternetAddress(from));
               
               InternetAddress[] addressTo = null;
               if (to != null){
                    addressTo = new InternetAddress[to.length];
               }
               
               InternetAddress[] addressCco = null;
               if (bcco != null){
                    addressCco = new InternetAddress[bcco.length];
               }
               
               InternetAddress[] addressBcco = null;
               if (bcco != null){
                   addressBcco = new InternetAddress[bcco.length];
               }
               //creamos la lista de envios
               
               if (to != null) {
                   for (int i = 0; i < to.length; i++) {
                       addressTo[i] = new InternetAddress(to[i]);
                   }
                   //seteamos a las personas que le llegaran los correos
                   msg.setRecipients(javax.mail.Message.RecipientType.TO, addressTo);
                    
               }
               
               if (cco != null) {
                    for (int i = 0; i < cco.length; i++) {
                        addressCco[i] = new InternetAddress(cco[i]);
                    }
                    
                    //seteamos a las personas que le llegara con copia oculta
                    msg.setRecipients(javax.mail.Message.RecipientType.CC, addressCco);
               }
               
               if (bcco != null) {
                    for (int i = 0; i < bcco.length; i++) {
                        addressBcco[i] = new InternetAddress(bcco[i]);
                    }
                    
                    //seteamos a las personas que le llegara con copia oculta
                    msg.setRecipients(javax.mail.Message.RecipientType.BCC, addressBcco);
               }
               
               //seteamos el tema del mensaje
               msg.setSubject(titulo);
               //seteamos la fecha
               msg.setSentDate(new Date());         
               MimeBodyPart mbp1 = new MimeBodyPart();              
               //agregamos el texto al cuerpo del mensaje
               MimeMultipart mpContent = new MimeMultipart("Texto");
               mbp1.setContent(msgText, "text/html");
               mpContent.addBodyPart(mbp1); 
               if (att != null && att.length > 0) {
                   for (int i = 0; i < att.length; i++) {
                       if (att[i] != null) {
                           MimeBodyPart mbp2 = new MimeBodyPart();
                           FileDataSource fds = new FileDataSource((String)att[i]);
                           mbp2.setDataHandler(new DataHandler(fds));
                           mbp2.setFileName(fds.getName());
                           mpContent.addBodyPart(mbp2);
                       }
                   }
               }                            
               //agregamos al mensaje el contenido
               msg.setContent(mpContent);           
               //enviamos el mensaje
               Transport.send(msg);
    
       } catch (MessagingException mex) {
               Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, mex);
               Exception ex = mex;
               do {
                   if (ex instanceof SendFailedException) {
                       SendFailedException sfex = (SendFailedException)ex;
                       Address[] invalid = sfex.getInvalidAddresses();
                       if (invalid != null) {
                               for (int i = 0; i < invalid.length; i++)
                                    Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, mex);
                           
                       }
                       Address[] validUnsent = sfex.getValidUnsentAddresses();
                       if (validUnsent != null) {
                               for (int i = 0; i < validUnsent.length; i++)
                                    Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, mex);
                       }
                       Address[] validSent = sfex.getValidSentAddresses();
                       if (validSent != null) {
                                for (int i = 0; i < validSent.length; i++)
                                    Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, mex);
                       }
                   }
                   if (ex instanceof MessagingException)
                       Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, mex);
                   else
                       ex = null;
               } while (ex != null);
       } catch (Exception e){
           Logger.getLogger(EnviarEmail.class.getName()).log(Level.SEVERE, null, e);
       }
    }
    public String getHost() {
       return host;
    }
    
    public void setHost(String host) {
       this.host = host;
    }
}
