/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.facades;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author saplic
 */
@Stateless
public class SgrUserFacade implements Serializable {
    @PersistenceContext
    private EntityManager em;
    private EntityManagerFactory emf = null;
    transient List<String>  email=new ArrayList();
    transient List<String> nameemail=new ArrayList();

    
    
     public SgrUserFacade(EntityManagerFactory emf) {
        this.emf = emf;
    }
    
    public SgrUserFacade(){
        emf = Persistence.createEntityManagerFactory("EngineeringManageBCPU");
    }
    

    public EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    public void setEntityManager(EntityManager em) {
           this.em = em;
       }
    
    public Object VerificaLoginBandera (String usuario){
        Object us=null;
        try {   
            Query query=em.createNativeQuery("select a.CODIGO86, b.STATUS from SGR_USER a Inner Join SGR_USER_PSW b on a.USER_ID = b.USER_ID where  a.CODIGO86='"+usuario+"' ");
            List results= query.getResultList();
            
            
            if(!results.isEmpty()) {              
                return (Object)results.get(0);
            }
        } catch (Exception e) {
            Logger.getLogger(SgrUserFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        finally{
                em.close();
        }
        return us;   
    }
     
     public Object VerificaLogin (String usuario,String password){
        String pass = password;
        Object us=null;
        try {
            pass=getHash(pass);            
            em = getEntityManager();            
            Query query=em.createNativeQuery("select a.CODIGO86,b.PWS,b.STATUS " +
            "from SGR_USER a " +
            "Inner Join SGR_USER_PSW b on a.USER_ID = b.USER_ID " +
            "where  a.CODIGO86='"+usuario+"' and upper(b.PWS)='"+pass+"'");  
            
            List results= query.getResultList();
            if(!results.isEmpty()) {
                return (Object)results.get(0);
            }
         
        } catch (Exception e) {
            Logger.getLogger(SgrUserFacade.class.getName()).log(Level.SEVERE, null, e);
        }
        finally{
                em.close();
        }
        return us;   
    }
    
    public String getHash(String in) throws NoSuchAlgorithmException  {
        MessageDigest digest = MessageDigest.getInstance("SHA");
        byte[] out = in.getBytes();
        digest.update(out);
        byte[] dig = digest.digest();
        return byteArrayToHexString(dig);
    }
        private static String byteArrayToHexString(byte[] in) {
        byte ch;
        int i = 0;
        if (in == null || in.length <= 0)
            return null;
        String[] pseudo = 
        { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "A", "B", "C", "D", 
          "E", "F" };

        StringBuilder out = new StringBuilder(in.length * 2);

        while (i < in.length) {
            ch = (byte)(in[i] & 0xF0); // Strip off high nibble
            ch = (byte)(ch >>> 4);
            // shift the bits down
            ch = (byte)(ch & 0x0F);
            // must do this is high order bit is on!
            out.append(pseudo[(int)ch]); // convert the nibble to a String Character
            ch = (byte)(in[i] & 0x0F); // Strip off low nibble
            out.append(pseudo[(int)ch]); // convert the nibble to a String Character
            i++;
        }
        String rslt = new String(out);
        return rslt;
    }

   
        public int insertFlagTracking(String messageID,String rol)throws SQLException {
            try{
            em = getEntityManager(); 
	    Query sql =em.createQuery("UPDATE EngRequest as e SET e.reqFlagTracking= ? WHERE  e.reqMessageid= ?"); 
            sql.setParameter(1, "-"+rol+"-");
            sql.setParameter(2, messageID);
	    int results=sql.executeUpdate();
           
	   return  results;
           
            }catch(Exception e){
                Logger.getLogger(SgrUserFacade.class.getName()).log(Level.SEVERE, null, e);
            }finally{
                em.close();
            }
        
       
        return 0;
	}  
        
        
        public void userEmail(){
            List<String> name;
            List<String> emails;
            
            try{
              em = getEntityManager(); 
              Query sql =em.createNativeQuery("SELECT EMAIL FROM PROCESOS.SGR_USER"); 
              emails= sql.getResultList();
              for(String eml: emails){
                  if (!email.contains("\""+eml+"\"")) {
                    email.add("\""+eml+"\"");   
                  }
                                   
              }              
            }catch(Exception e){
                Logger.getLogger(SgrUserFacade.class.getName()).log(Level.SEVERE, null, e);
            }
        }
        
    
        public int rolUser (){
        int num=0;
        int n=1;
        try {
            em = getEntityManager();
            Query query = em.createNativeQuery("select max(a.EAG_ID)+1 as id from eng_ea_general a");
            query.setMaxResults(n);
            String a=(String) query.getSingleResult().toString();         
            num=Integer.parseInt(a);
            return num; 
        }catch(Exception e){
            Logger.getLogger(SgrUserFacade.class.getName()).log(Level.SEVERE, null, e);
            
        }finally{
            em.close();
        }
        return  0 ;
          
    }
        
    /********************************************************************************************************************************************************  */    
        /* Va a insertar el archivo adjunto desde ea_pdf a msj_adjuntos*/
    public void copiaEApdfAMensajes(String messageid, String extension, String pdfid){    
        try {      
                          
            em = getEntityManager();
            String query ="INSERT INTO msj_adjuntos (MSG_CODIGO, MSG_COD_RESPONSE, MSG_ADJUNTO, MSG_EXTENSION, MSG_COD_ESR, MSG_NOMBRE_ARCHIVO) " +
                         "VALUES((SELECT NVL(MAX(MSG_CODIGO),0)+1 FROM msj_adjuntos)," +
                         "(select max(RES_ID)+1 from eng_req_responses), " +
                         "(SELECT pdf_file FROM eng_ea_pdf  where pdf_id="+pdfid+")," +
                         " '"+extension+"', "+messageid+", (SELECT trim(pdf_filename) || '.pdf'FROM eng_ea_pdf where pdf_id="+pdfid+"))";
            em.createNativeQuery(query).executeUpdate();
                    
        } catch(Exception e) {      
            Logger.getLogger(SgrUserFacade.class.getName()).log(Level.SEVERE, null, e);   
        }  
        finally{
           em.close();
        }
    }
    /* fin copiaEApdfAMensajes*/
          
        
        public List<String> getEmail() {
        return email;
    }

    public void setEmail(List<String> email) {
        this.email = email;
    }

    public List<String> getNameemail() {
        return nameemail;
    }

    public void setNameemail(List<String> nameemail) {
        this.nameemail = nameemail;
    }

}
