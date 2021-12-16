/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.TimeZone;
import javax.annotation.PostConstruct;

/**
 *
 * @author sbran
 */
@Named(value = "parametrosController")
@SessionScoped
public class engParametrosController implements Serializable {
    private String user;
    private String language;
    private String nameUser;

    public engParametrosController() {
        //code here
    }

    @PostConstruct
    public void init() {
        //code here
    }

    /**
     * @return the user
     */
    public String getUser() {
        if (user != null && !user.isEmpty()) {
            return user;
        }
        return "";
    }

    /**
     * @param user the user to set
     */
    public void setUser(String user) {
        if (user != null && !user.isEmpty()) {
            this.user = user;
        } else {
            this.user = "";
        }
    }

    /**
     * @return the language
     */
    public String getLanguage() {
        if (language != null && !language.isEmpty()) {
            return language.toLowerCase();
        }
        return "es";
    }

    /**
     * @param language the language to set
     */
    public void setLanguage(String language) {
        if (language != null && !language.isEmpty()) {
            this.language = language;
        } else {
            this.language = "es";
        }
    }

    /**
     * @return the nameUser
     */
    public String getNameUser() {
        if (nameUser != null && !nameUser.isEmpty()) {
            return nameUser;
        }
        return "";
    }

    /**
     * @param nameUser the nameUser to set
     */
    public void setNameUser(String nameUser) {
        if (nameUser != null && !nameUser.isEmpty()) {
            this.nameUser = nameUser;
        } else {
            this.nameUser = "";
        }
    }

    public String getRegExAlphanumDesc() {
        return "/[a-zA-Z0-9_\\s,.()-]/i";
    }

    public String getRegExAlphanumCode() {
        return "/[a-z0-9_\\s-]/i";
    }

    //Obtiene Select status Maintenance
    public List getStatusMaintenanceList() {
        ArrayList<ArrayList<String>> statusList = new ArrayList();
        statusList.add(new ArrayList<String>());
        statusList.get(0).add("A"); //VALUE
        statusList.get(0).add(JsfUtil.getIdiomaTexto(getLanguage(), "Active").toUpperCase()); //LABEL
        statusList.add(new ArrayList<String>());
        statusList.get(1).add("I"); //VALUE
        statusList.get(1).add(JsfUtil.getIdiomaTexto(getLanguage(), "Inactive").toUpperCase()); //LABEL

        return statusList;
    }

    //Obtiene string de status Maintenance
    public String getStatusMaintenanceStr(String text) {
        String strStatus;
        switch (text.toUpperCase()) {
            case "A":
                strStatus = JsfUtil.getIdiomaTexto(getLanguage(), "Active").toUpperCase();
                break;
            case "I":
                strStatus = JsfUtil.getIdiomaTexto(getLanguage(), "Inactive").toUpperCase();
                break;
            default:
                strStatus = JsfUtil.getIdiomaTexto(getLanguage(), "Unknown").toUpperCase();
        }

        return strStatus;
    }

    public String limpiarEspaciosInnecesarios(String text) {
        return text.trim().replaceAll("(\\s+)", " ");
    }

    public String getDatePattern() {
        return JsfUtil.getDatePattern();
    }

    public String getTimeStampPatternQa() {
        return JsfUtil.getTimeStampPatternQa();
    }
    
    //******** Time zone *****************//
    public TimeZone getTimeZone() {
        return JsfUtil.getTimeZone();
    }

    public String getDatePatternQa() {
        return JsfUtil.getDatePatternQa();
    }

    public Locale getLocale() {
        return JsfUtil.getLocale();
    }

    public String getDateStr(Date date, String formatDate) {
        return JsfUtil.getDateStr(date, formatDate);
    }
    
}
