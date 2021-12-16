/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.aeroman.aees.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.persistence.FetchType;

/**
 *
 * @author hjuarez
 */
@Entity
@Cacheable(false)
@Table(name = "ENG_PLANTILLAS_EA_COVER_PART")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "EngPlantillasEaCoverPart.findAll", query = "SELECT e FROM EngPlantillasEaCoverPart e"),
    @NamedQuery(name = "EngPlantillasEaCoverPart.findByIdDocu", query = "SELECT e FROM EngPlantillasEaCoverPart e WHERE e.idDocu = :idDocu"),
    @NamedQuery(name = "EngPlantillasEaCoverPart.findByNameDocu", query = "SELECT e FROM EngPlantillasEaCoverPart e WHERE e.nameDocu = :nameDocu"),
    @NamedQuery(name = "EngPlantillasEaCoverPart.findByExtenDocu", query = "SELECT e FROM EngPlantillasEaCoverPart e WHERE e.extenDocu = :extenDocu"),
    @NamedQuery(name = "EngPlantillasEaCoverPart.findByTipoDocu", query = "SELECT e FROM EngPlantillasEaCoverPart e WHERE e.tipoDocu = :tipoDocu"),
    @NamedQuery(name = "EngPlantillasEaCoverPart.findByEstadoDocu", query = "SELECT e FROM EngPlantillasEaCoverPart e WHERE e.estadoDocu = :estadoDocu"),
    @NamedQuery(name = "EngPlantillasEaCoverPart.findByUsuarioCreacion", query = "SELECT e FROM EngPlantillasEaCoverPart e WHERE e.usuarioCreacion = :usuarioCreacion"),
    @NamedQuery(name = "EngPlantillasEaCoverPart.findByFechaCreacion", query = "SELECT e FROM EngPlantillasEaCoverPart e WHERE e.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "EngPlantillasEaCoverPart.findByUsuarioModificacion", query = "SELECT e FROM EngPlantillasEaCoverPart e WHERE e.usuarioModificacion = :usuarioModificacion"),
    @NamedQuery(name = "EngPlantillasEaCoverPart.findByFechaModificacion", query = "SELECT e FROM EngPlantillasEaCoverPart e WHERE e.fechaModificacion = :fechaModificacion")})
public class EngPlantillasEaCoverPart implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "ID_DOCU")
    private Long idDocu;
    @Lob
    @Basic(fetch=FetchType.LAZY,optional=true)
    @Column(name = "BODY_DOCU")
    private byte[] bodyDocu;
    @Size(max = 200)
    @Column(name = "NAME_DOCU")
    private String nameDocu;
    @Size(max = 50)
    @Column(name = "EXTEN_DOCU")
    private String extenDocu;
    @Size(max = 3)
    @Column(name = "TIPO_DOCU")
    private String tipoDocu;
    @Size(max = 3)
    @Column(name = "ESTADO_DOCU")
    private String estadoDocu;
    @Size(max = 20)
    @Column(name = "USUARIO_CREACION")
    private String usuarioCreacion;
    @Column(name = "FECHA_CREACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaCreacion;
    @Size(max = 20)
    @Column(name = "USUARIO_MODIFICACION")
    private String usuarioModificacion;
    @Column(name = "FECHA_MODIFICACION")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    public EngPlantillasEaCoverPart() {
        super();
    }

    public EngPlantillasEaCoverPart(Long idDocu) {
        this.idDocu = idDocu;
    }

    public Long getIdDocu() {
        return idDocu;
    }

    public void setIdDocu(Long idDocu) {
        this.idDocu = idDocu;
    }

    public byte[] getBodyDocu() {
        return bodyDocu;
    }

    public void setBodyDocu(byte[] bodyDocu) {
        this.bodyDocu = bodyDocu;
    }
   
    public String getNameDocu() {
        return nameDocu;
    }

    public void setNameDocu(String nameDocu) {
        this.nameDocu = nameDocu;
    }

    public String getExtenDocu() {
        return extenDocu;
    }

    public void setExtenDocu(String extenDocu) {
        this.extenDocu = extenDocu;
    }

    public String getTipoDocu() {
        return tipoDocu;
    }

    public void setTipoDocu(String tipoDocu) {
        this.tipoDocu = tipoDocu;
    }

    public String getEstadoDocu() {
        return estadoDocu;
    }

    public void setEstadoDocu(String estadoDocu) {
        this.estadoDocu = estadoDocu;
    }

    public String getUsuarioCreacion() {
        return usuarioCreacion;
    }

    public void setUsuarioCreacion(String usuarioCreacion) {
        this.usuarioCreacion = usuarioCreacion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public String getUsuarioModificacion() {
        return usuarioModificacion;
    }

    public void setUsuarioModificacion(String usuarioModificacion) {
        this.usuarioModificacion = usuarioModificacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idDocu != null ? idDocu.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof EngPlantillasEaCoverPart)) {
            return false;
        }
        EngPlantillasEaCoverPart other = (EngPlantillasEaCoverPart) object;
        if ((this.idDocu == null && other.idDocu != null) || (this.idDocu != null && !this.idDocu.equals(other.idDocu))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.EngPlantillasEaCoverPart[ idDocu=" + idDocu + " ]";
    }
    
}
