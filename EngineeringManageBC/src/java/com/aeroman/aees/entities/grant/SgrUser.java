/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aeroman.aees.entities.grant;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Cacheable;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author saplic
 */
@Entity
@Cacheable(false)
@Table(name = "SGR_USER", catalog = "", schema = "PROCESOS")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "SgrUser.findAll", query = "SELECT s FROM SgrUser s"),
    @NamedQuery(name = "SgrUser.findByUserId", query = "SELECT s FROM SgrUser s WHERE s.userId = :userId"),
    @NamedQuery(name = "SgrUser.findByStatus", query = "SELECT s FROM SgrUser s WHERE s.status = :status"),
    @NamedQuery(name = "SgrUser.findByEmail", query = "SELECT s FROM SgrUser s WHERE s.email = :email"),
    @NamedQuery(name = "SgrUser.findByCostCenter", query = "SELECT s FROM SgrUser s WHERE s.costCenter = :costCenter"),
    @NamedQuery(name = "SgrUser.findByFullUserName", query = "SELECT s FROM SgrUser s WHERE s.fullUserName = :fullUserName"),
    @NamedQuery(name = "SgrUser.findByPuesto", query = "SELECT s FROM SgrUser s WHERE s.puesto = :puesto"),
    @NamedQuery(name = "SgrUser.findByGerencia", query = "SELECT s FROM SgrUser s WHERE s.gerencia = :gerencia"),
    @NamedQuery(name = "SgrUser.findByDireccion", query = "SELECT s FROM SgrUser s WHERE s.direccion = :direccion"),
    @NamedQuery(name = "SgrUser.findByIddir", query = "SELECT s FROM SgrUser s WHERE s.iddir = :iddir"),
    @NamedQuery(name = "SgrUser.findByPrimerNombre", query = "SELECT s FROM SgrUser s WHERE s.primerNombre = :primerNombre"),
    @NamedQuery(name = "SgrUser.findBySegundoNombre", query = "SELECT s FROM SgrUser s WHERE s.segundoNombre = :segundoNombre"),
    @NamedQuery(name = "SgrUser.findByPrimerApellido", query = "SELECT s FROM SgrUser s WHERE s.primerApellido = :primerApellido"),
    @NamedQuery(name = "SgrUser.findBySegundoApellido", query = "SELECT s FROM SgrUser s WHERE s.segundoApellido = :segundoApellido"),
    @NamedQuery(name = "SgrUser.findByNombreContable", query = "SELECT s FROM SgrUser s WHERE s.nombreContable = :nombreContable"),
    @NamedQuery(name = "SgrUser.findByCodigoMeta4", query = "SELECT s FROM SgrUser s WHERE s.codigoMeta4 = :codigoMeta4"),
    @NamedQuery(name = "SgrUser.findByCodigo86", query = "SELECT s FROM SgrUser s WHERE s.codigo86 = :codigo86"),
    @NamedQuery(name = "SgrUser.findByPrimerIngreso", query = "SELECT s FROM SgrUser s WHERE s.primerIngreso = :primerIngreso"),
    @NamedQuery(name = "SgrUser.findByUserType", query = "SELECT s FROM SgrUser s WHERE s.userType = :userType"),
    @NamedQuery(name = "SgrUser.findByAttribute1", query = "SELECT s FROM SgrUser s WHERE s.attribute1 = :attribute1"),
    @NamedQuery(name = "SgrUser.findByAttribute2", query = "SELECT s FROM SgrUser s WHERE s.attribute2 = :attribute2"),
    @NamedQuery(name = "SgrUser.findByCiaDefault", query = "SELECT s FROM SgrUser s WHERE s.ciaDefault = :ciaDefault"),
    @NamedQuery(name = "SgrUser.findByEstDefault", query = "SELECT s FROM SgrUser s WHERE s.estDefault = :estDefault")})
