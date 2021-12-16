package com.aeroman.aees.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

@Entity
@Table(name="TYPE_DOC")
@XmlRootElement
@NamedQueries({@javax.persistence.NamedQuery(name="TypeDoc.findAll", query="SELECT t FROM TypeDoc t"), @javax.persistence.NamedQuery(name="TypeDoc.findByTcTypeDoc", query="SELECT t FROM TypeDoc t WHERE t.tcTypeDoc = :tcTypeDoc"), @javax.persistence.NamedQuery(name="TypeDoc.findByTcMime", query="SELECT t FROM TypeDoc t WHERE t.tcMime = :tcMime")})
public class TypeDoc implements Serializable
{
  private static final long serialVersionUID = 1L;
  @Id
  @Basic(optional=false)
  @NotNull
  @Size(min=1, max=50)
  @Column(name="TC_TYPE_DOC")
  private String tcTypeDoc;
  @Size(max=250)
  @Column(name="TC_MIME")
  private String tcMime;
  
  public TypeDoc() {}
  
  public TypeDoc(String tcTypeDoc)
  {
    this.tcTypeDoc = tcTypeDoc;
  }
  
  public String getTcTypeDoc() {
    return tcTypeDoc;
  }
  
  public void setTcTypeDoc(String tcTypeDoc) {
    this.tcTypeDoc = tcTypeDoc;
  }
  
  public String getTcMime() {
    return tcMime;
  }
  
  public void setTcMime(String tcMime) {
    this.tcMime = tcMime;
  }
  
  public int hashCode()
  {
    int hash = 0;
    hash += (tcTypeDoc != null ? tcTypeDoc.hashCode() : 0);
    return hash;
  }
  

  public boolean equals(Object object)
  {
    if (!(object instanceof TypeDoc)) {
      return false;
    }
    TypeDoc other = (TypeDoc)object;
    if (((tcTypeDoc == null) && (tcTypeDoc != null)) || ((tcTypeDoc != null) && (!tcTypeDoc.equals(tcTypeDoc)))) {
      return false;
    }
    return true;
  }
  
  public String toString()
  {
    return "com.aeroman.aees.entities.TypeDoc[ tcTypeDoc=" + tcTypeDoc + " ]";
  }
}