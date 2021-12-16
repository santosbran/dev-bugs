/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author ealvarado
 */
@Entity
@Cacheable(false)
@Table(name = "RPT_ESQUEMAS",catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "RptEsquemas.findAll", query = "SELECT r FROM RptEsquemas r")
    , @NamedQuery(name = "RptEsquemas.findByEsquema", query = "SELECT r FROM RptEsquemas r WHERE r.esquema = :esquema")
    , @NamedQuery(name = "RptEsquemas.findByServer", query = "SELECT r FROM RptEsquemas r WHERE r.server = :server")
    , @NamedQuery(name = "RptEsquemas.findByUsuario", query = "SELECT r FROM RptEsquemas r WHERE r.usuario = :usuario")
    , @NamedQuery(name = "RptEsquemas.findByClave", query = "SELECT r FROM RptEsquemas r WHERE r.clave = :clave")
    , @NamedQuery(name = "RptEsquemas.findByRuta", query = "SELECT r FROM RptEsquemas r WHERE r.ruta = :ruta")
    , @NamedQuery(name = "RptEsquemas.findByDatasource", query = "SELECT r FROM RptEsquemas r WHERE r.datasource = :datasource")
    , @NamedQuery(name = "RptEsquemas.findByRutaJasper", query = "SELECT r FROM RptEsquemas r WHERE r.rutaJasper = :rutaJasper")})
public class RptEsquemas implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "ESQUEMA")
    private String esquema;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "SERVER")
    private String server;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "USUARIO")
    private String usuario;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "CLAVE")
    private String clave;
    @Size(max = 255)
    @Column(name = "RUTA")
    private String ruta;
    @Size(max = 200)
    @Column(name = "DATASOURCE")
    private String datasource;
    @Size(max = 4000)
    @Column(name = "RUTA_JASPER")
    private String rutaJasper;

    public RptEsquemas() {
    }

    public RptEsquemas(String esquema) {
        this.esquema = esquema;
    }

    public RptEsquemas(String esquema, String server, String usuario, String clave) {
        this.esquema = esquema;
        this.server = server;
        this.usuario = usuario;
        this.clave = clave;
    }

    public String getEsquema() {
        return esquema;
    }

    public void setEsquema(String esquema) {
        this.esquema = esquema;
    }

    public String getServer() {
        return server;
    }

    public void setServer(String server) {
        this.server = server;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public String getDatasource() {
        return datasource;
    }

    public void setDatasource(String datasource) {
        this.datasource = datasource;
    }

    public String getRutaJasper() {
        return rutaJasper;
    }

    public void setRutaJasper(String rutaJasper) {
        this.rutaJasper = rutaJasper;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (esquema != null ? esquema.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof RptEsquemas)) {
            return false;
        }
        RptEsquemas other = (RptEsquemas) object;
        if ((this.esquema == null && other.esquema != null) || (this.esquema != null && !this.esquema.equals(other.esquema))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.proc.entities.RptEsquemas[ esquema=" + esquema + " ]";
    }
    
}