public class SgrUser implements Serializable {
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sgrUser")
    private List<SgrUserRole> sgrUserRoleList;
    private static final long serialVersionUID = 1L;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "USER_ID")
    private BigDecimal userId;
    @Size(max = 3)
    @Column(name = "STATUS")
    private String status;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Size(max = 100)
    @Column(name = "EMAIL")
    private String email;
    @Size(max = 5)
    @Column(name = "COST_CENTER")
    private String costCenter;
    @Size(max = 255)
    @Column(name = "FULL_USER_NAME")
    private String fullUserName;
    @Size(max = 255)
    @Column(name = "PUESTO")
    private String puesto;
    @Size(max = 255)
    @Column(name = "GERENCIA")
    private String gerencia;
    @Size(max = 255)
    @Column(name = "DIRECCION")
    private String direccion;
    @Column(name = "IDDIR")
    private Long iddir;
    @Size(max = 255)
    @Column(name = "PRIMER_NOMBRE")
    private String primerNombre;
    @Size(max = 255)
    @Column(name = "SEGUNDO_NOMBRE")
    private String segundoNombre;
    @Size(max = 255)
    @Column(name = "PRIMER_APELLIDO")
    private String primerApellido;
    @Size(max = 255)
    @Column(name = "SEGUNDO_APELLIDO")
    private String segundoApellido;
    @Size(max = 255)
    @Column(name = "NOMBRE_CONTABLE")
    private String nombreContable;
    @Size(max = 50)
    @Column(name = "CODIGO_META4")
    private String codigoMeta4;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "CODIGO86")
    private String codigo86;
    @Basic(optional = false)
    @NotNull
    @Column(name = "PRIMER_INGRESO")
    private Character primerIngreso;
    @Size(max = 2)
    @Column(name = "USER_TYPE")
    private String userType;
    @Size(max = 20)
    @Column(name = "ATTRIBUTE1")
    private String attribute1;
    @Size(max = 20)
    @Column(name = "ATTRIBUTE2")
    private String attribute2;
    @Size(max = 4)
    @Column(name = "CIA_DEFAULT")
    private String ciaDefault;
    @Size(max = 4)
    @Column(name = "EST_DEFAULT")
    private String estDefault;
    @ManyToMany(mappedBy = "sgrUserList")
    private List<SgrPeopleType> sgrPeopleTypeList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userIdOwner")
    private List<SgrSistema> sgrSistemaList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "userCreaMod")
    private List<SgrUserPsw> sgrUserPswList;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "sgrUser")
    private SgrUserPsw sgrUserPsw;

    public SgrUser() {
        super();
    }

    public SgrUser(BigDecimal userId) {
        this.userId = userId;
    }

    public SgrUser(BigDecimal userId, String codigo86, Character primerIngreso) {
        this.userId = userId;
        this.codigo86 = codigo86;
        this.primerIngreso = primerIngreso;
    }

    public BigDecimal getUserId() {
        return userId;
    }

    public void setUserId(BigDecimal userId) {
        this.userId = userId;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCostCenter() {
        return costCenter;
    }

    public void setCostCenter(String costCenter) {
        this.costCenter = costCenter;
    }

    public String getFullUserName() {
        return fullUserName;
    }

    public void setFullUserName(String fullUserName) {
        this.fullUserName = fullUserName;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public String getGerencia() {
        return gerencia;
    }

    public void setGerencia(String gerencia) {
        this.gerencia = gerencia;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Long getIddir() {
        return iddir;
    }

    public void setIddir(Long iddir) {
        this.iddir = iddir;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }

    public String getNombreContable() {
        return nombreContable;
    }

    public void setNombreContable(String nombreContable) {
        this.nombreContable = nombreContable;
    }

    public String getCodigoMeta4() {
        return codigoMeta4;
    }

    public void setCodigoMeta4(String codigoMeta4) {
        this.codigoMeta4 = codigoMeta4;
    }

    public String getCodigo86() {
        return codigo86;
    }

    public void setCodigo86(String codigo86) {
        this.codigo86 = codigo86;
    }

    public Character getPrimerIngreso() {
        return primerIngreso;
    }

    public void setPrimerIngreso(Character primerIngreso) {
        this.primerIngreso = primerIngreso;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getAttribute1() {
        return attribute1;
    }

    public void setAttribute1(String attribute1) {
        this.attribute1 = attribute1;
    }

    public String getAttribute2() {
        return attribute2;
    }

    public void setAttribute2(String attribute2) {
        this.attribute2 = attribute2;
    }

    public String getCiaDefault() {
        return ciaDefault;
    }

    public void setCiaDefault(String ciaDefault) {
        this.ciaDefault = ciaDefault;
    }

    public String getEstDefault() {
        return estDefault;
    }

    public void setEstDefault(String estDefault) {
        this.estDefault = estDefault;
    }

    @XmlTransient
    public List<SgrPeopleType> getSgrPeopleTypeList() {
        return sgrPeopleTypeList;
    }

    public void setSgrPeopleTypeList(List<SgrPeopleType> sgrPeopleTypeList) {
        this.sgrPeopleTypeList = sgrPeopleTypeList;
    }

    @XmlTransient
    public List<SgrSistema> getSgrSistemaList() {
        return sgrSistemaList;
    }

    public void setSgrSistemaList(List<SgrSistema> sgrSistemaList) {
        this.sgrSistemaList = sgrSistemaList;
    }

    @XmlTransient
    public List<SgrUserPsw> getSgrUserPswList() {
        return sgrUserPswList;
    }

    public void setSgrUserPswList(List<SgrUserPsw> sgrUserPswList) {
        this.sgrUserPswList = sgrUserPswList;
    }

    public SgrUserPsw getSgrUserPsw() {
        return sgrUserPsw;
    }

    public void setSgrUserPsw(SgrUserPsw sgrUserPsw) {
        this.sgrUserPsw = sgrUserPsw;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (userId != null ? userId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        
        if (!(object instanceof SgrUser)) {
            return false;
        }
        SgrUser other = (SgrUser) object;
        if ((this.userId == null && other.userId != null) || (this.userId != null && !this.userId.equals(other.userId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.aeroman.aees.entities.SgrUser[ userId=" + userId + " ]";
    }

    @XmlTransient
    public List<SgrUserRole> getSgrUserRoleList() {
        return sgrUserRoleList;
    }

    public void setSgrUserRoleList(List<SgrUserRole> sgrUserRoleList) {
        this.sgrUserRoleList = sgrUserRoleList;
    }
    
}
