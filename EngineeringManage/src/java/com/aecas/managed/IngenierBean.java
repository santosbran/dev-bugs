/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.aecas.managed;

import com.aees.session.SessionBean;
import com.aeroman.aees.entities.EngListView;
import com.aeroman.aees.entities.EngTaskListView;
import com.aeroman.aees.entities.EngTasksByUserSupVw;
import com.aeroman.aees.entities.grant.SgrCia;
import com.aeroman.aees.facades.EngListViewFacade;
import com.aeroman.aees.facades.EngTaskListViewFacade;
import com.aeroman.aees.facades.EngTasksByUserSupVwFacade;
import com.aeroman.aees.facades.Sequences;
import com.aeroman.aees.facades.grant.SgrCiaFacade;
import com.aeroman.aees.facades.grant.SgrUserFacades;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.bean.SessionScoped;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;

@ManagedBean(name = "ingenierBean")
@SessionScoped
public class IngenierBean extends CrudBean<EngTasksByUserSupVw> implements Serializable {

    @EJB
    private EngTasksByUserSupVwFacade coreUsersVwFacade;
    @EJB
    private EngListViewFacade enlisfacade;
    @EJB
    private Sequences seq;
    @EJB
    private EngTaskListViewFacade taskListFacade;
    @EJB
    private SgrCiaFacade companyFacade;
    @EJB
    private SgrUserFacades sgrUser;
    // prueba de varables para ejecutar Variables
    private String ingenieroP,empresaP;
    private Integer totalActs = 0;
    private boolean filtromex;
    private boolean filtroae;
    private String ski;
    private transient List<Object> userskil = new ArrayList<>();
    private String codInge;
    transient List<EngTaskListView> taskList = new ArrayList<>();
    transient List<EngTaskListView> taskList2 = new ArrayList<>();
    private String companyInge;
    private SgrCia sgrCia;
    private String users;
    private String companyUser;
    
    @ManagedProperty(value = "#{companyBean}")
    private CompanyBean companyBean;

    @PostConstruct
    @Override
    public void init() {
        elemento = new EngTasksByUserSupVw();
        cargarTodas();
    }

    public void cargarTodas() {
        extendtime();
        if (listado != null) {
            listado = new ArrayList<>();
        }
        
        FacesContext facesContext = FacesContext.getCurrentInstance();
        ExternalContext externalContext = facesContext.getExternalContext();
        
        userskil = seq.userskill();
        if(companyUser == null){
            
            Map params = externalContext.getRequestParameterMap();
            HttpSession session = SessionBean.getSession();
            if (users==null) {
                users = (String) params.get("user");
                if (users==null) {
                    users = (String) session.getAttribute("username");
                }
                
            }
        }
        companyUser = sgrUser.findSelectUser(users).getCiaDefault();
        if(companyUser!=null){
            sgrCia = companyFacade.find(companyUser);
            if(sgrCia.getCiaAcceso().intValue()==1){
                    taskList = taskListFacade.findAllTaskListView();
                    listado = coreUsersVwFacade.listadoEngTasksByUserSupVw();
             }else{
                taskList = taskListFacade.findCompa(sgrCia.getCiaCode());
                listado = coreUsersVwFacade.findCompa(sgrCia.getCiaCode());
            }
        }
        
        
    }

    public void filteruser(String skiluser) {
        extendtime();
        List<EngListView> userskil3 = enlisfacade.findAll();
        List<EngListView> userskil2 = new ArrayList<>();
        List<EngTasksByUserSupVw> user2 = new ArrayList<>();
        int z = 0;
        while (z < userskil3.size()) {
            EngListView inge = (EngListView) userskil3.get(z);
            if (inge.getSkill() != null && inge.getSkill().equals(skiluser)) {
                userskil2.add(inge);
            }
            z++;
        }
        for (EngListView element : userskil2) {
            EngTasksByUserSupVw temp = new EngTasksByUserSupVw();
            temp.setRowId(element.getRowId());
            temp.setUsercode(element.getCodigo86());
            temp.setUserName(element.getFullUserName());

            user2.add(temp);
        }
        listado2 = user2;
    }

    public void filtroIngeniero(String codInge, String company) {
        extendtime();
        setCodInge(codInge);
        setCompanyInge(company);

        listado = coreUsersVwFacade.findUserCompa(codInge,company);  //listado de esr por inge
        taskList = taskListFacade.findUserCompa(codInge, company);   //listado de esr por ESR
       
    }

    public void filtroIngenieroPorCia(String company) {
        extendtime();
        setCodInge(codInge);
        setCompanyInge(company);

        listado = coreUsersVwFacade.findCompa(company); //listado de esr por inge
        taskList = taskListFacade.findCompa(company);   //listado de esr por inge
    }

    public String getIngenieroP() {
        return ingenieroP;
    }

    public void setIngenieroP(String ingenieroP) {
        this.ingenieroP = ingenieroP;
    }

    public String getEmpresaP() {
        return empresaP;
    }

    public void setEmpresaP(String empresaP) {
        this.empresaP = empresaP;
    }

    
    
    public Integer getTotalActs() {
        return totalActs;
    }

    public void setTotalActs(Integer totalActs) {
        this.totalActs = totalActs;
    }

    public boolean isFiltromex() {
        return filtromex;
    }

    public void setFiltromex(boolean filtromex) {
        this.filtromex = filtromex;
    }

    public boolean isFiltroae() {
        return filtroae;
    }

    public void setFiltroae(boolean filtroae) {
        this.filtroae = filtroae;
    }

    public List getUserskil() {
        return userskil;
    }

    public void setUserskil(List userskil) {
        this.userskil = userskil;
    }

    public String getSki() {
        return ski;
    }

    public void setSki(String ski) {
        this.ski = ski;
    }

    public String getCodInge() {
        return codInge;
    }

    public void setCodInge(String codInge) {
        this.codInge = codInge;
    }

    public List<EngTaskListView> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<EngTaskListView> taskList) {
        this.taskList = taskList;
    }

    public String getCompanyInge() {
        return companyInge;
    }

    public void setCompanyInge(String companyInge) {
        this.companyInge = companyInge;
    }

    @Override
    EngTasksByUserSupVw nuevoElemento() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void limpiar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void agregar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void eliminar(EngTasksByUserSupVw elemento) {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    void actualizar() {
        throw new UnsupportedOperationException(); //To change body of generated methods, choose Tools | Templates.
    }

    public CompanyBean getCompanyBean() {
        return companyBean;
    }

    public void setCompanyBean(CompanyBean companyBean) {
        this.companyBean = companyBean;
    }

    public String getUsers() {
        return users;
    }

    public void setUsers(String users) {
        this.users = users;
    }

    public String getCompanyUser() {
        return companyUser;
    }

    public void setCompanyUser(String companyUser) {
        this.companyUser = companyUser;
    }
    
    

}
